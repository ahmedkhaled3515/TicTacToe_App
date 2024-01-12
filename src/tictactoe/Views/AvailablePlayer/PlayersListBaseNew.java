package tictactoe.Views.AvailablePlayer;

import java.net.URL;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class PlayersListBaseNew extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label availableLabel;
    protected final ImageView backBtn;
    protected final Rectangle rectangle;
    protected static ListView listView=new ListView();
    public  static ArrayList<String> avaliable ;
    public static boolean closeInvite=false,checkforclose=false;

    public PlayersListBaseNew() {

        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        backBtn = new ImageView();
        rectangle = new Rectangle();        
        avaliable=new ArrayList<>();


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

        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#350663"));
        rectangle.setHeight(472.0);
        rectangle.setLayoutX(401.0);
        rectangle.setLayoutY(156.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
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
// public static void preperList(String name){
//    
//        ItemBase itemBase = new ItemBase();
//        itemBase.playerNameText.setText(name);
//        availablePlayerslistView.getItems().add(itemBase);
//        availablePlayerslistView.refresh();
//    }
//    
//    public static void showDialog(String name ,String PlayerIdOfTheInvitation){
//    Platform.runLater(() -> {
//        Alert alert = new Alert(Alert.AlertType.NONE,"Attention",ButtonType.OK,ButtonType.CANCEL); 
//        alert.setTitle("Attention");
//        alert.setContentText("you are invited to play with "+name+"\n"+"if you accept the invitation press ok button");
//         Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(5000);
//                if (alert.isShowing()) {
//                    if(!checkforclose){
//                        Platform.runLater(() -> alert.close());
//                       checkforclose=true;
//                    }
//                }
//            } catch (Exception exp) {
//                exp.printStackTrace();
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//        alert.showAndWait().ifPresent(rs->{
//            if(rs==ButtonType.OK){
//                if(!checkforclose){
//                    String repleyMessage="acceptInvitation,"+PlayerIdOfTheInvitation;
//                    LoginFXMLBase.playerConnection.sendMessage(repleyMessage);
//                    checkforclose=true;
//                }else checkforclose=false;
//                        
//            }
//            else{
//                if(!checkforclose){
//                    String repleyMessage="rejectInvitation,"+PlayerIdOfTheInvitation;
//                    LoginFXMLBase.playerConnection.sendMessage(repleyMessage);
//                    checkforclose=true;
//                }else checkforclose=false;
//            }
//           
//
//        });
//    });
//    }
//
//    public static void removeFromList(String name)
//    {
//        for (Object item : availablePlayerslistView.getItems()) {
//            if(((ItemBase)item).playerNameText.getText().equals(name))
//            {
//                availablePlayerslistView.getItems().remove(item);
//                availablePlayerslistView.refresh();
//                break;
//            }
//        }
//    }

}
