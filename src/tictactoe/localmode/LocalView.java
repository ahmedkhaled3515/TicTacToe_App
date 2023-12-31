package tictactoe.localmode;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public  class LocalView extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundimage;
    protected final Text titletoe;
    protected final Button startbutton;
    protected final TextField playerOneName;
    protected final TextField playerTwoName;
    protected final ImageView imageView;

    public LocalView() {

        anchorPane = new AnchorPane();
        backgroundimage = new ImageView();
        titletoe = new Text();
        startbutton = new Button();
        playerOneName = new TextField();
        playerTwoName = new TextField();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        anchorPane.setPrefHeight(700.0);
        anchorPane.setPrefWidth(1000.0);

        backgroundimage.setFitHeight(708.0);
        backgroundimage.setFitWidth(1000.0);
        backgroundimage.setLayoutY(-1.0);
        backgroundimage.setImage(new Image(getClass().getResource("background.jpg").toExternalForm()));

        titletoe.setFill(javafx.scene.paint.Color.valueOf("#c5a0d7"));
        titletoe.setLayoutX(648.0);
        titletoe.setLayoutY(155.0);
        titletoe.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        titletoe.setStrokeWidth(0.0);
        titletoe.setText("tic.tac.toe.");
        titletoe.setWrappingWidth(242.6708984375);
        titletoe.setFont(new Font("System Bold", 39.0));

        startbutton.setId("buttonstyles");
        startbutton.setLayoutX(658.0);
        startbutton.setLayoutY(471.0);
        startbutton.setMnemonicParsing(false);
        startbutton.setPrefHeight(23.0);
        startbutton.setPrefWidth(257.0);
        startbutton.setStyle("-fx-background-color: C5A0D7; -fx-background-radius: 90;");
        startbutton.setText("start");
        startbutton.setFont(new Font("Arial", 26.0));

        playerOneName.setLayoutX(669.0);
        playerOneName.setLayoutY(293.0);
        playerOneName.setPrefHeight(42.0);
        playerOneName.setPrefWidth(234.0);
        playerOneName.setPromptText("player one");
        playerOneName.setStyle("-fx-background-radius: 26 26 26 26;");
        playerOneName.setFont(new Font("System Bold", 19.0));

        playerTwoName.setLayoutX(664.0);
        playerTwoName.setLayoutY(382.0);
        playerTwoName.setPrefHeight(42.0);
        playerTwoName.setPrefWidth(234.0);
        playerTwoName.setPromptText("player two");
        playerTwoName.setStyle("-fx-background-radius: 26 26 26 26;");
        playerTwoName.setFont(new Font(19.0));

        imageView.setFitHeight(24.0);
        imageView.setFitWidth(99.0);
        imageView.setLayoutX(507.0);
        imageView.setLayoutY(78.0);
        imageView.setImage(new Image(getClass().getResource("arrowback.jpg").toExternalForm()));

        anchorPane.getChildren().add(backgroundimage);
        anchorPane.getChildren().add(titletoe);
        anchorPane.getChildren().add(startbutton);
        anchorPane.getChildren().add(playerOneName);
        anchorPane.getChildren().add(playerTwoName);
        anchorPane.getChildren().add(imageView);
        getChildren().add(anchorPane);

    }
}
