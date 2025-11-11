package com.example.hrapp.service;

import com.example.hrapp.model.Order;
import com.example.hrapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    public List<Order> getAll() {
        return repo.findAll();
    }

    public Order getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    public Order create(Order order) {
        return repo.save(order);
    }

    public Order update(Long id, Order order) {
        order.setId(id);
        return repo.save(order);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
