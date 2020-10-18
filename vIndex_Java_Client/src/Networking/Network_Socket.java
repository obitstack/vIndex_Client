package src.Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Network_Socket {

    private int nPort; // networking port
    private String nAdress; // networkig adress

    public Network_Socket(String network_adress, int port_number){
        this.nAdress = network_adress;
        this.nPort = port_number;

        try (Socket socket = new Socket(nAdress, nPort)) {

            System.out.println("Connected to server"); 
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
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }   
}
