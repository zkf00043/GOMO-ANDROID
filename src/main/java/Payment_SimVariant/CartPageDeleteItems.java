package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class CartPageDeleteItems {

	public static void CartPage_DeleteItems() throws Exception {
		try {
			
			//<Remarsks> Uncomment this if single flow 
			Control.click("GomoSim", "Cart");
			Thread.sleep(5000);
			//</Remarks>
			
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			GomoxFunction.objExist("RemoveSim", "DeleteNote", true);
			GomoxFunction.objExist("RemoveSim", "Cancel", true);
			GomoxFunction.objExist("RemoveSim", "Remove", true); 
			
			GomoxFunction.click("RemoveSim", "Cancel");
			Thread.sleep(2000);
			Control.objExists("Cart", "Quantity", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
