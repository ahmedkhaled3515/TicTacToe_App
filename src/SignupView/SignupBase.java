package SignupView;

//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.net.URL;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class SignupBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView image;
    protected final TextField user;
    protected final Button online;
    protected final TextField mail;
    protected final TextField password;
//    protected final FontAwesomeIcon arrow;

    public SignupBase() {

        imageView = new ImageView();
        image = new ImageView();
        user = new TextField();
        online = new Button();
        mail = new TextField();
        password = new TextField();
//        arrow = new FontAwesomeIcon();

        setId("AnchorPane");
        setPrefHeight(634.0);
        setPrefWidth(1034.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/SignupView/signup.css");

        imageView.setFitHeight(737.0);
        imageView.setFitWidth(1076.0);
        imageView.setLayoutX(-39.0);
        imageView.setLayoutY(-100.0);
        imageView.setImage(new Image(getClass().getResource("WhatsApp Image 2023-12-28 at 3.56.37 PM.jpeg").toExternalForm()));

        image.setFitHeight(118.0);
        image.setFitWidth(298.0);
        image.setLayoutX(733.0);
        image.setLayoutY(14.0);
        image.setImage(new Image(getClass().getResource("WhatsApp Image 2023-12-29 at 9.13.24 PM.jpeg").toExternalForm()));

        user.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        user.setId("user");
        user.setLayoutX(302.0);
        user.setLayoutY(197.0);
        user.setPrefHeight(76.0);
        user.setPrefWidth(599.0);
        user.setPromptText("User-name");
        user.setStyle("-fx-background-color: BCDBF9; -fx-background-radius: 26px;");
        user.setFont(new Font("Arial Black", 59.0));
        user.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));
        user.setOpaqueInsets(new Insets(0.0));
        user.setFocusTraversable(false);

        online.setLayoutX(453.0);
        online.setLayoutY(525.0);
        online.setMaxHeight(Double.MAX_VALUE);
        online.setMaxWidth(Double.MAX_VALUE);
        online.setMinHeight(USE_PREF_SIZE);
        online.setMinWidth(USE_PREF_SIZE);
        online.setMnemonicParsing(false);
        online.setPrefHeight(81.0);
        online.setPrefWidth(254.0);
       // online.setStyle("-fx-background-color: BCDBF9; -fx-background-radius: 26px;");
        online.setText("Signup");
        online.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        online.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        online.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        online.setFont(new Font("Arial Black", 47.0));
        online.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        online.setId("online");
        

        mail.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        mail.setId("mail");
        mail.setLayoutX(302.0);
        mail.setLayoutY(309.0);
        mail.setPrefHeight(76.0);
        mail.setPrefWidth(599.0);
        mail.setPromptText("e-mail");
        mail.setStyle("-fx-background-color: BCDBF9; -fx-background-radius: 26px; -fx-text-alignment: center;");
        mail.setFont(new Font("Arial Black", 59.0));
        mail.setOpaqueInsets(new Insets(0.0));
        mail.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));
        mail.setOpaqueInsets(new Insets(0.0));

        password.setAlignment(javafx.geometry.Pos.TOP_CENTER);
        password.setId("password");
        password.setLayoutX(302.0);
        password.setLayoutY(419.0);
        password.setPrefHeight(74.0);
        password.setPrefWidth(599.0);
        password.setPromptText("password");
        password.setStyle("-fx-background-color: BCDBF9; -fx-background-radius: 26px;");
        password.setFont(new Font("Arial Black", 59.0));
        password.setPadding(new Insets(0.0, 0.0, 0.0, 0.0));
        password.setOpaqueInsets(new Insets(0.0));

//        arrow.setLayoutX(22.0);
//        arrow.setLayoutY(96.0);
//        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);
//        arrow.setSize("7em");
//        arrow.setId("arrow");
//        arrow.scaleXProperty().add(1);
//        arrow.scaleYProperty().add(1);
//        arrow.scaleZProperty().add(1);

        getChildren().add(imageView);
        getChildren().add(image);
        getChildren().add(user);
        getChildren().add(online);
        getChildren().add(mail);
        getChildren().add(password);
//        getChildren().add(arrow);

    }
}
