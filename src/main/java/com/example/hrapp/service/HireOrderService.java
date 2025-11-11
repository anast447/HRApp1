package com.example.hrapp.service;

import com.example.hrapp.model.HireOrder;
import com.example.hrapp.repository.HireOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HireOrderService {

    private final HireOrderRepository repo;

    public HireOrderService(HireOrderRepository repo) {
        this.repo = repo;
    }

    public List<HireOrder> getAll() {
        return repo.findAll();
    }

    public HireOrder getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("HireOrder not found with id " + id));
    }

    public HireOrder create(HireOrder hireOrder) {
        return repo.save(hireOrder);
    }

    public HireOrder update(Long id, HireOrder hireOrder) {
        hireOrder.setId(id);
        return repo.save(hireOrder);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
