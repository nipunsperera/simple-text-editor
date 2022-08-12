package controller;

import javafx.animation.FadeTransition;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class AboutFormController {
    public AnchorPane aboutForm;

    public void initialize(){
        FadeTransition ft = new FadeTransition(Duration.millis(1000),aboutForm);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.playFromStart();
    }
}
