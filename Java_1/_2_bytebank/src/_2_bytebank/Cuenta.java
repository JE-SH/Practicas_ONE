package _2_bytebank;

public class Cuenta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total=0;
	
	
	public Cuenta() {
		total++;
	}
	public Cuenta(int agencia) {
		if (agencia>0) {
			this.agencia =agencia;
		}
		else {
			System.out.println("Número no valido");
			
		}
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getTitular() {
		return titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	public static int getTotal() {
		return total;
	}
	void depositar(double valor){
		saldo += valor;
	}
	public boolean retirar(double saldo) {
		if(this.saldo>=saldo) {
			this.saldo-=saldo;
			return true;
		}
		else
			return false;
					
	}
	void transferir(double valor, Cuenta cuenta) {
		if(saldo>=valor) {
			saldo -=valor;
			cuenta.depositar(valor);
		}
	} 
	
}
