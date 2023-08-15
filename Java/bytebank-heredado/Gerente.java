
public class Gerente extends Funcionario{
	
	private String clave="1234";
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	public boolean iniciarSesion(String contrasenia) {
		return (this.clave==contrasenia);
	}
	
	//@Override
	public double getBonificacion() {
		return super.getSalario();
	}
	
}
