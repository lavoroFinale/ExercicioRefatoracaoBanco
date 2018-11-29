package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

public class LogicaOperacoes {
	
	private Conta contaAtual;
	private Operacoes operacoes;
	private Contas contas;
	private static LogicaOperacoes instance;
	private Persistencia persistencia;
	private ValidacaoLimite validacaoLimite;
	
	private LogicaOperacoes(){
		this.operacoes = Operacoes.getInstance();
		this.contas = Contas.getInstance();
		this.persistencia = Persistencia.getInstance();
		this.validacaoLimite = ValidacaoLimite.getInstance();
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
		if(validacaoLimite.valida(contaAtual, valor)) {
		  contaAtual.debito(valor);	
		  Operacao op = FactoryOperacoes.getInstance( contaAtual.getNumero(), contaAtual.getStatus() ,valor,1);
			
	  	  operacoes.add(op);
  	  }
	}
	
	public void credito(double valor) throws NumberFormatException {
		  double aux = contaAtual.deposito(valor);
 		  Operacao op = FactoryOperacoes.getInstance( contaAtual.getNumero(), contaAtual.getStatus() ,aux,0);
 		
    	  operacoes.add(op);
	}
	
	public void saveContas() {
		persistencia.saveContas(contas.getListContas());
	}
	
	public void oi() {
		System.out.println("oi");
	}
	
	public void saveOperacoes(){
		persistencia.saveOperacoes(operacoes.getListOperacoes());
	}
	
	public double getSaldoMedio(int mes, int ano) {
		List<Operacao> listaOp = operacoes.getOperacoesMesAno(contaAtual, mes, ano);
		double aux = 0;
		for(int i = 0; i<listaOp.size();i++) {
			if(listaOp.get(i).getTipoOperacao() instanceof OperacaoCredito)
				aux += listaOp.get(i).getValorOperacao();
			else
				aux -= listaOp.get(i).getValorOperacao();
		}
		aux += operacoes.getTotalValorateData(contaAtual, mes, ano);
		return aux/30;
	}
	
	
	
	public List<String> getOperacoes(){
		return  operacoes.getOperacoes(contaAtual)
				.stream()
				.map(e -> e.toString())
				.collect(Collectors.toList());
		
	}
	
	public double getTotalDeDebitosMes(int mes, int ano) {
		return operacoes
				.getOperacoes(contaAtual)
				.stream()
				.filter(e -> e.getMes() == mes && e.getAno() == ano)
				.filter(e -> e.getTipoOperacao() instanceof OperacaoDebito)
				.mapToDouble(e -> e.getValorOperacao())
				.sum();
	}
	
	public double getTotalDeCreditoMes(int mes, int ano) {
		return operacoes
				.getOperacoes(contaAtual)
				.stream()
				.filter(e -> e.getMes() == mes && e.getAno() == ano)
				.filter(e -> e.getTipoOperacao() instanceof OperacaoCredito)
				.mapToDouble(e -> e.getValorOperacao())
				.sum();
	}
	
	public double getSaldo() {
		return contaAtual.getSaldo();
	}
	
}
