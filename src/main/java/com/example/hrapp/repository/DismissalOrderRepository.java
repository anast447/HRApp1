package com.example.hrapp.repository;

import com.example.hrapp.model.DismissalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DismissalOrderRepository extends JpaRepository<DismissalOrder, Long> {}
