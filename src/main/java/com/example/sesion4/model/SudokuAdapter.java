package com.example.sesion4.model;

public class SudokuAdapter implements SudokuLogic {
    private SudokuGenerator sudokuGenerator;
    private VerifySudoku verifySudoku;

    // Constructor para inicializar las dependencias
    public SudokuAdapter(SudokuGenerator sudokuGenerator, VerifySudoku verifySudoku) {
        this.sudokuGenerator = sudokuGenerator;
        this.verifySudoku = verifySudoku;
    }

    @Override
    public SudokuBoard generateBoard() {
        return sudokuGenerator.generateBoard();
    }

    @Override
    public boolean verify(int value, int row, int column) {
        return verifySudoku.verify(value, row, column);
    }
}