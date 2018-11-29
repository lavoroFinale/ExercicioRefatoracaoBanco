package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;

import sun.util.calendar.Gregorian;

public class ValidacaoLimite {

	private static ValidacaoLimite instance;
	private Operacoes operacoes;
	private GregorianCalendar date;
	
	private ValidacaoLimite() {
		operacoes = Operacoes.getInstance();
		date = new GregorianCalendar();
	}
	
	public static ValidacaoLimite getInstance() {
		if(instance == null) {
			instance = new ValidacaoLimite();
		}
		return instance;
	}
	
	public boolean valida(Conta c, double valor){
		
		double aux = operacoes.getOperacoes(c)
		.stream()
		.filter(e -> e.getAno() ==  date.get(GregorianCalendar.YEAR) && e.getMes() ==  date.get(GregorianCalendar.MONTH)+1 && e.getDia() ==  date.get(GregorianCalendar.DAY_OF_MONTH))
		.filter(e -> e.getTipoOperacao() instanceof OperacaoDebito).mapToDouble(e -> e.getValorOperacao())
		.sum();
		
		if(aux + valor <= c.getLimRetiradaDiaria())
			return true;
		throw new NumberFormatException("Limite diario alcancado!");
	}
}
