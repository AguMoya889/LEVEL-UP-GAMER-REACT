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

    const normalize = (t) => t?.toString().toLowerCase() || '';

    return products.filter((p) => {
      const productCat = normalize(p.category);
      const productName = normalize(p.name || p.title || p.slug);
      const catNorm = normalize(cat);

      // 🎮 Consolas → incluye consolas, controles, play, xbox, nintendo
      if (catNorm.includes('consol') && (
        productName.includes('consol') ||
        productName.includes('play') ||
        productName.includes('ps4') ||
        productName.includes('ps5') ||
        productName.includes('xbox') ||
        productName.includes('nintendo') ||
        productName.includes('switch') ||
        productName.includes('control') ||
        productName.includes('mando')
      )) return true;

      // 💻 Computadores
      if (catNorm.includes('comput') && (
        productName.includes('pc') ||
        productName.includes('computador') ||
        productName.includes('computadora') ||
        productName.includes('laptop') ||
        productName.includes('notebook') ||
        productName.includes('torre') ||
        productName.includes('setup')
      )) return true;

      // ⌨️ Periféricos → mouse, teclado, mousepad, audífonos, headset
      if (catNorm.includes('perifer') && (
        productName.includes('mouse') ||
        productName.includes('teclado') ||
        productName.includes('mousepad') ||
        productName.includes('pad') ||
        productName.includes('audif') ||
        productName.includes('audí') ||
        productName.includes('headset') ||
        productName.includes('auricular')
      )) return true;

      // 🖥️ Monitores
      if (catNorm.includes('monitor') && (
        productName.includes('monitor') ||
        productName.includes('pantalla')
      )) return true;

      // 🎲 Juegos de mesa → ahora incluye "Catan" y "Carcassonne"
      if (catNorm.includes('juegos de mesa') && (
        productName.includes('mesa') ||
        productName.includes('board') ||
        productName.includes('table') ||
        productName.includes('catan') ||
        productName.includes('carcass')
      )) return true;

      // 🪑 Sillas gamer
      if (catNorm.includes('silla') && (
        productName.includes('silla') ||
        productName.includes('gamer chair') ||
        productName.includes('chair')
      )) return true;

      // ✅ Fallback: si coincide exactamente con category
      return productCat === catNorm;
    });
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
