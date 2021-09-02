package utility;

public class NSFunction {

	public static void InvalidCharacter() throws Exception {
		try {
			GomoxFunction.sendKeys("CreateAccount", "FirstName", "@");
			
			GomoxFunction.clickByLocation("37,758,1043,907"); // Lastname
			GomoxFunction.enterTextByKeyCodeEvent("@");
			
			GomoxFunction.sendKeys("CreateAccount", "UnitNo", "@");
			GomoxFunction.sendKeys("CreateAccount", "StreetNo", "@");
			
			GomoxFunction.objExist("Invalid", "FirstName" , true);
			GomoxFunction.objExist("Invalid", "LastName" , true);
			GomoxFunction.objExist("Invalid", "UnitNo" ,true);
			GomoxFunction.objExist("Invalid", "StreetNo" , true);
			
			GomoxFunction.scrollToText("This Address");
			GomoxFunction.sendKeys("CreateAccount", "VillageSub", "@");
			GomoxFunction.objExist("Invalid", "VillageSub" , true);
			
			GomoxFunction.sendKeys("CreateAccount", "Email", "testing@");
			GomoxFunction.sendKeys("CreateAccount", "MobileNumber", "917");
			GomoxFunction.objExist("Invalid", "Email" , true);
			GomoxFunction.objExist("Invalid", "MobileNumber" , true);
			
			
			GomoxFunction.clickByLocation("0,117,147,264"); // back button
			Thread.sleep(1000);
			GomoxFunction.click("ShippingDetails", "AddYourAddress");
			
			GomoxFunction.sendKeys("CreateAccount", "FirstName", " ");
			
			Thread.sleep(1000);
			GomoxFunction.clickByLocation("37,758,1043,907"); // Lastname
			GomoxFunction.sendKeyEvent("62" , 0);
//			Constant.driver.hideKeyboard();
			
			GomoxFunction.sendKeys("CreateAccount", "UnitNo", " ");
			GomoxFunction.sendKeys("CreateAccount", "StreetNo", " ");
			
			GomoxFunction.objExist("", "This field is required." , true);
			GomoxFunction.objExist("", "This field is required." , true);
			GomoxFunction.objExist("", "This field is required." , true);
			GomoxFunction.objExist("", "This field is required." , true);
			
			GomoxFunction.scrollToText("This Address");
			GomoxFunction.sendKeys("CreateAccount", "VillageSub", " ");
			GomoxFunction.objExist("","This field is required." , true);
			
			GomoxFunction.sendKeys("CreateAccount", "Email", " ");
			GomoxFunction.sendKeys("CreateAccount", "MobileNumber", " ");
			GomoxFunction.objExist("", "This field is required." , true);
			GomoxFunction.objExist("", "This field is required." , true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
