package net.codeJava.DemoSpringBoot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
        
@SpringBootApplication
public class DemoSpringBootApplication implements CommandLineRunner{
    
    
    public static void main(String[] args) {
            System.out.println("Hello");
            SpringApplication.run(DemoSpringBootApplication.class, args);
    }
        
    @Override
    public void run(String... args) throws Exception {
        
    }

}
