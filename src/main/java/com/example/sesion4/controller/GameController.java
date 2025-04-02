package com.example.sesion4.controller;

import com.example.sesion4.model.Listener;
import com.example.sesion4.model.SudokuAdapter;
import com.example.sesion4.model.SudokuBoard;
import com.example.sesion4.model.SudokuGenerator;
import com.example.sesion4.model.SudokuLogic;
import com.example.sesion4.model.VerifySudoku;
import com.example.sesion4.view.GameV;
import com.example.sesion4.view.PopupWindow;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class GameController {

    @FXML private GridPane sudokuGrid;
    private TextField[][] cells = new TextField[6][6];
    private Listener.CellInfo[][] cellInfos = new Listener.CellInfo[6][6];

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
        this.sudokuLogic = new SudokuAdapter(sudokuGenerator, verifySudoku);
        sudokuBoard = sudokuLogic.generateBoard();
        
        initializeCellsMatrix();
        viewUpdateInit();
    }

    private void initializeCellsMatrix() {
        int contador = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String cellId = "cell" + contador;
                cells[i][j] = (TextField) sudokuGrid.lookup("#" + cellId);
                if (cells[i][j] != null) {
                    cellInfos[i][j] = new Listener.CellInfo(cells[i][j], i, j);
                    Listener.addTextListener(cellInfos[i][j]);
                }
                contador++;
            }
        }
    }

    private void viewUpdateInit() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (sudokuBoard.getCell(i, j) != 0) {
                    cells[i][j].setText(String.valueOf(sudokuBoard.getCell(i, j)));
                    cells[i][j].setStyle("-fx-control-inner-background:  #ADD8E6  ;");
                    Listener.removeTextListener(cellInfos[i][j]);
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
        sudokuLogic.setBoard(sudokuBoard);
        sudokuBoard = sudokuLogic.randomClue();
    
    }

}