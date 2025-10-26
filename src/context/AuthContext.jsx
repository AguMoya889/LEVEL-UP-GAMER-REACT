import { createContext, useContext, useEffect, useMemo, useState } from 'react';

const AuthContext = createContext(null);

const ADMIN_CREDENTIALS = {
  email: 'admin@levelupgamer.com',
  password: 'admin123',
  name: 'Administrador'
};

const SESSION_KEY = 'usuarioActivo';
const USERS_KEY = 'usuarios';

const loadSession = () => {
  try {
    const raw = sessionStorage.getItem(SESSION_KEY);
    return raw ? JSON.parse(raw) : null;
  } catch (error) {
    console.error('No se pudo leer la sesión almacenada', error);
    return null;
  }
};

const loadUsers = () => {
  try {
    const raw = localStorage.getItem(USERS_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch (error) {
    console.error('No se pudieron cargar los usuarios', error);
    return [];
  }
};

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(() => loadSession());
  const [users, setUsers] = useState(() => loadUsers());

  useEffect(() => {
    sessionStorage.setItem(SESSION_KEY, JSON.stringify(user));
  }, [user]);

  useEffect(() => {
    localStorage.setItem(USERS_KEY, JSON.stringify(users));
  }, [users]);

  const login = ({ email, password }) => {
    const trimmedEmail = email.trim().toLowerCase();

    if (
      trimmedEmail === ADMIN_CREDENTIALS.email &&
      password === ADMIN_CREDENTIALS.password
    ) {
      const adminUser = {
        nombre: ADMIN_CREDENTIALS.name,
        correo: ADMIN_CREDENTIALS.email,
        esAdmin: true,
        descuento: 0
      };
      setUser(adminUser);
      return { ok: true, admin: true };
    }

    const match = users.find(
      (record) =>
        record.correo.toLowerCase() === trimmedEmail &&
        record.password === password
    );

    if (!match) {
      return { ok: false, message: 'Credenciales inválidas' };
    }

    const userSession = {
      nombre: match.nombre,
      correo: match.correo,
      descuento: match.descuento || 0,
      esAdmin: false
    };
    setUser(userSession);
    return { ok: true };
  };

  const logout = () => {
    setUser(null);
  };

  const register = (payload) => {
    const correo = payload.correo.trim().toLowerCase();
    const run = payload.run.trim();

    if (users.some((record) => record.correo.toLowerCase() === correo)) {
      return { ok: false, message: 'El correo ya está registrado' };
    }

    const descuento = correo.endsWith('@duocuc.cl') || correo.endsWith('@profesor.duoc.cl') ? 20 : 0;

    const newUser = {
      ...payload,
      correo,
      run,
      descuento
    };

    setUsers((current) => [...current, newUser]);
    const userSession = {
      nombre: newUser.nombre,
      correo: newUser.correo,
      descuento: newUser.descuento,
      esAdmin: false
    };
    setUser(userSession);
    localStorage.setItem('correoUsuario', correo);
    return { ok: true, descuento };
  };

  const value = useMemo(
    () => ({
      user,
      users,
      login,
      register,
      logout
    }),
    [user, users]
  );

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth debe ser usado dentro de AuthProvider');
  }
  return context;
};
