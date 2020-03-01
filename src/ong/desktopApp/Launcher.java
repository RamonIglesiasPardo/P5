package ong.desktopApp;

        import com.jfoenix.controls.JFXDecorator;
        import com.jfoenix.svg.SVGGlyph;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.geometry.Rectangle2D;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.image.Image;
        import javafx.stage.Screen;
        import javafx.stage.Stage;

public class Launcher extends Application {

    public static Boolean isSplashLoaded = false;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/MainMenu.fxml"));

        stage.setTitle("JFoenix Demo");

        double width = 1200;
        double height = 800;
        try {
            Rectangle2D bounds = Screen.getScreens().get(0).getBounds();
            width = bounds.getWidth() / 2.5;
            height = bounds.getHeight() / 1.35;
        }catch (Exception e){ }

        Scene scene = new Scene(root, width, height);

        stage.setScene(scene);
        stage.setTitle("ONG Resource Planner");
        stage.getIcons().add(new Image("ong/desktopApp/resources/images/ico-ec.png"));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}