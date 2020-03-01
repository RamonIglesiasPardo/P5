package ong.desktopApp.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;

public class FXML_DatosSistemaController {

    @FXML
    Label title;

    public Label helloWorld;

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}