/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Duong Dinh Binh
 */
@Entity
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long invoice_id;
    @Column(name = "customer_id")
    private long customer_id;
    @Column(name = "ticket_id")
    private long ticket_id;
    @Column(name = "seat")
    private String seat;
    @Column(name = "price")
    private int price;

    public Invoice(long customer_id, long ticket_id, String seat, int price) {
        super();
        this.customer_id = customer_id;
        this.ticket_id = ticket_id;
        this.seat = seat;
        this.price = price;
    }
    
    public Invoice(){
        
    }

    public long getInvoice_id() {
        return invoice_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public long getTicket_id() {
        return ticket_id;
    }

    public String getSeat() {
        return seat;
    }

    public int getPrice() {
        return price;
    }

    public void setInvoice_id(long invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
