package DawnRegressionPack0602;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;

public class PinModification {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("PINModification");
			pinModification();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
//			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
//		Constant.driver.quit();

	}

	public static void pinModification() throws Exception {
		Generic.WriteTestCase("PIN Modification", "", "ExpectedResult", "ActualResult");
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "Menu");
			GomoxFunction.click("Menu", "Settings");
			GomoxFunction.click("Settings", "UpdatePin");
			GomoxFunction.clickByLocation("72,419,1014,558"); // Enter Pin
			Thread.sleep(1000);
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 1));
			
			GomoxFunction.clickByLocation("58,387,1028,534");
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 2));
			Thread.sleep(2000);
			GomoxFunction.clickByLocation("58,717,1028,864");
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 2));
			Thread.sleep(10000);
			//[144,949][936,1075]
			GomoxFunction.click("ChangePin", "GoToLogin");
			Thread.sleep(10000);
			GomoxFunction.clickByLocation("71,747,1014,889");
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 2));
			Thread.sleep(10000);
			Control.takeScreenshot();
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
	}

}
