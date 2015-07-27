package com.arvos.server.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryAugmentRepository implements AugmentRepository{
	//An Atomic counter that helps store unique Id's for each Augment
	private static final AtomicLong currentId = new AtomicLong(0L);
	
	private Map<Long,Augment> augments_ = new ConcurrentHashMap<>();
	
	private void checkAndSetId(Augment entity) {
        if(entity.getId() == 0){
            entity.setId(currentId.incrementAndGet());
        }
    }
	
	@Override
	public Iterable<Augment> findAll() {
		return augments_.values();
	}

	@Override
	public Augment save(Augment entity) {
		checkAndSetId(entity);
		augments_.put(entity.getId(), entity);
		return entity;
	}

}
