package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaGold implements StateConta{

	private final double limite = 100000.0;
	
	@Override
	public double credito(double valor) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		return  valor * 1.01;
	}
	
	public StateConta upgrade(double saldo) {
		if(saldo < 25000)
			return new ContaSilver();
		else if(saldo >= 200000)
			return new ContaPlatinum();
		else
			return new ContaGold();
	}
	
	public StateConta status() {
		return this;
	}
	
	public double getLimite() {
		return limite; 
	}
	
	public String toString() {
		return "Gold";
	}
}
