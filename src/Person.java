/**
 * The abstract class on one side of the bridge
 */
public abstract class Person {

	/**
	 * Variable of ProductMenu. Use this variable to point to a concrete 
	 * productMenu object. Later, it will operate the object
	 */
	private ProductMenu theProductMenu;

	private ProductMenu productMenu;

	/**
	 * Overridden by the class: buyer and seller to show the menu
	 */
	public abstract void showMenu();

	/**
	 * Call the implementation to show the "add" buttons
	 */
	public void showAddButton() {

	}

	/**
	 * Call the implementation to show the "view" buttons
	 */
	public void showViewButton() {

	}

	/**
	 * Call the implementation to show the radio buttons
	 */
	public void showRadioButton() {

	}

	/**
	 * Call the implementation to show the labels
	 */
	public void showLabels() {

	}

	/**
	 * Overridden by the class: buyer and seller to create the menu. The abstract factory method
	 */
	public abstract ProductMenu CreateProductMenu();

}
