package com.arvos.server;

import java.util.Collection;


import com.arvos.server.model.Augment;

import retrofit.http.GET;

public interface AugmentSvcApi {

	public static final String AUGMENT_SVC_PATH = "/directory-service";
	
	public static final String AUGMENT_TEST_PATH = "/augmentTest";
	public static final String AUGMENT_CREATE_PATH = "/augmentCreate";

	@GET(AUGMENT_TEST_PATH)
    public Augment augmentTest(String name);
	
	@GET(AUGMENT_SVC_PATH)
	public Collection<Augment> getAugmentList();
	
	@GET(AUGMENT_CREATE_PATH)
	public String createAugment(String name);
	
	/*
	@GET(AUGMENT_SVC_PATH)
	public Collection<Augment> getAugments(Long id, double lat, double lon, double alt, double azi, String ver, String plat, String dkey);
	*/
}