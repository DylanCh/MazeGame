package com.hanjunchen.maze;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class Player  {
	private Map m;
	//private int x, y,
	private int tileX, tileY;
	private Image playerImg;
	public Player(Map map){
		m=map;
		//ImageIcon img = new ImageIcon("SourceFiles/player.png");
		playerImg=(new ImageIcon("SourceFiles/smiley.gif")).getImage();
		//x=32;
		//y=32;
		tileX = tileY=1;
	}
	public void move (/*int x, int y, */int tx, int ty){
		//this.x += x;
		//this.y += y;
		tileX += tx;
		tileY += ty;
	}
	
	public Image getPlayer(){
		return playerImg;
	}
	/*
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	*/
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
	public class ArrowAction extends AbstractAction{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String command;
		public ArrowAction(String cmd){
			command=cmd;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (command.equalsIgnoreCase("LeftArrow") || command.equalsIgnoreCase("LeftArrow1")){
				if (m.getMap1(tileX-1,tileY) != 'w')
				move(-1,0);
			}
			else if(command.equalsIgnoreCase("RightArrow") || command.equalsIgnoreCase("RightArrow1")){
				if (m.getMap1(tileX+1,tileY) != 'w')
				move(1,0);
			}
			else if(command.equalsIgnoreCase("UpArrow") || command.equalsIgnoreCase("UpArrow1")){
				if (m.getMap1(tileX,tileY-1) != 'w')
					move(0, -1);
			}
			else if (command.equalsIgnoreCase("DownArrow") || command.equalsIgnoreCase("DownArrow1")){
				if (m.getMap1(tileX,tileY+1) != 'w')
				move(0, 1);
			}
			
		}
	}
}
