package com.cenfotec.apivrsgraphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cenfotec.apivrsgraphql.domain.Especie;

public interface EspecieRepository extends MongoRepository<Especie, String>{
	

}
