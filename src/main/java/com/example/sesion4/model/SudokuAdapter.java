package com.example.sesion4.model;

public class SudokuAdapter implements SudokuLogic {
    private SudokuBoard board;
    private SudokuGenerator sudokuGenerator;
    private VerifySudoku verifySudoku;

    // Constructor para inicializar las dependencias
    public SudokuAdapter(SudokuGenerator sudokuGenerator, VerifySudoku verifySudoku) {
        SudokuBoard board = new SudokuBoard();
        this.sudokuGenerator = sudokuGenerator;
        this.verifySudoku = verifySudoku;
    }

    @Override
    public int getRandomNumber(int min, int max){
        return sudokuGenerator.getRandomNumber(min,max);
    }

    @Override
    public SudokuBoard generateBoard() {
        return sudokuGenerator.generateBoard();
    }

    @Override
    public boolean verify(int value, int row, int column) {
        return verifySudoku.verify(value, row, column);
    }

    @Override
    public boolean verifyMiniBoard(int value, int row, int colum){
        return verifySudoku.verifyMiniBoard(value, row, colum);
    }

    @Override
    public void setBoard(SudokuBoard board){
        this.board = board;
    }
}