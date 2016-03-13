package com.hanjunchen.maze;

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
//import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Map m;
	private Player p;

	private String message="";
	public boolean win = false;
	// method for Key bindings
	private void setKeyBindings() {
		//get the "focus is in the window" input map for the panel
		InputMap im =this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = this.getActionMap();

		//create a keystroke object to represent the keys
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "RightArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "LeftArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "UpArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "DownArrow");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "RightArrow1");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "LeftArrow1");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "UpArrow1");
	    im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "DownArrow1");

	    am.put("RightArrow", p.new ArrowAction("RightArrow"));
	    am.put("LeftArrow", p.new ArrowAction("LeftArrow"));
	    am.put("UpArrow", p.new ArrowAction("UpArrow"));
	    am.put("DownArrow", p.new ArrowAction("DownArrow"));
	    am.put("RightArrow1", p.new ArrowAction("RightArrow1"));
	    am.put("LeftArrow1", p.new ArrowAction("LeftArrow1"));
	    am.put("UpArrow1", p.new ArrowAction("UpArrow1"));
	    am.put("DownArrow1", p.new ArrowAction("DownArrow1"));
    }
	
	public Board(){
		m=new Map(); // initialize  map
		
		p=new Player(m); // initialize player
		/*
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
		*/
		setKeyBindings();
		this.requestFocus();//have the frame request keyboard focus 
		timer = new Timer(25,this); // run actionPerformed every 25 milliseconds
		timer.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if (!win){
			for (int y=0; y<Map.arraySize; y++){
				for (int x=0; x<Map.arraySize;x++){
					/*
					if (m.getMap1(x,y)=='f'){
						g.drawImage(m.getFinishScreen(),x*32,y*32,this);
					}
					if (m.getMap1(x, y) == ('g')){
						g.drawImage(m.getGrass(), x*32,y*32, this);
					}
					if (m.getMap1(x, y) == ('w')){
						g.drawImage(m.getWall(), x*32,y*32, this);
					}*/
					switch (m.getMap1(x,y)){
					case 'f': g.drawImage(m.getFinishScreen(),x*32,y*32,this); break;
					case 'g': g.drawImage(m.getGrass(), x*32,y*32, this); break;
					case 'w': g.drawImage(m.getWall(), x*32,y*32, this); break;
					}
				}
			}
			g.drawImage(p.getPlayer(),p.getTileX()*32,p.getTileY()*32,null);
		}
		else if (win){
			g.setColor(Color.BLUE);
			g.setFont(new Font("Serif",Font.BOLD,48));
			g.drawString(message, 100, 200);
		}
		//Insert player to map
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (m.getMap1(p.getTileX(), p.getTileY()) == 'f'){
			win=true;
			message = "Good job!";
		}
		repaint(); // http://stackoverflow.com/questions/10768619/paint-and-repaint-in-java
	}
	
}
