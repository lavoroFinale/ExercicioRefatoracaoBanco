package com.bcopstein.ExercicioRefatoracaoBanco;

public interface StateConta {
	
	//@ requires valor > 0;
	//@ ensures \result > 0;
	public /*@ pure */ double credito(double valor);
	
	//@ requires saldo >= 0;
	//@ ensures \result != null;
	public /*@ pure */ StateConta upgrade(double saldo);
	
	//@ ensures \result != null; 
	public /*@ pure */ StateConta status();
	
	//@ ensures \result > 0;
	public /*@ pure */ double getLimite();
}
