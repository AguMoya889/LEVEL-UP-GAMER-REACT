package com.levelup.gamer.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    
    private Long id;
    private String orderId;
    private String usuarioCorreo;
    private LocalDateTime fecha;
    private Double subtotal;
    private Double descuentoAplicado;
    private Double total;
    private String nombre;
    private String apellido;
    private String email;
    private String calle;
    private String departamento;
    private String region;
    private String comuna;
    private String indicaciones;
    private String estado;
    private List<OrderItemDTO> items;
    
    public OrderDTO() {}
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    
    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }
    
    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }
    
    public LocalDateTime getFecha() {
        return fecha;
    }
    
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public Double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    public Double getDescuentoAplicado() {
        return descuentoAplicado;
    }
    
    public void setDescuentoAplicado(Double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }
    
    public Double getTotal() {
        return total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCalle() {
        return calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
    
    public String getIndicaciones() {
        return indicaciones;
    }
    
    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public List<OrderItemDTO> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}
