package src.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket; // needs to be changed to client socket

public class Network_Socket {

    private int nPort; // networking port
    private String nAdress; // networkig adress

    public Network_Socket(int port_number){
        this.nPort = port_number;

        try (ServerSocket serverSocket = new ServerSocket(nPort)) {
            java.net.Socket socket = serverSocket.accept();
            System.out.println("Client connected"); 
            BufferedReader input =  new BufferedReader( new InputStreamReader(socket.getInputStream()));  
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);  
            
            while(true){
                String echoString = input.readLine();
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server" + echoString);
            }
        } catch (Exception e) {
            System.out.println("server exception " + e.getMessage());
            e.printStackTrace();
        }
    }   
}
