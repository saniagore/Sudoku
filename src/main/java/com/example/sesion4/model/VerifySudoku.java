package com.example.sesion4.model;

/**
 * The VerifySudoku class provides validation logic for a 6x6 Sudoku board.
 * It checks the validity of number placements according to Sudoku rules:
 * - No duplicates in rows
 * - No duplicates in columns
 * - No duplicates in 2x3 sub-matrices
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class VerifySudoku {
    private SudokuBoard board;

    /**
     * Constructs a VerifySudoku instance with a new SudokuBoard.
     */
    public VerifySudoku(){
        this.board = new SudokuBoard();
    }
    
    /**
     * Verifies if a value can be placed at the specified position according to Sudoku rules.
     * Checks for duplicates in the row and column.
     * 
     * @param value The number to verify (1-6)
     * @param row The row index (0-5)
     * @param colum The column index (0-5)
     * @return true if the placement is valid, false if it violates Sudoku rules
     */
    public boolean verify(int value, int row, int colum){
        int[] columnValues = verifyColumnBoard(colum);
        int[] rowValues = verifyRowBoard(row);

        if(counter(value, rowValues)>=2 || counter(value, columnValues)>=2){
            return false;
        }
        return true;
    }

    /**
     * Retrieves all values from the specified column.
     * 
     * @param colum The column index (0-5)
     * @return An array containing all values in the specified column
     */
    public int[] verifyColumnBoard(int colum){
        int[] columnValues = new int[6];

        for(int i = 0; i<6; i++){
            columnValues[i] = board.getCell(i, colum);
        }
        return columnValues;
    }

    /**
     * Retrieves all values from the specified row.
     * 
     * @param row The row index (0-5)
     * @return An array containing all values in the specified row
     */
    public int[] verifyRowBoard(int row){
        int[] rowValues = new int[6];
        for(int i = 0; i<6; i++){
            rowValues[i] = board.getCell(row, i);
        }
        return rowValues;
    }

    /**
     * Sets the Sudoku board to be verified.
     * 
     * @param board The SudokuBoard instance to use for verification
     */
    public void setBoard(SudokuBoard board){
        this.board = board;
    }

    /**
     * Counts occurrences of a value in an array.
     * 
     * @param value The value to count
     * @param array The array to search
     * @return The number of times the value appears in the array
     */
    public int counter(int value, int[] array){
        int count = 0;

        for(int i = 0; i<6; i++){
            if(value == array[i]){
                count++;
            }
        }
        return count;
    }

    /**
     * Verifies if a value can be placed in the 2x3 sub-matrix according to Sudoku rules.
     * 
     * @param value The number to verify (1-6)
     * @param row The row index (0-5)
     * @param colum The column index (0-5)
     * @return true if the placement is valid in the sub-matrix, false if it violates Sudoku rules
     */
    public boolean verifyMiniBoard(int value, int row, int colum) {
        int submatrizFila = (row / 2) * 2; 
        int submatrizColumna = (colum / 3) * 3;
    
        int count = 0;
        for (int i = submatrizFila; i < submatrizFila + 2; i++) { 
            for (int j = submatrizColumna; j < submatrizColumna + 3; j++) { 
                if (board.getCell(i, j) == value) {
                    count++;
                    if (count > 1) {
                        return false; 
                    }
                }
            }
        }
    
        return true; 
    }

    /**
     * Sets a value in the Sudoku board at the specified position.
     * 
     * @param row The row index (0-5)
     * @param col The column index (0-5)
     * @param value The value to set (1-6)
     */
    public void setCell(int row, int col, int value){
        board.setCell(row, col, value);
    }
}