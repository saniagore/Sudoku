package com.example.sesion4;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.sesion4.view.GameV;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameV gameView = new GameV();
        gameView.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}