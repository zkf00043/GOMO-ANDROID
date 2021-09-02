package Dashboard;

import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class UnliDashboard {

	public static void Unli_Dashboard() throws Exception {
		try {

			Generic.WriteTestCase("UnliData EyeGuide", "", "ExpectedResult", "ActualResult");
			Thread.sleep(5000);
			
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("UnliDashboard", "UnliData", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("UnliDashboard", "UpTo", true);
			GomoxFunction.objExist("UnliDashboard", "MoreDetails", true);
			GomoxFunction.objExist("UnliDashboard", "UnliHeader", true);
			GomoxFunction.objExist("UnliDashboard", "UnliNote", true);
			GomoxFunction.objExist("UnliDashboard", "GotIt", true);
			
			Control.takeScreenshot();
			Control.click("UnliDashboard", "GotIt");
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
		
		
		try {
			Thread.sleep(5000);
			//WriteTestData
			Generic.WriteTestCase("UnliDashboard", "", "ExpectedResult", "ActualResult");
			
			GomoxFunction.click("UnliDashboard", "MoreDetails");
			Thread.sleep(1000);
			Control.takeScreenshot();
			GomoxFunction.objExist("DataDetails", "UnliDataNote", true);
			GomoxFunction.objExist("DataDetails", "NoExpiryNote", true);
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(1000);
			
			//Text
			GomoxFunction.clickByLocation("896,831,1017,952"); // <Remarks> Right arrow ">" in the dashboard screen </Remarks>
			Control.takeScreenshot();
			GomoxFunction.click("UnliDashboard", "UseMoCreds");
			Thread.sleep(10000);
			Control.takeScreenshot();
			
			GomoxFunction.click("Dashboard", "HomeTab");
			
			//Call
			GomoxFunction.clickByLocation("896,831,1017,952"); // <Remarks> Right arrow ">" in the dashboard screen </Remarks>
			Control.takeScreenshot();
			GomoxFunction.click("UnliDashboard", "UseMoCreds");
			Thread.sleep(10000);
			Control.takeScreenshot();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();

	}

}
