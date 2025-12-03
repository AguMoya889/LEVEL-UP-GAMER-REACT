package com.levelup.gamer.service;

import com.levelup.gamer.dto.StatsDTO;
import com.levelup.gamer.model.Order;
import com.levelup.gamer.model.Product;
import com.levelup.gamer.repository.OrderRepository;
import com.levelup.gamer.repository.ProductRepository;
import com.levelup.gamer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StatsService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderRepository orderRepository;
// Obtener estadísticas generales del sistema (para AdminDashboard)
    public StatsDTO getGeneralStats() {
        StatsDTO stats = new StatsDTO();
        
        // Total usuarios
        stats.setTotalUsuarios(userRepository.count());
        
        // Total productos
        stats.setTotalProductos(productRepository.count());
        
        // Total órdenes
        stats.setTotalOrdenes(orderRepository.count());
        
        // Ventas totales
        List<Order> orders = orderRepository.findAll();
        Double ventasTotales = orders.stream()
            .mapToDouble(Order::getTotal)
            .sum();
        stats.setVentasTotales(ventasTotales);
        
        // Productos por categoría
        List<Product> products = productRepository.findAll();
        Map<String, Long> categoryCounts = products.stream()
            .collect(Collectors.groupingBy(Product::getCategoria, Collectors.counting()));
        
        List<StatsDTO.CategoryStat> categoryStats = new ArrayList<>();
        categoryCounts.forEach((categoria, cantidad) -> 
            categoryStats.add(new StatsDTO.CategoryStat(categoria, cantidad))
        );
        stats.setProductosPorCategoria(categoryStats);
        
        // Órdenes recientes (últimas 10)
        List<Order> recentOrders = orders.stream()
            .sorted((o1, o2) -> o2.getFecha().compareTo(o1.getFecha()))
            .limit(10)
            .collect(Collectors.toList());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<StatsDTO.OrderStat> orderStats = recentOrders.stream()
            .map(order -> new StatsDTO.OrderStat(
                order.getOrderId(),
                order.getUsuarioCorreo(),
                order.getTotal(),
                order.getFecha().format(formatter)
            ))
            .collect(Collectors.toList());
        stats.setOrdenesRecientes(orderStats);
        
        return stats;
    }
// Obtener categorías únicas
    public List<String> getCategories() {
        return productRepository.findAll().stream()
            .map(Product::getCategoria)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }
}
