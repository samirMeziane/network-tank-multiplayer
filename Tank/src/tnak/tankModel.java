package tnak;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import tnakClient.Direction;
import tnakClient.shoot;
import tnakClient.tank;

public class tankModel {
	private static final ArrayList<gamerHandler>h=new ArrayList<>();
	private static final ArrayList<tank>t=new ArrayList<>();
	public static  ArrayList<Position>ss=new ArrayList<Position>();
	private static final TreeMap<Integer ,gamerHandler>sp=new TreeMap<>();
	public static ArrayList<shoot>pozBombe=new ArrayList<>();
	//public static int j;
	

	
	public static synchronized void checkColision(int numclient,int x,int y) {
		for(Position po:ss) {
		if(x/20==po.getX()/20 && y/20== po.getY()/20) {
			System.out.println("tnaket");
		}

			
		}
			
		}
	
	public static synchronized void registerPositionBombe(int num,int x,int y,Direction d) {
		pozBombe.add(new shoot(x, y,d));
		sp.values().forEach(c->c.hasShoted(pozBombe));
		
	
	}
		
	
public static synchronized void registerUser(String name,gamerHandler g) {
	h.add(g);}


public static synchronized void sendListPosition() {
sp.values().forEach(c->c.hasRegistred(ss));}














public static  synchronized void Tirer() {
	
	
}
public static synchronized void move() {}

public static synchronized void unRegister(String name) {}

public static synchronized void registerTank(tank ta) {
t.add(ta);}
public static synchronized void registerPosition(int numClient,int x,int y,gamerHandler g) {
ss.add(new Position(x,y));
sp.put(numClient, g);

}

public static synchronized TreeMap<Integer,gamerHandler> getSp() {
	return sp;
}
public static synchronized Set<Integer> getTP(){
	return sp.keySet();
	
	
}
public static synchronized ArrayList<gamerHandler> getH() {
	return h;}

public static synchronized void sendFirstCoordonnee(int numClient,gamerHandler g) {
	int x=0,y=0;
	//System.out.println(numClient+"ID");
	//gamerHandler gh=sp.get(numClient);
	//System.out.println(gh.numClient);
	//1060 
	//600
	switch(numClient) {
	case 0:
		x=0;
		y=20;
		break;
	case 1:
	y=20;
	x= 880;
	break;
	
	case 2:
	y=560;
	x=0;
	

	break;
	case 3:
	y=560;	
	x=880;
	System.out.println("4");
	
	break;}
	registerPosition(numClient, x, y, g);
	g.sendPosition(x, y);
	
	
//sendListPosition();	
}


public static synchronized void changePosition(int numClient,int x,int y) {
	Position p=new Position(x,y);
	//System.out.println(ss.size());
	ss.set(numClient, p);
	//System.out.println(ss.get(numClient).getX()+"fafa");
	//System.out.println(ss.size());
	sendListPosition();	
}





}
