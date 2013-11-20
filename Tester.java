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
*	This is the Tester class
	Program may not work if you are not using openjdk7 on linux
	or if openjdk is installed, try this:
	sudo update-alternatives --config java
	and select the one with openjdk7 or anything with java 7 in it
*/

import java.util.*;
import javax.swing.*;

public class Tester{
	public static void main(String[] arguments){
		LightsGUI game = new LightsGUI();
	}
}
