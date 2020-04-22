package com.cenfotec.apivrsgraphql.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenfotec.apivrsgraphql.domain.Especie;
import com.cenfotec.apivrsgraphql.repository.EspecieRepository;

@Service
public class EspecieServiceImpl implements EspecieService {

	@Autowired
	EspecieRepository especieRepo;

	@Override
	public Especie saveEspecie(Especie especie) {
		try {
			String guid = getGuid();
			String fecha = getFecha();
			especie.setGuid(guid);
			especie.setFecha(fecha);
		}
		catch(Exception e)
		{
			throw e;
		}
		return especieRepo.save(especie);
	}

	@Override
	public Optional<Especie> getEspecieById(String id) {
		return especieRepo.findById(id);
	}
	
	@Override
	public Optional<Especie> getEspecieByGuid(String guid) {
		return especieRepo.findByGuid(guid);
	}

	@Override
	public List<Especie> getEspecies() {
		return especieRepo.findAll();
	}

	@Override
	public boolean deleteEspecie(String id) {
		Optional<Especie> especie = getEspecieById(id);
		especieRepo.deleteById(id);
		return especie.isPresent();
	}

	@Override
	public Especie updateEspecie(String id, Especie especie) {
		return getEspecieById(id).map(record -> {
			record.setNombre(especie.getNombre());
			record.setAutor(especie.getAutor());
			record.setFecha(especie.getFecha());
			record.setTipo(especie.getTipo());
			Especie updated = saveEspecie(record);
			return updated;
		}).orElse(null);
	}

	private String getGuid()
	  {
		String results = "";
	    try
	    {
	      String myUrl = "http://localhost:8081/guid";
	      results = doHttpUrlConnectionAction(myUrl);
	    }
	    catch (Exception e)
	    {
	    	throw new RuntimeException("servidor de GUID no disponible");
	    }
	    results = results.replace("\n", "");
	    return results;
	  }

	private String doHttpUrlConnectionAction(String desiredUrl) throws Exception {
		URL url = null;
		BufferedReader reader = null;
		StringBuilder stringBuilder;

		try {
			//HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");

			connection.setReadTimeout(15 * 1000);
			connection.connect();

			//leer el output
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					throw ioe;
				}
			}
		}
	}

	private String getFecha() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return formatter.format(date);
	}

}
