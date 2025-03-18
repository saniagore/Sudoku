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

public class GameV extends Stage {

    private Scene scene;
    private GridPane gridPane; // Referencia al GridPane del FXML
    private Pane rightPane;    // Referencia al Pane derecho del FXML

    public GameV() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sesion4/view/GameView.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            gridPane = (GridPane) scene.lookup("#gridPane");
            rightPane = (Pane) scene.lookup("#rightPane");
            setBackgroundImage(gridPane, "/com/example/sesion4/bgsudoku.png");
            setBackgroundImage(rightPane, "/com/example/sesion4/bgright.jpg");

            initStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStage() {
        setTitle("Sudoku");
        setResizable(false);
        try {
            String iconPath = "/com/example/sesion4/icon.png";
            Image icon = new Image(getClass().getResource(iconPath).toExternalForm());
            getIcons().add(icon);
        } catch (NullPointerException e) {
        }
        setScene(scene);
        show();
    }

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
        }
    }
}