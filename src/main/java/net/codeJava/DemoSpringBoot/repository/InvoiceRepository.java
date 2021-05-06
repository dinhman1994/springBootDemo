/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.repository;

import java.util.List;
import net.codeJava.DemoSpringBoot.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duong Dinh Binh
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    @Query(value = "select invoices.* from invoices\n" +
"join tickets on invoices.ticket_id = tickets.ticket_id\n" +
"where tickets.movie_id = :movie_id",nativeQuery = true)
    List<Invoice> findInvoicesByMovieId(@Param("movie_id") long movie_id);
}
