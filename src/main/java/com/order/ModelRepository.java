package com.order;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ModelRepository extends CrudRepository<Model, Integer>{

}