/**
 * Visitor Design pattern
 * for every trading between a product and an offering
 */

@SuppressWarnings("all")
public class Trading {

	private Product product;

	private OfferingList offeringList;

	/**
	 * To track all the nodes
	 */
	public void accept(NodeVisitor visitor) {
		System.out.println("NODE MARKED AS  VISITED");
	}

}
