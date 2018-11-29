package com.bcopstein.ExercicioRefatoracaoBanco;

public class FactoryState {

	public static StateConta createInstance(int status) {
		switch(status) {
			case 0: return new ContaSilver();
			case 1: return new ContaGold();
			case 2: return new ContaPlatinum();
			default: return null;
		}
	}
	public static StateConta createInstance(String status) {
		switch(status) {
			case "Silver": return new ContaSilver();
			case "Gold": return new ContaGold();
			case "Platinum": return new ContaPlatinum();
			default: return null;
		}
	}
}
