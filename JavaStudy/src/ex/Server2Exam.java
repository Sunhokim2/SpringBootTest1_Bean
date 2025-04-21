package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2Exam {
  public static void main(String[] args) throws IOException {
    ServerSocket sSocket = new ServerSocket(20000);
    Socket socket = sSocket.accept();
    
    InputStream in = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(in);
    BufferedReader reader = new BufferedReader(isr);
    
    while (true) {
      String data = reader.readLine();
      if(data == null) break;
      System.out.println(data);
    }
    
    socket.close();
    sSocket.close();
  }
}