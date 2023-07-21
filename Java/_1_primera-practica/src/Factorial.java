
public class Factorial {
	public static void main(String[] args) {
		int valor=4;
		System.out.print("El factorial de "+ valor);
		int factorial =1;
		
		while(valor>0) {
			factorial *=valor;
			valor--;
		}
		System.out.print(" es " + factorial);
		
		
	}
}
