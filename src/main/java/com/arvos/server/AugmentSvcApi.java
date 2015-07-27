package com.arvos.server;

import java.util.List;

import com.arvos.server.model.Augment;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface AugmentSvcApi {

	public static final String AUGMENT_SVC_PATH = "/directory-service";
	public static final String AUGMENT_TEST_PATH = "/augmentTest";

	@GET(AUGMENT_SVC_PATH)
	public List<Augment> getAugmentList();
	
}
