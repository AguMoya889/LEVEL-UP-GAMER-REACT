package com.levelup.gamer.controller;

import com.levelup.gamer.dto.ApiResponse;
import com.levelup.gamer.dto.StatsDTO;
import com.levelup.gamer.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    
    @Autowired
    private StatsService statsService;
    
    /**
     * GET /api/v1/admin/stats
     * Obtener estadísticas generales - para AdminDashboard
     */
    @GetMapping("/stats")
    public ResponseEntity<ApiResponse<StatsDTO>> getStats() {
        try {
            StatsDTO stats = statsService.getGeneralStats();
            return ResponseEntity.ok(ApiResponse.success(stats));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener estadísticas: " + e.getMessage()));
        }
    }
    
    /**
     * GET /api/v1/admin/categories
     * Obtener todas las categorías únicas de productos
     */
    @GetMapping("/categories")
    public ResponseEntity<ApiResponse<List<String>>> getCategories() {
        try {
            List<String> categories = statsService.getCategories();
            return ResponseEntity.ok(ApiResponse.success(categories));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.error("Error al obtener categorías: " + e.getMessage()));
        }
    }
}
