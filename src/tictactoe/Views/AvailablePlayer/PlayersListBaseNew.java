package tictactoe.Views.AvailablePlayer;

import RecordHistory.RecordHistory;
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
import onlinemode.MyWindowAdapter;
import onlinemode.onlineModeGeneratedBase;
import tictactoe.Views.login.loginBase;

public class PlayersListBaseNew extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label availableLabel;
    protected final ImageView backBtn;
    protected final Rectangle rectangle;
    protected static ListView listView = new ListView();
    protected final ImageView users;
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
    MyWindowAdapterAvailablePlayers myWindowAdapter;
    public static boolean myTurn = false;
    public String player1, player2;
    Random random = new Random();
    String playerIs;
    public PlayersListBaseNew(Stage stage,String email) {
        
        
        
        myWindowAdapter=new MyWindowAdapterAvailablePlayers(email);
            // Set the event handler for window-closing
        stage.setOnCloseRequest(event -> {
            myWindowAdapter.handleWindowClosing(email);
            // Prevent the default close operation (which is to close the window)
            event.consume();
        });
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
        users = new ImageView();


        App.startConnection();
        Message msg = new Message();
        msg.setType("getOnline");
        String request = App.gson.toJson(msg);
        App.output.println(request);
        App.output.flush();
        new Thread(() -> {
//            while(App.server.isConnected())
//            {
                try {
                    String jsonResponse= App.input.readLine();
                    System.out.println("/////////////////"+jsonResponse);
                    Message response=App.gson.fromJson(jsonResponse,Message.class);
                    ArrayList<PlayersDTO> players =response.getPlayersList();
                    if(response.getType().equals("getOnline"))
                    {
                        for(PlayersDTO player: players)
                        {
                            ItemBase item=new ItemBase();
                            item.playerTxt.setText(player.getUserName());
                            item.inviteBTn.setOnAction((event) -> {
                                Message jsonMessage=new Message();
                                jsonMessage.setType("invite");
                                jsonMessage.setEmail(player.getEmail());
                                App.output.println(new Gson().toJson(jsonMessage));
                                App.output.flush();
                            });
                            listView.getItems().add(item);
                            listView.refresh();
                        }                    
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(PlayersListBase.class.getName()).log(Level.SEVERE, null, ex);
//                    break;
            }
//            }
        }).start();
        listen4();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/playerslist.css");

        anchorPane.setPrefHeight(679.0);
        anchorPane.setPrefWidth(998.0);

        backgroundImg.setFitHeight(686.0);
        backgroundImg.setFitWidth(1014.0);
        backgroundImg.setImage(new Image(getClass().getResource("gaming-blank-banner-background_23-2150390423.jpg").toExternalForm()));

        availableLabel.setLayoutX(500.0);
        availableLabel.setLayoutY(56.0);
        availableLabel.setText("Available Players");
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
                Parent root = new SelectModeBase(stage);
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
        
        
        users.setLayoutX(400);
        users.setLayoutY(50);
        users.setImage(new Image(getClass().getResource("/assets/images/u.png").toExternalForm()));
        users.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Parent root = new RecordHistory(stage,playerEmail);
                Scene scene = new Scene(root, 1000, 700);
                stage.setScene(scene);
                stage.show();
            }
        });


        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(availableLabel);
        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(listView);
        anchorPane.getChildren().add(users);
        getChildren().add(anchorPane);

    }

    public static void preperList() {
        ItemBase itemBase = new ItemBase();
        for (String email : receivedEmailList) {
            itemBase.playerTxt.setText(email);
            listView.getItems().add(itemBase);
            listView.refresh();
        }

    }
    Alert invitation;

    public void showInvitation(Message jsonResponse) {
        Message response = jsonResponse;
        invitation = new Alert(Alert.AlertType.CONFIRMATION, response.getEmail() + " someone wants to play with you", ButtonType.OK, ButtonType.CANCEL);
        DialogPane dialog = invitation.getDialogPane();
        Button okButton = (Button) dialog.lookupButton(ButtonType.OK);
        Button cancelButton = (Button) dialog.lookupButton(ButtonType.CANCEL);
        Message inviteResponse = new Message();
        invitation.setX(stage.getX() + (stage.getWidth() / 2));
        invitation.setY(stage.getY() + (stage.getHeight() / 2));
        okButton.setOnAction((event) -> {
            inviteResponse.setType("accepted");
            inviteResponse.setEmail(response.getEmail());
            App.output.println(new Gson().toJson(inviteResponse));
            App.output.flush();

            
            Parent root = new onlineModeGeneratedBase(stage,playerEmail,response.getEmail(),2);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        cancelButton.setOnAction((event) -> {
            inviteResponse.setType("rejected");
            inviteResponse.setEmail(response.getEmail());
            App.output.println(new Gson().toJson(inviteResponse));
            App.output.flush();
            listen4();
        });
        invitation.showAndWait();
    }

    public void listen4() {
        Thread th = new Thread(() -> {
            while (App.server.isConnected()) {

                try {
                    String jsonResponse = App.input.readLine();
                    Message response = new Gson().fromJson(jsonResponse, Message.class);
                    System.out.println(jsonResponse);
                    if (response.getType().equals("invite")) {
                        Platform.runLater(() -> {
                            showInvitation(response);
                        });
                        break;
                    } else if (response.getType().equals("accepted")) {
                        Platform.runLater(() -> {
                            Parent root = new onlineModeGeneratedBase(stage, playerEmail, response.getEmail(), 1);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        });
                        break;
                    } else if (response.getType().equals("rejected")) {
                        Platform.runLater(() -> {
                            Alert rejectAlert = new Alert(Alert.AlertType.INFORMATION, response.getEmail() + " rejected your play request check another player");
                            rejectAlert.setX(stage.getX() + (stage.getWidth() / 2));
                            rejectAlert.setY(stage.getY() + (stage.getHeight() / 2));
                            rejectAlert.show();
                        });
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PlayersListBaseNew.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
        });
        th.start();
    }

}
