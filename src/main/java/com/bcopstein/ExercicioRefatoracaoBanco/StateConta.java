package com.bcopstein.ExercicioRefatoracaoBanco;

public interface StateConta {
	public double credito(double valor, double saldo);
	public StateConta upgrade(double saldo);
	public int status();
	public String strStatus();
}
