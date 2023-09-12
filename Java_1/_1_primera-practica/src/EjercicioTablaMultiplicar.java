import java.util.Iterator;

public class EjercicioTablaMultiplicar {
	public static void main(String[] args) {
		for(int contador=1;contador <=10;contador++) {
			for(int multiplo=1; multiplo<=10;multiplo++) {
				System.out.print(contador*multiplo);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
