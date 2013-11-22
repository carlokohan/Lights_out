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

public class LightsGUI extends JFrame implements ActionListener{
	JLabel label1;
	CenterPanel panel1;
	BottomPanel panel2;

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
		label1 = new JLabel("Try to turn off all of the lights. Black means only lights are off.", JLabel.LEFT);
		panel1 = new CenterPanel();
		panel2 = new BottomPanel();
		
		this.add(label1, BorderLayout.NORTH);
		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);
		
		//add listener for the button that will load the text file
		this.panel2.loadFile.addActionListener(this);
		this.panel2.newGame.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String file = "level.txt";
		// Scanner object for file reading
		Scanner fileInput;

		if(e.getSource() == this.panel2.loadFile){
			try{
				String data[] = new String[5];
				int i=0,j=0;
				
				// initialize the Scanner to the file
				fileInput = new Scanner( new File( file ) );
				
				data[i] = fileInput.nextLine();
				i++;
				// Check next available line
				while ( fileInput.hasNext() ) {
					data[i] = fileInput.nextLine();
					i++;
				}

				// Close input file
				fileInput.close();
				
				i = 0;
				//this will contain the tokenized file
				ArrayList <String> list1 = new ArrayList <String>();	
				
				for(i=0;i<5;i++){
					//tokenize by space
					StringTokenizer str = new StringTokenizer(data[i], " ");
					list1.add(str.nextToken());
					while(str.hasMoreTokens()){
						//add tokens to array list
						list1.add(str.nextToken());
					}
				}
				
				int matrix[][] = new int[5][5];
				int temp=0;
				for(i=0;i<5;i++){
					for(j=0;j<5;j++){
						//parse to integer
						matrix[i][j] = Integer.parseInt( list1.get(temp),2 );
						temp++;
					}
				}
				
				for(i=0;i<5;i++){
					for(j=0;j<5;j++){
						if(matrix[i][j] == 1){
							this.panel1.switchOff(i,j,this.panel1.button);
						}
					}
					//System.out.println("\n");
				}
			}
			catch(Exception z){
				JOptionPane.showMessageDialog(null,"File (level.txt) not found.");
			}

		}
		
		//new game, reset to when all lights are on and all switch are off
		if(e.getSource() == this.panel2.newGame){
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(this.panel1.button[i][j].isOn()){
						this.panel1.button[i][j].reverseSwitch();
					}
					
					if( this.panel1.button[i][j].getColor() == Color.black ){
						this.panel1.button[i][j].reverseColor();
					}
				}
			}		
		}

	}
}


