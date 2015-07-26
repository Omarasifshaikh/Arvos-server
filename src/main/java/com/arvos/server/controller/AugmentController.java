package com.arvos.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arvos.server.data.AugmentRepository;
import com.arvos.server.model.Augment;

@RestController
public class AugmentController {
	
	@Autowired
    AugmentRepository repository;
	
    @RequestMapping("/")
    public String index() {
        return "Welcome to the Arvos Server.";
    }

    @RequestMapping("/augmentTest")
    public Augment augmentTest(@RequestParam(value="name", defaultValue="Arvos_augment") String name){
    	return new Augment(
                String.format("Augment Test title, %s!", name));
    }
    
    //TODO - Create Augments list as per specification here: https://github.com/peterGraf/ARVOS/wiki/ARVOS-Directory-Service.
    @RequestMapping(value="/directory-service", method=RequestMethod.GET)
    public @ResponseBody Collection<Augment> getAugmentsList(){
    	//return list of all augments here
    	return repository.findAll();
    	
    }
}