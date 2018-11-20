package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.Map;

public class Contas {
	
	private Map<Integer,Conta> contas;
	private Persistencia persistencia;
	private static Contas instance;
	private Conta contaAtual;
	
	private Contas(){
		persistencia = Persistencia.getInstance();
		contas = persistencia.loadContas();
	}
	
	public static Contas getInstance() {
		if(instance == null)
			instance = new Contas();
		return instance;
	}
	
	public Conta getContaAtual(){
		return contaAtual;	
	}
	
	
}
