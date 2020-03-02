package ong.desktopApp.controller;

        import com.jfoenix.controls.JFXButton;
        import com.jfoenix.controls.JFXDrawer;
        import com.jfoenix.controls.JFXHamburger;
        import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.BorderPane;
        import javafx.scene.layout.StackPane;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.layout.VBox;

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
    private VBox sideBar;
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
                FXMLLoader loaderDS = new FXMLLoader(getClass().getResource("/ong/desktopApp/view/DatosDelSistema.fxml"));
                StackPane rootDS = (StackPane) loaderDS.load();
                contentPanel.setCenter(rootDS);
                FXML_DatosSistemaController dsController = loaderDS.getController();
                dsController.init();
                break;
            case "b2":
                FXMLLoader loaderVN = new FXMLLoader(getClass().getResource("/ong/desktopApp/view/VoluntariosNacionales.fxml"));
                StackPane rootVN = (StackPane) loaderVN.load();
                contentPanel.setCenter(rootVN);
                FXML_VNController vnController = loaderVN.getController();
                vnController.init();
                break;
            case "b3":
                FXMLLoader loaderVI = new FXMLLoader(getClass().getResource("/ong/desktopApp/view/VoluntariosInternacionales.fxml"));
                StackPane rootVI = (StackPane) loaderVI.load();
                contentPanel.setCenter(rootVI);
                FXML_VIController viController = loaderVI.getController();
                viController.init();
                break;
        }

        Scene sceneDrawer = root.getScene();
        JFXDrawer drawer = (JFXDrawer) sceneDrawer.lookup("#drawer");
        drawer.toBack();
        Scene sceneHamburguer = root.getScene();
        JFXHamburger hamburger = (JFXHamburger)sceneHamburguer.lookup("#hamburger");
        hamburger.toFront();
//        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
//        transition.setRate(-1);
//        transition.setRate(transition.getRate() * -1);
//        transition.play();

        if (drawer.isOpened()) {
            drawer.close();
            drawer.toBack();
        } else {
            drawer.open();
            drawer.toFront();
        }
        hamburger.toFront();
    }

    @FXML
    private void exit(ActionEvent event) {
        System.exit(0);
    }


}