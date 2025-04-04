package com.example.sesion4.model;

/**
 * The SudokuBoard class represents a 6x6 Sudoku game board.
 * It provides basic operations for accessing and modifying individual cells
 * and the entire board state.
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class SudokuBoard {
    private int[][] board;

    /**
     * Constructs a new 6x6 Sudoku board initialized with zeros.
     * Zero represents an empty cell in the Sudoku puzzle.
     */
    public SudokuBoard() {
        board = new int[6][6];
    }

    /**
     * Retrieves the value from a specific cell on the board.
     * 
     * @param row The row index (0-5)
     * @param col The column index (0-5)
     * @return The value at the specified cell (0-6), where 0 represents an empty cell
     * @throws ArrayIndexOutOfBoundsException if row or column indices are out of bounds
     */
    public int getCell(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets the value of a specific cell on the board.
     * 
     * @param row The row index (0-5)
     * @param col The column index (0-5)
     * @param value The value to set (0-6), where 0 represents an empty cell
     * @throws ArrayIndexOutOfBoundsException if row or column indices are out of bounds
     */
    public void setCell(int row, int col, int value) {
        board[row][col] = value;
    }

    /**
     * Retrieves the complete 6x6 board state.
     * 
     * @return A 6x6 two-dimensional array representing the current board state
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Replaces the entire board with a new state.
     * 
     * @param board A 6x6 two-dimensional array representing the new board state
     * @throws IllegalArgumentException if the provided array is not 6x6
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }
}