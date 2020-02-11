package tnakClient;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import tnak.Position;
import tnak.TankProtocol;
import tnak.TankProtocolException;
import tnak.tankInput;
import tnak.tankOutPut;

public class GamerhundleConnexion extends Thread implements TankProtocol{
	private final Socket s;
	private clientOutput cho;
	private clientInput chi;
	private Client c;
	public Client getC() {
		return c;
	}

	public void setC(Client c) {
		this.c = c;
	}

	//static int cl=0;
	tank t;
	public jpanel j;
	public clientOutput getCho() {
		return cho;
	}

	public void setCho(clientOutput cho) {
		this.cho = cho;
	}

	public clientInput getChi() {
		return chi;
	}

	public void setChi(clientInput chi) {
		this.chi = chi;
	}

	public Socket getS() {
		return s;
	}


	
	
	@Override
	public void sendId(int x) {
		c.setId(x);
		//System.out.println(c.getId()+"ID");
	}

	public GamerhundleConnexion(Socket s,tank t,jpanel j,Client c) throws IOException {

		this.s=s;
		this.j=j;
		this.c=c;
	
		cho=new clientOutput(s.getOutputStream());
		this.t=t;
	this.start();	
	}
	
	@Override
	public void sendName(String name) {
		TankProtocol.super.sendName(name);
	
	}

	/*@Override
	public void tirer(int x, int y) {
		TankProtocol.super.tirer(x, y);
	}*/

	@Override
	public void move(int x, int y) {
		//TankProtocol.super.move(x, y);
		
	//t.setX(x);t.setY(y);
		
		//j.getComponent().repaint();
		
	}
	

	
	
	@Override
	public void sendFirstPosition(int x,int y) {
		
		c.t=new tank(x, y, 20, 20);
	
	}

	public void sendListPosition(ArrayList<Position> p) {
		// TODO Auto-generated method stub
	//	TankProtocol.super.sendListPosition(p);
		j.pa=p;
		//j.getComponent().repaint();
		//System.out.println("dfdfdfdfdef");
		
	}
	
	public ArrayList<Position> getAp(ArrayList<Position>a){
		return a;
	}
	
	

	@Override
	public void sendListPositionBombe(ArrayList<shoot> b) {
				TankProtocol.super.sendListPositionBombe(b);
				j.bo=b;
				j.getComponent().repaint();
	}

	@Override
	public void run() {
		
		try(Socket s1=s){
		chi=new clientInput(s1.getInputStream(),this);
		chi.doRun();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TankProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
