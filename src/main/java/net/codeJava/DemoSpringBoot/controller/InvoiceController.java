/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.controller;

import java.util.List;
import net.codeJava.DemoSpringBoot.model.Invoice;
import net.codeJava.DemoSpringBoot.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duong Dinh Binh
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InvoiceController {
    @Autowired
    private InvoiceRepository invoiceRepository;
    
    @GetMapping("/invoices/movie/{id}")
    public List<Invoice> getInvoicesByMovieId(@PathVariable long id){
        return invoiceRepository.findInvoicesByMovieId(id);
    }
    
    @GetMapping("/invoices")
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }
    
    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody Invoice invoice){
        return invoiceRepository.save(invoice);
    }
}
