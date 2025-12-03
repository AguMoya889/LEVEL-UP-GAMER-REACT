package com.levelup.gamer.controller;

import com.levelup.gamer.dto.ApiResponse;
import com.levelup.gamer.model.Product;
import com.levelup.gamer.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    // GET /api/v1/products Obtener todos los productos - equivalente a products.js
    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            return ResponseEntity.ok(ApiResponse.success(products));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener productos: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/products/{id} Obtener producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            if (product == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ApiResponse.success(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener producto: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/products/slug/{slug} Obtener producto por slug - equivalente a findProduct()
    @GetMapping("/slug/{slug}")
    public ResponseEntity<ApiResponse<Product>> getProductBySlug(@PathVariable String slug) {
        try {
            Product product = productService.getProductBySlug(slug);
            if (product == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ApiResponse.success(product));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener producto: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/products/category/{categoria} Obtener productos por categoría
    @GetMapping("/category/{categoria}")
    public ResponseEntity<ApiResponse<List<Product>>> getProductsByCategory(@PathVariable String categoria) {
        try {
            List<Product> products = productService.getProductsByCategory(categoria);
            return ResponseEntity.ok(ApiResponse.success(products));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener productos: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/products/search?q={query} Buscar productos por nombre
    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<Product>>> searchProducts(@RequestParam String q) {
        try {
            List<Product> products = productService.searchProducts(q);
            return ResponseEntity.ok(ApiResponse.success(products));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al buscar productos: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/products/featured Obtener productos destacados - equivalente a featuredProducts
    @GetMapping("/featured")
    public ResponseEntity<ApiResponse<List<Product>>> getFeaturedProducts() {
        try {
            List<Product> products = productService.getFeaturedProducts();
            return ResponseEntity.ok(ApiResponse.success(products));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener productos destacados: " + e.getMessage()));
        }
    }
    
    // POST /api/v1/products Crear producto (solo admin)
    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product) {
        try {
            Product created = productService.createProduct(product);
            return ResponseEntity.ok(ApiResponse.success("Producto creado exitosamente", created));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al crear producto: " + e.getMessage()));
        }
    }
    
    // PUT /api/v1/products/{id} Actualizar producto (solo admin)
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {
        try {
            Product updated = productService.updateProduct(id, product);
            return ResponseEntity.ok(ApiResponse.success("Producto actualizado exitosamente", updated));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al actualizar producto: " + e.getMessage()));
        }
    }
    
    // DELETE /api/v1/products/{id} Eliminar producto (solo admin)
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok(ApiResponse.success("Producto eliminado exitosamente", null));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al eliminar producto: " + e.getMessage()));
        }
    }
}
