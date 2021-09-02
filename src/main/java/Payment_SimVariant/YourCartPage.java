package Payment_SimVariant;

import utility.Constant;
import utility.Control;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class YourCartPage {

	public static void Your_CartPage() throws Exception {
		try {
			Thread.sleep(3000);
			Control.takeScreenshot();
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "AddToCart");
			GomoxFunction.objExist("Cart", "AddedNotif", true);
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "Cart");
			
//			GomoxFunction.objExist("Cart", "DeliverTo", true);
//			GomoxFunction.objExist("Cart", "YourCart", true);
//			GomoxFunction.objExist("Cart", "SelectAll", true);
//			GomoxFunction.objExist("Cart", "30GB", true);
//			GomoxFunction.objExist("Cart", "Value1", true);
//			
//			Thread.sleep(2000);
//			GomoxFunction.swipe(Direction.up);
//
//			Thread.sleep(2000);
////			GomoxFunction.scrollToText("Please note that deliveries may take longer due to the inclement weather.");
////			Thread.sleep(2000);
//			GomoxFunction.objExist("Cart", "Deliver", true);
//			GomoxFunction.objExist("Cart", "DeliverNote", true);
//			Control.takeScreenshot();
//			GomoxFunction.swipe(Direction.up);
//			Thread.sleep(3000);
//			
////			
////			//For Testing only
////			Thread.sleep(2000);
////			GomoxFunction.swipe(Direction.up); // Removed when there is a address
//			
//			Thread.sleep(1000);
//			Control.takeScreenshot();
//			GomoxFunction.objExist("Cart", "TrackingHeader", true);
//			GomoxFunction.objExist("Cart", "TrackingNote1", true);
//			GomoxFunction.objExist("Cart", "TrackingNote2", true);
//			
//			GomoxFunction.objExist("Cart", "Total", true);
//			GomoxFunction.objExist("Cart", "Checkout", true);
//			
//			
//			GomoxFunction.swipe(Direction.down);
//			Thread.sleep(3000);
//			GomoxFunction.swipe(Direction.down);
//			Thread.sleep(3000);		
////			GomoxFunction.scrollToText("Deliver to:");
//			
//			//GomoxFunction.click("PurchaseSim", "EnterAddress"); //Uncomment this for actual testing scenarios
//			
//			//<Remarks> This is for testing only removed when actual testing data should not have a address added
//			GomoxFunction.click("Cart", "ChangeAddress");
//			
//			Control.click("DeliveryAddress", "AddNewAddress");
//			
//			//</Remarks>
//			
//			GomoxFunction.AddAddress(2);
//			Control.click("CreateAccount", "AccountCreationCB");
//			Control.click("DeliveryAddress","AddAddress");
//			Thread.sleep(2000);
//			Control.takeScreenshot();
//			Control.click("DeliveryAddress", "ConfirmRecipient");
//			Thread.sleep(2000);
//			Control.takeScreenshot();
			GomoxFunction.click("Cart", "ChangeAddress");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			//1st Manage 864 , 998
			//2nd Manage 864 , 1415
			GomoxFunction.click("", "Manage");
//			GomoxFunction.clickByLocation("864,941,357,996"); 
			GomoxFunction.click("DeliveryAddress", "UpdateAddress");
			GomoxFunction.AddAddress(4);
			Control.click("CreateAccount", "AccountCreationCB");
			Control.click("Account","SavedAddress");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("DeliveryAddress", "ConfirmRecipient");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			GomoxFunction.objExist("", Constant.UnitNo ,true);
			GomoxFunction.objExist("", Constant.StreetName , true);
			GomoxFunction.objExist("", Constant.Province , true);
			GomoxFunction.objExist("", Constant.City , true);
			GomoxFunction.objExist("", Constant.Barangay , true);
			GomoxFunction.objExist("", Constant.ZipCode , true);
			
			
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			GomoxFunction.objExist("Cart", "Deliver", true);
			GomoxFunction.objExist("Cart", "DeliverNote", true);
			GomoxFunction.objExist("Cart", "TrackingHeader", true);
			GomoxFunction.objExist("Cart", "TrackingNote1", true);
			GomoxFunction.objExist("Cart", "TrackingNote2", true);
			
			GomoxFunction.objExist("Cart", "Total", true);
			GomoxFunction.objExist("Cart", "Checkout", true);
			
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(3000);
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(3000);
			Control.click("Cart", "SelectAllCB");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
