package ong.desktopApp.controller;

        import com.jfoenix.controls.JFXDrawer;
        import com.jfoenix.controls.JFXHamburger;
        import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;

        import javafx.scene.Node;
        import javafx.scene.Scene;
        import ong.desktopApp.Launcher;

        import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;
        import java.util.logging.Level;
        import java.util.logging.Logger;

        import javafx.animation.FadeTransition;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.AnchorPane;
        import javafx.scene.layout.StackPane;
        import javafx.util.Duration;

public class FXML_MainMenuController implements Initializable {

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!Launcher.isSplashLoaded) {
            loadSplashScreen();
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ong/desktopApp/view/SideMenuPanel.fxml"));
            StackPane box = loader.load();
            FXML_SideMenuPanelController controller = loader.getController();
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXML_MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isOpened()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });
    }

    @FXML
    private void hamClicked(MouseEvent event) throws IOException {

        Scene scene = root.getScene();
        Node nodeToFind = scene.lookup("#drawer");
        JFXDrawer contentPanel = (JFXDrawer) nodeToFind;
        contentPanel.toFront();
        hamburger.toFront();

    }

    private void loadSplashScreen() {
        try {
            Launcher.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("/ong/desktopApp/view/Splash.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("/ong/desktopApp/view/MainMenu.fxml")));
                    root.getChildren().setAll(parentContent);
                } catch (IOException ex) {
                    Logger.getLogger(FXML_MenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } catch (IOException ex) {
            Logger.getLogger(FXML_MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}