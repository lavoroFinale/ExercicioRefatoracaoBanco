package com.bcopstein.ExercicioRefatoracaoBanco;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TelaOperacoes {
	private Stage mainStage; 
	private Scene cenaEntrada;
	private Scene cenaOperacoes;
	
	private TextField tfValorOperacao;
	private TextField tfSaldo;
	
	private LogicaOperacoes logica;
	
	private ListView<Operacao> extrato;

	

	public TelaOperacoes(Stage mainStage, Scene telaEntrada) { // Tirar esse parâmetro																					// conta
		this.mainStage = mainStage;
		this.cenaEntrada = telaEntrada;
		this.logica = logica.getInstance();
	}

	public Scene getTelaOperacoes() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Conta conta = logica.getContaAtual();

        String dadosCorr = conta.getNumero() + " : " + conta.getCorrentista();
        Text scenetitle = new Text(dadosCorr);
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        
        String categoria = "Categoria: "+conta.getStrStatus();
        String limRetDiaria = "Limite retirada diaria: "+conta.getLimRetiradaDiaria();
        
        Label cat = new Label(categoria);
        grid.add(cat, 0, 1);

        Label lim = new Label(limRetDiaria);
        grid.add(lim, 0, 2);
        
        Label tit = new Label("Ultimos movimentos");
        grid.add(tit,0,3);
        
        
        extrato = new ListView<>(FXCollections.observableArrayList(logica.getOperacoes()));
        extrato.setPrefHeight(140);
        grid.add(extrato, 0, 4);

        tfSaldo = new TextField();
        tfSaldo.setDisable(true);
        tfSaldo.setText(""+conta.getSaldo());
        HBox valSaldo = new HBox(20);        
        valSaldo.setAlignment(Pos.BOTTOM_LEFT);
        valSaldo.getChildren().add(new Label("Saldo"));
        valSaldo.getChildren().add(tfSaldo);
        grid.add(valSaldo, 0, 5);        

        tfValorOperacao = new TextField();
        HBox valOper = new HBox(30);        
        valOper.setAlignment(Pos.BOTTOM_CENTER);
        valOper.getChildren().add(new Label("Valor operacao"));
        valOper.getChildren().add(tfValorOperacao);
        grid.add(valOper, 1, 1);        

        Button btnCredito = new Button("Credito");
        Button btnDebito = new Button("Debito");
        Button btnEstatisticas = new Button("Estatisticas");
        Button btnVoltar = new Button("Voltar");
        HBox hbBtn = new HBox(20);
        hbBtn.setAlignment(Pos.TOP_CENTER);
        hbBtn.getChildren().add(btnCredito);
        hbBtn.getChildren().add(btnDebito);
        hbBtn.getChildren().add(btnEstatisticas);
        hbBtn.getChildren().add(btnVoltar);
        grid.add(hbBtn, 1, 2);
        
        btnCredito.setOnAction(e->{
        	try {
        	  double valor = Integer.parseInt(tfValorOperacao.getText());
        	  
        	  logica.credito(valor);
        	  extrato.setItems(FXCollections.observableArrayList(logica.getOperacoes()));
        	  
        	  tfSaldo.setText(""+conta.getSaldo());
        	  cat.setText("Categoria " + conta.getStrStatus());
        	  lim.setText("Limite retirada diaria: "+conta.getLimRetiradaDiaria());
        	  
        	}catch(NumberFormatException ex) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Valor inválido !!");
				alert.setHeaderText(null);
				alert.setContentText("Valor inválido para operacao de crédito!!");

				alert.showAndWait();
        	}        	
        });
        
        btnDebito.setOnAction(e->{
        	try {
          	  double valor = Integer.parseInt(tfValorOperacao.getText());
          	  
              logica.debito(valor); 
              extrato.setItems(FXCollections.observableArrayList(logica.getOperacoes()));
              
        	  tfSaldo.setText(""+ conta.getSaldo());
          	  tfSaldo.setText(""+ conta.getSaldo());
          	  
          	  cat.setText("Categoria " + conta.getStrStatus());
          	  lim.setText("Limite retirada diaria: "+conta.getLimRetiradaDiaria());
          	  
          	}catch(NumberFormatException ex) {
  				Alert alert = new Alert(AlertType.WARNING);
  				alert.setTitle("Valor inválido !!");
  				alert.setHeaderText(null);
  				alert.setContentText("Valor inválido para operacao de débito!");

  				alert.showAndWait();
          	}        	
        });
        
        btnEstatisticas.setOnAction(e -> {
        	TelaEstatisticas tela = new TelaEstatisticas(mainStage,cenaOperacoes);
        	mainStage.setScene(tela.getScene());
        });

        btnVoltar.setOnAction(e->{
        	mainStage.setScene(cenaEntrada);
        });
		
        cenaOperacoes = new Scene(grid);
        return cenaOperacoes;
	}

}
