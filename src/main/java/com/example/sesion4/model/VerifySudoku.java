package com.example.sesion4.model;

public class VerifySudoku {
    private SudokuBoard board;

    public VerifySudoku(){
        this.board = new SudokuBoard();
    }
    
    public boolean verify(int value, int row, int colum){
        
        int[] columnValues = verifyColumnBoard(colum);
        int[] rowValues = verifyRowBoard(row);

        if(counter(value, rowValues)>=2 || counter(value, columnValues)>=2){
            return false;
        }
        return true;
    }

    public int[] verifyColumnBoard(int colum){
        int [] columnValues= new int[6];

        for(int i = 0; i<6; i++){
            columnValues[i] = board.getCell(i, colum);
        }
        return columnValues;
    }

    public int[] verifyRowBoard(int row){
        int [] rowValues= new int[6];
        for(int i = 0; i<6; i++){
            rowValues[i] = board.getCell(row, i);
        }
        return rowValues;
    }

    public void setBoard(SudokuBoard board){
        this.board = board;
    }

    public int counter (int value, int [] array){
        int count = 0;

        for(int i = 0; i<6;i++){
            if(value == array[i]){
                count++;
            }

        }
        return count;
    }

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
}
