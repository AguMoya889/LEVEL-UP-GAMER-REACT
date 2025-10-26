import { createContext, useContext, useEffect, useMemo, useState } from 'react';
import { useAuth } from './AuthContext.jsx';

const CartContext = createContext(null);

const CART_KEY = 'carrito';
const PURCHASES_KEY = 'historialCompras';

const loadCart = () => {
  try {
    const raw = localStorage.getItem(CART_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch (error) {
    console.error('No se pudo cargar el carrito', error);
    return [];
  }
};

const loadPurchases = () => {
  try {
    const raw = localStorage.getItem(PURCHASES_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch (error) {
    console.error('No se pudo leer el historial de compras', error);
    return [];
  }
};

export const CartProvider = ({ children }) => {
  const { user } = useAuth();
  const [items, setItems] = useState(() => loadCart());

  useEffect(() => {
    localStorage.setItem(CART_KEY, JSON.stringify(items));
  }, [items]);

  const itemCount = useMemo(
    () => items.reduce((sum, item) => sum + item.cantidad, 0),
    [items]
  );

  const subtotal = useMemo(
    () => items.reduce((sum, item) => sum + item.precio * item.cantidad, 0),
    [items]
  );

  const discountPercentage = useMemo(() => {
    if (user?.descuento) {
      return user.descuento;
    }
    const correoGuardado = localStorage.getItem('correoUsuario') ?? '';
    if (
      correoGuardado.endsWith('@duocuc.cl') ||
      correoGuardado.endsWith('@profesor.duoc.cl')
    ) {
      return 20;
    }
    return 0;
  }, [user]);

  const discountAmount = useMemo(
    () => (subtotal * discountPercentage) / 100,
    [subtotal, discountPercentage]
  );

  const total = useMemo(
    () => subtotal - discountAmount,
    [subtotal, discountAmount]
  );

  const addItem = (product, quantity = 1) => {
    setItems((current) => {
      const existing = current.find((item) => item.slug === product.slug);
      if (existing) {
        return current.map((item) =>
          item.slug === product.slug
            ? { ...item, cantidad: item.cantidad + quantity }
            : item
        );
      }
      return [
        ...current,
        {
          slug: product.slug,
          nombre: product.nombre,
          precio: product.precio,
          cantidad: quantity
        }
      ];
    });
  };

  const updateQuantity = (slug, quantity) => {
    const safeQuantity = Math.max(1, quantity);
    setItems((current) =>
      current.map((item) =>
        item.slug === slug ? { ...item, cantidad: safeQuantity } : item
      )
    );
  };

  const removeItem = (slug) => {
    setItems((current) => current.filter((item) => item.slug !== slug));
  };

  const clearCart = () => {
    setItems([]);
  };

  const checkout = () => {
    if (items.length === 0) {
      return { ok: false, message: 'Tu carrito está vacío' };
    }

    const purchases = loadPurchases();
    const nuevaCompra = {
      usuario: user?.correo ?? 'invitado',
      fecha: new Date().toLocaleString('es-CL'),
      total: total,
      productos: items.map((item) => ({ ...item })),
      descuentoAplicado: discountAmount
    };

    const updated = [...purchases, nuevaCompra];
    localStorage.setItem(PURCHASES_KEY, JSON.stringify(updated));
    clearCart();
    return { ok: true };
  };

  const value = useMemo(
    () => ({
      items,
      itemCount,
      subtotal,
      discountPercentage,
      discountAmount,
      total,
      addItem,
      updateQuantity,
      removeItem,
      clearCart,
      checkout
    }),
    [
      items,
      itemCount,
      subtotal,
      discountPercentage,
      discountAmount,
      total
    ]
  );

  return <CartContext.Provider value={value}>{children}</CartContext.Provider>;
};

export const useCart = () => {
  const context = useContext(CartContext);
  if (!context) {
    throw new Error('useCart debe ser utilizado dentro de CartProvider');
  }
  return context;
};
