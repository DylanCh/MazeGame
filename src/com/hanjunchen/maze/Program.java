package com.hanjunchen.maze;

import java.awt.EventQueue;

public class Program {
	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
	         public void run() {
	        	 new Maze();
	         }
	        });
	}
}
