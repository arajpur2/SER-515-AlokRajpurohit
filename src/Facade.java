/**
 * The interface class between the GUI and the underlining system, the control logic and many of the operating functions are included in this class
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

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

	public Person getThePerson() {
		return thePerson;
	}

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
			for(int i=0; i< lines.length; i++){
				if(lines[i].split(":")[0].equals(username)){
					if(lines[i].split(":")[1].equals(password)){
						if(this.userType == 0) {
							this.createUser(new Buyer(username, password));
						} else {
							this.createUser(new Seller(username, password));
						}
						return true;
					}
					else
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
		System.out.println("reminder set successfully");
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

	}

	/**
	 * Call this function after creating the user. Create productList by 
	 * reading the UserProduct.txt file. Match the product name with 
	 * theProductList. Attach the matched product object to the new 
	 * create user: Facade.thePerson. ProductList
	 */
	public void attachProductToUser() {

	}

	/**
	 * Show the Product list in a Dialog and return the selected product.
	 */
	public void SelectProduct() {

	}

	/**
	 * This function will call the thePerson. CreateProductMenu0 
	 * According to the real object (buyer or seller) and the 
	 * productLevel, it will call different menu creator and show the 
	 * menu differently according to the usertype
	 */
	public void productOperation() {

	}

}
