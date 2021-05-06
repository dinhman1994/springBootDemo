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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    @Column(name = "name")
    private String name;
    @Column(name ="age")
    private int age;
    @Column(name ="phone")
    private long phone;
    
    public Customer(){
    }

    public Customer(String name, int age, long phone) {
        super();
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPhone() {
        return phone;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }


}
