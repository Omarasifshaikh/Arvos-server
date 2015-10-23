package com.arvos.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.arvos.server.model.Augment;
import com.arvos.server.model.AugmentDao;
import com.arvos.server.model.Directory;
import com.arvos.server.model.DirectoryDao;
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {
	
	@Autowired
	private AugmentDao augmentDao;
	@Autowired
	private DirectoryDao directoryDao;
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
	//Spring boot application class.
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
    
    //Testing In-memory persistence
    @Override
    public void run(String... strings) throws Exception {
        // save a couple of augments
    	augmentDao.save(new Augment("Aug1", "Augment1"));
    	augmentDao.save(new Augment("Aug2", "Augment2"));
    	augmentDao.save(new Augment("Aug3", "Augment3"));
    	augmentDao.save(new Augment("Aug3", "Augment4"));
    	augmentDao.save(new Augment("Aug4", "Augment5"));

    	

    	directoryDao.save(new Directory("dir1"));
    	directoryDao.save(new Directory("dir2"));
    	directoryDao.save(new Directory("dir3"));
    	directoryDao.save(new Directory("dir4"));
    	directoryDao.save(new Directory("dir5"));
    	
    	
        // fetch all augments
        System.out.println("Augments found with findAll():");
        System.out.println("-------------------------------");
        for (Augment augment : augmentDao.findAll()) {
            System.out.println(augment);
        }
        // fetch all augments
        System.out.println("Directories found with findAll():");
        System.out.println("-------------------------------");
        for (Directory dir : directoryDao.findAll()) {
            System.out.println(dir);
        }
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