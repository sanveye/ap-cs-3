import java.util.Scanner;  //may be necessary for input

import javax.swing.JOptionPane;  //may be necessary for input

import kareltherobot.*;


    
public class Driver implements Directions {
// declared here so it is visible in all the methods!! 
// It will be assigned a value in the getInfo method
	private static Robot roomba; 


	// You will add very many variables!!

	
	public static void main(String[] args) {
		// LEAVE THIS ALONE!!!!!!
		Driver d = new Driver();

  /**
	 * This section of code gets info from the user in the following order: 1. Ask the user
	 * which world file they wish to process. Right now, that world file name is
	 * hardcoded in. 2. Ask the user for the starting location and direction of the
	 * Robot. A new Robot should be constructed and assigned to the global
	 * (instance) variable named roomba that is declared on line 10.
	 * 
	 * An inelegant way to interact with the user is via the console, using
	 * System.out.println and a Scanner that scans System.in (input from the
	 * console). A more elegant way to get user input might include using a
	 * JOptionPane.
	 */
		
	 
	 
	 //finalTestWorld2024 (1).wld 
	 	//(26, 101)
	 //TestWorld-2.wld 
	 	//(5,6)
		 
		//basicRoom.wld, world file loading
		String wrldName = JOptionPane.showInputDialog(null, "Which world file do you wish to process?:");
        World.readWorld(wrldName);
		World.setVisible(true);
		World.setDelay(0);

		//avenue num
		String avenueNumString = JOptionPane.showInputDialog(null, "Enter an avenue:");
		int avenueNum = Integer.parseInt(avenueNumString);

		//street num
		String streetNumString = JOptionPane.showInputDialog(null, "Enter a street:");
		int streetNum = Integer.parseInt(streetNumString);

		//direction
		String inputDirection = JOptionPane.showInputDialog(null, "Enter a direction:");
		
		//default: 7, 6, East (for the basic room file)
		
		Robot r = null;


		//loading in the robot
		if (inputDirection.equals("north")){
			r = new Robot(avenueNum,streetNum,North,0);
		} else if (inputDirection.equals("south")){
			r = new Robot(avenueNum,streetNum,South,0);
		} else if (inputDirection.equals("west")){
			r = new Robot(avenueNum,streetNum,West,0);
		} else if (inputDirection.equals("east")){
			r = new Robot(avenueNum,streetNum,East,0);
		} else {
			r = new Robot(avenueNum,streetNum,East,0);
		}
			

	/** This section will have all the logic that takes the Robot to every location 
	 * and cleans up all piles of beepers.  Think about ways you can break this
	 * large, complex task into smaller, easier to solve problems.
	 */

		// the line below causes a null pointer exception
		// what is that and why are we getting it?
		

	// setting variables
	int roomArea = 1;
	int beeperCount = 0;
	int pileCount = 0;
	int beepersInPile = 0;
	int greatestPileCount = 0;
	int greatestStreet = 0;
	int greatestAvenue = 0;
	

	while (true){
		while (r.frontIsClear()==true){
			if (r.nextToABeeper()){
				pileCount++;
				beepersInPile = 0;
				while (r.nextToABeeper()==true){
				r.pickBeeper();
				beeperCount ++;
				beepersInPile++;
			}
			if (beepersInPile>greatestPileCount){
				greatestPileCount = beepersInPile;
				greatestStreet = r.street();
				greatestAvenue = r.avenue();

			}
			r.move();
			roomArea ++;
		} else{
				r.move();
				roomArea ++;
			}
		}

		if (r.facingEast()==true){
			r.turnLeft();
			if (r.nextToABeeper()){
				pileCount++;
				beepersInPile = 0;
				while (r.nextToABeeper()==true){
				r.pickBeeper();
				beeperCount ++;
				beepersInPile++;
			}
			if (beepersInPile>greatestPileCount){
				greatestPileCount = beepersInPile;
				greatestStreet = r.street();
				greatestAvenue = r.avenue();

			}
		}
			if (r.frontIsClear()==true){
				r.move();
				roomArea ++;
				if (r.nextToABeeper()){
				pileCount++;
				beepersInPile = 0;
				while (r.nextToABeeper()==true){
				r.pickBeeper();
				beeperCount ++;
				beepersInPile++;
			}
			if (beepersInPile>greatestPileCount){
				greatestPileCount = beepersInPile;
				greatestStreet = r.street();
				greatestAvenue = r.avenue();

			}
		}
				r.turnLeft();
			} else {
				r.turnOff();
				break;
			} 
		} else if (r.facingWest()==true){
			turnRight(r);
			if (r.nextToABeeper()){
				pileCount++;
				beepersInPile = 0;
				while (r.nextToABeeper()==true){
				r.pickBeeper();
				beeperCount ++;
				beepersInPile++;
			}
			if (beepersInPile>greatestPileCount){
				greatestPileCount = beepersInPile;
				greatestStreet = r.street();
				greatestAvenue = r.avenue();

			}
		}
			if (r.frontIsClear()==true){
				r.move();
				roomArea ++;
				if (r.nextToABeeper()){
				pileCount++;
				beepersInPile = 0;
				while (r.nextToABeeper()==true){
				r.pickBeeper();
				beeperCount ++;
				beepersInPile++;
			}
			if (beepersInPile>greatestPileCount){
				greatestPileCount = beepersInPile;
				greatestStreet = r.street();
				greatestAvenue = r.avenue();

			}
		}
				turnRight(r);
			} else {
				r.turnOff();
				break;
			} 
			
			

		} 
		
	}
		
	


		


/** This method displays the results of cleaning the room.  All of the info
	 * in the pdf that describes the problem need to be displayed.  You can present
	 * this info in the console (boring) or you can present using JOptionPane (cool!)
	 */


	 double avgPileSize = (double) beeperCount/(double) pileCount;
	 double percentDirty = (double) pileCount/(double) roomArea;

    System.out.println("The area of the room was " + roomArea + " units.");
	System.out.println("There were " + pileCount + " piles.");
	System.out.println("There were " + beeperCount + " beepers collected.");
	System.out.println("The greatest amount of beepers in a pile was " + greatestPileCount + " beepers.");
	System.out.println("The location of the largest pile was at avenue " + greatestAvenue + " street " + greatestStreet + ".");
	System.out.println("The average pile size was " + avgPileSize + " beepers.");
	System.out.println("The room was " + percentDirty + " percent dirty.");
	

  }

  public static void turnRight(Robot r){
				r.turnLeft();
				r.turnLeft();
				r.turnLeft();
			}


	public static void getDirection(Robot r){
		//
	}

}