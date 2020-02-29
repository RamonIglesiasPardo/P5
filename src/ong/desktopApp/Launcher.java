package ong.desktopApp;

        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Stage;

public class Launcher extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/MainMenu.fxml"));

        Scene scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.setTitle("ONG Resource Planner");
        stage.getIcons().add(new Image("ong/desktopApp/resources/images/ico-ec.png"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}