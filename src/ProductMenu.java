/**
 * The abstract class on the other side of the bridge
 */
public interface ProductMenu {

	Person person = new Person() {
		@Override
		public void showMenu() {

		}

		@Override
		public ProductMenu CreateProductMenu() {
			return null;
		}
	};

	/**
	 * implemented by Meat and Produce class according to thier own needs
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
