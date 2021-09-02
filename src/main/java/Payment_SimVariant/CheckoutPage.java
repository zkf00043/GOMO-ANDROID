package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class CheckoutPage {

	public static void Checkout_Page() throws Exception {
		try {
			
			Control.click("GomoSim", "UnliData30");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddToCart");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.click("GomoSim", "Cart");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.objExists("Cart", "PromoNameUnli30", true);
			Control.objExists("Cart", "PromoPriceUnli30", true);
			Control.objExists("Cart", "PromoFreeUnli30", true);
			
			Control.objExists("Cart", "Quantity", true);
			
			Control.objExists("GetGomo", "SubQty", true);
			Control.objExists("GetGomo", "AddQty", true);
			Control.objExists("GetGomo", "SLA", true);
			
			
			GomoxFunction.click("PurchaseSim", "EnterAddress");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			GomoxFunction.AddAddress(1);
			
			Thread.sleep(1000);
			GomoxFunction.click("CreateAccount", "DataPrivacy");
			Thread.sleep(1000);
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(1000);
			GomoxFunction.click("CreateAccount", "PrivacyPol");
			Thread.sleep(1000);
			Control.takeScreenshot();
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(2000);
			
			Control.click("CreateAccount", "AccountCreationCB");
			Control.click("DeliveryAddress","AddAddress");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("DeliveryAddress", "ConfirmRecipient");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			
			Thread.sleep(2000);
			Control.click("Cart","Checkout");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Thread.sleep(2000);
			Control.click("Checkout","NextBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
