package ong.desktopApp.controller;

        import com.jfoenix.controls.JFXButton;
        import com.jfoenix.controls.JFXDrawer;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Scene;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.StackPane;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        Scene scene = root.getScene();
        Node nodeToFind = scene.lookup("#contentPanel");
        BorderPane contentPanel = (BorderPane) nodeToFind;

        JFXButton btn = (JFXButton) event.getSource();

        switch (btn.getId()) {
            case "b1":
                root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/DatosDelSistema.fxml"));
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

//        Scene sceneSB = root.getScene();
//        Node nodeToFindSB = scene.lookup("#drawer");
//        JFXDrawer contentPanelSB = (JFXDrawer) nodeToFind;
//        contentPanel.toFront();
//        hamburger.toFront();

    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }


}