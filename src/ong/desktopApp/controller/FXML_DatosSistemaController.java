package ong.desktopApp.controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.ContentDisplay;
        import javafx.scene.control.Label;

        import javax.annotation.PostConstruct;
        import java.io.IOException;

public class FXML_DatosSistemaController {


    @FXML
    Label title;

    public Label helloWorld;


    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() throws IOException {

    }

    public void sayHelloWorld(ActionEvent actionEvent) {
        helloWorld.setText("Hello World!");
    }
}