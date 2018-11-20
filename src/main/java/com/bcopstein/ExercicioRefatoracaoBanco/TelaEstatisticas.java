package com.bcopstein.ExercicioRefatoracaoBanco;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;


import javafx.scene.Scene;

public class TelaEstatisticas {
	
	private Conta conta;
	private Stage mainStage;
	private Scene cenaOperacoes;
	private Scene cenaEstatisticas;
	private List<Operacao> operacoes;
	private GregorianCalendar calendario;
	private int mes, ano;


	public TelaEstatisticas(Conta conta, Stage mainStage, Scene cenaOperacoes, List<Operacao> operacoes) {
		this.conta = conta;
		this.mainStage = mainStage;
		this.cenaOperacoes = cenaOperacoes;
		this.calendario = new GregorianCalendar();
		this.operacoes = operacoes;
		this.mes = calendario.get(GregorianCalendar.MONTH)+1;
		this.ano = calendario.get(GregorianCalendar.YEAR);
	}
	
	public double saldoNOdia(int conta,int mes,int ano) {
		return(operacoes
		.stream()
		.filter(o->o.getNumeroConta() == conta)
		.filter(o->o.getAno()<ano || o.getAno() == ano && o.getMes()<=mes)
		.mapToDouble(o-> (o.getTipoOperacao()==0)? o.getValorOperacao():-1*o.getValorOperacao())
		.sum());
	}
	
	public Scene getScene() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
		
		Button btn = new Button("voltar");
		btn.setOnAction(e -> {
			mainStage.setScene(cenaOperacoes);
		});
		
		grid.add(btn, 3, 5);
	

		Label labelData = new Label("Estatisticas do mes " + mes + " de " + ano);
		Label correntista =  new Label("Correntista: " + conta.getCorrentista());
		Label labelSaldoMedio = new Label("Saldo medio: " + saldoMedio());
		
		grid.add(correntista, 1, 1);
		grid.add(labelData, 1, 2);
		grid.add(labelSaldoMedio, 1, 3);
		
		
		
		cenaEstatisticas = new Scene(grid);
		return cenaEstatisticas;
	}
	
	public double saldoMedio() {
		
		double saldo = 0;
		int count = 0;
		
		for(Operacao o : operacoes)
			if(o.getMes() ==  5 && o.getAno()==ano) {
				if(o.getTipoOperacao() == 0)
					saldo += o.getValorOperacao();
				else 
					saldo -= o.getValorOperacao();
				
				count ++;
			}
		
		if(count != 0)
			return saldo/count;
		
		return count;
	}

}
