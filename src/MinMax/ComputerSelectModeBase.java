package MinMax;

import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tictactoe.Views.computerMode.ComputerModeBase;
import tictactoe.Views.computerMode.ComputerModeBase2;
import tictactoe.machineView.MachineViewBase;

public class ComputerSelectModeBase extends Pane {

    protected final ImageView backgroundImage;
    protected final Button hardGameButton;
    protected final Button easyGameButton;
    protected final Text ComputerText;
        protected final ImageView backBtn;

    public ComputerSelectModeBase(Stage stage) {

        backgroundImage = new ImageView();
        hardGameButton = new Button();
        easyGameButton = new Button();
        ComputerText = new Text();
           backBtn = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        getStyleClass().add("mainFxmlClass");
        getStylesheets().add("/MinMax/minMax.css");
        //getStylesheets().add(getClass().getResource("localstyle.css").toExternalForm());

        

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1000.0);
        backgroundImage.setLayoutX(-3.0);
        backgroundImage.setLayoutY(-2.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setPreserveRatio(true);
        backgroundImage.getStyleClass().add("win");
        backgroundImage.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));


        hardGameButton.setLayoutX(620.0);
        hardGameButton.setLayoutY(290.0);
        hardGameButton.setPrefHeight(65.0);
        hardGameButton.setPrefWidth(240.0);
        hardGameButton.setId("btn");
        hardGameButton.setMnemonicParsing(false);
        hardGameButton.setText("Hard Game");
        hardGameButton.setFont(new Font("Arial Bold", 50.0));
        hardGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new MinimaxGameboardBase3(stage , 0),1000,700));
            }
        });
        

        easyGameButton.setLayoutX(620.0);
        easyGameButton.setLayoutY(390.0);
         easyGameButton.setPrefHeight(65.0);
        easyGameButton.setPrefWidth(240.0);
        easyGameButton.setMnemonicParsing(false);
        easyGameButton.setText("Easy Game");
        easyGameButton.setFont(new Font("Arial Bold", 28.0));
        easyGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               stage.setScene(new Scene(new MachineViewBase(stage),1000,700));
            }
        });
        
        
           
        backBtn.setLayoutX(100.0);
        backBtn.setLayoutY(50.0);
        backBtn.setImage(new Image(getClass().getResource("/assets/images/a.png").toExternalForm()));
        backBtn.setId("arrow");
        backBtn.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                Parent root = new SelectModeBase(stage);
                Scene scene = new Scene(root, 1000, 700);
                stage.setScene(scene);
                stage.show();
            }
        });
        
        
        ComputerText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
        ComputerText.setLayoutX(530.0);
        ComputerText.setLayoutY(182.0);
        ComputerText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
        ComputerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ComputerText.setStrokeWidth(0.0);
        ComputerText.setText("Choose Level");
        //ComputerText.setFont(new Font("System Bold", 96.0));
        
        ComputerText.setFill(javafx.scene.paint.Color.valueOf("#BE8FD5"));
        ComputerText.setStroke(Color.web("#C1ADCB"));  
        ComputerText.setStrokeWidth(2); 
        ComputerText.setFont(new Font("System Bold", 60.0));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(3.0);
        dropShadow.setOffsetY(3.0);
        ComputerText.setEffect(dropShadow);

        getChildren().add(backgroundImage);
        getChildren().add(hardGameButton);
        getChildren().add(easyGameButton);
        getChildren().add(ComputerText);
        getChildren().add(backBtn);

    }
}
