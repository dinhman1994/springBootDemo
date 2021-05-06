/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.model;

/**
 *
 * @author Duong Dinh Binh
 */
public class MovieFrontEnd {
    private long id;
    private String movie_name;
    private String start_time;
    private String end_time;

    public MovieFrontEnd(long id, String movie_name, String start_time, String end_time) {
        this.id = id;
        this.movie_name = movie_name;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public long getId() {
        return id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }
    
    
}
