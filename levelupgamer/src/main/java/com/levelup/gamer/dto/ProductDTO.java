package com.levelup.gamer.dto;

import java.util.List;

public class ProductDTO {
    
    private Long id;
    private String slug;
    private String nombre;
    private String categoria;
    private Double precio;
    private String imagen;
    private String resumen;
    private String descripcion;
    private List<String> specs;
    private List<String> incluye;
    private List<String> relacionados;
    private Integer stock;
    
    public ProductDTO() {}
    
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
    
    public List<String> getSpecs() {
        return specs;
    }
    
    public void setSpecs(List<String> specs) {
        this.specs = specs;
    }
    
    public List<String> getIncluye() {
        return incluye;
    }
    
    public void setIncluye(List<String> incluye) {
        this.incluye = incluye;
    }
    
    public List<String> getRelacionados() {
        return relacionados;
    }
    
    public void setRelacionados(List<String> relacionados) {
        this.relacionados = relacionados;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
