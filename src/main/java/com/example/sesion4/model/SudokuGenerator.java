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
        int casilla = 0;
        int randomValue = 0;
        
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 2; j++) {
                do {
                    casilla = getRandomNumber(i * 6, (i + 1) * 6 - 1); 
                    randomValue = getRandomNumber(1, 6);
                    if (board.getCell(casilla) == 0) {
                        board.setCell(casilla, randomValue);
                        break; 
                    }
                } while (true); 
            }
        }
        
        return board;
    }

}