package com.cenfotec.apivrsgraphql.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.apivrsgraphql.domain.Especie;

@Repository
public interface EspecieRepository extends MongoRepository<Especie, String>{
	
	Optional<Especie> findByGuid(String guid);

}
