package tnakClient;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {

	jpanel j;
	
	public Key(jpanel j) {
	this.j=j;}
	
	@Override
	public void keyPressed(KeyEvent a) {
	if(a.getKeyCode()==KeyEvent.VK_LEFT) {
		j.t1.setX(j.t1.getX()-20);
		System.out.println("gagagaga");
		j.getComponent().repaint();
	}
	if(a.getKeyCode()==KeyEvent.VK_RIGHT) {
		j.t1.setX(j.t1.getX()+20);
		j.getComponent().repaint();
	}	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
