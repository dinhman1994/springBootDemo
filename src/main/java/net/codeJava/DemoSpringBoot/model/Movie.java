/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.model;

import java.util.Date;
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
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long movie_id;
    
    @Column(name = "movie_name")
    private String movie_name;
    
    @Column(name = "start_time")
    private Date start_time;
    
    @Column(name ="end_time")
    private Date end_time;

    public long getMovie_id() {
        return movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
    
    
    public Movie(String movie_name, Date start_time, Date end_time) {
        super();
        this.movie_name = movie_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }
    
    public Movie(){
        
    } 
}
