package com.example.sesion4.view;

import javafx.animation.ScaleTransition;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.geometry.Insets;

public class AnimatedButton {

    private Button button;

    public AnimatedButton(Button button) {
        this.button = button;
        setupButton();
        setupAnimation();
    }

    private void setupButton() {
        button.setBackground(new Background(new BackgroundFill(
            Color.web("144978"), 
            new CornerRadii(5), 
            Insets.EMPTY
        )));
        button.setTextFill(Color.WHITE); 
        button.setFont(Font.font(14)); 
        button.setCursor(Cursor.HAND);
    }

    private void setupAnimation() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(0.9);
        scaleTransition.setToY(0.9);
        scaleTransition.setOnFinished(event -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
        });

        button.setOnMousePressed(event -> {
            scaleTransition.play();
        });

        button.setOnMouseReleased(event -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
        });
    }
}