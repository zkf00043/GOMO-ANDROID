package ProductDetails;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class ProductDetails {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("ProductDetails");
			Product_Details(true);
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}

		Control.GeneratePDFReport();
		Constant.driver.quit();
	}

	public static void Product_Details(boolean isScrollFunction) throws Exception {
		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(5000);
		try {
			if (isScrollFunction)
				ProductDetails_WithScrollFunction();
			else
				ProductDetails_WithOutScrollFunction();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ProductDetails_WithScrollFunction() throws Exception {
		Generic.WriteTestCase("Product Details - Functionality (On Scroll)", "", "ExpectedResult", "ActualResult");
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
			
			GomoxFunction.swipe(Direction.up);
			Control.objExists("ProductDetails", "OverviewBtn", true);
			Control.objExists("ProductDetails", "DetailsBtn", true);
			Control.objExists("ProductDetails", "DeliveryBtn", true);
			
			Thread.sleep(2000);
			
			Control.click("ProductDetails", "DetailsBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("ProductDetails", "DeliveryBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("ProductDetails", "OverviewBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			
			Control.click("GetGomo", "AddToCart");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "Cart");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			Control.click("Cart", "BackBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("PurchaseSim", "BuyNowBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			
			Control.click("Cart", "BackBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GetGomo", "BackBtn");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.click("GomoSim", "BackButton");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "Menu");
			GomoxFunction.click("Menu", "Logout");
			Thread.sleep(8000);
			Control.click("LoginPage", "NotMyNumber"); // [616,471][852,506]
			Thread.sleep(5000);
			
			GomoxFunction.click("LoginPage", "PurchaseSim");

			GomoxFunction.scrollToText("30GB No Expiry");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.objExists("GetGomo", "AddToCart", false);
			
			Thread.sleep(2000);
			Control.click("PurchaseSim", "BuyNowBtn");
			Control.takeScreenshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

	public static void ProductDetails_WithOutScrollFunction() throws Exception {
		Generic.WriteTestCase("Product Details - Functionality (Without Scroll)", "", "ExpectedResult", "ActualResult");
		try {
			
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard","Shop");
			GomoxFunction.click("Shop","GomoSim");
			
			Thread.sleep(2000);
			GomoxFunction.scrollToText("30GB No Expiry");
			Thread.sleep(1000);
			
			Control.objExists("GomoSim", "30GB" , true);
			Control.objExists("GomoSim", "30GBDes" , true);
			Control.objExists("GomoSim", "30GBPrice" , true);
			Control.takeScreenshot();
			Thread.sleep(2000);
			
			Control.click("GomoSim", "30GB");
			Thread.sleep(1000);
			Control.takeScreenshot();
			
			Control.objExists("Cart", "Quantity", true);
			Control.objExists("GetGomo", "SubQty", true);
			Control.objExists("GetGomo", "AddQty", true);
			Control.objExists("GetGomo", "AddToCart", true);
			Control.objExists("PurchaseSim", "BuyNowBtn" , true);
			
			Control.click("GetGomo", "AddToCart");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Control.click("GetGomo", "Cart");
			Thread.sleep(2000);
			Control.takeScreenshot();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

}
