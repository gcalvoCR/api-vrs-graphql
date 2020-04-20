package com.cenfotec.apivrsgraphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.apivrsgraphql.domain.Especie;
import com.cenfotec.apivrsgraphql.service.EspecieService;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class EspecieMutation implements GraphQLMutationResolver{
	
	@Autowired
	private EspecieService service;
	
	public Especie createEspecie(String especie, String nombre, String fecha, String tipo, String guid) {
		Especie nueva = new Especie(especie, nombre, fecha, tipo, guid);
		return service.saveEspecie(nueva);
	}

//	public ResponseEntity<Especie> update(Especie especie) {
//		Especie record =  service.updateEspecie(especie.id, especie);
//		if(record!=null) {
//			return ResponseEntity.ok().body(record);
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}
//
//	public ResponseEntity<?> delete(String id) {
//		if(service.deleteEspecie(id)) {
//			return (ResponseEntity<?>) ResponseEntity.ok();
//		} else {
//			return ResponseEntity.notFound().build();
//		}
//	}

}
