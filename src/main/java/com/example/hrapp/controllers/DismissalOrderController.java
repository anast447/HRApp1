package com.example.hrapp.controllers;

import com.example.hrapp.model.DismissalOrder;
import com.example.hrapp.service.DismissalOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dismissal-orders")
public class DismissalOrderController {

    private final DismissalOrderService service;

    public DismissalOrderController(DismissalOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<DismissalOrder> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DismissalOrder getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public DismissalOrder create(@RequestBody DismissalOrder dismissalOrder) {
        return service.create(dismissalOrder);
    }

    @PutMapping("/{id}")
    public DismissalOrder update(@PathVariable Long id, @RequestBody DismissalOrder dismissalOrder) {
        dismissalOrder.setId(id);
        return service.update(id, dismissalOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
