package HomeView;

import java.net.URL;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class homeBase extends AnchorPane {

    protected final BorderPane borderPane;
    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane0;
    protected final Button button;

    public homeBase() {

        borderPane = new BorderPane();
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        anchorPane0 = new AnchorPane();
        button = new Button();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/HomeView/home.css");

        borderPane.setLayoutX(-1.0);
        borderPane.setPrefHeight(634.0);
        borderPane.setPrefWidth(1034.0);

        BorderPane.setAlignment(anchorPane, javafx.geometry.Pos.CENTER);
        anchorPane.setPrefHeight(200.0);
        anchorPane.setPrefWidth(200.0);

        imageView.setFitHeight(634.0);
        imageView.setFitWidth(1033.0);
        imageView.setLayoutX(1.0);
        imageView.setStyle("-fx-background-radius: 100px;");
        imageView.setImage(new Image(getClass().getResource("WhatsApp Image 2023-12-28 at 3.56.37 PM.jpeg").toExternalForm()));

        anchorPane0.setLayoutX(500.0);
        anchorPane0.setLayoutY(355.0);
        anchorPane0.setPrefHeight(157.0);
        anchorPane0.setPrefWidth(434.0);

        button.setLayoutX(14.0);
        button.setLayoutY(8.0);
        button.setMnemonicParsing(false);
        button.setPrefHeight(133.0);
        button.setPrefWidth(440.0);
        //button.setStyle("-fx-background-color: #72CFF9; -fx-background-radius: 26;");
        button.setText("Let’s Play");
        button.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        button.setTextFill(javafx.scene.paint.Color.valueOf("#5a1e76"));
        button.setFont(new Font("Arial Black", 65.0));
        borderPane.setCenter(anchorPane);

        anchorPane.getChildren().add(imageView);
        anchorPane0.getChildren().add(button);
        anchorPane.getChildren().add(anchorPane0);
        getChildren().add(borderPane);

    }
}
