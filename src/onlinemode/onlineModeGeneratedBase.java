package onlinemode;

import Requests.App;
import Requests.Message;
import SelectmodeView.SelectModeBase;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import static onlinemode.onlineModeGeneratedBaseNew.myTurn;

public class onlineModeGeneratedBase extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button topLeftBtn;
    protected final Button topBtn;
    protected final Button topRightBtn;
    protected final Button centerLeftBtn;
    protected final Button centerBtn;
    protected final Button centerRightBtn;
    protected final Button downLeftBtn;
    protected final Button downBtn;
    protected final Button downRightBtn;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final RowConstraints rowConstraints2;
    protected final BorderPane borderPane;
    protected final Text player1Txt;
    protected  Text player1ScoreTxt;
    protected final BorderPane borderPane0;
    protected final Text drawTxt;
    protected  Text drawScoreTxt;
    protected final BorderPane borderPane1;
    protected final Text player2Txt;
    protected  Text player2ScoreTxt;
    protected final Button newGameBtn;
    protected final Button menueBtn;
    protected final Text player1Label;
    protected final Text player2Label;
     Random random = new Random();
         public int[][] board;
    public static boolean myTurn = false;
    //private ArrayList<Move>moveList=new ArrayList<>();
    private Timer timer;
    Gson gson = new Gson();
    public String opponentEmail;
    public String PlayerEmail;
    public String player1, player2;
    public Button[] buttonArr = new Button[9];
    public int player1Score,player2Score,drawScore;
    
    public onlineModeGeneratedBase(Stage stage,String MyEmail,String opponentMail) {
        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        topLeftBtn = new Button();
        topLeftBtn.setUserData(0);
        topBtn = new Button();
        topBtn.setUserData(1);
        topRightBtn = new Button();
        topRightBtn.setUserData(2);
        centerLeftBtn = new Button();
        centerLeftBtn.setUserData(3);
        centerBtn = new Button();
        centerBtn.setUserData(4);
        centerRightBtn = new Button();
        centerRightBtn.setUserData(5);
        downLeftBtn = new Button();
        downLeftBtn.setUserData(6);
        downBtn = new Button();
        downBtn.setUserData(7);
        downRightBtn = new Button();
        downRightBtn.setUserData(8);
        gridPane0 = new GridPane();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        borderPane = new BorderPane();
        player1Txt = new Text();
        player1ScoreTxt = new Text();
        borderPane0 = new BorderPane();
        drawTxt = new Text();
        drawScoreTxt = new Text();
        borderPane1 = new BorderPane();
        player2Txt = new Text();
        player2ScoreTxt = new Text();
        newGameBtn = new Button();
        menueBtn = new Button();
        player1Label = new Text();
        player2Label = new Text();
         timer = new Timer();
        board = new int[][]{{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        buttonArr[0] = topLeftBtn;
        buttonArr[1] = topBtn;
        buttonArr[2] = topRightBtn;
        buttonArr[3] = centerLeftBtn;
        buttonArr[4] = centerBtn;
        buttonArr[5] = centerRightBtn;
        buttonArr[6] = downLeftBtn;
        buttonArr[7] = downBtn;
        buttonArr[8] = downRightBtn;
        
        PlayerEmail=MyEmail;
        opponentEmail=opponentMail;
        System.out.println("MyEmail"+MyEmail);
        System.out.println("opponentMail"+opponentMail);
        player1Score=0;
        player2Score=0;
        drawScore=0;

        
          firstTurn();
        App.startConnection();
        new Thread(() -> {
            while (App.server.isConnected()) {
                try {
                    String jsonResponse = App.input.readLine();
                    System.out.println(jsonResponse);
                    Message response = App.gson.fromJson(jsonResponse, Message.class);
                    String playerSide = response.getXO();
                    int location = response.getLocation();
                    if (response.getType().equals("retriveMove")) {
                        switch (location) {
                            case 1:
                            topLeftBtn.setText(playerSide); 
                            break;
                            case 2:
                            topBtn.setText(playerSide); 
                            break; 
                             case 3:
                            topRightBtn.setText(playerSide); 
                            break;
                             case 4:
                            centerLeftBtn.setText(playerSide); 
                            break;
                            case 5:
                            centerBtn.setText(playerSide); 
                            break;
                            case 6:
                            centerRightBtn.setText(playerSide); 
                            break;
                            case 7:
                            downLeftBtn.setText(playerSide); 
                            break;
                            case 8:
                            downBtn.setText(playerSide); 
                            break;
                            case 9:
                            downRightBtn.setText(playerSide); 
                            break;
                        }
                         myTurn=true;
                        checkWinner();                
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }).start(); 
        
        
        setId("AnchorPane");
        setPrefHeight(672.0);
        setPrefWidth(944.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/onlinemode/onlinemode.css");

        imageView.setFitHeight(672.0);
        imageView.setFitWidth(992.0);
        imageView.setImage(new Image(getClass().getResource("BackgroundImage.png").toExternalForm()));

        gridPane.setLayoutX(246.0);
        gridPane.setLayoutY(191.0);
        gridPane.setPrefHeight(334.0);
        gridPane.setPrefWidth(545.0);

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

        topLeftBtn.setMnemonicParsing(false);
        topLeftBtn.setPrefHeight(102.0);
        topLeftBtn.setPrefWidth(178.0);
        topLeftBtn.setFont(new Font(50));
        topLeftBtn.setStyle("-fx-text-stroke: white;");
        topLeftBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[0][0] == -1 && myTurn) {
                    board[0][0] = 0;
                    myTurn = false;
                    topLeftBtn.setText(player1);
                    sendMove(1, player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();

                }
                if (board[0][0] == -1 && myTurn == false) {
                    board[0][0] = 0;
                    myTurn = true;
                    sendMove(1, player2);
                    topLeftBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();

                }
            }
        });



        GridPane.setColumnIndex(topBtn, 1);
        topBtn.setMnemonicParsing(false);
        topBtn.setPrefHeight(102.0);
        topBtn.setPrefWidth(178.0);
        topBtn.setFont(new Font(50));
        topBtn.setStyle("-fx-text-stroke: white;");
         topBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[0][1] == -1 && myTurn) {
                    board[0][1] = 0;
                    myTurn = false;
                    sendMove(2, player1);
                    topBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[0][1] == -1 && myTurn == false) {
                    board[0][1] = 0;
                    myTurn = true;
                    sendMove(2, player2);
                    topBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }

            }
        });

        

        GridPane.setColumnIndex(topRightBtn, 2);
        topRightBtn.setMnemonicParsing(false);
        topRightBtn.setPrefHeight(102.0);
        topRightBtn.setPrefWidth(178.0);
        topRightBtn.setFont(new Font(50));
        topRightBtn.setStyle("-fx-text-stroke: white;");
         topRightBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[0][2] == -1 && myTurn) {
                    board[0][2] = 0;
                    myTurn = false;
                    sendMove(3, player1);
                    topRightBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[0][2] == -1 && myTurn == false) {
                    board[0][2] = 0;
                    myTurn = true;
                    sendMove(3, player2);
                    topRightBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        });


        GridPane.setRowIndex(centerLeftBtn, 1);
        centerLeftBtn.setMnemonicParsing(false);
        centerLeftBtn.setPrefHeight(102.0);
        centerLeftBtn.setPrefWidth(178.0);
        centerLeftBtn.setFont(new Font(50));
        centerLeftBtn.setStyle("-fx-text-stroke: white;");
        centerLeftBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[1][0] == -1 && myTurn) {
                    board[1][0] = 0;
                    myTurn = false;
                    sendMove(4, player1);
                    centerLeftBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();

                }
                if (board[1][0] == -1 && myTurn == false) {
                    board[1][0] = 0;
                    myTurn = true;
                    sendMove(4, player2);
                    centerLeftBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        }); 


        GridPane.setColumnIndex(centerBtn, 1);
        GridPane.setRowIndex(centerBtn, 1);
        centerBtn.setMnemonicParsing(false);
        centerBtn.setPrefHeight(102.0);
        centerBtn.setPrefWidth(178.0);
        centerBtn.setFont(new Font(50));
        centerBtn.setStyle("-fx-text-stroke: white;");
        centerBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[1][1] == -1 && myTurn) {
                    board[1][1] = 0;
                    myTurn = false;
                    sendMove(5, player1);
                    centerBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();

                }
                if (board[1][1] == -1 && myTurn == false) {
                    board[1][1] = 0;
                    myTurn = true;
                    sendMove(5, player2);
                    centerBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        });
 
        

        GridPane.setColumnIndex(centerRightBtn, 2);
        GridPane.setRowIndex(centerRightBtn, 1);
        centerRightBtn.setMnemonicParsing(false);
        centerRightBtn.setPrefHeight(102.0);
        centerRightBtn.setPrefWidth(178.0);
        centerRightBtn.setFont(new Font(50));
        centerRightBtn.setStyle("-fx-text-stroke: white;");
          centerRightBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[1][2] == -1 && myTurn) {
                    board[1][2] = 0;
                    myTurn = false;
                    sendMove(6, player1);
                    centerRightBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[1][2] == -1 && myTurn == false) {
                    board[1][2] = 0;
                    myTurn = true;
                    sendMove(6, player2);
                    centerRightBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        });
          

        GridPane.setRowIndex(downLeftBtn, 2);
        downLeftBtn.setMnemonicParsing(false);
        downLeftBtn.setPrefHeight(102.0);
        downLeftBtn.setPrefWidth(178.0);
        downLeftBtn.setFont(new Font(50));
        downLeftBtn.setStyle("-fx-text-stroke: white;");
        downLeftBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[2][0] == -1 && myTurn) {
                    board[2][0] = 0;
                    myTurn = false;
                    sendMove(7, player1);
                    downLeftBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[2][0] == -1 && myTurn == false) {
                    board[2][0] = 0;
                    myTurn = true;
                    sendMove(7, player2);
                    downLeftBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        });

        
        
        
        GridPane.setColumnIndex(downBtn, 1);
        GridPane.setRowIndex(downBtn, 2);
        downBtn.setMnemonicParsing(false);
        downBtn.setPrefHeight(102.0);
        downBtn.setPrefWidth(178.0);
        downBtn.setFont(new Font(50));
        downBtn.setStyle("-fx-text-stroke: white;");
        downBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[2][1] == -1 && myTurn) {
                    board[2][1] = 0;
                    myTurn = false;
                    sendMove(8, player1);
                    downBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[2][1] == -1 && myTurn == false) {
                    board[2][1] = 0;
                    myTurn = true;
                    sendMove(8, player2);
                    downBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        }); 
         
         

        GridPane.setColumnIndex(downRightBtn, 2);
        GridPane.setRowIndex(downRightBtn, 2);
        downRightBtn.setMnemonicParsing(false);
        downRightBtn.setPrefHeight(102.0);
        downRightBtn.setPrefWidth(178.0);
        downRightBtn.setFont(new Font(50));
        downRightBtn.setStyle("-fx-text-stroke: white;");
        downRightBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (board[2][2] == -1 && myTurn) {
                    board[2][2] = 0;
                    myTurn = false;
                    sendMove(9, player1);
                    downLeftBtn.setText(player1);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                }
                if (board[2][2] == -1 && myTurn == false) {
                    board[2][2] = 0;
                    myTurn = true;
                    sendMove(9, player2);
                    downLeftBtn.setText(player2);
                    player1Label.setText(PlayerEmail + " Turn");
                    player2Label.setText(opponentEmail);
                    checkWinner();
                }
            }
        }); 

        gridPane0.setLayoutX(301.0);
        gridPane0.setLayoutY(57.0);
        gridPane0.setPrefHeight(111.0);
        gridPane0.setPrefWidth(404.0);
        gridPane0.setHgap(10.0);

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

        borderPane.setPrefHeight(111.0);
        borderPane.setPrefWidth(117.0);
        borderPane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(player1Txt, javafx.geometry.Pos.CENTER);
        player1Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Txt.setStrokeWidth(0.0);
        player1Txt.setText("Player 1");
        player1Txt.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player1Txt, new Insets(5.0, 0.0, 0.0, 0.0));
        borderPane.setTop(player1Txt);

        BorderPane.setAlignment(player1ScoreTxt, javafx.geometry.Pos.CENTER);
        player1ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1ScoreTxt.setStrokeWidth(0.0);
        player1ScoreTxt.setText("0");
        player1ScoreTxt.setFont(new Font("Arial Bold", 36.0));
        borderPane.setCenter(player1ScoreTxt);

        GridPane.setColumnIndex(borderPane0, 1);
        borderPane0.setPrefHeight(111.0);
        borderPane0.setPrefWidth(119.0);
        borderPane0.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(drawTxt, javafx.geometry.Pos.CENTER);
        drawTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawTxt.setStrokeWidth(0.0);
        drawTxt.setText("Draw");
        drawTxt.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(drawTxt, new Insets(5.0, 0.0, 0.0, 0.0));
        borderPane0.setTop(drawTxt);

        BorderPane.setAlignment(drawScoreTxt, javafx.geometry.Pos.CENTER);
        drawScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawScoreTxt.setStrokeWidth(0.0);
        drawScoreTxt.setText("0");
        drawScoreTxt.setFont(new Font("Arial Bold", 36.0));
        borderPane0.setCenter(drawScoreTxt);

        GridPane.setColumnIndex(borderPane1, 2);
        borderPane1.setPrefHeight(111.0);
        borderPane1.setPrefWidth(119.0);
        borderPane1.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(player2Txt, javafx.geometry.Pos.CENTER);
        player2Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Txt.setStrokeWidth(0.0);
        player2Txt.setText("Player 2");
        player2Txt.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player2Txt, new Insets(5.0, 0.0, 0.0, 0.0));
        borderPane1.setTop(player2Txt);

        BorderPane.setAlignment(player2ScoreTxt, javafx.geometry.Pos.CENTER);
        player2ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2ScoreTxt.setStrokeWidth(0.0);
        player2ScoreTxt.setText("0");
        player2ScoreTxt.setFont(new Font("Arial Bold", 36.0));
        borderPane1.setCenter(player2ScoreTxt);

        newGameBtn.setLayoutX(320.0);
        newGameBtn.setLayoutY(560.0);
        newGameBtn.setMnemonicParsing(false);
        newGameBtn.setPrefHeight(48.0);
        newGameBtn.setPrefWidth(200.0);
        newGameBtn.setText("New Game");
        newGameBtn.setStyle("-fx-background-radius: 15;");
        newGameBtn.setText("New Game");
        newGameBtn.setFont(new Font("Arial Bold", 27.0));
        newGameBtn.setOpaqueInsets(new Insets(0.0));
        newGameBtn.setStyle("-fx-background-color: #68CFD1 ;");
        newGameBtn.setOnMouseEntered(event -> {
            newGameBtn.setStyle("-fx-background-color: #00CBFE;");
        });
        newGameBtn.setOnMouseExited(event -> {
            newGameBtn.setStyle("-fx-background-color: #68CFD1 ;");
        });
        newGameBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                for(int i=0;i<9;i++){
                    buttonArr[i].setText("");
                    buttonArr[i].setDisable(false);
                    buttonArr[i].setStyle("-fx-background-color: #d7049e;");
                    firstTurn();
                }
            }
        });


        menueBtn.setLayoutX(572.0);
        menueBtn.setLayoutY(560.0);
        menueBtn.setMnemonicParsing(false);
        menueBtn.setPrefHeight(48.0);
        menueBtn.setPrefWidth(200.0);
        menueBtn.setStyle("-fx-background-radius: 15;");
        menueBtn.setText("Main Menu");
        menueBtn.setFont(new Font("Arial Bold", 27.0));
        menueBtn.setStyle("-fx-background-color: #68CFD1 ;");
        menueBtn.setOnMouseEntered(event -> {
        menueBtn.setStyle("-fx-background-color: #00CBFE;");
        });
        menueBtn.setOnMouseExited(event -> {
        menueBtn.setStyle("-fx-background-color: #68CFD1 ;");
        });
        menueBtn.setText("Main Menue");
        menueBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                   Parent root = new  SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });
        
        
        

        player1Label.setLayoutX(45.0);
        player1Label.setLayoutY(350.0);
        player1Label.setText("Player1");
        player1Label.setFont(new Font(35.0));
        player1Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Label.setFill(Color.WHITE); // setting color of the text to blue
        player1Label.setStroke(Color.BLACK); // setting the stroke for the text
        player1Label.setStrokeWidth(1); 
        player1Label.setStrokeWidth(2.0);
        

        player2Label.setLayoutX(795.0);
        player2Label.setLayoutY(350.0);
        player2Label.setText("Player 2");
        player2Label.setFont(new Font(35.0));
        player2Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Label.setFill(Color.WHITE);
        player2Label.setStroke(Color.BLACK);
        player2Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Label.setStrokeWidth(2.0);
        

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(topLeftBtn);
        gridPane.getChildren().add(topBtn);
        gridPane.getChildren().add(topRightBtn);
        gridPane.getChildren().add(centerLeftBtn);
        gridPane.getChildren().add(centerBtn);
        gridPane.getChildren().add(centerRightBtn);
        gridPane.getChildren().add(downLeftBtn);
        gridPane.getChildren().add(downBtn);
        gridPane.getChildren().add(downRightBtn);
        getChildren().add(gridPane);
        gridPane0.getColumnConstraints().add(columnConstraints2);
        gridPane0.getColumnConstraints().add(columnConstraints3);
        gridPane0.getColumnConstraints().add(columnConstraints4);
        gridPane0.getRowConstraints().add(rowConstraints2);
        gridPane0.getChildren().add(borderPane);
        gridPane0.getChildren().add(borderPane0);
        gridPane0.getChildren().add(borderPane1);
        getChildren().add(gridPane0);
        getChildren().add(newGameBtn);
        getChildren().add(menueBtn);
        getChildren().add(player1Label);
        getChildren().add(player2Label);
        topLeftBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topRightBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        centerLeftBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        centerBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        centerRightBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        downLeftBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        downBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        downRightBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
 
 
    }
     public void firstTurn() {
        //zero or one//
        if (random.nextInt(2) == 0) {
            myTurn = true;
            player1 = "X";
            player2 = "O";
            player1Label.setText(PlayerEmail + " Turn");
            player2Label.setText(opponentEmail);

        } else {
            myTurn = false;
            player2 = "X";
            player1 = "O";
            player2Label.setText(opponentEmail + " Turn");
            player1Label.setText(PlayerEmail);
        }

    }

    public void sendMove(int location, String player) {
        App.startConnection();
        Message msg = new Message();
        msg.setType("sendMove");
        msg.setOpponentEmail(opponentEmail);
        msg.setLocation(location);
        msg.setXO(player);
        String request = gson.toJson(msg);
        App.output.println(request);
        App.output.flush();
    }

 
    public void xWins(int index1, int index2, int index3) {
        buttonArr[index1].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index2].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index3].setStyle("-fx-background-color: #5A1E76;");
        xWinsVideo();
        player1Label.setText("Player1 ");
        player2Label.setText("Player2");
        
    }

public void oWins(int index1, int index2, int index3) {
        buttonArr[index1].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index2].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index3].setStyle("-fx-background-color: #5A1E76;");
        oWinsVideo();
        player1Label.setText("Player1 ");
        player2Label.setText("Player2");

    }

    public void checkWinner() {
        
        if (buttonArr[0].getText() == "X"
                && buttonArr[1].getText() == "X"
                && buttonArr[2].getText() == "X") {
            xWins(0, 1, 2);
            playerXScore();
            setDisableBtn();

        }
        else if (buttonArr[3].getText() == "X"
                && buttonArr[4].getText() == "X"
                && buttonArr[5].getText() == "X") {
            xWins(3, 4, 5);
            playerXScore();
            setDisableBtn();
        }
        else if (buttonArr[6].getText() == "X"
                && buttonArr[7].getText() == "X"
                && buttonArr[8].getText() == "X") {
            xWins(6, 7, 8);
            playerXScore();
            setDisableBtn();
        }
        else if (buttonArr[0].getText() == "X"
                && buttonArr[3].getText() == "X"
                && buttonArr[6].getText() == "X") {
            xWins(0, 3, 6);
            playerXScore();
            setDisableBtn();
        }
        if (buttonArr[1].getText() == "X"
                && buttonArr[4].getText() == "X"
                && buttonArr[7].getText() == "X") {
            xWins(1, 4, 7);
             playerXScore();
            setDisableBtn();
        }
        else if (buttonArr[2].getText() == "X"
                && buttonArr[5].getText() == "X"
                && buttonArr[8].getText() == "X") {
            xWins(2, 5, 8);
             playerXScore();
            setDisableBtn();
        }
        else if (buttonArr[0].getText() == "X"
                && buttonArr[4].getText() == "X"
                && buttonArr[8].getText() == "X") {
            xWins(0, 4, 8);
             playerXScore();
            setDisableBtn();
        }
        else if (buttonArr[2].getText() == "X"
                && buttonArr[4].getText() == "X"
                && buttonArr[6].getText() == "X") {
            xWins(2, 4, 6);
             playerXScore();
            setDisableBtn();
        } //check if O wins//
        
        else if (buttonArr[0].getText() == "O"
                && buttonArr[1].getText() == "O"
                && buttonArr[2].getText() == "O") {
            oWins(0, 1, 2);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[3].getText() == "O"
                && buttonArr[4].getText() == "O"
                && buttonArr[5].getText() == "O") {
            oWins(3, 4, 5);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[6].getText() == "O"
                && buttonArr[7].getText() == "O"
                && buttonArr[8].getText() == "O") {
            oWins(6, 7, 8);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[0].getText() == "O"
                && buttonArr[3].getText() == "O"
                && buttonArr[6].getText() == "O") {
            oWins(0, 3, 6);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[1].getText() == "O"
                && buttonArr[4].getText() == "O"
                && buttonArr[7].getText() == "O") {
            oWins(1, 4, 7);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[2].getText() == "O"
                && buttonArr[5].getText() == "O"
                && buttonArr[8].getText() == "O") {
            oWins(2, 5, 8);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[0].getText() == "O"
                && buttonArr[4].getText() == "O"
                && buttonArr[8].getText() == "O") {
            oWins(0, 4, 8);
             playerOScore();
            setDisableBtn();
        }
        else if (buttonArr[2].getText() == "O"
                && buttonArr[4].getText() == "O"
                && buttonArr[6].getText() == "O") {
            oWins(2, 4, 6);
             playerOScore();
            setDisableBtn();
        }
        else{
        boolean isBoardFull = true;
        for (int i = 0; i < 9; i++) {
            if (buttonArr[i].getText().isEmpty()) {
                isBoardFull = false;
                break;
            }
        }
        if (isBoardFull) {
           DrawPlayVideo();
            setDisableBtn();
            drawScore++;
             drawScoreTxt.setText(String.valueOf(drawScore)); 
            
        }
     }
        
    }    
    
    
      public void playerXScore(){
            if(player1 == "X"){
                player1Score++;
                player1ScoreTxt.setText(String.valueOf(player1Score));
            }
            else{
               player2Score++;
                player2ScoreTxt.setText(String.valueOf(player2Score)); 
            }
        }
      

        public void playerOScore(){
            if(player1 == "O"){
                player1Score++;
                player1ScoreTxt.setText(String.valueOf(player1Score));
            }
            else{
               player2Score++;
                player2ScoreTxt.setText(String.valueOf(player2Score)); 
            }
        }

    
    
      public void setDisableBtn() {
        for (int i = 0; i < 9; i++) {
            buttonArr[i].setDisable(true);

        }     
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
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }    
}
