package com.org.isdb62.repository;

import com.org.isdb62.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
