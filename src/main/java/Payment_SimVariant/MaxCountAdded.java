package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class MaxCountAdded {

	public static void Max_CountAdded() throws Exception {

		try {
			Thread.sleep(1000);
			
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.click("GetGomo", "AddQty");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddToCart");
			GomoxFunction.objExist("Cart", "ReachedMaxSims", true);
			Thread.sleep(2000);
			
			Control.click("GetGomo", "AddQty");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddToCart");
			GomoxFunction.objExist("Cart", "ReachedMaxSims", true);
			Thread.sleep(2000);
			
			GomoxFunction.clickByLocation("5,122,147,264");
			Thread.sleep(1000);
//			GomoxFunction.scrollToText("P299");
//			Thread.sleep(1000);
			
			Control.click("GomoSim", "UnliData30");
			Thread.sleep(1000);
			Control.click("GetGomo", "AddQty");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddToCart");
			GomoxFunction.objExist("Cart", "ReachedMaxSims", true);
			Thread.sleep(2000);
			
			Control.click("GetGomo", "AddQty");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddToCart");
			GomoxFunction.objExist("Cart", "ReachedMaxSims", true);
			Thread.sleep(2000);
			
			Control.click("GetGomo", "BuyNowBtn");
			Control.takeScreenshot();
			Control.objExists("Checkout", "Total", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
