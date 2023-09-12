
public class Contador extends Funcionario implements Autenticable{

	private AutenticacionUtil util;
	//private String clave="1234";
	
	public Contador() {
		this.util= new AutenticacionUtil();
	}
	
	@Override
	public double getBonificacion() {
		// TODO Auto-generated method stub
		return 200;
	}
	
	@Override
	public void setClave(String clave) {
		this.util.setClave(clave);
	}
	@Override
	public boolean iniciarSesion(String clave) {
		return this.util.iniciarSesion(clave);
	}
/*
	@Override
	public void setClave(String clave) {
		this.clave=clave;
	}

	@Override
	public boolean iniciarSesion(String clave) {
		if(this.clave==clave)
			return true;
		else
			return false;
	}
	*/
	
}
