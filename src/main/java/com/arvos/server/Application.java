package com.arvos.server;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.arvos.server.data.AugmentRepository;
import com.arvos.server.model.Augment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
    AugmentRepository repository;
	
	//Maximum request(augment) size for multi-part support.
	private static final String MAX_AUGMENT_SIZE = "50MB";
	
	
	//Simple Spring boot applicaiton class.
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    
    
    
    
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
        for (Augment jack : repository.findByTitle("Jack")) {
            System.out.println(jack);
        }
    }
    
    
    
    
    
    
/*
    //Adding support for Multi-part file transfers from/to client.
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        final MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(MAX_AUGMENT_SIZE);
        factory.setMaxRequestSize(MAX_AUGMENT_SIZE);
        return factory.createMultipartConfig();
    }
*/
}