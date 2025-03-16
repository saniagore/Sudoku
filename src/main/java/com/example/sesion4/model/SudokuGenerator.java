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

        for(int j = 0; j<2; j++){
            for(int i= 0; i<3;i++){
                board.setCell(getRandomNumber(j*3, j*3+2), getRandomNumber(i*2, i*2+1), getRandomNumber(1,6));
            }
        }
        return board;
    }

}