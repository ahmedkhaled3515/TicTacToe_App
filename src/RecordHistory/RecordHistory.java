/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordHistory;
import RecordView.RecordBase;
import Requests.App;
import static Requests.App.input;
import Requests.Message;
import Requests.PlayersDTO;
import SelectmodeView.SelectModeBase;
import SignupView.SignupBase;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Flags;
import onlinemode.onlineModeGeneratedBase;
import tictactoe.Views.AvailablePlayer.ItemBase;
import tictactoe.Views.AvailablePlayer.PlayersListBaseNew;
import static tictactoe.Views.AvailablePlayer.PlayersListBaseNew.avaliable;
import tictactoe.Views.computerMode.GamesDTO;
import tictactoe.Views.login.loginBase;
/**
 *
 * @author Dell
 */
public class RecordHistory extends AnchorPane{
     protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label availableLabel;
    protected final ImageView backBtn;
    protected final Rectangle rectangle;
    protected static ListView listView = new ListView();
    public static ArrayList<String> avaliable;
    public static List<String> receivedEmailList;
    public static boolean closeInvite = false, checkforclose = false;
    Object lock = new Object();
    ArrayList<ItemBase> playersCards;
    Alert confirm;
    Optional<ButtonType> result;
    ButtonType alertResult;
    boolean flag;
    boolean shouldStop = false;
    Thread thread = new Thread();
    Stage stage;
    String playerEmail;
    public static boolean myTurn = false;
    public String player1, player2;
    Random random = new Random();
    String playerIs;

    
    
    public RecordHistory(Stage stage,String email){
         this.stage = stage;

        flag = true;
        alertResult = new ButtonType("");
        confirm = new Alert(Alert.AlertType.CONFIRMATION);
        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        backBtn = new ImageView();
        rectangle = new Rectangle();
        avaliable = new ArrayList<>();
        playersCards = new ArrayList<>();
         playerEmail = email;
        
        System.out.println("hi from record history");
        Message request=new Message();
        request.setType("showRec");
        App.output.println(new Gson().toJson(request));
        App.output.flush();
        new Thread(() -> {
            try {
                String jsonResponse = App.input.readLine();
                System.out.println(jsonResponse);
                Message response = App.gson.fromJson(jsonResponse, Message.class);
                ArrayList<GamesDTO> games = response.getGames();
                if (response.getType().equals("showRec")) {
                    for (GamesDTO game : games) {
                        ItemRecord item = new ItemRecord();
                        item.playerTxt.setText(String.valueOf(game.getGameID()));
                        if (game.isWin()) {
                            item.winTxt.setText("Winner");
                        } else {
                            item.winTxt.setText("Loser");
                        }
                        listView.getItems().add(item);
                        listView.refresh();
                        item.inviteBTn.setOnAction((event) -> { 
                            Parent root = new RecordBase(stage, game.getSteps());
                            Scene scene = new Scene(root, 1000, 700);
                            stage.setScene(scene);
                            stage.show();
                        });
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }).start();
         setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/RecordHistory/fxml.css");

        anchorPane.setPrefHeight(690.0);
        anchorPane.setPrefWidth(1000.0);

        backgroundImg.setFitHeight(690.0);
        backgroundImg.setFitWidth(1000.0);
        backgroundImg.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        availableLabel.setLayoutX(500.0);
        availableLabel.setLayoutY(56.0);
        availableLabel.setText("Record History");
        availableLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        availableLabel.setFont(new Font("System Bold", 50.0));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        dropShadow.setColor(Color.BLACK); // Set the shadow color
        availableLabel.setEffect(dropShadow);

        backBtn.setLayoutX(100.0);
        backBtn.setLayoutY(50.0);
        backBtn.setImage(new Image(getClass().getResource("/assets/images/a.png").toExternalForm()));
        backBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new PlayersListBaseNew(stage,playerEmail);
                Scene scene = new Scene(root, 1000, 700);
                stage.setScene(scene);
                stage.show();
            }
        });

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setHeight(472.0);
        rectangle.setLayoutX(401.0);
        rectangle.setLayoutY(156.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(2);
        rectangle.setWidth(567.0);

        listView.setLayoutX(427.0);
        listView.setLayoutY(187.0);
        listView.setPrefHeight(397.0);
        listView.setPrefWidth(515.0);
        listView.getStyleClass().add("mylistview");
        listView.setStyle("-fx-background-color: transparent;");

        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(availableLabel);
        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(listView);
        getChildren().add(anchorPane);
        
    }
}
