package ong.desktopApp.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class FXML_MenuController {
    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}
