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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class onlineModeBase extends AnchorPane {

    protected final ImageView imageView;
    protected final FlowPane flowPane;
    protected final Button topLeftBtn;
    protected final Button topBtn;
    protected final Button topRightBtn;
    protected final Button centerRightBtn;
    protected final Button centerBtn;
    protected final Button centerLeftBtn;
    protected final Button downLeftBtn;
    protected final Button downBtn;
    protected final Button downRightBtn;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final BorderPane borderPane1;
    protected final Text player1Txt;
    protected final Text player1ScoreTxt;
    protected final BorderPane borderPane2;
    protected final Text drawTxt;
    protected final Text drawScoreTxt;
    protected final BorderPane borderPane3;
    protected final Text player2Txt;
    protected final Text player2ScoreTxt;
    protected final Button newGameBtn;
    protected final Button menueBtn;
    protected final Label player1Label;
    protected final Label player2Label;

    public onlineModeBase() {

        imageView = new ImageView();
        flowPane = new FlowPane();
        topLeftBtn = new Button();
        topBtn = new Button();
        topRightBtn = new Button();
        centerRightBtn = new Button();
        centerBtn = new Button();
        centerLeftBtn = new Button();
        downLeftBtn = new Button();
        downBtn = new Button();
        downRightBtn = new Button();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        borderPane1 = new BorderPane();
        player1Txt = new Text();
        player1ScoreTxt = new Text();
        borderPane2 = new BorderPane();
        drawTxt = new Text();
        drawScoreTxt = new Text();
        borderPane3 = new BorderPane();
        player2Txt = new Text();
        player2ScoreTxt = new Text();
        newGameBtn = new Button();
        menueBtn = new Button();
        player1Label = new Label();
        player2Label = new Label();

        setId("AnchorPane");
        setPrefHeight(672.0);
        setPrefWidth(944.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/onlinemode/onlinemode.css");

        imageView.setFitHeight(672.0);
        imageView.setFitWidth(992.0);
        imageView.setLayoutX(-8.0);
        imageView.setImage(new Image(getClass().getResource("BackgroundImage.png").toExternalForm()));

        flowPane.setLayoutX(253.0);
        flowPane.setLayoutY(177.0);
        flowPane.setPrefHeight(342.0);
        flowPane.setPrefWidth(544.0);

        topLeftBtn.setMnemonicParsing(false);
        topLeftBtn.setPrefHeight(114.0);
        topLeftBtn.setPrefWidth(180.0);

        topBtn.setMnemonicParsing(false);
        topBtn.setPrefHeight(114.0);
        topBtn.setPrefWidth(180.0);

        topRightBtn.setMnemonicParsing(false);
        topRightBtn.setPrefHeight(114.0);
        topRightBtn.setPrefWidth(180.0);

        centerRightBtn.setMnemonicParsing(false);
        centerRightBtn.setPrefHeight(114.0);
        centerRightBtn.setPrefWidth(180.0);

        centerBtn.setMnemonicParsing(false);
        centerBtn.setPrefHeight(114.0);
        centerBtn.setPrefWidth(180.0);

        centerLeftBtn.setMnemonicParsing(false);
        centerLeftBtn.setPrefHeight(114.0);
        centerLeftBtn.setPrefWidth(180.0);

        downLeftBtn.setMnemonicParsing(false);
        downLeftBtn.setPrefHeight(114.0);
        downLeftBtn.setPrefWidth(180.0);

        downBtn.setMnemonicParsing(false);
        downBtn.setPrefHeight(114.0);
        downBtn.setPrefWidth(180.0);

        downRightBtn.setMnemonicParsing(false);
        downRightBtn.setPrefHeight(114.0);
        downRightBtn.setPrefWidth(180.0);

        gridPane.setLayoutX(301.0);
        gridPane.setLayoutY(47.0);
        gridPane.setPrefHeight(114.0);
        gridPane.setPrefWidth(426.0);
        gridPane.setStyle("-fx-border-color: black;");

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

        borderPane1.setPrefHeight(112.0);
        borderPane1.setPrefWidth(167.0);
        borderPane1.setStyle("-fx-background-color: C5A0D7;");

        BorderPane.setAlignment(player1Txt, javafx.geometry.Pos.CENTER);
        player1Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Txt.setStrokeWidth(0.0);
        player1Txt.setText("Player1");
        borderPane1.setTop(player1Txt);

        BorderPane.setAlignment(player1ScoreTxt, javafx.geometry.Pos.CENTER);
        player1ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1ScoreTxt.setStrokeWidth(0.0);
        player1ScoreTxt.setText("0");
        borderPane1.setCenter(player1ScoreTxt);

        GridPane.setColumnIndex(borderPane2, 1);
        borderPane2.setPrefHeight(200.0);
        borderPane2.setPrefWidth(200.0);
        borderPane2.setStyle("-fx-background-color: C5A0D7;");

        BorderPane.setAlignment(drawTxt, javafx.geometry.Pos.CENTER);
        drawTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawTxt.setStrokeWidth(0.0);
        drawTxt.setText("Draw");
        borderPane2.setTop(drawTxt);

        BorderPane.setAlignment(drawScoreTxt, javafx.geometry.Pos.CENTER);
        drawScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawScoreTxt.setStrokeWidth(0.0);
        drawScoreTxt.setText("0");
        borderPane2.setCenter(drawScoreTxt);

        GridPane.setColumnIndex(borderPane3, 2);
        borderPane3.setPrefHeight(200.0);
        borderPane3.setPrefWidth(200.0);
        borderPane3.setStyle("-fx-background-color: C5A0D7;");
        borderPane3.setOpaqueInsets(new Insets(0.0, 20.0, 0.0, 0.0));

        BorderPane.setAlignment(player2Txt, javafx.geometry.Pos.CENTER);
        player2Txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Txt.setStrokeWidth(0.0);
        player2Txt.setText("Player2");
        borderPane3.setTop(player2Txt);

        BorderPane.setAlignment(player2ScoreTxt, javafx.geometry.Pos.CENTER);
        player2ScoreTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2ScoreTxt.setStrokeWidth(0.0);
        player2ScoreTxt.setText("0");
        borderPane3.setCenter(player2ScoreTxt);

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

        player1Label.setLayoutX(82.0);
        player1Label.setLayoutY(326.0);
        player1Label.setText("Player1");
        player1Label.setFont(new Font(30.0));

        player2Label.setLayoutX(835.0);
        player2Label.setLayoutY(326.0);
        player2Label.setText("Player 2");
        player2Label.setFont(new Font(30.0));

        getChildren().add(imageView);
        flowPane.getChildren().add(topLeftBtn);
        flowPane.getChildren().add(topBtn);
        flowPane.getChildren().add(topRightBtn);
        flowPane.getChildren().add(centerRightBtn);
        flowPane.getChildren().add(centerBtn);
        flowPane.getChildren().add(centerLeftBtn);
        flowPane.getChildren().add(downLeftBtn);
        flowPane.getChildren().add(downBtn);
        flowPane.getChildren().add(downRightBtn);
        getChildren().add(flowPane);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(borderPane1);
        gridPane.getChildren().add(borderPane2);
        gridPane.getChildren().add(borderPane3);
        getChildren().add(gridPane);
        getChildren().add(newGameBtn);
        getChildren().add(menueBtn);
        getChildren().add(player1Label);
        getChildren().add(player2Label);

    }
}
