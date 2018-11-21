package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;

public class Operacoes  {
	
	private List<Operacao> listOperacoes;
	private Persistencia persistencia;
	private static Operacoes instance;
	
	private Operacoes() {
		persistencia = Persistencia.getInstance();
		listOperacoes = persistencia.loadOperacoes();
	}
	
	public static Operacoes getInstance() {
		if(instance == null)
			instance = new Operacoes();
		return instance;
	}
	
	public List<Operacao> getExtrato(Conta conta){
		List<Operacao> aux = 
		listOperacoes
		.stream()
		.filter(e->e.getNumeroConta()==conta.getNumero())
		.collect(Collectors.toList());
		
		return aux;
	}
	
	public void add(Double valor, Conta conta){
		 GregorianCalendar date = new GregorianCalendar();
		 Operacao op = new Operacao(
 			  date.get(GregorianCalendar.DAY_OF_MONTH),
 			  date.get(GregorianCalendar.MONTH+1),
 			  date.get(GregorianCalendar.YEAR),
 			  date.get(GregorianCalendar.HOUR),
 			  date.get(GregorianCalendar.MINUTE),
 			  date.get(GregorianCalendar.SECOND),
 			  conta.getNumero(),
 			  conta.getStatus(),
 			  valor,
 			  1);
		listOperacoes.add(op);	
	}
	
	
	
	
	
	
}
