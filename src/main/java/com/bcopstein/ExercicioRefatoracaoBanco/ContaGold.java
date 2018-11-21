package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaGold implements StateConta{

	@Override
	public double credito(double valor) {
		return valor;
	}

	@Override
	public double debito(double valor) {
		return valor;
	}

}
