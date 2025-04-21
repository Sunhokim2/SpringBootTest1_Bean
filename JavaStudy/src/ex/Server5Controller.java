package ex;

import java.util.Vector;

public class Server5Controller {
  private static Server5Controller controller = new Server5Controller();
  
  private Vector<Server5Thread> clients = new Vector<Server5Thread>();
  
  private Server5Controller() {}
  
  public static Server5Controller getInstance() {
    if(controller == null) controller = new Server5Controller();
    return controller;
  }
  
  public void addClient(Server5Thread client) {
    clients.add(client);
  }
  
  public void removeClient(Server5Thread client) {
    clients.remove(client);
  }
  
  public void sendAll(String message) {
    for(Server5Thread client : clients) {
      client.send(message);
    }
  }
}
