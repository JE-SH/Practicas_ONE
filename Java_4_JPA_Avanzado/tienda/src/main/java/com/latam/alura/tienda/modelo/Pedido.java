package com.latam.alura.tienda.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDate fecha = LocalDate.now();
	private BigDecimal valorTotal= new BigDecimal(0);
	@ManyToOne(fetch = FetchType.LAZY)
	private Cliente cliente;
	
//	@ManyToMany
//	@JoinTable(name="items_pedidos")
//	private List<Producto>productos;
	@OneToMany(mappedBy="pedido",cascade=CascadeType.ALL)
	List<ItemsPedido>itemsPedido = new ArrayList<ItemsPedido>();


	
	public Pedido() {
		
	}
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void agregarItems(ItemsPedido item) {
		item.setPedido(this);
		this.itemsPedido.add(item);
		this.valorTotal = this.valorTotal.add(item.getValor());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) { //******
		this.id = id;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
}
