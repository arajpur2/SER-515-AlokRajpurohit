/**
 * The abstract class on the other side of the bridge
 */
public interface ProductMenu {

	/**
	 * implemented by Meat and Produce class according to their own needs
	 */
	public abstract void showMenu();

	/**
	 * To show the add buttons
	 */
	public abstract void showAddButton();

	/**
	 * To show the view buttons
	 */
	public abstract void showViewButton();

	/**
	 * To show the radio buttons
	 */
	public abstract void showRadioButton();

	/**
	 * To show the labels
	 */
	public abstract void showLabels();

	/**
	 * To show the combo boxes if needed.
	 */
	public abstract void showComboxes();

}
