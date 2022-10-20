import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A concrete subclass of ListIterator that iterates the ProductList
 */
public class ProductIterator<Product> implements Iterator<Product> {

	private ClassProductList classProductList;

	private int current;

	public ProductIterator(ClassProductList classProductList) {
		this.classProductList = classProductList;
		this.current = 0;
		this.size = this.classProductList.getProducts().size();
	}

	private int size;


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
			throw new NoSuchElementException();
		Product product = (Product) this.classProductList.getProducts().get(current);
		current += 2;
		return product;
	}

	/**
	 * Set the current product to the location before the first product
	 */
	public void moveToHead() {
		this.current = 0;
	}

	/**
	 * Remove the current product from the list
	 */
	public void remove() {
		this.classProductList.getProducts().remove(current);
	}
}
