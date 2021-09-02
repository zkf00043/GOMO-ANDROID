package Payment_SimVariant;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;

public class SimPurchaseLimit {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("SimPurchaseLimit");
			Sim_PurchaseLimit(true);
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}

	public static void Sim_PurchaseLimit(boolean isLandingPage) throws Exception {
		Generic.WriteTestCase("Payment (SIM Variants) - SIM Purchase Limit For Logged Out Users", "", "ExpectedResult", "ActualResult");
		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(5000);
		try {
			if (isLandingPage)
				LandingPage();
			else
				ShopPage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void LandingPage() throws Exception {
		try {
			Thread.sleep(5000);
			Control.takeScreenshot();
			GomoxFunction.click("LoginPage", "PurchaseSim");

			GomoxFunction.scrollToText("30GB No Expiry");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.click("GetGomo", "AddQty");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("PurchaseSim", "BuyNowBtn");
			Control.takeScreenshot();

			GomoxFunction.click("PurchaseSim", "EnterAddress"); // NEW FLOW
			Control.takeScreenshot();

			Thread.sleep(1000);

			GomoxFunction.fillUpAddAddress();
			Thread.sleep(1000);

			GomoxFunction.scrollToText("This Address");
			GomoxFunction.clickByLocation("42,1390,95,1440"); // CB [37,1382][95,1440]
//		GomoxFunction.clickByLocation("45,1185,108,1248"); //If samsung 10e version 9.
			Thread.sleep(1000);
			Control.click("CreateAccount", "UseThisAddBtn");
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ShopPage() throws Exception {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
