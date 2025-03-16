package com.example.sesion4.model;

import java.util.Random;

public class SudokuGenerator {
    private SudokuBoard board;

    public SudokuGenerator() {
        board = new SudokuBoard();
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public SudokuBoard generateBoard() {
        int row = 0;
        int colum = 0;
        int value = 0;

        for(int i = 0; i<3; i++){
            for(int k=0; k<2; k++){
                do{
                    row = getRandomNumber(0, 2);
                    colum = getRandomNumber(i*2, 2*i+1);
                    value = getRandomNumber(1, 6);

                    if(board.getCell(row, colum)==0){
                        board.setCell(row, colum, value);
                        break;
                    }
                }while(true);
            }
        }
        return board;
    }

}