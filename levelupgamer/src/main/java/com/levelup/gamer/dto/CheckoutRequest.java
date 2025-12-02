package com.levelup.gamer.dto;

import java.util.List;
import java.util.Map;

public class CheckoutRequest {
    
    private Map<String, String> user;
    private List<CartItemDTO> items;
    private Double subtotal;
    private Double discount;
    private Double total;
    
    public CheckoutRequest() {}
    
    // Getters y Setters
    public Map<String, String> getUser() {
        return user;
    }
    
    public void setUser(Map<String, String> user) {
        this.user = user;
    }
    
    public List<CartItemDTO> getItems() {
        return items;
    }
    
    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }
    
    public Double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Double getDiscount() {
        return discount;
    }
    
    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
}
