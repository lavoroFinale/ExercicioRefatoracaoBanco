package com.bcopstein.ExercicioRefatoracaoBanco;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.sql.Date;
import java.text.NumberFormat.Field;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;

public class TelaEstatisticas {
	
	private Stage mainStage;
	private Scene cenaOperacoes;
	private Scene cenaEstatisticas;
	
	private LogicaOperacoes logica;
	
	private GregorianCalendar calendario;
	private int mes, ano;
	
	private Label labelData, labelcorrentista, labelSaldoMedio, labelTotalCredito, labelTotalDebito;
	private TextField fieldMes, fieldAno;

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
	    grid.setPadding(new Insets(30));
	    
	    labelcorrentista =  new Label("Correntista: " + conta.getCorrentista());
	    
	    fieldMes = new TextField("");
		fieldAno= new TextField("");
		
		labelData = new Label("Estatisticas do mes " + mes + " de " + ano);
		labelSaldoMedio = new Label("Saldo medio: " + logica.getSaldoMedio(mes, ano));	
		labelTotalCredito = new Label("Total de credito: " + logica.getTotalDeCreditoMes(mes,ano));
		labelTotalDebito = new Label("Total de debito: " + logica.getTotalDeDebitosMes(mes,ano));
	    
		grid.add(labelcorrentista, 1, 1);
		grid.add(labelData, 1, 2);
		grid.add(labelSaldoMedio, 1, 3);
		grid.add(labelTotalDebito, 1, 4);
		grid.add(labelTotalCredito, 1, 5);
		
		grid.add(fieldMes, 3, 3);
		grid.add(fieldAno, 3, 4);
		
		Button btnPesquisar = new Button("Pesquisar");
		
		btnPesquisar.setOnAction(e -> {
			try {
			mes = Integer.parseInt(fieldMes.getText());
			ano = Integer.parseInt(fieldAno.getText());
			
			fieldMes.setText("");
			fieldAno.setText("");
			
			
			attInfo();
			}
			catch(NumberFormatException ex) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Valor inválido !!");
				alert.setHeaderText(null);
				alert.setContentText("Mes ou ano invalido!!");
				alert.showAndWait();
			}	
		});
		
		Button btnVoltar = new Button("voltar");
		btnVoltar.setOnAction(e -> {
			mainStage.setScene(cenaOperacoes);
		});
		
		
		grid.add(btnPesquisar, 3, 5);
		grid.add(btnVoltar, 4, 5);
		
		
		cenaEstatisticas = new Scene(grid);
		return cenaEstatisticas;
	}
	
	public void attInfo() {
		
		fieldMes.setText("");
		fieldAno.setText("");
		
		labelData.setText("Estatisticas do mes " + mes + " de " + ano);
		labelSaldoMedio.setText("Saldo medio: " + logica.getSaldoMedio(mes, ano));	
		labelTotalCredito.setText("Total de credito: " + logica.getTotalDeCreditoMes(mes,ano));
		labelTotalDebito.setText("Total de debito: " + logica.getTotalDeDebitosMes(mes,ano));
	}
}
