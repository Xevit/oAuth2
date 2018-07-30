package com.ptellos.client;

import java.io.*;
import java.net.*;

public class ImplCliente implements InterfazCliente {
    
	static Socket requestSocket;
    static ObjectOutputStream out;
    static ObjectInputStream in;
    static String message;
    
    
    public ImplCliente(){}
    public static void runCliente()
    {
        try{
            //1. creating a socket to connect to the server
            requestSocket = new Socket("localhost", 2004);
            System.out.println(place + "Connected to localhost in port 2004");
            //2. get Input and Output streams
            out = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(requestSocket.getInputStream());
            //3: Communicating with the server
            sendMessage();      
        }
        catch(UnknownHostException unknownHost){
            System.err.println(place + "You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                requestSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    public static void sendMessage()
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
        try{
        	String texto = br.readLine();
        	do {
		            out.writeObject(texto);
		            out.flush();
		            texto = br.readLine();
        	} while (!texto.equals("bye"));
        	out.writeObject(texto);
            out.flush();
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main()
    {
    	runCliente(); 
    }
}