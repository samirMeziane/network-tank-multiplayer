package tnakClient;

import java.util.ArrayList;

public class tank {
private int x,y,height,width,jauge;
private String id;
//private ArrayList<Bombe>b;
Bombe b;
private Direction d;
public shoot sh;
public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Bombe getB() {
	return b;
}

public void setB(Bombe b) {
	this.b = b;
}

public Direction getD() {
	return d;
}

public void setD(Direction d) {
	this.d = d;
}

public tank(int x,int y,int height,int width) {
this.x=x;
this.y=y;
this.height=height;
this.width=width;
this.jauge=3;
d=Direction.RIGHT;

}

public int getJauge() {
	return jauge;
}

public void setJauge(int jauge) {
	this.jauge = jauge;
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

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

public int getWidth() {
	return width;
}

public void setWidth(int width) {
	this.width = width;
}

public void shoot()  {
	switch(this.d) {
	case LEFT:
	sh=new shoot(x-20, (this.y+this.height+y)/2, d);
	//b.setX(b.getX()-20);
		
	
	System.out.println("sokay");break;
	case RIGHT:
	sh=new shoot(x+40,(this.y+this.height+y)/2,d);break;
	case UP:
	sh=new shoot((2*x+this.width)/2, y-20,d);break;	
	case DOWN:
	sh=new shoot((2*x+this.width)/2, y+40,d);break;	
	}
	
}

}
