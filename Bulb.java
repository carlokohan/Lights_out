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
*	This is the Bulb class - it turns on or off
*	References: my Cmsc 22 exercises and Java API from Oracle
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class Bulb{
	protected int x,y;						//(x,y) coordinates of the Bulb
	public JButton light;					//this will have the ActionListener
	protected boolean switchedOn = false;	//automatically turned on
	Color blind = Color.yellow;

	public Bulb(int x, int y){
		this.light = new JButton();
		this.x = x;
		this.y = y;
	}

	public Bulb(){
		this.light = new JButton();
	}

	/**
	*	returns the x-coordinate
	*/
	public int getX(){
		return	this.x;
	}

	/**
	*	returns the y-coordinate
	*/
	public int getY(){
		return	this.y;
	}

	public Color getColor(){
		return this.blind;
	}

	public void reverseColor(){
		if( this.blind.equals(Color.black) )
			this.blind = Color.yellow;
		else
			this.blind = Color.black;

		this.light.setBackground(this.getColor());
	}

	public void reverseSwitch(){
		if(this.switchedOn == true)
			this.switchedOn = false;
		else
			this.switchedOn = true;
	}

	public boolean isOn(){
		return this.switchedOn;
	}
}