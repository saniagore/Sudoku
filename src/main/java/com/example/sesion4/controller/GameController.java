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

/**
 * The GameController class manages the game logic and user interactions
 * for the Sudoku application. It serves as the bridge between the model
 * and view components, handling cell validation, game state management,
 * and user input processing.
 * 
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class GameController {

    @FXML private GridPane sudokuGrid;
    private TextField[][] cells = new TextField[6][6];
    private Listener.CellInfo[][] cellInfos = new Listener.CellInfo[6][6];
    @SuppressWarnings("unused")
    private GameV view;
    private SudokuLogic sudokuLogic;
    private SudokuBoard sudokuBoard;

    /**
     * Constructs a GameController with a reference to the game view.
     * @param view The GameV instance representing the game view
     */
    public GameController(GameV view){
        this.view = view;
    }

    /**
     * Default constructor for FXML loading.
     */
    public GameController() {
    }

    /**
     * Initializes the controller after FXML loading completes.
     * Sets up the game board, initializes cell matrices, and updates the view.
     */
    @FXML
    public void initialize() {
        SudokuGenerator sudokuGenerator = new SudokuGenerator();
        VerifySudoku verifySudoku = new VerifySudoku();
        this.sudokuLogic = new SudokuAdapter(sudokuGenerator, verifySudoku);
        sudokuBoard = sudokuLogic.generateBoard();
        
        initializeCellsMatrix();
        viewUpdateInit();
    }

    /**
     * Initializes the cell matrices by locating all TextField elements
     * in the grid and setting up their corresponding CellInfo objects.
     */
    private void initializeCellsMatrix() {
        int contador = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String cellId = "cell" + contador;
                cells[i][j] = (TextField) sudokuGrid.lookup("#" + cellId);
                if (cells[i][j] != null) {
                    cellInfos[i][j] = new Listener.CellInfo(cells[i][j], i, j);
                    Listener.addTextListener(cellInfos[i][j], this::handleCellTextChange);
                }
                contador++;
            }
        }
    }

    /**
     * Handles text changes in Sudoku cells.
     * @param cellInfo Information about the changed cell
     * @param oldValue The previous cell value
     * @param newValue The new cell value
     */
    private void handleCellTextChange(Listener.CellInfo cellInfo, String oldValue, String newValue) {
        if (newValue.isEmpty()) {
            cells[cellInfo.row][cellInfo.col].setStyle("-fx-control-inner-background: white;");
            sudokuBoard.setCell(cellInfo.row, cellInfo.col, 0);
            verifyAllCells();
        } else if (!newValue.matches("[1-6]?")) {
            cellInfo.textField.setText(oldValue);
            PopupWindow.Window("Error!", "Only numbers from 1 to 6 are allowed");
        } else {
            int value = Integer.parseInt(newValue);
            sudokuBoard.setCell(cellInfo.row, cellInfo.col, value);
            verifyAllCells();
        }
    }

    /**
     * Verifies the validity of all cells in the Sudoku board.
     * Updates cell styles based on validation results.
     */
    private void verifyAllCells() {
        sudokuLogic.setBoard(sudokuBoard);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (!cellInfos[i][j].isClue) { 
                    int cellValue = sudokuBoard.getCell(i, j);
                    if (cellValue != 0) {
                        boolean isValid = sudokuLogic.verify(cellValue, i, j) && 
                                         sudokuLogic.verifyMiniBoard(cellValue, i, j);
                        
                        if (!isValid) {
                            cells[i][j].setStyle("-fx-control-inner-background: rgb(247, 144, 116);");
                        } else {
                            cells[i][j].setStyle("-fx-control-inner-background: white;");
                        }
                    } else {
                        cells[i][j].setStyle("-fx-control-inner-background: white;");
                    }
                }
            }
        }
    }

    /**
     * Initializes the view with the starting game state.
     * Marks clue cells and sets their initial values.
     */
    private void viewUpdateInit() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (sudokuBoard.getCell(i, j) != 0) {
                    cells[i][j].setText(String.valueOf(sudokuBoard.getCell(i, j)));
                    cells[i][j].setStyle("-fx-control-inner-background:rgb(202, 226, 235);");
                    Listener.removeTextListener(cellInfos[i][j]);
                } else {
                    cells[i][j].setText("");
                }
            }
        }
    }

    /**
     * Sets the game view reference.
     * @param view The GameV instance representing the game view
     */
    public void setView(GameV view) {
        this.view = view;
    }

    /**
     * Handles the clue button click event.
     * Generates and displays a new random clue on the board.
     * @param event The ActionEvent triggered by the button click
     */
    @FXML
    public void handleButtonClick(ActionEvent event) {
        sudokuLogic.setBoard(sudokuBoard);
        sudokuBoard = sudokuLogic.randomClue();

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