package com.bcopstein.ExercicioRefatoracaoBanco;

public class ValidacaoLimite {

	private final double LIM_PLATINUM = 500000.0;
	private final double LIM_GOLD = 100000.0;
	private final double LIM_SILVER = 500000.0;
	private static ValidacaoLimite instance;
	
	private ValidacaoLimite() {
	}
	
	public static ValidacaoLimite getInstance() {
		if(instance == null) {
			instance = new ValidacaoLimite();
		}
		return instance;
	}
	
	public boolean valida(Conta c){
		return true;
	}
}
