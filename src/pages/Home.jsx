import { Link } from 'react-router-dom';
import ProductCard from '../components/ProductCard.jsx';
import { featuredProducts } from '../data/products.js';

const Home = () => (
  <>
    <section className="hero-section">
      <div className="container">
        <h1 className="fw-bold">Tienda Online</h1>
        <p className="hero-subtitle">
          ¡Explora lo último en tecnología y accesorios gamers en Chile!
        </p>
        <div className="hero-actions">
          <Link className="btn btn-primary btn-lg" to="/productos">
            Ver productos
          </Link>
          <Link className="btn btn-outline-light btn-lg" to="/blogs">
            Leer novedades
          </Link>
        </div>
        <img
          src="/img/ps5-5.png.jpg"
          alt="PlayStation 5"
          className="hero-image mt-4"
        />
      </div>
    </section>

    <section>
      <div className="container">
        <h2 className="section-title">Productos Destacados</h2>
        <div className="row g-4">
          {featuredProducts.map((product) => (
            <div className="col-12 col-md-6 col-lg-3" key={product.slug}>
              <ProductCard product={product} />
            </div>
          ))}
        </div>
      </div>
    </section>

    <section>
      <div className="container">
        <div className="card card-gradient p-4 p-md-5">
          <h3>Beneficios Level-Up</h3>
          <ul className="list-checkmark">
            <li>Despachos a todo Chile dentro de 72 horas hábiles</li>
            <li>Garantía oficial en todos los productos</li>
            <li>Descuento automático 20% para correos Duoc y profesor Duoc</li>
            <li>Puntos Level-Up por cada compra completada</li>
          </ul>
        </div>
      </div>
    </section>

    <section className="cta">
      <div className="container">
        <h2>¿Listo para subir de nivel?</h2>
        <p className="mb-4">
          Únete a la comunidad Level-Up Gamer y disfruta beneficios exclusivos,
          lanzamientos anticipados y soporte especializado.
        </p>
        <div className="hero-actions">
          <Link className="btn btn-primary" to="/registro">
            Crear cuenta
          </Link>
          <Link className="btn btn-outline-light" to="/contacto">
            Contáctanos
          </Link>
        </div>
      </div>
    </section>
  </>
);

export default Home;
