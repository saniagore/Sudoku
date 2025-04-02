package com.example.sesion4.model;

import javafx.scene.control.TextField;

public class Listener {

    public interface TextChangeCallback {
        void onTextChanged(CellInfo cellInfo, String oldValue, String newValue);
    }

    public static void addTextListener(CellInfo cellInfo, TextChangeCallback callback) {
        cellInfo.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            callback.onTextChanged(cellInfo, oldValue, newValue);
        });
    }


    public static class CellInfo {
        public final TextField textField;
        public final int row;
        public final int col;
        public boolean isClue;
        public boolean isValid;

        public CellInfo(TextField textField, int row, int col) {
            this.textField = textField;
            this.row = row;
            this.col = col;
            this.isClue = false;
            this.isValid = true;
        }

        public void setIsClue(){
            isClue = true;
        }

        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }
    }

    public static void removeTextListener(CellInfo cellInfo) {
        cellInfo.textField.textProperty().removeListener((observable, oldValue, newValue) -> {});
        cellInfo.setIsClue();
        cellInfo.textField.setEditable(false);
    }
}
