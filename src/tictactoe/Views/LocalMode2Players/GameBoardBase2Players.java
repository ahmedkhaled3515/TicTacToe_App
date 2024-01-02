package tictactoe.Views.LocalMode2Players;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaErrorEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
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
    protected final Button playMusicButton;
    protected final GridPane scoreGrid;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints2;
    protected final BorderPane score1Pane;
    protected final Text player1Text;
    protected Text player1ScoreText;
    protected final BorderPane drawPane;
    protected final Text drawScoreText;
    protected final Text drawText;
    protected final BorderPane score2Pane;
    protected Text player2ScoreText;
    protected final Text player2Text;
    protected final Button newGameButton;
    protected final Button mainMenuButton;
    protected final Text playerTurnText;
    boolean newGameFlag = true;
    // Create an array to store buttons
    Button[] buttonArray = new Button[9];
    int indexA;
    int indexB;
    int indexC;
    int xWinCounter;
    int oWinCounter;
    int drawCounter;
    boolean drawCountFlag=true;
    int x;
    int mouseClickCounter;
    boolean playMusicFlag=true;
    String soundFile;
    Media media;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;
    MediaView mediaView;
    
    boolean button0Flag=true;
    boolean button1Flag=true;
    boolean button2Flag=true;
    boolean button3Flag=true;
    boolean button4Flag=true;
    boolean button5Flag=true;
    boolean button6Flag=true;
    boolean button7Flag=true;
    boolean button8Flag=true;
    
    boolean xStartFirst=true;
    
    public GameBoardBase2Players(Stage stage) {

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
        playMusicButton= new Button();
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
        mainMenuButton = new Button();
        playerTurnText = new Text();
        xWinCounter=0;
        oWinCounter=0;
        drawCounter=0;
        x=0;
        mouseClickCounter=0;
        
        gameboardMusicWhenTheScreenAppears();
        playMusicFlag=false;
        
        
       /* 
        // Load the sound file
        soundFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/gameMusic.mp3";
        sound = new Media(soundFile);
        mediaPlayer = new MediaPlayer(sound);
        mediaView= new MediaView(mediaPlayer);
        mediaView.setMediaPlayer(mediaPlayer);
        playMusicWhenTheGameboardOpen();
        playMusicFlag=false;
        
       */ 

        
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
        backgroundImage.setImage(new Image(getClass().getResource("backgroundImageGif.gif").toExternalForm()));

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
        button0.setFont(new Font(50)); 
        button0.setStyle("-fx-text-stroke: white;");
        
        GridPane.setColumnIndex(button1, 1);
        button1.setMnemonicParsing(false);
        button1.setPrefHeight(200.0);
        button1.setPrefWidth(255.0);
        button1.setFont(new Font(50)); 
        button1.setStyle("-fx-text-stroke: white;");

        GridPane.setColumnIndex(button2, 2);
        button2.setMnemonicParsing(false);
        button2.setPrefHeight(144.0);
        button2.setPrefWidth(215.0);
        button2.setFont(new Font(50)); 
        button2.setStyle("-fx-text-stroke: white;");
        
        GridPane.setRowIndex(button3, 1);
        button3.setMnemonicParsing(false);
        button3.setPrefHeight(123.0);
        button3.setPrefWidth(212.0);
        button3.setFont(new Font(50)); 
        button3.setStyle("-fx-text-stroke: white;");
        
        GridPane.setColumnIndex(button4, 1);
        GridPane.setRowIndex(button4, 1);
        button4.setMnemonicParsing(false);
        button4.setPrefHeight(139.0);
        button4.setPrefWidth(260.0);
        button4.setFont(new Font(50)); 
        button4.setStyle("-fx-text-stroke: white;");
        
        GridPane.setColumnIndex(button5, 2);
        GridPane.setRowIndex(button5, 1);
        button5.setMnemonicParsing(false);
        button5.setPrefHeight(139.0);
        button5.setPrefWidth(242.0);
        button5.setFont(new Font(50)); 
        button5.setStyle("-fx-text-stroke: white;");
        
        GridPane.setRowIndex(button6, 2);
        button6.setMnemonicParsing(false);
        button6.setPrefHeight(127.0);
        button6.setPrefWidth(234.0);
        button6.setFont(new Font(50)); 
        button6.setStyle("-fx-text-stroke: white;");
        
        GridPane.setColumnIndex(button7, 1);
        GridPane.setRowIndex(button7, 2);
        button7.setMnemonicParsing(false);
        button7.setPrefHeight(196.0);
        button7.setPrefWidth(192.0);
        button7.setFont(new Font(50)); 
        button7.setStyle("-fx-text-stroke: white;");
        
        GridPane.setColumnIndex(button8, 2);
        GridPane.setRowIndex(button8, 2);
        button8.setMnemonicParsing(false);
        button8.setPrefHeight(161.0);
        button8.setPrefWidth(220.0);
        button8.setFont(new Font(50)); 
        button8.setStyle("-fx-text-stroke: white;");
 
        playMusicButton.setMnemonicParsing(false);
        playMusicButton.setLayoutX(30.0);
        playMusicButton.setLayoutY(100.0);
        playMusicButton.setFont(new Font(50)); 
        playMusicButton.setStyle("-fx-text-stroke: white;");
        playMusicButton.setPrefHeight(60.0);
        playMusicButton.setPrefWidth(200.0);
        playMusicButton.setStyle("-fx-background-radius: 15;");
        playMusicButton.setText("Stop Music");
        playMusicButton.setFont(new Font("Arial Bold", 27.0));
        playMusicButton.setOpaqueInsets(new Insets(0.0));
        playMusicButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        playMusicButton.setOnMouseEntered(event -> {
            playMusicButton.setStyle("-fx-background-color: #00CBFE;");
        });
        playMusicButton.setOnMouseExited(event -> {
            playMusicButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        });
        playMusicButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
             
                
                if(playMusicFlag==true){
                    mouseClick();
                    gameboardMusicWhenTheScreenAppears();
                     playMusicButton.setText("Stop");
                    playMusicFlag=false;
                }else{
                    mouseClick();
                    mediaPlayer.pause();
                    playMusicButton.setText("Play");
                    playMusicFlag=true;
                } 
            }
        });
       
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
        score1Pane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(player1Text, javafx.geometry.Pos.CENTER);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);
        player1Text.setText("Player 1");
        player1Text.setFont(new Font("Arial Bold", 27.0));
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
        drawPane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");
        
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
        drawText.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(drawText, new Insets(5.0, 0.0, 0.0, 0.0));
        drawPane.setTop(drawText);

        GridPane.setColumnIndex(score2Pane, 2);
        score2Pane.setPrefHeight(88.0);
        score2Pane.setPrefWidth(142.0);
        score2Pane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

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
        player2Text.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player2Text, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(player2Text);
        
        newGameButton.setLayoutX(300.0);
        newGameButton.setLayoutY(552.0);
        newGameButton.setMnemonicParsing(false);
        newGameButton.setPrefHeight(60.0);
        newGameButton.setPrefWidth(200.0);
        newGameButton.setStyle("-fx-background-radius: 15;");
        newGameButton.setText("New Game");
        newGameButton.setFont(new Font("Arial Bold", 27.0));
        newGameButton.setOpaqueInsets(new Insets(0.0));
        newGameButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        newGameButton.setOnMouseEntered(event -> {
            newGameButton.setStyle("-fx-background-color: #00CBFE;");
        });
        newGameButton.setOnMouseExited(event -> {
            newGameButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        });
        newGameButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() { 
        @Override
        public void handle(javafx.event.ActionEvent event) {
        allPlayingButtonsFalse(); 
        mouseClick();
        for(int i=0; i<9; i++){
            buttonArray[i].setDisable(false);
            mouseClickCounter=0;
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
                
                xStartFirst=true;
                if(newGameFlag==false){
                    firstTurn();
                    actionPerformedButtons();
                }
                
                manageDrawButtons();
            }
        }
                
        );
        
        mainMenuButton.setLayoutX(510.0);
        mainMenuButton.setLayoutY(552.0);
        mainMenuButton.setMnemonicParsing(false);
        mainMenuButton.setPrefHeight(60.0);
        mainMenuButton.setPrefWidth(200.0);
        mainMenuButton.setStyle("-fx-background-radius: 15;");
        mainMenuButton.setText("Main Menu");
        mainMenuButton.setFont(new Font("Arial Bold", 27.0));
        mainMenuButton.setStyle("-fx-background-color: #68CFD1 ;");
        mainMenuButton.setOnMouseEntered(event -> {
            mainMenuButton.setStyle("-fx-background-color: #00CBFE;");
        });
        mainMenuButton.setOnMouseExited(event -> {
            mainMenuButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        });
        mainMenuButton.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                allPlayingButtonsFalse(); 
                mouseClick();
                playMusicButton.setText("Play Music");
                mediaPlayer.stop();
                button0.setText("");
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                player1ScoreText.setText("0");
                player2ScoreText.setText("0");
                drawScoreText.setText("0");
                for(int i=0; i<9; i++){
                    buttonArray[i].setDisable(false);
                }
              //  allPlayingButtonsFalse();
                manageDrawButtons();
                System.exit(0);
        }
        }
        );
        
        playerTurnText.setLayoutX(770.0);
        playerTurnText.setLayoutY(345.0);
        playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTurnText.setStrokeWidth(2.0);
        playerTurnText.setText("Player's Turn");
        playerTurnText.setFont(new Font(70.0));

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
        getChildren().add(mainMenuButton);
        getChildren().add(playerTurnText);
        getChildren().add(playMusicButton);

      //  playMusic();    
        
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
                mouseClick();
                
                Button fakeButton = button0;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button0Flag=false;
                checkIfAnyPlayerWon();
            }
        });
        button1.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                
                Button fakeButton = button1;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button1Flag=false;
                checkIfAnyPlayerWon();
            }
        });
        button2.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button2;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button2Flag=false;
                checkIfAnyPlayerWon();
            }
        });
        button3.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button3;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button3Flag=false;
                checkIfAnyPlayerWon();
            }
        });   
        button4.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button4;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button4Flag=false;
                checkIfAnyPlayerWon();
            }
        });          
        button5.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button5;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button5Flag=false;
                checkIfAnyPlayerWon();
            }
        }); 
        button6.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button6;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button6Flag=false;
                checkIfAnyPlayerWon();
            }
        }); 
        button7.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button7;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button7Flag=false;
                checkIfAnyPlayerWon();
            }
        });        
        button8.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                mouseClick();
                Button fakeButton = button8;
                ActionEvent fakeEvent = new ActionEvent(fakeButton, ActionEvent.ACTION_PERFORMED, "SimulateButtonClick");
                actionPerformed(fakeEvent);
                mouseClickCounter=mouseClickCounter+1;
                button8Flag=false;
                checkIfAnyPlayerWon();
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
                       playerTurnText.setStroke(javafx.scene.paint.Color.WHITE);
                       playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                       buttonArray[i].setText("X");
                       player1Turn=false;
                       playerTurnText.setText("O Turn");
//                 //      checkIfAnyPlayerWon();
                   }
               }else{
                       if(buttonArray[i].getText()==""){
                       buttonArray[i].setTextFill(Color.rgb(197,160,215));
                       buttonArray[i].setText("O");
                       playerTurnText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
                       playerTurnText.setStroke(javafx.scene.paint.Color.WHITE);
                       playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
                       player1Turn=true;
                       playerTurnText.setText("X Turn");   
//                  //     checkIfAnyPlayerWon();
                   }   
               }
           }
       }
    }
    public void firstTurn(){
        if(xStartFirst==true){
            playerTurnText.setFill(javafx.scene.paint.Color.WHITE);
            playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            playerTurnText.setStrokeWidth(5.0);
            setEditsToPlayerTurnText();
            playerTurnText.setText("X Turn");
            player1Turn=true;
            xStartFirst=false;

        }else{  
            playerTurnText.setFill(javafx.scene.paint.Color.WHITE);
            playerTurnText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
            playerTurnText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            playerTurnText.setStrokeWidth(5.0);
            setEditsToPlayerTurnText();
            playerTurnText.setText("O Turn");
            player1Turn=false;
            xStartFirst=true;
        }
    }
    public void checkIfAnyPlayerWon(){
            
            if(buttonArray[0].getText()=="X" &&
               buttonArray[1].getText()=="X" &&
               buttonArray[2].getText()=="X"){
                xWins(0,1,2);

            }
            else if(buttonArray[3].getText()=="X" &&
               buttonArray[4].getText()=="X" &&
               buttonArray[5].getText()=="X"){
                xWins(3,4,5);

            } 
            else if(buttonArray[6].getText()=="X" &&
               buttonArray[7].getText()=="X" &&
               buttonArray[8].getText()=="X"){
                xWins(6,7,8);

            }
            else if(buttonArray[0].getText()=="X" &&
               buttonArray[3].getText()=="X" &&
               buttonArray[6].getText()=="X"){
                xWins(0,3,6);

            }
            else if(buttonArray[1].getText()=="X" &&
               buttonArray[4].getText()=="X" &&
               buttonArray[7].getText()=="X"){
                xWins(1,4,7);

            } 
            else if(buttonArray[2].getText()=="X" &&
               buttonArray[5].getText()=="X" &&
               buttonArray[8].getText()=="X"){
                xWins(2,5,8);

            }
            else if(buttonArray[0].getText()=="X" &&
               buttonArray[4].getText()=="X" &&
               buttonArray[8].getText()=="X"){
                xWins(0,4,8);

            } 
            else if(buttonArray[2].getText()=="X" &&
               buttonArray[4].getText()=="X" &&
               buttonArray[6].getText()=="X"){
                xWins(2,4,6);

            }

            else if(buttonArray[0].getText()=="O" &&
               buttonArray[1].getText()=="O" &&
               buttonArray[2].getText()=="O"){
                oWins(0,1,2);

            }
            else if(buttonArray[3].getText()=="O" &&
               buttonArray[4].getText()=="O" &&
               buttonArray[5].getText()=="O"){
                oWins(3,4,5);

            } 
            else if(buttonArray[6].getText()=="O" &&
               buttonArray[7].getText()=="O" &&
               buttonArray[8].getText()=="O"){
                oWins(6,7,8);

            }
            else if(buttonArray[0].getText()=="O" &&
               buttonArray[3].getText()=="O" &&
               buttonArray[6].getText()=="O"){
                oWins(0,3,6);

            }
            else if(buttonArray[1].getText()=="O" &&
               buttonArray[4].getText()=="O" &&
               buttonArray[7].getText()=="O"){
                oWins(1,4,7);

            } 
            else if(buttonArray[2].getText()=="O" &&
               buttonArray[5].getText()=="O" &&
               buttonArray[8].getText()=="O"){
                oWins(2,5,8);

            }
            else if(buttonArray[0].getText()=="O" &&
               buttonArray[4].getText()=="O" &&
               buttonArray[8].getText()=="O"){
                oWins(0,4,8);

            } 
            else if(buttonArray[2].getText()=="O" &&
               buttonArray[4].getText()=="O" &&
               buttonArray[6].getText()=="O"){
                oWins(2,4,6);
            }
            else{
                if(button0Flag==false && 
                   button1Flag==false &&
                   button2Flag==false &&
                   button3Flag==false && 
                   button4Flag==false &&
                   button5Flag==false &&
                   button6Flag==false && 
                   button7Flag==false &&
                   button8Flag==false){
                    x=x+1;
                    drawScoreText.setText(Integer.toString(x)); 
                    playerTurnText.setText("Draw");
                    setEditsToPlayerTurnText();
                    DrawPlayVideo();
                    manageDrawButtons();
                    
                }

            }
          
    }
    public void xWins(int a, int b, int c){

         xWinsVideo();
        
        
        indexA=a;
        indexB=b;
        indexC=c;
        
        buttonArray[a].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        buttonArray[b].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        buttonArray[c].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");

        for(int i=0; i<9; i++){
            if(buttonArray[i] != buttonArray[indexA] && buttonArray[i] != buttonArray[indexB] && buttonArray[i] != buttonArray[indexC] ){
                 buttonArray[i].setDisable(true);
            }
        }
        playerTurnText.setText("X Wins");
        setEditsToPlayerTurnText();
        xWinCounter=xWinCounter+1;
        player1ScoreText.setText(Integer.toString(xWinCounter));

    }
    public void oWins(int a, int b, int c){
        
        oWinsVideo();
        
        indexA=a;
        indexB=b;
        indexC=c;
        
        buttonArray[a].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        buttonArray[b].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        buttonArray[c].setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");

        for(int i=0; i<9; i++){
            if(buttonArray[i] != buttonArray[indexA] && buttonArray[i] != buttonArray[indexB] && buttonArray[i] != buttonArray[indexC] ){
                 buttonArray[i].setDisable(true);
            }
        }    

        playerTurnText.setText("O Wins"); 
        setEditsToPlayerTurnText();
        player1Turn=false;
        oWinCounter=oWinCounter+1;
        System.out.println(oWinCounter);
        player2ScoreText.setText(Integer.toString(oWinCounter)); 
        
    }
    public void setEditsToPlayerTurnText(){
                    InnerShadow innerShadow = new InnerShadow();
                    innerShadow.setOffsetX(3.0);
                    innerShadow.setOffsetY(2.0);
                    innerShadow.setColor(Color.WHITE);
                    playerTurnText.setEffect(innerShadow);

                    Reflection reflection = new Reflection();
                    reflection.setFraction(0.7);
                    playerTurnText.setEffect(reflection);


                    TranslateTransition textTranslateTransition = new TranslateTransition(Duration.seconds(1), playerTurnText);
                    textTranslateTransition.setFromY(0);   // Set the starting Y position
                    textTranslateTransition.setToY(50);   // Set the ending Y position
                    textTranslateTransition.setAutoReverse(true);
                    textTranslateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Make it repeat indefinitely
                    textTranslateTransition.play();

                    // Apply 3D transformations
                    PerspectiveCamera camera = new PerspectiveCamera(true);
                    RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), playerTurnText);
                    rotateTransition.setAxis(Rotate.Y_AXIS);
                    rotateTransition.setByAngle(360);
                    rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
                    rotateTransition.play();
    }
    /*
    public void playMusic(){
        
        playMusicButton.setOnAction(event -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            
            if(playMusicFlag==true){
                playMusicButton.setText("Play Music");
                mediaPlayer.stop();
                playMusicFlag=false;
            }else{
                playMusicButton.setText("Stop Music");
                mediaPlayer.play();
                mediaPlayer.setOnEndOfMedia(() -> replayAudio());
                playMusicFlag=true;
            }
        });
    }

    public void playMusicWhenTheGameboardOpen(){
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
        playMusicFlag=true;
    }
    */

    
    
    /*
        private void replayAudio() {
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.play();
    }
    */
    
    /*
    public void playMusicWhenTheGameboardOpen(){
        if(playMusicFlag==true){
            mediaPlayer.play();
            playMusicFlag=false;   
        }else{
            mediaPlayer.stop();
            playMusicFlag=true;
        }
    }
        
    */
      public void xWinsVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/XWinsVideo.mp4";

        // Create a Media object
        Media media = new Media(videoFile);

        // Create a MediaPlayer
        MediaPlayer mediaPlayer3 = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer3);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer3.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer3.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }  
      public void oWinsVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/OWinsVideo.mp4";
                               
        // Create a Media object
        Media media = new Media(videoFile);

        // Create a MediaPlayer
        MediaPlayer mediaPlayer4 = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer4);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer4.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer4.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    } 
      public void DrawPlayVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/DrawVideo2.mp4";
                                
        // Create a Media object
        Media media = new Media(videoFile);

        // Create a MediaPlayer
        MediaPlayer mediaPlayer6 = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer6);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(120.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer6.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer6.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
     }
      
      
       public void mouseClick() {
         String path = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/mouseClick.mp3";  // Use the correct path here
         Media media = new Media(path);
         mediaPlayer2 = new MediaPlayer(media);
         mediaPlayer2.play(); 
       }
      
      public void gameboardMusicWhenTheScreenAppears(){
         String path = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/gameMusic.mp3";  // Use the correct path here
         Media media = new Media(path);
         mediaPlayer = new MediaPlayer(media);
         mediaPlayer.play();
         mediaPlayer.setOnEndOfMedia(()-> {
             mediaPlayer.seek(Duration.ZERO);
             mediaPlayer.play();
         });
      }

       
       
      /*
      
              // Load the sound file
        soundFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/gameMusic.mp3";
        media = new Media(soundFile);
        mediaPlayer = new MediaPlayer(media);
        mediaView = new MediaView(mediaPlayer);
        getChildren().add(mediaView);
        mediaPlayer.setAutoPlay(true);
        playMusicFlag = false;
      
      */
       
    public void manageDrawButtons(){
        if(button0Flag==false && 
           button1Flag==false &&
           button2Flag==false &&
           button3Flag==false && 
           button4Flag==false &&
           button5Flag==false &&
           button6Flag==false && 
           button7Flag==false &&
           button8Flag==false)
        {
            button0Flag=true;
            button1Flag=true;
            button2Flag=true;
            button3Flag=true;
            button4Flag=true;
            button5Flag=true;
            button6Flag=true;
            button7Flag=true;
            button8Flag=true;
        }
    }
       
    public void allPlayingButtonsFalse(){

            button0Flag=false;
            button1Flag=false;
            button2Flag=false;
            button3Flag=false;
            button4Flag=false;
            button5Flag=false;
            button6Flag=false;
            button7Flag=false;
            button8Flag=false;

    }    
     
      
      
}

