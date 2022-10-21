/**
 * Bridge Design pattern
 * One concrete implementation of ProductMenu for the produce product
 */

@SuppressWarnings("all")
public class ProduceProductMenu implements ProductMenu {

	private ClassProductList productList;

	public ProduceProductMenu(ClassProductList productList) {
		this.productList = productList;
	}

	public ClassProductList getProductList() {
		return productList;
	}

	/**
	 * According to the type of menu show the appropriate items on
	 * the menu.
	 */
	public void showMenu() {
		System.out.println("\nTHE PRODUCE MENU:");
		System.out.println("\nNAME			CATEGORY");
		System.out.println("____		   ________");
		System.out.println();
		ProductIterator<Product> iterator = new ProductIterator<>(this.productList);
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getCategory().equals("Produce")){
				System.out.println(product.getName() + "			" + product.getCategory());
			}
		}
	}

	/**
	 * show the add buttons
	 */
	public void showAddButton() {
		System.out.println("ADD BUTTON DISPLAYED!");
	}

	/**
	 * show the radio buttons
	 */
	public void showRadioButton() {
		System.out.println("RADIO BUTTONS DISPLAYED!");
	}

	/**
	 * show the labels
	 */
	public void showLabels() {
		System.out.println("ALL LABELS DISPLAYED!");
	}

	/**
	 * show the view buttons
	 */
	public void showViewButton() {
		System.out.println("VIEW BUTTON DISPLAYED!");
	}

	/**
	 * show the combo boxes if required
	 */
	public void showComboxes() {
		System.out.println("COMBO-BOXES DISPLAYED!");
	}

}
