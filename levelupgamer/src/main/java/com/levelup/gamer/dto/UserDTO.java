package com.levelup.gamer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    
    private Long id;
    private String nombre;
    private String apellidos;
    private String correo;
    private Integer descuento;
    private Boolean esAdmin;
    private String region;
    private String comuna;
    private String direccion;
    
    public UserDTO() {}
    
    public UserDTO(Long id, String nombre, String correo, Integer descuento, Boolean esAdmin) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.descuento = descuento;
        this.esAdmin = esAdmin;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public Integer getDescuento() {
        return descuento;
    }
    
    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }
    
    public Boolean getEsAdmin() {
        return esAdmin;
    }
    
    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getComuna() {
        return comuna;
    }
    
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
