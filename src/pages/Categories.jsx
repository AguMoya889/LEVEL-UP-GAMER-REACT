import React from 'react';

const TOP_CATS = [
  { name: 'Categoría Consolas', img: '/img/categorias/cat1.jpg' },
  { name: 'Categoría Monitores', img: '/img/categorias/cat2.jng' },
  { name: 'Categoría Perifericos', img: '/img/categorias/cat3.jpg ' },
  { name: 'Categoría Juegos de mesa', img: '/img/categorias/cat4.jpg' },
];



// Ejemplos para la sección de “Categoría 1” (cámbialos por tus imágenes reales)
const CAT1_ITEMS = [
  { img: '/img/categorias/cat1_b.jpg', title: 'Categoría 1' },
  { img: '/img/categorias/cat1_b.jpg', title: 'Categoría 1' },
  { img: '/img/categorias/cat1_c.jpg', title: 'Categoría 1' },
  { img: '/img/categorias/cat1_d.jpg', title: 'Categoría 1' },
];

export default function Categories() {
  return (
    <>
      {/* Encabezado con breadcrumb simple (como en la figura) */}
      <section className="bg-secondary text-white py-4 mb-3">
        <div className="container">
          <nav className="small mb-2">
            <span className="opacity-75">Home</span> <span className="mx-1">/</span> <strong>Categorías</strong>
          </nav>
          <h1 className="h4 m-0">Categorías</h1>
        </div>
      </section>

      {/* Tira superior con 4 categorías pequeñas */}
      <div className="container mb-4">
        <div className="d-flex gap-3 flex-wrap">
          {TOP_CATS.map((c) => (
            <a
              key={c.name}
              href={`/productos?cat=${encodeURIComponent(c.name)}`}
              className="text-decoration-none text-center"
              style={{ width: 92 }}
              title={c.name}
            >
              <div className="card shadow-sm">
                {/* Cuadro chico con imagen */}
                <div className="ratio ratio-1x1 rounded-top">
                  <img
                    src={c.img}
                    alt={c.name}
                    className="img-fluid rounded-top"
                    style={{ objectFit: 'cover' }}
                  />
                </div>
                <div className="card-body p-2">
                  <div className="small text-dark text-truncate">{c.name}</div>
                </div>
              </div>
            </a>
          ))}
        </div>
      </div>

      {/* Sección inferior “Categoría 1” con 4 tarjetas grandes (400x300 aprox) */}
      <div className="container">
        <section className="mb-5">
          <h2 className="h6 mb-3">Categoría 1</h2>
          <div className="row g-3">
            {CAT1_ITEMS.map((it, i) => (
              <div key={i} className="col-12 col-sm-6 col-md-4 col-lg-3">
                <a
                  href={`/productos?cat=${encodeURIComponent('Categoría 1')}`}
                  className="text-decoration-none"
                  title="Ver Categoría 1"
                >
                  <div className="card h-100 shadow-sm">
                    {/* Imagen grande 4:3 (≈400x300) */}
                    <div className="ratio ratio-4x3 rounded-top">
                      <img
                        src={it.img}
                        alt={it.title}
                        className="img-fluid rounded-top"
                        style={{ objectFit: 'cover' }}
                      />
                    </div>
                    <div className="card-body">
                      <div className="text-dark small">{it.title}</div>
                    </div>
                  </div>
                </a>
              </div>
            ))}
          </div>
        </section>
      </div>
    </>
  );
}
