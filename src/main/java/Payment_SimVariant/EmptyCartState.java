package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class EmptyCartState {

	public static void Empty_CartState() throws Exception {
		
		try {
			GomoxFunction.click("Dashboard", "Shop");
			Thread.sleep(2000);
			GomoxFunction.click("Shop", "GomoSim");
			Thread.sleep(2000);
			Control.click("GomoSim","Cart");
			Thread.sleep(4000);
			Control.takeScreenshot();
			
			Control.objExists("Cart", "DeliverText", true);
			Control.objExists("Cart", "EnterAddress", true);
			Control.objExists("Cart", "YourCart", true);
			Control.objExists("Cart", "EmptyCartText", true);
			Control.objExists("Cart", "GoToGomoShop", true);
			Control.objExists("Cart", "Checkout", true);
			
			Control.click("Cart", "GoToGomoShop");
			Thread.sleep(5000);
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
