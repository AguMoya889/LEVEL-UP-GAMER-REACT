package com.levelup.gamer.repository;

import com.levelup.gamer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    Optional<Order> findByOrderId(String orderId);
    
    List<Order> findByUsuarioCorreo(String usuarioCorreo);
    
    List<Order> findByEstado(String estado);
    
    List<Order> findByUserIdOrderByFechaDesc(Long userId);
}
