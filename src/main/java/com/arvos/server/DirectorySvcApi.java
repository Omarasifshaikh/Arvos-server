package com.arvos.server;

import java.util.Collection;


import com.arvos.server.model.Augment;
import com.arvos.server.model.Directory;

import retrofit.http.GET;
import retrofit.http.POST;

public interface DirectorySvcApi {

	public static final String DIRECTORY_TEST_PATH = "/directoryTest";

	public static final String DIRECTORY_SVC_PATH = "/directory-service";
	public static final String DIRECTORY_SEARCH_PATH = "/directory-service/search";
	
	public static final String DIRECTORY_CREATE_PATH = "/directory/create";
	public static final String DIRECTORY_UPDATE_PATH = "/directory/update/{id}";
	public static final String DIRECTORY_DELETE_PATH = "/directory/delete/{id}";

	@GET(DIRECTORY_TEST_PATH)
    public Directory directoryTest(String name);
	
	@GET(DIRECTORY_SVC_PATH)
	public Collection<Directory> getDirectoryList();
	
	@GET(DIRECTORY_SEARCH_PATH)
	public Collection<Directory> getDirectories(Long id, double lat, double lon, double alt, double azi, String ver, String plat, String dkey);
	
	@GET(DIRECTORY_CREATE_PATH)
	public String createDirectory(String name);
	
	@GET(DIRECTORY_UPDATE_PATH)
	public String updateDirectory(Long id, double lat, double lon, double alt, double azi, String ver, String plat, String dkey);
	
	@GET(DIRECTORY_DELETE_PATH)
	public String deleteDirectory(Long id);
}