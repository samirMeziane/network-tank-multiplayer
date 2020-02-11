package tnakClient;

import java.io.IOException;
import java.net.Socket;

public class Client {
private boolean connected=false;
tank t;
int port ;
private int id;
public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


Socket ss;
String name;
jpanel j;
GamerhundleConnexion gm;
public Client(int port,jpanel j) {
this.port=port;this.t=t;
System.out.println(id);


this.j=j;}


public void connected() {
if(connected)return ;
try {
	
	ss=new Socket("127.0.0.1",1234);
	connected=true;
	gm=new GamerhundleConnexion(ss,t,j,this);
//this.t=new tank(gm., y, height, width)
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	
}


}
