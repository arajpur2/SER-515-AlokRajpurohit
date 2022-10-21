/**
 * Visitor Design pattern
 * The abstract class of the visitor, it can visit class: Façade, Trading, Product. 
 * The real work that need to be done will be implemented in the concrete 
 * visitor classes.
 */

@SuppressWarnings("all")
public abstract class NodeVisitor {

	/**
	 * abstract method which is implemented by any class which wants to traverse every part of the application.
	 */
	public abstract void visitProduct(Product product);

	/**
	 * abstract method which is implemented by any class which wants to traverse every part of the application.
	 */
	public abstract void visitTrading(Trading trading);

	/**
	 * abstract method which is implemented by any class which wants to traverse every part of the application.
	 */
	public abstract void visitFacade(Facade facade);

}
