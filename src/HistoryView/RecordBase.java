package HistoryView;

import Requests.App;
import Requests.Message;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

public abstract class RecordBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView image;
    protected final Label label;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Label IDLabel;
    protected final Label StatusLabel;
    protected final Label NameLabel;
    protected final Label ID1;
    protected final Label label0;
    protected final Label Ststus1;
    protected final Label ID2;
    protected final Label Name2;
    protected final Label Status2;
    protected final Button btn1;
    protected final Button btn2;

    public RecordBase() {

        anchorPane = new AnchorPane();
        image = new ImageView();
        label = new Label();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        IDLabel = new Label();
        StatusLabel = new Label();
        NameLabel = new Label();
        ID1 = new Label();
        label0 = new Label();
        Ststus1 = new Label();
        ID2 = new Label();
        Name2 = new Label();
        Status2 = new Label();
        btn1 = new Button();
        btn2 = new Button();
        
        App.startConnection();
        Message msg= new Message();
        msg.setType("showRec");
        String request=App.gson.toJson(msg);
        App.output.println(request);
        App.output.flush();

        setId("AnchorPane");
        setPrefHeight(642.0);
        setPrefWidth(1034.0);

        anchorPane.setLayoutX(-3.0);
        anchorPane.setLayoutY(-2.0);
        anchorPane.setPrefHeight(649.0);
        anchorPane.setPrefWidth(1034.0);

        image.setFitHeight(656.0);
        image.setFitWidth(1054.0);
        image.setLayoutX(-7.0);
        image.setImage(new Image(getClass().getResource("../../../../../Downloads/WhatsApp%20Image%202023-12-28%20at%203.56.37%20PM.jpeg").toExternalForm()));

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label.setLayoutX(317.0);
        label.setLayoutY(-1.0);
        label.setPrefHeight(66.0);
        label.setPrefWidth(581.0);
        label.setStyle("-fx-background-radius: 26px;");
        label.setText("Your History");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#c76ad3"));
        label.setFont(new Font("Arial Black", 64.0));

        gridPane.setLayoutX(37.0);
        gridPane.setLayoutY(119.0);
        gridPane.setPrefHeight(336.0);
        gridPane.setPrefWidth(720.0);
        gridPane.setStyle("-fx-opacity: 90%;");
        gridPane.setVgap(20.0);

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

        IDLabel.setAlignment(javafx.geometry.Pos.CENTER);
        IDLabel.setPrefHeight(71.0);
        IDLabel.setPrefWidth(245.0);
        IDLabel.setStyle("-fx-background-color: #43115b;");
        IDLabel.setText("ID");
        IDLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        IDLabel.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(StatusLabel, 2);
        StatusLabel.setAlignment(javafx.geometry.Pos.CENTER);
        StatusLabel.setPrefHeight(37.0);
        StatusLabel.setPrefWidth(236.0);
        StatusLabel.setStyle("-fx-background-color: #43115b;");
        StatusLabel.setText("Status");
        StatusLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        StatusLabel.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(NameLabel, 1);
        NameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        NameLabel.setPrefHeight(71.0);
        NameLabel.setPrefWidth(250.0);
        NameLabel.setStyle("-fx-background-color: #43115b;");
        NameLabel.setText("Name");
        NameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        NameLabel.setFont(new Font("Arial Black", 48.0));

        GridPane.setRowIndex(ID1, 1);
        ID1.setAlignment(javafx.geometry.Pos.CENTER);
        ID1.setPrefHeight(71.0);
        ID1.setPrefWidth(245.0);
        ID1.setStyle("-fx-background-color: #43115b;");
        ID1.setText("1");
        ID1.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        ID1.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(label0, 1);
        GridPane.setRowIndex(label0, 1);
        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setPrefHeight(71.0);
        label0.setPrefWidth(250.0);
        label0.setStyle("-fx-background-color: #43115b;");
        label0.setText("Amer");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        label0.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(Ststus1, 2);
        GridPane.setRowIndex(Ststus1, 1);
        Ststus1.setAlignment(javafx.geometry.Pos.CENTER);
        Ststus1.setPrefHeight(37.0);
        Ststus1.setPrefWidth(236.0);
        Ststus1.setStyle("-fx-background-color: #43115b;");
        Ststus1.setText("Win");
        Ststus1.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        Ststus1.setFont(new Font("Arial Black", 48.0));

        GridPane.setRowIndex(ID2, 2);
        ID2.setAlignment(javafx.geometry.Pos.CENTER);
        ID2.setPrefHeight(71.0);
        ID2.setPrefWidth(245.0);
        ID2.setStyle("-fx-background-color: #43115b;");
        ID2.setText("2");
        ID2.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        ID2.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(Name2, 1);
        GridPane.setRowIndex(Name2, 2);
        Name2.setAlignment(javafx.geometry.Pos.CENTER);
        Name2.setPrefHeight(71.0);
        Name2.setPrefWidth(250.0);
        Name2.setStyle("-fx-background-color: #43115b;");
        Name2.setText("Asmaa");
        Name2.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        Name2.setFont(new Font("Arial Black", 48.0));

        GridPane.setColumnIndex(Status2, 2);
        GridPane.setRowIndex(Status2, 2);
        Status2.setAlignment(javafx.geometry.Pos.CENTER);
        Status2.setPrefHeight(37.0);
        Status2.setPrefWidth(236.0);
        Status2.setStyle("-fx-background-color: #43115b;");
        Status2.setText("Lose");
        Status2.setTextFill(javafx.scene.paint.Color.valueOf("#fffeff"));
        Status2.setFont(new Font("Arial Black", 48.0));

        btn1.setLayoutX(781.0);
        btn1.setLayoutY(252.0);
        btn1.setMaxHeight(Double.MAX_VALUE);
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn1.setMinHeight(USE_PREF_SIZE);
        btn1.setMinWidth(USE_PREF_SIZE);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(71.0);
        btn1.setPrefWidth(219.0);
        btn1.setStyle("-fx-background-color: #43115b; -fx-background-radius: 26px;");
        btn1.setText("Show");
        btn1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn1.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        btn1.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btn1.setFont(new Font("Arial Black", 36.0));
        btn1.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));

        btn2.setLayoutX(773.0);
        btn2.setLayoutY(370.0);
        btn2.setMaxHeight(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn2.setMinHeight(USE_PREF_SIZE);
        btn2.setMinWidth(USE_PREF_SIZE);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(71.0);
        btn2.setPrefWidth(219.0);
        btn2.setStyle("-fx-background-color: #43115b; -fx-background-radius: 26px;");
        btn2.setText("Show");
        btn2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn2.setTextFill(javafx.scene.paint.Color.valueOf("#f2f2f2"));
        btn2.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btn2.setFont(new Font("Arial Black", 36.0));
        btn2.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));

        anchorPane.getChildren().add(image);
        anchorPane.getChildren().add(label);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(IDLabel);
        gridPane.getChildren().add(StatusLabel);
        gridPane.getChildren().add(NameLabel);
        gridPane.getChildren().add(ID1);
        gridPane.getChildren().add(label0);
        gridPane.getChildren().add(Ststus1);
        gridPane.getChildren().add(ID2);
        gridPane.getChildren().add(Name2);
        gridPane.getChildren().add(Status2);
        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(btn1);
        anchorPane.getChildren().add(btn2);
        getChildren().add(anchorPane);

    }
}
