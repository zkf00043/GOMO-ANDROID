package DawnRegressionPack0602;

import utility.Constant;
import utility.Control;
import utility.Email;
import utility.Generic;
import utility.GomoxFunction;

public class SimPurchase {

	public static void main(String[] args) throws Exception {

		try {
			Generic.TestScriptStart("SimPurchase");
			Sim_Purchase(false, false);
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();

		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}

	public static void Sim_Purchase(boolean LandingPage, boolean isGcash) throws Exception {
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			if (LandingPage)
				LandingPage(isGcash);
			else
				ShopPage(isGcash);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

	public static void LandingPage(boolean isGCash) throws Exception {
		Generic.WriteTestCase("SIM Purchase in landing page", "", "ExpectedResult", "ActualResult");
		try {
			Thread.sleep(5000);
			Control.takeScreenshot();
			GomoxFunction.click("LoginPage", "PurchaseSim");

			GomoxFunction.scrollToText("30GB with No Expiry");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();

			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();

			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();

			Control.click("PurchaseSim", "BuyNowBtn");
			Control.takeScreenshot();

			GomoxFunction.click("PurchaseSim", "EnterAddress"); // NEW FLOW
			Control.takeScreenshot();

			GomoxFunction.scrollToText("This Address");
			GomoxFunction.click("CreateAccount", "DataPrivacy");
			Thread.sleep(1000);
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(2000);
			GomoxFunction.click("CreateAccount", "PrivacyPol");
			Thread.sleep(2000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(2000);
			GomoxFunction.clickByLocation("0,117,66,264");
			Thread.sleep(1000);

			GomoxFunction.click("PurchaseSim", "EnterAddress"); // NEW FLOW

			Thread.sleep(1000);

			GomoxFunction.fillUpAddAddress();
			Thread.sleep(1000);

			GomoxFunction.scrollToText("This Address");
			
			Control.click("CreateAccount", "UseThisAddCB"); //Location [37,1445][95,1503]
			Thread.sleep(1000);
			Control.click("CreateAccount", "UseThisAddBtn");

			if (isGCash) 
			{
				Thread.sleep(3000);
				GomoxFunction.scrollToText("Next");
				Control.click("ShippingDetails", "NextBtn");
				Thread.sleep(2000);

				Control.click("PaymentOption", "CB_Gcash");
				Control.takeScreenshot();

//				Control.click("PaymentOption", "PayP299");
				GomoxFunction.clickByLocation("47,1953,1038,2074"); //[42,1948][1038,2074]
				Thread.sleep(12000);
				GomoxFunction.PurchaseViaGCash();
			}	
			else 
			{
				Thread.sleep(5000);
				GomoxFunction.scrollToText("Next");
				Control.click("ShippingDetails", "NextBtn");
				Thread.sleep(2000);

				Control.click("PaymentOption", "CB_CreditDebit");
				Control.takeScreenshot();

//				Control.click("PaymentOption", "PayP299");
				GomoxFunction.clickByLocation("47,1953,1038,2074");
				GomoxFunction.PurchaseViaDebit();
			}
				

			Control.takeScreenshot();
			Thread.sleep(2000);
			Control.click("Onboarding", "BackToLogin");

//		Thread.sleep(60000);
//		GomoxFunction.ValidateEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ShopPage(boolean isGCash) throws Exception {
		Generic.WriteTestCase("SIM Purchase in shop page", "", "ExpectedResult", "ActualResult");
		try {
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard","Shop");
			GomoxFunction.click("Shop","GomoSim");
			
			Thread.sleep(2000);
			GomoxFunction.scrollToText("30GB with No Expiry");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();

			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "SubQty");
			Thread.sleep(1000);
			Control.takeScreenshot();

			Control.click("GetGomo", "AddToCart");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			GomoxFunction.clickByLocation("954,122,1080,264"); //CART
//			Control.click("GetGomo", "Cart"); //[949,117][1080,264]
			Thread.sleep(3000);
			
			Control.click("Cart", "SelectAllCB");
			Thread.sleep(500);
			Control.takeScreenshot();
			Control.click("Cart", "Checkout");

			if (isGCash) 
			{
				Thread.sleep(12000);
				GomoxFunction.scrollToText("Next");
				Control.click("ShippingDetails", "NextBtn");
				Thread.sleep(2000);

				Control.click("PaymentOption", "CB_Gcash");
				Control.takeScreenshot();

//				Control.click("PaymentOption", "PayP299");
				GomoxFunction.clickByLocation("47,1953,1038,2074");
				Thread.sleep(12000);
				GomoxFunction.PurchaseViaGCash();
			}	
			else 
			{
				Thread.sleep(5000);
				GomoxFunction.scrollToText("Next");
				Control.click("ShippingDetails", "NextBtn");
				Thread.sleep(2000);

				Control.click("PaymentOption", "CB_CreditDebit");
				Control.takeScreenshot();

//				Control.click("PaymentOption", "PayP299");
				GomoxFunction.clickByLocation("47,1953,1038,2074");
				GomoxFunction.PurchaseViaDebit();
			}
			
			Thread.sleep(2000);
			Control.click("Shop", "BackToHome");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
