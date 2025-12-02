package com.levelup.gamer.dto;

public class CheckoutResponse {
    
    private boolean ok;
    private String message;
    private String orderId;
    
    public CheckoutResponse() {}
    
    public CheckoutResponse(boolean ok, String message, String orderId) {
        this.ok = ok;
        this.message = message;
        this.orderId = orderId;
    }
    
    // Getters y Setters
    public boolean isOk() {
        return ok;
    }
    
    public void setOk(boolean ok) {
        this.ok = ok;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
