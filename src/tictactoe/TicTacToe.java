/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import HomeView.homeBase;
import SelectmodeView.SelectModeBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import tictactoe.localmode.LocalViewBase;
import tictactoe.machineView.MachineViewBase;

import tictactoe.Views.WinView.WinPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import tictactoe.Views.DrawView.DrawPane;
import tictactoe.Views.LoseView.LosePane;
import tictactoe.Views.WinView.WinController;

import tictactoe.Views.AvailablePlayer.PlayersListBase;
import tictactoe.Views.login.loginBase;


import tictactoe.Views.GameBoardBase;



/**
 *
 * @author ak882
 */
public class TicTacToe extends Application {
    
    
    private WinPane winPane;
    private LosePane losePane;
    private DrawPane drawPane;
    private Scene scene;
    private Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = new MachineViewBase();
        
        //LocalViewBase();
         //MachineViewBase();

        Parent root = new SelectModeBase();



   

  


        
        winPane = new WinPane(this);

        
       
        
       // Set up the scene with WinPane
       scene = new Scene(winPane,1000,700);
       scene.getStylesheets().add("/tictactoe/Views/WinView/win.css");
       stage.setScene(scene);
       
      //text.getStyleClass().add("styles");
       stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
        // Method to switch to the WinPane
    public void switchToWinPane() {
        setScene(winPane);
    }

    // Method to switch to the LosePane
    public void switchToLosePane() {
        losePane = new LosePane(this);
        setScene(losePane);
    }

    // Method to switch to the DrawPane
    public void switchToDrawPane() {
        drawPane = new DrawPane(this);
        setScene(drawPane);
    }

    private void setScene(Pane pane) {
        if (scene == null) {
            // Initialize the scene if it's null
            scene = new Scene(pane, 1000, 700);
            stage.setScene(scene);
        } else {
            // Update the root of the existing scene
            scene.setRoot(pane);
        }
    }
    
    
}
