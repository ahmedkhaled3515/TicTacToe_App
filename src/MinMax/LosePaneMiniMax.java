package MinMax;

import SelectmodeView.SelectModeBase;
import tictactoe.Views.LoseView.*;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;
import static org.omg.CORBA.ORB.init;
import tictactoe.TicTacToe;

public class LosePaneMiniMax extends Pane {

    protected final ImageView backgroundImage;
   // protected final Button playAgainButton;
  //  protected final ImageView playAgainImage;
    protected final Button mainMenuButton;
    protected final ImageView mainMenuImage;
    protected final Text loseText;
    Stage stage;
    
    public LosePaneMiniMax(Stage stage) {

        backgroundImage = new ImageView();
    //    playAgainButton = new Button();
    //    playAgainImage = new ImageView();
        mainMenuButton = new Button();
        mainMenuImage = new ImageView();
        loseText = new Text();
        this.stage=stage;
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        
        setPrefSize(1000.0,700.0);

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1100.0);
        backgroundImage.setLayoutX(0.0);
        backgroundImage.setLayoutY(0.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setPreserveRatio(true);
        backgroundImage.getStyleClass().add("win");
        backgroundImage.setImage(new Image(getClass().getResource("/assets/images/backgroundImageGif.gif").toExternalForm()));
/*
        playAgainButton.setLayoutX(650.0);
        playAgainButton.setLayoutY(500.0);
        playAgainButton.setMnemonicParsing(false);
        playAgainButton.setStyle("-fx-background-color: C5A0D7;");
        playAgainButton.setText("     Play Again");
        playAgainButton.setFont(new Font("Arial Bold", 28.0));
        playAgainButton.setOnMouseEntered(event -> {
            playAgainButton.setStyle("-fx-background-color: D7049E;");
        });

        playAgainButton.setOnMouseExited(event -> {
            playAgainButton.setStyle("-fx-background-color:C5A0D7 ;");
        });
        playAgainButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
              //  mainApp.switchToDrawPane();
            }
        });
 
        
        
        playAgainImage.setFitHeight(33.0);
        playAgainImage.setFitWidth(38.0);
        playAgainImage.setLayoutX(660.0);
        playAgainImage.setLayoutY(510.0);
        playAgainImage.setPickOnBounds(true);
        playAgainImage.setPreserveRatio(true);
        playAgainImage.setImage(new Image(getClass().getResource("/assets/images/Replay2.png").toExternalForm()));
*/
        mainMenuButton.setLayoutX(650.0);
        mainMenuButton.setLayoutY(400.0);
        mainMenuButton.setMnemonicParsing(false);
        mainMenuButton.setText("     Main Menu");
        mainMenuButton.setFont(new Font("Arial Bold", 28.0));
        mainMenuButton.setStyle("-fx-background-color: C5A0D7;");
        mainMenuButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               mainMenuButton.setStyle("-fx-background-color: D7049E;");
            }
        });
        
         mainMenuButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               mainMenuButton.setStyle("-fx-background-color:C5A0D7 ;");
            }
        });
         mainMenuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new SelectModeBase(stage)));
            }
        });
          

        mainMenuImage.setFitHeight(33.0);
        mainMenuImage.setFitWidth(38.0);
        mainMenuImage.setLayoutX(660.0);
        mainMenuImage.setLayoutY(410.0);
        mainMenuImage.setPickOnBounds(true);
        mainMenuImage.setPreserveRatio(true);
        mainMenuImage.setImage(new Image(getClass().getResource("/assets/images/main-menu_3916045.png").toExternalForm()));

        loseText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
        loseText.setLayoutX(660);
        loseText.setLayoutY(220.0);
        loseText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
        loseText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        loseText.setStrokeWidth(0.0);
        loseText.setText("Lose");
        loseText.setFont(new Font("System Bold", 96.0));
        
          
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(3.0);
        innerShadow.setOffsetY(2.0);
        innerShadow.setColor(Color.WHITE);
        loseText.setEffect(innerShadow);
               
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        loseText.setEffect(reflection);
        
        
        TranslateTransition textTranslateTransition = new TranslateTransition(Duration.seconds(1), loseText);
        textTranslateTransition.setFromY(0);   // Set the starting Y position
        textTranslateTransition.setToY(50);   // Set the ending Y position
        textTranslateTransition.setAutoReverse(true);
        textTranslateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Make it repeat indefinitely
        textTranslateTransition.play();
        
        // Apply 3D transformations
        PerspectiveCamera camera = new PerspectiveCamera(true);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), loseText);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        getChildren().add(backgroundImage);
       // getChildren().add(playAgainButton);
        getChildren().add(mainMenuButton);
        getChildren().add(mainMenuImage);
        getChildren().add(loseText);
      //  getChildren().add(playAgainImage);
        LosePlayVideo();
        
    }
    
        public void LosePlayVideo() {
        String videoFile = "/assets/videos/LoseVideo.mp4";

        // Create a Media object
        Media media = new Media(getClass().getResource(videoFile).toExternalForm());

        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(130.0);  // Set Y position

        // Set the position of the MediaView within the WinPane
        StackPane.setAlignment(mediaView, Pos.CENTER);

        // Play the video
        mediaPlayer.play();

        // Add the MediaView to the WinPane
        getChildren().add(mediaView);

        // Set the event handler for when the media finishes playing
        mediaPlayer.setOnEndOfMedia(() -> {
            // Add any additional actions when the video finishes
            System.out.println("Video finished");
            mediaView.setVisible(false);
        });
    }
        
        
         public void mainMenuButtonSound(){
        // Load the sound file
        String soundFile = "/assets/sounds/ClickSoundEffect.mp3";
        Media sound = new Media(getClass().getResource(soundFile).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                // Play the sound when hovering over the button
        mainMenuButton.setOnMouseEntered(event -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });
    }
    /*
        public void playAgainButtonSound(){
        // Load the sound file
        String soundFile = "/assets/sounds/ClickSoundEffect.mp3";
        Media sound = new Media(getClass().getResource(soundFile).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        // Play the sound when hovering over the button
        playAgainButton.setOnMouseEntered(event -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });   
    }
*/
        
}
