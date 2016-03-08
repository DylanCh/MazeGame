package com.hanjunchen.maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Timer timer;
	private Map m;
	
	public Board(){
		m=new Map();
		timer = new Timer(25,this);
		timer.start();
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for (int y=0; y<Map.arraySize; y++){
			for (int x=0; x<Map.arraySize;x++){
				if (m.getMap(x, y).equals("g")){
					g.drawImage(m.getGrass(), x*32,y*32, this);
				}
				if (m.getMap(x, y).equals("w")){
					g.drawImage(m.getWall(), x*32,y*32, this);
				}
			}
		}
		g.setColor(Color.black);
		g.fillRect(45, 60, 32, 32);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint(); // http://stackoverflow.com/questions/10768619/paint-and-repaint-in-java
	}
	
}
