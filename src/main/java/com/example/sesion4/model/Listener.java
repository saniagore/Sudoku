package com.example.sesion4.model;

import javafx.scene.control.TextField;

public class Listener {
    
    public class CellInfo {
        public final TextField textField;
        public final int row;
        public final int col;

    
        public CellInfo(TextField textField, int row, int col) {
            this.textField = textField;
            this.row = row;
            this.col = col;
        }
    }

    public void addTextListener(CellInfo cellInfo) {
        cellInfo.textField.textProperty().addListener((observable, oldValue, newValue) -> {

        });
    }
}
