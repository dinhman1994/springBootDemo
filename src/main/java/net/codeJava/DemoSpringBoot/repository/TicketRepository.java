/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.repository;

import java.util.List;
import net.codeJava.DemoSpringBoot.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duong Dinh Binh
 */
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    @Query(value = "select * from tickets ts where ts.movie_id = :movie_id",nativeQuery = true)
    List<Ticket> findTicketByMovieId(@Param("movie_id") Long movie_id);
    
    @Query(value = "select * from tickets \n" +
"where movie_id = :movie_id and category = :category ",nativeQuery = true)
    List<Ticket> findExitTicktet(@Param("movie_id") long movie_id, @Param("category") int category);
}
