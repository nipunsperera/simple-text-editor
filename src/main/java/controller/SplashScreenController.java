package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.security.Key;

public class SplashScreenController {
    public Label lblLoader;

    public void initialize(){
        Timeline timeline = new Timeline();
        KeyFrame keyFrame1 = new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoader.setText("Initializing Application...");

            }
        });

        KeyFrame keyFrame2 = new KeyFrame(Duration.millis(1500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoader.setText("Setting up Tools...");

            }
        });

        KeyFrame keyFrame3 = new KeyFrame(Duration.millis(2500), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                lblLoader.setText("Setting up UI...");

            }
        });

        KeyFrame keyFrame4 = new KeyFrame(Duration.millis(3000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                URL resource = this.getClass().getResource("/view/MainForm.fxml");
                try {
                    Parent container = FXMLLoader.load(resource);
                    Scene scene = new Scene(container);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.setTitle("Blue Disk Text Editor V 1.0.0");
                    stage.show();
                    stage.centerOnScreen();
                    lblLoader.getScene().getWindow().hide();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4);
        timeline.playFromStart();

    }
}
