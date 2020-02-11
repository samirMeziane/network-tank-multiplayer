package tnakClient;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import tnak.Position;
import tnak.TankProtocol;
import tnak.tankModel;

public class clientOutput implements TankProtocol {
PrintWriter pr;

public clientOutput(OutputStream out) {
	pr=new PrintWriter(out,true);
	
}
	@Override
	public void sendName(String name) {
		//TankProtocol.super.sendName(name);
		pr.println("NAME");
		pr.println(name);
	}

	@Override
	public void sendQuit() {
		TankProtocol.super.sendQuit();
	}

	@Override
	public void tirer(ArrayList<shoot>sh) {
		pr.println("SHOOT");
		for(shoot h:sh) {
			pr.println(h.getX());
			pr.println(h.getY());
			pr.println(h.getD());
		}
		pr.println(".");
	}

	@Override
	public void move(int x, int y) {
		pr.println("MOVE");
		//System.out.println(x+"fufu");
		pr.println(x);
		pr.println(y);
		
	}
	@Override
	public void sendPosition(int x, int y) {
			pr.println("POSITION");
			pr.println(x);
			pr.println(y);}

	
	@Override
	public void sendAskList() {
		pr.println("APLIST");}
	@Override
	public void AskId() {
		pr.println("AID");
	}
	@Override
	public void AskFirstPosition() {
	pr.println("AFP");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
