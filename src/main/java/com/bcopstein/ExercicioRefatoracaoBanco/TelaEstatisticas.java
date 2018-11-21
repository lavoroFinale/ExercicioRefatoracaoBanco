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
	
	private Stage mainStage;
	private Scene cenaOperacoes;
	private Scene cenaEstatisticas;
	
	private LogicaOperacoes logica;
	
	private GregorianCalendar calendario;
	private int mes, ano;
	
	private Conta conta;

	public TelaEstatisticas(Stage mainStage, Scene cenaOperacoes) {
		this.mainStage = mainStage;
		this.cenaOperacoes = cenaOperacoes;
		this.calendario = new GregorianCalendar();
		this.mes = calendario.get(GregorianCalendar.MONTH)+1;
		this.ano = calendario.get(GregorianCalendar.YEAR);
		this.logica = logica.getInstance();
		this.conta = logica.getContaAtual();
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
		Label labelSaldoMedio = new Label("Saldo medio: " + "faze saldo medio nas operacoes");
		
		grid.add(correntista, 1, 1);
		grid.add(labelData, 1, 2);
		grid.add(labelSaldoMedio, 1, 3);
		
		
		
		cenaEstatisticas = new Scene(grid);
		return cenaEstatisticas;
	}
}
