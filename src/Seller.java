import java.util.ArrayList;

/**
 * Bridge Design pattern
 * The concrete subclass of Person
 */

@SuppressWarnings("all")
public class Seller extends Person {

	public Seller(String username, String password) {
		super(username, password);
	}

	/**
	 * According to the need of seller show the appropriate items on 
	 * the menu.
	 */
	public void showMenu() {
		ArrayList<Product> menuItems = this.getProductList();
		ClassProductList productList = new ClassProductList(menuItems);
		System.out.println("\nTHESE ARE THE CURRENT ITEMS WITH THE SELLER:");
		System.out.println("\nNAME			CATEGORY");
		System.out.println("____		   ________");
		System.out.println();
		ProductIterator<Product> iterator = new ProductIterator<>(productList);
		while (iterator.hasNext()){
			Product product = iterator.next();
			System.out.println(product.getName() + "			" + product.getCategory());
		}
	}

	/**
	 * show the combo boxes if required
	 */
	public ProductMenu createProductMenu(int menuType, ClassProductList theProductList) {
		ProductMenu menu;
		if(menuType == 0){
			menu = new MeatProductMenu(theProductList); //Factory Design Pattern
		} else {
			menu = new ProduceProductMenu(theProductList); //Factory Design Pattern
		}

		return menu;
	}

}
