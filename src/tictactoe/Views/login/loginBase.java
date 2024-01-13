package tictactoe.Views.login;

import Requests.App;
import Requests.Message;
import SelectmodeView.SelectModeBase;
import SignupView.SignupBase;
import com.google.gson.Gson;
import java.awt.event.MouseEvent;
import java.net.URL;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javax.json.Json;
import tictactoe.Views.AvailablePlayer.PlayersListBase;


public class loginBase extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label headLabel;
    protected final TextField txtEmail;
    protected final Button btnLogin;
    protected final Text textHaveAc;
    protected final PasswordField txtPassword;
    protected final FontAwesomeIcon arrow;
     Gson gson;
    public loginBase(Stage stage) {

        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        headLabel = new Label();
        txtEmail = new TextField();
        btnLogin = new Button();
        textHaveAc = new Text();
        txtPassword = new PasswordField();
        arrow = new FontAwesomeIcon();

        setId("AnchorPane");
        setPrefHeight(700.0);
        setPrefWidth(1000.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/login/login.css");
        getStylesheets().add(getClass().getResource("localstyle.css").toExternalForm());

//        anchorPane.setLayoutY(-3.0);
        anchorPane.setPrefHeight(700);
        anchorPane.setPrefWidth(1000);

        backgroundImg.setFitHeight(700);
        backgroundImg.setFitWidth(1000);
//        backgroundImg.setLayoutX(-6.0);
        backgroundImg.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));

        headLabel.setLayoutX(614.0);
        headLabel.setLayoutY(108.0);
        headLabel.setText("tic.tac.toe.");
        headLabel.setTextFill(javafx.scene.paint.Color.valueOf("#c5a0d7"));
        headLabel.setFont(new Font("Arial Rounded MT Bold", 64.0));
      


        txtEmail.setLayoutX(648.0);
        txtEmail.setLayoutY(220.0);
        txtEmail.setPrefHeight(48.0);
        txtEmail.setPrefWidth(250.0);
        txtEmail.setPromptText("Email");
        txtEmail.setFont(new Font(18.0));

        btnLogin.setLayoutX(686.0);
        btnLogin.setLayoutY(408.0);
        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(36.0);
        btnLogin.setPrefWidth(174.0);
        btnLogin.setText("Login");
        App.startConnection();
//        App.resetCon();
        btnLogin.setOnAction((event) -> {
           
           Message msg=new Message();
           msg.setEmail(txtEmail.getText());
           msg.setPassword(txtPassword.getText());
           msg.setType("login");
           String message=App.gson.toJson(msg);
//           System.out.println(message);
           App.output.println(message);
           App.output.flush();
           new Thread(() -> {
                try {
                        String jsonResponse=App.input.readLine();
//                        System.out.println(jsonResponse);
                        Message response2= new Gson().fromJson(jsonResponse,Message.class);
                        System.out.println(response2.getType());
                        if(response2.getValidation().equals("valid"))
                        {
                            Platform.runLater(() -> {
                                stage.setScene(new Scene(new PlayersListBase(stage),1000,700));
                            });   
                        }
                } catch (IOException ex) {
                    Logger.getLogger(loginBase.class.getName()).log(Level.SEVERE, null, ex);
                }
//            App.closeConnection();
        }).start();
        });
        
        textHaveAc.setFill(javafx.scene.paint.Color.valueOf("#e8e5e5"));
        textHaveAc.setLayoutX(635.0);
        textHaveAc.setLayoutY(536.0);
        textHaveAc.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textHaveAc.setStrokeWidth(0.0);
        textHaveAc.setText("You Don't have an account?");
        textHaveAc.setUnderline(true);
        textHaveAc.setFont(new Font(24.0));
        
         textHaveAc.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new  SignupBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });
        

        txtPassword.setLayoutX(648.0);
        txtPassword.setLayoutY(313.0);
        txtPassword.setPrefHeight(48.0);
        txtPassword.setPrefWidth(250.0);
        txtPassword.setPromptText("Password");

        arrow.setLayoutX(15);
        arrow.setLayoutY(115.0);
        arrow.setIcon(FontAwesomeIcons.ARROW_LEFT);
        arrow.setSize("7em");
        arrow.setId("arrow");
        arrow.scaleXProperty().add(1);
        arrow.scaleYProperty().add(1);
        arrow.scaleZProperty().add(1);

        arrow.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase(stage);
                Scene scene = new Scene(root,1000,700);
                stage.setScene(scene);
                stage.show();
            }
        });

        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(headLabel);
        anchorPane.getChildren().add(txtEmail);
        anchorPane.getChildren().add(btnLogin);
        anchorPane.getChildren().add(textHaveAc);
        anchorPane.getChildren().add(txtPassword);
        anchorPane.getChildren().add(arrow);
        getChildren().add(anchorPane);

    }
}
