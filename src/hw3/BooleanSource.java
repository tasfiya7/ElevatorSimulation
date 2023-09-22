/**
 * Tasfiya Mubasshira
 * 114870281
 * sec 7
 */
package hw3;

/**
 * 
 * @author Tasfiya Mubasshira
 * The <code>BooleanSource</code> class randomly returns true or false if a request arrives based on the probability entered by the user
 * This code is used from the lecture slides
 */
public class BooleanSource {

	private double probability;

    /**
     * Constructor for class which checks if the value of the probablity eneteres is valid and if it is, it is set to the variable probability
     * 
     * @param p the probablity value entered by the user.
     * @throw IllegalArugumentException if the value is not between 0.0 and 1.0
     */
    public BooleanSource(double p) throws IllegalArgumentException {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException("The probability must be between 0.0 and 1.0");
        probability = p;
    }

    /**
     * Shows if the request arrives based on whether simulator probablity is correctly generated.
     *
     * @return true if the probablity is less that what is entered by the user
     */
    public boolean requestArrived() {
        return (Math.random() < probability);
    }
	
	
	
}
