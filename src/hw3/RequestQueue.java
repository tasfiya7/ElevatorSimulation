/**
 * Tasfiya Mubasshira
 * 114870281
 * sec 7
 */

package hw3;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * 
 * @author Tasfiya Mubasshira
 * 
 * The <code>RequestQueue</code> class adds(enqueue) or removes (dequeue) a node (Request) to/from
 * the queue that is in the form of a Linked List. It also allows you to see (peek) the first request in the queue. 
 *
 */
public class RequestQueue extends LinkedList<Request> {
	
	private int size; // measures the size of the Queue
	
	/**
	 * Constructor for a Queue which is initially empty so the size is set to 0
	 */
	public RequestQueue() {
		size=0;
	}

	/**
	 * A Request is added to the Queue
	 * @param r This is the request that is being added to the queue
	 */
	public void enqueue(Request r) {
		add(r);
		size++;
	}
	
	/**
	 * The request that is first in the queue is removed from the queue because it is being handled/processed
	 * @return the request that is being handled in the simulation
	 */
	public Request dequeue() {
		
		try {
		size--;
		return removeFirst();
		}
		catch(NoSuchElementException ie) {
			System.out.println("There is no item in the queue to remove.");
		}
		return null;
	}
	
	
	/**
	 * @return the request in the queue that is next to being taken off and handled, without removing it from the actual queue 
	 */
	public Request peek() {
		return peekFirst();
	}
	
	/**
	 * @return size (the size of the queue)
	 */
	public int size() {
		return this.size;
	}
	
	
	/**
	 * @return true/false depending on if the queue is empty or not by checking the variable: size
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	
}
