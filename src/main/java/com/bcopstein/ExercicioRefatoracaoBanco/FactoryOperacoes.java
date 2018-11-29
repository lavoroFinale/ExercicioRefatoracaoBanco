package com.bcopstein.ExercicioRefatoracaoBanco;



public class FactoryOperacoes {
	
	public static Operacao getInstance(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, StateConta statusConta, double valorOperacao, int tipoOperacao) {
		if(tipoOperacao == 0)
			return new OperacaoCredito(dia, mes, ano, hora, minuto, segundo, numeroConta, statusConta, valorOperacao);
		if (tipoOperacao == 1) {
			return new OperacaoDebito(dia, mes, ano, hora, minuto, segundo, numeroConta, statusConta, valorOperacao);
		}
		return null;
	} 
	
	public static Operacao getInstance(int numero,StateConta statusConta, double valorOperacao, int tipoOperacao) {
		if(tipoOperacao == 0)
			return new OperacaoCredito(numero, statusConta, valorOperacao);
		if (tipoOperacao == 1) {
			return new OperacaoDebito(numero, statusConta, valorOperacao);
		}
		return null;
	} 

}
