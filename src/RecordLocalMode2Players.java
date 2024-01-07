
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.Views.LocalMode2Players.GameBoardBase2Players;

public abstract class RecordLocalMode2Players extends AnchorPane implements Runnable{

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
    protected final Text playerTurn;
    int integarForCastingString;
    boolean flag0 = true;
    boolean flag1 = false;
    boolean flag2 = false;
    boolean flag3 = false;
    boolean flag4 = false;
    boolean flag5 = false;
    boolean flag6 = false;
    boolean flag7 = false;
    boolean flag8 = false;
    
    public RecordLocalMode2Players(Stage stage) {
        
       
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
        playerTurn = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1000.0);
        backgroundImage.setImage(new Image(getClass().getResource("../../resources/images/background.jpg").toExternalForm()));

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

        exitButton.setLayoutX(528.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(130.0);
        exitButton.setStyle("-fx-background-radius: 15;");
        exitButton.setText("Exit");
        exitButton.setFont(new Font("Arial Bold", 14.0));

        playerTurn.setLayoutX(760.0);
        playerTurn.setLayoutY(377.0);
        playerTurn.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        playerTurn.setStrokeWidth(0.0);
        playerTurn.setText("Player's Turn");
        playerTurn.setFont(new Font(36.0));

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
        getChildren().add(playerTurn);

    }
    
        public void init(){
            Thread th=new Thread(this);
            th.start();
	}
    	public void run(){
		while(true){
			try{
                            
//                            saveXOMovements[0][2][0]="o";
//                        saveXOMovements[0][2][1]=Integer.toString(movementCounter);



                                for(int row=0; row<3; row++){
                                    for(int col=0; col<3; col++){
                                        for(int z=0; z<9; z++){
                                            
                                        }
                                        
                                            
                                                
                                        }
                                    }
                            Thread.sleep(1000);
                                
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
    
    
    
}
