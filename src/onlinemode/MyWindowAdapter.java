 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinemode;

import Requests.App;
import Requests.Message;
import java.awt.event.WindowAdapter;
import javafx.stage.WindowEvent;

/**
 *
 * @author sarah
 */
public class MyWindowAdapter extends WindowAdapter{
    
    String userEmail;
    String opponentEmail;
    
    public MyWindowAdapter(String userEmail , String opponentEmail){
        this.userEmail=userEmail;
        this.opponentEmail=opponentEmail;
    }
    
    
    public void windowClosing(WindowEvent e) {
        System.out.println("closingggggggggggggggggggggggggggggg");
        handleWindowClosing(userEmail , opponentEmail);
    }

    // Method to handle the window closing event
    public void handleWindowClosing(String userEmail , String opponentEmail) {
        Message msg = new Message();
        msg.setEmail(userEmail);
        msg.setOpponentEmail(opponentEmail);
        msg.setType("logOut");
        String message=App.gson.toJson(msg);
        App.output.println(message);
        App.output.flush();
               
        System.out.println("HANDLING WINDOWCLOSINGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
        
        System.exit(0);
    }
}
