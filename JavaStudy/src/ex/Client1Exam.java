package ex;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1Exam {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("127.0.0.1", 20000);
    
    OutputStream out = socket.getOutputStream();
    PrintWriter writer = new PrintWriter(out, true);
    
    String data = "Hello~";
    writer.println(data);
    
    socket.close();
  }
}