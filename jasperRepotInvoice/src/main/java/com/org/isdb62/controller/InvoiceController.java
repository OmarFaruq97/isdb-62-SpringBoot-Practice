package com.org.isdb62.controller;

import com.org.isdb62.entity.Invoice;
import com.org.isdb62.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping
    public Invoice createInvoice(@RequestBody Invoice invoice) {
        return invoiceService.saveInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> getAll(){

        return invoiceService.getAllInvoice();
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice){
        return invoiceService.updateInvoice(id, invoice);
    }

    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id){
        invoiceService.deleteInvoice(id);
        return "Invoice successfully delete";
    }
}
