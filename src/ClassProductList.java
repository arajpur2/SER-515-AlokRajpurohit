import java.util.ArrayList;

/**
 * The abstract class of the list to be iterated
 */
public class ClassProductList {

	private ReminderVisitor reminderVisitor;

	public ClassProductList(ArrayList<Product> products) {
		this.products = products;
	}

	private ArrayList<Product> products;

	private ProductIterator productIterator;

	/**
	 * To track all the nodes
	 */
	public void accept(NodeVisitor visitor) {

	}

}
