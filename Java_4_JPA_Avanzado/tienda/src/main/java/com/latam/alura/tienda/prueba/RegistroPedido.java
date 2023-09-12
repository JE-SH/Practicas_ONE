package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.latam.alura.tienda.dao.CategoriaDAO;
import com.latam.alura.tienda.dao.ClienteDAO;
import com.latam.alura.tienda.dao.PedidoDAO;
import com.latam.alura.tienda.dao.ProductoDAO;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cliente;
import com.latam.alura.tienda.modelo.ItemsPedido;
import com.latam.alura.tienda.modelo.Pedido;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;
import com.latam.alura.tienda.vo.RelatorioDeVentas;

public class RegistroPedido {

	public static void main(String[] args) {
		crearProducto();
		
		EntityManager em = JPAUtils.getEntityManager();//factory.createEntityManager();
		Cliente cliente = new Cliente("Juan", "n4568489");
		Pedido pedido = new Pedido(cliente);	
		
		PedidoDAO pedidoDao = new PedidoDAO(em);
		ClienteDAO clienteDao = new ClienteDAO(em);
		ProductoDAO productodao = new ProductoDAO(em);

		Producto producto = productodao.consultaId(1l);
		pedido.agregarItems(new ItemsPedido(5,producto,pedido));

		
		em.getTransaction().begin();
		
		pedidoDao.guardar(pedido);
		clienteDao.guardar(cliente);
		BigDecimal VT = pedidoDao.ValorTotalVendido();
		System.out.println("ValorTotal: "+VT);
		/*List<Object[]> relatorio =pedidoDao.relatorioDeVentas();
		
		for(Object[] obj :relatorio) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		}*/
		List<RelatorioDeVentas> relatorio = pedidoDao.relatorioDeVentasVO();
		relatorio.forEach(System.out::println);
		
		em.getTransaction().commit();
		em.close();
	
	}

	private static void crearProducto() {
		Categoria celulares = new Categoria("CELULARES");
		Producto celular = new Producto("Alcatel", 
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
