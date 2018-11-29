package com.bcopstein.ExercicioRefatoracaoBanco;

import java.util.GregorianCalendar;

public class OperacaoCredito implements Operacao{
	    
		private int dia;
	    private int mes;
	    private int ano;
	    private int hora;
	    private int minuto;
	    private int segundo;
	    private int numeroConta;
	    private StateConta statusConta;
	    private double valorOperacao;
	    
	    public OperacaoCredito(int dia, int mes, int ano, int hora, int minuto, int segundo, int numeroConta, StateConta statusConta, double valorOperacao) {
	    	this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			this.hora = hora;
			this.minuto = minuto;
			this.segundo = 	segundo;
			
			this.numeroConta = numeroConta;
			this.statusConta = statusConta;
			this.valorOperacao = valorOperacao;
	    }
	    
		public OperacaoCredito(int numeroConta,StateConta statusConta, double valorOperacao) {
			GregorianCalendar date = new GregorianCalendar();
			this.dia =date.get(GregorianCalendar.DAY_OF_MONTH);
			this.mes =date.get(GregorianCalendar.MONTH)+1;
			this.ano = date.get(GregorianCalendar.YEAR);
			this.hora = date.get(GregorianCalendar.HOUR);
			this.minuto = date.get(GregorianCalendar.MINUTE);
			this.segundo = 	date.get(GregorianCalendar.SECOND);
			
			this.numeroConta = numeroConta;
			this.statusConta = statusConta;
			this.valorOperacao = valorOperacao;
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

		public StateConta getStatusConta() {
			return statusConta;
		}

		public double getValorOperacao() {
			return valorOperacao;
		}

		public Operacao getTipoOperacao() {
			return this;
		}
	    
		@Override
		public String toString() {
			String line = dia+"/"+mes+"/"+ano+" "+
		                  hora+":"+minuto+":"+segundo+" "+
					      numeroConta+" "+
		                  statusConta +" "+
					      "<C>"+" "+
		                  valorOperacao;
			return(line);
		}

		@Override
		public int getIntTipo() {
			return 0;
		}
}
