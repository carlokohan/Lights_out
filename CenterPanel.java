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
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class CenterPanel extends JPanel implements ActionListener{

	// Bulb objects
	Bulb button[][] = new Bulb[5][5];

	// Layout manager object
	GridLayout layout;
	

	public CenterPanel(){
	
		// Call default constructor of superclass
		super();
		
		PanelSetLayout();
		
		// Set components of JPanel
		PanelSetComponents();
		
		this.setVisible(true);
		
	}
	
	private void PanelSetLayout(){
	
		// Instantiate layout manager
		layout = new GridLayout(5,5);	// Arguments: rows, columns
		
		// Set the layout manager of JFrame
		this.setLayout(layout);
		
	}
	
	/**
	*	As we instantiate the 5x5 bulbs, we add it to the panel
	*/
	private void PanelSetComponents(){
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				this.button[i][j] = new Bulb(i,j);
				this.button[i][j].light.setBackground(button[i][j].getColor());
				this.button[i][j].light.addActionListener(this);
				this.add(button[i][j].light);
			}
		}
	}

	public void actionPerformed(ActionEvent e){
		int x1,x2,x3,x4;	//this will contain the coordinates of the other 4
		int y1,y2,y3,y4;	//Bulbs that could be turned off when one button is clicked
		boolean found = false;

		//a 2-level for-loop will check if the source of the event is from that bulb
		for(int i=0;i<5;i++){
			if(!found){
				for(int j=0;j<5;j++){
					if(e.getSource() == this.button[i][j].light){
						this.button[i][j].reverseColor();
						this.button[i][j].reverseSwitch();

						x1 = i-1; y1 = j;	//there will be a maximum of 4 Bulbs that
						x2 = i; y2 = j-1;	//might be affected
						x3 = i; y3 = j+1;
						x4 = i+1; y4 = j;

						if(x1 >= 0){
							this.button[x1][y1].reverseColor();
							//this.button[x1][y1].reverseSwitch();
						}

						if(y2 >= 0){
							this.button[x2][y2].reverseColor();
							//this.button[x2][y2].reverseSwitch();
						}

						if(y3 < 5){
							this.button[x3][y3].reverseColor();
							//this.button[x3][y3].reverseSwitch();
						}

						if(x4 < 5){
							this.button[x4][y4].reverseColor();
							//this.button[x4][y4].reverseSwitch();
						}
						/*
						* We immediately get out of the 2-level for-loop because we already
						* found the Bulb that triggered the event.
						*/
						found = true;
						break;
					}
				}
			}
			else break;
		}

		//check for a winner
		int i=0,j=0;
		for(i=0;i<5;i++){
			for(j=0;j<5;j++){
				//if(button[i][j].isOn()){
				if(button[i][j].getColor().equals(Color.yellow)){
					return;
				}
			}
		}

		if(i == 5 && j == 5){
			JOptionPane.showMessageDialog(null,"You Won!");
		}
	}
}
