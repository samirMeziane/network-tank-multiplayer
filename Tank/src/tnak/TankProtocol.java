package tnak;

import java.util.ArrayList;
import java.util.Collection;

import tnakClient.shoot;
import tnakClient.tank;

public interface TankProtocol {
	
	default void sendName(String name){}
	default void sendNameOK(){}
	default void sendNameBad() {}
	public default void sendListPositionBombe(ArrayList<shoot> b) {}
	//public default void sendListPositionBombe(int num,ArrayList<Position> b) {}
	default void sendMessage(String from, String to, String msg){}
	default void sendQuit(){}
	default void tirer(ArrayList<shoot>sh){}
	default void tirer(int numclient,ArrayList<Position>sh) {}
	default void move(int numClient,int x,int y) {}
	default void move(int x,int y) {}
	default void moveOk(int x,int y) {}
	default void sendId(int x) {}
	default void sendId() {}
	default void AskId() {}
	default void AskFirstPosition(){}
	default void sendFirstPosition(int x,int y) {}
	default void moveBad() {}
	default void registerTank(tank ta) {}
	default void sendPosition(int x,int y) {}
	default void sendPositionOk(){}
	default void sendPositionBad() {}
	default void sendListPosition() {}
	default void sendListPosition(ArrayList<Position> p) {}
	default void sendAskList() {}
	

}
