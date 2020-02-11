package tnak;

public interface ItankLoger {
public void isConnected(String name);
public void hasShooted(String name);
public void hasDestroyrdObstacle(String name);
public void hasMoved(String name);
public void hasTouchedEnnemi(String name);
public void hasSentMessage(String from,String to , String msg);
public void isDeconnected(String name);
}
