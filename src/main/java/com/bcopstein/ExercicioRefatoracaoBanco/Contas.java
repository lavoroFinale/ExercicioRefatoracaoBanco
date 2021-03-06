package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.*;

public class Contas {
	
	private Map<Integer,Conta> contas;
	private Persistencia persistencia;
	private static Contas instance;
	
	private Contas(){
		persistencia = Persistencia.getInstance();
		contas = persistencia.loadContas();
	}
	
	public static Contas getInstance() {
		if(instance == null)
			instance = new Contas();
		return instance;
	}
	
	public Conta getConta(int nrm) {
		Conta aux = contas.get(nrm);
		
		if(aux == null)
			throw new NumberFormatException("Conta invalida");
	
		return contas.get(nrm);
	}
	
	public Collection<Conta> getListContas(){
		return contas.values();	
	}	
}
