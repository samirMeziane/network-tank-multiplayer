package tnakClient;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import tnak.Game;
import tnak.Position;
import tnak.tankModel;

public class jpanel {
	JFrame frame = new JFrame("tankGzgt");
	Client cl;
	ArrayList<shoot> bo=new ArrayList<>();
	boolean isRunning = true;
	static ArrayList<Position> pa=new ArrayList<>();
	ArrayList<Position>pb = new ArrayList<>();
	int xy = 0;
	tank t1;

	private JComponent component = new JComponent() {

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.black);

			for (Position ta : pa) {
				g.fillRect(ta.getX(), ta.getY(), 40, 40);
			}
		
			if(bo!=null) {
				//System.out.println(bo.getX()+"fufu");
				//System.out.println(bo.getX());
				for(shoot sh :bo) {
				g.fillRect(sh.getX(),sh.getY(), 20,20);}
			}
		}

	};

	public jpanel() throws InterruptedException {
		int x = (int) (Math.random() * 500);

		cl = new Client(2345, this);
		cl.connected();

		// cl.gm.getCho().sendPosition(t1.getX(), t1.getY());
		cl.gm.getCho().AskFirstPosition();
		cl.gm.getCho().sendAskList();
		cl.gm.getCho().AskId();
		Thread.sleep(100);
		// System.out.println(cl.getId()+"okok");
		Game g = new Game(920, 640);
		frame.setSize(g.getW(), g.getH());
		// System.out.println(cl.getId()+"okokak");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.blue);

		frame.setVisible(true);
		frame.setContentPane(component);

		frame.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				component.repaint();

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		frame.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowLostFocus(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				component.repaint();
			}
		});
		frame.addKeyListener(new KeyListener() {
			int a, b, c, d;

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37) {
					a = cl.t.getX() - 20;
					b = cl.t.getY();
				cl.t.setD(Direction.LEFT);	
				}
				
				if (e.getKeyCode() == 39) {
					a = cl.t.getX() + 20;
					b = cl.t.getY();
					cl.t.setD(Direction.RIGHT);	
				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					a = cl.t.getX();
					b = cl.t.getY() - 20;
					cl.t.setD(Direction.UP);	
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					a = cl.t.getX();
					b = cl.t.getY() + 20;
					cl.t.setD(Direction.DOWN);
				}
				cl.gm.getCho().move(a, b);
				component.repaint();
				cl.t.setX(a);
				cl.t.setY(b);
				if(e.getKeyCode()==KeyEvent.VK_SPACE) {
					cl.t.shoot();
					//cl.gm.getCho().move(cl.t.b.getX(), cl.t.b.getY());
					//System.out.println(cl.t.getX()+"popo");
					bo.add(cl.t.sh);
					ArrayList<Position>m=new ArrayList<>();
				
					
						cl.gm.getCho().tirer(bo);
						//component.repaint();
					
					}
				
				}
				
			
		});

		/*
		 * while(isRunning) { cl.gm.getCho().sendAskList(); }
		 */

		// System.out.println(pa.size()+"aaas");

		// System.out.println(this.pa.size()+"amine");

	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public tank getT1() {
		return t1;
	}

	public void setT1(tank t1) {
		this.t1 = t1;
	}

	public JComponent getComponent() {
		return component;
	}

	public void setComponent(JComponent component) {
		this.component = component;
	}
	public void sendTir(int x,int y) {
		cl.gm.getCho().move(x, y);
	}

}
