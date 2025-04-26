package com.org.isdb62.service;

import com.org.isdb62.entity.Invoice;
import com.org.isdb62.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    //Calculate total before discount
    public double calculateRawTotal(Invoice invoice){
        return invoice.getQuantity() * invoice.getPrice();
    }

    //save invoice
    public Invoice saveInvoice(Invoice invoice) {
        if (!isValid(invoice)) {
            throw new IllegalArgumentException("Invoice data is invalid")
        }
        double rawTotal = calculateRawTotal(invoice);
        double discount = calculateDiscountAmmount(rawTotal,invoice.getQuantity());
        double finalTotal = rawTotal - discount;

        invoice.setInvoiceNumber(generateInvoiceNumber());
        invoice.setDiscountAmmount(discount);
        invoice.setTotalAmmount(finalTotal);

        return invoiceRepository.save(invoice);
    }

    //get invoice
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }

    //update Invoice
    public Invoice updateInvoice(Long id, Invoice invoice) {
        return invoiceRepository.findById(id).orElse(null);
    }

    //delete invoice
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
