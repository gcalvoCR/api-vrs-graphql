package com.cenfotec.apivrsgraphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cenfotec.apivrsgraphql.domain.Especie;
import com.cenfotec.apivrsgraphql.repository.EspecieRepository;

@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired
	EspecieRepository especieRepo;

	@Override
	public Especie saveEspecie(Especie especie) {
		return especieRepo.save(especie);
	}

	@Override
	public Optional<Especie> getEspecie(String id) {
		return especieRepo.findById(id);
	}

	@Override
	public List<Especie> getEspecies() {
		return especieRepo.findAll();
	}

	@Override
	public boolean deleteEspecie(String id) {
		Optional<Especie> especie = getEspecie(id);
		especieRepo.deleteById(id);
		return especie.isPresent();
	}

	@Override
	public Especie updateEspecie(String id, Especie especie) {
		return getEspecie(id).map(record -> {
			record.setEspecie(especie.getEspecie());
			record.setNombre(especie.getNombre());
			record.setFecha(especie.getFecha());
			record.setTipo(especie.getTipo());
			record.setGuid(especie.getGuid());
			Especie updated = saveEspecie(record);
			return updated;
		}).orElse(null);
	}

}
