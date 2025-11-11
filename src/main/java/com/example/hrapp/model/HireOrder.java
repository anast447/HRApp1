package com.example.hrapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hire_orders")
public class HireOrder extends Order {

    private LocalDate hireDate;
    private String position;
    private String department;
    private Double salary;

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Double getSalary() { return salary; }
    public void setSalary(Double salary) { this.salary = salary; }
}
