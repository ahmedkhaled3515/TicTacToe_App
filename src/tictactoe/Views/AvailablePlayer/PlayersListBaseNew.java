package tictactoe.Views.AvailablePlayer;

import Requests.App;
import static Requests.App.input;
import Requests.Message;
import Requests.PlayersDTO;
import SelectmodeView.SelectModeBase;
import SignupView.SignupBase;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.Flags;
import onlinemode.onlineModeGeneratedBase;
import onlinemode.onlineModeGeneratedBaseNew;

public class PlayersListBaseNew extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final ImageView backgroundImg;
    protected final Label availableLabel;
    protected final ImageView backBtn;
    protected final Rectangle rectangle;
    protected static ListView listView = new ListView();
    public static ArrayList<String> avaliable;
    public static List<String> receivedEmailList;
    public static boolean closeInvite = false, checkforclose = false;
    Object lock = new Object();
    ArrayList<ItemBase> playersCards;
    Alert confirm;
    Optional<ButtonType> result;
    ButtonType alertResult;
    boolean flag;
    boolean shouldStop=false;
    Thread thread= new Thread();
    Stage stage;
    String playerEmail;

    public PlayersListBaseNew(Stage stage,String email) {

        this.stage=stage;

        flag=true;
        alertResult=new ButtonType("");
        confirm = new Alert(Alert.AlertType.CONFIRMATION);
        anchorPane = new AnchorPane();
        backgroundImg = new ImageView();
        availableLabel = new Label();
        backBtn = new ImageView();
        rectangle = new Rectangle();
        avaliable = new ArrayList<>();
        playersCards=new ArrayList<>();
        
        playerEmail=email;
       
        App.startConnection();
        Message msg= new Message();
        msg.setType("getOnline");
        String request=App.gson.toJson(msg);
        App.output.println(request);
        App.output.flush();
        new Thread(() -> {
//            while(App.server.isConnected())
//            {
                try {
                    String jsonResponse= App.input.readLine();
                    System.out.println(jsonResponse);
                    Message response=App.gson.fromJson(jsonResponse,Message.class);
                    ArrayList<PlayersDTO> players =response.getPlayersList();
                    if(response.getType().equals("getOnline"))
                    {
                        for(PlayersDTO player: players)
                        {
                            ItemBase item=new ItemBase();
                            item.playerTxt.setText(player.getUserName());
                            item.inviteBTn.setOnAction((event) -> {
                                Message jsonMessage=new Message();
                                jsonMessage.setType("invite");
                                jsonMessage.setEmail(player.getEmail());
                                App.output.println(new Gson().toJson(jsonMessage));
                                App.output.flush();
                            });
                            listView.getItems().add(item);
                            listView.refresh();
                        }                    
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PlayersListBase.class.getName()).log(Level.SEVERE, null, ex);
//                    break;
                }
//            }
        }).start();

//        App.resetCon();
       Thread yourThread = new Thread(() -> {
    while (App.server.isConnected() && !Thread.interrupted()) { 
                try {
                    AtomicBoolean accepted= new AtomicBoolean(false);
                    String jsonResponse=App.input.readLine();
                    Message response= new Gson().fromJson(jsonResponse,Message.class);
                    String opponentEmail=response.getEmail();
                    System.out.println(jsonResponse);
                    if(response.getType().equals("invite"))
                    {
                        Platform.runLater(() -> {
                            confirm.setContentText(response.getEmail()+" is inviting you to play do you want to join?");
                            confirm.setTitle("Play Request");
                            confirm.setX(stage.getX()+(stage.getWidth()/2));
                            confirm.setY(stage.getY()+(stage.getHeight()/2));
                            result= confirm.showAndWait();
                            alertResult=result.get();
                            if (result.isPresent() && result.get() == ButtonType.OK) {
                                accepted.set(true);
                            }
                            else if(result.isPresent() && result.get() == ButtonType.CANCEL)
                            {
                                accepted.set(false);
                            }
                            
                        });
                        while(accepted.get()==false)
                        {
                            Thread.sleep(60000);
                        }
                        if (accepted.get()) {
                // Continue with the rest of your code for accepting the invitation
                            System.out.println("accepted");
                            Message inviteResponse = new Message();
                            inviteResponse.setType("accepted");
                            inviteResponse.setEmail(response.getEmail());
                            App.output.println(new Gson().toJson(inviteResponse));
                            App.output.flush();
                            Platform.runLater(() -> {
                            Parent root = new onlineModeGeneratedBase(stage,playerEmail,opponentEmail);
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                            });
                            break;
                        } else {
                            // Handle rejection
                            System.out.println("invite canceled");
                            Message inviteResponse = new Message();
                            inviteResponse.setType("rejected");
                            inviteResponse.setEmail(response.getEmail());
                            App.output.println(new Gson().toJson(inviteResponse));
                            App.output.flush();
                        }
//                        System.out.println(result.get());
//                        if(flag==false)
//                        {
//                            break;
//                        }
                    }
                    else if(response.getType().equals("accepted"))
                    {
                        Platform.runLater(() -> {
                            Parent root = new onlineModeGeneratedBase(stage,playerEmail,opponentEmail);               
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        });
                       
                        break;
                    }
                    else if(response.getType().equals("rejected"))
                    {
                        Platform.runLater(() -> {    
                            Alert rejectAlert=new Alert(Alert.AlertType.INFORMATION,response.getEmail()+" rejected your play request check another player");
                            rejectAlert.setX(stage.getX()+(stage.getWidth()/2));
                            rejectAlert.setY(stage.getY()+(stage.getHeight()/2));
                            rejectAlert.show();
                        });
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PlayersListBaseNew.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                } catch (InterruptedException ex) {
                    Logger.getLogger(PlayersListBaseNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       yourThread.start();
//        App.resetCon();
//        new Thread(() -> {
////            while(App.server.isConnected())
////            {
//                try {
//                    String jsonResponse=App.input.readLine();
//                    Message response= new Gson().fromJson(jsonResponse,Message.class);
//                    System.out.println(jsonResponse);
//                    if(response.getType().equals("accepted"))
//                    {
//                        Platform.runLater(() -> {
//                            Parent root = new onlineModeGeneratedBase(stage);               
//                            Scene scene = new Scene(root);
//                            stage.setScene(scene);
//                            stage.show();
//                        });
//                    }
//                } catch (IOException ex) {
//                    Logger.getLogger(PlayersListBaseNew.class.getName()).log(Level.SEVERE, null, ex);
////                    break;
//                }
////            }
//        }).start();
        
//        Gson gson = new Gson();
//        new Thread(() -> {
//            while (App.server.isConnected()) {
//                try {
//                    String jsonEmailList = input.readLine();
//
//                    // Convert the JSON string to a List of emails
//                    Type listType = new TypeToken<List<String>>() {
//                    }.getType();
//                    List<String> newReceivedEmailList = gson.fromJson(jsonEmailList, listType);
//
//                    // Synchronize access to the shared variable
//                        receivedEmailList = newReceivedEmailList;
//                    
//
//                    Platform.runLater(() -> {
//                        for (String email : newReceivedEmailList) {
//                            ItemBase itemBase = new ItemBase();
//                            itemBase.playerTxt.setText(email);
//                            listView.getItems().add(itemBase);
//                            listView.refresh();
//                            System.out.print(email);
//                        }
//                    });
//                } catch (IOException ex) {
//                    System.out.println("server closed !!!");
//                    Logger.getLogger(SignupBase.class.getName()).log(Level.SEVERE, null, ex);
//                    break;
//                }
//            }
//        }).start();

        listen4();


        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/tictactoe/Views/AvailablePlayer/playerslist.css");

        anchorPane.setPrefHeight(679.0);
        anchorPane.setPrefWidth(998.0);

        backgroundImg.setFitHeight(686.0);
        backgroundImg.setFitWidth(1014.0);
        backgroundImg.setImage(new Image(getClass().getResource("gaming-blank-banner-background_23-2150390423.jpg").toExternalForm()));

        availableLabel.setLayoutX(500.0);
        availableLabel.setLayoutY(56.0);
        availableLabel.setText("Available Players");
        availableLabel.setTextFill(javafx.scene.paint.Color.WHITE);
        availableLabel.setFont(new Font("System Bold", 50.0));

        backBtn.setFitHeight(73.0);
        backBtn.setFitWidth(100.0);
        backBtn.setLayoutX(391.0);
        backBtn.setLayoutY(56.0);
        backBtn.setPickOnBounds(true);
        backBtn.setPreserveRatio(true);
        backBtn.setImage(new Image(getClass().getResource("symbole-fleche-gauche-violet.png").toExternalForm()));
        backBtn.setOnMouseClicked(new EventHandler() {

            @Override
            public void handle(Event event) {
                listView.getItems().clear();
                Parent root = new SelectModeBase(stage);               
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
             
            }
        });


        rectangle.setArcHeight(5.0);
        rectangle.setArcWidth(5.0);
        rectangle.setFill(javafx.scene.paint.Color.valueOf("#7f1fff"));
        rectangle.setHeight(472.0);
        rectangle.setLayoutX(401.0);
        rectangle.setLayoutY(156.0);
        rectangle.setStroke(javafx.scene.paint.Color.TRANSPARENT);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStrokeWidth(2);
        rectangle.setWidth(567.0);

        listView.setLayoutX(427.0);
        listView.setLayoutY(187.0);
        listView.setPrefHeight(397.0);
        listView.setPrefWidth(515.0);
        listView.getStyleClass().add("mylistview");

        anchorPane.getChildren().add(backgroundImg);
        anchorPane.getChildren().add(availableLabel);
        anchorPane.getChildren().add(backBtn);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(listView);
        getChildren().add(anchorPane);

    }

    public static void preperList() {
        ItemBase itemBase = new ItemBase();
        for (String email : receivedEmailList) {
            itemBase.playerTxt.setText(email);
            listView.getItems().add(itemBase);
            listView.refresh();
        }

    }
    Alert invitation;
    public void showInvitation(Message jsonResponse)
    {   
        Message response= jsonResponse;
        invitation = new Alert(Alert.AlertType.CONFIRMATION,response.getEmail()+" someone wants to play with you",ButtonType.OK,ButtonType.CANCEL);
        DialogPane dialog= invitation.getDialogPane();
        Button okButton= (Button) dialog.lookupButton(ButtonType.OK);
        Button cancelButton= (Button) dialog.lookupButton(ButtonType.CANCEL);
        Message inviteResponse= new Message();
            invitation.setX(stage.getX()+(stage.getWidth()/2));
            invitation.setY(stage.getY()+(stage.getHeight()/2));
            okButton.setOnAction((event) -> {
            inviteResponse.setType("accepted");
            inviteResponse.setEmail(response.getEmail());
            App.output.println(new Gson().toJson(inviteResponse));
            App.output.flush();
            Parent root = new onlineModeGeneratedBase(stage,playerEmail,response.getEmail());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        });
        cancelButton.setOnAction((event) -> {
           inviteResponse.setType("rejected");
           inviteResponse.setEmail(response.getEmail());
           App.output.println(new Gson().toJson(inviteResponse));
           App.output.flush();
           listen4();
        });
        invitation.showAndWait();
    }
    public void listen4()
    {
        Thread th=new Thread(() -> {
            while(App.server.isConnected())
            {
                
                try {
                    String jsonResponse=App.input.readLine();
                    Message response= new Gson().fromJson(jsonResponse,Message.class);
                    System.out.println(jsonResponse);
                    if(response.getType().equals("invite"))
                    {
                        Platform.runLater(() -> {
                            showInvitation(response);
                        });
                        break;
                    }
                    else if(response.getType().equals("accepted"))
                    {
                        Platform.runLater(() -> {
                            Parent root = new onlineModeGeneratedBase(stage,playerEmail,response.getEmail());               
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        });
                        break;
                    }
                    else if(response.getType().equals("rejected"))
                    {
                        Platform.runLater(() -> {    
                            Alert rejectAlert=new Alert(Alert.AlertType.INFORMATION,response.getEmail()+" rejected your play request check another player");
                            rejectAlert.setX(stage.getX()+(stage.getWidth()/2));
                            rejectAlert.setY(stage.getY()+(stage.getHeight()/2));
                            rejectAlert.show();
                        });
                    }
                } catch (IOException ex) {
                    Logger.getLogger(PlayersListBaseNew.class.getName()).log(Level.SEVERE, null, ex);
                    break;
                }
            }
        });
        th.start();
    }

    
}
