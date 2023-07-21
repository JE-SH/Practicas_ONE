
public class CuentaCorriente extends Cuenta {

	double comision = .2;

	
	public CuentaCorriente(int agencia, int numero) {
		super(agencia, numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean retirar(double saldo) {
		return super.retirar(saldo+comision);
	}

	@Override
	void depositar(double valor) {
		this.saldo += valor;
		
	}
	
}
