package tictactoe.Views.AvailablePlayer;

import java.net.URL;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PlayersListBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label availableLabel;
    protected final Label playerLabel;
    protected final Label scoreLabel;
    protected final Button inviteBtn;
    protected final Text playerNametxt;
    protected final Text playerScoretxt;
    protected final ImageView backBtn;

    public PlayersListBase(Stage stage) {

        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        playerLabel = new Label();
        scoreLabel = new Label();
        inviteBtn = new Button();
        playerNametxt = new Text();
        playerScoretxt = new Text();
        backBtn = new ImageView();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/playerslist.css");

        anchorPane.setPrefHeight(679.0);
        anchorPane.setPrefWidth(998.0);

        backgroundImg.setFitHeight(686.0);
        backgroundImg.setFitWidth(1014.0);
    //    backgroundImg.setImage(new Image(getClass().getResource("gaming-blank-banner-background_23-2150390423.jpg").toExternalForm()));

        availableLabel.setLayoutX(545.0);
        availableLabel.setLayoutY(69.0);
        availableLabel.setText("Available Players");
        availableLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        availableLabel.setFont(new Font("System Bold", 50.0));

        playerLabel.setLayoutX(564.0);
        playerLabel.setLayoutY(233.0);
        playerLabel.setText("Player Name");
        playerLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        playerLabel.setFont(new Font("System Bold", 30.0));

        scoreLabel.setLayoutX(782.0);
        scoreLabel.setLayoutY(233.0);
        scoreLabel.setText("Score");
        scoreLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        scoreLabel.setFont(new Font("System Bold", 30.0));

        inviteBtn.setLayoutX(884.0);
        inviteBtn.setLayoutY(315.0);
        inviteBtn.setMnemonicParsing(false);
        inviteBtn.setPrefHeight(35.0);
        inviteBtn.setPrefWidth(96.0);
        inviteBtn.setText("Invite");
        inviteBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Player is offline");
                a.show();
            }
        });

        playerNametxt.setFill(javafx.scene.paint.Color.WHITE);
        playerNametxt.setLayoutX(606.0);
        playerNametxt.setLayoutY(343.0);
        playerNametxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerNametxt.setStrokeWidth(0.0);
        playerNametxt.setText("Player1");
        playerNametxt.getStyleClass().add("text-styled");
        playerNametxt.setFont(new Font(30.0));

        playerScoretxt.setFill(javafx.scene.paint.Color.WHITE);
        playerScoretxt.setLayoutX(813.0);
        playerScoretxt.setLayoutY(343.0);
        playerScoretxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerScoretxt.setStrokeWidth(0.0);
        playerScoretxt.setText("3");
        playerScoretxt.getStyleClass().add("text-styled");
        playerScoretxt.setFont(new Font(30.0));

        backBtn.setFitHeight(73.0);
        backBtn.setFitWidth(100.0);
        backBtn.setLayoutX(444.0);
        backBtn.setLayoutY(69.0);
        backBtn.setPickOnBounds(true);
        backBtn.setPreserveRatio(true);
//        backBtn.setImage(new Image(getClass().getResource("symbole-fleche-gauche-violet.png").toExternalForm()));
  //      backBtn.setImage(new Image(getClass().getResource("symbole-fleche-gauche-violet.png").toExternalForm()));

        backBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("This is Backbutton");
                a.show();
            }
        });

     
        
        

        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(availableLabel);
        anchorPane.getChildren().add(playerLabel);
        anchorPane.getChildren().add(scoreLabel);
        anchorPane.getChildren().add(inviteBtn);
        anchorPane.getChildren().add(playerNametxt);
        anchorPane.getChildren().add(playerScoretxt);
        anchorPane.getChildren().add(backBtn);
        getChildren().add(anchorPane);

    }
}
