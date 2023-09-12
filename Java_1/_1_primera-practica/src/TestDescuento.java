public class TestDescuento {

    public static void main(String[] args) {

        double valorCompra = 1500.0;
        double descuento=0;
        // ifs aqui
        if (valorCompra>=100 && valorCompra<200) {
        	System.out.println("Descuento del 10%");
        	descuento=10;
        }
        else if( valorCompra>=200 && valorCompra <300) {
        	System.out.println("Descuento del 15%");
        	descuento=15;
        }
        else if(valorCompra >=300) {
        	System.out.println("Descuento del 20%");
        	descuento=20;
        }
        else
        	System.out.println("No hay descuento");
        
        descuento =((descuento*valorCompra)/100);
        System.out.println("El descuento a aplicar es de "+ descuento);
        double total = valorCompra - descuento;
        
        System.out.println("El total de la compra es de " + total + " pesos");
    }
}