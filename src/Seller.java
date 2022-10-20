/**
 * The concrete subclass of Person
 */
public class Seller extends Person {

	public Seller(String username, String password) {
		super(username, password);
	}

	/**
	 * According to the need of seller show the appropriate items on 
	 * the menu.
	 */
	public void showMenu() {

	}

	/**
	 * show the combo boxes if required
	 */
	public ProductMenu CreateProductMenu() {
		return null;
	}

}
