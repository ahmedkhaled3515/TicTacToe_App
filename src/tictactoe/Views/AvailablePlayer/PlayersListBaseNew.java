package tictactoe.Views.AvailablePlayer;

import Requests.App;
import static Requests.App.input;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class PlayersListBaseNew extends AnchorPane {

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

    public PlayersListBaseNew(Stage stage) {

        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        backBtn = new ImageView();
        rectangle = new Rectangle();
        avaliable = new ArrayList<>();

        ItemBase item = new ItemBase();
        item.playerTxt.setText("Haneen");
        listView.getItems().add(item);
        listView.refresh();

        App.startConnection();
        Gson gson = new Gson();
        new Thread(() -> {
            while (App.server.isConnected()) {
                try {
                    String jsonEmailList = input.readLine();

                    // Convert the JSON string to a List of emails
                    Type listType = new TypeToken<List<String>>() {
                    }.getType();
                    List<String> newReceivedEmailList = gson.fromJson(jsonEmailList, listType);

                    // Synchronize access to the shared variable
                        receivedEmailList = newReceivedEmailList;
                    

                    Platform.runLater(() -> {
                        for (String email : newReceivedEmailList) {
                            ItemBase itemBase = new ItemBase();
                            itemBase.playerTxt.setText(email);
                            listView.getItems().add(itemBase);
                            listView.refresh();
                            System.out.print(email);
                        }
                    });
                } catch (IOException ex) {
                    System.out.println("server closed !!!");
                    Logger.getLogger(SignupBase.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
        }).start();

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

        backBtn.setFitHeight(73.0);
        backBtn.setFitWidth(100.0);
        backBtn.setLayoutX(391.0);
        backBtn.setLayoutY(56.0);
        backBtn.setPickOnBounds(true);
        backBtn.setPreserveRatio(true);
        backBtn.setImage(new Image(getClass().getResource("symbole-fleche-gauche-violet.png").toExternalForm()));
        backBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase(stage);               
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
             
            }
        });


        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#7f1fff"));
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

        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(availableLabel);
        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(listView);
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
}
