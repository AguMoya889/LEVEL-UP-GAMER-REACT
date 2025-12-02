package com.levelup.gamer.controller;

import com.levelup.gamer.dto.ApiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthController {
    
    /**
     * GET /api/v1/health
     * Endpoint de salud para verificar que el backend está funcionando
     */
    @GetMapping("/health")
    public ApiResponse<Map<String, Object>> healthCheck() {
        Map<String, Object> health = new HashMap<>();
        health.put("status", "UP");
        health.put("service", "Level Up Gamer API");
        health.put("version", "1.0.0");
        health.put("timestamp", LocalDateTime.now().toString());
        
        return ApiResponse.success("Backend funcionando correctamente", health);
    }
    
    /**
     * GET /api/v1/info
     * Información general de la API
     */
    @GetMapping("/info")
    public ApiResponse<Map<String, Object>> apiInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("name", "Level Up Gamer REST API");
        info.put("version", "1.0.0");
        info.put("description", "API REST para e-commerce de productos gaming");
        info.put("endpoints", Map.of(
            "users", "/api/v1/users",
            "products", "/api/v1/products",
            "orders", "/api/v1/orders",
            "health", "/api/v1/health"
        ));
        info.put("features", new String[]{
            "Autenticación de usuarios",
            "Registro con descuento DuocUC",
            "CRUD de productos",
            "Sistema de checkout",
            "Historial de compras",
            "Panel de administración"
        });
        
        return ApiResponse.success(info);
    }
}
