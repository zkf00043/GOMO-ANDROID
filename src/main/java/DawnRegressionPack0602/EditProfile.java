package DawnRegressionPack0602;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;

public class EditProfile {

	public static void main(String[] args) throws Exception {
		try {
			Generic.TestScriptStart("EditProfileVerifiedEmail");
			editProfileVerifiedEmail();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();

	}

	public static void editProfileVerifiedEmail() throws Exception {
		Generic.WriteTestCase("Edit Profile - Verified Email", "", "ExpectedResult", "ActualResult");
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			Thread.sleep(5000);
			GomoxFunction.click("Dashboard", "Account");
			Thread.sleep(5000);
			Control.takeScreenshot();
			GomoxFunction.click("Account", "BasicInfo");
			Thread.sleep(5000);
		
			GomoxFunction.click("BasicInfo", "EditBtn");
			GomoxFunction.clickByLocation("71,421,1014,563");
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 1));
			GomoxFunction.sendKeys("CreateAccount", "FirstName", Generic.ReadRandomCellData("Names"));
			Thread.sleep(1000);
			GomoxFunction.click("CreateAccount", "Gender");
			Thread.sleep(1000);
			GomoxFunction.click("Gender", "Undisclosed");
			Thread.sleep(2000);
			GomoxFunction.scrollToText("Save Edited Profile");
			
			GomoxFunction.click("CreateAccount", "DataPrivacy");
			Thread.sleep(5000);
			Control.takeScreenshot();
			GomoxFunction.KeyboardBackButton();
			
			GomoxFunction.click("CreateAccount", "PrivacyPol");
			Thread.sleep(5000);
			Control.takeScreenshot();
			GomoxFunction.KeyboardBackButton();
//			GomoxFunction.click("CreateAccount", "BackBtn");
			
			GomoxFunction.clickByLocation("58,1492,110,1545");
			Control.click("BasicInfoEdit", "SavedEditedProfileBtn");
			Thread.sleep(12000);
			Control.takeScreenshot();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();

	}

}
