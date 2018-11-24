package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaGold implements StateConta{

	public ContaGold() {
		
	}
	@Override
	public double credito(double valor, double saldo) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		return saldo + valor * 1.01;
	}
	
	public StateConta upgrade(double saldo) {
		if(saldo < 25000)
			return new ContaSilver();
		else if(saldo >= 200000)
			return new ContaPlatinum();
		else
			return new ContaGold();
	}
	
	public int status() {
		return 1;
	}
	
	public String strStatus() {
		return "Gold";
	}
}
