package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.Categoria;
import com.latam.alura.tienda.Producto;
import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		crearProducto();
		EntityManager em = JPAUtils.getEntityManager();//factory.createEntityManager();
		ProductoDAO productodao = new ProductoDAO(em);
		
		Producto prod = productodao.consultaId(1l);
		System.out.println(prod.getNombre());
		
		/*List<Producto>*/BigDecimal product = productodao.consultarPrecioPorNombreProducto("Pillofon");
		System.out.println(product);
		//product.forEach(pr->System.out.println(pr.getDescripcion()+"|"+pr.getNombre()));
	}

	private static void crearProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Pillofon", 
				"Telefono usado",
				new BigDecimal(4000),
				celulares);
	
		
		//Encargada de realizar operaciones de sql
		//crea clase que se guarda dentro de la interfaz
		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");//Tomada del archhivo persistence
		EntityManager em = JPAUtils.getEntityManager();//factory.createEntityManager();
		ProductoDAO productodao = new ProductoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.guardar(celulares);
		productodao.guardar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
