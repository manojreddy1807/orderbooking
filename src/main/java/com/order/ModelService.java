package com.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

 
@Service
public class ModelService {
 
    // @Autowired annotation provides the automatic dependency injection.
    @Autowired
    ModelRepository repository;
	private final Logger log = LoggerFactory.getLogger(this.getClass()); 

    // Save student entity in the h2 database.
    public void save(final Model model) {
    	log.info("Saving order details in the database."+model);
    	repository.save(model);
    }
 
    // Get all students from the h2 database.
    public List<Model> getAll() {
        final List<Model> models = new ArrayList<>();
        repository.findAll().forEach(model -> models.add(model));
    	log.info("Reteiving order details in the database."+models);
        return models;
    }
    
    public Optional<Model> getbyId(Integer id) {
       
        return repository.findById(id);
    }
}

