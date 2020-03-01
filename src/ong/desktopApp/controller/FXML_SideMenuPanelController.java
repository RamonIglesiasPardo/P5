package ong.desktopApp.controller;

        import com.jfoenix.controls.JFXButton;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.GridPane;
        import javafx.scene.layout.StackPane;
        import javafx.stage.Stage;
        import ong.desktopApp.ColorChangeCallback;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;

public class FXML_SideMenuPanelController implements Initializable {

    @FXML
    private JFXButton b1;
    @FXML
    private JFXButton b2;
    @FXML
    private JFXButton b3;
    @FXML
    private JFXButton exit;
    @FXML
    private StackPane root;

    private ColorChangeCallback callback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setCallback(ColorChangeCallback callback) {
        this.callback = callback;
    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Scene scene = root.getScene();
        Node nodeToFind = scene.lookup("#contentPanel");
        BorderPane contentPanel = (BorderPane) nodeToFind;

        JFXButton btn = (JFXButton) event.getSource();

        switch (btn.getId()) {
            case "b1":
                root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/Menu.fxml"));
                contentPanel.setCenter(root);
                break;
            case "b2":
                root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/VoluntariosNacionales.fxml"));
                contentPanel.setCenter(root);
                break;
            case "b3":
                root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/VoluntariosInternacionales.fxml"));
                contentPanel.setCenter(root);
                break;
        }
    }

    @FXML
    private void changeColor(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        switch (btn.getId()) {
            case "b1":

                break;
            case "b2":
                callback.updateColor("#0000FF");
                break;
            case "b3":
                callback.updateColor("#FF0000");
                break;
        }
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }


}