package com.levelup.gamer.service;

import com.levelup.gamer.model.Product;
import com.levelup.gamer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    /**
     * Obtener todos los productos
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    /**
     * Obtener producto por ID
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    /**
     * Obtener producto por slug
     */
    public Product getProductBySlug(String slug) {
        return productRepository.findBySlug(slug).orElse(null);
    }
    
    /**
     * Obtener productos por categoría
     */
    public List<Product> getProductsByCategory(String categoria) {
        return productRepository.findByCategoria(categoria);
    }
    
    /**
     * Buscar productos por nombre
     */
    public List<Product> searchProducts(String query) {
        return productRepository.findByNombreContainingIgnoreCase(query);
    }
    
    /**
     * Crear producto
     */
    public Product createProduct(Product product) {
        if (productRepository.existsBySlug(product.getSlug())) {
            throw new RuntimeException("Ya existe un producto con ese slug");
        }
        return productRepository.save(product);
    }
    
    /**
     * Actualizar producto
     */
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id).orElse(null);
        if (existing == null) {
            throw new RuntimeException("Producto no encontrado");
        }
        
        existing.setNombre(product.getNombre());
        existing.setCategoria(product.getCategoria());
        existing.setPrecio(product.getPrecio());
        existing.setImagen(product.getImagen());
        existing.setResumen(product.getResumen());
        existing.setDescripcion(product.getDescripcion());
        existing.setSpecs(product.getSpecs());
        existing.setIncluye(product.getIncluye());
        existing.setRelacionados(product.getRelacionados());
        existing.setStock(product.getStock());
        
        return productRepository.save(existing);
    }
    
    /**
     * Eliminar producto
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    
    /**
     * Obtener productos destacados (primeros 4)
     */
    public List<Product> getFeaturedProducts() {
        List<Product> all = productRepository.findAll();
        return all.size() > 4 ? all.subList(0, 4) : all;
    }
}
