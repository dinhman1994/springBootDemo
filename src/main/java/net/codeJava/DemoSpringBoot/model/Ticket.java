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
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticket_id;
    
    @Column(name = "movie_id")
    private long movie_id;
    
    @Column(name = "category")
    private int category;
    
    @Column(name = "price")
    private int price;

    public Ticket(long ticket_id, long movie_id, int category, int price) {
        this.ticket_id = ticket_id;
        this.movie_id = movie_id;
        this.category = category;
        this.price = price;
    }
    
    public Ticket(long movie_id, int category, int price) {
        super();
        this.movie_id = movie_id;
        this.category = category;
        this.price = price;
    }
    
    public long getTicket_id() {
        return ticket_id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public int getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    public void setTicket_id(long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
    public Ticket(){
        
    }
}
