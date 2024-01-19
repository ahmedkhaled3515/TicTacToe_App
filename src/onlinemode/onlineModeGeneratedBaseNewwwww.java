package onlinemode;

import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class onlineModeGeneratedBaseNewwwww extends AnchorPane {

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
    protected final Text player1ScoreTxt;
    protected final BorderPane borderPane0;
    protected final Text drawTxt;
    protected final Text drawScoreTxt;
    protected final BorderPane borderPane1;
    protected final Text player2Txt;
    protected final Text player2ScoreTxt;
    protected final Button newGameBtn;
    protected final Button menueBtn;
    protected final Label player1Label;
    protected final Label player2Label;
    protected final ImageView imageView0;
    protected final ImageView imageView1;

    public onlineModeGeneratedBaseNewwwww() {

        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        topLeftBtn = new Button();
        topBtn = new Button();
        topRightBtn = new Button();
        centerLeftBtn = new Button();
        centerBtn = new Button();
        centerRightBtn = new Button();
        downLeftBtn = new Button();
        downBtn = new Button();
        downRightBtn = new Button();
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
        player1Label = new Label();
        player2Label = new Label();
        imageView0 = new ImageView();
        imageView1 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(672.0);
        setPrefWidth(944.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/onlinemode/onlinemode.css");

        imageView.setFitHeight(672.0);
        imageView.setFitWidth(992.0);
        imageView.setImage(new Image(getClass().getResource("../../../../gaming-blank-banner-background_23-2150390423.jpg").toExternalForm()));

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

        GridPane.setColumnIndex(topBtn, 1);
        topBtn.setMnemonicParsing(false);
        topBtn.setPrefHeight(102.0);
        topBtn.setPrefWidth(178.0);

        GridPane.setColumnIndex(topRightBtn, 2);
        topRightBtn.setMnemonicParsing(false);
        topRightBtn.setPrefHeight(102.0);
        topRightBtn.setPrefWidth(178.0);

        GridPane.setRowIndex(centerLeftBtn, 1);
        centerLeftBtn.setMnemonicParsing(false);
        centerLeftBtn.setPrefHeight(102.0);
        centerLeftBtn.setPrefWidth(178.0);

        GridPane.setColumnIndex(centerBtn, 1);
        GridPane.setRowIndex(centerBtn, 1);
        centerBtn.setMnemonicParsing(false);
        centerBtn.setPrefHeight(102.0);
        centerBtn.setPrefWidth(178.0);

        GridPane.setColumnIndex(centerRightBtn, 2);
        GridPane.setRowIndex(centerRightBtn, 1);
        centerRightBtn.setMnemonicParsing(false);
        centerRightBtn.setPrefHeight(102.0);
        centerRightBtn.setPrefWidth(178.0);

        GridPane.setRowIndex(downLeftBtn, 2);
        downLeftBtn.setMnemonicParsing(false);
        downLeftBtn.setPrefHeight(102.0);
        downLeftBtn.setPrefWidth(178.0);

        GridPane.setColumnIndex(downBtn, 1);
        GridPane.setRowIndex(downBtn, 2);
        downBtn.setMnemonicParsing(false);
        downBtn.setPrefHeight(102.0);
        downBtn.setPrefWidth(178.0);

        GridPane.setColumnIndex(downRightBtn, 2);
        GridPane.setRowIndex(downRightBtn, 2);
        downRightBtn.setMnemonicParsing(false);
        downRightBtn.setPrefHeight(102.0);
        downRightBtn.setPrefWidth(178.0);

        gridPane0.setLayoutX(301.0);
        gridPane0.setLayoutY(57.0);
        gridPane0.setPrefHeight(111.0);
        gridPane0.setPrefWidth(404.0);

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

        BorderPane.setAlignment(player1Txt, javafx.geometry.Pos.CENTER);
        player1Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Txt.setStrokeWidth(0.0);
        player1Txt.setText("Player 1");
        borderPane.setTop(player1Txt);

        BorderPane.setAlignment(player1ScoreTxt, javafx.geometry.Pos.CENTER);
        player1ScoreTxt.setLayoutX(100.0);
        player1ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1ScoreTxt.setStrokeWidth(0.0);
        player1ScoreTxt.setText("0");
        borderPane.setCenter(player1ScoreTxt);
        GridPane.setMargin(borderPane, new Insets(0.0, 5.0, 0.0, 0.0));

        GridPane.setColumnIndex(borderPane0, 1);
        borderPane0.setPrefHeight(111.0);
        borderPane0.setPrefWidth(119.0);

        BorderPane.setAlignment(drawTxt, javafx.geometry.Pos.CENTER);
        drawTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawTxt.setStrokeWidth(0.0);
        drawTxt.setText("Draw");
        borderPane0.setTop(drawTxt);

        BorderPane.setAlignment(drawScoreTxt, javafx.geometry.Pos.CENTER);
        drawScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawScoreTxt.setStrokeWidth(0.0);
        drawScoreTxt.setText("0");
        borderPane0.setCenter(drawScoreTxt);
        GridPane.setMargin(borderPane0, new Insets(0.0, 5.0, 0.0, 5.0));

        GridPane.setColumnIndex(borderPane1, 2);
        borderPane1.setPrefHeight(111.0);
        borderPane1.setPrefWidth(119.0);

        BorderPane.setAlignment(player2Txt, javafx.geometry.Pos.CENTER);
        player2Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Txt.setStrokeWidth(0.0);
        player2Txt.setText("Player 2");
        borderPane1.setTop(player2Txt);

        BorderPane.setAlignment(player2ScoreTxt, javafx.geometry.Pos.CENTER);
        player2ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2ScoreTxt.setStrokeWidth(0.0);
        player2ScoreTxt.setText("0");
        borderPane1.setCenter(player2ScoreTxt);
        GridPane.setMargin(borderPane1, new Insets(0.0, 5.0, 0.0, 5.0));

        newGameBtn.setLayoutX(320.0);
        newGameBtn.setLayoutY(560.0);
        newGameBtn.setMnemonicParsing(false);
        newGameBtn.setPrefHeight(48.0);
        newGameBtn.setPrefWidth(155.0);
        newGameBtn.setText("New Game");

        menueBtn.setLayoutX(572.0);
        menueBtn.setLayoutY(560.0);
        menueBtn.setMnemonicParsing(false);
        menueBtn.setPrefHeight(48.0);
        menueBtn.setPrefWidth(155.0);
        menueBtn.setText("Main Menue");

        player1Label.setLayoutX(78.0);
        player1Label.setLayoutY(358.0);
        player1Label.setText("Player1");
        player1Label.setFont(new Font(30.0));

        player2Label.setLayoutX(825.0);
        player2Label.setLayoutY(358.0);
        player2Label.setText("Player 2");
        player2Label.setFont(new Font(30.0));

        imageView0.setFitHeight(117.0);
        imageView0.setFitWidth(119.0);
        imageView0.setLayoutX(58.0);
        imageView0.setLayoutY(222.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("../../../../../Downloads/icons8-player-64.png").toExternalForm()));

        imageView1.setFitHeight(111.0);
        imageView1.setFitWidth(117.0);
        imageView1.setLayoutX(822.0);
        imageView1.setLayoutY(225.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("../../../../../Downloads/icons8-anonymous-64.png").toExternalForm()));

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

    }
}
