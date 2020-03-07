package ong.desktopApp;

        import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ong.hibernate.OngDAOHibernate;
        import ong.hibernate.personalNacional;

        import java.util.List;

public class Launcher extends Application {

    public static Boolean isSplashLoaded = false;
    public static OngDAOHibernate componenteService;
    public static List<personalNacional> listPersonalNacional;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ong/desktopApp/view/MainMenu.fxml"));

        stage.setMaxHeight(800);
        stage.setMaxWidth(1200);
        stage.setFullScreen(false);
        stage.setMaximized(false);
        double width = 1200;
        double height = 800;


        Scene scene = new Scene(root, width, height);

        stage.setScene(scene);

        stage.setTitle("ONG Resource Planner");
        stage.getIcons().add(new Image("ong/desktopApp/resources/images/ico-ec.png"));
        stage.show();
    }


    public static void main(String[] args) {
        componenteService = new OngDAOHibernate();
        listPersonalNacional = componenteService.mostrarPersonas();
        launch(args);
    }

}