package com.bcopstein.ExercicioRefatoracaoBanco;
public class Conta {
	public final int LIM_SILVER_GOLD = 50000;
	public final int LIM_GOLD_PLATINUM = 200000;
	public final int LIM_PLATINUM_GOLD = 100000;
	public final int LIM_GOLD_SILVER = 25000;

	private int numero;
	private String correntista;
	private double saldo;
	private StateConta state;

	public Conta(int umNumero, String umNome) {
		numero = umNumero;
		correntista = umNome;
		saldo = 0.0;
		setState(new ContaSilver());
	}
	
	public Conta(int umNumero, String umNome, double umSaldo, int status) {
		numero = umNumero;
		correntista = umNome;
		saldo = umSaldo;
		switch(status) {
			case 0: setState(new ContaSilver());
			case 1: setState(new ContaGold());
			case 2: setState(new ContaPlatinum());
		}
	}
	
	private void setState(final StateConta state){
		this.state = state;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public Integer getNumero() {
		return numero;
	}
	
	public String getCorrentista() {
		return correntista;
	}
	
	public int getStatus() {
		return state.status();
	}
	
	public String getStrStatus() {
		return state.strStatus();
	}
	
	public double getLimRetiradaDiaria() {
		switch(state.status()) {
		case 0:  return 5000.0;
		case 1:  return 50000.0;
		case 2:  return 500000.0;
		default: return 0.0;
		}
	}
	
	public void deposito(double valor) {
		saldo = state.credito(valor, saldo);
		update();
	}
	
	public void debito(double valor) {
		if (valor < 0.0)
	  		  throw new NumberFormatException("Valor invalido");
		saldo -= valor;
		update();
	}
	
	private void update() {
		setState(state.upgrade(saldo));
	}

	

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status=" + state.status()
				+ "]";
	}
}
