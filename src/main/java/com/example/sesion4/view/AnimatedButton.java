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
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;

public class AnimatedButton {

    private Button button;
    private final Color PRIMARY_COLOR = Color.web("#7c8386");  
    private final Color HOVER_COLOR = Color.web("#6b6f71");   

    public AnimatedButton(Button button) {
        this.button = button;
        setupButton();
        setupAnimation();
        setupHoverEffects();
    }
    private void setupButton() {
        button.setBackground(new Background(new BackgroundFill(
            PRIMARY_COLOR, 
            new CornerRadii(5), 
            Insets.EMPTY
        )));
        button.setTextFill(Color.WHITE); 
        button.setFont(Font.font("Arial", 14)); 
        button.setCursor(Cursor.HAND);
        button.setBorder(new Border(new BorderStroke(
            Color.web("#c0c7c9"), 
            BorderStrokeStyle.SOLID, 
            new CornerRadii(5), 
            new BorderWidths(1))
        ));
        DropShadow shadow = new DropShadow();
        shadow.setRadius(3);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
        shadow.setColor(Color.color(0, 0, 0, 0.3));
        button.setEffect(shadow);
    }

    private void setupAnimation() {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), button);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(0.95);
        scaleTransition.setToY(0.95);
        scaleTransition.setOnFinished(event -> {
            button.setScaleX(1.0);
            button.setScaleY(1.0);
        });

        button.setOnMousePressed(event -> scaleTransition.play());
        button.setOnMouseReleased(event -> button.setScaleX(1.0));
    }

    private void setupHoverEffects() {
        button.setOnMouseEntered(event -> {
            button.setBackground(new Background(new BackgroundFill(
                HOVER_COLOR, 
                new CornerRadii(5), 
                Insets.EMPTY
            )));
            DropShadow hoverShadow = new DropShadow();
            hoverShadow.setRadius(5);
            hoverShadow.setOffsetX(3);
            hoverShadow.setOffsetY(3);
            hoverShadow.setColor(Color.color(0, 0, 0, 0.4));
            button.setEffect(hoverShadow);
        });

        button.setOnMouseExited(event -> {
            button.setBackground(new Background(new BackgroundFill(
                PRIMARY_COLOR, 
                new CornerRadii(5), 
                Insets.EMPTY
            )));
            DropShadow shadow = new DropShadow();
            shadow.setRadius(3);
            shadow.setOffsetX(2);
            shadow.setOffsetY(2);
            shadow.setColor(Color.color(0, 0, 0, 0.3));
            button.setEffect(shadow);
        });
    }
}