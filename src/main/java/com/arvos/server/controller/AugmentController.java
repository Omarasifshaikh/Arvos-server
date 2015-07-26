package com.arvos.server.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arvos.server.model.Augment;

@RestController
public class AugmentController {

	private static final String template = "Augment name, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	
    @RequestMapping("/")
    public String index() {
        return "Welcome to the Arvos Server.";
    }

    @RequestMapping("/augments")
    public Augment augments(@RequestParam(value="name", defaultValue="Arvos_augment") String name){
    	return new Augment(
                String.format(template, name));
    }

}