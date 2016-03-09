package com.hanjunchen.maze;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Maze {
	private JFrame frame;
	private Board board;
	//private JLabel timerLabel;
	public Maze(){
		 frame = new JFrame("Maze Game");
		 //frame.setTitle("Maze Game");
		 board = new Board();
		 frame.getContentPane().add(board); // initialize a Board (Japanel) and add to the JFrame
		 frame.pack();
		 frame.setSize(464,485);
		 frame.setResizable(false);
		 frame.setLocationRelativeTo(null);
		 //timerLabel = new JLabel("10", JLabel.CENTER);
		 //frame.getContentPane().add(timerLabel);
         //new GameTimer(timerLabel,true);
		 // frame.setLocationByPlatform(true);
		 frame.setVisible(true);
		 board.requestFocusInWindow();
		 frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 // Ask if the player really wants to quit
		 frame.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent windowEvent){
		          if (JOptionPane.showConfirmDialog(frame,
			              "Really Quit ?", "Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
		              System.exit(0);
	         }        
		 });
		 
	}
	
}
