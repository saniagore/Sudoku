package com.example.sesion4.model;

import javafx.scene.control.TextField;

/**
 * The Listener class provides functionality for managing text field listeners in a Sudoku game UI.
 * It handles text change events for Sudoku cells and maintains cell state information.
 * 
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class Listener {

    /**
     * Functional interface for handling text change events in Sudoku cells.
     */
    public interface TextChangeCallback {
        /**
         * Callback method invoked when text changes in a Sudoku cell.
         *
         * @param cellInfo Information about the cell that changed
         * @param oldValue The previous text value
         * @param newValue The new text value
         */
        void onTextChanged(CellInfo cellInfo, String oldValue, String newValue);
    }

    /**
     * Adds a text change listener to a Sudoku cell.
     *
     * @param cellInfo The cell information object
     * @param callback The callback to invoke when text changes
     */
    public static void addTextListener(CellInfo cellInfo, TextChangeCallback callback) {
        cellInfo.textField.textProperty().addListener((observable, oldValue, newValue) -> {
            callback.onTextChanged(cellInfo, oldValue, newValue);
        });
    }

    /**
     * Removes text change listeners from a Sudoku cell and marks it as a clue.
     * Makes the cell non-editable after removal.
     *
     * @param cellInfo The cell information object to modify
     */
    public static void removeTextListener(CellInfo cellInfo) {
        cellInfo.textField.textProperty().removeListener((observable, oldValue, newValue) -> {});
        cellInfo.setIsClue();
        cellInfo.textField.setEditable(false);
    }

    /**
     * Represents information about a Sudoku cell in the UI.
     */
    public static class CellInfo {
        /** The text field representing the cell */
        public final TextField textField;
        /** The row index of the cell */
        public final int row;
        /** The column index of the cell */
        public final int col;
        /** Flag indicating if this cell is a clue (pre-filled) */
        public boolean isClue;
        /** Flag indicating if the cell's current value is valid */
        public boolean isValid;

        /**
         * Creates a new CellInfo instance.
         *
         * @param textField The associated text field
         * @param row The row index (0-based)
         * @param col The column index (0-based)
         */
        public CellInfo(TextField textField, int row, int col) {
            this.textField = textField;
            this.row = row;
            this.col = col;
            this.isClue = false;
            this.isValid = true;
        }

        /**
         * Marks this cell as a clue (pre-filled value).
         */
        public void setIsClue() {
            isClue = true;
        }

        /**
         * Sets the validity state of this cell.
         *
         * @param isValid true if the cell's value is valid, false otherwise
         */
        public void setIsValid(boolean isValid) {
            this.isValid = isValid;
        }
    }
}