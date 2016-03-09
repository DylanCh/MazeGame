package com.hanjunchen.maze;

//import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Map m;
	private Player p;
	
	/*public class Al extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e){
			
			 * if (e.getKeyCode()== KeyEvent.VK_W){
				p.move(0, -32, 0, -1);
			}
			if (e.getKeyCode()== KeyEvent.VK_S){
				p.move(0, 32, 0, 1);
			}
			if (e.getKeyCode()== KeyEvent.VK_A){
				p.move(-32,0,-1,0);
			}
			if (e.getKeyCode()== KeyEvent.VK_D){
				p.move(32, 0, 1, 0);	
			}
			
			
			}
		}
		@Override
		public void keyReleased(KeyEvent e){
			
		}
		@Override
		public void keyTyped(KeyEvent e){
			
		}
	}*/
	
	public Board(){
		m=new Map(); // initialize  map
		p=new Player(); // initialize player
		//addKeyListener(new Al());
		addKeyListener(new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e){
				switch (e.getKeyCode()){
					case KeyEvent.VK_W : p.move(0, -32, 0, -1); //System.out.println("Up ");
					case KeyEvent.VK_S : p.move(0, 32, 0, 1); //System.out.println("Down ");
					case KeyEvent.VK_A : p.move(-32,0,-1,0); //System.out.println("Left ");
					case KeyEvent.VK_D: p.move(32, 0, 1, 0); //System.out.println("Right ");
				}
			}
			@Override
			public void keyReleased(KeyEvent e){
				System.out.println("keyTyped: "+e);
			}
			@Override
			public void keyTyped(KeyEvent e){
				System.out.println("keyTyped: "+e);
			}
		});
		setFocusable(true); // http://stackoverflow.com/questions/8631165/how-to-set-a-jframe-to-always-be-in-focus
		timer = new Timer(25,this); // run actionPerformed every 25 milliseconds
		timer.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for (int y=0; y<Map.arraySize; y++){
			for (int x=0; x<Map.arraySize;x++){
				if (m.getMap1(x, y) == ('g')){
					g.drawImage(m.getGrass(), x*32,y*32, this);
				}
				if (m.getMap1(x, y) == ('w')){
					g.drawImage(m.getWall(), x*32,y*32, this);
				}
			}
		}
		//Insert player to map
		g.drawImage(p.getPlayer(),p.getX(),p.getY(),null);
		//g.setColor(Color.black);
		//g.fillRect(45, 60, 32, 32);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint(); // http://stackoverflow.com/questions/10768619/paint-and-repaint-in-java
	}
	
}
