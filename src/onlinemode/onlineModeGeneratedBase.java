package onlinemode;

import Requests.App;
import Requests.Message;
import SelectmodeView.SelectModeBase;
import com.google.gson.Gson;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;

import javafx.scene.control.Alert.AlertType;

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
import tictactoe.Views.AvailablePlayer.PlayersListBaseNew;

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
    protected Text player1ScoreTxt;
    protected final BorderPane borderPane0;
    protected final Text drawTxt;
    protected Text drawScoreTxt;
    protected final BorderPane borderPane1;
    protected final Text player2Txt;
    protected Text player2ScoreTxt;
    protected final Button newGameBtn;
    protected final Button menueBtn;
    protected final Text player1Label;
    protected final Text player2Label;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Button recordBtn;
    Random random = new Random();
    public int[][] board;
    public static boolean myTurn = false;
    Gson gson = new Gson();
    public String opponentEmail;
    public String PlayerEmail;
    public String player1, player2;
    Boolean isLogOutAlertShown=true;
    public int player1Score,player2Score,drawScore;
    
    String opponentName;
    
    Button[] buttonArr;
    Alert alert;
    int turn;
    String currentPlayer;
    boolean running=true;
    String myEmail;
    MyWindowAdapter myWindowAdapter;
    public onlineModeGeneratedBase(Stage stage, String MyEmail, String opponentMail, int turn) {
        buttonArr = new Button[9];
        myWindowAdapter=new MyWindowAdapter(MyEmail,opponentMail);
            // Set the event handler for window-closing
        stage.setOnCloseRequest(event -> {
            myWindowAdapter.handleWindowClosing(MyEmail,opponentMail);
            // Prevent the default close operation (which is to close the window)
            event.consume();
        });
        myEmail=MyEmail;
        this.opponentName=opponentName;



    
        this.turn = turn;

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
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        recordBtn = new Button();
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
        player1Score = 0;
        player2Score = 0;
        drawScore = 0;

        
        
        PlayerEmail = MyEmail;
        opponentEmail = opponentMail;
        player1Label.setText(MyEmail);
        player2Label.setText(opponentMail);

        System.out.println("MyEmail: " + PlayerEmail);
        System.out.println("opponentMail :" + opponentEmail);
        PlayerEmail = MyEmail;
        opponentEmail = opponentMail;
        player1Label.setText(MyEmail);
        player2Label.setText(opponentMail);
        player1ScoreTxt.setText("0");
        player2ScoreTxt.setText("0");
        System.out.println("MyEmail: " + PlayerEmail);
        System.out.println("opponentMail :" + opponentEmail);
        firstTurn();
        App.startConnection();
        if(turn==2)
        {
            listener();
        }
        

        setId("AnchorPane");
        setPrefHeight(672.0);
        setPrefWidth(1050.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/onlinemode/onlinemode.css");

        imageView.setFitHeight(672.0);
        imageView.setFitWidth(1050.0);
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
                    topLeftBtn.setText(currentPlayer);
                    sendMove(1, currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                    System.out.println("fllllllllllllg" + running);
                    if(running)
                    {
                        listener();

                    }
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
                    sendMove(2, currentPlayer);
                    topBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                    System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }
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
                    sendMove(3, currentPlayer);
                    topRightBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                    System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();
                    }

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
                    sendMove(4, currentPlayer);
                    centerLeftBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                    System.out.println("lllllllllllllllll "+ running);
                System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }

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
                    sendMove(5, currentPlayer);
                    centerBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                                        System.out.println("lllllllllllllllll "+ running);
                System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }


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
                    sendMove(6, currentPlayer);
                    centerRightBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                                        System.out.println("lllllllllllllllll "+ running);
                System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }

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
                    sendMove(7, currentPlayer);
                    downLeftBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                                        System.out.println("lllllllllllllllll "+ running);
                System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }

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
                    sendMove(8, currentPlayer);
                    downBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                                        System.out.println("lllllllllllllllll "+ running);
                System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }

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
                    sendMove(9, currentPlayer);
                    downRightBtn.setText(currentPlayer);
                    player2Label.setText(opponentEmail + " Turn");
                    player1Label.setText(PlayerEmail);
                    checkWinner();
                    System.out.println("lllllllllllllllll "+ running);
                                    System.out.println("lllllllllllllllll "+ running);
                    if(running)
                    {
                        listener();

                    }

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
        player1Txt.setText(PlayerEmail);
        player1Txt.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player1Txt, new Insets(5.0, 0.0, 0.0, 0.0));
        borderPane.setTop(player1Txt);

        BorderPane.setAlignment(player1ScoreTxt, javafx.geometry.Pos.CENTER);
        player1ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1ScoreTxt.setStrokeWidth(0.0);
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
        player2Txt.setText(opponentEmail);
        player2Txt.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player2Txt, new Insets(5.0, 0.0, 0.0, 0.0));
        borderPane1.setTop(player2Txt);

        BorderPane.setAlignment(player2ScoreTxt, javafx.geometry.Pos.CENTER);
        player2ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2ScoreTxt.setStrokeWidth(0.0);
        player2ScoreTxt.setFont(new Font("Arial Bold", 36.0));
        borderPane1.setCenter(player2ScoreTxt);

        newGameBtn.setLayoutX(390.0);
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
                for (int i = 0; i < 9; i++) {
                    buttonArr[i].setText("");
                    buttonArr[i].setTextFill(Color.WHITE);
                    buttonArr[i].setDisable(false);
                    buttonArr[i].setStyle("-fx-background-color: #d7049e;");
                    firstTurn();
//                    buttonArr[i].setStyle("-fx-text-stroke: white;");
                }
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        board[a][b] = -1;
                    }
                }
                running=true;
                if(turn == 2 && running)
                {
                    System.out.println("///////////////////////////////////// new game");
                    listener();
                }

//                Platform.runLater(() -> {
//                    Parent root = new PlayersListBaseNew(stage, PlayerEmail);
//                    Scene scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
//                });

            }
        });

        menueBtn.setLayoutX(160.0);
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
        menueBtn.setText("Main Menu");
        menueBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {


                String logOutAlert = "logOutShowAlert";
                Message logOutMsg = new Message();
                logOutMsg.setEmail(myEmail);
                logOutMsg.setOpponentEmail(opponentMail);
               // System.out.println(opponentMail + "qqqqqqqqqqqss");
                logOutMsg.setType("logOut");
                logOutMsg.setShowAlertOnLogOut(logOutAlert);
                
                
                String request = gson.toJson(logOutMsg);
                System.out.println(request);
                App.output.println(request);
                App.output.flush();
                
                Parent root = new  SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });

        player1Label.setLayoutX(45.0);
        player1Label.setLayoutY(390.0);
//        player1Label.setText("Player1");
        player1Label.setFont(new Font(35.0));
        player1Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Label.setFill(Color.WHITE); // setting color of the text to blue
        player1Label.setStroke(Color.BLACK); // setting the stroke for the text
        player1Label.setStrokeWidth(1);
        player1Label.setStrokeWidth(2.0);

        player2Label.setLayoutX(795.0);
        player2Label.setLayoutY(390.0);
//        player2Label.setText("Player 2");
        player2Label.setFont(new Font(35.0));
        player2Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Label.setFill(Color.WHITE);
        player2Label.setStroke(Color.BLACK);
        player2Label.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Label.setStrokeWidth(2.0);

        imageView0.setFitHeight(117.0);
        imageView0.setFitWidth(119.0);
        imageView0.setLayoutX(58.0);
        imageView0.setLayoutY(222.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("icons8-player-64.png").toExternalForm()));

        imageView1.setFitHeight(111.0);
        imageView1.setFitWidth(117.0);
        imageView1.setLayoutX(822.0);
        imageView1.setLayoutY(225.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("icons8-anonymous-64.png").toExternalForm()));

        recordBtn.setLayoutX(628.0);
        recordBtn.setLayoutY(560.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setPrefHeight(48.0);
        recordBtn.setPrefWidth(210.0);
        recordBtn.setStyle("-fx-background-radius: 15;");
        recordBtn.setText("Main Menu");
        recordBtn.setFont(new Font("Arial Bold", 27.0));
        recordBtn.setStyle("-fx-background-color: #68CFD1 ;");
        recordBtn.setOnMouseEntered(event -> {
            recordBtn.setStyle("-fx-background-color: #00CBFE;");
        });
        recordBtn.setOnMouseExited(event -> {
            recordBtn.setStyle("-fx-background-color: #68CFD1 ;");
        });
        recordBtn.setText("Record");

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
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(recordBtn);
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
    public void listener(){
        new Thread(() -> {
//            while (true) {
                try {
                    
                    String jsonResponse = App.input.readLine();
                    System.out.println(jsonResponse);
                    Message response = App.gson.fromJson(jsonResponse, Message.class);
                    String playerSide = response.getXO();
                    int location = response.getLocation();
                    if (response.getType().equals("updateOpponentScore")) {
                        int score = response.getScore();
                        player2ScoreTxt.setText(String.valueOf(score));
                    }

                    if (response.getType().equals("updateScore")) {
                        int score = response.getScore();
                        player2ScoreTxt.setText(String.valueOf(score));

                    }

                    if (response.getType().equals("retriveMove")) {
                        Platform.runLater(() -> {
                            switch (location) {
                                case 1:
                                    
                                    topLeftBtn.setText(playerSide);
                                    buttonArr[0].setText(playerSide);
                                    myTurn = true;
//                                    checkWinner();
                                    print();
                                    break;
                                case 2:
                                    topBtn.setText(playerSide);
                                    buttonArr[1].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 3:
                                    topRightBtn.setText(playerSide);
                                    buttonArr[2].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 4:
                                    centerLeftBtn.setText(playerSide);
                                    buttonArr[3].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 5:
                                    centerBtn.setText(playerSide);
                                    buttonArr[4].setText(playerSide);
                                    myTurn = true;
                                    break;
                                case 6:
                                    centerRightBtn.setText(playerSide);
                                    buttonArr[5].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 7:
                                    downLeftBtn.setText(playerSide);
                                    buttonArr[6].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 8:
                                    downBtn.setText(playerSide);
                                    buttonArr[7].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                                case 9:
                                    downRightBtn.setText(playerSide);
                                    buttonArr[8].setText(playerSide);
                                    myTurn = true;
                                    print();
                                    break;
                            }
                            checkWinner();

//                            checkWinner();
//                            try {
//                                Thread.sleep(100);
//                            } catch (InterruptedException ex) {
//                                Logger.getLogger(onlineModeGeneratedBase.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                        });
                    }
                    String logOutAlert = "logOutShowAlert";
                  //  System.out.println(response.getShowAlertOnLogOut() + "XXXXXXXXXXXX");
                    if(myEmail.equalsIgnoreCase(response.getOpponentEmail())){
                        if (response.getShowAlertOnLogOut().equalsIgnoreCase(logOutAlert)){                   
                            Platform.runLater(() -> {                    
                                if(isLogOutAlertShown==true){
                                    System.out.println("Log out alert");
                                    showAlertWhenOpponentLoggingOutAndNavigateToAvailablePlayersGUI(stage,MyEmail);
                                }
                            });

                        }else{
                            System.out.println("Alert is not working");
                        }
                    }else{
                        System.out.println("NOT THE OPPONENTTTTT");
                    }
//                        System.out.println("fllllllllllllg" + running);
//                        if(running==false){
//                            break;
//                        }

                } catch (IOException ex) {
                    ex.printStackTrace();
                    
                }
//            }
        }).start();
    }

    public void firstTurn() {

        if (turn == 1) {
            currentPlayer = "X";
            myTurn = true;
            player1 = "X";
            player2 = "O";
            player1Label.setText(PlayerEmail + " Turn");
            player2Label.setText(opponentEmail);
            System.out.println("x: " + PlayerEmail);
            System.out.println("O: " + opponentEmail);
        }
        if (turn == 2) {
            currentPlayer = "O";
            myTurn = false;
            player1 = "O";
            player2 = "X";
            player1Label.setText(PlayerEmail);
            player2Label.setText(opponentEmail + " Turn");
            System.out.println("x: " + opponentEmail);
            System.out.println("O: " + PlayerEmail);
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
        System.out.println(request);
        App.output.println(request);
        App.output.flush();
    }

    public synchronized void xWins(int index1, int index2, int index3) {
        buttonArr[index1].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index2].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index3].setStyle("-fx-background-color: #5A1E76;");
        Platform.runLater(() -> {
            xWinsVideo();
        });
        running=false;
//        try {
//            Thread.sleep(100);
//            
//            //player1Label.setText("Player1 ");
//            //player2Label.setText("Player2");
//        } catch (InterruptedException ex) {
//            Logger.getLogger(onlineModeGeneratedBase.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public synchronized void oWins(int index1, int index2, int index3) {
        buttonArr[index1].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index2].setStyle("-fx-background-color: #5A1E76;");
        buttonArr[index3].setStyle("-fx-background-color: #5A1E76;");
        Platform.runLater(() -> {
            oWinsVideo();
        });
        running=false;
//        try {
//            Thread.sleep(100);
//            //player1Label.setText("Player1 ");
//            //player2Label.setText("Player2");
//        } catch (InterruptedException ex) {
//            Logger.getLogger(onlineModeGeneratedBase.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

    public synchronized void  checkWinner() {
        for (int i = 0; i < buttonArr.length; i++) {
            System.out.println("button " + i + " " + buttonArr[i].getText());
        }
        if (buttonArr[0].getText().equalsIgnoreCase("X")
                && buttonArr[1].getText().equalsIgnoreCase("X")
                && buttonArr[2].getText().equalsIgnoreCase("X")) {
            xWins(0, 1, 2);
            playerXScore();
            setDisableBtn();

        } else if (buttonArr[3].getText().equalsIgnoreCase("X")
                && buttonArr[4].getText().equalsIgnoreCase("X")
                && buttonArr[5].getText().equalsIgnoreCase("X")) {
            xWins(3, 4, 5);
            playerXScore();
            setDisableBtn();
        } else if (buttonArr[6].getText().equalsIgnoreCase("X")
                && buttonArr[7].getText().equalsIgnoreCase("X")
                && buttonArr[8].getText().equalsIgnoreCase("X")) {
            xWins(6, 7, 8);
            playerXScore();
            setDisableBtn();
        } else if (buttonArr[0].getText().equalsIgnoreCase("X")
                && buttonArr[3].getText().equalsIgnoreCase("X")
                && buttonArr[6].getText().equalsIgnoreCase("X")) {
            xWins(0, 3, 6);
            playerXScore();
            setDisableBtn();
        }
        if (buttonArr[1].getText().equalsIgnoreCase("X")
                && buttonArr[4].getText().equalsIgnoreCase("X")
                && buttonArr[7].getText().equalsIgnoreCase("X")) {
            xWins(1, 4, 7);
            playerXScore();
            setDisableBtn();
        } else if (buttonArr[2].getText().equalsIgnoreCase("X")
                && buttonArr[5].getText().equalsIgnoreCase("X")
                && buttonArr[8].getText().equalsIgnoreCase("X")) {
            xWins(2, 5, 8);
            playerXScore();
            setDisableBtn();
        } else if (buttonArr[0].getText().equalsIgnoreCase("X")
                && buttonArr[4].getText().equalsIgnoreCase("X")
                && buttonArr[8].getText().equalsIgnoreCase("X")) {
            xWins(0, 4, 8);
            playerXScore();
            setDisableBtn();
        } else if (buttonArr[2].getText().equalsIgnoreCase("X")
                && buttonArr[4].getText().equalsIgnoreCase("X")
                && buttonArr[6].getText().equalsIgnoreCase("X")) {
            xWins(2, 4, 6);
            playerXScore();
            setDisableBtn();
        } //check if O wins//
        else if (buttonArr[0].getText().equalsIgnoreCase("O")
                && buttonArr[1].getText().equalsIgnoreCase("O")
                && buttonArr[2].getText().equalsIgnoreCase("O")) {
            oWins(0, 1, 2);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[3].getText().equalsIgnoreCase("O")
                && buttonArr[4].getText().equalsIgnoreCase("O")
                && buttonArr[5].getText().equalsIgnoreCase("O")) {
            oWins(3, 4, 5);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[6].getText().equalsIgnoreCase("O")
                && buttonArr[7].getText().equalsIgnoreCase("O")
                && buttonArr[8].getText().equalsIgnoreCase("O")) {
            oWins(6, 7, 8);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[0].getText().equalsIgnoreCase("O")
                && buttonArr[3].getText().equalsIgnoreCase("O")
                && buttonArr[6].getText().equalsIgnoreCase("O")) {
            oWins(0, 3, 6);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[1].getText().equalsIgnoreCase("O")
                && buttonArr[4].getText().equalsIgnoreCase("O")
                && buttonArr[7].getText().equalsIgnoreCase("O")) {
            oWins(1, 4, 7);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[2].getText().equalsIgnoreCase("O")
                && buttonArr[5].getText().equalsIgnoreCase("O")
                && buttonArr[8].getText().equalsIgnoreCase("O")) {
            oWins(2, 5, 8);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[0].getText().equalsIgnoreCase("O")
                && buttonArr[4].getText().equalsIgnoreCase("O")
                && buttonArr[8].getText().equalsIgnoreCase("O")) {
            oWins(0, 4, 8);
            playerOScore();
            setDisableBtn();
        } else if (buttonArr[2].getText().equalsIgnoreCase("O")
                && buttonArr[4].getText().equalsIgnoreCase("O")
                && buttonArr[6].getText().equalsIgnoreCase("O")) {
            oWins(2, 4, 6);
            playerOScore();
            setDisableBtn();

        } else {
            boolean isBoardFull = true;
            for (int i = 0; i < 9; i++) {
                if (buttonArr[i].getText().isEmpty()) {
                    isBoardFull = false;
                    break;
                }
            }
            if (isBoardFull) {
                running=false;
                DrawPlayVideo();
                setDisableBtn();
                drawScore++;
                drawScoreTxt.setText(String.valueOf(drawScore));
            }
        }

    }

    public void playerXScore() {
//        if (player1 == "X") {
//            player1Score++;
//            player1ScoreTxt.setText(String.valueOf(player1Score));
//        } else {
//            player2Score++;
//            player2ScoreTxt.setText(String.valueOf(player2Score));
//        }
        if (currentPlayer.equalsIgnoreCase("X")) {
            player1Score++;
            player1ScoreTxt.setText(String.valueOf(player1Score));
            App.startConnection();
            Message m = new Message();
            m.setType("PlayerScore");
            m.setEmail(PlayerEmail);
            m.setOpponentEmail(opponentEmail);
            m.setScore(player1Score);
            String send = gson.toJson(m);
            System.out.println(send);
            App.output.println(send);
            App.output.flush();
        } else {
            player2Score++;
            player2ScoreTxt.setText(String.valueOf(player2Score));
        }

    }

    public void playerOScore() {
//        if (player1 == "O") {
//            player1Score++;
//            player1ScoreTxt.setText(String.valueOf(player1Score));
//        } else {
//            player2Score++;
//            player2ScoreTxt.setText(String.valueOf(player2Score));
//        }
        if (currentPlayer.equalsIgnoreCase("O")) {
            player1Score++;
            player1ScoreTxt.setText(String.valueOf(player1Score));
            App.startConnection();
            Message msg = new Message();
            msg.setType("opponentScore");
            msg.setEmail(PlayerEmail);
            msg.setOpponentEmail(opponentEmail);
            msg.setScore(player1Score);
            String request = gson.toJson(msg);
            System.out.println(request);
            App.output.println(request);
            App.output.flush();
        } else {
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
        Media media = new Media(getClass().getResource("/assets/videos/XWinsVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer3 = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer3);
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position
        StackPane.setAlignment(mediaView, Pos.CENTER);
        mediaPlayer3.play();
        getChildren().add(mediaView);
        mediaPlayer3.setOnEndOfMedia(() -> {
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }

    public void oWinsVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/OWinsVideo.mp4";
        Media media = new Media(getClass().getResource("/assets/videos/OWinsVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer4 = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer4);
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position
        StackPane.setAlignment(mediaView, Pos.CENTER);
        mediaPlayer4.play();
        getChildren().add(mediaView);

        mediaPlayer4.setOnEndOfMedia(() -> {
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }

    public void DrawPlayVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/LocalMode2Players/DrawVideo2.mp4";
        Media media = new Media(getClass().getResource("/assets/videos/DrawVideo2.mp4").toExternalForm());
        MediaPlayer mediaPlayer6 = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer6);
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(120.0);  // Set Y position
        StackPane.setAlignment(mediaView, Pos.CENTER);
        mediaPlayer6.play();
        getChildren().add(mediaView);
        mediaPlayer6.setOnEndOfMedia(() -> {
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });

    }

    public void print() {
        player2Label.setText(opponentEmail);
        player1Label.setText(PlayerEmail + " Turn");
    }
    
    public void showAlertWhenOpponentLoggingOutAndNavigateToAvailablePlayersGUI(Stage stage , String myEmail){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ALERTT!!!");
        alert.setHeaderText("The game ended");
        alert.setContentText("Your opponent has logged out , you will be navigated to the available online players gui");

        // Set up event handler for OK button
        ButtonType okButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(okButton);

        Optional<ButtonType> result = alert.showAndWait();

        // Handle OK button click or closing the alert
        if (result.isPresent() && result.get() == okButton) {
            System.out.println("OK button clicked or alert closed");
            Parent root = new  PlayersListBaseNew(stage, myEmail);
            Scene scene = new Scene(root,1000,700);
            stage.setScene(scene);
            stage.show();
        } else {
            System.out.println("Alert closed without clicking OK");
            Parent root = new  PlayersListBaseNew(stage, myEmail);
            Scene scene = new Scene(root,1000,700);
            stage.setScene(scene);
            stage.show();
        }
        
        isLogOutAlertShown=false;
        
    }
    
}

