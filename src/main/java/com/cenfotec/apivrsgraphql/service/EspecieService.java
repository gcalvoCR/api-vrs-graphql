package com.cenfotec.apivrsgraphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cenfotec.apivrsgraphql.domain.Especie;

public interface EspecieService {

	public Especie saveEspecie(Especie especie);
	
	public Optional<Especie> getEspecie(String id);

	public List<Especie> getEspecies();

	public ResponseEntity<Especie> updateEspecie(String id, Especie especie);
	
	public ResponseEntity<?> deleteEspecie(String id);

}
