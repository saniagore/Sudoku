package com.example.sesion4.model;

/**
 * The SudokuAdapter class implements the SudokuLogic interface and acts as an intermediary
 * between the game components and the core Sudoku logic. It delegates operations to
 * appropriate specialized classes (SudokuGenerator and VerifySudoku).
 * 
 * This class follows the Adapter pattern to provide a unified interface for Sudoku operations.
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class SudokuAdapter implements SudokuLogic {
    @SuppressWarnings("unused")
    private SudokuBoard board;
    private SudokuGenerator sudokuGenerator;
    private VerifySudoku verifySudoku;

    /**
     * Constructs a SudokuAdapter with specified generator and verifier components.
     * 
     * @param sudokuGenerator The SudokuGenerator instance to handle board generation
     * @param verifySudoku The VerifySudoku instance to handle game validation
     */
    public SudokuAdapter(SudokuGenerator sudokuGenerator, VerifySudoku verifySudoku) {
        this.board = new SudokuBoard();
        this.sudokuGenerator = sudokuGenerator;
        this.verifySudoku = verifySudoku;
    }

    /**
     * Generates a random number within the specified range.
     * Delegates to the SudokuGenerator implementation.
     * 
     * @param min The minimum value (inclusive)
     * @param max The maximum value (inclusive)
     * @return A random number between min and max
     */
    @Override
    public int getRandomNumber(int min, int max) {
        return sudokuGenerator.getRandomNumber(min, max);
    }

    /**
     * Generates a new valid Sudoku board.
     * Delegates to the SudokuGenerator implementation.
     * 
     * @return A new SudokuBoard instance with a valid puzzle configuration
     */
    @Override
    public SudokuBoard generateBoard() {
        return sudokuGenerator.generateBoard();
    }

    /**
     * Verifies if a value can be placed at the specified position.
     * Delegates to the VerifySudoku implementation.
     * 
     * @param value The number to verify (1-6)
     * @param row The row index (0-5)
     * @param column The column index (0-5)
     * @return true if the placement is valid, false if it violates Sudoku rules
     */
    @Override
    public boolean verify(int value, int row, int column) {
        return verifySudoku.verify(value, row, column);
    }

    /**
     * Verifies if a value can be placed in the 2x3 sub-matrix.
     * Delegates to the VerifySudoku implementation.
     * 
     * @param value The number to verify (1-6)
     * @param row The row index (0-5)
     * @param column The column index (0-5)
     * @return true if the placement is valid in the sub-matrix, false otherwise
     */
    @Override
    public boolean verifyMiniBoard(int value, int row, int column) {
        return verifySudoku.verifyMiniBoard(value, row, column);
    }

    /**
     * Sets the current Sudoku board for validation.
     * Delegates to the VerifySudoku implementation.
     * 
     * @param board The SudokuBoard instance to use for validation
     */
    @Override
    public void setBoard(SudokuBoard board) {
        verifySudoku.setBoard(board);
    }

    /**
     * Generates a random valid clue on the current board.
     * Delegates to the SudokuGenerator implementation.
     * 
     * @return The SudokuBoard with one additional valid clue
     */
    @Override
    public SudokuBoard randomClue() {
        return sudokuGenerator.randomClue();
    }

    /**
     * Sets a value in the current Sudoku board.
     * Delegates to the VerifySudoku implementation.
     * 
     * @param row The row index (0-5)
     * @param col The column index (0-5)
     * @param value The value to set (1-6)
     */
    @Override
    public void setCell(int row, int col, int value) {
        verifySudoku.setCell(row, col, value);
    }
}