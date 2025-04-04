package com.example.sesion4;

import javafx.application.Application;
import javafx.stage.Stage;
import com.example.sesion4.view.GameV;

/**
 * The Main class serves as the entry point for the JavaFX application.
 * It extends the JavaFX Application class and launches the game view.
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class Main extends Application {

    /**
     * The main entry point for the JavaFX application.
     * Creates and displays the primary game view.
     * 
     * @param primaryStage The primary stage for this application, where the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        GameV gameView = new GameV();
        gameView.show(); 
    }

    /**
     * The main method that launches the JavaFX application.
     * 
     * @param args The command line arguments passed to the application.
     */
    public static void main(String[] args) {
        launch(args);
    }
}