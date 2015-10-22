package com.arvos.server.model;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
@Transactional
public interface DirectoryDao extends CrudRepository<Directory, Long> {
	
	  public Directory findByName(String name);
	  public List<Directory> findAll();
}
