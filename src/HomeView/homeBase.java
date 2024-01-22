package HomeView;

import SelectmodeView.SelectModeBase;
import java.net.URL;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class homeBase extends AnchorPane {

    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane0;
    protected final Text headLabel;
    protected final Button button;
    protected final ImageView imageView0;

    public homeBase(Stage stage) {

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        anchorPane0 = new AnchorPane();
        headLabel = new Text();
        button = new Button();
        imageView0 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/HomeView/home.css");

        borderPane.setPrefHeight(700);
        borderPane.setPrefWidth(1000);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        imageView.setFitHeight(700);
        imageView.setFitWidth(1000);
        imageView.setLayoutX(1.0);
        imageView.setStyle("-fx-background-radius: 100px;");
        imageView.setImage(new Image(getClass().getResource("/assets/images/image.gif").toExternalForm()));


        headLabel.setLayoutX(560.0);
        headLabel.setLayoutY(250.0);
        headLabel.setText("tic.tac.toe.");
        headLabel.setFill(javafx.scene.paint.Color.valueOf("#8F9AD5"));
        headLabel.setStroke(Color.web("#ADAECB"));
        headLabel.setStrokeWidth(2);
        headLabel.setFont(new Font("System Bold", 80.0));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        headLabel.setEffect(dropShadow);
        
        

//        button.setLayoutX(600.0);
//        button.setLayoutY(350.0);
//        button.setMnemonicParsing(false);
//        button.setPrefHeight(80.0);
//        button.setPrefWidth(300.0);
//        //button.setStyle("-fx-background-color: #72CFF9; -fx-background-radius: 26;");
//        button.setText("Let’s Play!");
//        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
//        button.setTextFill(javafx.scene.paint.Color.valueOf("#FFFFFF"));
//        button.setOnMouseClicked(new EventHandler() {
//
//            @Override
//            public void handle(Event event) {
//                Parent root = new SelectModeBase(stage);
//                Scene scene = new Scene(root,1000,700);
//                stage.setScene(scene);
//                stage.show();
//            }
//        });
        
        imageView0.setFitHeight(184.0);
        imageView0.setFitWidth(211.0);
        imageView0.setLayoutX(658.0);
        imageView0.setLayoutY(295.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("play.png").toExternalForm()));
        imageView0.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });
        
        borderPane.setCenter(anchorPane);

        anchorPane.getChildren().add(imageView);
        //anchorPane0.getChildren().add(button);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(headLabel);
        anchorPane.getChildren().add(imageView0);
        getChildren().add(borderPane);

    }
}
