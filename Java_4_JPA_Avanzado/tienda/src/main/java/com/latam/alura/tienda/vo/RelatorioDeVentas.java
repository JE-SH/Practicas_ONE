package com.latam.alura.tienda.vo;

import java.time.LocalDate;

public class RelatorioDeVentas {
	String nombreDelProducto;
	Long cantidadDelProducto;
	LocalDate fechaUltimaVenta;
	
	public RelatorioDeVentas(String nombreDelProducto, Long cantidadDelProducto, LocalDate fechaUltimaVenta) {
		this.nombreDelProducto = nombreDelProducto;
		this.cantidadDelProducto = cantidadDelProducto;
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	public String getNombreDelProducto() {
		return nombreDelProducto;
	}

	public void setNombreDelProducto(String nombreDelProducto) {
		this.nombreDelProducto = nombreDelProducto;
	}

	public Long getCantidadDelProducto() {
		return cantidadDelProducto;
	}

	public void setCantidadDelProducto(Long cantidadDelProducto) {
		this.cantidadDelProducto = cantidadDelProducto;
	}

	public LocalDate getFechaUltimaVenta() {
		return fechaUltimaVenta;
	}

	public void setFechaUltimaVenta(LocalDate fechaUltimaVenta) {
		this.fechaUltimaVenta = fechaUltimaVenta;
	}

	@Override
	public String toString() {
		return "RelatorioDeVentas [nombreDelProducto=" + nombreDelProducto + ", cantidadDelProducto="
				+ cantidadDelProducto + ", fechaUltimaVenta=" + fechaUltimaVenta + "]";
	}
	
	
}
