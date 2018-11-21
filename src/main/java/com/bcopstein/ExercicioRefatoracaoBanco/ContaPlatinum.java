package com.bcopstein.ExercicioRefatoracaoBanco;

public class ContaPlatinum implements StateConta{

	@Override
	public double credito(double valor) {
		return valor;		
	}

	@Override
	public double debito(double valor) {
		return valor;		
	}

}
