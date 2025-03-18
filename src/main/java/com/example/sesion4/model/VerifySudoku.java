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
        // Determinar la posición de la miniboard (2x3)
        int submatrizFila = (row / 2) * 2; // Fila inicial de la miniboard
        int submatrizColumna = (colum / 3) * 3; // Columna inicial de la miniboard
    
        int count = 0;
    
        // Iterar sobre la miniboard (2 filas y 3 columnas)
        for (int i = submatrizFila; i < submatrizFila + 2; i++) { // 2 filas
            for (int j = submatrizColumna; j < submatrizColumna + 3; j++) { // 3 columnas
                if (board.getCell(i, j) == value) {
                    count++;
                    if (count > 1) {
                        return false; // Si el valor aparece más de una vez, es inválido
                    }
                }
            }
        }
    
        return true; 
    }
}
