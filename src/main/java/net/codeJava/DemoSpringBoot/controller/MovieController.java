/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import net.codeJava.DemoSpringBoot.model.Movie;
import net.codeJava.DemoSpringBoot.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import net.codeJava.DemoSpringBoot.model.MovieFrontEnd;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author Duong Dinh Binh
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;
    
    @GetMapping("/movies")
    public List<Object> getMovies() {
        List<Object> result = new ArrayList<Object>();
        List<Movie> movies = movieRepository.findAll();
        for (Movie movie : movies) {
            MovieFrontEnd movieFrontEnd = new MovieFrontEnd(movie.getMovie_id(), 
                    movie.getMovie_name(), 
                    movie.getStart_time().toString(), 
                    movie.getEnd_time().toString());
            result.add(movieFrontEnd);
        }
        return result;
    }
    
    @GetMapping("/movies/{id}")
    public MovieFrontEnd getMovie(@PathVariable long id){
        Optional<Movie> movieQuery = movieRepository.findById(id);
        if(movieQuery.isPresent()){
            Movie movie = movieQuery.get();
            MovieFrontEnd movieFrontEnd = new MovieFrontEnd(movie.getMovie_id(), 
                    movie.getMovie_name(), 
                    movie.getStart_time().toString(), 
                    movie.getEnd_time().toString());
            return movieFrontEnd;  
        }
        return null;
    }
    
    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Object requestBody) throws ParseException{
        LinkedHashMap<String,String> bodyParser = (LinkedHashMap<String,String>) requestBody; 
        String startTimeString = bodyParser.get("dateTime") + " " + bodyParser.get("startTime");
        String endTimeString = bodyParser.get("dateTime") + " " + bodyParser.get("endTime");       
        String movieName = bodyParser.get("movieName");
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date startTime = df.parse(startTimeString);
        Date endTime = df.parse(endTimeString);
        return movieRepository.save(new Movie(movieName, startTime, endTime));        
    }
    
    @PatchMapping("/movies/{id}")
    public MovieFrontEnd updateMovie(@PathVariable long id,@RequestBody Object requestBody) throws ParseException{
        Optional<Movie> movieQuery = movieRepository.findById(id);
        if(movieQuery.isPresent()){
            Movie movie = movieQuery.get();
            LinkedHashMap<String,String> bodyParser = (LinkedHashMap<String,String>) requestBody;
            String startTimeString = bodyParser.get("date_time") + " " + bodyParser.get("start_time");
            String endTimeString = bodyParser.get("date_time") + " " + bodyParser.get("end_time");
            String movieName = bodyParser.get("movie_name");
            
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date startTime = df.parse(startTimeString);
            Date endTime = df.parse(endTimeString);
            movie.setMovie_name(movieName);
            movie.setStart_time(startTime);
            movie.setEnd_time(endTime);
            Movie updatedMovie = movieRepository.save(movie);
            
            MovieFrontEnd movieFrontEnd = new MovieFrontEnd(updatedMovie.getMovie_id(), 
                    updatedMovie.getMovie_name(), 
                    updatedMovie.getStart_time().toString(), 
                    updatedMovie.getEnd_time().toString());
            return movieFrontEnd;            
        }
        return null;
    }
    
    @DeleteMapping("/movies/{id}")
    public Boolean deleteMovie(@PathVariable long id){
        Optional<Movie> movieQuery = movieRepository.findById(id);
        if(movieQuery.isPresent()){
            Movie movie = movieQuery.get();
            movieRepository.delete(movie);
            return true;
        }
        return false;
    }
}
