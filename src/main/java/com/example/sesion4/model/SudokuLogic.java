package com.example.sesion4.model;

public interface SudokuLogic {

    SudokuBoard generateBoard();

    int getRandomNumber(int min, int max);

    boolean verify(int value, int row, int column);

    boolean verifyMiniBoard(int value, int row, int colum);

    void setBoard(SudokuBoard board);
}