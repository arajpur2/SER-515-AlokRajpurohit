/**
 * The interface class between the GUI and the underlining system, the control logic and many of the operating functions are included in this class
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@SuppressWarnings("all")
/**
 * Facde Design Pattern
 */
public class Facade {

	/**
	 * The type of the user: Buyer: 0, Seller 1
	 */
	private int userType;

	/**
	 * The object that holds the currently selected product.
	 */
	private Product theSelectedProduct;

	/**
	 * The list of products of the entire system.
	 */
	private ClassProductList theProductList;

	/**
	 * The list of products of the entire system.
	 */
	private Person thePerson;

	/**
	 * The selected product category: 0: Meat, 1: Produce.
	 */
	private int nProductCategory;

	/**
	 * Show login GUI and return the login result
	 */
	public boolean login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("*************WELCOME TO ALOK'S PRODUCT TRADING AND BIDDING SYSTEM!*************");
		System.out.println();
		System.out.println();
		System.out.print("PLEASE ENTER YOUR USERNAME: ");
		String username = sc.nextLine();
		System.out.print("PLEASE ENTER YOUR PASSWORD: ");
		String password = sc.nextLine();


		String[][] files = {{"data\\BuyerInfo.txt", "Buyer"},{"data\\SellerInfo.txt", "Seller"}};

		for(int j=0; j<2; j++){
			Path filePath = Paths.get(files[j][0]);
			if(files[j][1] == "Buyer"){
				this.userType = 0;
			} else {
				this.userType = 1;
			}

			String fileContent = null;
			try {
				fileContent = Files.readString(filePath);
			} catch (IOException e) {
				System.out.println("WARNING: DATABASE READ ERROR");
			}

			String[] lines = fileContent.split("\\r?\\n");
			for (String line : lines) {
				if (line.split(":")[0].equals(username)) {
					if (line.split(":")[1].equals(password)) {
						if (this.userType == 0) {
							this.createUser(new Buyer(username, password));
						} else {
							this.createUser(new Seller(username, password));
						}
						return true;
					} else
						return false;
				}
			}
		}

		return false;
	}

	/**
	 * When clicking the add button of the ProductMenu, call this 
	 * function. This function will add a new trade and fill in the required information. This function will be called
	 * SellerTradingMenu or BuyerTradingMenu based on the type of the user. It will not update the product menu. The product menu 
	 * needs to be refreshed outside the function.
	 */
	public void addTrading() {

	}

	/**
	 * When clicking the view button of the ProductMenu, call this 
	 * function and pass the pointer of the Trading and the person 
	 * pointer to this function.
	 * This function will view the trading information.
	 * This function will call SellerTradingMenu or BuyerTradingMenu 
	 * according to the type of the user.
	 */
	public void viewTrading() {

	}

	/**
	 * This function will view the given offering
	 */
	public void viewBidding() {

	}

	/**
	 * Set the deal flag of the given offering
	 */
	public void markBidding() {

	}

	/**
	 * Used by the buyer to submit the offering
	 */
	public void submitBidding() {

	}

	/**
	 * Show the remind box to remind buyer of the upcoming overdue 
	 * trading window
	 */
	public void remind() {
		Scanner sc2 = new Scanner(System.in);
		System.out.println("ENTER THE REMINDER NAME:");
		String reminderName = sc2.nextLine();
		System.out.println("ENTER THE REMINDER DESCRIPTION:");
		String reminderDesc = sc2.nextLine();
		System.out.println("ENTER THE REMINDER DEADLINE TIME:");
		String reminderTime = sc2.nextLine();
		Reminder reminder = new Reminder(reminderName, reminderDesc, reminderTime);
		reminder.showReminder();
	}

	/**
	 * Create a user object according to the user info item, the object
	 * can be a buyer or a seller
	 */
	public void createUser(Person thePerson) {
		this.thePerson = thePerson;
		this.attachProductToUser();
	}

	/**
	 * Create the product list of the entire system
	 */
	public void createProductList() {
		String file = "data\\ProductInfo.txt";
		Path filePath = Paths.get(file);
		String fileContent = null;
		ArrayList<Product> products = new ArrayList<>();

		try {
			fileContent = Files.readString(filePath);
		} catch (IOException e) {
			System.out.println("WARNING: DATABASE READ ERROR");
		}

		String[] lines = fileContent.split("\\r?\\n");
		for(int i=0; i< lines.length; i++) {
			String productCategory = lines[i].split(":")[0];
			String productName = lines[i].split(":")[1];
			Product product = new Product(productCategory, productName);
			products.add(product);
		}

		this.theProductList = new ClassProductList(products);
	}

	/**
	 * Call this function after creating the user. Create productList by 
	 * reading the UserProduct.txt file. Match the product name with 
	 * theProductList. Attach the matched product object to the new 
	 * create user: Facade.thePerson.ProductList
	 */
	public void attachProductToUser() {
		this.createProductList();
		String file = "data\\UserProduct.txt";
		Path filePath = Paths.get(file);
		String fileContent = null;
		ArrayList<Product> products = new ArrayList<>();

		try {
			fileContent = Files.readString(filePath);
		} catch (IOException e) {
			System.out.println("WARNING: DATABASE READ ERROR");
		}

		assert fileContent != null;
		String[] lines = fileContent.split("\\r?\\n");
		for (String line : lines) {
			String username = line.split(":")[0];
			String productName = line.split(":")[1];
			if (this.thePerson.getUsername().equals(username)) {
				ProductIterator<Product> productIterator = new ProductIterator<>(this.theProductList);
				while (productIterator.hasNext()){
					Product product = productIterator.next();
					if(productName.equals((product.toString()).split(",")[0])){
						products.add(product);
					}
				}
			}
		}

		this.thePerson.setProductList(products);
	}

	public void showMenu(){
		System.out.println("\nTHE FULL MENU:");
		System.out.println("\nNAME			CATEGORY");
		System.out.println("____		   ________");
		System.out.println();
		ProductIterator<Product> iterator = new ProductIterator<>(this.theProductList);
		while (iterator.hasNext()) {
			Product product = iterator.next();
			System.out.println(product.getName() + "			" + product.getCategory());
		}
	}

	/**
	 * Show the Product list in a Dialog and return the selected product.
	 */
	public void selectProduct(ProductMenu produceMenu, ProductMenu meatMenu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n1. VIEW PRODUCE MENU");
		System.out.println("2. VIEW MEAT MENU");
		System.out.println("3. VIEW THE FULL MENU");
		System.out.println("4. VIEW YOUR PRODUCTS");
		System.out.println("5. ADD A PRODUCT");
		System.out.println("6. SET REMINDER");
		System.out.println("PLEASE ENTER YOUR CHOICE!");
		int choice = 0;

		try {
			choice = sc.nextInt();
		} catch (Exception e){
			System.out.println("PLEASE ENTER CHOICE NUMBERS ONLY");
		}

		switch (choice){
			case 1:
				produceMenu.showMenu();
				break;
			case 2:
				meatMenu.showMenu();
				break;
			case 3:
				this.showMenu();
				break;
			case 4:
				this.thePerson.showMenu();
				break;
			case 5:
				this.showMenu();
				System.out.println("\nPLEASE ENTER THE NAME OF THE PRODUCT YOU WANT TO ADD:");
				Scanner sc1 = new Scanner(System.in);
				String productName = sc1.nextLine();

				File f1 = new File("data\\UserProduct.txt");
				ArrayList<Product> products = this.theProductList.getProducts();
				ProductIterator<Product> productIterator = new ProductIterator<>(this.theProductList);
				boolean repetitionFlag = false;
				boolean notFoundFlag = true;

				while(productIterator.hasNext()){
					Product product = productIterator.next();
					if (product.getName().equalsIgnoreCase(productName)){
						notFoundFlag = false;
					}
				}

				ClassProductList theProductList = new ClassProductList(this.thePerson.getProductList());
				productIterator = new ProductIterator<>(theProductList);
				while(productIterator.hasNext()){
					Product product = productIterator.next();
					if (product.getName().equalsIgnoreCase(productName)){
						repetitionFlag = true;
					}
				}


				if (notFoundFlag || repetitionFlag){
					System.out.println("\nTHIS PRODUCT CAN'T BE ADDED EITHER BECAUSE IT IS NOT PRESENT IN THE MAIN LIST OR YOU ALREADY HAVE IT IN YOUR LIST OF PRODUCTS.");
				} else {
					try {
						FileWriter fileWriter = new FileWriter(f1,true);
						BufferedWriter bw = new BufferedWriter(fileWriter);
						bw.write("\n"+this.thePerson.getUsername()+":"+productName);
						bw.close();
					} catch (Exception e){
						System.out.println("DATABASE WRITE ERROR");
					}
				}

				System.out.println("THE PRODUCT HAS BEEN ADDED SUCCESSFULLY!");
				break;
			case 6:
				this.remind();
				break;
			default:
				System.out.println("WRONG CHOICE");
		}
	}

	/**
	 * This function will call the thePerson. CreateProductMenu0 
	 * According to the real object (buyer or seller) and the 
	 * productLevel, it will call different menu creator and show the 
	 * menu differently according to the usertype
	 */
	public void productOperation() {
		System.out.println("*************WELCOME TO ALOK'S PRODUCT TRADING AND BIDDING SYSTEM!*************");
		System.out.println();
		System.out.println();
		System.out.println("CUSTOMER USERNAME: " + this.thePerson.getUsername());
		System.out.println("CUSTOMER TYPE: " + ((this.userType == 0) ? "Buyer" : "Seller"));
		ProductMenu produceMenu = this.thePerson.createProductMenu(0, this.theProductList);
		ProductMenu meatMenu = this.thePerson.createProductMenu(1, this.theProductList);
		this.selectProduct(produceMenu, meatMenu);
	}

}
