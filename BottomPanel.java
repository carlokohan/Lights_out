/**
*	@author Jose Carlo G. Husmillo
*	@version 1.0
*	@date November 17, 2013
*	
*	Simple implementation of lights out game using java
*
*	To run: compile all java files then run "Tester.java"
*
*
*	This is the BottomPanel class
*	This contains the buttons for loading the text file for the game
*	References: my Cmsc 22 exercises and Java API from Oracle
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class BottomPanel extends JPanel{
	// Layout manager object
	FlowLayout layout;
	JButton loadFile;
	JButton newGame;

	public BottomPanel(){
	
		// Call default constructor of superclass
		super();
		
		PanelSetLayout();
		
		// Set components of JPanel
		PanelSetComponents();
		
		this.setVisible(true);
		
	}
	
	private void PanelSetLayout(){
	
		// Instantiate layout manager
		layout = new FlowLayout();
		
		// Set the layout manager of JFrame
		this.setLayout(layout);
		
	}
	
	/**
	*	2 buttons for new game and load the file
	*/
	private void PanelSetComponents(){
		loadFile = new JButton("Load File");
		newGame = new JButton("New Blank Game");
		
		this.add(newGame);
		this.add(loadFile);
	}
}
