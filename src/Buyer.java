/**
 * The concrete subclass of Person
 */
public class Buyer extends Person {

	public Buyer(String username, String password, ProductMenu theProductMenu, ProductMenu productMenu) {
		super(username, password, theProductMenu, productMenu);
	}

	/**
	 * According to the need of buyer show the appropriate items on 
	 * the menu.
	 */
	public void showMenu() {

	}

	/**
	 * Overridden by the class: buyer and seller to create the menu
	 */
	public ProductMenu CreateProductMenu() {
		return null;
	}

}
