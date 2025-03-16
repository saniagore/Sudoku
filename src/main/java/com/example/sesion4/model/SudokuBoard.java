package com.example.sesion4.model;

public class SudokuBoard {
    private int[][] board;

    public SudokuBoard() {
        board = new int[6][6];
    }

    public int getCell(int row, int col) {
        return board[row][col];
    }

    public void setCell(int row, int col, int value) {
        board[row][col] = value;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}