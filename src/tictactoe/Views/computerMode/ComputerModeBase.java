package tictactoe.Views.computerMode;

import SelectmodeView.SelectModeBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import tictactoe.Views.DrawView.DrawPane;
import tictactoe.Views.LoseView.LosePane;
import tictactoe.Views.WinView.WinPane;

public class ComputerModeBase extends AnchorPane {

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
    protected final Text score1CountText;
    protected final BorderPane drawPane;
    protected final Text drawCountText;
    protected final Text text0;
    protected final BorderPane score2Pane;
    protected final Text score2CountText;
    protected final Text text1;
    protected final Button newButton;
    protected final Button exitButton;
    boolean flag, game;
    Button[][] buttons = null;
    int count;
    ArrayList<Integer> computerPositions;
    ArrayList<Integer> playerPositions;
    int i;
    String currentPlayer;
    String computer;
    Stage stage;
    int result = 0;
    int playerScore = 0;
    int computerScore = 0;
    int draw = 0;
    String currentSymbol;
    public class XOButton extends Button {

        int index;

        public XOButton(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    public ComputerModeBase(Stage stage, String current , int userScoreP , int computerScoreP , int drawScoreP) {
            
        currentSymbol=current;
        computerScore=computerScoreP;
        playerScore=userScoreP;
        draw= drawScoreP;
        
        imageView = new ImageView();
        boardGrid = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        but00 = new XOButton(0);
        but01 = new XOButton(1);
        but02 = new XOButton(2);
        but10 = new XOButton(3);
        but11 = new XOButton(4);
        but12 = new XOButton(5);
        but20 = new XOButton(6);
        but21 = new XOButton(7);
        but22 = new XOButton(8);
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
        flag = true;
        game = true;
        buttons = new Button[3][3];
        buttons[0][0] = but00;
        buttons[0][1] = but01;
        buttons[0][2] = but02;
        buttons[1][0] = but10;
        buttons[1][1] = but11;
        buttons[1][2] = but12;
        buttons[2][0] = but20;
        buttons[2][1] = but21;
        buttons[2][2] = but22;
        
//        but00.setStyle("-fx-background-color: #d7049e;");
//        but01.setStyle("-fx-background-color: #d7049e;");
//        but02.setStyle("-fx-background-color: #d7049e;");
//        but10.setStyle("-fx-background-color: #d7049e;");
//        but11.setStyle("-fx-background-color: #d7049e;");
//        but12.setStyle("-fx-background-color: #d7049e;");
//        but20.setStyle("-fx-background-color: #d7049e;");
//        but21.setStyle("-fx-background-color: #d7049e;");
//        but22.setStyle("-fx-background-color: #d7049e;");
        playerPositions = new ArrayList<Integer>();
        computerPositions = new ArrayList<Integer>();
        this.stage = stage;
        currentPlayer = current;

        if (currentPlayer.equalsIgnoreCase("O")) {
            computer = "X";
            computerTurn(computer);
        } else {
            computer = "O";
        }

//        for(i=0;i<3;i++)
//        {
//            for(int j=0;j<3;j++)
//            {
//                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        XOButton button=(XOButton) event.getSource();
//                        if(count>=9)
//                        {
//                            game=false;
//                        }
//                        if(button.getText().isEmpty() && game)
//                        {
//                            button.setText(currentPlayer);
//                            button.setTextFill(Color.web("#3E4D8C"));
//                            flag=!flag;
//                            count++;
//                            evaluate();
//                            if(game)
//                            {
//                                computerTurn(computer);
//                            }
////                            playerPositions.add(button.getIndex());
////                            checkWinner("X");
////                            if(game)
////                            {
////                                makeAIMove(1);
////                            }
//                        }
//                        if(!game)
//                        {
//                            result=evaluate();
//                            if(result == 1)
//                            {
//                                System.out.println("You won!!");
//                            }
//                            else if(result == -1)
//                            {
//                                System.out.println("You lose!!");
//                            }
//                            else if(result == 0)
//                            {
//                                System.out.println("Draw");
//                            }
//                        }
//                        
//                    }
//                } );
//            }
//        }
  
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
        but00.setStyle("-fx-background-color: #d7049e;");
        but00.setFont(new Font("Arial", 50.0));


        GridPane.setColumnIndex(but01, 1);
        but01.setMnemonicParsing(false);
        but01.setPrefHeight(200.0);
        but01.setPrefWidth(255.0);
        but01.setStyle("-fx-background-color: #d7049e; ");
        but01.setFont(new Font("Arial", 50.0));


        GridPane.setColumnIndex(but02, 2);
        but02.setMnemonicParsing(false);
        but02.setPrefHeight(144.0);
        but02.setPrefWidth(215.0);
        but02.setStyle("-fx-background-color: #d7049e;");
        but02.setFont(new Font("Arial", 50.0));


        GridPane.setRowIndex(but10, 1);
        but10.setMnemonicParsing(false);
        but10.setPrefHeight(123.0);
        but10.setPrefWidth(212.0);
        but10.setStyle("-fx-background-color: #d7049e;");
        but10.setFont(new Font("Arial", 50.0));


        GridPane.setColumnIndex(but11, 1);
        GridPane.setRowIndex(but11, 1);
        but11.setMnemonicParsing(false);
        but11.setPrefHeight(139.0);
        but11.setPrefWidth(260.0);
        but11.setStyle("-fx-background-color: #d7049e;");
        but11.setFont(new Font("Arial", 50.0));
//        but11.setText("X");

        GridPane.setColumnIndex(but12, 2);
        GridPane.setRowIndex(but12, 1);
        but12.setMnemonicParsing(false);
        but12.setPrefHeight(139.0);
        but12.setPrefWidth(242.0);
        but12.setStyle("-fx-background-color: #d7049e;");
        but12.setFont(new Font("Arial", 50.0));


        GridPane.setRowIndex(but20, 2);
        but20.setMnemonicParsing(false);
        but20.setPrefHeight(127.0);
        but20.setPrefWidth(234.0);
        but20.setStyle("-fx-background-color: #d7049e;");
        but20.setFont(new Font("Arial", 50.0));


        GridPane.setColumnIndex(but21, 1);
        GridPane.setRowIndex(but21, 2);
        but21.setMnemonicParsing(false);
        but21.setPrefHeight(196.0);
        but21.setPrefWidth(192.0);
        but21.setStyle("-fx-background-color: #d7049e;");
        but21.setFont(new Font("Arial", 50.0));


        GridPane.setColumnIndex(but22, 2);
        GridPane.setRowIndex(but22, 2);
        but22.setMnemonicParsing(false);
        but22.setPrefHeight(161.0);
        but22.setPrefWidth(220.0);
        but22.setStyle("-fx-background-color: #d7049e;");
        but22.setFont(new Font("Arial", 50.0));


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

        BorderPane.setAlignment(text, javafx.geometry.Pos.CENTER);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Player");
        text.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text, new Insets(5.0, 0.0, 0.0, 0.0));
        score1Pane.setTop(text);

        BorderPane.setAlignment(score1CountText, javafx.geometry.Pos.CENTER);
        score1CountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score1CountText.setStrokeWidth(0.0);
        score1CountText.setText("" + playerScore);
        score1CountText.setFont(new Font("Arial Bold", 36.0));
        score1Pane.setCenter(score1CountText);

        GridPane.setColumnIndex(drawPane, 1);
        drawPane.setPrefHeight(200.0);
        drawPane.setPrefWidth(200.0);
        drawPane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(drawCountText, javafx.geometry.Pos.CENTER);
        drawCountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawCountText.setStrokeWidth(0.0);
        drawCountText.setText("" + draw);
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
        score2Pane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(score2CountText, javafx.geometry.Pos.CENTER);
        score2CountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score2CountText.setStrokeWidth(0.0);
        score2CountText.setText("" + computerScore);
        score2CountText.setFont(new Font("Arial Bold", 36.0));
        score2Pane.setCenter(score2CountText);

        BorderPane.setAlignment(text1, javafx.geometry.Pos.CENTER);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Computer");
        text1.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text1, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(text1);

        newButton.setLayoutX(300.0);
        newButton.setLayoutY(552.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(60.0);
        newButton.setPrefWidth(200.0);
        newButton.setStyle("-fx-background-radius: 15;");
        newButton.setText("New Game");
        newButton.setFont(new Font("Arial Bold", 27.0));
        newButton.setOpaqueInsets(new Insets(0.0));
        newButton.setStyle("-fx-background-color: #68CFD1 ;");
        newButton.setOnMouseEntered(event -> {
        newButton.setStyle("-fx-background-color: #00CBFE;");
        });
        newButton.setOnMouseExited(event -> {
        newButton.setStyle("-fx-background-color: #68CFD1 ;");
        });
//        newButton.setStyle("-fx-background-radius: 15; -fx-background-color: C5A0D7;");
//    newButton.setText("Restart");
//        newButton.setFont(new Font("Arial Bold", 14.0));
//        newButton.setOpaqueInsets(new Insets(0.0));

        exitButton.setLayoutX(510.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(200.0);
        exitButton.setStyle("-fx-background-radius: 15;");
        exitButton.setText("Main Menu");
        exitButton.setFont(new Font("Arial Bold", 27.0));
        exitButton.setStyle("-fx-background-color: #68CFD1 ;");
        exitButton.setOnMouseEntered(event -> {
        exitButton.setStyle("-fx-background-color: #00CBFE;");
        });
        exitButton.setOnMouseExited(event -> {
        exitButton.setStyle("-fx-background-color: #68CFD1 ;"); 
        });
//        exitButton.setStyle("-fx-background-radius: 15; -fx-background-color: C5A0D7;");
//        exitButton.setText("Exit");
//        exitButton.setFont(new Font("Arial Bold", 14.0));

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
        
        
        
              for (i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setOnAction((e) -> clickAction(e));
            }
        }

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new SelectModeBase(stage), 1000, 700));
            }
        });
        newButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                computerTurn(computer);
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        buttons[i][j].setText("");
                    }
                }
                game = true;
                count = 0;
            }
        });

    }

    public void clickAction(ActionEvent event) {
        if (game) {

            evaluate();
            XOButton button = (XOButton) event.getSource();
            if (button.getText().isEmpty() && game) {
                button.setText(currentPlayer);
                //button.setTextFill(Color.web("#3E4D8C"));
                count++;
                if (count >= 9) {
                    game = false;
                }

                if (game) {
                    computerTurn(computer);
                }

            }
            evaluate();
            if (!game) {
                if (result > 0) {
                    userWin();
                } else if (result < 0) {
                    computerWin();
                } else {
                    draw();
                }
            }
        }
    }

    public void userWin() {
        System.out.println("You Win!!!");
        playerScore++;

        score1CountText.setText(""+playerScore);
        stage.setScene(new Scene(new WinPane(stage,currentSymbol,playerScore,computerScore,draw),1000,700));
      //WinPlayVideo();
    }

    public void computerWin() {
        System.out.println("You Lose!!");
        computerScore++;

        score2CountText.setText(""+computerScore);
//        stage.setScene(new Scene(new LosePane(stage),1000,700));
        stage.setScene(new Scene(new LosePane(stage,currentSymbol,playerScore,computerScore,draw)));
        
        //LosePlayVideo();
    }

    public void draw() {
        System.out.println("Draw");
        draw++;

        drawCountText.setText(""+draw);
     //   DrawPlayVideo();
     
       stage.setScene(new Scene(new DrawPane(stage,currentSymbol,playerScore,computerScore,draw)));
    }

    public void computerTurn(String play) {
        int row;
        int col;
        evaluate();
        if (count < 9 && game) {
            do {
                row = (int) (Math.random() * 3);
                col = (int) (Math.random() * 3);
            } while (!buttons[row][col].getText().isEmpty());
            buttons[row][col].setText(play);
            //buttons[row][col].setTextFill(Color.web("#FF3B8B"));
            count++;
            if (count >= 9) {
                game = false;
            }
            computerPositions.add(row);

        }

//        if(!game)
//        {
//            int result=evaluate();
//            if(result == 1)
//            {
//                System.out.println("You won!!");
//            }
//            else if(result == -1)
//            {
//                System.out.println("You lose!!");
//            }
//            else if(result == 0)
//            {
//                System.out.println("Draw");
//            }
//        }
    }

    public boolean checkDraw() {
        if (!checkWinner2(currentPlayer) && !checkWinner2(computer)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkWinner2(String currentPlayer) {
        boolean win = false;
        // check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(currentPlayer) && buttons[i][1].getText().equals(currentPlayer) && buttons[i][2].getText().equals(currentPlayer)) {
                win = true;
                game = false;
            }
        }
        // check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[0][i].getText().equals(currentPlayer) && buttons[1][i].getText().equals(currentPlayer) && buttons[2][i].getText().equals(currentPlayer)) {
                win = true;
                game = false;
            }

        }
        // check diagonals
        if (buttons[0][0].getText().equals(currentPlayer) && buttons[1][1].getText().equals(currentPlayer) && buttons[2][2].getText().equals(currentPlayer)) {
            win = true;
            game = false;
        }
        if (buttons[2][0].getText().equals(currentPlayer) && buttons[1][1].getText().equals(currentPlayer) && buttons[0][2].getText().equals(currentPlayer)) {
            win = true;
            game = false;
        }

        return win;
    }

    public void evaluate() {
        if (checkWinner2(currentPlayer)) {
            result = 1;
        } else if (checkWinner2(computer)) {
            result = -1;
        } else if (checkDraw()) {
            result = 0;
        }
    }

    public boolean checkWinner(String player) {
        List<Integer> row1 = Arrays.asList(0, 1, 2);
        List<Integer> row2 = Arrays.asList(3, 4, 5);
        List<Integer> row3 = Arrays.asList(6, 7, 8);
        List<Integer> col1 = Arrays.asList(0, 3, 6);
        List<Integer> col2 = Arrays.asList(1, 4, 7);
        List<Integer> col3 = Arrays.asList(2, 5, 8);
        List<Integer> diag1 = Arrays.asList(0, 4, 8);
        List<Integer> diag2 = Arrays.asList(6, 4, 2);
        List<List> winPostions = new ArrayList<>();
        winPostions.add(row1);
        winPostions.add(row2);
        winPostions.add(row3);
        winPostions.add(col1);
        winPostions.add(col2);
        winPostions.add(col3);
        winPostions.add(diag1);
        winPostions.add(diag2);
        boolean win = false;
        for (List pos : winPostions) {
            if (playerPositions.containsAll(pos)) {
                System.out.println("You Won!");
                win = true;
                game = false;
            } else if (computerPositions.containsAll(pos)) {
                System.out.println("You Lost!!!");
                game = false;
            }
        }
        return win;

    }

    private void makeAIMove(int depth) {
        int[] bestMove = minimax(boardCopy(), depth, currentPlayer.equals("O"));

        int row = bestMove[0];
        int col = bestMove[1];

        if (isValidMove(row, col)) {
            buttons[row][col].setText("O");
            //buttons[row][col].setTextFill(Color.web("#FF0000"));
            computerPositions.add(row * 3 + col);
            count++;
            checkWinner("O");
        }
    }

    private int[] minimax(char[][] board, int depth, boolean isMaximizing) {
        // Base cases: check for a terminal state (win/lose/draw) or reach the specified depth
        int score = evaluateBoard(board);
        if (score == 10 || score == -10 || depth == 0) {
            return new int[]{score, -1, -1}; // Return the score and move coordinates
        }

        // If maximizing player's turn (computer 'O')
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            int[] bestMove = {-1, -1};

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        // Make the move
                        board[i][j] = 'O';

                        // Recursive call for this move
                        int currentScore = minimax(board, depth - 1, false)[0];

                        // Undo the move
                        board[i][j] = ' ';

                        // Update the best move if needed
                        if (currentScore > bestScore) {
                            bestScore = currentScore;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                    }
                }
            }

            return bestMove;
        } else {
            // If minimizing player's turn (player 'X')
            int bestScore = Integer.MAX_VALUE;
            int[] bestMove = {-1, -1};

            // Traverse all cells
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        // Make the move
                        board[i][j] = 'X';

                        // Recursive call for this move
                        int currentScore = minimax(board, depth - 1, true)[0];

                        // Undo the move
                        board[i][j] = ' ';

                        // Update the best move if needed
                        if (currentScore < bestScore) {
                            bestScore = currentScore;
                            bestMove[0] = i;
                            bestMove[1] = j;
                        }
                    }
                }
            }

            return bestMove;
        }
    }

// Helper method to evaluate the current state of the board
    private int evaluateBoard(char[][] board) {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'O') {
                    return 10;
                } else if (board[i][0] == 'X') {
                    return -10;
                }
            }

            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'O') {
                    return 10;
                } else if (board[0][i] == 'X') {
                    return -10;
                }
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'O') {
                return 10;
            } else if (board[0][0] == 'X') {
                return -10;
            }
        }

        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'O') {
                return 10;
            } else if (board[0][2] == 'X') {
                return -10;
            }
        }

        // If no winner and the board is full, it's a draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return 0; // The game is not finished yet
                }
            }
        }

        return 0; // It's a draw
    }

    private char[][] boardCopy() {
        char[][] copy = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copy[i][j] = buttons[i][j].getText().isEmpty() ? ' ' : buttons[i][j].getText().charAt(0);
            }
        }
        return copy;
    }

    private boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && buttons[row][col].getText().isEmpty();
    }

    public void WinPlayVideo() {

        // Create a Media object
        Media media = new Media(getClass().getResource("/assets/videos/WinVideo.mp4").toExternalForm());

        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(120.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }

    public void LosePlayVideo() {
        String videoFile = "/assets/videos/LoseVideo.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource(videoFile).toExternalForm());

        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }

    public void DrawPlayVideo() {

        String videoFile = "/assets/videos/DrawVideo2.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource(videoFile).toExternalForm());

        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(120.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }

}
