package com.example.sesion4.model;

public class SudokuBoard {
    private int[] board;

    public SudokuBoard() {
        board = new int[36];
    }

    public int getCell(int cell) {
        return board[cell];
    }

    public void setCell(int cell, int value) {
        board[cell] = value;
    }

    public int[] getBoard() {
        return board;
    }

    public void setBoard(int[] board) {
        this.board = board;
    }
}