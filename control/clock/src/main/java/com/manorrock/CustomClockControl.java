package com.manorrock;

import javafx.application.Platform;
import javafx.scene.control.Control;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.time.LocalTime;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CustomClockControl extends VBox {
    private Label timeLabel;

    public CustomClockControl() {
        Platform.runLater(() -> {
            timeLabel = new Label("Time");
            timeLabel.setId("timeLabel");
            this.getChildren().add(timeLabel);
            startClock();
        });
    }

    private void startClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            timeLabel.setText(currentTime.toString());
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }
}
