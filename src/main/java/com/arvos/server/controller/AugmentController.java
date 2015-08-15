package com.arvos.server.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arvos.server.AugmentSvcApi;
import com.arvos.server.model.Augment;
import com.arvos.server.model.AugmentDao;
import com.google.common.collect.Lists;

@Controller
public class AugmentController implements AugmentSvcApi{
	
	@Autowired
	private AugmentDao augmentDao;
	
    
    @RequestMapping(value=AugmentSvcApi.AUGMENT_TEST_PATH, method=RequestMethod.GET)
    public @ResponseBody Augment augmentTest(@RequestParam(value="name", defaultValue="Arvos_augment") String name){
    	return new Augment(
                String.format("Augment Test title:, %s!", name));
    }
    @RequestMapping(value=AugmentSvcApi.AUGMENT_CREATE_PATH, method=RequestMethod.GET)
    public @ResponseBody String createAugment(String name) {
      Augment aug = null;
      try {
        aug = new Augment(name);
        augmentDao.save(aug);
      }
      catch (Exception ex) {
        return "Error creating the user: " + ex.toString();
      }
      return "User succesfully created! (id = " + aug.getId() + ")";
    }
    
    //Augments list as per specification here: https://github.com/peterGraf/ARVOS/wiki/ARVOS-Directory-Service.
    @RequestMapping(value=AugmentSvcApi.AUGMENT_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Augment> getAugmentList() {
		return Lists.newArrayList(augmentDao.findAll());
	}
    
    
    
    
    
    
    /*
    //Client request with optional parameters as per: https://github.com/peterGraf/ARVOS/wiki/ARVOS-Directory-Service
    @RequestMapping(value=AugmentSvcApi.AUGMENT_SVC_PATH, method=RequestMethod.POST)
	public @ResponseBody Collection<Augment> getAugments(
			@RequestParam(value="id",required = false)Long id,
			@RequestParam(value="lat",required = false) double lat,
			@RequestParam(value="lon",required = false) double lon,
			@RequestParam(value="alt",required = false) double alt,
			@RequestParam(value="azi",required = false) double azi,
			@RequestParam(value="ver",required = false) String ver,
			@RequestParam(value="plat",required = false) String plat,
			@RequestParam(value="plat",required = false) String dkey
			) {
		//TODO -Implement the query Logic here.
    	return Lists.newArrayList(augmentRepository_.findAll());
		
	}
    
    */
    
    //START OF MVC
    
    @RequestMapping(value="/greeting", method=RequestMethod.GET)
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
}