
public class TestFuncionario {
	public static void main(String[] args) {
		Funcionario diego = new Contador();
		diego.setDocumento("4685484");
		diego.setNombre("Diego");
		diego.setSalario(2560);
		
		 Gerente g1 = new Gerente();
        g1.setNombre("Marco");
        g1.setDocumento("235568413");
        g1.setSalario(5000.0);

        System.out.println(g1.getNombre());
        System.out.println(g1.getDocumento());
        System.out.println(g1.getSalario());
        System.out.println(g1.getBonificacion());


        g1.setClave("2222");
        boolean autentico = g1.iniciarSesion("2222");

        System.out.println(autentico);
		
	}
}
