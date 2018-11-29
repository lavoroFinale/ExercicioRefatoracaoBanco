package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaSilver implements StateConta {
	
	private final double limite = 10000;
	
	public ContaSilver() {	
	}

	@Override
	public double credito(double valor) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		return valor;
	}
	
	public StateConta upgrade(double saldo) {
		if(saldo >= 50000)
			return new ContaGold();
		else 
			return new ContaSilver();
	}
	
	public StateConta status() {
		return this;
	}
	
	public double getLimite() {
		return limite; 
	}
	
	public String toString() {
		return "Silver";
	}
}
