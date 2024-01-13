package tictactoe.Views.AvailablePlayer;

import Requests.App;
import Requests.Message;
import Requests.PlayersDTO;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    ArrayList<PlayersDTO> playersList;
    Gson gson;
    public PlayersListBase(Stage stage) {
        gson=new Gson();
        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        playerLabel = new Label();
        scoreLabel = new Label();
        inviteBtn = new Button();
        playerNametxt = new Text();
        playerScoretxt = new Text();
        backBtn = new ImageView();
        playersList =new ArrayList<>();
        
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/playerslist.css");
        
        anchorPane.setPrefHeight(679.0);
        anchorPane.setPrefWidth(998.0);

        backgroundImg.setFitHeight(700.0);
        backgroundImg.setFitWidth(1000.0);
        backgroundImg.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

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
        backBtn.setImage(new Image(getClass().getResource("/assets/images/symbole-fleche-gauche-violet.png").toExternalForm()));
        backBtn.setImage(new Image(getClass().getResource("/assets/images/symbole-fleche-gauche-violet.png").toExternalForm()));
//        App.resetCon();
        backBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                
            }
        });
        Message msg= new Message();
        msg.setType("getOnline");
        String request=App.gson.toJson(msg);
        App.output.println(request);
        App.output.flush();
        new Thread(() -> {
//            while(App.server.isConnected())
//            {
                try {
                    String jsonResponse= App.input.readLine();
                    System.out.println(jsonResponse);
                    Message response=App.gson.fromJson(jsonResponse,Message.class);
                    ArrayList<PlayersDTO> players =response.getPlayersList();
                    for(PlayersDTO player: players)
                    {
                        
                    }
                    if(response.getType().equals("getOnline"))
                    {
                        System.out.println("ssssssssssssssssss");                    
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PlayersListBase.class.getName()).log(Level.SEVERE, null, ex);
//                    break;
                }
//            }
        }).start();
        

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
