package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.Map;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;

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
	
	public Conta getConta(int nrm){
		Conta aux = contas.get(nrm);
		contaAtual = aux;
		
		return aux;
	}
	
}
