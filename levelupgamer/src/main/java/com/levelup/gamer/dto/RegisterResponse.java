package com.levelup.gamer.dto;

public class RegisterResponse {
    
    private boolean ok;
    private String message;
    private Integer descuento;
    private UserDTO user;
    
    public RegisterResponse() {}
    
    public RegisterResponse(boolean ok, String message, Integer descuento, UserDTO user) {
        this.ok = ok;
        this.message = message;
        this.descuento = descuento;
        this.user = user;
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
    
    public Integer getDescuento() {
        return descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
    
    public UserDTO getUser() {
        return user;
    }
    
    public void setUser(UserDTO user) {
        this.user = user;
    }
}
