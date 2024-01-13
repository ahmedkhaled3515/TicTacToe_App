package SignupView;

import HomeView.homeBase;
import Requests.App;
import Requests.Mail;
import Requests.Message;
import com.google.gson.Gson;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.GroupLayout;
import onlinemode.onlineModeGeneratedBase;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tictactoe.Views.login.loginBase;

public class SignupBase extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView image;
    protected final TextField user;
    protected final Button online;
    protected final TextField mail;
    protected final TextField password;
    protected final FontAwesomeIcon arrow;
    protected final TextField returnedMsg;
    Gson gson;
    Label headLabel;
    public SignupBase(Stage stage) {
        returnedMsg = new TextField();
        imageView = new ImageView();
        image = new ImageView();
        user = new TextField();
        online = new Button();
        mail = new TextField();
        password = new TextField();
        arrow = new FontAwesomeIcon();
        headLabel = new Label();
        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/SignupView/signup.css");
        getStylesheets().add(getClass().getResource("localstyle.css").toExternalForm());

        
        imageView.setFitHeight(700.0);
        imageView.setFitWidth(1000.0);
        imageView.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        headLabel.setLayoutX(450);
        headLabel.setLayoutY(90.0);
        headLabel.setText("tic.tac.toe.");
        headLabel.setFont(new Font("Arial Rounded MT Bold", 64.0));

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
        
        
//        mailRequest.setEmail(mail.getText());
        
//        String gsonMsg= gson.toJson(mailRequest);
        App.startConnection();
        gson=new Gson();
        online.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 Alert alert = new Alert(Alert.AlertType.ERROR);
             if(user.getText().isEmpty() || mail.getText().isEmpty() || password.getText().isEmpty()){
                     alert.setContentText("Required field");
                     alert.showAndWait();
             }else{
                Message msg=new Message();
                msg.setType("signup");
                msg.setUserName(user.getText());
                msg.setEmail(mail.getText());
                msg.setPassword(user.getText());
                msg.setUserName(user.getText());
                String gsonMessage=gson.toJson(msg);
                System.out.println(gsonMessage);
                App.output.println(gsonMessage);
                App.output.flush();     
            }
               }
        });
        new Thread(() -> {
            while(App.server.isConnected())
            {
                try {
                    String response = App.input.readLine();
                    if(response.equals("true"))
                    {
                        System.out.println(response);
                    }
                    else{
                        System.out.println(response);
                    }
                } catch (IOException ex) {
                    System.out.println("server closed !!!");
                    Logger.getLogger(SignupBase.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
                
            }
        }).start();

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

        arrow.setLayoutX(22.0);
        arrow.setLayoutY(96.0);
        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);
        arrow.setSize("7em");
        arrow.setId("arrow");
        arrow.scaleXProperty().add(1);
        arrow.scaleYProperty().add(1);
        arrow.scaleZProperty().add(1);
        arrow.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Parent root = new loginBase(stage) ;
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });

        getChildren().add(imageView);
        getChildren().add(headLabel);
        getChildren().add(user);
        getChildren().add(online);
        getChildren().add(mail);
        getChildren().add(password);
        getChildren().add(arrow);

    }
}
