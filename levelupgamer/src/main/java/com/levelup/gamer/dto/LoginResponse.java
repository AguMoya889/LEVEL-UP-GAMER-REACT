package com.levelup.gamer.dto;

public class LoginResponse {
    
    private boolean ok;
    private boolean admin;
    private String message;
    private UserDTO user;
    
    public LoginResponse() {}
    
    public LoginResponse(boolean ok, boolean admin, UserDTO user) {
        this.ok = ok;
        this.admin = admin;
        this.user = user;
    }
    
    public LoginResponse(boolean ok, String message) {
        this.ok = ok;
        this.message = message;
    }
    
    // Getters y Setters
    public boolean isOk() {
        return ok;
    }
    
    public void setOk(boolean ok) {
        this.ok = ok;
    }
    
    public boolean isAdmin() {
        return admin;
    }
    
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public UserDTO getUser() {
        return user;
    }
    
    public void setUser(UserDTO user) {
        this.user = user;
    }
}
