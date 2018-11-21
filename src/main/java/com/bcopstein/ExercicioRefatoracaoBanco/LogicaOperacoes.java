package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;

public class LogicaOperacoes {
	
	private Conta contaAtual;
	private Operacoes operacoes;
	private Contas contas;
	private static LogicaOperacoes instance;
	
	private LogicaOperacoes(){
		this.operacoes = Operacoes.getInstance();
		this.contas = Contas.getInstance();
	}
	
	public static LogicaOperacoes getInstance() {
		if(instance == null)
			instance = new LogicaOperacoes();
		return instance;
	}
	
	public void setContaAtual(int nrm) throws NumberFormatException  {
		contaAtual = contas.getConta(nrm);
	}
	
	public Conta getContaAtual() {
		return contaAtual;
	}
	
	public void debito(double valor) throws NumberFormatException{
    	  contaAtual.debito(valor);
    	  operacoes.add(valor,contaAtual);
	}
	
	public void credito(double valor) throws NumberFormatException {
    	  contaAtual.deposito(valor);
          operacoes.add(valor, contaAtual); 
	}
	
	public void saveContas() {
		
	}
	
	public void saveOperacoes(){
		
	}

}
