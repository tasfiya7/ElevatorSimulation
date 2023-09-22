/**
 * Tasfiya Mubasshira
 * 114870281
 * sec 7
 */
package hw3;

import java.util.Scanner;

/**
 * 
 * @author  Tasfiya Mubasshira
 *
 *The <code>Analyzer</code> contains the main method and asks the user for the probability, number of floors, number of elevators and total time units of the simulation.
 *If the information provided is valid the simulation runs
 *If the infromation is incorrect the Exceptions that are thrown are caught and the mistakes of the user is printed
 */
public class Analyzer {


	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		Simulator simulator = new Simulator();
        
		
		try {
            System.out.println("Welcome to the Elevator simulation!");
            System.out.println();

            System.out.println("Please enter the probability of arrival for Requests: ");
            double probability = sc.nextDouble();
            System.out.println("Please enter the number of floors: ");
            int floors = sc.nextInt();
            System.out.println("Please enter the number of elevators: ");
            int elevators = sc.nextInt();
            System.out.println("Please enter the length of the simulation (in time units): ");
            int totalTime = sc.nextInt();
            System.out.println();
            
            

            simulator.simulate(floors, elevators, totalTime, probability);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
		
	}
	
}
