package com.example.sesion4.model;

public interface SudokuLogic {

    SudokuBoard generateBoard();

    boolean verify(int value, int row, int column);

    boolean verifyMiniBoard(int value, int row, int colum);
}