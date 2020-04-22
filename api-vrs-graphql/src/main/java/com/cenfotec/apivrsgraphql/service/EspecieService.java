package com.cenfotec.apivrsgraphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cenfotec.apivrsgraphql.domain.Especie;

public interface EspecieService {

	public Especie saveEspecie(Especie especie);
	
	public Optional<Especie> getEspecieById(String id);
	
	public Optional<Especie> getEspecieByGuid(String guid);

	public List<Especie> getEspecies();

	public Especie updateEspecie(String id, Especie especie);
	
	public boolean deleteEspecie(String id);
	

}
