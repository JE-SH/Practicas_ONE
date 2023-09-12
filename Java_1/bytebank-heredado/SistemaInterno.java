
public class SistemaInterno {
	private String clave = "1234";
	
	public boolean autentica(Gerente gerente) {
		if (gerente.iniciarSesion(clave)) {
            System.out.println("Puede entrar al sistema");
			return true;
		}
		else {
            System.out.println("No puede entrar al sistema");
			return false;
		}
	}
	
}
