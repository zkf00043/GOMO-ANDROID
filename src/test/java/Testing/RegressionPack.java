package Testing;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import DawnRegressionPack0602.AccountCreation;
import DawnRegressionPack0602.MoCreds;
import DawnRegressionPack0602.PinModification;
import DawnRegressionPack0602.PromoPurchase;
import DawnRegressionPack0602.SimPurchase;
import DawnRegressionPack0602.EditProfile;

public class RegressionPack {

	@BeforeTest
	public void OnStart() throws Exception {
		Generic.TestScriptStart("RegressionPack");
		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(5000);
	}

	@AfterTest
	public void OnFinished() throws Exception {
		Control.GeneratePDFReport();
	}

	@AfterMethod
	public void RestartApp() throws Exception {

		Control.RestartApp(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void SimPurchaseOnLanding() throws Exception {
		SimPurchase.Sim_Purchase(true, true);
	}

	@Test(priority = 2)
	public void AccounCreation() throws Exception {
		AccountCreation.accountCreation();
	}

	@Test(priority = 3)
	public void MoCredsNewAccount() throws Exception {
		MoCreds.moCreds(true);
	}

	@Test(priority = 4)
	public void PromoPurchase() throws Exception {
		GomoxFunction.ChangeUser(Generic.ReadFromExcel("MSISDN", "LoginDetails", 2));
		PromoPurchase.promoPurchased(true);
	}

	@Test(priority = 5)
	public void SimPurchaseOnShop() throws Exception {
		SimPurchase.Sim_Purchase(false, false);
	}

	@Test(priority = 6)
	public void MoCredsOldAccount() throws Exception {
		GomoxFunction.ChangeUser(Generic.ReadFromExcel("MSISDN", "LoginDetails", 1)); // FOR TESTING REMOVE THIS LINE
		MoCreds.moCreds(false);
	}

	@Test(priority = 7)
	public void EditProfile() throws Exception {
		EditProfile.editProfileVerifiedEmail();
	}

	@Test(priority = 8)
	public void PinModication() throws Exception {
		PinModification.pinModification();
	}

}
