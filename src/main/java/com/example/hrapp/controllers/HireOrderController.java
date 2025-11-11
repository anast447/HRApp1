package com.example.hrapp.controllers;

import com.example.hrapp.model.HireOrder;
import com.example.hrapp.service.HireOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hire-orders")
public class HireOrderController {

    private final HireOrderService service;

    public HireOrderController(HireOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<HireOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HireOrder getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public HireOrder create(@RequestBody HireOrder hireOrder) {
        return service.create(hireOrder);
    }

    @PutMapping("/{id}")
    public HireOrder update(@PathVariable Long id, @RequestBody HireOrder hireOrder) {
        hireOrder.setId(id);
        return service.update(id, hireOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
