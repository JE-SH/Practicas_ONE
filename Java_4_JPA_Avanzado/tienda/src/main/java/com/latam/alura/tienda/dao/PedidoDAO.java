package com.latam.alura.tienda.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.vo.RelatorioDeVentas;

public class PedidoDAO {
private EntityManager em;
	
	public PedidoDAO(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Pedido pedido) {
		this.em.persist(pedido);
	}
	public void actualizar(Pedido pedido) {
		this.em.merge(pedido);
	}
	public Pedido consultaId(Long id) {
		return this.em.find(Pedido.class, id);
	}
	public List<Pedido> listarTodos(){
		String jpql = "SELECT P FROM Pedido AS P";
		return this.em.createQuery(jpql,Pedido.class).getResultList();
	}
	
	public BigDecimal ValorTotalVendido() {
		String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
	public BigDecimal ValorPromedioVendido() {
		String jpql = "SELECT AVG(p.valorTotal) FROM Pedido p";
		return em.createQuery(jpql,BigDecimal.class).getSingleResult();
	}
//	public List<Object[]> relatorioDeVentas(){
	public List<RelatorioDeVentas> relatorioDeVentasVO(){
		String jpql = "SELECT new com.latam.alura.tienda.vo.RelatorioDeVentas("
				+ "producto.nombre,SUM(item.cantidad),MAX(pedido.fecha)) "
				+ "FROM Pedido pedido "
				+ "JOIN pedido.itemsPedido item "
				+ "Join item.producto producto "
				+ "GROUP BY producto.nombre "
				+ "ORDER BY item.cantidad DESC";
		return em.createQuery(jpql,RelatorioDeVentas.class).getResultList();
	}
	public Pedido consultaPedidoConCliente(Long id) {
		String jpql="SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id=:id"; 
		return em.createQuery (jpql, Pedido.class).setParameter("id", id).getSingleResult();
	}


public List<Producto> consultarPorParametros(String nombre, BigDecimal precio,LocalDate fecha){
	CriteriaBuilder builder = em.getCriteriaBuilder();
	CriteriaQuery<Producto> query = builder.createQuery (Producto.class);
	 Root<Producto> from = query.from(Producto.class);
	 Predicate filtro = builder.and();
	 
	if(nombre!=null && !nombre.trim().isEmpty()) {
	    filtro=builder.and(filtro, builder.equal(from.get("nonbre"), nombre));
	 }
	if(precio!=null && !precio.equals(new BigDecimal(0))) {
	    filtro=builder.and(filtro, builder .equal(from.get("precio"), precio));
	 }
	if(fecha!=null){
	    filtro=builder.and(filtro,builder.equal(from.get("fechaDeRegistro"), fecha));
	query=query.where(filtro);
	}
	 return em.createQuery(query).getResultList();

/*StringBuilder jpql=new StringBuilder( "SELECT p FROM Producto p WHERE 1=1 ");
        if(nombre != null && !nombre.trim().isEmpty()) {
             jpql.append("AND p.nombre=:nombre ");
        if(precio != null && !precio.equals(new BigDecimal(0))) {
             jpql.append("AND p.precios:precio ");
        if(fecha !=null) {
             jpql.append("AND p. .fechaDeRegistro=:fecha");
         }
        TypedQuery<Producto>query = em.createQuery(jpql.toString(),Producto.class);

        if(nombre!=null && !nombre.trim().isEmpty()) {
             query.setParameter("nombre", nombre);
         }
        if(precio!= null && !precio.equals(new BigDecimal(0))) {
        	query.setParameter("precio", precio);
        }
        if(fecha !=null) {
            query.setParameter("fechaDeRegistro", fecha);
        }
         return query.getResultList();

*/
}
	


}
