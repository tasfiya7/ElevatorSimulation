/**
 * Tasfiya Mubasshira
 * 114870281
 * sec 7
 */
package hw3;

import java.util.ArrayList;

/**
 * 
 * @author  Tasfiya Mubasshira
 * 114870281
 * sec 7
 * 
 * The <code>Simulator</code> runs the simulation.
 * It adds requests to the queue, puts the person them into a elevator if the elevator is empty, which removes their request from the queue.
 * It takes them from theire source floor to their destination. It calculates the amount of time they waited before being picked up and the total amout of passengers the elevator picked up throughout the simulation.
 * It then provide the average wait time during the simulation
 */
public class Simulator {
	
	int totalWaitTime = 0; // total amount all the people waiting during the simulation
    int requests = 0; // total request picked
    double averageWaitTime; // average wait time during the simulation
    boolean debug=false; // used to test the code when it is set to true
    

    /**
     * @param floors num of floors in the building 
     * @param numOfElevators num of elevators in the buidling 
     * @param totalTime total time units the simulation will run for
     * @param probability the probability of arrival for requests as provided by the user
     * @throws IllegalArgumentException this Exception is thrown when any of the parameter values are invalid 
     */
	public void simulate(int floors, int numOfElevators, int totalTime, double probability) throws IllegalArgumentException{
		// creates queue
		RequestQueue requestQueue = new RequestQueue();
		
		if (floors <= 1) // there has to be at least one floor
            throw new IllegalArgumentException("The number of floors must be greater than 1");
        if (numOfElevators <= 0)// there can't be less than 0 elevators
            throw new IllegalArgumentException("The number of elevators must be greater than 0");
        if (totalTime <= 0) // for the simulation to run the total time it's running for cannot be less than 0
            throw new IllegalArgumentException("Total time must be greater than 0");
        if (probability < 0.0 || probability > 1.0) // user to need to provide a probability between 0 and 1
            throw new IllegalArgumentException("The probability must be between 0.0 and 1.0");
		
        
        BooleanSource prob = new BooleanSource(probability);
        
        // an arraylist hold all the elevators in the building
        ArrayList<Elevator> elevatorList = new ArrayList<>();
        int[] waitTime = new int[numOfElevators]; // hold wait time of each elevator in an array
        for (int i = 0; i < numOfElevators; i++) {
            Elevator elevator = new Elevator();// elevator object is created for the number of elevators there are
            elevatorList.add(elevator); // each elevator is added to the list
            waitTime[i] = 0; // wait time is initiallized to 0
        }
        
        
        //start of simulation 
        for (int i = 0; i < totalTime; i++) {
        	// Request is created and added to queue
        	if (prob.requestArrived()) {
                Request request = new Request(floors);
                request.setTimeEntered(i); // time unite request is created
                requestQueue.enqueue(request); // adding to queue
                if (debug==true) { // testing code
                System.out.println("A request arrives from Floor " + request.getSourceFloor()
				+ " to Floor " + request.getDestinationFloor());
                }
     
    		
            }
        	
        	
        	else{
        		//testing code
        		if (debug==true)
				System.out.println("No Request Arrived");
			}
        	
        	// if an elevator is empty and there is a request, the request is taken off the queue and starts being processed
        	for (int j = 0; j < numOfElevators && !requestQueue.isEmpty(); j++) {
        		
        		if (elevatorList.get(j).getElevatorState() == Elevator.IDLE && !requestQueue.isEmpty()) {
        			elevatorList.get(j).request = (Request) requestQueue.dequeue(); //taking out of queue
        			waitTime[j] = Math.abs(elevatorList.get(j).request.getSourceFloor() - elevatorList.get(j).getCurrentFloor()); // wait time calculated for this elevator to get to source floor
        			elevatorList.get(j).setRequest(elevatorList.get(j).request);
					// elevator status is Moving to source floor.
        			elevatorList.get(j).setElevatorState(Elevator.TO_SOURCE);
        			
        		}
        	}
        		
        		for(int k=0; k<numOfElevators; k++) {
        			// nothing happens if elevator is idle
        			if(elevatorList.get(k).getElevatorState() == Elevator.IDLE){
    					continue;
        			}
        			
        			else if(elevatorList.get(k).getElevatorState() == Elevator.TO_SOURCE) { // check if heading towards source floor
        				//move current floor 1 floor closer to source floor, by going up, every time unit if it is heading towards there
        				if (elevatorList.get(k).getCurrentFloor()< elevatorList.get(k).getRequest().getSourceFloor()) {
        					elevatorList.get(k).setCurrentFloor(elevatorList.get(k).getCurrentFloor()+1); //  moves up a floor 
        					
        				}
        				//move current floor 1 floor closer to source floor, by going down, every time unit if it is heading towards there
        				else if (elevatorList.get(k).getCurrentFloor()> elevatorList.get(k).getRequest().getSourceFloor()) {
        					elevatorList.get(k).setCurrentFloor(elevatorList.get(k).getCurrentFloor()-1); // move down a floor
        					
        				}
        				// if source floor is reached change statust to going towards destination floor
        				if (elevatorList.get(k).getCurrentFloor()== elevatorList.get(k).getRequest().getSourceFloor()) { 
        					elevatorList.get(k).setElevatorState(Elevator.TO_DESTINATION);
        					requests++; // incriments amount of request addressed by the simulation
        					totalWaitTime += waitTime[k]; // wait time to reah source floor for this instance is added to total wait time
    						waitTime[k] = 0; // reset to 0 to count wait time for next request
        				}
        				
        				
        				
        			}
        			// heading towards destination floor
        			else if (elevatorList.get(k).getElevatorState()==Elevator.TO_DESTINATION) {
        			
        				// if destination floor is greater than source floor move up 1 floor
        				if (elevatorList.get(k).getCurrentFloor()< elevatorList.get(k).getRequest().getDestinationFloor()) {
        					elevatorList.get(k).setCurrentFloor(elevatorList.get(k).getCurrentFloor()+1);
        				}
        				//if destination floor is less than source floor move down 1 floor
        				else if (elevatorList.get(k).getCurrentFloor()> elevatorList.get(k).getRequest().getDestinationFloor()) {
        					elevatorList.get(k).setCurrentFloor(elevatorList.get(k).getCurrentFloor()-1);
        				}
        				// if destination floor is reached , change status to idle. no request is being handled
        				if (elevatorList.get(k).getCurrentFloor() == elevatorList.get(k).request.getDestinationFloor()) {
                            elevatorList.get(k).setElevatorState(Elevator.IDLE);
                            elevatorList.get(k).request = null;
                            
    						
                        }
        				
        			}
        			
        	
        			
        			
        		}
        		
        		if(requests != 0) // total request is not equal to 0
                averageWaitTime = (double) totalWaitTime / requests; // average wait time is total wait time divided by total requests
        		
        		
        	if (debug==true) { // test code
        		System.out.print("Request next in Queue: ");
        		// if there's a request in queue, it prints it
                if(!requestQueue.isEmpty()) {
                	System.out.println(((Request)requestQueue.peek()).toString());
                }
                else {
                	System.out.println("n/a");
                }
        		
        
        		
                // prints info about each elevator
                for(int k=0; k<numOfElevators; k++) {
                	
                	System.out.println("Elevator " + (k+1) + ": ");
    				System.out.print(elevatorList.get(k) + " ");
    			System.out.println();
                }
                // prints total time, requests, and averageWaitTime after each time unit
                System.out.println("\nTotal Wait Time: " + totalWaitTime);
        		System.out.println("Total Requests: " + requests);
        		System.out.print("Average Wait Time: ");
        		System.out.println(String.format("%.2f" , averageWaitTime));
        		System.out.println();
        	}
        	
        }
        // at the end of simulation totalWaitTime, total Request, and Average Wait Time of Simulation is printed
        System.out.println("\nTotal Wait Time: " + totalWaitTime);
		System.out.println("Total Requests: " + requests);
		System.out.print("Average Wait Time: ");
		System.out.println(String.format("%.2f" , averageWaitTime));
		System.out.println();
		
	}

	
	

}
