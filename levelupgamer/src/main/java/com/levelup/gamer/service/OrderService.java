package com.levelup.gamer.service;

import com.levelup.gamer.dto.CartItemDTO;
import com.levelup.gamer.dto.CheckoutRequest;
import com.levelup.gamer.dto.CheckoutResponse;
import com.levelup.gamer.model.Order;
import com.levelup.gamer.model.OrderItem;
import com.levelup.gamer.model.Product;
import com.levelup.gamer.model.User;
import com.levelup.gamer.repository.OrderRepository;
import com.levelup.gamer.repository.ProductRepository;
import com.levelup.gamer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
// Procesar checkout - replica la lógica del CartContext
    @Transactional
    public CheckoutResponse processCheckout(CheckoutRequest request, String userEmail) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            return new CheckoutResponse(false, "Tu carrito está vacío", null);
        }
        
        // Obtener datos del usuario desde el Map
        var userData = request.getUser();
        String nombre = userData.get("nombre");
        String apellido = userData.get("apellido");
        String email = userData.get("email");
        String calle = userData.get("calle");
        String departamento = userData.get("departamento");
        String region = userData.get("region");
        String comuna = userData.get("comuna");
        String indicaciones = userData.get("indicaciones");
        
        // Usar el total calculado del frontend
        double subtotal = request.getSubtotal() != null ? request.getSubtotal() : 0.0;
        double descuentoMonto = request.getDiscount() != null ? request.getDiscount() : 0.0;
        double total = request.getTotal() != null ? request.getTotal() : subtotal;
        
        // Buscar usuario si está logueado
        User user = null;
        if (userEmail != null && !userEmail.isEmpty()) {
            user = userRepository.findByCorreo(userEmail.toLowerCase()).orElse(null);
        } else if (email != null && !email.isEmpty()) {
            user = userRepository.findByCorreo(email.toLowerCase()).orElse(null);
        }
        
        // Generar Order ID
        String orderId = "ORDER" + System.currentTimeMillis();
        
        // Crear Order
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUser(user);
        order.setUsuarioCorreo(email);
        order.setFecha(LocalDateTime.now());
        order.setSubtotal(subtotal);
        order.setDescuentoAplicado(descuentoMonto);
        order.setTotal(total);
        order.setNombre(nombre);
        order.setApellido(apellido);
        order.setEmail(email);
        order.setCalle(calle);
        order.setDepartamento(departamento);
        order.setRegion(region);
        order.setComuna(comuna);
        order.setIndicaciones(indicaciones);
        order.setEstado("COMPLETADO");
        
        // Crear OrderItems
        for (CartItemDTO item : request.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setSlug(item.getProductSlug());
            orderItem.setPrecio(item.getPrice());
            orderItem.setCantidad(item.getQuantity());
            orderItem.setSubtotal(item.getPrice() * item.getQuantity());
            
            // Buscar producto y asociarlo
            Product product = productRepository.findBySlug(item.getProductSlug()).orElse(null);
            if (product != null) {
                orderItem.setProduct(product);
                orderItem.setNombre(product.getNombre());
            }
            
            order.addItem(orderItem);
        }
        
        orderRepository.save(order);
        
        return new CheckoutResponse(true, "Compra realizada exitosamente", orderId);
    }
// Obtener todas las órdenes
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
// Obtener orden por ID
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
// Obtener orden por OrderId
    public Order getOrderByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId).orElse(null);
    }
// Obtener órdenes de un usuario
    public List<Order> getOrdersByUser(Long userId) {
        return orderRepository.findByUserIdOrderByFechaDesc(userId);
    }
// Obtener órdenes por email
    public List<Order> getOrdersByEmail(String email) {
        return orderRepository.findByUsuarioCorreo(email.toLowerCase());
    }
// Obtener órdenes por estado
    public List<Order> getOrdersByStatus(String estado) {
        return orderRepository.findByEstado(estado);
    }
// Actualizar estado de orden
    public Order updateOrderStatus(Long id, String estado) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            throw new RuntimeException("Orden no encontrada");
        }
        
        order.setEstado(estado);
        return orderRepository.save(order);
    }
}
