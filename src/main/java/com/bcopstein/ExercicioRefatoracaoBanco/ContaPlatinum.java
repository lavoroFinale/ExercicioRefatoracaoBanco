package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaPlatinum implements StateConta{

	private final double limite = 500000;
	
	@Override
	public double credito(double valor, double saldo) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		return saldo + valor * 1.025;
	}
	
	public StateConta upgrade(double saldo){
		if(saldo < 100000) 
			return new ContaGold();
		else
			return new ContaPlatinum();
	}
	
	public StateConta status() {
		return this;
	}
	
	public double getLimite() {
		return limite; 
	}
	
	public String toString() {
		return "Platinum";
	}
}
