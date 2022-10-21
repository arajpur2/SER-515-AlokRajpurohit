/**
 * Iterator Design Pattern
 * A concrete subclass of ListIterator that iterate the OfferingList
 */

@SuppressWarnings("all")
public class OfferingIterator {

	private OfferingList offeringList;

	private int current;

	public OfferingIterator(OfferingList offeringList) {
		this.offeringList = offeringList;
		this.current = -1;
		this.size = this.offeringList.getOffering().length;
	}

	private final int size;

	/**
	 * If in the OfferingIterator there exists the "next", return true; else 
	 * return false.
	 */
	public boolean hasNext() {
		return size - current > 1;
	}

	/**
	 * If hasNext, return the next offering, move the current Item to the 
	 * next offering. Else return null
	 */
	public Offering next() {
		if(!hasNext())
			return null;
		Offering offering = (Offering) this.offeringList.getOffering()[current+1];
		current += 1;
		return offering;
	}

	/**
	 * Set the current offering to the location before the first offering
	 */
	public void moveToHead() {
		this.current = -1;
	}

	/**
	 * Remove the current offering from the list
	 */
	public void remove() {
		this.offeringList.getOffering()[current] = null;
	}

}
