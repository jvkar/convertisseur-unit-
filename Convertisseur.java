package com.example.tp1;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Convertisseur extends Application {
    private double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    private double kilometersToMiles(double kilometers) {
        return kilometers * 0.621371;
    }
    private double metresParsToKilometresParh(double metres) {
        return metres * 3.6;
    }
    private double kilogrammeenlivre(double kilogramme) {
        return kilogramme * 2.20462;
    }
    public void start(Stage premierStage)  {
        premierStage.show();

        ObservableList<String> options = FXCollections.observableArrayList("degrés Celsius en Fahrenheit", "kilomètres en miles","m/s en k/h","kilogramme en livre");

        ComboBox<String> select = new ComboBox<>(options);
        select.setValue("Selrctionner une option");
        select.setStyle("-fx-background-color: white;-fx-text-fill: Black");

        VBox root = new VBox();
        root.setSpacing(10);


        Scene scene = new Scene(root, 600, 200);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #000000;-fx-font-family:'Arial Black'");

        Label l1=new Label("Entrer la valeur");
        l1.setStyle("-fx-font-size: 16px;-fx-text-fill: white");

        Button converter=new Button("converter");
        converter.setStyle("-fx-background-color: white;-fx-text-fill: Black;-fx-max-width: 150px");


        Label l3 =new Label("LE RESULTAT :");
        l3.setStyle("-fx-font-size: 16px;-fx-text-fill: white");
        Label l4 =new Label("0");
        l4.setStyle("-fx-font-size: 16px;-fx-text-fill: white");
        Label l5 =new Label("");
        l5.setStyle("-fx-font-size: 16px;-fx-text-fill: white");
        TextField number= new TextField();
        HBox hbox1=new HBox(l1,number,select);
        HBox hbox2=new HBox(converter);
        HBox hbox3=new HBox(l3,l4);
        HBox hbox4=new HBox(l5);
        hbox1.setAlignment(Pos.CENTER);
        hbox2.setAlignment(Pos.CENTER);
        hbox3.setAlignment(Pos.CENTER);
        hbox4.setAlignment(Pos.CENTER);
        hbox1.setSpacing(10);
        root.getChildren().addAll(hbox1,hbox2,hbox3,hbox4);
        number.textProperty().addListener((observable, precval, nouvval) -> {
            try {
                Double.parseDouble(nouvval);

                l5.setText("");
            } catch (NumberFormatException e) {

                l5.setText("Attention : Entrer que des nombres");
            }
        });
        converter.setOnAction(event -> {
            double valeur;
            String option = select.getValue();
            try {
                valeur = Double.parseDouble(number.getText());

                if ("degrés Celsius en Fahrenheit".equals(option)) {
                    double resultat = celsiusToFahrenheit(valeur);
                    l4.setText("" + resultat);
                }
                if ("kilomètres en miles".equals(option)) {
                    double resultat = kilometersToMiles(valeur);
                    l4.setText("" + resultat);
                }
                if ("m/s en k/h".equals(option)) {
                    double resultat = metresParsToKilometresParh(valeur);
                    l4.setText("" + resultat);
                }
                if ("kilogramme en livre".equals(option)) {
                    double resultat = kilogrammeenlivre(valeur);
                    l4.setText("" + resultat);
                }
            } catch (NumberFormatException e) {
                l5.setText("entrer que des nombres");
            }

        });
        premierStage.setTitle("Convertisseur unite");
        premierStage.setScene(scene);

    }
    public static void main(String args[]){
        launch(args);
    }  }

