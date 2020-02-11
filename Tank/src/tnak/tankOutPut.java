package tnak;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import tnakClient.shoot;

public class tankOutPut implements TankProtocol {

	
	
	PrintWriter p;
	
	public tankOutPut(OutputStream out)throws IOException{
		p=new PrintWriter(out,true);
		
		
	}


	@Override
	public void sendNameOK() {


		p.println("NAME OK");
	}

	@Override
	public void sendNameBad() {
		
		TankProtocol.super.sendNameBad();
		p.println("Name Bad");
	}

	@Override
	public void sendMessage(String from, String to, String msg) {
		TankProtocol.super.sendMessage(from, to, msg);
		p.println("Message");
		p.println(from);
		p.println(to);
		p.println(msg);
		
	}

	

	public void tirer() {
		
		
		p.println("SHOOT");
	}

	public void move() {
	
		p.println("MOVE");
	}
	@Override
	public void moveOk(int x,int y) {
		p.println("MOVE OK");
		p.println(x);p.println(y);
		
	}
	@Override
	public void moveBad() {
		p.println("MOVE BAD");}
	
	@Override
	public void sendPositionOk() {
	p.println("POSITION OK");	
		
	}


	@Override
	public void sendListPosition(ArrayList<Position> poz) {
		// TODO Auto-generated method stub
		//TankProtocol.super.sendListPosition(pr);
		
	p.println("PLIST");
	for(Position po:poz) {
	p.println(po.getX());
	p.println(po.getY());
	//System.out.println("ooooft");
	}
	p.println(".");
	}


	@Override
	public void sendId(int x) {
	p.println("ID");
	p.println(x);
	}


	@Override
	public void sendPosition(int x, int y) {
	p.println("POSITION");
	System.out.println("toz");
	p.println(x);
	p.println(y);
	}


	@Override
	public void sendListPositionBombe(ArrayList<shoot> b) {
		// TODO Auto-generated method stub
		//TankProtocol.super.sendListPositionBombe(b);
		p.println("LBOMBE");
		for(shoot pr:b) {
		p.println(pr.getX());
		p.println(pr.getY());
		p.println(pr.getD());
		//System.out.println("karamba");
		}
		p.println(".");
	}
	
	
	

	


}
