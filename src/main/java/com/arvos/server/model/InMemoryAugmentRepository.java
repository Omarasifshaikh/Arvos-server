package com.arvos.server.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAugmentRepository implements AugmentRepository{

	
	private Map<Long,Augment> augments_ = new ConcurrentHashMap<>();
	
	@Override
	public Iterable<Augment> findAll() {
		return augments_.values();
	}

	@Override
	public Augment save(Augment entity) {
		augments_.put(entity.getId(), entity);
		return entity;
	}

}
