import ProductCard from '../components/ProductCard.jsx';
import { products } from '../data/products.js';

const Products = () => (
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
          {products.map((product) => (
            <div className="col-12 col-md-6 col-lg-3" key={product.slug}>
              <ProductCard product={product} />
            </div>
          ))}
        </div>
      </div>
    </section>
  </>
);

export default Products;
