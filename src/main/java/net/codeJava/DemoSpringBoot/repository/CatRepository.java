/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.repository;

import net.codeJava.DemoSpringBoot.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Duong Dinh Binh
 */
@Repository
public interface CatRepository extends JpaRepository<Cat, Long>{
       
}
