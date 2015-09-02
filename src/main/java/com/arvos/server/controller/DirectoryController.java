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
import com.arvos.server.DirectorySvcApi;
import com.arvos.server.model.Augment;
import com.arvos.server.model.AugmentDao;
import com.arvos.server.model.Directory;
import com.arvos.server.model.DirectoryDao;
import com.google.common.collect.Lists;

@Controller
public class DirectoryController implements DirectorySvcApi{
	
	@Autowired
	private DirectoryDao directoryDao;
	
    
    @RequestMapping(value=DirectorySvcApi.DIRECTORY_TEST_PATH, method=RequestMethod.GET)
    public @ResponseBody Directory directoryTest(@RequestParam(value="name", defaultValue="Arvos_directory") String name){
    	return new Directory(
                String.format("Directory Test title:, %s!", name));
    }
/*
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
    
    
    */
    
    //Augments list as per specification here: https://github.com/peterGraf/ARVOS/wiki/ARVOS-Directory-Service.
    @RequestMapping(value=DirectorySvcApi.DIRECTORY_SVC_PATH, method=RequestMethod.GET)
	public @ResponseBody Collection<Directory> getDirectoryList() {
		return Lists.newArrayList(directoryDao.findAll());
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
    
    
    
    
}