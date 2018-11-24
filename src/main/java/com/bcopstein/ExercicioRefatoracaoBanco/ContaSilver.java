package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaSilver implements StateConta {
	
	public ContaSilver() {	
	}

	@Override
	public double credito(double valor, double saldo) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		return saldo + valor;
	}
	
	public StateConta upgrade(double saldo) {
		if(saldo >= 50000)
			return new ContaGold();
		else 
			return new ContaSilver();
	}
	
	public int status() {
		return 0;
	}
	
	public String strStatus() {
		return "Silver";
	}
}
