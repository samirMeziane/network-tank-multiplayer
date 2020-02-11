package tnakClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.xml.bind.ParseConversionEvent;

import tnak.Position;
import tnak.TankProtocol;
import tnak.TankProtocolException;

public class clientInput {
	
	boolean stop=false;
	TankProtocol handler;
	InputStream in;	
		public clientInput(InputStream in, TankProtocol handler) throws IOException {
			this.in = in;
			this.handler = handler;
				}
		
		public void doRun() throws IOException, TankProtocolException {
			String strMsg, strName, strFrom, strTo, strRoom;
			int x,y;
			Direction d=null;
			String x1,y1,z1;
			ArrayList<String> userList;
			try (BufferedReader is = new BufferedReader(new InputStreamReader(in))) {
				while (!stop) {
				String l=is.readLine();
				switch(l) {
				case "MOVE OK":
				 x=(is.read());
				 //System.out.println(x);
				 y=(is.read());
				 handler.move(x, y);
				break;
				case"PLIST":
					//System.out.println("kikih");
					
					ArrayList<Position>position=new ArrayList<Position>();
					while(!(x1=is.readLine()).equals(".")) {
						y1=is.readLine();
						
						Position pos=new Position(Integer.parseInt(x1),Integer.parseInt(y1));
						//System.out.println(pos.getX()+"esperons");
						position.add(pos);
						
						//System.out.println(position.get(2).getX());
					}handler.sendListPosition(position);
					//System.out.println(position.get(2).getX());
						//jpanel.pa=position;
					/*	for(Position poz:position ) {
					jpanel.pa.add(poz);
							
						}*/
						
						//System.out.println("jfjf");
					//System.out.println("ooft");
					break;
				case "ID":
					x1=is.readLine();
					//System.out.println(x1+"id");
					handler.sendId(Integer.parseInt(x1));break;
					
				case "POSITION":
					//System.out.println("nurufufufufu");
					x1=is.readLine();
					y1=is.readLine();
					handler.sendFirstPosition(Integer.parseInt(x1), Integer.parseInt(y1));
					break;
				case "LBOMBE":
					ArrayList<shoot>pz=new ArrayList<>();
					//System.out.println("ok");
					while(!(x1=is.readLine()).equals(".")) {
						y1=is.readLine();
						z1=is.readLine();
						//System.out.println(y1);
						
						  switch(z1) {
						    case "RIGHT":
						    	d=Direction.RIGHT;break;
						    case "LEFT":
						    	d=Direction.LEFT;break;
						    case "UP":
						    	d=Direction.UP;break;
						    case "DOWN":
						    	d=Direction.DOWN;break;
						    }
						pz.add(new shoot(Integer.parseInt(x1), Integer.parseInt(y1),d));
					}
					handler.sendListPositionBombe(pz);
					break;
					
				}}
		}}}


