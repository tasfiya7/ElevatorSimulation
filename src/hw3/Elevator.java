/**
 * Tasfiya Mubasshira
 * 114870281
 * sec 7
 */

package hw3;

/**
 * 
 * @author Tasfiya Mubasshira
 * 
 * The <code>Elevator</code> class keeps track of the current floor and the current status (idle/going to source floor/going to destination floor) of the Elevator.
 * 
 *
 */
public class Elevator {

	static final int IDLE=0;              //Final value if the elevator is idle.
    static final int TO_SOURCE = 1;        //Final value if the elevator is going to its source location.
    static final int TO_DESTINATION = 2;   //Final value if the elevator is going to its destination.

    private int currentFloor;             // This indicates the current floor where the elevator is.
    private int elevatorState;            // This indicates the current state of the elevator based on the final values assigned.
    Request request;                      // The elevator also contains a request object.
    
    
    /**
     * Constructs the Elevator Object. The Request is initialized to null and the elevator starts of being idle at the first floor
     */
    public Elevator() {
    	
    	request = null;
        elevatorState = IDLE;
        currentFloor = 1;
       
    }
    
    /**
     * accessor method to find out the current floor the elevator is in
     * @return the current floor the elevator is on
     */
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * Mutator method to assign which floor the elevator is on based on the parameter
	 * @param currentFloor, floor which the elevator is on
	 */
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	
	/**
	 * accessor method to find out the current state of the elevator, which can be idle/going to source floor/going to destination floor
     * @return the current state of the elevator
	 */
	public int getElevatorState() {
		return elevatorState;
	}
	
	/**
	 * Mutator method to assign state of the elevator on based on the parameter
	 * @param elevatorState, the state of the elevator which can be idle/going to source floor/going to destination floor
	 */
	public void setElevatorState(int elevatorState) {
		this.elevatorState = elevatorState;
	}

	/**
	 * Accessor method for the Request
	 * @return the Reuest that was created 
	 */
	public Request getRequest(){
		return this.request;
	}
	
	/**
	 * Mutator method to set the request based on the parameter
	 * @param request this is the request being set
	 */
	public void setRequest(Request request){
		this.request = request;
	}
	
	@Override
	/**
	 * This prints out information about the state of and floor on which the elevator is as well as the request it is fufulling
	 * ("---") means no request is being fufilled
	 */
	public String toString(){
		String output = "[Floor: " + currentFloor + ", ";

		if(elevatorState == IDLE)
			output += "IDLE, ";
		else if(elevatorState == TO_SOURCE)
			output += "TO_SOURCE, ";
		else if(elevatorState == 2)
			output +=  "TO_DESTINATION, ";

		if(request == null)
			output += "---";
		else
			output += request;

		return (output+ "]");
	}
	
}
