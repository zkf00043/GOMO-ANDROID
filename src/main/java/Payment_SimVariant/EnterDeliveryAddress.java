package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class EnterDeliveryAddress {

	public static void Enter_DeliveryAddress() throws Exception {
		
		try {
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard","Shop");
			GomoxFunction.click("Shop","GomoSim");
			Thread.sleep(2000);
			GomoxFunction.scrollToText("30GB No Expiry");
			Thread.sleep(1000);
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "AddToCart");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "Cart");
			Thread.sleep(5000);
			
			
			GomoxFunction.click("PurchaseSim", "EnterAddress");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			GomoxFunction.AddAddress(1);
			
			Control.click("CreateAccount", "AccountCreationCB");
			Control.click("DeliveryAddress","AddAddress");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("DeliveryAddress", "ConfirmRecipient");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.objExists("Cart", "PromoFreeUnli30", true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
