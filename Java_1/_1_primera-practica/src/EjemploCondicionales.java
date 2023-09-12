
public class EjemploCondicionales {
	public static void main(String[] args) {
		
		int edad = 23;
		int cantidadPersonas = 3;
		
		if (edad >= 18) {
			System.out.println("Usted puede entrar");
			System.out.println("Bienvenido");
		}
		else {
			if (cantidadPersonas >= 2) {
                System.out.println("No tienes 18 años, pero puedes ingresar, porque estás acompañado");
			}
			else
				System.out.println("Usted no puede entrar");
		}
		
		
		
		}
}
