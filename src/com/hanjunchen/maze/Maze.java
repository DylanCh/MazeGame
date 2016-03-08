package com.hanjunchen.maze;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Maze {
	private JFrame frame;
	public Maze(){
		 frame = new JFrame();
		 frame.setTitle("Maze Game");
		 frame.add(new Board());
		 frame.setSize(500,400);
		 frame.setLocationRelativeTo(null);
		 frame.setVisible(true);
		 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 frame.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent windowEvent){
		          if (JOptionPane.showConfirmDialog(frame,
			              "Really Quit ?", "Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		              System.exit(0);
	         }        
		 });
	}
	
}
