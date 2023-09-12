package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.Producto;

public class ClienteDAO {
	private EntityManager em;
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Cliente cliente) {
		this.em.persist(cliente);
	}
	public void actualizar(Cliente cliente) {
		this.em.merge(cliente);
	}
	public Cliente consultaId(Long id) {
		return this.em.find(Cliente.class, id);
	}
	public List<Cliente> listarTodos(){
		String jpql = "SELECT P FROM Cliente AS P";
		return this.em.createQuery(jpql,Cliente.class).getResultList();
	}
	
	public List<Cliente> consultaPorNombres(String nombre){
		String jpql = "SELECT P FROM Cliente AS P WHERE P.nombre=:nombre";
		return em.createNamedQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	public List<Cliente> consultaPorNombreCategoria(String nombre){
		String jpql = "SELECT P FROM Cliente P WHERE P.categoria.nombre=:nombre";
		return em.createQuery(jpql,Cliente.class).setParameter("nombre", nombre).getResultList();
	}
	public BigDecimal consultarPrecioPorNombreCliente(String nombre) {
		String jpql = "SELECT p.precio FROM Cliente AS p WHERE p.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
