import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A concrete subclass of ListIterator that iterates the ProductList
 */
public class ProductIterator<Product> implements Iterator<Product> {

	private final ClassProductList classProductList;

	private int current;

	public ProductIterator(ClassProductList classProductList) {
		this.classProductList = classProductList;
		this.current = -1;
		this.size = this.classProductList.getProducts().size();
	}

	private final int size;


	/**
	 * If in the ProductIterator there exists the "next", return true; else 
	 * return false
	 */
	public boolean hasNext() {
		return size - current > 1;
	}

	/**
	 * If hasNext, return the next product, move the current Item to the 
	 * next product. Else return null
	 */
	public Product next() {
		if(!hasNext())
			return null;
		Product product = (Product) this.classProductList.getProducts().get(current+1);
		current += 1;
		return product;
	}

	/**
	 * Set the current product to the location before the first product
	 */
	public void moveToHead() {
		this.current = -1;
	}

	/**
	 * Remove the current product from the list
	 */
	public void remove() {
		this.classProductList.getProducts().remove(current);
	}
}
