package ex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server5Exam {
  
  public static void main(String[] args) throws IOException {
    ServerSocket sSocket = new ServerSocket(20000);

    boolean isStart = true;
    
    while(isStart) {
      Socket socket = sSocket.accept();
      
      Server5Thread client = new Server5Thread(socket);
      client.start();
      
      Server5Controller.getInstance().addClient(client);
    }
    
    sSocket.close();
  }
}