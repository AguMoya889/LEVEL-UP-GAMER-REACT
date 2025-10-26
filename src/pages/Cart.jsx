import { useCart } from '../context/CartContext.jsx';

const Cart = () => {
  const {
    items,
    subtotal,
    discountPercentage,
    discountAmount,
    total,
    itemCount,
    updateQuantity,
    removeItem,
    clearCart,
    checkout
  } = useCart();

  const handleCheckout = () => {
    const result = checkout();
    if (!result.ok) {
      window.alert(result.message);
      return;
    }
    window.alert('✅ Compra realizada con éxito. ¡Gracias por tu pedido!');
  };

  return (
    <section>
      <div className="container">
        <h1 className="text-center mb-4">🛒 Carrito de Compras</h1>

        {itemCount === 0 ? (
          <div className="text-center py-5">
            <p className="lead">Tu carrito está vacío.</p>
          </div>
        ) : (
          <>
            <div className="table-responsive">
              <table className="table table-dark table-hover align-middle">
                <thead>
                  <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                    <th>Subtotal</th>
                    <th />
                  </tr>
                </thead>
                <tbody>
                  {items.map((item) => (
                    <tr key={item.slug}>
                      <td>{item.nombre}</td>
                      <td>
                        {item.precio.toLocaleString('es-CL', {
                          style: 'currency',
                          currency: 'CLP'
                        })}
                      </td>
                      <td style={{ width: '120px' }}>
                        <input
                          type="number"
                          min={1}
                          className="form-control bg-dark text-light text-center"
                          value={item.cantidad}
                          onChange={(event) =>
                            updateQuantity(item.slug, Number(event.target.value) || 1)
                          }
                        />
                      </td>
                      <td>
                        {(item.precio * item.cantidad).toLocaleString('es-CL', {
                          style: 'currency',
                          currency: 'CLP'
                        })}
                      </td>
                      <td>
                        <button
                          className="btn btn-sm btn-danger"
                          type="button"
                          onClick={() => removeItem(item.slug)}
                        >
                          Eliminar
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>

            <div className="text-end mt-4">
              <p>
                Subtotal:{' '}
                <strong>
                  {subtotal.toLocaleString('es-CL', {
                    style: 'currency',
                    currency: 'CLP'
                  })}
                </strong>
              </p>
              {discountPercentage > 0 && (
                <p className="text-success">
                  Descuento {discountPercentage}% aplicado:{' '}
                  <strong>
                    -
                    {discountAmount.toLocaleString('es-CL', {
                      style: 'currency',
                      currency: 'CLP'
                    })}
                  </strong>
                </p>
              )}
              <h3>
                Total:{' '}
                <span>
                  {total.toLocaleString('es-CL', {
                    style: 'currency',
                    currency: 'CLP'
                  })}
                </span>
              </h3>
              <div className="d-flex gap-3 justify-content-end mt-3 flex-wrap">
                <button className="btn btn-secondary" type="button" onClick={clearCart}>
                  Vaciar carrito
                </button>
                <button className="btn btn-primary" type="button" onClick={handleCheckout}>
                  Pagar
                </button>
              </div>
            </div>
          </>
        )}
      </div>
    </section>
  );
};

export default Cart;
