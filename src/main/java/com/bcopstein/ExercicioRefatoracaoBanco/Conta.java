package com.bcopstein.ExercicioRefatoracaoBanco;
public class Conta {

	private String correntista;
	private int numero;
	private double saldo;
	private StateConta state;
	
	//@ invariant getSaldo() >= 0;

	public Conta(int umNumero, String umNome) {
		numero = umNumero;
		correntista = umNome;
		saldo = 0.0;
		this.setState(new ContaSilver());
	}
	
	public Conta(int umNumero, String umNome, double umSaldo, StateConta status) {
		numero = umNumero;
		correntista = umNome;
		saldo = umSaldo;
		this.setState(status);
		this.update();
	}
	
	private void setState(final StateConta state){
		this.state = state;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getCorrentista() {
		return correntista;
	}
	
	public StateConta getStatus() {
		return state.status();
	}
	
	public double getLimRetiradaDiaria() {
		return state.getLimite();
	}
	
	public double deposito(double valor) {
		double aux = state.credito(valor);
		saldo += aux;
		update();
		return aux;
	}

	public void debito(double valor) {
		if (valor <= 0.0 || valor > saldo)
	  		  throw new NumberFormatException("Valor invalido");
		saldo -= valor;
		update();
	}
	
	private void update() {
		setState(state.upgrade(saldo));
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status=" + state.status()
				+ "]";
	}

	public String getStrStatus() {
		return state.toString();
	}
}
