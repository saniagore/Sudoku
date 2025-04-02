package com.example.sesion4.model;

public class SudokuAdapter implements SudokuLogic {
    private SudokuBoard board;
    private SudokuGenerator sudokuGenerator;
    private VerifySudoku verifySudoku;

    public SudokuAdapter(SudokuGenerator sudokuGenerator, VerifySudoku verifySudoku) {
        this.board = new SudokuBoard();
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
        verifySudoku.setBoard(board);
    }

    @Override
    public SudokuBoard randomClue(){
        return sudokuGenerator.randomClue();
    }

    @Override
    public void setCell(int row, int col, int value){
        verifySudoku.setCell(row, col, value);
    }
}