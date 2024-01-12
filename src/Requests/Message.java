/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import java.net.InetAddress;

/**
 *
 * @author ak882
 */
public class Message {
    String type;
    String userName;
    String email;
    String password;
    String opponentUserName;
    InetAddress ipAddress;
    boolean status;
 
    
    int step;
    
    String XO;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpponentUserName() {
        return opponentUserName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOpponentUserName(String opponentUserName) {
        this.opponentUserName = opponentUserName;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getXO() {
        return XO;
    }

    public void setXO(String XO) {
        this.XO = XO;
    }


    
    
    public Message()
    {}
   public Message(String type, String userName, String opponentUserName, InetAddress ipAddress, int step, String XO) {
        this.type = type;
        this.userName = userName;
        this.opponentUserName = opponentUserName;
        this.ipAddress = ipAddress;
        this.step = step;
        this.XO = XO;
    }

   
    
}
