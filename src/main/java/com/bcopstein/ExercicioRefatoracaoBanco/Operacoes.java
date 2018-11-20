package com.bcopstein.ExercicioRefatoracaoBanco;

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
		List<Operacao> aux = FXCollections.observableArrayList(
		listOperacoes
		.stream()
		.filter(e->e.getNumeroConta()==conta.getNumero())
		.collect(Collectors.toList()));
		
		return aux;
	}
	
	
	
	
	
	
}
