package computer22;

import SelectmodeView.SelectModeBase;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Computerplay extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane boardGrid;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button but00;
    protected final Button but01;
    protected final Button but02;
    protected final Button but10;
    protected final Button but11;
    protected final Button but12;
    protected final Button but20;
    protected final Button but21;
    protected final Button but22;
    protected final GridPane scoreGrid;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints2;
    protected final BorderPane score1Pane;
    protected final Text text;
    protected  Text score1CountText;
    protected final BorderPane drawPane;
    protected  Text drawCountText;
    protected final Text text0;
    protected final BorderPane score2Pane;
    protected  Text score2CountText;
    protected final Text text1;
    protected final Button newButton;
    protected final Button exitButton;
    String Human;
    String Ai;
    boolean Playerturn ;
     boolean computerturn ;
    String [] board;
    Button []buttons;
    int count=0;
    int [] win;
     boolean playwin=false;
      boolean comwin=false;
        boolean gameover=false;
        
        boolean over=false; 
       int playerScore=0;
       int computerscore=0;
      int drawScore=0;
      boolean chhooseX=false;
      boolean chhooseO=false; 
      
    
    public Computerplay(Stage stage,String choose) {
        if(choose=="X"){
            Human="X";
            Ai="O";
            Playerturn=true;
            computerturn=false;
            chhooseX=true;
        }else {
            Human="O";
            Ai="X";
            Playerturn=false;
             computerturn=true;
             
             
             chhooseO=true;
        }
        
            
        
        
        
        
        
      board = new String[] {" ", " ", " ", " ", " ", " ", " ", " ", " "};
        win=new int [] {0,0,0};
        imageView = new ImageView();
        boardGrid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        but00 = new Button();
        but01 = new Button();
        but02 = new Button();
        but10 = new Button();
        but11 = new Button();
        but12 = new Button();
        but20 = new Button();
        but21 = new Button();
        but22 = new Button();
        buttons = new Button[] {but00, but01, but02, but10, but11, but12, but20, but21, but22};
        scoreGrid = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        score1Pane = new BorderPane();
        text = new Text();
        score1CountText = new Text();
        drawPane = new BorderPane();
        drawCountText = new Text();
        text0 = new Text();
        score2Pane = new BorderPane();
        score2CountText = new Text();
        text1 = new Text();
        newButton = new Button();
        exitButton = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        imageView.setFitHeight(700.0);
        imageView.setFitWidth(1000.0);
        imageView.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

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

        but00.setMnemonicParsing(false);
        but00.setPrefHeight(130.0);
        but00.setPrefWidth(211.0);
        but00.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
        eventClick(0);
        GridPane.setColumnIndex(but01, 1);
        but01.setMnemonicParsing(false);
        but01.setPrefHeight(200.0);
        but01.setPrefWidth(255.0);
        but01.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(1);
        GridPane.setColumnIndex(but02, 2);
        but02.setMnemonicParsing(false);
        but02.setPrefHeight(144.0);
        but02.setPrefWidth(215.0);
        but02.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(2);
        GridPane.setRowIndex(but10, 1);
        but10.setMnemonicParsing(false);
        but10.setPrefHeight(123.0);
        but10.setPrefWidth(212.0);
        but10.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(3);
        GridPane.setColumnIndex(but11, 1);
        GridPane.setRowIndex(but11, 1);
        but11.setMnemonicParsing(false);
        but11.setPrefHeight(139.0);
        but11.setPrefWidth(260.0);
        but11.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
        eventClick(4);

        GridPane.setColumnIndex(but12, 2);
        GridPane.setRowIndex(but12, 1);
        but12.setMnemonicParsing(false);
        but12.setPrefHeight(139.0);
        but12.setPrefWidth(242.0);
        but12.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(5);
        GridPane.setRowIndex(but20, 2);
        but20.setMnemonicParsing(false);
        but20.setPrefHeight(127.0);
        but20.setPrefWidth(234.0);
        but20.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(6);
        GridPane.setColumnIndex(but21, 1);
        GridPane.setRowIndex(but21, 2);
        but21.setMnemonicParsing(false);
        but21.setPrefHeight(196.0);
        but21.setPrefWidth(192.0);
        but21.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(7);
        GridPane.setColumnIndex(but22, 2);
        GridPane.setRowIndex(but22, 2);
        but22.setMnemonicParsing(false);
        but22.setPrefHeight(161.0);
        but22.setPrefWidth(220.0);
        but22.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
         eventClick(8);
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
        score1Pane.setStyle("-fx-background-radius: 15; -fx-background-color: #48D2FE;");

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Player 1");
        text.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text, new Insets(5.0, 0.0, 0.0, 0.0));
        score1Pane.setTop(text);

        BorderPane.setAlignment(score1CountText, javafx.geometry.Pos.CENTER);
        score1CountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score1CountText.setStrokeWidth(0.0);
        score1CountText.setText("0");
        score1CountText.setFont(new Font("Arial Bold", 36.0));
        score1Pane.setCenter(score1CountText);

        GridPane.setColumnIndex(drawPane, 1);
        drawPane.setPrefHeight(200.0);
        drawPane.setPrefWidth(200.0);
        drawPane.setStyle("-fx-background-radius: 15; -fx-background-color: BCDBF9;");

        BorderPane.setAlignment(drawCountText, javafx.geometry.Pos.CENTER);
        drawCountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawCountText.setStrokeWidth(0.0);
        drawCountText.setText("0");
        drawCountText.setFont(new Font("Arial Bold", 36.0));
        drawPane.setCenter(drawCountText);

        BorderPane.setAlignment(text0, javafx.geometry.Pos.CENTER);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Draw");
        text0.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text0, new Insets(5.0, 0.0, 0.0, 0.0));
        drawPane.setTop(text0);

        GridPane.setColumnIndex(score2Pane, 2);
        score2Pane.setPrefHeight(88.0);
        score2Pane.setPrefWidth(142.0);
        score2Pane.setStyle("-fx-background-radius: 15; -fx-background-color: #3E4D8C;");

        BorderPane.setAlignment(score2CountText, javafx.geometry.Pos.CENTER);
        score2CountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score2CountText.setStrokeWidth(0.0);
        score2CountText.setText("0");
        score2CountText.setFont(new Font("Arial Bold", 36.0));
        score2Pane.setCenter(score2CountText);

        
        BorderPane.setAlignment(text1, javafx.geometry.Pos.CENTER);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Computer");
        text1.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text1, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(text1);

        newButton.setLayoutX(352.0);
        newButton.setLayoutY(552.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(60.0);
        newButton.setPrefWidth(130.0);
        newButton.setStyle("-fx-background-radius: 15; -fx-background-color: C5A0D7;");
        newButton.setText("Restart");
        newButton.setFont(new Font("Arial Bold", 14.0));
        newButton.setOpaqueInsets(new Insets(0.0));
       newButton.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                for(int i=0;i<9;i++){
                    buttons[i].setText(" ");
                    board[i]=" ";
                    buttons[i].setDisable(false);
                    buttons[i].setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
                     gameover = false;
                   if(choose=="X"){
                      Human="X";
                      Ai="O";
                      Playerturn=true;
                      computerturn=false;
                      
                  }else if(computerturn==true){
                      Human="O";
                      Ai="X";
                        computerMove();
                       Playerturn=true;
                       computerturn=false;

                       
                  }
                    
                    
                }
            }
        });

       if(choose=="O"){
            computerMove();
            Playerturn=true;
        }

        exitButton.setLayoutX(528.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(130.0);
        exitButton.setStyle("-fx-background-radius: 15; -fx-background-color: C5A0D7;");
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial Bold", 14.0));
        exitButton.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                   Parent root = new  SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });
        
        getChildren().add(imageView);
        boardGrid.getColumnConstraints().add(columnConstraints);
        boardGrid.getColumnConstraints().add(columnConstraints0);
        boardGrid.getColumnConstraints().add(columnConstraints1);
        boardGrid.getRowConstraints().add(rowConstraints);
        boardGrid.getRowConstraints().add(rowConstraints0);
        boardGrid.getRowConstraints().add(rowConstraints1);
        boardGrid.getChildren().add(but00);
        boardGrid.getChildren().add(but01);
        boardGrid.getChildren().add(but02);
        boardGrid.getChildren().add(but10);
        boardGrid.getChildren().add(but11);
        boardGrid.getChildren().add(but12);
        boardGrid.getChildren().add(but20);
        boardGrid.getChildren().add(but21);
        boardGrid.getChildren().add(but22);
        getChildren().add(boardGrid);
        scoreGrid.getColumnConstraints().add(columnConstraints2);
        scoreGrid.getColumnConstraints().add(columnConstraints3);
        scoreGrid.getColumnConstraints().add(columnConstraints4);
        scoreGrid.getRowConstraints().add(rowConstraints2);
        scoreGrid.getChildren().add(score1Pane);
        scoreGrid.getChildren().add(drawPane);
        scoreGrid.getChildren().add(score2Pane);
        getChildren().add(scoreGrid);
        getChildren().add(newButton);
        getChildren().add(exitButton);

    }
    
    
public void eventClick(int index) {
    buttons[index].setOnAction(event -> {
        if (Playerturn&&  gameover==false) {
            if (board[index].equals(" ")) {
                buttons[index].setText(Human);
                board[index] = Human;
                 checkWinner();
                Playerturn = false;
                computerturn = true;
                
                // Run computerMove in a new thread
                if(gameover==false){
                new Thread(() -> {
                    computerMove();
                   //  checkWinner();
                  
                    // You may want to use Platform.runLater to update the UI if needed
                    Playerturn = true;
                }).start();
            }}
        }
    });
}

  
   public void computerMove() {
    Random random = new Random();
    int buttonIndex;
    boolean flag = true;

    while (flag) {
        buttonIndex = random.nextInt(9);
        if (board[buttonIndex].equals(" ")) {
            flag = false;
            final int finalButtonIndex = buttonIndex;

            // Use Platform.runLater to update UI components
            Platform.runLater(() -> {
                board[finalButtonIndex] = Ai;
                buttons[finalButtonIndex].setText(Ai); 
                checkWinner();
                
            });
        }
    }
}

       public void playerWin(int index1, int index2, int index3) {
        buttons[index1].setStyle("-fx-background-color: #5A1E76;");
        buttons[index2].setStyle("-fx-background-color: #5A1E76;");
        buttons[index3].setStyle("-fx-background-color: #5A1E76;");
      //  WinsVideo;
        if(chhooseX==true){
            xWinsVideo();
        }else{
            oWinsVideo();
        }
     

    }

public void computerWin(int index1, int index2, int index3) {
        buttons[index1].setStyle("-fx-background-color: #5A1E76;");
        buttons[index2].setStyle("-fx-background-color: #5A1E76;");
        buttons[index3].setStyle("-fx-background-color: #5A1E76;");
      // oWinsVideo();
      losePlayVideo();
    
    }
   
   
   
   
   
   ///////////////////chech winner
   public void checkWinner() {
        
        if (board[0].equals(Human)
                && board[1].equals(Human)
                && board[2].equals(Human)) {
            playerWin(0, 1, 2);
            playerScore();
            setDisableBtn();
            gameover=true;

        }
        else if (board[3].equals(Human)
                &&board[4].equals(Human)
                && board[5].equals(Human)) {
            playerWin(3, 4, 5);
               playerScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[6].equals(Human)
                &&board[7].equals(Human)
                && board[8].equals(Human)) {
            playerWin(6, 7, 8);
             playerScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[0].equals(Human)
                &&board[3].equals(Human)
                && board[6].equals(Human)) {
            playerWin(0, 3, 6);
             playerScore();
            setDisableBtn();
              gameover=true;
        }
        if (board[1].equals(Human)
                &&board[4].equals(Human)
                && board[7].equals(Human)) {
            playerWin(1, 4, 7);
             playerScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[2].equals(Human)
                &&board[5].equals(Human)
                && board[8].equals(Human)) {
            playerWin(2, 5, 8);
             playerScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[0].equals(Human)
                &&board[4].equals(Human)
                && board[8].equals(Human)) {
           playerWin(0, 4, 8);
            playerScore();
           setDisableBtn();
              gameover=true;
        }
        else if (board[2].equals(Human)
                &&board[4].equals(Human)
                && board[6].equals(Human)) {
            playerWin(2, 4, 6);
             playerScore();
            setDisableBtn();
              gameover=true;
        } 


//check if O wins//
        
        else if (board[0].equals(Ai)
                &&board[1].equals(Ai)
                && board[2].equals(Ai)) {
            computerWin(0, 1, 2);
            computerOScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[3].equals(Ai)
                &&board[4].equals(Ai)
                && board[5].equals(Ai)) {
            computerWin(3, 4, 5);
             computerOScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[6].equals(Ai)
                &&board[7].equals(Ai)
                && board[8].equals(Ai)) {
                computerWin(6, 7, 8);
                 computerOScore();
                setDisableBtn();
              gameover=true;
        }
        else if (board[0].equals(Ai)
                &&board[3].equals(Ai)
                && board[6].equals(Ai)) {
                 computerWin(0, 3, 6);
                computerOScore();
                 setDisableBtn();
              gameover=true;
        }
        else if (board[1].equals(Ai)
                &&board[4].equals(Ai)
                && board[7].equals(Ai)) {
                computerWin(1, 4, 7);
                 computerOScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[2].equals(Ai)
                &&board[5].equals(Ai)
                && board[8].equals(Ai)) {
                computerWin(2, 5, 8);
  
                 computerOScore();
            setDisableBtn();
              gameover=true;
        }
        else if (board[0].equals(Ai)
                &&board[4].equals(Ai)
                && board[8].equals(Ai)) {
                computerWin(0, 4, 8);
                 computerOScore();
                setDisableBtn();
              gameover=true;
        }
        else if (board[2].equals(Ai)
                &&board[4].equals(Ai)
                && board[6].equals(Ai)) {
                computerWin(2, 4, 6);
                 computerOScore();
                setDisableBtn();
              gameover=true;
        }
        else{
        boolean isBoardFull = true;
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(" ")) {
                isBoardFull = false;
                break;
            }
        }
        if (isBoardFull&&comwin==false&&playwin==false) {
              gameover=true;
            setDisableBtn();
            drawOScore();
            DrawPlayVideo();
  
            
        }
     } 
        

    }

 
 public void setDisableBtn() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setDisable(true);

        }     
    }
 
   public void playerScore(){
         
                playerScore++;
                score1CountText.setText(String.valueOf(playerScore));
                
            }
            
        
      

        public void computerOScore(){
            
                computerscore++;
                score2CountText.setText(String.valueOf(computerscore));
           
            }
        
         public void drawOScore(){
            
                drawScore++;
                 drawCountText.setText(String.valueOf(drawScore));
           
            }
        
        
    public void xWinsVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/XWinsVideo.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource("/assets/videos/XWinsVideo.mp4").toExternalForm());

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
        //      getChildren().remove(mediaView);
            System.out.println("Video finished");
           mediaView.setVisible(false);
        });
    }

   public void oWinsVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/OWinsVideo.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource("/assets/videos/OWinsVideo.mp4").toExternalForm());

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

        mediaPlayer4.setOnEndOfMedia(() -> {
         //     getChildren().remove(mediaView);
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }
   

public void DrawPlayVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/DrawVideo2.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource("/assets/videos/DrawVideo2.mp4").toExternalForm());

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
           //   getChildren().remove(mediaView);
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }   
    
public void losePlayVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/LoseVideo.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource("/assets/videos/LoseVideo.mp4").toExternalForm());

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
           //   getChildren().remove(mediaView);
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }   
  
    
  
}
