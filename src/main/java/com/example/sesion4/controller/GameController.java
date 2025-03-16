package com.example.sesion4.controller;

import com.example.sesion4.model.SudokuBoard;
import com.example.sesion4.model.SudokuGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {
    // Matriz de 6x6 para los TextField
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

    private TextField[] allCells;
    private SudokuGenerator sudokuGenerator;
    private SudokuBoard sudokuBoard;

    @FXML
    public void initialize() {
        allCells = new TextField[] {
            cell1, cell2, cell3, cell4, cell5, cell6,
            cell7, cell8, cell9, cell10, cell11, cell12,
            cell13, cell14, cell15, cell16, cell17, cell18,
            cell19, cell20, cell21, cell22, cell23, cell24,
            cell25, cell26, cell27, cell28, cell29, cell30,
            cell31, cell32, cell33, cell34, cell35, cell36
        };

        initializeCellsMatrix();

        sudokuGenerator = new SudokuGenerator();
        sudokuBoard = sudokuGenerator.generateBoard();

        updateView();
    }

    private void initializeCellsMatrix() {
        cells[0][0] = cell1;
        cells[0][1] = cell2;
        cells[1][0] = cell3;
        cells[1][1] = cell4;
        cells[2][0] = cell5;
        cells[2][1] = cell6;

        cells[0][2] = cell7;
        cells[0][3] = cell8;
        cells[1][2] = cell9;
        cells[1][3] = cell10;
        cells[2][2] = cell11;
        cells[2][3] = cell12;

        cells[0][4] = cell13;
        cells[0][5] = cell14;
        cells[1][4] = cell15;
        cells[1][5] = cell16;
        cells[2][4] = cell17;
        cells[2][5] = cell18;

        cells[3][0] = cell19;
        cells[3][1] = cell20;
        cells[4][0] = cell21;
        cells[4][1] = cell22;
        cells[5][0] = cell23;
        cells[5][1] = cell24;
        cells[3][2] = cell25;
        cells[3][3] = cell26;
        cells[4][2] = cell27;
        cells[4][3] = cell28;
        cells[5][2] = cell29;
        cells[5][3] = cell30;
        cells[3][4] = cell31;
        cells[3][5] = cell32;
        cells[4][4] = cell33;
        cells[4][5] = cell34;
        cells[5][4] = cell35;
        cells[5][5] = cell36;
    }

    private void updateView() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (sudokuBoard.getCell(i, j) != 0) {
                    cells[i][j].setText(String.valueOf(sudokuBoard.getCell(i, j)));
                } else {
                    cells[i][j].setText("");
                }
            }
        }
    }
    
}