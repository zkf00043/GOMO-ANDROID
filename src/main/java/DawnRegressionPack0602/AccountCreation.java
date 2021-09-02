package DawnRegressionPack0602;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class AccountCreation {

	public static void main(String[] args) throws Exception {

		try {
			Generic.TestScriptStart("AccountCreation");
			accountCreation();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}
	

	public static void accountCreation() throws Exception {
		Generic.WriteTestCase("Account Creation", "", "ExpectedResult", "ActualResult");
//		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		try {
			
			Thread.sleep(5000);
			GomoxFunction.sendKeys("LoginPage", "MobileNumber", Generic.ReadFromExcel("MSISDN", "LoginDetails", 1));
			Control.click("LoginPage", "LetsGoBtn");
			Thread.sleep(1000);
			GomoxFunction.click("LoginPage", "Proceed");
			Thread.sleep(10000);
			GomoxFunction.clickByLocation("58,547,1028,694");
			String otp = GomoxFunction.getOtp(Generic.ReadFromExcel("MSISDN", "LoginDetails", 1) , false);
			GomoxFunction.enterPin(otp);
			Thread.sleep(2000);
			GomoxFunction.accountCreation();
			GomoxFunction.click("CreateAccount", "Birthday");
			GomoxFunction.swipeUntilDateIsVisisble("June");
			Thread.sleep(1000);
			GomoxFunction.click("", "Done");
			GomoxFunction.scrollToText("Create Account");
			Thread.sleep(1000);
			GomoxFunction.click("CreateAccount", "DataPrivacy");
			Thread.sleep(1000);
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(1000);
			GomoxFunction.click("CreateAccount", "PrivacyPol");
			Thread.sleep(1000);
			Control.takeScreenshot();
			GomoxFunction.KeyboardBackButton();
			Thread.sleep(2000);
			Control.click("CreateAccount" , "AccountCreationCB"); //Checkbox 
			Thread.sleep(2000);
			Control.takeScreenshot();
			Control.click("CreateAccount" , "CreateAccountBtn");
			Control.takeScreenshot();
			
			//TODO PIN
			String pin = Generic.ReadFromExcel("PIN", "LoginDetails", 1);
			Thread.sleep(3000);
			
			GomoxFunction.clickByLocation("58,492,1028,639");
			Thread.sleep(1000);
			GomoxFunction.enterPin(pin);
			Thread.sleep(1000);
	
			GomoxFunction.clickByLocation("58,835,1028,982");
			Thread.sleep(1000);
			GomoxFunction.enterPin(pin);
			Thread.sleep(50000);
			
			
			//TODO Validation of Biometrics
//			GomoxFunction.objExist("Biometrics", "Header", true);
//			Thread.sleep(1000);
//			GomoxFunction.objExist("Biometrics", "Note", true);
			GomoxFunction.click("Biometrics", "Skip");
			Thread.sleep(15000);
//			
//			GomoxFunction.objExist("SuccessCreation", "SuccessfulAccountCreation", true);
//			GomoxFunction.objExist("SuccessCreation", "Note", true);
//			Thread.sleep(2000);
			Control.takeScreenshot();
			GomoxFunction.click("SuccessCreation", "GetStarted");
			Thread.sleep(4000);
			
			Control.takeScreenshot();
//			GomoxFunction.click("EyeGuide", "GotIt");
			
			//TODO Eye guide
//			Thread.sleep(5000);
//			GomoxFunction.objExist("EyeGuide", "Note", true);
//			Thread.sleep(1000);
//			GomoxFunction.click("EyeGuide", "GotIt");
			
			Thread.sleep(2000);
			GomoxFunction.objExist("EyeGuide", "FirstHeader", true);
			GomoxFunction.objExist("EyeGuide", "FirstEyeGuide", true);
			Thread.sleep(1000);
			Control.click("EyeGuide", "RightArrow");
//			GomoxFunction.clickByLocation("896,1722,975,1801");
			
			Thread.sleep(2000);
			
			GomoxFunction.objExist("EyeGuide", "SecondHeader", true);
			GomoxFunction.objExist("EyeGuide", "SecondEyeGuide", true);
			Thread.sleep(1000);
			Control.click("EyeGuide", "RightArrow2");
//			GomoxFunction.clickByLocation("896,1568,975,1647");
			Thread.sleep(2000);
			
			GomoxFunction.objExist("EyeGuide", "ThirdHeader", true);
			GomoxFunction.objExist("EyeGuide", "ThirdEyeGuide", true);
			Thread.sleep(1000);
			Control.click("EyeGuide", "RightArrow2");
//			GomoxFunction.clickByLocation("895,1541,975,1621");
			Thread.sleep(2000);
			
			GomoxFunction.objExist("EyeGuide", "ForthEyeGuide", true);
			Thread.sleep(1000);
			
			GomoxFunction.click("EyeGuide", "DoneBtn");
			Thread.sleep(2000);
			
			GomoxFunction.swipe(Direction.up);
			Thread.sleep(3000);
			GomoxFunction.click("Dashboard", "LastConversion");
			Thread.sleep(3000);
			GomoxFunction.objExist("Dashboard", "NoConversion" , true);
			Thread.sleep(3000);
			GomoxFunction.click("", "Use Mo Creds here");
			Thread.sleep(3000);
			Control.takeScreenshot();	
			Thread.sleep(2000);
			GomoxFunction.click("Dashboard", "HomeTab");
			GomoxFunction.swipe(Direction.down);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();

	}

}
