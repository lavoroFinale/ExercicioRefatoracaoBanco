package com.bcopstein.ExercicioRefatoracaoBanco;
public interface Operacao {

	public int getDia();

	public int getMes() ;
	
	public int getAno();

	public int getHora();

	public int getMinuto();

	public int getSegundo();

	public int getNumeroConta();

	public StateConta getStatusConta();

	public double getValorOperacao();

	public Operacao getTipoOperacao();
	@Override
	public String toString();

	public int getIntTipo();
}
