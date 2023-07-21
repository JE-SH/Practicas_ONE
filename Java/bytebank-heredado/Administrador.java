
public class Administrador extends Funcionario implements Autenticable{

	private AutenticacionUtil util;
	//private String clave="1234";
	
	public Administrador() {
		this.util= new AutenticacionUtil();
	}
	
	@Override
	public void setClave(String clave) {
		this.util.setClave(clave);
	}
	@Override
	public boolean iniciarSesion(String clave) {
		return this.util.iniciarSesion(clave);
	}
	
	@Override
	public double getBonificacion() {
		return this.getSalario();
	}
	
}
