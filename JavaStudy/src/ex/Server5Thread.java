package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Server5Thread extends Thread {
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;
  private String nickname;
  
  public Server5Thread(Socket socket) throws IOException {
    this.socket = socket;
    this.reader = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.writer = new PrintWriter(socket.getOutputStream(), true);
    this.nickname = reader.readLine();
  }
  
  @Override
  public void run() {   
    System.out.printf("[%s] 접속\n", this.nickname);
    Server5Controller.getInstance().sendAll("[" + this.nickname + "] 접속!");
    
    try {
      while(true) {
        String message = this.reader.readLine();
        Server5Controller.getInstance().sendAll(
            "[" + this.nickname + "] " + message);
      }
    } catch (IOException e) {
      e.printStackTrace();
      
      try { this.socket.close(); } 
      catch (IOException e1) { e1.printStackTrace(); }
    }
  }
  
  public void send(String message) {
    this.writer.println(message);
  }
}