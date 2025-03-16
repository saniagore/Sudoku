package com.example.sesion4.controller;

import com.example.sesion4.model.SudokuBoard;
import com.example.sesion4.model.SudokuGenerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class GameController {
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

    private SudokuGenerator sudokuGenerator;
    private SudokuBoard sudokuBoard;

    @FXML
    public void initialize() {

        sudokuGenerator = new SudokuGenerator();
        sudokuBoard = sudokuGenerator.generateBoard();

        updateView();
    }

    private void updateView() {
        int[] board = sudokuBoard.getBoard();
        for (int i = 0; i < board.length; i++) {
            TextField textField = getTextFieldByIndex(i);
            if (textField != null) {
                if(board[i]==0){
                }else{
                    textField.setText(String.valueOf(board[i]));
                }
            }
        }
    }
    
    private TextField getTextFieldByIndex(int index) {
        switch (index) {
            case 0: return cell1;
            case 1: return cell2;
            case 2: return cell3;
            case 3: return cell4;
            case 4: return cell5;
            case 5: return cell6;
            case 6: return cell7;
            case 7: return cell8;
            case 8: return cell9;
            case 9: return cell10;
            case 10: return cell11;
            case 11: return cell12;
            case 12: return cell13;
            case 13: return cell14;
            case 14: return cell15;
            case 15: return cell16;
            case 16: return cell17;
            case 17: return cell18;
            case 18: return cell19;
            case 19: return cell20;
            case 20: return cell21;
            case 21: return cell22;
            case 22: return cell23;
            case 23: return cell24;
            case 24: return cell25;
            case 25: return cell26;
            case 26: return cell27;
            case 27: return cell28;
            case 28: return cell29;
            case 29: return cell30;
            case 30: return cell31;
            case 31: return cell32;
            case 32: return cell33;
            case 33: return cell34;
            case 34: return cell35;
            case 35: return cell36;
            default: return null;
        }
    }
}