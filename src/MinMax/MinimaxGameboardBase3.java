
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinMax;

/**
 *
 * @author sarah
 */

import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.Views.DrawView.DrawPane;
import tictactoe.Views.LoseView.LosePane;

public class MinimaxGameboardBase3 extends AnchorPane {

    
    String player1="User";
    String player2="Computer";
    private static final int SIZE = 3;
    private static final String PLAYER_X = "X";
    private static final String PLAYER_O = "O";
    private final GridPane boardGrid;
    private boolean player1Turn = true;
    private String[][] board = new String[SIZE][SIZE];
    protected final ImageView backgroundImage;
   // protected final Button newGameButton;
    protected final Button mainMenuButton;
    
    protected final BorderPane score1Pane;
    protected final Text player1Text;
    protected Text player1ScoreText;
    protected final BorderPane drawPane;
    protected final Text drawScoreText;
    protected final Text drawText;
    protected final BorderPane score2Pane;
    protected Text player2ScoreText;
    protected final Text player2Text;
    protected final GridPane scoreGrid;
      protected final ImageView backBtn;
    int computerWinsCounter;
    public MinimaxGameboardBase3(Stage stage , int computerScore) {
        
        computerWinsCounter=computerScore; 
        boardGrid = new GridPane();
        initializeBoard(stage);
        mainMenuButton = new Button();
        
        score1Pane = new BorderPane();
        player1Text = new Text();
        player1ScoreText = new Text();
        drawPane = new BorderPane();
        drawScoreText = new Text();
        drawText = new Text();
        score2Pane = new BorderPane();
        player2ScoreText = new Text();
        player2Text = new Text();
            backBtn = new ImageView();
        
        
        /*
        // Existing code...
        newGameButton = new Button();
        
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
        newGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
     */   
        
        
        score1Pane.setPrefHeight(200.0);
        score1Pane.setPrefWidth(143.0);
        score1Pane.setStyle("-fx-background-radius: 15; -fx-background-color: white;");

        BorderPane.setAlignment(player1Text, javafx.geometry.Pos.CENTER);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);
        player1Text.setText(player1);
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
        player2ScoreText.setText(Integer.toString(computerWinsCounter));
        player2ScoreText.setFont(new Font("Arial Bold", 36.0));
        score2Pane.setCenter(player2ScoreText);

        BorderPane.setAlignment(player2Text, javafx.geometry.Pos.CENTER);
        player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Text.setStrokeWidth(0.0);
        player2Text.setText(player2);
        player2Text.setFont(new Font("Arial Bold", 27.0));
        BorderPane.setMargin(player2Text, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(player2Text);
        
        
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
        mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               //SelectModeBase
               stage.setScene(new Scene(new SelectModeBase(stage)));
            }
        });

        
        backBtn.setLayoutX(100.0);
        backBtn.setLayoutY(50.0);
        backBtn.setImage(new Image(getClass().getResource("/assets/images/a.png").toExternalForm()));
        backBtn.setId("arrow");
        backBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Parent root = new homeBase(stage);
                Scene scene = new Scene(root, 1000, 700);
                stage.setScene(scene);
                stage.show();
            }
        });

        
        
        scoreGrid = new GridPane();
        scoreGrid.setHgap(10.0);
        scoreGrid.setLayoutX(276.0);
        scoreGrid.setLayoutY(43.0);
        scoreGrid.setPrefHeight(99.0);
        scoreGrid.setPrefWidth(448.0);
        // Set the layout for the boardGrid
        boardGrid.setHgap(10.0);
        boardGrid.setVgap(10.0);
        boardGrid.setLayoutX(265.0);
        boardGrid.setLayoutY(171.0);
        boardGrid.setPrefHeight(359.0);
        boardGrid.setPrefWidth(470.0);
        // Set the preferred size of the AnchorPane (this)
        setPrefSize(1000, 700);
        // Create a BorderPane to set the size of the scene
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(boardGrid);
        // Create the scene with the specified dimensions
        Scene scene = new Scene(borderPane, 1000, 700);
        backgroundImage = new ImageView();
        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1000.0);
        backgroundImage.setImage(new Image(getClass().getResource("/assets/images/backgroundImageGif.gif").toExternalForm()));
        getChildren().add(backgroundImage);
        getChildren().add(boardGrid);
         //getChildren().add(backBtn);
        scoreGrid.getChildren().add(score1Pane);
        scoreGrid.getChildren().add(drawPane);
        scoreGrid.getChildren().add(score2Pane);
       
        getChildren().add(scoreGrid);
      //  getChildren().add(newGameButton);
        getChildren().add(mainMenuButton);
        stage.setScene(scene);
    }

    private void initializeBoard(Stage stage) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "";
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Button button = new Button();
                button.setPrefHeight(127.0);
                button.setPrefWidth(234.0);
                button.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
                button.setMnemonicParsing(false);
               // button6.setPrefHeight(127.0);
               // button6.setPrefWidth(234.0);
                button.setFont(new Font(50)); 
                
                int row = i;
                int col = j;
                button.setOnAction(e -> handleButtonClick(row, col, button , stage));
                boardGrid.add(button, j, i);
            }
        }

        // Other initialization code...
    }

    private void handleButtonClick(int row, int col, Button button,Stage stage) {
        if (button.getText().isEmpty()) {
            if (player1Turn) {
                button.setText(PLAYER_X);
                board[row][col] = PLAYER_X;
            } else {
                button.setText(PLAYER_O);
                board[row][col] = PLAYER_O;
            }
            player1Turn = !player1Turn;

            if (checkForWinner()) {
                handleGameOver(stage);
                disableAllButtonsExceptWinning();
            } else {
                if (!player1Turn) {
                    makeComputerMove(stage);
                    if (checkForWinner()) {
                        handleGameOver(stage);
                        disableAllButtonsExceptWinning();
                    }
                }
            }
        }
    }
    private void disableAllButtonsExceptWinning() {
        for (Node node : boardGrid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                int row = GridPane.getRowIndex(button);
                int col = GridPane.getColumnIndex(button);

                // Check if the button is part of the winning combination
                if (!isPartOfWinningCombination(row, col)) {
                    button.setDisable(true);
                }
            }
        }
    }

    private boolean isPartOfWinningCombination(int row, int col) {
        // Check if the button is part of the winning combination in the row
        if (!board[row][0].isEmpty() && board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2])) {
            return true;
        }

        // Check if the button is part of the winning combination in the column
        if (!board[0][col].isEmpty() && board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col])) {
            return true;
        }

        // Check if the button is part of the winning combination in the diagonal
        if (row == col && !board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }

        if (row + col == 2 && !board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            return true;
        }

        return false;
    }
    
    private void enableAllButtons() {
        for (Node node : boardGrid.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setDisable(false);
            }
        }
    }
        
    private void makeComputerMove(Stage stage) {
        int[] bestMove = minimax(board, 0 , stage);
        
        if (bestMove[0] < 0 || bestMove[0] >= SIZE || bestMove[1] < 0 || bestMove[1] >= SIZE) {
            System.err.println("Invalid move: " + Arrays.toString(bestMove));
            return;
        }
        
        int row = bestMove[0];
        int col = bestMove[1];

        Button button = (Button) boardGrid.getChildren().get(row * SIZE + col);
        button.setText(PLAYER_O);
        board[row][col] = PLAYER_O;
        player1Turn = true;
    }

    private int[] minimax(String[][] currentBoard, int depth , Stage stage) {
    int[] bestMove = {-1, -1};
    int bestScore = (player1Turn) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    boolean foundMove = false;

    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            if (currentBoard[i][j].isEmpty()) {
                currentBoard[i][j] = (player1Turn) ? PLAYER_X : PLAYER_O;

                int score = minimaxHelper(currentBoard, depth + 1, !player1Turn);
                currentBoard[i][j] = "";

                if ((player1Turn && score > bestScore) || (!player1Turn && score < bestScore)) {
                    bestScore = score;
                    bestMove[0] = i;
                    bestMove[1] = j;
                    foundMove = true;
                }
            }
        }
    }

    if (!foundMove) {
        System.out.println("No valid move found");
        stage.setScene(new Scene(new DrawPaneMiniMax(stage , computerWinsCounter),1000,700));
    }

    return bestMove;
}



    private int minimaxHelper(String[][] currentBoard, int depth, boolean maximizingPlayer) {
        if (checkForWinner()) {
            return (maximizingPlayer) ? -1 : 1;
        }

        if (isBoardFull()) {
            return 0;
        }

        int score;

        if (maximizingPlayer) {
            score = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (currentBoard[i][j].isEmpty()) {
                        currentBoard[i][j] = PLAYER_X;
                        score = Math.max(score, minimaxHelper(currentBoard, depth + 1, false));
                        currentBoard[i][j] = "";
                    }
                }
            }
        } else {
            score = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (currentBoard[i][j].isEmpty()) {
                        currentBoard[i][j] = PLAYER_O;
                        score = Math.min(score, minimaxHelper(currentBoard, depth + 1, true));
                        currentBoard[i][j] = "";
                    }
                }
            }
        }

        return score;
    }

    private boolean checkForWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                return true;
            }
            if (!board[0][i].isEmpty() && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                return true;
            }
        }
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            return true;
        }
        return !board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]);
    }

    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void handleGameOver(Stage stage) {
        if (checkForWinner()) {
            String winner = (player1Turn) ? PLAYER_X : PLAYER_O;
            disableAllButtonsExceptWinning();
            System.out.println("Player " + winner + " wins!");
            
            
            computerWinsCounter+=1;
            player2ScoreText.setText(Integer.toString(computerWinsCounter));
            stage.setScene(new Scene(new LosePaneMiniMax(stage,computerWinsCounter)));
            
            // You can add additional logic here based on the winner
        } else if (isBoardFull()) {
            System.out.println("It's a draw! No one wins.");
            // You can add additional logic here for a draw
            
         
            
        } else {
            // Computer wins if it's not the player's turn
            System.out.println("Computer wins!");
            disableAllButtonsExceptWinning();
            // You can add additional logic here for the computer winning
        }

        // Add any additional logic you want to execute when the game is over
    }

    private void resetGame() {
        // Implement the logic to reset the game
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "";
                Button button = (Button) boardGrid.getChildren().get(i * SIZE + j);
                button.setText("");
            }
        }
        player1Turn = true;
    }
}