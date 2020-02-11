package tnak;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import tnakClient.shoot;
import tnakClient.tank;





public class gamerHandler implements TankProtocol,tankEvents,Runnable {

	private final Socket s;
	private tankOutPut cho;
	private tankInput chi;
	private tank ta;
	private String name = "";
	private int jauge=3;
	private int x,y;
	private ItankLoger logger = null;
	private enum GamerState {
	ST_INIT, ST_NORMAL
	};
	private GamerState state = GamerState.ST_INIT;
	private boolean stop = false;
	public int numClient;
	
	public gamerHandler(Socket s, ItankLoger logger,int numClient) throws IOException {
	this.s = s;
	this.numClient=numClient;
	this.logger = logger;
	//sendId();
	}
	
	

	@Override
	public void userDamaged() {
	
		
	}

	

	

/*	@Override
	public void sendMessage(String from, String to, String msg) {
		tankModel.sendMessage(from, to, msg);		
		
	}

	public void sendQuit() {
	tankModel.unregisterUser(name);	
	}*/
	
	@Override
	public void AskFirstPosition() {
		// TODO Auto-generated method stub
		
	tankModel.sendFirstCoordonnee(numClient,this);
	//sendPosition(x, y);

	}



	@Override
	public void sendId() {
	cho.sendId(this.numClient);
	//System.out.println(this.numClient);
	}





	@Override
	public void tirer(ArrayList<shoot>poz) {
		// TODO Auto-generated method stub
		for (shoot p: poz) {
		//tankModel.checkColision(numClient,p.getX(),p.getY());
			tankModel.registerPositionBombe(this.numClient,p.getX(), p.getY(),p.getD());
		}
		
	}



	@Override
	public void move(int x,int y) {
		//System.out.println(x+"yooooooo");
		tankModel.changePosition(this.numClient, x, y);
		}

	@Override
	public void userMoved() {
		}
	
	@Override
public void sendPosition(int x, int y) {
//tankModel.registerPosition(this.numClient,x, y,this);
	cho.sendPosition(x, y);	

}

	@Override
	public void chatMessageSent(String from, String to,String msg) {
if(to==this.name) {
	cho.sendMessage(from, to, msg);
}
		
	}

	@Override
	public void userDead() {
			}
	
	
	@Override
	public void sendListPosition() {
		// TODO Auto-generated method stub
		//TankProtocol.super.sendListPosition();
		tankModel.sendListPosition();
	
	}



	@Override
	
	public void run() {
		try (Socket s1 = s) {
			cho = new tankOutPut(s1.getOutputStream());
			sendId();
			chi = new tankInput(s1.getInputStream(), this);
			
			chi.doRun();
			
		} catch (IOException ex) {

ex.printStackTrace();




} catch (TankProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

}
		try {
			s.close();
		} catch (IOException e) { e.printStackTrace(); }	
	
	}



	



	@Override
	public void hasRegistred(ArrayList<Position> po) {
	cho.sendListPosition(po);
		
	}



	@Override
	public void listPositionChanged() {

		}



	@Override
	public void hasShoted(ArrayList<shoot> p) {
	
	cho.sendListPositionBombe(p);	
	}
	}
