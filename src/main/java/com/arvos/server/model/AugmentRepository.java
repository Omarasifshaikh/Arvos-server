package com.arvos.server.model;


public interface AugmentRepository {
	public Augment save(Augment entity);
	public Iterable<Augment> findAll();	
}
