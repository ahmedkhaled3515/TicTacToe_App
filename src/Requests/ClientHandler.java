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
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ak882
 */
public class ClientHandler extends Thread{
//    static List<ClientHandler> clientList=new ArrayList<ClientHandler>();
//    String clientUserName;
//    String opponentUserName;
//    PrintStream output;
//    BufferedReader input;
//    Socket clientSocket;
//    Gson gson =new Gson();
//    public ClientHandler(Socket clientSocket)
//    {
//        try {
//            this.clientSocket=clientSocket;
//            input = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
//            output = new PrintStream(clientSocket.getOutputStream());
////            this.clientUserName=input.readLine();
////            this.opponentUserName=gson.fromJson(input.readLine(),Message.class).opponentUserName;
//            clientList.add(this);
//            start();
//        } catch (IOException ex) {
//            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//
//        }
//    }
//    @Override
//    public void run()
//    {
//        try{
//            while(clientSocket.isConnected())
//            {
//                String gsonMessage=input.readLine();
//                System.out.println(gsonMessage);
//                messageHandler(gsonMessage);
//            }
//        }
//        catch(IOException ex)
//        {
//            System.out.println("client closed");
//        }
//        finally{
//            clientList.remove(this);
//        }
//    }
////    public void messageHandler(String gsonMessage)
////    {
////        Message msg=gson.fromJson(gsonMessage,Message.class);
////        switch(msg.type)
////        {
////            case "signup":
////                signUp(msg);
////        }
////    }
//    
//    public void broadCastMessage(String message)
//    {
//        for(ClientHandler client: clientList)
//        {
//                client.output.println(message);
//                System.out.println(clientList.size());
//        }
//    }
}
