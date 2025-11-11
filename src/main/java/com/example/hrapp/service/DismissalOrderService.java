package com.example.hrapp.service;

import com.example.hrapp.model.DismissalOrder;
import com.example.hrapp.repository.DismissalOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DismissalOrderService {

    private final DismissalOrderRepository repo;

    public DismissalOrderService(DismissalOrderRepository repo) {
        this.repo = repo;
    }

    public List<DismissalOrder> getAll() {
        return repo.findAll();
    }

    public DismissalOrder getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("DismissalOrder not found with id " + id));
    }

    public DismissalOrder create(DismissalOrder dismissalOrder) {
        return repo.save(dismissalOrder);
    }

    public DismissalOrder update(Long id, DismissalOrder dismissalOrder) {
        dismissalOrder.setId(id);
        return repo.save(dismissalOrder);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
