package Dashboard;

import utility.Control;
import utility.Generic;
import utility.GomoxFunction;
import utility.GomoxFunction.Direction;

public class AllUnliDashboard {

	public static void AllUnli_Dashboard() throws Exception {
		try {
			Generic.WriteTestCase("AllUnliDashboard_EyeGuide", "", "ExpxectedResult", "ActualResult");
			
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("UnliDashboard", "UnliData", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("UnliDashboard", "UpTo", true);
			GomoxFunction.objExist("UnliDashboard", "MoreDetails", true);
			
			GomoxFunction.objExist("AllUnliEyeGuide", "UnliCalls", true);
			GomoxFunction.objExist("AllUnliEyeGuide", "UnliTexts", true);
			GomoxFunction.objExist("AllUnliEyeGuide", "EyeGuideHeader1", true);
			GomoxFunction.objExist("AllUnliEyeGuide", "EyeGuideBody1", true);
			Control.takeScreenshot();
			
			GomoxFunction.clickByLocation("895,1726,975,1806"); // Right arrow >
			Thread.sleep(1000);
			GomoxFunction.objExist("AllUnliEyeGuide", "EyeGuideHeader2", true);
			GomoxFunction.objExist("AllUnliEyeGuide", "EyeGuideBody2", true);
			Control.takeScreenshot();
			
			GomoxFunction.clickByLocation("895,1686,975,1766"); // Right arrow >
			Thread.sleep(1000);
			GomoxFunction.objExist("AllUnliEyeGuide", "EyeGuideBody3", true);
			Control.takeScreenshot();
			
			
			Thread.sleep(500);
			GomoxFunction.clickByLocation("109,1541,189,1621"); // Left arrow <
			Thread.sleep(500);
			GomoxFunction.clickByLocation("109,1686,189,1766"); // Left arrow <
			Thread.sleep(500);
			
			GomoxFunction.click("AllUnliEyeGuide", "SkipBtn");
			Control.takeScreenshot();
			GomoxFunction.click("AllUnliEyeGuide", "DoneBtn");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();
		
		
		try {
			Generic.WriteTestCase("AllUnliDashboard_Dashboard", "", "ExpxectedResult", "ActualResult");
			
			//<Remarks> Validating the Unli data section
			Thread.sleep(5000);
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("UnliDashboard", "UnliData", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("UnliDashboard", "UpTo", true);
			GomoxFunction.objExist("UnliDashboard", "MoreDetails", true);
			
			Thread.sleep(2000);
			GomoxFunction.click("UnliDashboard", "MoreDetails");
			Control.takeScreenshot();
			
			GomoxFunction.objExist("", "Data Details", true);
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("UnliDashboard", "UnliData", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("AllUnliDashboard", "UnliDataNote", true);
			
			GomoxFunction.objExist("", "No Expiry Data", true);
			GomoxFunction.objExist("AllUnliDashboard", "NoExpiryNote", true);
			Control.takeScreenshot();
			Thread.sleep(2000);
			GomoxFunction.click("AllUnliDashboard", "MoreQuestion");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			Control.click("AllUnliDashboard", "BackBtn");
			Thread.sleep(2000);
			
			//</Remarks>
			
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(2000);
			GomoxFunction.clickByLocation("896,831,1017,952"); //Clicking to text hexagon
			Thread.sleep(500);
			Control.takeScreenshot();
			
			
			//<Remarks> Validating the Unli Text section	
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("", "UNLI Texts", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("", "All networks", true);
			GomoxFunction.objExist("UnliDashboard", "MoreDetails", true);
			Thread.sleep(2000);
			GomoxFunction.click("UnliDashboard", "MoreDetails");
			Control.takeScreenshot();
			
			GomoxFunction.objExist("AllUnliDashboard", "TextDetails", true);
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("AllUnliDashboard", "UnliTxt", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			
			GomoxFunction.objExist("AllUnliDashboard", "UnliNote", true);
			
			GomoxFunction.objExist("AllUnliDashboard", "NoExpiryHeader", true);
			GomoxFunction.objExist("AllUnliDashboard", "NoExpiryBody", true);
			
			GomoxFunction.click("AllUnliDashboard", "MoreQuestion");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			Control.click("AllUnliDashboard", "BackBtn");
			Thread.sleep(2000);
			
			//</Remarks>
			
			GomoxFunction.swipe(Direction.down);
			Thread.sleep(2000);
			Thread.sleep(2000);
			GomoxFunction.clickByLocation("896,831,1017,952"); //Clicking to text hexagon
			Thread.sleep(500);
			Control.takeScreenshot();
			
			//<Remarks> Validating the Unli Calls section
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("", "UNLI Calls", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			GomoxFunction.objExist("UnliDashboard", "MoreDetails", true);
			
			Thread.sleep(2000);
			GomoxFunction.click("UnliDashboard", "MoreDetails");
			Control.takeScreenshot();
			
			GomoxFunction.objExist("AllUnliDashboard", "CallDetails", true);
			GomoxFunction.objExist("UnliDashboard", "InUse", true);
			GomoxFunction.objExist("AllUnliDashboard", "UnliCalls", true);
			GomoxFunction.objExist("UnliDashboard", "ValidUntil", true);
			
			
			GomoxFunction.objExist("AllUnliDashboard", "UnliCallNote", true);
			GomoxFunction.objExist("AllUnliDashboard", "NoExpHeader", true);
			GomoxFunction.objExist("AllUnliDashboard", "NoExpNote", true);
			
			GomoxFunction.click("AllUnliDashboard", "MoreQuestion");
			Thread.sleep(3000);
			Control.takeScreenshot();
			Thread.sleep(1000);
			Control.click("AllUnliDashboard", "BackBtn");
			Thread.sleep(2000);
			
			//</Remarks>
			
			GomoxFunction.swipe(Direction.down);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Generic.TestScriptEnds();


	}

}
