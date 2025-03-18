package com.example.sesion4.controller;

import com.example.sesion4.model.SudokuAdapter;
import com.example.sesion4.model.SudokuBoard;
import com.example.sesion4.model.SudokuGenerator;
import com.example.sesion4.model.SudokuLogic;
import com.example.sesion4.model.VerifySudoku;
import com.example.sesion4.view.GameV;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {
    private TextField[][] cells = new TextField[6][6];

    @FXML private TextField cell1;
    @FXML private TextField cell2;
    @FXML private TextField cell3;
    @FXML private TextField cell4;
    @FXML private TextField cell5;
    @FXML private TextField cell6;
    @FXML private TextField cell7;
    @FXML private TextField cell8;
    @FXML private TextField cell9;
    @FXML private TextField cell10;
    @FXML private TextField cell11;
    @FXML private TextField cell12;
    @FXML private TextField cell13;
    @FXML private TextField cell14;
    @FXML private TextField cell15;
    @FXML private TextField cell16;
    @FXML private TextField cell17;
    @FXML private TextField cell18;
    @FXML private TextField cell19;
    @FXML private TextField cell20;
    @FXML private TextField cell21;
    @FXML private TextField cell22;
    @FXML private TextField cell23;
    @FXML private TextField cell24;
    @FXML private TextField cell25;
    @FXML private TextField cell26;
    @FXML private TextField cell27;
    @FXML private TextField cell28;
    @FXML private TextField cell29;
    @FXML private TextField cell30;
    @FXML private TextField cell31;
    @FXML private TextField cell32;
    @FXML private TextField cell33;
    @FXML private TextField cell34;
    @FXML private TextField cell35;
    @FXML private TextField cell36;

    private GameV view;

    private SudokuLogic sudokuLogic;
    private SudokuBoard sudokuBoard;

    public GameController(GameV view){
        this.view = view;
    }
    public GameController() {
    }

    @FXML
    public void initialize() {
    
        SudokuGenerator sudokuGenerator = new SudokuGenerator();
        VerifySudoku verifySudoku = new VerifySudoku();

        initializeCellsMatrix();
        this.sudokuLogic = new SudokuAdapter(sudokuGenerator,verifySudoku);
        sudokuBoard = sudokuLogic.generateBoard();

        initialTable();
    }

    private void initializeCellsMatrix() {
        cells[0][0] = cell1;
        cells[0][1] = cell2;
        cells[0][2] = cell7;
        cells[1][0] = cell3;
        cells[1][1] = cell4;
        cells[1][2] = cell9;

        cells[0][3] = cell8;
        cells[0][4] = cell13;
        cells[0][5] = cell14;
        cells[1][3] = cell10;
        cells[1][4] = cell15;
        cells[1][5] = cell16;

        cells[2][0] = cell5;
        cells[2][1] = cell6;
        cells[2][2] = cell11;
        cells[3][0] = cell19;
        cells[3][1] = cell20;
        cells[3][2] = cell25;

        cells[2][3] = cell12;
        cells[2][4] = cell17;
        cells[2][5] = cell18;
        cells[3][3] = cell26;
        cells[3][4] = cell31;
        cells[3][5] = cell32;
    
        cells[4][0] = cell21;
        cells[4][1] = cell22;
        cells[4][2] = cell27;
        cells[5][0] = cell23;
        cells[5][1] = cell24;
        cells[5][2] = cell29;
    
        cells[4][3] = cell28;
        cells[4][4] = cell33;
        cells[4][5] = cell34;
        cells[5][3] = cell30;
        cells[5][4] = cell35;
        cells[5][5] = cell36;
    }

    private void initialTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (sudokuBoard.getCell(i, j) != 0) {
                    cells[i][j].setText(String.valueOf(sudokuBoard.getCell(i, j)));
                    cells[i][j].setEditable(false); 
                    cells[i][j].setStyle("-fx-control-inner-background: #ADD8E6;"); 
                } else {
                    cells[i][j].setText("");
                }
            }
        }
    }

    public void setView(GameV view) {
        this.view = view;
    }

    
    @FXML
    public void handleButtonClick(ActionEvent event) {
        int attempts = 0;
        int maxAttempts = 100; 
    
        do {
            int row = sudokuLogic.getRandomNumber(0, 5);
            int column = sudokuLogic.getRandomNumber(0, 5);
    
            if (sudokuBoard.getCell(row, column) == 0) {
                int value = sudokuLogic.getRandomNumber(1, 6);
                sudokuBoard.setCell(row, column, value);
                sudokuLogic.setBoard(sudokuBoard);
    
                if (sudokuLogic.verify(value, row, column) && sudokuLogic.verifyMiniBoard(value, row, column)) {
                    cells[row][column].setText(String.valueOf(value));
                    break;
                } else {
                    sudokuBoard.setCell(row, column, 0);
                    sudokuLogic.setBoard(sudokuBoard);
                }
            }
    
            attempts++;
            if (attempts >= maxAttempts) {
                break; 
            }
    
        } while (true);
    }
    

}