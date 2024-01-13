/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import HomeView.homeBase;
import RecordView.RecordBase;
import SelectmodeView.SelectModeBase;
import SignupView.SignupBase;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.net.Socket;

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
import onlinemode.onlineModeGeneratedBase;
import tictactoe.Views.DrawView.DrawPane;
import tictactoe.Views.LoseView.LosePane;
import tictactoe.Views.WinView.WinController;

import tictactoe.Views.AvailablePlayer.PlayersListBase;
import tictactoe.Views.AvailablePlayer.PlayersListBaseNew;
import tictactoe.Views.login.loginBase;



import tictactoe.Views.computerMode.ComputerModeBase;
import tictactoe.Views.computerMode.ComputerModeBase2;

import tictactoe.Views.LocalMode2Players.GameBoardBase2Players;




/**
 *
 * @author ak882
 */
public class TicTacToe extends Application {
   
    private Scene scene;
    private Stage stage;

    Socket server;

    @Override

    public void start(Stage stage) throws Exception {

        Parent root = new homeBase(stage);
//        Parent root = new PlayersListBaseNew(stage);
        Parent root2=new ComputerModeBase(stage,"O");
        scene = new Scene(root);
       stage.setScene(scene);
       stage.show();
       
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
   
}
