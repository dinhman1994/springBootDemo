/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import net.codeJava.DemoSpringBoot.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Duong Dinh Binh
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    @Query(value = "select * from customers where phone = :phone",nativeQuery = true)
    List<Customer> findCustomerByPhone(@Param("phone") int phone);
}
