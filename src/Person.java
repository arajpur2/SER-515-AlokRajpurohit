/**
 * The abstract class on one side of the bridge
 */
public abstract class Person {

	private String username;
	private String password;

	/**
	 * Variable of ProductMenu. Use this variable to point to a concrete 
	 * productMenu object. Later, it will operate the object
	 */
	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	public Person(String username, String password, ProductMenu theProductMenu, ProductMenu productMenu) {
		this.username = username;
		this.password = password;
		this.theProductMenu = theProductMenu;
		this.productMenu = productMenu;
	}

	/**
	 * Overridden by the class: buyer and seller to show the menu
	 */
	public abstract void showMenu();

	/**
	 * Call the implementation to show the "add" buttons
	 */
	public void showAddButton() {
		System.out.println("ADD BUTTON ADDED!");
	}

	/**
	 * Call the implementation to show the "view" buttons
	 */
	public void showViewButton() {
		System.out.println("VIEW BUTTON ADDED!");
	}

	/**
	 * Call the implementation to show the radio buttons
	 */
	public void showRadioButton() {
		System.out.println("RADIO BUTTONS ADDED!");
	}

	/**
	 * Call the implementation to show the labels
	 */
	public void showLabels() {
		System.out.println("ALL LABELS ADDED!");
	}

	/**
	 * Overridden by the class: buyer and seller to create the menu. The abstract factory method
	 */
	public abstract ProductMenu CreateProductMenu();

}
