package tnakClient;

public class shoot extends Thread {
	
private int x;
private int y;
private Direction d;
/*private boolean lanc�=false;
public boolean isLanc�() {
	return lanc�;
}*/
/*public void setLanc�(boolean lanc�) {
	this.lanc� = lanc�;
}*/
public shoot(int x,int y,Direction d) {
	this.x=x;
	this.y=y;
	this.d=d;
	//lanc�=true;
	this.start();
}
@Override
public void run() {
	
	switch(d) {
	case LEFT:
	while(x>0 ) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	this.x=x-20;
	
	}
	break;
	case RIGHT:
	while(x<940) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("okokokokok");
		this.x=x+20;
		
	}
	    break;
	case UP:
		while(y>-20 ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.y-=20;}
		break;
	case DOWN:
		while(y<620 ) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.y+=20;}
		break;
	}
	
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
public Direction getD() {
	return d;
}
public void setD(Direction d) {
	this.d = d;
}
}
