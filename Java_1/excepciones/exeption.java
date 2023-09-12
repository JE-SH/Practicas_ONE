
public class exeption {

	public static void main(String[] args) {
        System.out.println("Inicio main");
        try {
			metodo1();
		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Fin de main");
    }

    private static void metodo1() throws MiExcepcion {
        System.out.println("Inicio de metodo1");
        try {
            metodo2();
        } catch(ArithmeticException | NullPointerException ex) {
            String msg = ex.getMessage();
            System.out.println("Exception " + msg);
            ex.printStackTrace();
        }
        System.out.println("Fin de metodo1");
    }

    private static void metodo2() throws MiExcepcion {
        System.out.println("Inicio de metodo2");
        metodo3();

        throw new ArithmeticException("dio error");
        // System.out.println("Fin de metodo2");
    }

    private static void metodo3() throws MiExcepcion {
        System.out.println("Inicio de metodo3");
        throw new MiExcepcion("Error 212"); 
        // System.out.println("Fin de metodo2");
    }
	
}