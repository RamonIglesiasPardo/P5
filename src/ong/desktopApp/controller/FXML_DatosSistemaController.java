package ong.desktopApp.controller;

        import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.effects.JFXDepthManager;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
        import ong.hibernate.OngDAOHibernate;

        import javax.annotation.PostConstruct;
import java.util.ArrayList;

import static javafx.animation.Interpolator.EASE_BOTH;

public class FXML_DatosSistemaController {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private JFXMasonryPane masonryPane;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        ArrayList<Node> children = new ArrayList<>();

        String numVolunterariosNacionales = OngDAOHibernate.getNumberOfElements("personalNacional");
        String numVolunterariosInternacionales = OngDAOHibernate.getNumberOfElements("PersonalInternacional");


        String[] datosDelSistema = new String[]{
                "Organización No Gubernamental Entreculturas",
                "Número de voluntarios Nacionales: "+numVolunterariosNacionales,
                "Número de voluntarios Internacionales: "+numVolunterariosInternacionales,
                "Número total de voluntarios: "+(Integer.parseInt(numVolunterariosNacionales)+Integer.parseInt(numVolunterariosInternacionales))
        };

        for (int i = 0; i < 4; i++) {
            StackPane child = new StackPane();
            double width = Math.random() * 150 + 150;
            child.setPrefWidth(width);
            double height = Math.random() * 150 + 150;
            child.setPrefHeight(height);
            JFXDepthManager.setDepth(child, 1);
            children.add(child);

            // create content
            StackPane header = new StackPane();
            String headerColor = getDefaultColor(i % 12);
            header.setStyle("-fx-background-radius: 5 5 0 0; -fx-background-color: " + headerColor);
            VBox.setVgrow(header, Priority.ALWAYS);
            StackPane body = new StackPane();
            body.setMinHeight(Math.random() * 20 + 50);
            VBox content = new VBox();
            content.getChildren().addAll(header, body);
            body.setStyle("-fx-background-radius: 0 0 5 5; -fx-background-color: " + headerColor);

            //Text
            JFXTextArea text = new JFXTextArea(datosDelSistema[i]);
            text.setStyle("-fx-stroke: black; -fx-stroke-width: 2;-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: " + getDefaultColorText((int) ((Math.random() * 12) % 12)));
            text.setEditable(false);
            text.setScaleX(0);
            text.setScaleY(0);

            StackPane.setMargin(text, new Insets(0, 0, 0, 12));
            StackPane.setAlignment(text, Pos.TOP_LEFT);


            Timeline animation = new Timeline(new KeyFrame(Duration.millis(240),
                    new KeyValue(text.scaleXProperty(),
                            1,
                            EASE_BOTH),
                    new KeyValue(text.scaleYProperty(),
                            1,
                            EASE_BOTH)));
            animation.setDelay(Duration.millis(100));
            animation.play();
            child.getChildren().addAll(content, text);
        }
        masonryPane.getChildren().addAll(children);
        Platform.runLater(() -> scrollPane.requestLayout());

        JFXScrollPane.smoothScrolling(scrollPane);
    }

    private String getDefaultColor(int i) {
        String color = "#FFFFFF";
        switch (i) {
            case 0:
                color = "#8F3F7E";
                break;
            case 1:
                color = "#B5305F";
                break;
            case 2:
                color = "#CE584A";
                break;
            case 3:
                color = "#DB8D5C";
                break;
            case 4:
                color = "#DA854E";
                break;
            case 5:
                color = "#E9AB44";
                break;
            case 6:
                color = "#FEE435";
                break;
            case 7:
                color = "#99C286";
                break;
            default:
                break;
        }
        return color;
    }
    private String getDefaultColorText(int i) {
        String color = "#f04747";
        switch (i) {
            case 0:
                color = "#8F3F7E";
                break;
            case 1:
                color = "#01A05E";
                break;
            case 2:
                color = "#4A8895";
                break;
            case 3:
                color = "#16669B";
                break;
            case 4:
                color = "#2F65A5";
                break;
            case 5:
                color = "#4E6A9C";
                break;
            default:
                break;
        }
        return color;
    }
}