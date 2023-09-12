package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String dni;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public Cliente(String nombre,String dni) {
		this.nombre = nombre;
		this.dni=dni;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) { //********
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return this.dni;
	}
	public void setDescripcion(String dni) {
		this.dni = dni;
	}
	
}
