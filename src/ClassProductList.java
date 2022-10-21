import java.util.ArrayList;

/**
 * Iterator Design Pattern
 * The abstract class of the list to be iterated
 */

@SuppressWarnings("all")
public class ClassProductList {

	private ReminderVisitor reminderVisitor;

	public ClassProductList(ArrayList<Product> products) {
		this.products = products;
	}

	private ArrayList<Product> products;

	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * To track all the nodes
	 */
	public void accept(NodeVisitor visitor) {
		System.out.println("VISITOR NODE ACCEPTED AND MARKED");
	}

}
