package tictactoe.Views.AvailablePlayer;

import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.Views.login.loginBase;

public class ItemBase extends AnchorPane {

    protected final Rectangle rectangle;
    protected final Text playerTxt;
    protected final Button inviteBTn;
    static String playerNameToBeInvite="";

    public ItemBase() {

        rectangle = new Rectangle();
        playerTxt = new Text();
        inviteBTn = new Button();

        setId("AnchorPane");
        setPrefHeight(262.0);
        setPrefWidth(835.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/item.css");

        rectangle.setArcHeight(50.0);
        rectangle.setArcWidth(50.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#305bc3"));
        rectangle.setHeight(50.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(410.0);


        playerTxt.setFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        playerTxt.setLayoutX(20.0);
        playerTxt.setLayoutY(33.0);
        playerTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTxt.setStrokeWidth(0.0);
        playerTxt.setText("Player Name");
        playerTxt.setWrappingWidth(95.6708984375);
        playerTxt.setFont(new Font("Serif Regular", 24.0));
        playerTxt.autosize();

           inviteBTn.setLayoutX(297.0);
        inviteBTn.setLayoutY(8.0);
        inviteBTn.setMnemonicParsing(false);
        inviteBTn.setPrefHeight(33.0);
        inviteBTn.setPrefWidth(77.0);
        inviteBTn.getStyleClass().add("inviteBtn");
        inviteBTn.getStylesheets().add("/tic/tac/toe/css/Item.css");
        inviteBTn.setText("Invite");
        inviteBTn.setFont(new Font("Serif Regular", 20.0));
        inviteBTn.setOnAction(event ->{
            if(!PlayersListBaseNew.closeInvite){
                PlayersListBaseNew.closeInvite=true;
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                      PlayersListBaseNew.closeInvite=false;  
                    }
                }, 6000);
//                if(loginBase.playerConnection!=null){
//                    OnLineGameBoard.myTurn=true;
//                  
//                        String playerIdToBeInvite="";
//                        for(int i=2;i<PlayersListBaseNew.avaliable.size();i+=2){
//                            if(playerTxt.getText().equals(PlayersListBaseNew.avaliable.get(i))){
//                                playerIdToBeInvite=PlayersListBaseNew.avaliable.get(i-1);
//                                playerNameToBeInvite=playerTxt.getText();
//                                break;
//                            }
//                        }
//
//                        loginBase.playerConnection.sendMessage("invite,"+playerIdToBeInvite+","+loginBase.playerData.userName);
//                       
//                }
            }
        });;

        getChildren().add(rectangle);
        getChildren().add(playerTxt);
        getChildren().add(inviteBTn);

    }
}
