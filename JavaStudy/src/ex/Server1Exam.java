package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1Exam {
  public static void main(String[] args) throws IOException {
    ServerSocket sSocket = new ServerSocket(20000);
    System.out.println("Server started...");
    Socket socket = sSocket.accept();
    
    InputStream in = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(in);
    BufferedReader reader = new BufferedReader(isr);
    
    String data = reader.readLine();
    System.out.println(data);
    
    sSocket.close();
  }
}