package com.arvos.server.data;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.arvos.server.model.*;

public interface AugmentRepository extends CrudRepository<Augment, Long>   {
	List<Augment> findByName(String name);
	List<Augment> findAll();
}
