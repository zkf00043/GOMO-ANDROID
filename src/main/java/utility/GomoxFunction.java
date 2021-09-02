package utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.KeyStroke;

import org.apache.bcel.generic.SWAP;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GomoxFunction {

	public static void main(String[] args) throws Exception {

		System.out.println(getOtp("9271002520", false));

	}

	@SuppressWarnings("unchecked")
	public static void LaunchAppInPerfecto(String appPackage) throws Exception {

		String token = Generic.ReadFromExcel("TechMToken", "AI_TestData", 1);
		DesiredCapabilities capabilities = new DesiredCapabilities("mobileOS", "", Platform.ANY);
		capabilities.setCapability("securityToken", token);
		capabilities.setCapability("deviceName", Generic.ReadFromExcel("DeviceName", "AI_TestData", 1));
		capabilities.setCapability("deviceSessionId", Generic.ReadFromExcel("DeviceSessionID", "AI_TestData", 1));
		capabilities.setCapability("enableAppiumBehavior", true);
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("autoLaunch", true);

		try {
			Constant.driver = new AndroidDriver<AndroidElement>(
					new URL("https://techm-globe-public.perfectomobile.com/nexperience/perfectomobile/wd/hub"),
					capabilities);
//			RemoteWebDriver driver = new RemoteWebDriver(
//					new URL("https://techm-globe-public.app.perfectomobile.com/nexperience/perfectomobile/wd/hub"), capabilities);
			Constant.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Map<String, Object> params = new HashMap<>();
			params.put("identifier", appPackage);
			Constant.driver.executeScript("mobile:application:open", params);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static String getOtp(String otp, Boolean isStg) throws Exception {
		String endPoint;
		if (isStg)
			endPoint = "https://c0fs27xwue.execute-api.ap-southeast-1.amazonaws.com/stg/webtool/v1/get-otp-bd";
		else
			endPoint = "https://brskc46xre.execute-api.ap-southeast-1.amazonaws.com/dev/webtool/v1/get-otp-bd";

		URL url = new URL(endPoint);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "{\"serviceNumber\": \"" + otp + "\"}";

		try (OutputStream os = con.getOutputStream()) {
			byte[] input = jsonInputString.getBytes("utf-8");
			os.write(input, 0, input.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
			StringBuilder response = new StringBuilder();
			String responseLine = null;
			while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
			}
			// System.out.println(response.toString());
			String getResponse = response.toString();
			otp = getResponse.split("\"otp\":", 2)[1].replace("\"", "").replace("}", "");
			;
		}
		System.out.println("Otp: " + otp);
		return otp;
	}

	// Paramater Label is text related to the element to set text
	public static void sendKeys(String PageName, String label, String text) throws Exception {
		String getLabel = null;
		if (label != null) {
			if (PageName != "")
				getLabel = Constant.labelMap.get(PageName).get(label);
			else
				getLabel = label;
		}
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("report", "Screenshot");
			params.put("report.resolution", "Medium");
			params.put("label", getLabel);
			params.put("text", text);
			String res = (String) Constant.driver.executeScript("mobile:edit-text:set", params);
			Thread.sleep(1000);
			Control.takeScreenshot();

			Generic.WriteTestData("Sending text in to the text box", label, text,
					"Should be able to send text: " + text + " to the: " + label, "Same as expected", "Pass");

		} catch (Exception e) {
			Generic.WriteTestData("Sending text in to the text box", label, text,
					"Should be able to send text: " + text + " to the: " + label, "Not the same as  expected", "Fail");
		}
		Thread.sleep(1000);
		Constant.driver.hideKeyboard();
	}

	public static void click(String PageName, String label) throws Exception {
		String getLabel = null;
		if (label != null) {
			if (PageName != "") {
				getLabel = Constant.labelMap.get(PageName).get(label);
				System.out.println(getLabel);
			} else {
				getLabel = label;
				System.out.println(getLabel);
			}
		}
		try {

			Map<String, Object> params = new HashMap<>();
			params.put("interval", 1);
			params.put("report", "Screenshot");
			params.put("report.resolution", "Medium");
			params.put("label", getLabel);
			Constant.driver.executeScript("mobile:button-text:click", params);
			Thread.sleep(1000);
			Control.takeScreenshot();
			Generic.WriteTestData("Should be able to click the button", PageName, label,
					"Able to click button: " + label, "Same as expected", "Pass");
		} catch (Exception e) {
//			e.printStackTrace();
			Generic.WriteTestData("Should be able to click the button", PageName, label,
					"Able to click button: " + label, "Not the same as expected", "Fail");
		}
	}

	public static void objExist(String PageName, String context, boolean shouldExist) throws Exception {
		String getContext = null;
		if (context != null) {
			if (PageName != "") {
				getContext = Constant.labelMap.get(PageName).get(context);
				System.out.println(getContext);
			} else {
				getContext = context;
			}
		}
		try {

			Map<String, Object> params = new HashMap<>();
			params.put("report", "Screenshot");
			params.put("report.resolution", "Medium");
			params.put("content", getContext);
			String res = (String) Constant.driver.executeScript("mobile:text:find", params);

			if (shouldExist) {
				if (res.equalsIgnoreCase("true")) {
					System.out.println("This object exist: " + getContext);
					Generic.WriteTestData("The element or the object should be exist in the screen page", PageName,
							context, "The object " + context + " should exist", "Same as expected", "Pass");
					Control.takeScreenshot();
				} else {
					System.out.println("This object does not exist: " + getContext);
					Generic.WriteTestData("The element or the object should be exist in the screen page", PageName,
							context, "The object " + context + " should exist", "Not the same as expected", "Fail");
					Control.takeScreenshot();
				}

			} else {
				if (res.equalsIgnoreCase("true")) {
					System.out.println("This object exist on screen: " + getContext);
					Generic.WriteTestData("The element or the object should not be exist in the screen page", PageName,
							context, "The object " + context + " should  not exist", "Not the same as expected",
							"Fail");
					Control.takeScreenshot();
				} else {
					System.out.println("This object should not exist on the screen: " + getContext);
					Generic.WriteTestData("The element or the object should not be exist in the screen page", PageName,
							context, "The object " + context + " should  not exist", "Same as expected", "Pass");
					Control.takeScreenshot();

				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// For account creation

	public static void accountCreation() throws Exception {
		String fName = Generic.ReadRandomCellData("Names");
		String lName = Generic.ReadRandomCellData("Names");
		String nName = Generic.ReadRandomCellData("Names");
		String email = Generic.ReadFromExcel("Email", "LoginDetails", 1);
		try {
			sendKeys("CreateAccount", "FirstName", fName);

			GomoxFunction.clickByLocation("37,923,1043,1073");
			GomoxFunction.enterTextByKeyCodeEvent(lName);

			sendKeys("CreateAccount", "NickName", nName);
			click("CreateAccount", "Gender");
			Thread.sleep(500);
			click("Gender", "Male");
			sendKeys("CreateAccount", "Email", email);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Fill up the basic information for buying sim on the landing page
	public static void fillUpAddAddress() throws Exception {
		String fName = Generic.ReadRandomCellData("Names");
		String lName = Generic.ReadRandomCellData("Names");

		String email = Generic.ReadFromExcel("Email", "LoginDetails", 1);
		String mobileNum = Generic.ReadFromExcel("GCashNum", "LoginDetails", 1);
		try {

			sendKeys("CreateAccount", "FirstName", fName);

			clickByLocation("42,783,1038,954");
			enterTextByKeyCodeEvent(lName);

//			sendKeys("CreateAccount", "UnitNo", Generic.ReadFromExcel("UnitNo", "LoginDetails", 1));
//			sendKeys("CreateAccount", "StreetNo", Generic.ReadFromExcel("StreetName", "LoginDetails", 1));
			AddAddress(1);
			Thread.sleep(2000);
			sendKeys("CreateAccount", "Email", email);
			Thread.sleep(2000);
			sendKeys("CreateAccount", "MobileNumber", mobileNum);
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void swipeUntilDateIsVisisble(String textToFind) throws Exception {
		WebElement element = null;
		int tries = 0;
		boolean isVisible = false;
		try {
			while (tries < 10 && !isVisible) {
				try {
					tries++;
					swipeDate(Date.Month, true);
					Thread.sleep(2000);
					element = Constant.driver.findElement(By.xpath("//*[@content-desc=\"" + textToFind + "\"]"));
					isVisible = element.isDisplayed();
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean findText(String textToFind) throws Exception {
		boolean isVisible = false;
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("content", textToFind);
			String result = (String) Constant.driver.executeScript("mobile:text:find", params);
			Thread.sleep(1000);
			System.out.println("Result is: " + result);
			if (result.equalsIgnoreCase("true")) {
				isVisible = true;
			} else {
				isVisible = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isVisible;
	}

	// Add address information for buying sim on the shop screen
	public static void AddAddress(int selectAddress) throws Exception {
		WebElement element = null;
		Constant.UnitNo = Generic.ReadFromExcel("UnitNo", "LoginDetails", selectAddress);
		Constant.StreetName = Generic.ReadFromExcel("StreetName", "LoginDetails", selectAddress);
		Constant.Province = Generic.ReadFromExcel("Province", "LoginDetails", selectAddress);
		Constant.City = Generic.ReadFromExcel("City", "LoginDetails", selectAddress);
		Constant.Barangay = Generic.ReadFromExcel("Barangay", "LoginDetails", selectAddress);
		Constant.ZipCode = Generic.ReadFromExcel("ZipCode", "LoginDetails", selectAddress);
		try {
			Thread.sleep(5000);
			sendKeys("CreateAccount", "UnitNo", Constant.UnitNo);
			sendKeys("CreateAccount", "StreetNo", Constant.StreetName);
			click("CreateAccount", "Province");
			Thread.sleep(1000);
			sendKeys("CreateAccount", "EnterProvince", Constant.Province);
			Thread.sleep(1000);
			element = Constant.driver
					.findElement(By.xpath("//*[@content-desc=\"" + Constant.Province + ", List Choice Label\"]"));
			element.click();

			//// *[@content-desc="METRO MANILA, List Choice Label"]

			Thread.sleep(2000);

			// TODO BUG on-going fix
			// <Remarks> uncomment this after fix </Remarks>
//			click("CreateAccount", "City");
//			Thread.sleep(1000);

			sendKeys("CreateAccount", "EnterCity", Constant.City);
			Thread.sleep(1000);
			element = Constant.driver
					.findElement(By.xpath("//*[@content-desc=\"" + Constant.City + ", List Choice Label\"]"));
			element.click();

			Thread.sleep(2000);

			// TODO BUG on-going fix
			// <Remarks> uncomment this after fix </Remarks>
//			click("CreateAccount", "Barangay");
//			Thread.sleep(1000);

			sendKeys("CreateAccount", "EnterBarangay", Constant.Barangay);
			Thread.sleep(1000);
			element = Constant.driver
					.findElement(By.xpath("//*[@content-desc=\"" + Constant.Barangay + ", List Choice Label\"]"));
			element.click();
			Thread.sleep(1000);
			Control.takeScreenshot();
			scrollToText("This Address"); // Add This Address || Save This Address
			Thread.sleep(2000);
			click("CreateAccount", "ZipCode");
			sendKeys("CreateAccount", "ZipCode", Constant.ZipCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void scrollToText(String text) throws Exception {
		System.out.println("Scrolling to: " + text);
		Constant.driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
				+ "new UiSelector().descriptionContains(\"" + text + "\"));");
	}

	public static void clickByLocation(String location) throws Exception {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("location", location);
//			params.put("duration" , 1);
			System.out.println("Click by location: " + location);
			Object res = Constant.driver.executeScript("mobile:touch:tap", params);
			Thread.sleep(2000);
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterPin(String pin) throws Exception {
		String[] enteredPin = pin.split("");
		String value = null;
		String keyCode = null;
		try {
			System.out.println("Start entering: " + pin);
			for (int i = 0; i < enteredPin.length; i++) {
				value = enteredPin[i];
				keyCode = getKeyCode(value);
				sendKeyEvent(keyCode, 0);
			}
			Generic.WriteTestData("Able to enter pin", "", pin, "Able to enter pin: " + pin, "Same as expected",
					"Pass");
			Thread.sleep(4500);
			Control.takeScreenshot();
		} catch (Exception e) {
			Generic.WriteTestData("Able to enter pin", "", pin, "Able to enter pin: " + pin, "Not the same as expected",
					"Fail");
			Control.takeScreenshot();
		}

	}

	public static String getKeyCode(String keyCode) throws Exception {
		String value = null;
		try {
			switch (keyCode) {
			case "0":
				value = "7";
				break;
			case "1":
				value = "8";
				break;
			case "2":
				value = "9";
				break;
			case "3":
				value = "10";
				break;
			case "4":
				value = "11";
				break;
			case "5":
				value = "12";
				break;
			case "6":
				value = "13";
				break;
			case "7":
				value = "14";
				break;
			case "8":
				value = "15";
				break;
			case "9":
				value = "16";
				break;
			default:
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public static void sendKeyEvent(String keyCode, int metaStates) throws Exception {
		try {
			Map<String, Object> pars = new HashMap<>();
			pars.put("key", keyCode);
			pars.put("metastate", metaStates); // 0 lower case || 1 upper case
			Constant.driver.executeScript("mobile:key:event", pars);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void KeyboardBackButton() throws Exception {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("keySequence", "BACK");
			Constant.driver.executeScript("mobile:presskey", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void enterTextByKeyCodeEvent(String textToSend) throws Exception {
		String[] texts = textToSend.split("");
		String textValue = null;
		try {
			for (int i = 0; i < texts.length; i++) {
				textValue = texts[i];
				String convertTextToKeyCode = GetKeyCodeEventForLetters(textValue);
				if (textValue == textValue.toUpperCase()) {
					sendKeyEvent(convertTextToKeyCode, 1);
				} else {
					sendKeyEvent(convertTextToKeyCode, 0);
				}
			}

			Thread.sleep(1000);
			Control.takeScreenshot();

			Generic.WriteTestData("Sending text in to the text box", "", textToSend,
					"Should be able to send text: " + textToSend, "Same as expected", "Pass");
		} catch (Exception e) {
			e.printStackTrace();
			Control.takeScreenshot();
			Generic.WriteTestData("Sending text in to the text box", "", textToSend,
					"Should be able to send text: " + textToSend, "Not the same as expected", "Fail");
		}
//		Constant.driver.hideKeyboard();
	}

	public static String GetKeyCodeEventForLetters(String letter) throws Exception {
		String value = null;
		try {
			switch (letter.toUpperCase()) {
			case "A":
				value = "29";
				break;
			case "B":
				value = "30";
				break;
			case "C":
				value = "31";
				break;
			case "D":
				value = "32";
				break;
			case "E":
				value = "33";
				break;
			case "F":
				value = "34";
				break;
			case "G":
				value = "35";
				break;
			case "H":
				value = "36";
				break;
			case "I":
				value = "37";
				break;
			case "J":
				value = "38";
				break;
			case "K":
				value = "39";
				break;
			case "L":
				value = "40";
				break;
			case "M":
				value = "41";
				break;
			case "N":
				value = "42";
				break;
			case "O":
				value = "43";
				break;
			case "P":
				value = "44";
				break;
			case "Q":
				value = "45";
				break;
			case "R":
				value = "46";
				break;
			case "S":
				value = "47";
				break;
			case "T":
				value = "48";
				break;
			case "U":
				value = "49";
				break;
			case "V":
				value = "50";
				break;
			case "W":
				value = "51";
				break;
			case "X":
				value = "52";
				break;
			case "Y":
				value = "53";
				break;
			case "Z":
				value = "54";
				break;
			case "@":
				value = "77";
				break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	public static void clear(String text) throws Exception {
		String[] texts = text.split("");
		try {
			for (int i = 0; i < texts.length; i++) {
				sendKeyEvent("67", 0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getText(String PageName, String label) throws Exception {
		String value = null;
		String getLabel = null;
		if (label != null) {
			if (PageName != "") {
				getLabel = Constant.labelMap.get(PageName).get(label);
				System.out.println(getLabel);
			} else {
				getLabel = label;
			}
		}
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("label", getLabel);
			value = (String) Constant.driver.executeScript("mobile:edit-text:get", params);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;
	}

	public enum Direction {

		up, down, left, right;
	}

	public static void swipe(Direction direction) throws Exception {
		String start = null;
		String startY = null;
		String endY = null;
		switch (direction) {
		case up: // from bottom to top
			start = "50%";
			startY = "70%"; // 80
			endY = "40%"; // 30
			break;

		case down: // from top do bottom
			start = "50%";
			startY = "40%"; // 30
			endY = "70%"; // 80
			break;

		case left: // from top do bottom offset to left side
			start = "50%";
			startY = "80%"; // 80
			endY = "70%";
			break;

		case right: // from top do bottom offset to right side
			start = "50%";
			startY = "70%"; // 80
			endY = "80%";
			break;
		}
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("start", "" + start + "," + startY + "");
			params.put("end", "" + start + "," + endY + "");
			params.put("duration", "3");
			System.out.println("Swipe " + direction);
			Object res = Constant.driver.executeScript("mobile:touch:swipe", params);

			Control.takeScreenshot();
			Generic.WriteTestData("Able to swipe", "", "", "Swiping " + direction, "Same as expected", "Pass");

		} catch (Exception e) {
			e.printStackTrace();
			Generic.WriteTestData("Able to swipe", "", "", "Swiping " + direction, "Not the same as expected", "Fail");
		}
	}

	public enum Date {
		Month, Day, Year;
	}

	public static void swipeDate(Date date, boolean isUpSwipe) {
		String start = null;
		String startY = null;
		String endY = null;
		if (isUpSwipe) {
			startY = "70%";
			endY = "80%";
		} else {
			startY = "80%";
			endY = "70%";
		}

		switch (date) {
		case Month: // from top do bottom offset to left side
			start = "50%";
			break;

		case Day: // from top do bottom offset to right side
			start = "60%";
			break;
		case Year:
			start = "80%";
			break;
		}
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("start", "" + start + "," + startY + "");
			params.put("end", "" + start + "," + endY + "");
			params.put("duration", "3");
			System.out.println("Swipe " + date);
			Object res = Constant.driver.executeScript("mobile:touch:swipe", params);

			Control.takeScreenshot();
			Generic.WriteTestData("Able to swipe", "", "", "Swiping " + date, "Same as expected", "Pass");

		} catch (Exception e) {
			e.printStackTrace();
			Generic.WriteTestData("Able to swipe", "", "", "Swiping " + date, "Not the same as expected", "Fail");
		}

	}

	public static void ValidateEmail() throws Exception {
		try {
			System.out.println("Validate Email.");
			String[] result = Email.GetEmailBody("automationtcoe52@gmail.com", "Password5%");
			String[] getResult = new String[2];
			int count = 0;
			for (int i = result.length - 1; i >= 0; i--) {
				getResult[count] = result[i];
				count++;
				if (count == 2)
					break;
			}
			for (int j = getResult.length; j >= 0; j--) {
				String[] ResultArray = getResult[j].split(" ");
				String[] BodyArray = Constant.emailBody[j].split(" ");
				String[] testingResult = new String[ResultArray.length];
				String res = null;
				int count2 = 0;

				for (int i = 0; i < ResultArray.length; i++) {
					boolean test = ResultArray[i].equalsIgnoreCase(BodyArray[i]);
					res = Boolean.toString(test);
					if (res.equalsIgnoreCase("true")) {
						testingResult[i] = res;
						count2++;
					}

				}
				if ((((float) count2 / testingResult.length) * 100) > 90) {
//					System.out.println("Passed");
					Generic.WriteTestData("Validate the Order Tracking Email", "", "", ResultArray[j],
							"Same as expected", "Pass");
				} else {
					Generic.WriteTestData("Validate the Order Tracking Email", "", "", ResultArray[j],
							"Not the same as expected", "Pass");
//					System.out.println("Failed"); // TODO Generic.WriteTestData for fail
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void LoginUser(String msisdn) throws Exception {
		try {
			Thread.sleep(5000);
			GomoxFunction.sendKeys("LoginPage", "MobileNumber", msisdn);
			Control.click("LoginPage", "LetsGoBtn");
			Thread.sleep(1000);
			GomoxFunction.clickByLocation("71,747,1014,889");
			GomoxFunction.enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 1));
			Thread.sleep(6000);
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void ChangeUser(String msisdn) throws Exception {
		try {
			Thread.sleep(5000);
			click("Dashboard", "Menu");
			click("Menu", "Logout");
			Thread.sleep(8000);
			Control.click("LoginPage", "NotMyNumber"); // [616,471][852,506]
			Thread.sleep(5000);
			sendKeys("LoginPage", "MobileNumber", msisdn);
			Control.click("LoginPage", "LetsGoBtn");
			Thread.sleep(8000);
			
			clickByLocation("71,747,1014,889"); // ENTER PIN
			
			enterPin(Generic.ReadFromExcel("PIN", "LoginDetails", 1));
			Thread.sleep(5000);
			Control.takeScreenshot();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void PurchaseViaDebit() throws Exception {
		try {
			Thread.sleep(12000);
			Control.click("PaymentOption", "CreditCard");

			Control.sendKeys("CreditCard", "CardNumber", Generic.ReadFromExcel("CreditCard", "LoginDetails", 1));
			Control.sendKeys("CreditCard", "ExpiryDate", Generic.ReadFromExcel("CCDate", "LoginDetails", 1));
			Control.sendKeys("CreditCard", "CVC", Generic.ReadFromExcel("CCPin", "LoginDetails", 1));
			Control.takeScreenshot();
			Control.click("CreditCard", "PayBtn");
			Thread.sleep(15000);
			Control.takeScreenshot();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void PurchaseViaGCash() throws Exception {
		try {

//			//PROMO PURCHASE VIA GCASH

			GomoxFunction.clickByLocation("434,925,1483,257");
//			Thread.sleep(2000);
//			Control.takeScreenshot();
			enterPin(Generic.ReadFromExcel("GCashNum", "LoginDetails", 1));
			Constant.driver.hideKeyboard();
			Thread.sleep(1000);

			GomoxFunction.click("GCash", "NextBtn");
			Thread.sleep(5000);

			// TODO Should have this
//			GomoxFunction.enterPin(Generic.ReadFromExcel("GCashOtp", "LoginDetails", 1));
//			GomoxFunction.click("GCash", "NextBtn");
//			Thread.sleep(2000);

			GomoxFunction.enterPin(Generic.ReadFromExcel("GCashPin", "LoginDetails", 1));
			GomoxFunction.click("GCash", "NextBtn");
			Thread.sleep(1000);

			// Control.click("GCash", "PayPhp");
			GomoxFunction.click("", "PAY PHP"); // 735,2196
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
