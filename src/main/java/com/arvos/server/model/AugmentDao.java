package com.arvos.server.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface AugmentDao extends CrudRepository<Augment, Long> {
	
	  public Augment findByName(String name);
	  public List<Augment> findAll();
}
