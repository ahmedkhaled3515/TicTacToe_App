 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Views.AvailablePlayer;

import onlinemode.*;
import Requests.App;
import Requests.Message;
import java.awt.event.WindowAdapter;
import javafx.stage.WindowEvent;

/**
 *
 * @author sarah
 */
public class MyWindowAdapterAvailablePlayers extends WindowAdapter{
    
    String userEmail;
    
    public MyWindowAdapterAvailablePlayers(String userEmail){
        this.userEmail=userEmail;   
    }
    
    public void windowClosing(WindowEvent e) {
        System.out.println("closingggggggg AVAILABLE PLAYERS");
        handleWindowClosing(userEmail);
    }

    // Method to handle the window closing event
    public void handleWindowClosing(String userEmail) {
        Message msg = new Message();
        msg.setEmail(userEmail);
        msg.setType("logOutAvailablePlayers");
        String message=App.gson.toJson(msg);
        App.output.println(message);
        App.output.flush();
               
        System.out.println("HANDLING WINDOWCLOSINGGGGGGGGGGGGGG AVAILABLE PLAYERS");
        
        System.exit(0);
    }
}
