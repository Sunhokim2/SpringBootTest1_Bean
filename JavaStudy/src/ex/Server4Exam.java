package ex;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4Exam {
  public static void main(String[] args) throws IOException {
    ServerSocket sSocket = new ServerSocket(20000);
    Socket socket = sSocket.accept();
    
    InputStream in = socket.getInputStream();
    Server4Listener listener = new Server4Listener(in);
    listener.start();
    
    OutputStream out = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(out, true);
    
    Scanner scan = new Scanner(System.in);
    while (true) {
      String data = scan.nextLine();
      if(data == null) break;
      writer.println("[SERVER] "+data);
    }
    
    scan.close();
    socket.close();
    sSocket.close();
  }
}