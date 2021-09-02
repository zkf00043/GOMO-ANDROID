package DawnRegressionPack0602;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class PromoPurchase {
	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("PromoPurchase");
//			promoPurchased();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();

	}

	public static void promoPurchased(boolean isGCash) throws Exception {
		String text = "";
		if (isGCash)
			text = "GCash";
		else
			text = "Debit/Credit";
		
		Generic.WriteTestCase("Promo Purchase via " + text + "", "", "ExpectedResult", "ActualResult");
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "Shop");
			GomoxFunction.click("", "Local");
			GomoxFunction.click("", "Local");

			Thread.sleep(2000);
			Control.click("LocalPromos", "Promo30GB");
//			GomoxFunction.clickByLocation("83,1664,484,1750");
			Thread.sleep(5000);
			Control.click("PaymentOption", "PaymentDetailsBtn");
			Thread.sleep(10000);

			if (isGCash)
				GomoxFunction.PurchaseViaGCash();
			else
				GomoxFunction.PurchaseViaDebit();

			Control.click("PaymentOption", "GotItBtn");
//			Thread.sleep(2000);
//			Control.click("PaymentOption", "GotItBtn");
			Thread.sleep(2000);
			Control.click("LocalPromos", "BackBtn");
			Thread.sleep(2000);
			GomoxFunction.click("Dashboard", "HomeTab");
			Thread.sleep(1000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			GomoxFunction.swipe(Direction.down);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();

	}
}
