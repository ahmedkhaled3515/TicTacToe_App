package tictactoe.localmode;

import SelectmodeView.SelectModeBase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import tictactoe.TicTacToe;

import javafx.stage.Stage;

import tictactoe.Views.LocalMode2Players.GameBoardBase2Players;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;


public  class LocalViewBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundimage;
    protected final Label headLabel;
    protected final Button startbutton;
    protected final TextField playerOneName;
    protected final TextField playerTwoName;
    FontAwesomeIcon arrow;
    TicTacToe mainApp;
  
    
    private boolean startButtonClicked = false;

    public LocalViewBase(Stage stage) {

        anchorPane = new AnchorPane();
        backgroundimage = new ImageView();
        headLabel = new Label();
        startbutton = new Button();
        playerOneName = new TextField();
        playerTwoName = new TextField();
        arrow = new FontAwesomeIcon();
         
         
 
        getStylesheets().add(getClass().getResource("localstyle.css").toExternalForm());
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(1000.0);

        backgroundimage.setFitHeight(708.0);
        backgroundimage.setFitWidth(1000.0);
        backgroundimage.setLayoutY(-1.0);
        backgroundimage.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        headLabel.setLayoutX(614.0);
        headLabel.setLayoutY(108.0);
        headLabel.setText("tic.tac.toe.");
        headLabel.setTextFill(javafx.scene.paint.Color.valueOf("#c5a0d7"));
        headLabel.setFont(new Font("Arial Rounded MT Bold", 64.0));

        startbutton.setId("buttonstyles");
        startbutton.setLayoutX(658.0);
        startbutton.setLayoutY(471.0);
        startbutton.setMnemonicParsing(false);
        startbutton.setPrefHeight(23.0);
        startbutton.setPrefWidth(257.0);
        startbutton.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 90;");
        startbutton.setText("start");
        startbutton.setFont(new Font("Arial", 26.0));
        startbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene=new Scene(new GameBoardBase2Players(stage,playerOneName.getText(),playerTwoName.getText()));
                stage.setScene(scene);
                //To change body of generated methods, choose Tools | Templates.
            }
        });
//      startbutton.setOnAction(new EventHandler<ActionEvent>() {

//            @Override
//            public void handle(ActionEvent event) {
//                
//                 if (startButtonClicked) {
//
//                    startbutton.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
//                 } else {
//                    startbutton.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
//                 }
//                    startButtonClicked = !startButtonClicked;
//                 }
//
//            startbutton.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
//               Parent root = new GameBoardBase() ;
//                scene = new Scene(root);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
//        } else {
//            startbutton.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
//        }
//        startButtonClicked = !startButtonClicked;
//    }
//
//        }); 
      

        playerOneName.setLayoutX(664.0);
        playerOneName.setLayoutY(289.0);
        playerOneName.setPrefHeight(42.0);
        playerOneName.setPrefWidth(234.0);
        playerOneName.setPromptText("player one");
        playerOneName.setStyle("-fx-background-radius: 26 26 26 26;");
        playerOneName.setFont(new Font("System Bold", 19.0));

        playerTwoName.setLayoutX(664.0);
        playerTwoName.setLayoutY(382.0);
        playerTwoName.setPrefHeight(42.0);
        playerTwoName.setPrefWidth(234.0);
        playerTwoName.setPromptText("player two");
        playerTwoName.setStyle("-fx-background-radius: 26 26 26 26;");
        playerTwoName.setFont(new Font("System Bold",19.0));

        arrow.setLayoutX(15.0);
        arrow.setLayoutY(115.0);
        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);
        arrow.setSize("7em");
        arrow.setId("arrow");
        arrow.scaleXProperty().add(1);
        arrow.scaleYProperty().add(1);
        arrow.scaleZProperty().add(1);
        arrow.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();           
            }
        });
        anchorPane.getChildren().add(backgroundimage);
        anchorPane.getChildren().add(headLabel);
        anchorPane.getChildren().add(startbutton);
        anchorPane.getChildren().add(playerOneName);
        anchorPane.getChildren().add(playerTwoName);
        anchorPane.getChildren().add(arrow);
        getChildren().add(anchorPane);

    }
}
