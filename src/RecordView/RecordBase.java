package RecordView;

import SelectmodeView.SelectModeBase;
import com.google.gson.Gson;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.Views.login.loginBase;

public class RecordBase extends AnchorPane {

    protected final ImageView imageView;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button topLeftBtn;
    protected final Button topLeftBtn1;
    protected final Button topLeftBtn11;
    protected final Button topLeftBtn12;
    protected final Button topLeftBtn13;
    protected final Button topLeftBtn14;
    protected final Button topLeftBtn15;
    protected final Button topLeftBtn16;
    protected final Button topLeftBtn17;
    protected final Label label;
    protected final Label PlayerNameLabel;
    protected final FontAwesomeIcon arrow;
boolean turnX=true;
         Stage stage;
        String stepsArray;
        public RecordBase(Stage stage,String stepsArray) {
        this.stage=stage;
        this.stepsArray=stepsArray;
          arrow = new FontAwesomeIcon();
        ArrayList<Double> steps= new Gson().fromJson(stepsArray,ArrayList.class);
        System.out.println(steps.toString());
        ArrayList<Integer> intSteps=new ArrayList<Integer>();
        
        for(double step:steps)
        {
            intSteps.add((int) step);
        }
        imageView = new ImageView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        topLeftBtn = new Button();
        topLeftBtn1 = new Button();
        topLeftBtn11 = new Button();
        topLeftBtn12 = new Button();
        topLeftBtn13 = new Button();
        topLeftBtn14 = new Button();
        topLeftBtn15 = new Button();
        topLeftBtn16 = new Button();
        topLeftBtn17 = new Button();
        label = new Label();
        PlayerNameLabel = new Label();
        
            Timeline timeline = new Timeline();
            int delayInSeconds = 1;

            for (int i = 0; i < intSteps.size(); i++) {
                int step = intSteps.get(i);
                KeyFrame key = new KeyFrame(Duration.seconds(delayInSeconds), (event) -> {
                    Button button;
                    if (turnX) {
                        switch (step) {
                            case 0:
                                button = topLeftBtn17;
                                break;
                            case 1:
                                button = topLeftBtn14;
                                break;
                            case 2:
                                button = topLeftBtn13;
                                break;
                            case 3:
                                button = topLeftBtn12;
                                break;
                            case 4:
                                button = topLeftBtn1;
                                break;
                            case 5:
                                button = topLeftBtn16;
                                break;
                            case 6:
                                button = topLeftBtn11;
                                break;
                            case 7:
                                button = topLeftBtn;
                                break;
                            case 8:
                                button = topLeftBtn15;
                                break;
                            default:
                                return;
                        }
                    } else {
                        switch (step) {
                            case 0:
                                button = topLeftBtn17;
                                break;
                            case 1:
                                button = topLeftBtn14;
                                break;
                            case 2:
                                button = topLeftBtn13;
                                break;
                            case 3:
                                button = topLeftBtn12;
                                break;
                            case 4:
                                button = topLeftBtn1;
                                break;
                            case 5:
                                button = topLeftBtn16;
                                break;
                            case 6:
                                button = topLeftBtn11;
                                break;
                            case 7:
                                button = topLeftBtn;
                                break;
                            case 8:
                                button = topLeftBtn15;
                                break;
                            default:
                                return;
                        }
                    }

                    if (turnX) {
                        button.setText("X");
                    } else {
                        button.setText("O");
                    }

                    turnX = !turnX;
                });

                timeline.getKeyFrames().add(key);
                delayInSeconds += 1;
            }

            timeline.setCycleCount(intSteps.size());
            timeline.play();
            
        setId("AnchorPane");
        setPrefHeight(642.0);
        setPrefWidth(1034.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/RecordView/record.css");

        imageView.setFitHeight(747.0);
        imageView.setFitWidth(1127.0);
        imageView.setLayoutX(-56.0);
        imageView.setLayoutY(-31.0);
        imageView.setImage(new Image(getClass().getResource("/assets/images/BackgroundImage.png").toExternalForm()));

        gridPane.setHgap(10.0);
        gridPane.setLayoutX(94.0);
        gridPane.setLayoutY(221.0);
        gridPane.setPrefHeight(373.0);
        gridPane.setPrefWidth(856.0);
        gridPane.setVgap(10.0);

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

        GridPane.setColumnIndex(topLeftBtn, 1);
        GridPane.setRowIndex(topLeftBtn, 2);
        topLeftBtn.setMnemonicParsing(false);
        topLeftBtn.setPrefHeight(113.0);
        topLeftBtn.setPrefWidth(286.0);

        GridPane.setColumnIndex(topLeftBtn1, 1);
        GridPane.setRowIndex(topLeftBtn1, 1);
        topLeftBtn1.setMnemonicParsing(false);
        topLeftBtn1.setPrefHeight(113.0);
        topLeftBtn1.setPrefWidth(286.0);

        GridPane.setRowIndex(topLeftBtn11, 2);
        topLeftBtn11.setMnemonicParsing(false);
        topLeftBtn11.setPrefHeight(113.0);
        topLeftBtn11.setPrefWidth(286.0);

        GridPane.setRowIndex(topLeftBtn12, 1);
        topLeftBtn12.setMnemonicParsing(false);
        topLeftBtn12.setPrefHeight(113.0);
        topLeftBtn12.setPrefWidth(286.0);

        GridPane.setColumnIndex(topLeftBtn13, 2);
        topLeftBtn13.setLayoutX(5.0);
        topLeftBtn13.setLayoutY(5.0);
        topLeftBtn13.setMnemonicParsing(false);
        topLeftBtn13.setPrefHeight(113.0);
        topLeftBtn13.setPrefWidth(286.0);

        GridPane.setColumnIndex(topLeftBtn14, 1);
        topLeftBtn14.setMnemonicParsing(false);
        topLeftBtn14.setPrefHeight(113.0);
        topLeftBtn14.setPrefWidth(286.0);

        GridPane.setColumnIndex(topLeftBtn15, 2);
        GridPane.setRowIndex(topLeftBtn15, 2);
        topLeftBtn15.setMnemonicParsing(false);
        topLeftBtn15.setPrefHeight(113.0);
        topLeftBtn15.setPrefWidth(286.0);

        GridPane.setColumnIndex(topLeftBtn16, 2);
        GridPane.setRowIndex(topLeftBtn16, 1);
        topLeftBtn16.setMnemonicParsing(false);
        topLeftBtn16.setPrefHeight(113.0);
        topLeftBtn16.setPrefWidth(286.0);

        topLeftBtn17.setMnemonicParsing(false);
        topLeftBtn17.setPrefHeight(113.0);
        topLeftBtn17.setPrefWidth(286.0);

//        label.setAlignment(javafx.geometry.Pos.CENTER);
//        label.setLayoutX(420.0);
//        label.setLayoutY(14.0);
//        label.setPrefHeight(75.0);
//        label.setPrefWidth(636.0);
//        label.setText("Your Record with");
//        label.setTextFill(javafx.scene.paint.Color.valueOf("#da12b5"));
//        label.setFont(new Font("Arial Black", 51.0));
//
//        PlayerNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
//        PlayerNameLabel.setLayoutX(430.0);
//        PlayerNameLabel.setLayoutY(89.0);
//        PlayerNameLabel.setPrefHeight(75.0);
//        PlayerNameLabel.setPrefWidth(636.0);
//        PlayerNameLabel.setText("PlayerName");
//        PlayerNameLabel.setTextFill(javafx.scene.paint.Color.valueOf("#da12b5"));
//        PlayerNameLabel.setFont(new Font("Arial Black", 51.0));

        getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getChildren().add(topLeftBtn);
        gridPane.getChildren().add(topLeftBtn1);
        gridPane.getChildren().add(topLeftBtn11);
        gridPane.getChildren().add(topLeftBtn12);
        gridPane.getChildren().add(topLeftBtn13);
        gridPane.getChildren().add(topLeftBtn14);
        gridPane.getChildren().add(topLeftBtn15);
        gridPane.getChildren().add(topLeftBtn16);
        gridPane.getChildren().add(topLeftBtn17);
        
        
        
        arrow.setLayoutX(
                15);
        arrow.setLayoutY(
                115.0);
        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);

        arrow.setSize(
                "7em");
        arrow.setId(
                "arrow");
        arrow.scaleXProperty()
                .add(1);
        arrow.scaleYProperty()
                .add(1);
        arrow.scaleZProperty()
                .add(1);

        arrow.setOnMouseClicked(
                new EventHandler() {

            @Override
            public void handle(Event event
            ) {
                Parent root = new loginBase(stage);
                Scene scene = new Scene(root, 1000, 700);
                stage.setScene(scene);
                stage.show();
            }
        }
        );
        
          topLeftBtn.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn1.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn11.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn12.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn13.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn14.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn15.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn16.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");
        topLeftBtn17.setStyle("-fx-background-color: #d7049e; -fx-text-fill: white;");

        getChildren().add(gridPane);
        getChildren().add(label);
        getChildren().add(PlayerNameLabel);
         getChildren() .add(arrow);

    }

}
