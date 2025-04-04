package com.example.sesion4.model;

import java.util.Random;

/**
 * The SudokuGenerator class handles the generation of valid 6x6 Sudoku boards
 * and provides functionality to generate random clues for the puzzle.
 * It implements the core logic for creating playable Sudoku games.
 *
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class SudokuGenerator {
    private SudokuBoard board;
    private VerifySudoku verify;

    /**
     * Constructs a new SudokuGenerator with an empty board and verification system.
     */
    public SudokuGenerator() {
        board = new SudokuBoard();
        verify = new VerifySudoku();
    }

    /**
     * Generates a random number within the specified range (inclusive).
     * 
     * @param min The minimum value of the range (inclusive)
     * @param max The maximum value of the range (inclusive)
     * @return A random integer between min and max (inclusive)
     */
    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Generates a complete, valid 6x6 Sudoku board.
     * The board is filled according to Sudoku rules with numbers 1-6,
     * ensuring no duplicates in rows, columns, or 2x3 sub-matrices.
     * 
     * @return A fully generated SudokuBoard that satisfies all Sudoku rules
     */
    public SudokuBoard generateBoard() {
        int row = 0;
        int colum = 0;
        int value = 0;

        // Fills the board in 3 passes (for each 2-row band)
        for(int j = 0; j<3; j++){
            // Processes each of the 2 3-column blocks in the band
            for(int i = 0; i<2; i++){
                // Places 2 numbers in each block
                for(int k=0; k<2; k++){
                    do{
                        // Randomly selects position within current 2x3 sub-matrix
                        row = getRandomNumber(j*2, j*2+1);
                        colum = getRandomNumber(i*3,i*3+2);
                        value = getRandomNumber(1, 6);
                        
                        if(board.getCell(row, colum)==0){
                            board.setCell(row, colum, value);
                            verify.setBoard(board);

                            // Validates the placement
                            if(verify.verify(value, row, colum) && verify.verifyMiniBoard(value, row, colum)){
                                break;
                            }else{
                                board.setCell(row, colum, 0);
                                verify.setBoard(board);
                            }
                        }
                        
                    }while(true);
                }
            }
        }
        return board;
    }

    /**
     * Generates a random valid clue (pre-filled cell) on the current board.
     * Attempts to find an empty cell and fill it with a valid number.
     * Includes a safety counter to prevent infinite loops.
     * 
     * @return The SudokuBoard with one additional valid clue added,
     *         or the original board if no valid placement found after 100 attempts
     */
    public SudokuBoard randomClue(){
        int row = 0;
        int colum = 0;
        int value = 0;
        int counter = 0;

        do{
            row = getRandomNumber(0, 5);
            colum = getRandomNumber(0,5);
            value = getRandomNumber(1, 6);
            counter++;
            
            if(board.getCell(row, colum)==0){
                board.setCell(row, colum, value);
                verify.setBoard(board);

                if(verify.verify(value, row, colum) && verify.verifyMiniBoard(value, row, colum)){
                    break;
                }else{
                    board.setCell(row, colum, 0);
                    verify.setBoard(board);
                }
            }

            if(counter>100){
                break;
            }
                        
        }while(true);
                
        return board;
    }
}