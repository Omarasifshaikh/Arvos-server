package com.arvos.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arvos.server.AugmentSvcApi;
import com.arvos.server.model.Augment;
import com.arvos.server.model.AugmentRepository;
import com.google.common.collect.Lists;

@Controller
public class AugmentController {
	
	@Autowired
	private AugmentRepository augmentRepository_;
	
    @RequestMapping("/")
    public @ResponseBody String index() {
        return "Welcome to the Arvos Server.";
    }
    
    @RequestMapping(value=AugmentSvcApi.AUGMENT_TEST_PATH, method=RequestMethod.GET)
    public @ResponseBody Augment augmentTest(@RequestParam(value="name", defaultValue="Arvos_augment") String name){
    	return new Augment(
                String.format("Augment Test title:, %s!", name));
    }
    
    //TODO - Create Augments list as per specification here: https://github.com/peterGraf/ARVOS/wiki/ARVOS-Directory-Service.
    @RequestMapping(value=AugmentSvcApi.AUGMENT_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Augment> getAugmentList() {
		return Lists.newArrayList(augmentRepository_.findAll());
	}
}