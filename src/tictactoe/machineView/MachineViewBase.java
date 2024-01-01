package tictactoe.machineView;

import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static tictactoe.TicTacToe.scene;

public  class MachineViewBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Text titleText;
    protected final Button recording;
    protected final Button continuw;
    protected final Button choseX;
    protected final Button choseO;
    protected final ImageView arrowback;

    
     private boolean recordingClickState = false;
    private boolean continuwClickState = false;
    private boolean choseXClickState = false;
    private boolean choseOClickState = false;
    
    
      
        
    
    public MachineViewBase() {

        imageView = new ImageView();
        titleText = new Text();
        recording = new Button();
        
        continuw = new Button();
        choseX = new Button();
        choseO = new Button();
        arrowback = new ImageView();

        
    
        
        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/machineView/machineview.css");

        imageView.setFitHeight(710.0);
        imageView.setFitWidth(1020.0);
        imageView.setLayoutX(-4.0);
        imageView.setLayoutY(-1.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        titleText.setFill(javafx.scene.paint.Color.valueOf("#c5a0d7"));
        titleText.setLayoutX(657.0);
        titleText.setLayoutY(179.0);
        titleText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titleText.setStrokeWidth(0.0);
        titleText.setText("tic.tac.toe.");
        titleText.setWrappingWidth(263.6708984375);
        titleText.setFont(new Font("System Bold", 39.0));

        recording.setLayoutX(639.0);
        recording.setLayoutY(398.0);
        recording.setMnemonicParsing(false);
        recording.setPrefHeight(63.0);
        recording.setPrefWidth(264.0);
        recording.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        recording.setText("Recording");
        recording.setFont(new Font(29.0));
        
        recording.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                        if (recordingClickState) {
            recording.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        } else {
            recording.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
        }
        recordingClickState= !recordingClickState;
    }
        });

        continuw.setLayoutX(639.0);
        continuw.setLayoutY(519.0);
        continuw.setMnemonicParsing(false);
        continuw.setPrefHeight(63.0);
        continuw.setPrefWidth(264.0);
        continuw.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        continuw.setText("continue");
        continuw.setFont(new Font(29.0));
        continuw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               
                        if (continuwClickState) {
            continuw.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        } else {
            continuw.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
        }
        continuwClickState = !continuwClickState;
    }
        });
                
                
        choseX.setLayoutX(669.0);
        choseX.setLayoutY(248.0);
        choseX.setMnemonicParsing(false);
        choseX.setPrefHeight(63.0);
        choseX.setPrefWidth(65.0);
        choseX.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15 15 15 15;");
        choseX.setText("X");
        choseX.setFont(new Font("System Bold", 29.0));
        choseX.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                         if (choseXClickState) {
            choseX.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        } else {
            choseX.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
        }
        choseXClickState = !choseXClickState;
    }
               
              
                
            
        });

        choseO.setLayoutX(819.0);
        choseO.setLayoutY(248.0);
        choseO.setMnemonicParsing(false);
        choseO.setPrefHeight(63.0);
        choseO.setPrefWidth(65.0);
        choseO.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15 15 15 15;");
        choseO.setText("O");
        choseO.setFont(new Font("System Bold", 29.0));
         choseO.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                 if (choseOClickState) {
            choseO.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 26 26 26 26;");
        } else {
            choseO.setStyle("-fx-background-color: 72CFF9; -fx-background-radius: 26 26 26 26;");
        }
        choseOClickState = !choseOClickState;
    }
        });
         
        arrowback.setFitHeight(52.0);
        arrowback.setFitWidth(65.0);
        arrowback.setLayoutX(524.0);
        arrowback.setLayoutY(73.0);
        arrowback.setPickOnBounds(true);
        arrowback.setPreserveRatio(true);
        arrowback.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase() ;
                scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
        });

        arrowback.setImage(new Image(getClass().getResource("arrowback.jpg").toExternalForm()));
        
        

        getChildren().add(imageView);
        getChildren().add(titleText);
        getChildren().add(recording);
        getChildren().add(continuw);
        getChildren().add(choseX);
        getChildren().add(choseO);
        getChildren().add(arrowback);

    }
}
