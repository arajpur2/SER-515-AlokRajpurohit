
@SuppressWarnings("all")
/**
 * Visitor Design pattern
 */
public class ReminderVisitor extends NodeVisitor {

	/**
	 * Reminder object
	 */
	private Reminder m_Reminder;

	private ClassProductList classProductList;

	/**
	 * When visiting Façade, it will in turn visit each product in the 
	 * Façade.productList
	 */
	public void visitProduct(Product product) {

	}

	/**
	 * When visiting a trading, it will compare the current date and the 
	 * due date of the trading and show the proper reminding 
	 * information on the Reminder. (The client)
	 */
	public void visitTrading(Trading trading) {

	}

	/**
	 * When visiting Façade, it will in turn visit each product in the 
	 * Façade.productList
	 */
	public void visitFacade(Facade facade) {

	}

}
