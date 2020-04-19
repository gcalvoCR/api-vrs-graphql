package com.cenfotec.apivrsgraphql.service;

import java.util.Optional;

import com.cenfotec.apivrsgraphql.domain.Especie;

public interface EspecieService {

	public Especie saveEspecie(Especie especie);

	public Optional<Especie> listAllEspecies();

	public void deleteEspecie(Especie especie);

	public Especie updateEspecie(Especie especie);

}
