package SelectmodeView;


//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;


//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
//import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;

import HomeView.homeBase;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;

import java.net.URL;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.Views.login.loginBase;
import tictactoe.localmode.LocalViewBase;
import tictactoe.machineView.MachineViewBase;

public class SelectModeBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane0;
    protected final Button local;
    protected final Button computer;
    protected final Button online;
    protected final AnchorPane anchorPane1;
//    protected final FontAwesomeIcon user;
    protected final AnchorPane anchorPane2;
    protected final FontAwesomeIcon arrow;
  //  protected final FontAwesomeIcon user;
//    protected final AnchorPane anchorPane2;
  //  protected final FontAwesomeIcon arrow;
    Stage stage;
    public SelectModeBase(Stage stage) {
        this.stage=stage;
        anchorPane = new AnchorPane();
        imageView = new ImageView();
        anchorPane0 = new AnchorPane();
        local = new Button();
        computer = new Button();
        online = new Button();
        anchorPane1 = new AnchorPane();

    //    user = new FontAwesomeIcon();
        anchorPane2 = new AnchorPane();
        arrow = new FontAwesomeIcon();

        setId("AnchorPane");
        setPrefHeight(642.0);
        setPrefWidth(1034.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/SelectmodeView/selectmode.css");

        anchorPane.setPrefHeight(700);
        anchorPane.setPrefWidth(1000);

        imageView.setFitHeight(700.0);
        imageView.setFitWidth(1000.0);
//        imageView.setLayoutY(-94.0);
        imageView.setImage(new Image(getClass().getResource("WhatsApp Image 2023-12-28 at 3.56.37 PM.jpeg").toExternalForm()));

        anchorPane0.setLayoutX(549.0);
        anchorPane0.setLayoutY(290.0);
        anchorPane0.setPrefHeight(60.0);
        anchorPane0.setPrefWidth(300.0);

        local.setLayoutX(4.0);
        local.setLayoutY(2.0);
        local.setMaxHeight(Double.MAX_VALUE);
        local.setMaxWidth(Double.MAX_VALUE);
        local.setMinHeight(USE_PREF_SIZE);
        local.setMinWidth(USE_PREF_SIZE);
        local.setMnemonicParsing(false);
        local.setPrefHeight(89.0);
        local.setPrefWidth(410.0);
        //local.setStyle("-fx-background-color: #72CFF9; -fx-background-radius: 26px;");
        local.setText("Local");
        local.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        local.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        local.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        local.setFont(new Font("Arial Black", 55.0));
        local.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        local.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
//                Parent root = new LocalViewBase();
//                scene = new Scene(root);
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.setScene(scene);
//                stage.show();
            }
        });
        local.setId("local");

        computer.setLayoutX(549.0);
        computer.setLayoutY(396.0);
        computer.setMaxHeight(Double.MAX_VALUE);
        computer.setMaxWidth(Double.MAX_VALUE);
        computer.setMinHeight(USE_PREF_SIZE);
        computer.setMinWidth(USE_PREF_SIZE);
        computer.setMnemonicParsing(false);
        computer.setPrefHeight(89.0);
        computer.setPrefWidth(410.0);
      //  computer.setStyle("-fx-background-color: #72CFF9; -fx-background-radius: 26px;");
        computer.setText("Computer ");
        computer.setId("com");
        computer.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        computer.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        computer.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        computer.setFont(new Font("Arial Black", 55.0));
        computer.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        computer.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                stage.setScene(new Scene(new MachineViewBase(stage),1000,700));
            }
        });
                

        online.setLayoutX(549.0);
        online.setLayoutY(501.0);
        online.setMaxHeight(Double.MAX_VALUE);
        online.setMaxWidth(Double.MAX_VALUE);
        online.setMinHeight(USE_PREF_SIZE);
        online.setMinWidth(USE_PREF_SIZE);
        online.setMnemonicParsing(false);
        online.setPrefHeight(89.0);
        online.setPrefWidth(410.0);
        //online.setStyle("-fx-background-color: #72CFF9; -fx-background-radius: 26px;");
        online.setText("Online");
        online.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        online.setTextFill(javafx.scene.paint.Color.valueOf("#43115b"));
        online.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        online.setFont(new Font("Arial Black", 55.0));
        online.setPadding(new Insets(0.0, 0.0, 10.0, 0.0));
        online.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new loginBase() ;
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });
        online.setId("online");

        anchorPane1.setLayoutX(616.0);
        anchorPane1.setLayoutY(53.0);
        anchorPane1.setPrefHeight(200.0);
        anchorPane1.setPrefWidth(200.0);

/*
        user.setLayoutX(873.0);
        user.setLayoutY(143.0);
        user.setIcon(FontAwesomeIcons.USER);
        user.setSize("7em");
        user.setId("user");
       user.setLayoutX(950);
       user.setLayoutY(130);
       user.scaleXProperty().add(1);
       user.scaleYProperty().add(1);
       user.scaleZProperty().add(1);
*/
        anchorPane2.setLayoutX(50.0);
        anchorPane2.setPrefHeight(200.0);
        anchorPane2.setPrefWidth(200.0);
/*
        arrow.setLayoutX(-40.0);
        arrow.setLayoutY(115.0);
        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);
        arrow.setSize("7em");
        arrow.setId("arrow");
       arrow.scaleXProperty().add(1);
       arrow.scaleYProperty().add(1);
       arrow.scaleZProperty().add(1);

*/

       arrow.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new homeBase(stage) ;
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });


        anchorPane.getChildren().add(imageView);
        anchorPane0.getChildren().add(local);
        anchorPane.getChildren().add(anchorPane0);
        anchorPane.getChildren().add(computer);
        anchorPane.getChildren().add(online);
        anchorPane.getChildren().add(anchorPane1);

      //  anchorPane.getChildren().add(user);
      //  anchorPane2.getChildren().add(arrow);
        anchorPane.getChildren().add(anchorPane2);
        getChildren().add(anchorPane);

    }
}
