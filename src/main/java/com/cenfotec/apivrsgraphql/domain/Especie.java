package com.cenfotec.apivrsgraphql.domain;


import org.springframework.data.annotation.Id;

import lombok.Data;


@Data
public class Especie {
	
		//Attributes
		@Id
		public String id;
		public String especie;
		public String nombre;
		public String fecha;
		public String tipo;
		public String guid;
		
		
		//Constructors
		public Especie() {}
		
		
		public Especie(String especie, String nombre, String fecha, String tipo, String guid) {
			this.especie = especie;
			this.nombre = nombre;
			this.fecha = fecha;
			this.tipo = tipo;
			this.guid = guid;
		}
		
		//getters and setters
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getEspecie() {
			return especie;
		}
		public void setEspecie(String especie) {
			this.especie = especie;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getGuid() {
			return guid;
		}
		public void setGuid(String guid) {
			this.guid = guid;
		}
		
		
		
}
