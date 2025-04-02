package com.example.sesion4.model;

import javafx.scene.control.TextField;

public class Listener {
    public static void addTextListener(CellInfo cellInfo) {
        cellInfo.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            /*
             * logica a implementar
             */


        });
    }

    public static class CellInfo {
        public final TextField textField;
        public final int row;
        public final int col;
        public boolean isClue;

        public CellInfo(TextField textField, int row, int col) {
            this.textField = textField;
            this.row = row;
            this.col = col;
            this.isClue = false;
        }

        public void setIsClue(){
            isClue = true;
        }
    }

    public static void removeTextListener(CellInfo cellInfo) {
        cellInfo.textField.textProperty().removeListener((observable, oldValue, newValue) -> {});
        cellInfo.setIsClue();
        cellInfo.textField.setEditable(false);
    }
}
