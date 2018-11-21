package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContextConta {
	private String correntista;
	private int numero;
	private double saldo;
	private StateConta state;
	
	public ContextConta(String correntista, int numero, double saldo) {
		this.correntista = correntista;
		this.numero = numero;
		this.saldo = saldo;
		setState(new ContaSilver());
	}

	
	private void setState(final StateConta state){
		this.state = state;
	}
	
	public String getCorrentista() {
		return correntista;
	}


	public int getNumero() {
		return numero;
	}


	public double getSaldo() {
		return saldo;
	}


	public StateConta getState() {
		return state;
	}
	
	public void debito(double valor) {
		state.debito(valor);
		//update();
	}


}
