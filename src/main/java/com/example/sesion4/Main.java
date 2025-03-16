package com.example.sesion4;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.sesion4.view.GameV;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear una instancia de GameV (que es una ventana)
        GameV gameView = new GameV();
        gameView.show(); // Mostrar la ventana
    }

    public static void main(String[] args) {
        launch(args);
    }
}