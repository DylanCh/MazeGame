package com.hanjunchen.maze;

import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Map {
	private Scanner scanner;
	private String[] map;
	private Image grass, wall;
	public static final int arraySize = 14;
	public Map(){
		ImageIcon img = new ImageIcon("SourceFiles/grass.png");
		grass=img.getImage();
		img=new ImageIcon("SourceFiles/wall.png");
		wall=img.getImage();
		map = new String[arraySize];
		openFile();
		readFile();
		scanner.close();
	}
	
	public String getMap(int x, int y){
		return map[y].substring(x,x+1);		
	}
	
	// identical to getMap
	public char getMap1(int x, int y){
		return map[y].charAt(x);
	}
	
	public Image getGrass(){
		return grass;
	}

	private void openFile() {
		// TODO Auto-generated method stub
		try {
			scanner = new Scanner(new File("SourceFiles/Map.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Cannot find map!");
			e.printStackTrace();
		}
	}

	private void readFile() {
		// TODO Auto-generated method stub
		while (scanner.hasNext()){
			for (int i=0; i<arraySize; i++){
				map[i]=scanner.next();
			}
		}
	}

	public Image getWall() {
		// TODO Auto-generated method stub
		return wall;
	}
}
