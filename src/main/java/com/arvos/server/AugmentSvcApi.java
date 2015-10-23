package com.arvos.server;

import java.util.Collection;


import com.arvos.server.model.Augment;

import retrofit.http.GET;
import retrofit.http.POST;

public interface AugmentSvcApi {

	public static final String AUGMENT_TEST_PATH = "/augmentTest";

	public static final String AUGMENT_SVC_PATH = "/augments";
	public static final String AUGMENT_SEARCH_PATH = "/augments/search";
	
	public static final String AUGMENT_CREATE_PATH = "/augment/create";
	public static final String AUGMENT_DELETE_PATH = "/augment/delete/{id}";

	@GET(AUGMENT_TEST_PATH)
    public Augment augmentTest(String name);
	
	
	@GET(AUGMENT_SVC_PATH)
	public Collection<Augment> getAugmentList();
	
	@GET(AUGMENT_SEARCH_PATH)
	public Collection<Augment> searchAugments(Long id, double lat, double lon, double alt, double azi, String ver, String plat, String dkey);	
	
	@GET(AUGMENT_CREATE_PATH)
	public String createAugment(String name);

	@GET(AUGMENT_DELETE_PATH)
	public String deleteAugment(Long id);

}