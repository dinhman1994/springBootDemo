/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codeJava.DemoSpringBoot.controller;

import java.util.List;
import java.util.ListIterator;
import net.codeJava.DemoSpringBoot.model.Cat;
import net.codeJava.DemoSpringBoot.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Duong Dinh Binh
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CatController {
    @Autowired
    private CatRepository catRepository;
    
    @GetMapping("/cats")
    public List<Cat> getCats(){
        return this.catRepository.findAll();
    }
    
    @PostMapping("/cats")
    public Cat addCat(Cat cat){
        return catRepository.save(cat);
    }
}
