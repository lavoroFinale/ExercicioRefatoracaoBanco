package com.bcopstein.ExercicioRefatoracaoBanco;
public class Conta {

	private String correntista;
	private int numero;
	private double saldo;
	private StateConta state;
	
	//@ invariant getSaldo() >= 0;

	public Conta(int umNumero, String umNome) {
		numero = umNumero;
		correntista = umNome;
		saldo = 0.0;
		this.setState(new ContaSilver());
	}
	
	public Conta(int umNumero, String umNome, double umSaldo, StateConta status) {
		numero = umNumero;
		correntista = umNome;
		saldo = umSaldo;
		this.setState(status);
		this.update();
	}
	
	//@ requires state != null;
	private void setState(final StateConta state){
		this.state = state;
	}
	//@ ensures \result >= 0;
	public/*@ pure */ double getSaldo() {
		return saldo;
	}
	//@ ensures \result >= 0;
	public /*@ pure */  Integer getNumero() {
		return numero;
	}
	
	//@ ensures !\result.equals(" ")
	public /*@ pure */  String getCorrentista() {
		return correntista;
	}
	
	// @ ensures \result != null;
	public /*@ pure */  StateConta getStatus() {
		return state.status();
	}
	
	//@ ensures \result != null;
	public /*@ pure */ double getLimRetiradaDiaria() {
		return state.getLimite();
	}
	
	//@ requires valor > 0;
	//@ ensures getSaldo() == \old(getSaldo()) + state.credito(valor);
	public double deposito(double valor) {
		double aux = state.credito(valor);
		saldo += aux;
		update();
		return aux;
	}
	//@ requires valor > 0;
	//@ ensures getSaldo() == \old(getSaldo()) - valor;
	public void debito(double valor) {
		if (valor <= 0.0 || valor > saldo)
	  		  throw new NumberFormatException("Valor invalido");
		saldo -= valor;
		update();
	}
	//@ ensures state == \old(state).upgrade(getSaldo());
	private void update() {
		setState(state.upgrade(saldo));
	}

	@Override
	public /*@ pure */ String toString() {
		return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status=" + state.status()
				+ "]";
	}

	public /*@ pure */  String getStrStatus() {
		return state.toString();
	}
}
