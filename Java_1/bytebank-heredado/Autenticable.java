
public /*abstract*/ interface Autenticable{ /*extends Funcionario { */
	//UNA INTERFAZ SOLO PUEDE EXTENDER DE OTRA INTERFAZ, 
	
	//TODOS LOS MÉTODOS SON ABSTRACTOS EN LA INTERFAZ,NO ESTÁ IMPLEMENTADO
	
	//private String clave;
	
	// ^ SE OMITE YA QUE NO ES POSIBLE ACCESAR AL ATRIBUTO PORQUE 
	//NO HAY CUERPO
	
	//POR DEFECTO TODOS LOS MÉTODOS SON ABSTRACTOS
	public /*abstract */void setClave(String clave);
	public /*abstract*/ boolean iniciarSesion(String clave);

}
