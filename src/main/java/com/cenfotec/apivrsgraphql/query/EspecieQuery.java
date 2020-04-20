package com.cenfotec.apivrsgraphql.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.apivrsgraphql.domain.Especie;
import com.cenfotec.apivrsgraphql.service.EspecieService;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class EspecieQuery implements GraphQLQueryResolver{
	
	@Autowired
	private EspecieService service;
	
	public List<Especie> getEspecies() {
		return service.getEspecies();
	}


	public Optional<Especie> getEspecie(String id) {
		return service.getEspecie(id);
	}
	

}

