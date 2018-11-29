package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.Collection;
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
	
	
	public void add(Operacao o){
		listOperacoes.add(o);
	}
	
	public List<Operacao> getOperacoes(Conta c){
		return listOperacoes.stream()
				.filter(e -> e.getNumeroConta() == c.getNumero())
				.collect(Collectors.toList());
	}
	
	public  List<Operacao> getOperacoesMesAno(Conta c, int mes, int ano){
		return getOperacoes(c).stream()
				.filter(e -> (e.getAno() == ano) && (e.getMes() == mes))
				.collect(Collectors.toList());
	}
	
	public  double getTotalValorateData(Conta c, int mes, int ano){
		 List<Operacao> listaOp = getOperacoes(c).stream()
				.filter(e -> (e.getAno() <= ano) && (e.getMes() < mes))
				.collect(Collectors.toList());
		 double aux = 0;
		 for(int i = 0; i<listaOp.size();i++) {
				if(listaOp.get(i).getTipoOperacao() instanceof OperacaoCredito)
					aux += listaOp.get(i).getValorOperacao();
				else
					aux -= listaOp.get(i).getValorOperacao();
			}
		 return aux;
		 }

	public Collection<Operacao> getListOperacoes() {
		return listOperacoes;
	}
}
	
