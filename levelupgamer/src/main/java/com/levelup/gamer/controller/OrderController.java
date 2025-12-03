package com.levelup.gamer.controller;

import com.levelup.gamer.dto.ApiResponse;
import com.levelup.gamer.dto.CheckoutRequest;
import com.levelup.gamer.dto.CheckoutResponse;
import com.levelup.gamer.model.Order;
import com.levelup.gamer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3100", "http://localhost:5173"})
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    // POST /api/v1/orders/checkout Procesar checkout - replica la función checkout() del CartContext
    @PostMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout(
            @RequestBody CheckoutRequest request,
            @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        try {
            CheckoutResponse response = orderService.processCheckout(request, userEmail);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(new CheckoutResponse(false, "Error al procesar la compra: " + e.getMessage(), null));
        }
    }
    
    // GET /api/v1/orders Obtener todas las órdenes (solo admin)
    @GetMapping
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        try {
            List<Order> orders = orderService.getAllOrders();
            return ResponseEntity.ok(ApiResponse.success(orders));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener órdenes: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/orders/{id} Obtener orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById(@PathVariable Long id) {
        try {
            Order order = orderService.getOrderById(id);
            if (order == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ApiResponse.success(order));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener orden: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/orders/order-id/{orderId} Obtener orden por OrderId
    @GetMapping("/order-id/{orderId}")
    public ResponseEntity<ApiResponse<Order>> getOrderByOrderId(@PathVariable String orderId) {
        try {
            Order order = orderService.getOrderByOrderId(orderId);
            if (order == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(ApiResponse.success(order));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener orden: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/orders/user/{userId} Obtener órdenes de un usuario
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrdersByUser(@PathVariable Long userId) {
        try {
            List<Order> orders = orderService.getOrdersByUser(userId);
            return ResponseEntity.ok(ApiResponse.success(orders));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener órdenes: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/orders/email/{email} Obtener órdenes por email - para historial de compras
    @GetMapping("/email/{email}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrdersByEmail(@PathVariable String email) {
        try {
            List<Order> orders = orderService.getOrdersByEmail(email);
            return ResponseEntity.ok(ApiResponse.success(orders));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener órdenes: " + e.getMessage()));
        }
    }
    
    // GET /api/v1/orders/status/{estado} Obtener órdenes por estado (PENDIENTE, COMPLETADO, CANCELADO)
    @GetMapping("/status/{estado}")
    public ResponseEntity<ApiResponse<List<Order>>> getOrdersByStatus(@PathVariable String estado) {
        try {
            List<Order> orders = orderService.getOrdersByStatus(estado);
            return ResponseEntity.ok(ApiResponse.success(orders));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener órdenes: " + e.getMessage()));
        }
    }
    
    // PATCH /api/v1/orders/{id}/status Actualizar estado de orden (solo admin)
    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiResponse<Order>> updateOrderStatus(
            @PathVariable Long id,
            @RequestParam String estado) {
        try {
            Order order = orderService.updateOrderStatus(id, estado);
            return ResponseEntity.ok(ApiResponse.success("Estado actualizado exitosamente", order));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al actualizar estado: " + e.getMessage()));
        }
    }
}
