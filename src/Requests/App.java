/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 *
 * @author ak882
 */
public class App {

    public static Socket server;
    public static BufferedReader input;
    public static PrintWriter output;
    public static Gson gson=new Gson();
    public App()
    {
        


    }

    public static void startConnection() {
        if (server == null) {
            try {
                server = new Socket("127.0.0.1", 6000);
                input = new BufferedReader(new InputStreamReader(server.getInputStream()));
                output = new PrintWriter(server.getOutputStream());
            } catch (IOException ex) {
               Platform.runLater(() -> {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Sorry!");
                            alert.setHeaderText(null);
                            alert.setContentText("Server is Out");
                            alert.showAndWait();
                        });
            }
        }
    }

  

    public static void closeConnection() {

        try {
            output.close();
            input.close();
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void resetCon()
    {
        try {
            input=new BufferedReader(new InputStreamReader(server.getInputStream()));
            output=new PrintWriter(server.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
