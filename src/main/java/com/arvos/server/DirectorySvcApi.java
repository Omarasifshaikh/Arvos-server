package com.arvos.server;

import java.util.Collection;


import com.arvos.server.model.Augment;
import com.arvos.server.model.Directory;

import retrofit.http.GET;

public interface DirectorySvcApi {

	public static final String DIRECTORY_SVC_PATH = "/directory-service";
	
	public static final String DIRECTORY_TEST_PATH = "/directoryTest";
	public static final String DIRECTORY_CREATE_PATH = "/directoryCreate";
	

	@GET(DIRECTORY_TEST_PATH)
    public Directory directoryTest(String name);
	
	@GET(DIRECTORY_SVC_PATH)
	public Collection<Directory> getDirectoryList();
	/*
	@GET(DIRECTORY_CREATE_PATH)
	public String createAugment(String name);
	
	*/
	/*
	@GET(DIRECTORY_SVC_PATH)
	public Collection<Augment> getAugments(Long id, double lat, double lon, double alt, double azi, String ver, String plat, String dkey);
	*/
}