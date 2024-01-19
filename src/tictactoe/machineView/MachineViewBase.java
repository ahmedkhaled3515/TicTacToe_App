package tictactoe.machineView;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import computer22.Computerplay;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.Views.computerMode.ComputerModeBase;

public  class MachineViewBase extends AnchorPane {

    protected final ImageView imageView;
    protected final Label headLabel;
  //  protected final Button recording;
    protected final Button continuw;
    protected final Button choseX;
    protected final Button choseO;
    private boolean recordingClickState = false;
    private boolean continuwClickState = false;
    private boolean choseXClickState = false;
    private boolean choseOClickState = false;
    FontAwesomeIcon arrow;
    
   
      
        
    
    public MachineViewBase(Stage stage) {
        arrow=new FontAwesomeIcon();
        imageView = new ImageView();
        headLabel = new Label();
      //  recording = new Button();
        
        continuw = new Button();
        choseX = new Button();
        choseO = new Button();

        
    
        
        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/machineView/machineview.css");

        imageView.setFitHeight(700);
        imageView.setFitWidth(1000);
        
        imageView.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        headLabel.setLayoutX(614.0);
        headLabel.setLayoutY(108.0);
        headLabel.setText("tic.tac.toe.");
        headLabel.setTextFill(javafx.scene.paint.Color.valueOf("#c5a0d7"));
        headLabel.setFont(new Font("Arial Rounded MT Bold", 64.0));
/*
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

  */      continuw.setLayoutX(639.0);
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
         continuw.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                       if (choseXClickState) {
                         Parent root = new Computerplay(stage,"X" );
                         Scene scene = new Scene(root,1000,700);
                            stage.setScene(scene);
                            stage.show();
                    } else if(choseOClickState){
                        Parent root = new Computerplay(stage ,"O" );
                        Scene scene = new Scene(root,1000,700);
                           stage.setScene(scene);
                           stage.show();
                        
                    }else{
                         Parent root = new Computerplay(stage,"X" );
                         Scene scene = new Scene(root,1000,700);
                            stage.setScene(scene);
                            stage.show();
      
                    }
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
                Parent root = new SelectModeBase(stage) ;
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        });
        getChildren().add(imageView);
        getChildren().add(headLabel);
       // getChildren().add(recording);
        getChildren().add(continuw);
        getChildren().add(choseX);
        getChildren().add(choseO);
        getChildren().add(arrow);

    }
}
