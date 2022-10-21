import java.util.ArrayList;

/**
 * Bridge Design pattern
 * The abstract class on one side of the bridge.
 * Template of the logged-in user
 */

@SuppressWarnings("all")
public abstract class Person {

	/**
	 * Variables to store the username and password of the Person
	 * This is the Person who is logged in
	*/
	private String username;

	private String password;

	/**
	 * Variable of ProductMenu. Use this variable to point to a concrete
	 * productMenu object. Later, it will operate the object
	 */
	private ProductMenu theProductMenu;  // Factory Design Pattern

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	/**
	 * Variable to store the list of products associated with the logged-in user
	 */
	private ArrayList<Product> productList;

	public ProductMenu getTheProductMenu() {
		return theProductMenu;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Person(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	/**
	 * Overridden by the class: buyer and seller to show the menu
	 */
	public abstract void showMenu();

	/**
	 * Call the implementation to show the "add" buttons
	 */
	public void showAddButton() {
		this.theProductMenu.showAddButton();
	}

	/**
	 * Call the implementation to show the "view" buttons
	 */
	public void showViewButton() {
		this.theProductMenu.showViewButton();
	}

	/**
	 * Call the implementation to show the radio buttons
	 */
	public void showRadioButton() {
		this.theProductMenu.showRadioButton();
	}

	/**
	 * Call the implementation to show the labels
	 */
	public void showLabels() {
		this.theProductMenu.showLabels();
	}

	public void setTheProductMenu(ProductMenu theProductMenu) {
		this.theProductMenu = theProductMenu;
	}

	/**
	 * Overridden by the class: buyer and seller to create the menu. The abstract factory method
	 */
	public abstract ProductMenu createProductMenu(int menuType, ClassProductList theProductList);

}
