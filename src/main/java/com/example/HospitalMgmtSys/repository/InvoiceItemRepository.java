package com.example.HospitalMgmtSys.repository;

import com.example.HospitalMgmtSys.entity.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Long> {
}
