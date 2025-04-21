package ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server3Exam {
  public static void main(String[] args) throws IOException {
    ServerSocket sSocket = new ServerSocket(20000);
    Socket socket = sSocket.accept();
    
    InputStream in = socket.getInputStream();
    InputStreamReader isr = new InputStreamReader(in);
    BufferedReader reader = new BufferedReader(isr);
    
    OutputStream out = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(out, true);
    
    while (true) {
      String data = reader.readLine();
      if(data == null) break;
      System.out.println(data);
      writer.println(data);
    }
    
    socket.close();
    sSocket.close();
  }
}