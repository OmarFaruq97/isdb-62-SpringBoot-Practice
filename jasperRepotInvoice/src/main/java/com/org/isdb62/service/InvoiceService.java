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

    //Calculation discount amount general based on amount (5% fixed) for all customer
    public double calculateDiscountAmount(double rowTotal){
        double discountRate = 0.05; //5% discount
        return rowTotal * discountRate;
    }

    //Generate a dummy invoice number(could be replaced with real logic or depend on clint demand)
    public String generateInvoiceNumber(){
        return "INV-" + System.currentTimeMillis();
    }

    //Validation basic invoice data
    public boolean isValid(Invoice invoice){
        return
//                invoice.getCustomerName() != null &&
//                invoice.getContactNumber() != null &&
                  invoice.getItemName() != null &&
                  invoice.getQuantity() > 0 &&
                  invoice.getPrice() > 0;
    }

    //save invoice
    public Invoice saveInvoice(Invoice invoice) {
        if (!isValid(invoice)) {
            throw new IllegalArgumentException("Invoice data is invalid");
        }
        double rawTotal = calculateRawTotal(invoice);
        double discountAmount = calculateDiscountAmount(rawTotal);
        double finalTotal = rawTotal - discountAmount;

        invoice.setInvoiceNumber(generateInvoiceNumber());
        invoice.setAmount((int) rawTotal);
        invoice.setDiscount("5%"); // 5% fixed discount all medicine
        invoice.setDiscountAmount((int) discountAmount);
        invoice.setNetPayable(finalTotal);

        return invoiceRepository.save(invoice);
    }

    //get invoice
    public List<Invoice> getAllInvoice() {
        return invoiceRepository.findAll();
    }


    //update Invoice by id
    public Invoice updateInvoice(Long id, Invoice invoice) {
        Invoice existing = invoiceRepository.findById(id).orElse(null);
        if (existing !=null) {

            existing.setCustomerName(invoice.getCustomerName());
            existing.setContactNumber(invoice.getContactNumber());
            existing.setItemName(invoice.getItemName());
            existing.setQuantity(invoice.getQuantity());
            existing.setPrice(invoice.getPrice());

            double rowTotal = calculateRawTotal(invoice);
            double discount = calculateDiscountAmount(rowTotal);
            double finalTotal = rowTotal - discount;

            existing.setAmount((int) rowTotal);
            existing.setDiscount("5%");
            existing.setDiscountAmount((int) discount);
            existing.setNetPayable(finalTotal);

            return invoiceRepository.save(existing);
        }
        return null;
    }

    //delete invoice
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
