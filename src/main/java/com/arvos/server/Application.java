package com.arvos.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arvos.server.data.AugmentRepository;
import com.arvos.server.model.Augment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
    AugmentRepository repository;
	
	//Spring boot application class.
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    //testing JPA persistance
    @Override
    public void run(String... strings) throws Exception {
        // save a couple of augments
        repository.save(new Augment("Jack", "Augment1"));
        repository.save(new Augment("Chloe", "Augment2"));
        repository.save(new Augment("Kim", "Augment3"));
        repository.save(new Augment("David", "Augment4"));
        repository.save(new Augment("Michelle", "Augment5"));

        // fetch all augments
        System.out.println("Augments found with findAll():");
        System.out.println("-------------------------------");
        for (Augment augment : repository.findAll()) {
            System.out.println(augment);
        }
        System.out.println();

        // fetch an individual augment by ID
        Augment augment = repository.findOne(1L);
        System.out.println("Augment found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(augment);
        System.out.println();

        // fetch augments by title
        System.out.println("Augment found with findByTitle('Jack'):");
        System.out.println("--------------------------------------------");
        for (Augment jack : repository.findByName("Jack")) {
            System.out.println(jack);
        }
    }
}