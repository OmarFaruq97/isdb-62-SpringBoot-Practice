package com.org.isdb62.service;

import com.org.isdb62.entity.Invoice;
import com.org.isdb62.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository repository;

    // Calculate total before discount
    public double calculateRawTotal(Invoice invoice) {
        return invoice.getQuantity() * invoice.getPrice();
    }

    // Apply discount (if quantity > 100 → 10% discount)
    public double calculateDiscountAmount(double total, int quantity) {
        if (total > 4999) {
            return total * 0.08; // 10% discount
        }
        return 0;
    }

    // Validate invoice
    public boolean isValid(Invoice invoice) {
        return invoice.getQuantity() > 0 &&
                invoice.getPrice() > 0 &&
                invoice.getCustomerName() != null &&
                !invoice.getCustomerName().isEmpty();
    }

    // Generate unique invoice number
    public String generateInvoiceNumber() {
        return "INV-" + System.currentTimeMillis();
    }

    // Save invoice
    public Invoice saveInvoice(Invoice invoice) {
        if (!isValid(invoice)) {
            throw new IllegalArgumentException("Invoice data is invalid");
        }

        double rawTotal = calculateRawTotal(invoice);
        double discount = calculateDiscountAmount(rawTotal, invoice.getQuantity());
        double finalTotal = rawTotal - discount;

        invoice.setInvoiceNumber(generateInvoiceNumber());
        invoice.setDiscountAmount(discount);
        invoice.setTotalAmount(finalTotal);

        return repository.save(invoice);
    }

    // Update invoice
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {
        Invoice existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));

        existing.setCustomerName(updatedInvoice.getCustomerName());
        existing.setContactNumber(updatedInvoice.getContactNumber());
        existing.setItemName(updatedInvoice.getItemName());
        existing.setQuantity(updatedInvoice.getQuantity());
        existing.setPrice(updatedInvoice.getPrice());

        double rawTotal = calculateRawTotal(existing);
        double discount = calculateDiscountAmount(rawTotal, existing.getQuantity());
        double finalTotal = rawTotal - discount;

        existing.setDiscountAmount(discount);
        existing.setTotalAmount(finalTotal);

        return repository.save(existing);
    }

    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteInvoice(Long id) {
        repository.deleteById(id);
    }
}
