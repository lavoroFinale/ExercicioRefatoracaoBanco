package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;
import java.util.List;

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
    	  GregorianCalendar date = new GregorianCalendar();
 		  Operacao op = FactoryOperacoes.getInstance(
  			  date.get(GregorianCalendar.DAY_OF_MONTH),
  			  date.get(GregorianCalendar.MONTH)+1,
  			  date.get(GregorianCalendar.YEAR),
  			  date.get(GregorianCalendar.HOUR),
  			  date.get(GregorianCalendar.MINUTE),
  			  date.get(GregorianCalendar.SECOND),
  			  contaAtual.getNumero(),
  			  contaAtual.getStatus(),
  			  valor,
  			  1);
 		
    	  operacoes.add(op);
	}
	
	public void credito(double valor) throws NumberFormatException {
		  contaAtual.deposito(valor);
    	  GregorianCalendar date = new GregorianCalendar();
 		  Operacao op = FactoryOperacoes.getInstance(
  			  date.get(GregorianCalendar.DAY_OF_MONTH),
  			  date.get(GregorianCalendar.MONTH)+1,
  			  date.get(GregorianCalendar.YEAR),
  			  date.get(GregorianCalendar.HOUR),
  			  date.get(GregorianCalendar.MINUTE),
  			  date.get(GregorianCalendar.SECOND),
  			  contaAtual.getNumero(),
  			  contaAtual.getStatus(),
  			  valor,
  			  0);
 		
    	  operacoes.add(op);
	}
	
	public void saveContas() {
		
	}
	
	public void saveOperacoes(){
		
	}
	
	public double getSaldoMedio(int mes, int ano) {
		List<Operacao> listaOp = operacoes.getOperacoesMesAno(contaAtual, mes, ano);
		double aux = 0;
		for(int i = 0; i<listaOp.size();i++) {
			if(listaOp.get(i).getTipoOperacao() == 0)
				aux += listaOp.get(i).getValorOperacao();
			else
				aux -= listaOp.get(i).getValorOperacao();
		}
		aux += operacoes.getTotalValorateData(contaAtual, mes, ano);
		return aux/30.;
	}
	
	public List<Operacao> getOperacoes(){
		return operacoes.getOperacoes(contaAtual);
	}
	
	public int getTotalDeDebitos() {
		return operacoes.getTotalDebito(contaAtual);
	}
	
	public int getTotalDeCredito() {
		return operacoes.getTotalCredito(contaAtual);
	}
	
	public double getSaldo() {
		return contaAtual.getSaldo();
	}
	
}
