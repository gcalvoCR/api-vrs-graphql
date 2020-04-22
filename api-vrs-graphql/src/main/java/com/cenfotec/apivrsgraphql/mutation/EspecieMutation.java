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
	
	public Especie createEspecie(String nombre, String autor, String tipo) {
		Especie nueva = new Especie(nombre, autor, tipo);
		return service.saveEspecie(nueva);
	}

	public Especie updateEspecie(String id, String nombre, String autor, String fecha, String tipo) {
		Especie o = new Especie(id, nombre, autor, fecha, tipo);
		return  service.updateEspecie(id, o);

	}

	public boolean deleteEspecie(String id) {
		return service.deleteEspecie(id); 
	}

}
