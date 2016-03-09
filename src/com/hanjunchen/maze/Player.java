package com.hanjunchen.maze;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Player {
	private int x, y, tileX, tileY;
	private Image playerImg;
	public Player(){
		//ImageIcon img = new ImageIcon("SourceFiles/player.png");
		playerImg=(new ImageIcon("SourceFiles/smiley.gif")).getImage();
		x=32;
		y=32;
		tileX = tileY=1;
	}
	public void move (int x, int y, int tx, int ty){
		this.x += x;
		this.y += y;
		tileX += tx;
		tileY += ty;
	}
	
	public Image getPlayer(){
		return playerImg;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getTileX(){
		return tileX;
	}
	
	public int getTileY(){
		return tileY;
	}
}
