package com.example.sesion4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {

    // Inyectar los 36 TextField usando fx:id
    @FXML private TextField cell1;
    @FXML private TextField cell2;
    @FXML private TextField cell3;
    @FXML private TextField cell4;
    @FXML private TextField cell5;
    @FXML private TextField cell6;
    @FXML private TextField cell7;
    @FXML private TextField cell8;
    @FXML private TextField cell9;
    @FXML private TextField cell10;
    @FXML private TextField cell11;
    @FXML private TextField cell12;
    @FXML private TextField cell13;
    @FXML private TextField cell14;
    @FXML private TextField cell15;
    @FXML private TextField cell16;
    @FXML private TextField cell17;
    @FXML private TextField cell18;
    @FXML private TextField cell19;
    @FXML private TextField cell20;
    @FXML private TextField cell21;
    @FXML private TextField cell22;
    @FXML private TextField cell23;
    @FXML private TextField cell24;
    @FXML private TextField cell25;
    @FXML private TextField cell26;
    @FXML private TextField cell27;
    @FXML private TextField cell28;
    @FXML private TextField cell29;
    @FXML private TextField cell30;
    @FXML private TextField cell31;
    @FXML private TextField cell32;
    @FXML private TextField cell33;
    @FXML private TextField cell34;
    @FXML private TextField cell35;
    @FXML private TextField cell36;

    /**
     * Método llamado automáticamente después de que se carga el FXML.
     */
    @FXML
    public void initialize() {
        // Aquí puedes inicializar el tablero y actualizar la vista
        updateView();
    }

    /**
     * Actualiza la vista con los valores del tablero.
     */
    private void updateView() {
        // Ejemplo: Asignar un valor a cada celda
        cell1.setText("1");
        cell2.setText("2");
        cell3.setText("3");
        cell4.setText("4");
        cell5.setText("5");
        cell6.setText("6");
        cell7.setText("7");
        cell8.setText("8");
        cell9.setText("9");
        cell10.setText("10");
        cell11.setText("11");
        cell12.setText("12");
        cell13.setText("13");
        cell14.setText("14");
        cell15.setText("15");
        cell16.setText("16");
        cell17.setText("17");
        cell18.setText("18");
        cell19.setText("19");
        cell20.setText("20");
        cell21.setText("21");
        cell22.setText("22");
        cell23.setText("23");
        cell24.setText("24");
        cell25.setText("25");
        cell26.setText("26");
        cell27.setText("27");
        cell28.setText("28");
        cell29.setText("29");
        cell30.setText("30");
        cell31.setText("31");
        cell32.setText("32");
        cell33.setText("33");
        cell34.setText("34");
        cell35.setText("35");
        cell36.setText("36");
    }
}