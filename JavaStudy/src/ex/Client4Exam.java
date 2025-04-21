package ex;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client4Exam {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("127.0.0.1", 20000);
    
    OutputStream out = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(out, true);
    
    InputStream in = socket.getInputStream();
    Client4Listener listener = new Client4Listener(in);
    listener.start();
    
    Scanner scan = new Scanner(System.in);
    while (true) {
      String data = scan.nextLine();
      if(data == null) break;
      writer.println(data);
    }
        
    scan.close();
    socket.close();
  }
}