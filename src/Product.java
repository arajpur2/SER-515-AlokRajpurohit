/**
 * Template of every product
 */
public class Product {
	public Product(String category, String name) {
		this.category = category;
		this.name = name;
	}

	private String category;

	private String name;

	private Trading trading;

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return this.name + "," + this.category;
	}
}
