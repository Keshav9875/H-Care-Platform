package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
}
