package com.cenfotec.apivrsgraphql.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.apivrsgraphql.domain.Especie;
import com.cenfotec.apivrsgraphql.errorhandling.GuidNotFoundException;
import com.cenfotec.apivrsgraphql.service.EspecieService;


@RestController
@RequestMapping({ "/especies" })
public class EspecieController {

	@Autowired
	private EspecieService service;


	@GetMapping
	public List<Especie> findAll() {
		return service.getEspecies();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Especie> findById(@PathVariable String id) {
		return service.getEspecieById(id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "/guid/{guid}" })
	public ResponseEntity<Especie> findByGuid(@PathVariable String guid) {
		return service.getEspecieByGuid(guid).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Especie> create(@RequestBody Especie especie) throws GuidNotFoundException {
		try {
			Especie record =  service.saveEspecie(especie);	
			return ResponseEntity.ok().body(record);
		}
		catch(Exception e) {
			if(e.getMessage().equals("servidor de GUID no disponible")) {
				throw new GuidNotFoundException("El servidor de GUID no disponible");
			}
			else {
				return ResponseEntity.status(500).build();
			}
		}
		
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Especie> update(@PathVariable("id") String id, @RequestBody Especie especie) {
		Especie record =  service.updateEspecie(id, especie);
		if(record!=null) {
			return ResponseEntity.ok().body(record);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		if(service.deleteEspecie(id)) {
			return ResponseEntity.accepted().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
	
