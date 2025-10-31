package com.example.HospitalMgmtSys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="invoice")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;

    @ManyToOne
    @JoinColumn(name="patientId")
    private Patient patient;

    // appointment rel one to one
    @OneToOne
    @JoinColumn(name="appointment_id", unique = true)
    private Appointment appointment;

    // invoice item
    @OneToMany(mappedBy = "invoice",fetch = FetchType.LAZY)
    private List<InvoiceItem> invoiceItemList= new ArrayList<>();

    private double subTotal;

    private double discount;

    private double tax;

    private double totalAmount;

    private String paymentMode;

    //convert to enum
    private String paymentStatus;

    private LocalDateTime paymentDate;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
