/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.codeJava.DemoSpringBoot.model.Movie;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duong Dinh Binh
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    
}
