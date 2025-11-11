package com.example.hrapp.repository;

import com.example.hrapp.model.HireOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HireOrderRepository extends JpaRepository<HireOrder, Long> {}
