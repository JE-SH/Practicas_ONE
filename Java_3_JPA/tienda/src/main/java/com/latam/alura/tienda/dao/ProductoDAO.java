package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.latam.alura.tienda.Producto;

public class ProductoDAO {
	private EntityManager em;
	
	public ProductoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Producto producto) {
		this.em.persist(producto);
	}
	public Producto consultaId(Long id) {
		return this.em.find(Producto.class, id);
	}
	public List<Producto> listarTodos(){
		String jpql = "SELECT P FROM Producto AS P";
		return this.em.createQuery(jpql,Producto.class).getResultList();
	}
	
	public List<Producto> consultaPorNombres(String nombre){
		String jpql = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
		return em.createNamedQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	public List<Producto> consultaPorNombreCategoria(String nombre){
		String jpql = "SELECT P FROM Producto P WHERE P.categoria.nombre=:nombre";
		return em.createQuery(jpql,Producto.class).setParameter("nombre", nombre).getResultList();
	}
	public BigDecimal consultarPrecioPorNombreProducto(String nombre) {
		String jpql = "SELECT p.precio FROM Producto AS p WHERE p.nombre=:nombre";
		return em.createQuery(jpql,BigDecimal.class).setParameter("nombre", nombre).getSingleResult();
	}
}
