package tictactoe.Views.LocalMode2Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.TicTacToe;

public class GameBoardBase2Players extends AnchorPane implements ActionListener{

    boolean player1Turn=true;
    Random random = new Random();
    protected final ImageView backgroundImage;
    protected final GridPane boardGrid;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button button0;
    protected final Button button1;
    protected final Button button2;
    protected final Button button3;
    protected final Button button4;
    protected final Button button5;
    protected final Button button6;
    protected final Button button7;
    protected final Button button8;
    protected final GridPane scoreGrid;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints2;
    protected final BorderPane score1Pane;
    protected final Text player1Text;
    protected final Text player1ScoreText;
    protected final BorderPane drawPane;
    protected final Text drawScoreText;
    protected final Text drawText;
    protected final BorderPane score2Pane;
    protected final Text player2ScoreText;
    protected final Text player2Text;
    protected final Button newGameButton;
    protected final Button exitButton;
    protected final Text playerTurnText;
    boolean newGameFlag = true;
    // Create an array to store buttons
    Button[] buttonArray = new Button[9];
    int indexA;
    int indexB;
    int indexC;
    
    
    public GameBoardBase2Players(TicTacToe mainApp) {

        backgroundImage = new ImageView();
        boardGrid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        button0 = new Button();
        button1 = new Button();
        button2 = new Button();
        button3 = new Button();
        button4 = new Button();
        button5 = new Button();
        button6 = new Button();
        button7 = new Button();
        button8 = new Button();
        scoreGrid = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        score1Pane = new BorderPane();
        player1Text = new Text();
        player1ScoreText = new Text();
        drawPane = new BorderPane();
        drawScoreText = new Text();
        drawText = new Text();
        score2Pane = new BorderPane();
        player2ScoreText = new Text();
        player2Text = new Text();
        newGameButton = new Button();
        exitButton = new Button();
        playerTurnText = new Text();
        
        
        buttonArray[0] = button0;
        buttonArray[1] = button1;        
        buttonArray[2] = button2;        
        buttonArray[3] = button3;
        buttonArray[4] = button4;
        buttonArray[5] = button5;
        buttonArray[6] = button6;
        buttonArray[7] = button7;
        buttonArray[8] = button8;

        
        button0.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button1.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button2.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button3.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button4.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button5.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button6.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button7.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        button8.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1000.0);
        backgroundImage.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        boardGrid.setHgap(10.0);
        boardGrid.setLayoutX(265.0);
        boardGrid.setLayoutY(171.0);
        boardGrid.setPrefHeight(359.0);
        boardGrid.setPrefWidth(470.0);
        boardGrid.setVgap(10.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        button0.setMnemonicParsing(false);
        button0.setPrefHeight(130.0);
        button0.setPrefWidth(211.0);

        GridPane.setColumnIndex(button1, 1);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(200.0);
        button1.setPrefWidth(255.0);

        GridPane.setColumnIndex(button2, 2);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(144.0);
        button2.setPrefWidth(215.0);

        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(123.0);
        button3.setPrefWidth(212.0);

        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(139.0);
        button4.setPrefWidth(260.0);

        GridPane.setColumnIndex(button5, 2);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(139.0);
        button5.setPrefWidth(242.0);

        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(127.0);
        button6.setPrefWidth(234.0);

        GridPane.setColumnIndex(button7, 1);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(196.0);
        button7.setPrefWidth(192.0);

        GridPane.setColumnIndex(button8, 2);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(161.0);
        button8.setPrefWidth(220.0);

        scoreGrid.setHgap(10.0);
        scoreGrid.setLayoutX(276.0);
        scoreGrid.setLayoutY(43.0);
        scoreGrid.setPrefHeight(99.0);
        scoreGrid.setPrefWidth(448.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(100.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        score1Pane.setPrefHeight(200.0);
        score1Pane.setPrefWidth(143.0);
        score1Pane.setStyle("-fx-background-radius: 15; -fx-background-color: red;");

        BorderPane.setAlignment(player1Text, javafx.geometry.Pos.CENTER);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);
        player1Text.setText("Player 1");
        player1Text.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(player1Text, new Insets(5.0, 0.0, 0.0, 0.0));
        score1Pane.setTop(player1Text);

        BorderPane.setAlignment(player1ScoreText, javafx.geometry.Pos.CENTER);
        player1ScoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1ScoreText.setStrokeWidth(0.0);
        player1ScoreText.setText("0");
        player1ScoreText.setFont(new Font("Arial Bold", 36.0));
        score1Pane.setCenter(player1ScoreText);

        GridPane.setColumnIndex(drawPane, 1);
        drawPane.setPrefHeight(200.0);
        drawPane.setPrefWidth(200.0);
        drawPane.setStyle("-fx-background-radius: 15; -fx-background-color: yellow;");

        BorderPane.setAlignment(drawScoreText, javafx.geometry.Pos.CENTER);
        drawScoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawScoreText.setStrokeWidth(0.0);
        drawScoreText.setText("0");
        drawScoreText.setFont(new Font("Arial Bold", 36.0));
        drawPane.setCenter(drawScoreText);

        BorderPane.setAlignment(drawText, javafx.geometry.Pos.CENTER);
        drawText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawText.setStrokeWidth(0.0);
        drawText.setText("Draw");
        drawText.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(drawText, new Insets(5.0, 0.0, 0.0, 0.0));
        drawPane.setTop(drawText);

        GridPane.setColumnIndex(score2Pane, 2);
        score2Pane.setPrefHeight(88.0);
        score2Pane.setPrefWidth(142.0);
        score2Pane.setStyle("-fx-background-radius: 15; -fx-background-color: blue;");

        BorderPane.setAlignment(player2ScoreText, javafx.geometry.Pos.CENTER);
        player2ScoreText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2ScoreText.setStrokeWidth(0.0);
        player2ScoreText.setText("0");
        player2ScoreText.setFont(new Font("Arial Bold", 36.0));
        score2Pane.setCenter(player2ScoreText);

        BorderPane.setAlignment(player2Text, javafx.geometry.Pos.CENTER);
        player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Text.setStrokeWidth(0.0);
        player2Text.setText("Player 2");
        player2Text.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(player2Text, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(player2Text);

        newGameButton.setLayoutX(352.0);
        newGameButton.setLayoutY(552.0);
        newGameButton.setMnemonicParsing(false);
        newGameButton.setPrefHeight(60.0);
        newGameButton.setPrefWidth(130.0);
        newGameButton.setStyle("-fx-background-radius: 15;");
        newGameButton.setText("New Game");
        newGameButton.setFont(new Font("Arial Bold", 14.0));
        newGameButton.setOpaqueInsets(new Insets(0.0));
        newGameButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            
        @Override
        public void handle(javafx.event.ActionEvent event) {
           
        for(int i=0; i<9; i++){
            buttonArray[i].setDisable(false);
        }
        
        
        for(int i=0; i<9; i++){
            buttonArray[i].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        }
      
        
                button0.setText("");
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                
                if(newGameFlag==false){
                    firstTurn();
                    actionPerformedButtons();
                }
            }
        }
        );
        
        
        exitButton.setLayoutX(528.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(130.0);
        exitButton.setStyle("-fx-background-radius: 15;");
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial Bold", 14.0));
        
        exitButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
               System.exit(0); 
            }
        }
        );
        

        playerTurnText.setLayoutX(760.0);
        playerTurnText.setLayoutY(377.0);
        playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTurnText.setStrokeWidth(0.0);
        playerTurnText.setText("Player's Turn");
        playerTurnText.setFont(new Font(36.0));

        getChildren().add(backgroundImage);
        boardGrid.getColumnConstraints().add(columnConstraints);
        boardGrid.getColumnConstraints().add(columnConstraints0);
        boardGrid.getColumnConstraints().add(columnConstraints1);
        boardGrid.getRowConstraints().add(rowConstraints);
        boardGrid.getRowConstraints().add(rowConstraints0);
        boardGrid.getRowConstraints().add(rowConstraints1);
        boardGrid.getChildren().add(button0);
        boardGrid.getChildren().add(button1);
        boardGrid.getChildren().add(button2);
        boardGrid.getChildren().add(button3);
        boardGrid.getChildren().add(button4);
        boardGrid.getChildren().add(button5);
        boardGrid.getChildren().add(button6);
        boardGrid.getChildren().add(button7);
        boardGrid.getChildren().add(button8);
        getChildren().add(boardGrid);
        scoreGrid.getColumnConstraints().add(columnConstraints2);
        scoreGrid.getColumnConstraints().add(columnConstraints3);
        scoreGrid.getColumnConstraints().add(columnConstraints4);
        scoreGrid.getRowConstraints().add(rowConstraints2);
        scoreGrid.getChildren().add(score1Pane);
        scoreGrid.getChildren().add(drawPane);
        scoreGrid.getChildren().add(score2Pane);
        getChildren().add(scoreGrid);
        getChildren().add(newGameButton);
        getChildren().add(exitButton);
        getChildren().add(playerTurnText);

        if(newGameFlag==true){
            for(int i=0; i<9;i++){
                buttonArray[i].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
            }
            firstTurn();
            actionPerformedButtons();
            newGameFlag=false;
        }
    }
    
    
    public void actionPerformedButtons(){
        
        button0.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button0;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        });
        
        button1.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button1;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        });
        
        button2.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button2;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        });
        
        button3.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button3;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        });   

         button4.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button4;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        });        
        
        button5.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button5;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        }); 

         button6.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button6;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        }); 

        button7.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button7;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        }); 
        
        button8.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                Button fakeButton = button8;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
            }
        }); 

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i=0; i<9; i++){
           if(e.getSource()==buttonArray[i]){
               if(player1Turn==true){
                   if(buttonArray[i].getText()==""){
                       buttonArray[i].setTextFill(Color.rgb(197,160,215));
                       playerTurnText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
                       playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
                       playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                       buttonArray[i].setText("X");
                       player1Turn=false;
                       playerTurnText.setText("O turn");
                       checkIfAnyPlayerWon();
                   }
               }else{
                       if(buttonArray[i].getText()==""){
                       buttonArray[i].setTextFill(Color.rgb(197,160,215));
                       buttonArray[i].setText("O");
                       playerTurnText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
                       playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
                       playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                       player1Turn=true;
                       playerTurnText.setText("X turn");   
                       checkIfAnyPlayerWon();
                   }   
               }
           }
       }
    }
    
    public void firstTurn(){
        if(random.nextInt(2)==0){
            player1Turn = true;
            playerTurnText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            playerTurnText.setText("X turn");

        }else{
            player1Turn = false;  
            playerTurnText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            playerTurnText.setText("O turn");
        }
    }
    
    public void checkIfAnyPlayerWon(){
        if(buttonArray[0].getText()=="X" &&
           buttonArray[1].getText()=="X" &&
           buttonArray[2].getText()=="X"){
            checkIfXWins(0,1,2);
            
        }
        if(buttonArray[3].getText()=="X" &&
           buttonArray[4].getText()=="X" &&
           buttonArray[5].getText()=="X"){
            checkIfXWins(3,4,5);
            
        } 
        if(buttonArray[6].getText()=="X" &&
           buttonArray[7].getText()=="X" &&
           buttonArray[8].getText()=="X"){
            checkIfXWins(6,7,8);
            
        }
        if(buttonArray[0].getText()=="X" &&
           buttonArray[3].getText()=="X" &&
           buttonArray[6].getText()=="X"){
            checkIfXWins(0,3,6);
            
        }
        if(buttonArray[1].getText()=="X" &&
           buttonArray[4].getText()=="X" &&
           buttonArray[7].getText()=="X"){
            checkIfXWins(1,4,7);
            
        } 
        if(buttonArray[2].getText()=="X" &&
           buttonArray[5].getText()=="X" &&
           buttonArray[8].getText()=="X"){
            checkIfXWins(2,5,8);
            
        }
        if(buttonArray[0].getText()=="X" &&
           buttonArray[4].getText()=="X" &&
           buttonArray[8].getText()=="X"){
            checkIfXWins(0,4,8);
            
        } 
        if(buttonArray[2].getText()=="X" &&
           buttonArray[4].getText()=="X" &&
           buttonArray[6].getText()=="X"){
            checkIfXWins(2,4,6);
            
        }
        
        if(buttonArray[0].getText()=="O" &&
           buttonArray[1].getText()=="O" &&
           buttonArray[2].getText()=="O"){
            checkIfOWins(0,1,2);
            
        }
        if(buttonArray[3].getText()=="O" &&
           buttonArray[4].getText()=="O" &&
           buttonArray[5].getText()=="O"){
            checkIfOWins(3,4,5);
            
        } 
        if(buttonArray[6].getText()=="O" &&
           buttonArray[7].getText()=="O" &&
           buttonArray[8].getText()=="O"){
            checkIfOWins(6,7,8);
            
        }
        if(buttonArray[0].getText()=="O" &&
           buttonArray[3].getText()=="O" &&
           buttonArray[6].getText()=="O"){
            checkIfOWins(0,3,6);
            
        }
        if(buttonArray[1].getText()=="O" &&
           buttonArray[4].getText()=="O" &&
           buttonArray[7].getText()=="O"){
            checkIfOWins(1,4,7);
            
        } 
        if(buttonArray[2].getText()=="O" &&
           buttonArray[5].getText()=="O" &&
           buttonArray[8].getText()=="O"){
            checkIfOWins(2,5,8);
            
        }
        if(buttonArray[0].getText()=="O" &&
           buttonArray[4].getText()=="O" &&
           buttonArray[8].getText()=="O"){
            checkIfOWins(0,4,8);
            
        } 
        if(buttonArray[2].getText()=="O" &&
           buttonArray[4].getText()=="O" &&
           buttonArray[6].getText()=="O"){
            checkIfOWins(2,4,6);
            
        }
    }
    
    public void checkIfXWins(int a, int b, int c){

            buttonArray[a].setStyle("-fx-background-color: green; -fx-text-fill: white;");
            buttonArray[b].setStyle("-fx-background-color: green; -fx-text-fill: white;");
            buttonArray[c].setStyle("-fx-background-color: green; -fx-text-fill: white;");

        for(int i=0; i<9; i++){
            buttonArray[i].setDisable(true);
        }
        
        playerTurnText.setText("X Wins");
        
    }
    
    public void checkIfOWins(int a, int b, int c){
        
        indexA=a;
        indexB=b;
        indexC=c;
        

            buttonArray[a].setStyle("-fx-background-color: green; -fx-text-fill: white;");
            buttonArray[b].setStyle("-fx-background-color: green; -fx-text-fill: white;");
            buttonArray[c].setStyle("-fx-background-color: green; -fx-text-fill: white;");

        for(int i=0; i<9; i++){
            buttonArray[i].setDisable(true);
        }
        
        playerTurnText.setText("O Wins");   
    }

}
