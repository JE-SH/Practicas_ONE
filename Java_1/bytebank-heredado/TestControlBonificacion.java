
public class TestControlBonificacion {
	public static void main(String[] args) {
		Funcionario diego = new Contador();
		diego.setSalario(2000);
		
		Gerente jimena = new Gerente();
		jimena.setSalario(10000);
		
		ControlBonificacion controlBonificacion = new ControlBonificacion();
		System.out.println(controlBonificacion.registrarSalario(diego));
		System.out.println(controlBonificacion.registrarSalario(jimena));

		Contador alexis = new Contador();
		alexis.setSalario(5000);
		System.out.println(controlBonificacion.registrarSalario(alexis));

	}
}
