package com.arvos.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.arvos.server.model.Augment;
@SpringBootApplication
public class Application implements CommandLineRunner {

	
	//Spring boot application class.
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    //Testing In-memory persistence
    @Override
    public void run(String... strings) throws Exception {
      /*  // save a couple of augments
    	augmentRepository_.save(new Augment("Jack", "Augment1"));
    	augmentRepository_.save(new Augment("Chloe", "Augment2"));
    	augmentRepository_.save(new Augment("Kim", "Augment3"));
    	augmentRepository_.save(new Augment("David", "Augment4"));
    	augmentRepository_.save(new Augment("Michelle", "Augment5"));

        // fetch all augments
        System.out.println("Augments found with findAll():");
        System.out.println("-------------------------------");
        for (Augment augment : augmentRepository_.findAll()) {
            System.out.println(augment);
        }
        System.out.println();
        */
        /*TODO: implement repo api.
        // fetch an individual augment by ID
        Augment augment = augmentRepository_.findOne(1L);
        System.out.println("Augment found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(augment);
        System.out.println();

        // fetch augments by title
        System.out.println("Augment found with findByTitle('Jack'):");
        System.out.println("--------------------------------------------");
        for (Augment jack : repository.findByName("Jack")) {
            System.out.println(jack);
        }*/
    }
    
}