/**
*	@author Jose Carlo G. Husmillo
*	@version 1.0
*	@date November 17, 2013
*	
*	Simple implementation of lights out game using java
*
*	To run: compile all java files then run "Tester.java"
*/

/**
*	This is the LightsGUI class
*	This contains the frame needed for the program
*	References: my Cmsc 22 exercises and Java API from Oracle
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class LightsGUI extends JFrame {
	JLabel label1,label2;
	CenterPanel panel1;

	// Layout manager object
	BorderLayout layout;

	public LightsGUI(){
		// Call constructor of superclass
		super("Lights Out!");
	
		// Set the dimensions of the JFrame
		this.setSize(500, 500);
		
		// Call the method to set the layout of JFrame
		LightsGUISetLayout();
		
		// Call the private method to set the components of JFrame
		LightsGUISetComponents();
		
		// Set the close operation of JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setResizable(false);

		//center
		this.setLocationRelativeTo(null);
		
		// Set the visibility of JFrame
		this.setVisible(true);
	}

	/**
	*	Sets the layout to be used in our game
	*/
	private void LightsGUISetLayout(){
		layout = new BorderLayout();
		this.setLayout(layout);
	}

	/**
	*	Sets the components to be displayed and used in the JFrame
	*/
	private void LightsGUISetComponents(){
		label1 = new JLabel("Try to turn off all of the lights. Black means lights are off.", JLabel.LEFT);
		label2 = new JLabel("by woootiness", JLabel.RIGHT);
		panel1 = new CenterPanel();
		
		this.add(label1, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(label2, BorderLayout.SOUTH);
	
	}
}


