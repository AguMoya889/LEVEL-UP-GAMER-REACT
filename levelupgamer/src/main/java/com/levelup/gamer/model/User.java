package com.levelup.gamer.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 9)
    private String run;
    
    @Column(nullable = false, length = 50)
    private String nombre;
    
    @Column(nullable = false, length = 100)
    private String apellidos;
    
    @Column(nullable = false, unique = true, length = 100)
    private String correo;
    
    @Column(nullable = false, length = 100)
    private String password;
    
    @Column(nullable = false)
    private LocalDate fechaNacimiento;
    
    @Column(nullable = false, length = 100)
    private String region;
    
    @Column(nullable = false, length = 100)
    private String comuna;
    
    @Column(nullable = false, length = 300)
    private String direccion;
    
    @Column(nullable = false)
    private Integer descuento = 0;
    
    @Column(nullable = false)
    private Boolean esAdmin = false;
    
    // Constructor vacío obligatorio para JPA
    public User() {}
    
    // Constructor completo
    public User(String run, String nombre, String apellidos, String correo, String password,
                LocalDate fechaNacimiento, String region, String comuna, String direccion) {
        this.run = run;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.region = region;
        this.comuna = comuna;
        this.direccion = direccion;
        
        // Aplicar descuento automático para DuocUC
        if (correo.endsWith("@duocuc.cl") || correo.endsWith("@profesor.duoc.cl")) {
            this.descuento = 20;
        }
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRun() {
        return run;
    }
    
    public void setRun(String run) {
        this.run = run;
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
        // Actualizar descuento si cambia el correo
        if (correo != null && (correo.endsWith("@duocuc.cl") || correo.endsWith("@profesor.duoc.cl"))) {
            this.descuento = 20;
        }
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
}
