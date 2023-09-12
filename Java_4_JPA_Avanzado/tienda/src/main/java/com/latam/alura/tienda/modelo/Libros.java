package com.latam.alura.tienda.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="electronicos")
public class Libros extends Producto{
	String marca;
	String modelo; 
	
public Libros() {
	// TODO Auto-generated constructor stub
}

public Libros(String marca, String modelo) {
	this.marca = marca;
	this.modelo = modelo;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}

public String getModelo() {
	return modelo;
}

public void setModelo(String modelo) {
	this.modelo = modelo;
}

}
