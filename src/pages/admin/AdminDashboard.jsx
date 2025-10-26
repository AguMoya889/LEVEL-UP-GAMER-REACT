import { useOutletContext } from 'react-router-dom';

const AdminDashboard = () => {
  const { stats } = useOutletContext();

  return (
    <div>
      <div className="row g-4">
        <div className="col-12 col-md-3">
          <div className="card bg-primary text-white text-center">
            <div className="card-body">
              <h5 className="card-title">👥 Usuarios</h5>
              <p className="card-text display-6">{stats.totalUsuarios}</p>
              <small>Usuarios registrados</small>
            </div>
          </div>
        </div>
        <div className="col-12 col-md-3">
          <div
            className="card text-white text-center"
            style={{ background: 'linear-gradient(45deg, #6e14ff, #148dff)' }}
          >
            <div className="card-body">
              <h5 className="card-title">📦 Productos</h5>
              <p className="card-text display-6">{stats.stockTotal / 10}</p>
              <small>En catálogo</small>
            </div>
          </div>
        </div>
        <div className="col-12 col-md-3">
          <div
            className="card text-white text-center"
            style={{ background: 'linear-gradient(45deg, #14ffec, #148dff)' }}
          >
            <div className="card-body">
              <h5 className="card-title">💰 Ventas</h5>
              <p className="card-text display-6">
                {stats.totalVentas.toLocaleString('es-CL', {
                  style: 'currency',
                  currency: 'CLP'
                })}
              </p>
              <small>Total vendido</small>
            </div>
          </div>
        </div>
        <div className="col-12 col-md-3">
          <div className="card bg-success text-white text-center">
            <div className="card-body">
              <h5 className="card-title">🛒 Carritos pendientes</h5>
              <p className="card-text display-6">{stats.carritosPendientes}</p>
              <small>Con productos activos</small>
            </div>
          </div>
        </div>
      </div>

      <div className="text-center mt-5">
        <h4 className="text-light">¡Panel administrativo en tiempo real!</h4>
        <p className="text-secondary">
          Los datos se actualizan automáticamente con las compras y registros.
        </p>
      </div>
    </div>
  );
};

export default AdminDashboard;
