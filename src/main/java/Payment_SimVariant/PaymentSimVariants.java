package Payment_SimVariant;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;

public class PaymentSimVariants {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("PaymentSimVariants");
			Payment_SimVariants();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}
	
	public static void Payment_SimVariants() throws Exception 
	{
		//TODO all payment sim variants 
		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(5000);
		
//		Generic.WriteTestCase("Payment (SIM Variants) - Empty Cart State", "", "Expected Result", "Actual Result");
//		EmptyCartState.Empty_CartState();
//		Generic.TestScriptEnds();
		
		//<Remarks> For testing pleae remove this block of script
//		GomoxFunction.click("Dashboard", "Shop");
//		Thread.sleep(2000);
//		GomoxFunction.click("Shop", "GomoSim");
//		Thread.sleep(2000); //</Remarks>
//		
//		
//		GomoxFunction.scrollToText("P299");
//		Thread.sleep(1000);
		
		
//		Generic.WriteTestCase("Payment (SIM Variants) - Your Cart Page", "", "Expected Result", "Actual Result");
//		YourCartPage.Your_CartPage();
//		Generic.TestScriptEnds();
		
		
		//<Remarks> Uncomment if it is single run
		
//		Control.click("Cart", "SelectAllCB");
//		Thread.sleep(2000);
//		Control.takeScreenshot();
//		Control.click("GetGomo", "AddQty");
//		Thread.sleep(2000);
//		Control.click("GetGomo", "AddQty");
//		Control.click("Cart", "BackBtn");	
		//</Remarks>
		
//		Generic.WriteTestCase("Payment (SIM Variants) - Product Details (Max Count Added)", "", "Expected Result", "Actual Result");
//		MaxCountAdded.Max_CountAdded();
//		Generic.TestScriptEnds();
//		
		
//		Generic.WriteTestCase("Payment (SIM Variants) - Cart Page (Delete Items)", "", "Expected Result", "Actual Result");
//		CartPageDeleteItems.CartPage_DeleteItems();
//		Generic.TestScriptEnds();
		
		
		Generic.WriteTestCase("Payment (SIM Variants) - Payment Options Page", "", "Expected Result", "Actual Result");
		PaymentOptionsPage.Payment_OptionPage();
		Generic.TestScriptEnds();
		
	}

}
