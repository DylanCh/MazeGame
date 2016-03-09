package com.hanjunchen.maze;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.Timer;
// Implements a timer placed in the JFrame. Not yet finished
public class GameTimer {
	private JLabel label;
    Timer countdownTimer;
    int timeRemaining = 10;

    public GameTimer(JLabel passedLabel,boolean displayInJFrame) {
    	if (displayInJFrame == true)
    		countdownTimer = new Timer(25, new CountdownTimerListener());
    	//else if (CallerClass.getCallerClassName().class instanceof ActionListener) 
    		//countdownTimer = new Timer (25,CallerClass.getCallerClassName());
    	else countdownTimer = new Timer (25,null);
       this.label = passedLabel;
       countdownTimer.start();
    }

     class CountdownTimerListener implements ActionListener {
         public void actionPerformed(ActionEvent e) {
            if (--timeRemaining > 0) {
                label.setText(String.valueOf(timeRemaining));
             } else {
                label.setText("Time's up!");
                countdownTimer.stop();
             }
         }
     }
}
