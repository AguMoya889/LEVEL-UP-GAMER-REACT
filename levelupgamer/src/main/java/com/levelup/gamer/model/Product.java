package com.levelup.gamer.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String slug;
    
    @Column(nullable = false, length = 120)
    private String nombre;
    
    @Column(nullable = false, length = 100)
    private String categoria;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(length = 500)
    private String imagen;
    
    @Column(length = 500)
    private String resumen;
    
    @Column(length = 2000)
    private String descripcion;
    
    @Column(length = 2000)
    private String specs;
    
    @Column(length = 1000)
    private String incluye;
    
    @Column(length = 500)
    private String relacionados;
    
    @Column(nullable = false)
    private Integer stock = 0;
    
    // Constructor vacío obligatorio para JPA
    public Product() {}
    
    // Constructor
    public Product(String slug, String nombre, String categoria, Double precio, String imagen) {
        this.slug = slug;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.imagen = imagen;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSlug() {
        return slug;
    }
    
    public void setSlug(String slug) {
        this.slug = slug;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public String getImagen() {
        return imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    public String getResumen() {
        return resumen;
    }
    
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getSpecs() {
        return specs;
    }
    
    public void setSpecs(String specs) {
        this.specs = specs;
    }
    
    public String getIncluye() {
        return incluye;
    }
    
    public void setIncluye(String incluye) {
        this.incluye = incluye;
    }
    
    public String getRelacionados() {
        return relacionados;
    }
    
    public void setRelacionados(String relacionados) {
        this.relacionados = relacionados;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
