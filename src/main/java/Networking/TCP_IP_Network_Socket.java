package Networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TCP_IP_Network_Socket {

    private int nPort; // networking port
    private String nAdress; // networking adress

    public TCP_IP_Network_Socket(String network_adress, int port_number){
        this.nAdress = network_adress;
        this.nPort = port_number;

        try (Socket socket = new Socket(nAdress, nPort)) {

            System.out.println("Connected to server"); 
            BufferedReader echoes =  new BufferedReader( new InputStreamReader(socket.getInputStream()));  
            PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);  

            Scanner scanner = new Scanner(System.in);
            String echoString;
            String response;

            do {
                System.out.println("Enter string to be Echoed: ");
                echoString = scanner.nextLine();
                stringToEcho.println(echoString);
                if(!echoString.equals("exit")){
                    response = echoes.readLine();
                    System.out.println(response);
                }
                
            } while (!echoString.equals("exit"));
            
        } catch (Exception e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }   
}
