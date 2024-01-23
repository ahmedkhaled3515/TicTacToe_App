package UserProfile;

import RecordHistory.RecordHistory;
import java.net.URL;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.Views.AvailablePlayer.PlayersListBaseNew;
import tictactoe.Views.login.loginBase;

public  class userfxmlBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Button availableBtn;
    protected final Button recordBtn;
    String userEmail;

    public userfxmlBase(Stage stage,String email) {

        imageView = new ImageView();
        availableBtn = new Button();
        recordBtn = new Button();
        userEmail=email;

        setId("AnchorPane");
        setPrefHeight(630.0);
        setPrefWidth(886.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/UserProfile/userfxml.css");

        imageView.setFitHeight(630.0);
        imageView.setFitWidth(886.0);
        imageView.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        availableBtn.setLayoutX(557.0);
        availableBtn.setLayoutY(207.0);
        availableBtn.setMnemonicParsing(false);
        availableBtn.setPrefHeight(58.0);
        availableBtn.setPrefWidth(213.0);
        availableBtn.setText("Available Player");
        availableBtn.setFont(new Font(18.0));
        availableBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new PlayersListBaseNew( stage,userEmail);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();            }
        });

        recordBtn.setLayoutX(557.0);
        recordBtn.setLayoutY(339.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setPrefHeight(58.0);
        recordBtn.setPrefWidth(213.0);
        recordBtn.setText("Recorded Game");
        recordBtn.setFont(new Font(18.0));
         recordBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new RecordHistory( stage,userEmail);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();            }
        });

        getChildren().add(imageView);
        getChildren().add(availableBtn);
        getChildren().add(recordBtn);

    }
}
