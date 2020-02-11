package tnak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import tnakClient.Direction;
import tnakClient.shoot;


public class tankInput {
	InputStream in;
	boolean stop=false;
TankProtocol handler;
	
	public tankInput(InputStream in, TankProtocol handler) throws IOException {
		this.in = in;
		this.handler = handler;
			}
	
	public void doRun() throws IOException, TankProtocolException {
		String strMsg, strName, strFrom, strTo, strRoom;
		String x ,y,z;
		Direction d=null;
		ArrayList<String> userList;
		try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
			while (!stop) {
				String line = is.readLine();
				switch (line) {
				case "NAME":
					strName = is.readLine();
						//System.out.println("hahahah");
						handler.sendName(strName);
						break;
			
				case " MESSAGE":
						strFrom = is.readLine();
						strTo = is.readLine();
						strMsg = is.readLine();
						handler.sendMessage(strFrom, strTo, strMsg);
						break;
			     case "QUIT":
						handler.sendQuit();
						break;
			     case "SHOOT":
			    	 ArrayList<shoot>s=new ArrayList<>();
			    	  //System.out.println("gouri3");
			    	 while(!(x=is.readLine()).equals(".")){
			    	
			    y=is.readLine();
			    z=is.readLine();
			    switch(z) {
			    case "RIGHT":
			    	d=Direction.RIGHT;break;
			    case "LEFT":
			    	d=Direction.LEFT;break;
			    case "UP":
			    	d=Direction.UP;break;
			    case "DOWN":
			    	d=Direction.DOWN;break;
			    }
			    //System.out.println(z);
			    s.add(new shoot(Integer.parseInt(x),Integer.parseInt(y),d));
			    	 }
			  
			    handler.tirer(s);
			    break;
			   // y=Integer.parseInt(is.readLine());
			    	//handler.tirer(x,y);break;
			   /*  case "MOVE":
			    	  x=is.read();
			    	  System.out.println(x+"jkjkj");
					    y=(is.read());
					    System.out.println(y+" yohoho");
			    handler.move(x,y);
			    break;*/
			     case "POSITION":
			   //strName=is.readLine();
			   x=is.readLine();
			   
			   y=is.readLine();
			   //System.out.println(sx+"h2");
			   //int d=Integer.parseInt(x)+Integer.parseInt(y);
			   //System.out.println(d);
handler.sendPosition(Integer.parseInt(x),Integer.parseInt(y) );break;
			     case "APLIST":
			   	 handler.sendListPosition();break;
			   	 case "MOVE":
			    x=is.readLine();
			    System.out.println(x+"fofofafa");
			    y=is.readLine();
			   // System.out.println(x+"katon");
			    handler.move(Integer.parseInt(x),Integer.parseInt(y));
				break;
			   	 case "AID":
			   		 System.out.println("asked id");
			   		 handler.sendId();break;
			   		 
			   	 case "AFP":
			   		 //System.out.println("ici");
			   		 handler.AskFirstPosition();
				}
				
			}}}}


