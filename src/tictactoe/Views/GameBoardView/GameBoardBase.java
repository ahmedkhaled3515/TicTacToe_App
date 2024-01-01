package tictactoe.Views;

import java.util.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import tictactoe.TicTacToe;

public  class GameBoardBase extends AnchorPane {

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
    boolean flag;

    public GameBoardBase(TicTacToe mainApp) {

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
        Button[][] buttons={{but00,but01,but02},{but10,but11,but12},{but20,but21,but22}};
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                buttons[i][j].getStyleClass().add("x");
                buttons[i][j].setOnAction(new buttonHandler());
            }
        }
        

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
        getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        boardGrid.getStyleClass().add("board");
        score1Pane.getStyleClass().add("score1");
        score2Pane.getStyleClass().add("score2");
        drawPane.getStyleClass().add("draw");
        newButton.getStyleClass().add("buttons");
        exitButton.getStyleClass().add("buttons");
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

        GridPane.setColumnIndex(but01, 1);
        but01.setMnemonicParsing(false);
        but01.setPrefHeight(200.0);
        but01.setPrefWidth(255.0);

        GridPane.setColumnIndex(but02, 2);
        but02.setMnemonicParsing(false);
        but02.setPrefHeight(144.0);
        but02.setPrefWidth(215.0);

        GridPane.setRowIndex(but10, 1);
        but10.setMnemonicParsing(false);
        but10.setPrefHeight(123.0);
        but10.setPrefWidth(212.0);

        GridPane.setColumnIndex(but11, 1);
        GridPane.setRowIndex(but11, 1);
        but11.setMnemonicParsing(false);
        but11.setPrefHeight(139.0);
        but11.setPrefWidth(260.0);

        GridPane.setColumnIndex(but12, 2);
        GridPane.setRowIndex(but12, 1);
        but12.setMnemonicParsing(false);
        but12.setPrefHeight(139.0);
        but12.setPrefWidth(242.0);

        GridPane.setRowIndex(but20, 2);
        but20.setMnemonicParsing(false);
        but20.setPrefHeight(127.0);
        but20.setPrefWidth(234.0);

        GridPane.setColumnIndex(but21, 1);
        GridPane.setRowIndex(but21, 2);
        but21.setMnemonicParsing(false);
        but21.setPrefHeight(196.0);
        but21.setPrefWidth(192.0);

        GridPane.setColumnIndex(but22, 2);
        GridPane.setRowIndex(but22, 2);
        but22.setMnemonicParsing(false);
        but22.setPrefHeight(161.0);
        but22.setPrefWidth(220.0);

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

        BorderPane.setAlignment(score2CountText, javafx.geometry.Pos.CENTER);
        score2CountText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        score2CountText.setStrokeWidth(0.0);
        score2CountText.setText("0");
        score2CountText.setFont(new Font("Arial Bold", 36.0));
        score2Pane.setCenter(score2CountText);

        BorderPane.setAlignment(text1, javafx.geometry.Pos.CENTER);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Player 2");
        text1.setFont(new Font("Arial Bold", 18.0));
        BorderPane.setMargin(text1, new Insets(5.0, 0.0, 0.0, 0.0));
        score2Pane.setTop(text1);

        newButton.setLayoutX(352.0);
        newButton.setLayoutY(552.0);
        newButton.setMnemonicParsing(false);
        newButton.setPrefHeight(60.0);
        newButton.setPrefWidth(130.0);
        newButton.setText("New game");
        newButton.setFont(new Font("Arial Bold", 14.0));
        newButton.setOpaqueInsets(new Insets(0.0));

        exitButton.setLayoutX(528.0);
        exitButton.setLayoutY(552.0);
        exitButton.setMnemonicParsing(false);
        exitButton.setPrefHeight(60.0);
        exitButton.setPrefWidth(130.0);
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

    }
    public class buttonHandler implements EventHandler<ActionEvent>
    {

        @Override
        public void handle(ActionEvent event) {
            Button button = (Button) event.getSource();
            if(button.getText().isEmpty())
            {
               if(flag)
                {
                    button.setText("X");
                    button.getStyleClass().add("x");
                    flag=false;
                }
                else
                {
                    button.setText("O");
                    button.getStyleClass().add("o");
                    flag=true;
                } 
            }
            
            
        }
        
    }
}
