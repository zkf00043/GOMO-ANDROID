package Dashboard;

import utility.Constant;
import utility.Control;
import utility.Generic;
import utility.GomoxFunction;

public class Dashboard {

	public static void main(String[] args) throws Exception {
		try {
			// TODO dashboard scenarios for Unli data and all unli data
			Generic.TestScriptStart("Dashboard");
			DashboardScenarios();
		} catch (Exception e) {
			e.printStackTrace();
			Generic.TestScriptEnds();
			Control.GeneratePDFReport();
			Constant.driver.quit();
		}
		Control.GeneratePDFReport();
		Constant.driver.quit();
	}

	public static void DashboardScenarios() throws Exception {
		GomoxFunction.LaunchAppInPerfecto(Generic.ReadFromExcel("DawnApp", "AI_TestData", 1));
		Thread.sleep(5000);
		try {
			GomoxFunction.LoginUser(Generic.ReadFromExcel("MSISDN", "LoginDetails", 4)); // change to 4
			Thread.sleep(5000);
			UnliDashboard.Unli_Dashboard();	
			GomoxFunction.ChangeUser(Generic.ReadFromExcel("MSISDN", "LoginDetails", 5));
			AllUnliDashboard.AllUnli_Dashboard();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
