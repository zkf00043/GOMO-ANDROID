package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class DeleteSoldOutItems {

	public static void DeeteSold_OutItems() throws Exception {
		try {
			
			//TODO Validate Sold Out section column 192
			
			
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			GomoxFunction.objExist("RemoveSim", "DeleteNote", true);
			GomoxFunction.objExist("RemoveSim", "Cancel", true);
			GomoxFunction.objExist("RemoveSim", "Remove", true); 
			
			GomoxFunction.click("RemoveSim", "Remove");
			GomoxFunction.objExist("RemoveSim", "SimRemoveNote", true);
			Thread.sleep(2000);
			Control.objExists("Cart", "EmptyCartText", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
