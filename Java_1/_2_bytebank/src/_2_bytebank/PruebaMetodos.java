package _2_bytebank;

public class PruebaMetodos {
	public static void main(String[] args) {
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(1000);
		System.out.println(cuenta.getSaldo());
		System.out.println( cuenta.retirar(500));
		System.out.println(cuenta.getSaldo());
		Cuenta cuenta2 = new Cuenta();
		
		cuenta.transferir(100, cuenta2);
		System.out.println(cuenta.getSaldo());
		System.out.println(cuenta2.getSaldo());
		
		Cliente diego = new Cliente();
		diego.setNombre("Diego");
		diego.setDocumento("56568968");
		diego.setTelefono("225484533");
		
		cuenta.setTitular(diego);
		System.out.println(cuenta.getTitular().getNombre());

		System.out.println(Cuenta.getTotal()); 


	}
}
