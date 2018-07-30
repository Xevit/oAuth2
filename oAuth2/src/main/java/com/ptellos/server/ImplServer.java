package com.ptellos.server;

import java.io.*;
import java.net.*;


public class ImplServer implements InterfazServidor{
    static ServerSocket providerSocket;
    static Socket connection = null;
    static ObjectOutputStream out;
    static ObjectInputStream in;
    static String message;
    public ImplServer(){}
    /* (non-Javadoc)
	 * @see server.InterfazServidor#runServer()
	 */
    public static void runServer()
    {
        try{
            //1. creating a server socket
            providerSocket = new ServerSocket(2004, 10);
            //2. Wait for connection
            System.out.println(place + "Waiting for connection");
            connection = providerSocket.accept();
            System.out.println(place + "Connection received from " + connection.getInetAddress().getHostName());
            //3. get Input and Output streams
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            sendMessage("Connection successful");
            //4. The two parts communicate via the input and output streams
            do{
                try{
                    message = (String)in.readObject();
                    System.out.println(place + "client>" + message);
                    if (message.equals("bye"))
                        sendMessage("Gracias por conectarte al servicio de mensajería instantanea");
                }
                catch(ClassNotFoundException classnot){
                    System.err.println(place + "Data received in unknown format");
                }
            }while(!message.equals("bye"));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            //4: Closing connection
            try{
                in.close();
                out.close();
                providerSocket.close();
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    /* (non-Javadoc)
	 * @see server.InterfazServidor#sendMessage(java.lang.String)
	 */
    public static void sendMessage(String msg)
    {
        try{
            out.writeObject(msg);
            out.flush();
            System.out.println(place + "server>" + msg);
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
    }
    public static void main()
    {
	    	Runnable r = new Runnable() {
	            @Override
	            public void run() {
	                runServer();
	            }
	        };
	        new Thread(r).start(); 
    }
}