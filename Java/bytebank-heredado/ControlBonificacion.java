
public class ControlBonificacion {
	private double suma;
	
	public double registrarSalario(Funcionario funcionario) {
		this.suma = funcionario.getBonificacion()+ suma;
		return this.suma;
	}
	/*
	public double registrarSalario(Gerente gerente) {
		this.suma = gerente.getBonificacion()+ suma;
		return this.suma;
	}
	
	public double registrarSalario(Contador contador) {
		this.suma = contador.getBonificacion()+ suma;
		return this.suma;
	}
	*/
}
