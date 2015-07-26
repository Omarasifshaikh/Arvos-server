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
	
	//Maximum request size.
	private static final String MAX_AUGMENT_SIZE = "50MB";

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        /*Display all beans
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        */
    }
    
    
    
    
    
    @Override
    public void run(String... strings) throws Exception {
        // save a couple of customers
        repository.save(new Augment("Jack", "Bauer"));
        repository.save(new Augment("Chloe", "O'Brian"));
        repository.save(new Augment("Kim", "Bauer"));
        repository.save(new Augment("David", "Palmer"));
        repository.save(new Augment("Michelle", "Dessler"));

        // fetch all customers
        System.out.println("Augments found with findAll():");
        System.out.println("-------------------------------");
        for (Augment augment : repository.findAll()) {
            System.out.println(augment);
        }
        System.out.println();

        // fetch an individual customer by ID
        Augment augment = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(augment);
        System.out.println();

        // fetch customers by last name
        System.out.println("Customer found with findByTitle('Jack'):");
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