package com.example.sesion4.model;

import java.util.Random;

public class SudokuGenerator {
    private SudokuBoard board;
    private VerifySudoku verify;

    public SudokuGenerator() {
        board = new SudokuBoard();
        verify = new VerifySudoku();
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public SudokuBoard generateBoard() {
        int row = 0;
        int colum = 0;
        int value = 0;

        for(int j = 0; j<2; j++){

            for(int i = 0; i<3; i++){

                for(int k=0; k<2; k++){
                    do{
                        row = getRandomNumber(j*3, 2+j*3);
                        colum = getRandomNumber(i*2, 2*i+1);
                        value = getRandomNumber(1, 6);
                        
                        if(board.getCell(row, colum)==0){
                            board.setCell(row, colum, value);
                            verify.setBoard(board);

                            if(verify.verify(value, row, colum) ){
                                break;
                            }else{
                                board.setCell(row, colum, 0);
                                verify.setBoard(board);
                            }
                        }
                        
                    }while(true);
                }
            }
        }
        return board;
    }

}