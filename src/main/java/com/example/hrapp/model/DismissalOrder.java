package com.example.hrapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dismissal_orders")
public class DismissalOrder extends Order {

    private LocalDate dismissalDate;

    @Column(length = 1000)
    private String dismissalReason;

    public LocalDate getDismissalDate() { return dismissalDate; }
    public void setDismissalDate(LocalDate dismissalDate) { this.dismissalDate = dismissalDate; }

    public String getDismissalReason() { return dismissalReason; }
    public void setDismissalReason(String dismissalReason) { this.dismissalReason = dismissalReason; }
}
