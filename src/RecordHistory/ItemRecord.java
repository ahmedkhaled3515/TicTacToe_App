/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RecordHistory;
import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
/**
 *
 * @author Dell
 */
public class ItemRecord extends AnchorPane{
     protected final Rectangle rectangle;
    protected final Text playerTxt;
    protected final Text playerScore;
    protected final Button inviteBTn;
    
     public ItemRecord(){
         
         
        rectangle = new Rectangle();
        playerTxt = new Text();
        playerScore = new Text();
        inviteBTn = new Button();
        
        
          setId("AnchorPane");
        setPrefHeight(71.0);
        setPrefWidth(458.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/item.css");

        rectangle.setArcHeight(50.0);
        rectangle.setArcWidth(50.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#312B78"));
        rectangle.setHeight(73.0);
        rectangle.setStroke(javafx.scene.paint.Color.BEIGE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(510.0);

        playerTxt.setLayoutX(20.0);
        playerTxt.setLayoutY(43.0);
        playerTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTxt.setStrokeWidth(0.0);
        playerTxt.setText("Player Name");
        playerTxt.setWrappingWidth(116.6708984375);
        playerTxt.setFont(new Font(20.0));
        playerTxt.setId("txt");
        
        playerScore.setLayoutX(50.0);
        playerScore.setLayoutY(43.0);
        playerScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerScore.setStrokeWidth(0.0);
        playerScore.setText("Win");
        playerScore.setWrappingWidth(116.6708984375);
        playerScore.setFont(new Font(20.0));
        playerScore.setId("txt");


        inviteBTn.setLayoutX(306.0);
        inviteBTn.setLayoutY(20.0);
        inviteBTn.setMnemonicParsing(false);
        inviteBTn.setPrefHeight(31.0);
        inviteBTn.setPrefWidth(120.0);
        inviteBTn.setText("View Record");
         inviteBTn.setId("btn");

        getChildren().add(rectangle);
        getChildren().add(playerTxt);
        getChildren().add(inviteBTn);
        getChildren().add(playerScore);
         
     }
    
}
