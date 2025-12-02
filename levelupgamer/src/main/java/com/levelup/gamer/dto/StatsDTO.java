package com.levelup.gamer.dto;

import java.util.List;

public class StatsDTO {
    
    private Long totalUsuarios;
    private Long totalProductos;
    private Long totalOrdenes;
    private Double ventasTotales;
    private List<CategoryStat> productosPorCategoria;
    private List<OrderStat> ordenesRecientes;
    
    public StatsDTO() {}
    
    // Getters y Setters
    public Long getTotalUsuarios() {
        return totalUsuarios;
    }
    
    public void setTotalUsuarios(Long totalUsuarios) {
        this.totalUsuarios = totalUsuarios;
    }
    
    public Long getTotalProductos() {
        return totalProductos;
    }
    
    public void setTotalProductos(Long totalProductos) {
        this.totalProductos = totalProductos;
    }
    
    public Long getTotalOrdenes() {
        return totalOrdenes;
    }
    
    public void setTotalOrdenes(Long totalOrdenes) {
        this.totalOrdenes = totalOrdenes;
    }
    
    public Double getVentasTotales() {
        return ventasTotales;
    }
    
    public void setVentasTotales(Double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }
    
    public List<CategoryStat> getProductosPorCategoria() {
        return productosPorCategoria;
    }
    
    public void setProductosPorCategoria(List<CategoryStat> productosPorCategoria) {
        this.productosPorCategoria = productosPorCategoria;
    }
    
    public List<OrderStat> getOrdenesRecientes() {
        return ordenesRecientes;
    }
    
    public void setOrdenesRecientes(List<OrderStat> ordenesRecientes) {
        this.ordenesRecientes = ordenesRecientes;
    }
    
    // Clases internas
    public static class CategoryStat {
        private String categoria;
        private Long cantidad;
        
        public CategoryStat(String categoria, Long cantidad) {
            this.categoria = categoria;
            this.cantidad = cantidad;
        }
        
        public String getCategoria() {
            return categoria;
        }
        
        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }
        
        public Long getCantidad() {
            return cantidad;
        }
        
        public void setCantidad(Long cantidad) {
            this.cantidad = cantidad;
        }
    }
    
    public static class OrderStat {
        private String orderId;
        private String usuarioCorreo;
        private Double total;
        private String fecha;
        
        public OrderStat(String orderId, String usuarioCorreo, Double total, String fecha) {
            this.orderId = orderId;
            this.usuarioCorreo = usuarioCorreo;
            this.total = total;
            this.fecha = fecha;
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
        
        public Double getTotal() {
            return total;
        }
        
        public void setTotal(Double total) {
            this.total = total;
        }
        
        public String getFecha() {
            return fecha;
        }
        
        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
    }
}
