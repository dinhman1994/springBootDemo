/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import net.codeJava.DemoSpringBoot.model.Ticket;
import net.codeJava.DemoSpringBoot.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    
    @PostMapping("/tickets")
    public Ticket createTicket(@RequestBody Object requestBody){
        LinkedHashMap<String,String> bodyParser = (LinkedHashMap<String,String>) requestBody;
        long movie_id = Long.parseLong(bodyParser.get("movie_id"));
        int category = Integer.parseInt(bodyParser.get("category"));
        int price = Integer.parseInt(bodyParser.get("price"));
       
        List<Ticket> tickets = ticketRepository.findExitTicktet(movie_id, category);
        if(tickets.size()>0)
        {
            return null;
        }
        return ticketRepository.save(new Ticket(movie_id, category, price));
    }
    
    @PatchMapping("/tickets/{id}")
    public Ticket updateTicket(@PathVariable long id, @RequestBody Object requestBody){
        Optional<Ticket> ticketQuery = ticketRepository.findById(id);
        if(ticketQuery.isPresent()){
            Ticket ticket = ticketQuery.get();
            LinkedHashMap<String,Integer> bodyParser = (LinkedHashMap<String,Integer>) requestBody;

            long movie_id = bodyParser.get("movie_id");
            int category = bodyParser.get("category");
            int price = bodyParser.get("price");

            ticket.setMovie_id(movie_id);
            ticket.setCategory(category);
            ticket.setPrice(price);
            
            return ticketRepository.save(ticket);
        }
        return this.createTicket(requestBody);
    }
    
    @DeleteMapping("/tickets/{id}")
    public Boolean deleteMovie(@PathVariable long id){
        Optional<Ticket> ticketQuery = ticketRepository.findById(id);
        if(ticketQuery.isPresent()){
            Ticket ticket = ticketQuery.get();
            ticketRepository.delete(ticket);
            return true;
        }
        return false;
    }
    
    @GetMapping("/tickets/movie/{movie_id}")
    public List<Ticket> getTicketsByMovieId(@PathVariable long movie_id){
        return ticketRepository.findTicketByMovieId(movie_id);       
    } 
    
    @GetMapping("tickets/{id}")
    public Ticket getTicketById(@PathVariable long id){
        Optional<Ticket> ticketQuery = ticketRepository.findById(id);
        if(ticketQuery.isPresent()){
            return ticketQuery.get();
        }
        return null;
    }
    
    @GetMapping("/tickets/all")
    public List<Ticket> getAllTicket(){
        return ticketRepository.findAll();
    }
}
