/**
 * Iterator Design Pattern
 * Subclass of ArrayList. One concreted List class that needs to be iterated
 */
@SuppressWarnings("all")
public class OfferingList {

	private Trading trading;

	private Offering[] offering;

	private OfferingIterator offeringIterator;

	public Offering[] getOffering() {
		return offering;
	}
}
