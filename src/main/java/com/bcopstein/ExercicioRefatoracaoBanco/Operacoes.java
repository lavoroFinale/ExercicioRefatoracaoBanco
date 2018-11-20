package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.List;

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
	
	
	
	
	
	
}
