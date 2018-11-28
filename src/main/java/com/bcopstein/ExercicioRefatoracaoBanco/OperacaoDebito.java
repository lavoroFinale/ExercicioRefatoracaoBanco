package com.bcopstein.ExercicioRefatoracaoBanco;

public class OperacaoDebito implements Operacao{
    
	private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int minuto;
    private int segundo;
    private int numeroConta;
    private int statusConta;
    private double valorOperacao;
    
	public OperacaoDebito(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, int statusConta, double valorOperacao) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.hora = hora;
		this.minuto = minuto;
		this.segundo = segundo;
		this.numeroConta = numeroConta;
		this.statusConta = statusConta;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getStatusConta() {
		return statusConta;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public int getTipoOperacao() {
		return 1;
	}
    
	@Override
	public String toString() {
		String line = dia+"/"+mes+"/"+ano+" "+
	                  hora+":"+minuto+":"+segundo+" "+
				      numeroConta+" "+
	                  statusConta +" "+
				      "<D>"+" "+
	                  valorOperacao;
		return(line);
	}
}
