/**
 * A concrete subclass of ListIterator that iterates the ProductList
 */
public class ProductIterator {

	private ClassProductList classProductList;

	/**
	 * If in the ProductIterator there exists the "next", return true; else 
	 * return false
	 */
	public boolean hasNext() {
		return false;
	}

	/**
	 * If hasNext, return the next product, move the current Item to the 
	 * next product. Else return null
	 */
	public Product next() {
		return null;
	}

	/**
	 * Set the current product to the location before the first product
	 */
	public void moveToHead() {

	}

	/**
	 * Remove the current product from the list
	 */
	public void remove() {

	}

}
