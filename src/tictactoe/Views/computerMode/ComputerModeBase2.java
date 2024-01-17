package tictactoe.Views.computerMode;

import static Requests.App.gson;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;

public class ComputerModeBase2 extends AnchorPane {

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
   // Gson gson;
    Button[][] buttons=null;
    int count;
    ArrayList<Integer> computerPositions;
    ArrayList<Integer> playerPositions;
    int i;
    String currentPlayer="O";
    public class XOButton extends Button{
        int index;
        public XOButton(int index)
        {
            this.index=index;
        }
        public int getIndex()
        {
            return index;
        }
    }
    public ComputerModeBase2(Stage stage) {

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
        buttons=new Button[3][3];
        buttons[0][0] = but00;
        buttons[0][1] = but01;
        buttons[0][2] = but02;
        buttons[1][0] = but10;
        buttons[1][1] = but11;
        buttons[1][2] = but12;
        buttons[2][0] = but20;
        buttons[2][1] = but21;
        buttons[2][2] = but22;
        Recording(buttons);
    
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        imageView.setFitHeight(700.0);
        imageView.setFitWidth(1000.0);
        imageView.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));
        
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

        GridPane.setColumnIndex(but01, 1);
        but01.setMnemonicParsing(false);
        but01.setPrefHeight(200.0);
        but01.setPrefWidth(255.0);
        but01.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setColumnIndex(but02, 2);
        but02.setMnemonicParsing(false);
        but02.setPrefHeight(144.0);
        but02.setPrefWidth(215.0);
        but02.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setRowIndex(but10, 1);
        but10.setMnemonicParsing(false);
        but10.setPrefHeight(123.0);
        but10.setPrefWidth(212.0);
        but10.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setColumnIndex(but11, 1);
        GridPane.setRowIndex(but11, 1);
        but11.setMnemonicParsing(false);
        but11.setPrefHeight(139.0);
        but11.setPrefWidth(260.0);
        but11.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");
//        but11.setText("X");

        GridPane.setColumnIndex(but12, 2);
        GridPane.setRowIndex(but12, 1);
        but12.setMnemonicParsing(false);
        but12.setPrefHeight(139.0);
        but12.setPrefWidth(242.0);
        but12.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setRowIndex(but20, 2);
        but20.setMnemonicParsing(false);
        but20.setPrefHeight(127.0);
        but20.setPrefWidth(234.0);
        but20.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setColumnIndex(but21, 1);
        GridPane.setRowIndex(but21, 2);
        but21.setMnemonicParsing(false);
        but21.setPrefHeight(196.0);
        but21.setPrefWidth(192.0);
        but21.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

        GridPane.setColumnIndex(but22, 2);
        GridPane.setRowIndex(but22, 2);
        but22.setMnemonicParsing(false);
        but22.setPrefHeight(161.0);
        but22.setPrefWidth(220.0);
        but22.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 15; -fx-font-family: 'Comic Sans MS'; -fx-font-size: 50;");

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

        exitButton.setLayoutX(528.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(130.0);
        exitButton.setStyle("-fx-background-radius: 15; -fx-background-color: C5A0D7;");
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial Bold", 14.0));

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
                buttons[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        XOButton clickedButton = (XOButton) event.getSource();
                        int index = clickedButton.getIndex();

                        if (isValidMove(index)) {
                            // Update the board with the player's move
                            updateBoard(index);

                            // Check for a winner or a draw
                            if (checkWinner()) {
                                // Handle the winner
                                // Update the score and provide options to restart or exit
                            } else if (isBoardFull()) {
                                // Handle a draw
                                // Update the score and provide options to restart or exit
                            } else {
                                // Switch to the AI's turn (Minimax algorithm)
                                makeComputerMove();
                            }
                        }
                    }
                });
            }
        }
        
    }

    private boolean isValidMove(int index) {
        int row = index / 3;
        int col = index % 3;
        return buttons[row][col].getText().isEmpty();
    }

    private void updateBoard(int index) {
        int row = index / 3;
        int col = index % 3;
        buttons[row][col].setText(currentPlayer);
        if (currentPlayer.equals("O")) {
            playerPositions.add(index);
        } else {
            computerPositions.add(index);
        }
        currentPlayer = (currentPlayer.equals("O")) ? "X" : "O";
    }

    private boolean checkWinner() {
        List<List<Integer>> winningConditions = new ArrayList<>();
        List<Integer> row1=Arrays.asList(0,1,2);
        List<Integer> row2=Arrays.asList(3,4,5);
        List<Integer> row3=Arrays.asList(6,7,8);
        List<Integer> col1=Arrays.asList(0,3,6);
        List<Integer> col2=Arrays.asList(1,4,7);
        List<Integer> col3=Arrays.asList(2,5,8);
        List<Integer> diag1=Arrays.asList(0,4,8);
        List<Integer> diag2=Arrays.asList(6,4,2);
        winningConditions.add(row1);
        winningConditions.add(row2);
        winningConditions.add(row3);
        winningConditions.add(col1);
        winningConditions.add(col2);
        winningConditions.add(col3);
        winningConditions.add(diag1);
        winningConditions.add(diag2);

        for (List<Integer> condition : winningConditions) {
            if (playerPositions.containsAll(condition)) {
                // Player wins
                updateScore("Player 1");
                return true;
            } else if (computerPositions.containsAll(condition)) {
                // Computer wins
                updateScore("Computer");
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        // Board is full
        updateScore("Draw");
        return true;
    }

    private void makeComputerMove() {
        int bestMove = getBestMove();
        updateBoard(bestMove);

        // Check for a winner or a draw after the computer's move
        if (!checkWinner() && !isBoardFull()) {
            currentPlayer = "O"; // Switch back to player's turn
        }
    }

    private int getBestMove() {
        // Implement the Minimax algorithm to find the best move for the computer
        // You need to add your own implementation here
        int[] bestMove = minimax(2, "X"); // Depth and player ("X" for computer)
        return bestMove[1];
    }

    private int[] minimax(int depth, String player) {
        List<Integer> availableSpots = getAvailableSpots();

        if (depth == 0 || isBoardFull()) {
            return new int[]{evaluateBoard(), -1};
        }

        int bestScore = (player.equals("X")) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestMove = -1;

        for (Integer spot : availableSpots) {
            int row = spot / 3;
            int col = spot % 3;
            buttons[row][col].setText(player);

            if (player.equals("X")) {
                int currentScore = minimax(depth - 1, "O")[0];
                if (currentScore > bestScore) {
                    bestScore = currentScore;
                    bestMove = spot;
                }
            } else {
                int currentScore = minimax(depth - 1, "X")[0];
                if (currentScore < bestScore) {
                    bestScore = currentScore;
                    bestMove = spot;
                }
            }

            buttons[row][col].setText(""); // Undo the move
        }

        return new int[]{bestScore, bestMove};
    }

    private List<Integer> getAvailableSpots() {
        List<Integer> spots = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getText().isEmpty()) {
                    spots.add(i * 3 + j);
                }
            }
        }
        return spots;
    }

    private int evaluateBoard() {
        // You need to add your own implementation for board evaluation
        // Return a positive value if the computer wins, a negative value if the player wins, and 0 for a draw
        return 0;
    }

    private void updateScore(String winner) {
        // Update the score based on the winner
        if (winner.equals("Player 1")) {
            int score = Integer.parseInt(score1CountText.getText()) + 1;
            score1CountText.setText(String.valueOf(score));
        } else if (winner.equals("Computer")) {
            int score = Integer.parseInt(score2CountText.getText()) + 1;
            score2CountText.setText(String.valueOf(score));
        } else {
            int score = Integer.parseInt(drawCountText.getText()) + 1;
            drawCountText.setText(String.valueOf(score));
        }
    }
    
    Gson gson = new Gson();
    private void Recording(Button[][] buttons){
              String[][] buttonValues = new String[3][3];

        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                Button button = buttons[i][j];
                buttonValues[i][j] = button.getText();
            }
        }

        String json = gson.toJson(buttonValues);

        System.out.println(json);
    }
        
}
