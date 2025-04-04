package com.example.sesion4.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.io.IOException;

import com.example.sesion4.controller.GameController;

import javafx.scene.control.Button;

/**
 * The GameV class represents the main game view window for the Sudoku application.
 * It extends JavaFX's Stage class and handles the initialization and display of
 * the game interface, including background images and controller setup.
 * 
 * @author Santiago Vanegas Torres
 * @version 1.0
 * @since 1.0
 */
public class GameV extends Stage {
    
    private GameController gameController;
    private Scene scene;
    private GridPane gridPane;
    private Pane rightPane;
    private Button clueButton;
    @SuppressWarnings("unused")
    private AnimatedButton animatedButton;

    /**
     * Constructs a new GameV (Game View) window.
     * Loads the FXML layout, initializes UI components, sets up background images,
     * and configures the game controller.
     */
    public GameV() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sesion4/view/GameView.fxml"));
            Parent root = loader.load();

            gameController = loader.getController();

            scene = new Scene(root);
            gridPane = (GridPane) scene.lookup("#gridPane");
            rightPane = (Pane) scene.lookup("#rightPane");
            clueButton = (Button) rightPane.lookup("#clueButton");

            animatedButton = new AnimatedButton(clueButton);
            setBackgroundImage(gridPane, "/com/example/sesion4/bgsudoku.png");
            setBackgroundImage(rightPane, "/com/example/sesion4/bgright.jpg");

            initController();

            initStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes and configures the stage properties.
     * Sets the window title, icon, and makes the window non-resizable.
     */
    private void initStage() {
        setTitle("Sudoku");
        setResizable(false);
        try {
            String iconPath = "/com/example/sesion4/icon.png";
            Image icon = new Image(getClass().getResource(iconPath).toExternalForm());
            getIcons().add(icon);
        } catch (NullPointerException e) {
            // Icon loading failed, continue without it
        }
        setScene(scene);
        show();
        initController();
    }

    /**
     * Sets a background image for the specified region.
     * 
     * @param region The JavaFX region (Pane, GridPane, etc.) to set the background on
     * @param imagePath The path to the image resource to use as background
     */
    private void setBackgroundImage(Region region, String imagePath) {
        try {
            Image image = new Image(getClass().getResource(imagePath).toExternalForm());
            BackgroundImage backgroundImage = new BackgroundImage(
                    image,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.CENTER, 
                    new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, true)
            );
            Background background = new Background(backgroundImage);
            region.setBackground(background);
        } catch (NullPointerException e) {
            // Background image loading failed, continue without it
        }
    }

    /**
     * Initializes the connection between this view and its controller.
     */
    private void initController() {
        gameController.setView(this);
    }
}