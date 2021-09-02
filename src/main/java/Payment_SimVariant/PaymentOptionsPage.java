package Payment_SimVariant;

import utility.Control;
import utility.GomoxFunction;

public class PaymentOptionsPage {

	public static void Payment_OptionPage() throws Exception {

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
			
			Control.click("Cart", "SelectAllCB");
			Thread.sleep(500);
			Control.takeScreenshot();
			Control.click("Cart", "Checkout");
			Thread.sleep(5000);
			
			Control.click("ShippingDetails", "NextBtn");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			
			Control.click("PaymentOption", "CB_CreditDebit");
			Thread.sleep(3000);
			Control.takeScreenshot();
			
			Control.click("PaymentOption", "CB_Gcash");
			Thread.sleep(3000);
			Control.takeScreenshot();
			
			Control.objExists("OrderSummary", "EditBtn", true);
			
			Control.objExists("OrderSummary", "SKU", true);
			Control.objExists("OrderSummary", "SKUQuantitty", true);
			Control.objExists("OrderSummary", "SKUPrice", true);
			
			Control.objExists("OrderSummary", "SimCard", true);
			Control.objExists("OrderSummary", "SimQuantity", true);
			Control.objExists("OrderSummary", "SimPrice", true);
			
			Control.objExists("OrderSummary", "DeliveryFee", true);
			Control.objExists("OrderSummary", "DeliveryText", true);
			
			Control.objExists("OrderSummary", "OrderTotal", true);
			Control.objExists("OrderSummary", "TotalPrice", true);
			
			Thread.sleep(3000);
			
			Control.click("OrderSummary", "EditBtn");
			Thread.sleep(4000);
			Control.takeScreenshot();
			
			Control.click("Cart", "Checkout");
			Thread.sleep(5000);
			
			Control.click("ShippingDetails", "NextBtn");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.objExists("DeliverTo", "EditBtn", true);
			Control.objExists("DeliverTo", "Name", true);
			Control.objExists("DeliverTo", "Address", true);
			Control.objExists("DeliverTo", "Email", true);
			Control.objExists("DeliverTo", "MobileNumber", true);
			Control.objExists("DeliverTo", "EstimateDate", true);
			Control.objExists("DeliverTo", "Days", true);
			
			
			Control.click("DeliverTo", "EditBtn");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.click("DeliveryAddress", "ConfirmRecipient");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
