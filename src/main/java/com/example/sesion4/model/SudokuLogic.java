package com.example.sesion4.model;

/**
 * The SudokuLogic interface defines the core operations for a Sudoku game.
 * It provides methods for board generation, validation, and game management
 * for a 6x6 Sudoku implementation.
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public interface SudokuLogic {

    /**
     * Generates a new valid Sudoku board.
     * 
     * @return A new SudokuBoard instance with a valid puzzle configuration
     */
    SudokuBoard generateBoard();



    /**
     * Verifies if a value can be placed at the specified position according to Sudoku rules.
     * Checks for duplicates in the row and column.
     * 
     * @param value The number to verify (1-6)
     * @param row The row index (0-5)
     * @param column The column index (0-5)
     * @return true if the placement is valid, false if it violates Sudoku rules
     */
    boolean verify(int value, int row, int column);

    /**
     * Provides a random clue (pre-filled cell) for the current board.
     * 
     * @return A SudokuBoard containing one randomly revealed cell
     */
    SudokuBoard randomClue();

    /**
     * Sets the current Sudoku board to operate on.
     * 
     * @param board The SudokuBoard instance to use for operations
     */
    void setBoard(SudokuBoard board);

    /**
     * Sets a value in the current Sudoku board at the specified position.
     * 
     * @param row The row index (0-5)
     * @param col The column index (0-5)
     * @param value The value to set (1-6)
     */
    void setCell(int row, int col, int value);
}