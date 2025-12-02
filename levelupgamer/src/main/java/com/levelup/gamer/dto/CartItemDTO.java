package com.levelup.gamer.dto;

public class CartItemDTO {
    
    private String productSlug;
    private Integer quantity;
    private Double price;
    
    public CartItemDTO() {}
    
    public CartItemDTO(String productSlug, Integer quantity, Double price) {
        this.productSlug = productSlug;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Getters y Setters
    public String getProductSlug() {
        return productSlug;
    }
    
    public void setProductSlug(String productSlug) {
        this.productSlug = productSlug;
    }
    
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
}
