import React, { useMemo } from 'react';
import { useLocation } from 'react-router-dom';
import ProductCard from '../components/ProductCard.jsx';
import { products } from '../data/products.js';

const Products = () => {
  const { search } = useLocation();

  const filtered = useMemo(() => {
    const params = new URLSearchParams(search);
    const cat = params.get('cat');
    if (!cat) return products;
    return products.filter(
      (p) => String(p.category || '').toLowerCase() === String(cat).toLowerCase()
    );
  }, [search]);

  return (
    <>
      <section className="py-5 text-center">
        <div className="container">
          <h1 className="fw-bold">Catálogo de Productos</h1>
          <p className="lead text-secondary">Artículos oficiales Level-Up Gamer</p>
        </div>
      </section>

      <section>
        <div className="container">
          <div className="row g-4">
            {filtered.length > 0 ? (
              filtered.map((product) => (
                <div className="col-12 col-md-6 col-lg-3" key={product.slug}>
                  <ProductCard product={product} />
                </div>
              ))
            ) : (
              <div className="col-12 text-center text-muted">
                No hay productos para esta categoría.
              </div>
            )}
          </div>
        </div>
      </section>
    </>
  );
};

export default Products;
