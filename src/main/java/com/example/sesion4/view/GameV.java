package com.example.sesion4.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class GameV extends Stage {

    private Scene scene;

    public GameV() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sesion4/view/GameView.fxml"));
            Parent root = loader.load();
            scene = new Scene(root);
            initStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initStage() {
        setTitle("Sudoku");
        setResizable(false);

        getIcons().add(new Image(String.valueOf(getClass().getResource("/com/example/sesion4/icon.png"))));

        setScene(scene);
        show();
    }
}