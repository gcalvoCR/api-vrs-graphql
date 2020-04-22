package com.cenfotec.apivrsgraphql.domain;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;


@Data
public class Especie {
	
		//Attributes
		@Id
		public String id;
		public String nombre;
		public String autor;
		public String fecha;
		public String tipo;
		public String guid;
		
		
		//Constructors
		public Especie() {}
		
		public Especie(String nombre, String autor, String tipo) {
			super();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			this.nombre = nombre;
			this.autor = autor;
			this.tipo = tipo;
			this.fecha = formatter.format(date);
		}
		
		public Especie(String id, String nombre, String autor, String fecha, String tipo) {
			super();

			this.id = id;
			this.nombre = nombre;
			this.autor = autor;
			this.fecha = fecha;
			this.tipo = tipo;
			this.guid = guid;
		}
		
		public Especie(String nombre, String autor, String tipo, String guid) {
			super();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			this.nombre = nombre;
			this.autor = autor;
			this.tipo = tipo;
			this.guid = guid;
			this.fecha = formatter.format(date);
		}

		//getters and setters
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getAutor() {
			return autor;
		}
		public void setAutor(String autor) {
			this.autor = autor;
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

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((autor == null) ? 0 : autor.hashCode());
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((guid == null) ? 0 : guid.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
			result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Especie other = (Especie) obj;
			if (autor == null) {
				if (other.autor != null)
					return false;
			} else if (!autor.equals(other.autor))
				return false;
			if (fecha == null) {
				if (other.fecha != null)
					return false;
			} else if (!fecha.equals(other.fecha))
				return false;
			if (guid == null) {
				if (other.guid != null)
					return false;
			} else if (!guid.equals(other.guid))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nombre == null) {
				if (other.nombre != null)
					return false;
			} else if (!nombre.equals(other.nombre))
				return false;
			if (tipo == null) {
				if (other.tipo != null)
					return false;
			} else if (!tipo.equals(other.tipo))
				return false;
			return true;
		}	
		
}
