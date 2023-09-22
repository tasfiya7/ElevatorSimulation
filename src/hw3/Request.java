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
 * The <code>Request</code> class creates the Request Object and sets up the sourceFloor, destinationFloor and the
 * timeEntered parameter for the request that is placed.
 *
 */
public class Request {
	private  int sourceFloor;
	private int destinationFloor;
	private int timeEntered;
	private int numOfFloors;
	
	
	/**
	 * Constructor which randomly sets the source floor and destination floor for the Request. The destination and soruce floor should be different.
	 * @param numOfFloors This is the total number of Floors in the building which is used to constuct the Request
	 */
	public Request(int numOfFloors) {
		setSourceFloor((int)(Math.random()* numOfFloors +1)); // randomly assign source floor
		setDestinationFloor((int)(Math.random()* numOfFloors +1)); // randomly assigns destination floor
		if (sourceFloor==destinationFloor) { // if source and destination floor are the same randomly assign another floor as the destination floor
			setDestinationFloor((int)(Math.random()* numOfFloors +1));
		}
	}

	/**
	 * Accessor method for the sourceFloor 
	 * @return sourceFloor which is where a request to be picked up by the elevator starts from
	 */
	public int getSourceFloor() {
		return sourceFloor;
	}

	/**
	 * Mutator method to assign the source floor  as the parameter
	 * @param sourceFloor This is is the floor being set as sourceFloor of a Request. (where to pick up a person initially from)
	 */
	public void setSourceFloor(int sourceFloor) {
		this.sourceFloor = sourceFloor;
	}

	/**
	 * Accessor method for the destinationFloor 
	 * @return destinationFloor which is the floor where a request to be dropped of by the elevator is
	
	 */
	public int getDestinationFloor() {
		return destinationFloor;
	}

	/**
	 * Mutator method to assign the destination floor  as the parameter
	 * @param destinationFloor This is is the floor being set as destination of a Request. (where to drop off a person aftre they get on the elevator)
	 * 
	 */
	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}
	
	/**
	 * Accessor method to for timeEntered
	 * @return timeEntered, which is the time unit at which a request is created
	 */
	public int getTimeEntered() {
		return timeEntered;
	}

	/**
	 * Mustator method to assign the timeEntered as the parameter
	 * @param timeEntered, the time unit at which a request is created
	 */
	public void setTimeEntered(int timeEntered) {
		this.timeEntered = timeEntered;
	}

	/**
	 * accessor method for the number of floors in the building
	 * @return the total number of floors in the building
	 */
	public int getNumOfFloors() {
		return numOfFloors;
	}

	/**
	 * Mutator method to assign the number of floors in the building based on the parameters
	 * @param numOfFloors the total number of floors in a building used to create a request
	 */
	public void setNumOfFloors(int numOfFloors) {
		this.numOfFloors = numOfFloors;
	}

	@Override
	/**
	 * prints out the contects of the requests in the form of the (sourceFloor, destinationFloors, timeEntered)
	 */
	public String toString(){
		return "(" + sourceFloor + ", " + destinationFloor + ", " + timeEntered + ")";
	}
	
	
	
}
