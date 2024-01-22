package MinMax;

import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
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

        

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1000.0);
        backgroundImage.setLayoutX(-3.0);
        backgroundImage.setLayoutY(-2.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setPreserveRatio(true);
        backgroundImage.getStyleClass().add("win");
        backgroundImage.setImage(new Image(getClass().getResource("/assets/images/background.jpg").toExternalForm()));


        hardGameButton.setLayoutX(650.0);
        hardGameButton.setLayoutY(400.0);
        hardGameButton.setMnemonicParsing(false);
        hardGameButton.setStyle("-fx-background-color: C5A0D7;");
        hardGameButton.setText("Hard Game");
        hardGameButton.setFont(new Font("Arial Bold", 28.0));
        hardGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new MinimaxGameboardBase3(stage , 0),1000,700));
            }
        });
        

        easyGameButton.setLayoutX(650.0);
        easyGameButton.setLayoutY(500.0);
        easyGameButton.setMnemonicParsing(false);
        easyGameButton.setStyle("-fx-background-color: C5A0D7;");
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
        ComputerText.setLayoutX(500.0);
        ComputerText.setLayoutY(182.0);
        ComputerText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
        ComputerText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        ComputerText.setStrokeWidth(0.0);
        ComputerText.setText("Computer");
        ComputerText.setFont(new Font("System Bold", 96.0));

        getChildren().add(backgroundImage);
        getChildren().add(hardGameButton);
        getChildren().add(easyGameButton);
        getChildren().add(ComputerText);
        getChildren().add(backBtn);

    }
}
