package DawnRegressionPack0602;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class MoCreds {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("MoCreds_NewSim");
//			moCreds();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}

	// Should try old sim and newly sim
	public static void moCreds(boolean isNewSim) throws Exception {
		String text = "";
		if (isNewSim)
			text = "NewSim";
		else
			text = "OldSim";
		try {
			ThirtySmsConversion(text);
			SixMinsConversion(text);
			FiftySmsConversion(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ThirtySmsConversion(String text) throws Exception {
		Generic.WriteTestCase("" + text + " | Mo Creds - (Navigation) (0.2GB = 30 SMS)", "", "ExpectedResult",
				"ActualResult");
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			Thread.sleep(8000);
			GomoxFunction.click("Dashboard", "MoCreds");
			Thread.sleep(5000);

//			GomoxFunction.clickByLocation("219,2011,432,2153"); // This line will remove for one run 

			// TODO NEW FLOW
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			GomoxFunction.click("", "Go To 'Mo Creds");

			Thread.sleep(4000);
			Control.click("MoCreds", "Call&Text");
			Thread.sleep(1000);
			GomoxFunction.click("MoCreds", "30SMS");
			Control.click("MoCreds", "NextBtn");
			Control.click("MoCreds", "ConfirmConversion");
			Thread.sleep(10000);
//			GomoxFunction.click("", "NO THANKS");
			Control.takeScreenshot();
			GomoxFunction.objExist("MoCreds", "SuccessConversion", true);
			Thread.sleep(2000);
			GomoxFunction.click("MoCreds", "BackToMoCreds");
			Thread.sleep(2000);
			GomoxFunction.click("Dashboard", "HomeTab");
			Thread.sleep(2000);
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(5000);
			GomoxFunction.swipe(Direction.up);
			GomoxFunction.click("Dashboard", "LastConversion");
			GomoxFunction.objExist("", "0.2 GB", true);
			Control.takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

	public static void SixMinsConversion(String text) throws Exception {
		Generic.WriteTestCase("" + text + " | Mo Creds - (Dashboard) (0.4GB = 6 Mins)", "", "ExpectedResult",
				"ActualResult");
		try {
			Thread.sleep(2000);
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "MoCreds");
//			GomoxFunction.clickByLocation("219,2011,432,2153");
			Thread.sleep(5000);
			// TODO NEW FLOW
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			GomoxFunction.click("", "Go To 'Mo Creds");

			Thread.sleep(4000);
			Control.click("MoCreds", "Call&Text");
			Thread.sleep(500);
			GomoxFunction.click("MoCreds", "6Mins");
			Control.click("MoCreds", "NextBtn");
			Control.click("MoCreds", "ConfirmConversion");
			Thread.sleep(10000);
//			GomoxFunction.click("", "NO THANKS");
			Control.takeScreenshot();
			GomoxFunction.objExist("MoCreds", "SuccessConversion", true);
			Thread.sleep(2000);
			GomoxFunction.click("MoCreds", "BackToMoCreds");
			Thread.sleep(2000);
			GomoxFunction.click("Dashboard", "HomeTab");
			GomoxFunction.swipe(Direction.up);
			GomoxFunction.click("Dashboard", "LastConversion");
			GomoxFunction.objExist("", "0.4 GB", true);
			Control.takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

	public static void FiftySmsConversion(String text) throws Exception {
		Generic.WriteTestCase("" + text + " | Mo Creds -  (Shop) (0.5GB = 50 SMS + 5 Mins)", "", "ExpectedResult",
				"ActualResult");
		try {
			Thread.sleep(2000);
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "MoCreds");
//			GomoxFunction.clickByLocation("219,2011,432,2153");
			Thread.sleep(5000);
			
			// TODO NEW FLOW
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(1000);
			GomoxFunction.click("", "Go To 'Mo Creds");

			Thread.sleep(4000);
			Control.click("MoCreds", "Call&Text");
			Thread.sleep(500);
			GomoxFunction.click("MoCreds", "50SMS");
			Control.click("MoCreds", "NextBtn");
			Control.click("MoCreds", "ConfirmConversion");
			Thread.sleep(10000);
//			GomoxFunction.click("", "NO THANKS");
			Control.takeScreenshot();
			GomoxFunction.objExist("MoCreds", "SuccessConversion", true);
			Thread.sleep(2000);
			GomoxFunction.click("MoCreds", "BackToMoCreds");
			Thread.sleep(2000);
			GomoxFunction.click("Dashboard", "HomeTab");
			GomoxFunction.swipe(Direction.up);
			GomoxFunction.click("Dashboard", "LastConversion");
			GomoxFunction.objExist("", "0.5 GB", true);
			Control.takeScreenshot();
			GomoxFunction.swipe(Direction.down);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}
}
