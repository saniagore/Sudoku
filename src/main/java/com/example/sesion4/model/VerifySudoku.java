package com.example.sesion4.model;

public class VerifySudoku {
    private SudokuBoard board;

    public VerifySudoku(){
        SudokuBoard board = new SudokuBoard();
    }
    
    public boolean verify(int value, int row, int colum){
        
        int count = 0;
        int[] columnValues = verifyColumnBoard(colum);
        int[] rowValues = verifyRowBoard(row);


        for(int i = 0; i<6;i++){
            if(value == columnValues[i]){
                count++;
            }
            if(count>=2){
                return false;
            }
        }

        count = 0;
        for(int i = 0; i<6;i++){
            if(value == rowValues[i]){
                count++;
            }
            if(count>=2){
                return false;
            }
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

}
