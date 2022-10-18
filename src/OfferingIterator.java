/**
 * A concrete subclass of ListIterator that iterate the OfferingList
 */
public class OfferingIterator {

	private OfferingList offeringList;

	/**
	 * If in the OfferingIterator there exists the "next", return true; else 
	 * return false.
	 */
	public boolean hasNext() {
		return false;
	}

	/**
	 * If hasNext, return the next offering, move the current Item to the 
	 * next offering. Else return null
	 */
	public Offering next() {
		return null;
	}

	/**
	 * Set the current offering to the location before the first offering
	 */
	public void moveToHead() {

	}

	/**
	 * Remove the current offering from the list
	 */
	public void remove() {

	}

}
