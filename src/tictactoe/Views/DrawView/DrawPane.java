package tictactoe.Views.DrawView;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.PerspectiveCamera;
import javafx.scene.control.Button;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import tictactoe.TicTacToe;

public class DrawPane extends Pane {

    protected final ImageView backgroundImage;
    protected final Button playAgainButton;
    protected final ImageView playAgainImage;
    protected final Button mainMenuButton;
    protected final ImageView mainMenuImage;
    protected final Text drawText;

    public DrawPane(TicTacToe mainApp) {

        backgroundImage = new ImageView();
        playAgainButton = new Button();
        playAgainImage = new ImageView();
        mainMenuButton = new Button();
        mainMenuImage = new ImageView();
        drawText = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        backgroundImage.setFitHeight(700.0);
        backgroundImage.setFitWidth(1100.0);
        backgroundImage.setLayoutX(0.0);
        backgroundImage.setLayoutY(0.0);
        backgroundImage.setPickOnBounds(true);
        backgroundImage.setPreserveRatio(true);
        backgroundImage.getStyleClass().add("win");
        backgroundImage.setImage(new Image(getClass().getResource("BackgroundImage.png").toExternalForm()));

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
            playAgainButton.setStyle("-fx-background-color:C5A0D7;");
        });
        
        playAgainImage.setFitHeight(33.0);
        playAgainImage.setFitWidth(38.0);
        playAgainImage.setLayoutX(660.0);
        playAgainImage.setLayoutY(510.0);
        playAgainImage.setPickOnBounds(true);
        playAgainImage.setPreserveRatio(true);
        playAgainImage.setImage(new Image(getClass().getResource("replay.png").toExternalForm()));

        mainMenuButton.setLayoutX(650.0);
        mainMenuButton.setLayoutY(400.0);
        mainMenuButton.setMnemonicParsing(false);
        mainMenuButton.setStyle("-fx-background-color: C5A0D7;");
        mainMenuButton.setText("     Main Menu");
        mainMenuButton.setFont(new Font("Arial Bold", 28.0));
        mainMenuButton.setOnMouseEntered(event -> {
            mainMenuButton.setStyle("-fx-background-color: D7049E;");
        });

        mainMenuButton.setOnMouseExited(event -> {
            mainMenuButton.setStyle("-fx-background-color:C5A0D7 ;");
        });
          
        mainMenuImage.setFitHeight(33.0);
        mainMenuImage.setFitWidth(38.0);
        mainMenuImage.setLayoutX(660.0);
        mainMenuImage.setLayoutY(410.0);
        mainMenuImage.setPickOnBounds(true);
        mainMenuImage.setPreserveRatio(true);
        mainMenuImage.setImage(new Image(getClass().getResource("main-menu_3916045.png").toExternalForm()));

        drawText.setFill(javafx.scene.paint.Color.valueOf("#d7049e"));
        drawText.setLayoutX(660.0);
        drawText.setLayoutY(250.0);
        drawText.setStroke(javafx.scene.paint.Color.valueOf("#d7049e"));
        drawText.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        drawText.setStrokeWidth(0.0);
        drawText.setText("Draw");
        drawText.setFont(new Font("System Bold", 96.0));
        
        InnerShadow innerShadow = new InnerShadow();
        innerShadow.setOffsetX(3.0);
        innerShadow.setOffsetY(2.0);
        innerShadow.setColor(Color.WHITE);
        drawText.setEffect(innerShadow);
               
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
        drawText.setEffect(reflection);
        
        
        TranslateTransition textTranslateTransition = new TranslateTransition(Duration.seconds(1), drawText);
        textTranslateTransition.setFromY(0);   // Set the starting Y position
        textTranslateTransition.setToY(50);   // Set the ending Y position
        textTranslateTransition.setAutoReverse(true);
        textTranslateTransition.setCycleCount(TranslateTransition.INDEFINITE); // Make it repeat indefinitely
        textTranslateTransition.play();
        
        // Apply 3D transformations
        PerspectiveCamera camera = new PerspectiveCamera(true);
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(3), drawText);
        rotateTransition.setAxis(Rotate.Y_AXIS);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
        rotateTransition.play();
        
        getChildren().add(backgroundImage);
        getChildren().add(playAgainButton);
        getChildren().add(mainMenuButton);
        getChildren().add(mainMenuImage);
        getChildren().add(drawText);
        getChildren().add(playAgainImage);

        DrawPlayVideo();
        
    }
    
    
     public void DrawPlayVideo() {
        String videoFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/DrawView/DrawVideo.mp4";

        // Create a Media object
        Media media = new Media(videoFile);

        // Create a MediaPlayer
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Create a MediaView to display the video
        MediaView mediaView = new MediaView(mediaPlayer);

        // Set the size of the MediaView to fit the screen without cropping
        mediaView.setFitWidth(800.0);
        mediaView.setFitHeight(800.0);

        // Set the position of the MediaView within the WinPane
        mediaView.setLayoutX(100.0); // Set X position
        mediaView.setLayoutY(120.0);  // Set Y position

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
      /*  
        public void mainMenuButtonSound(){
        // Load the sound file
        String soundFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/WinView/ClickSoundEffect.mp3";
        Media sound = new Media(soundFile);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
                // Play the sound when hovering over the button
        mainMenuButton.setOnMouseEntered(event -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });
    }
    */
        public void playAgainButtonSound(){
        // Load the sound file
        String soundFile = "file:/D:/TicTacToe/TicTacToe_App/src/tictactoe/Views/WinView/ClickSoundEffect.mp3";
        Media sound = new Media(soundFile);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        // Play the sound when hovering over the button
        playAgainButton.setOnMouseEntered(event -> {
            mediaPlayer.seek(mediaPlayer.getStartTime());
            mediaPlayer.play();
        });
    }
         
}
