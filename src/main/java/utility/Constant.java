/*
 *Description: Control Functions library 
'Author :Sunanda Tirunagari and Ankit Kumar
 */

package utility;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.URL;

public class Constant {

	/*
	 * *********************************************************** User-specific
	 * parameters - can be modified by END users
	 * ***********************************************************
	 */

	public static String senderList = "8080,2652,2882,9451926523,2916,2884,AutoLoadMAX,GLOBE,3373";// comma seperated
																									// values

	public static String TestDataFilePath = "DawnGomoX_DataSheet.xlsx";

	public static final String path_to_python_scripts = "E:\\Python27_Excel_PDF\\";

	public static float smsPercentageMatch = 0.70f;

	public static int smsWaitingTime = 30; // in seconds

	public static int sleepTimeBeforeCheckingMessages = 120000;// milliseconds
	public static String WorkSpace = System.getProperty("user.dir");
	public static String ProjectName = "GlobeOne";

	/*
	 * *****************************************************************************
	 * ****************
	 * *****************************************************************************
	 * ****************
	 * *****************************************************************************
	 * ****************
	 */

	/*
	 * *********************************************************** System Parameters
	 * - shall NOT be modified by END users
	 * ***********************************************************
	 */

	public static String ipToListen = null;
	public static final String Environment = "SIT";
	public static int SeqID = 1;
	public static int StepIndex = 0;
	public static int TestStepIndex = 0;
	public static int StepStatus = 0;
	public static int TestCaseIndex = 0;
	public static int TestCaseNumber = 0;
	public static int PassedCases = 0;
	public static int FailedCases = 0;
	public static HashMap<String, HashMap<String, String>> Map = new HashMap<String, HashMap<String, String>>();
	public static HashMap<String, HashMap<String, String>> Map2 = new HashMap<String, HashMap<String, String>>();

	public static HashMap<String, HashMap<String, String>> labelMap = new HashMap<String, HashMap<String, String>>();

	public static final String Brand[] = null;

	public static boolean MultipleTCInOneMethod = false;

	public static int MaxDriverTimeOut = 30;
	public static String UserStoryName = null;
	public static String ResultFilePath = null;
	public static String ScreenshotFolderName = null;
	public static String strScenarioDesc = null;
	public static String strExpectedResult = null;
	public static String strActualResult = null;
	public static String PageName = null;
	public static String locator = null;
	public static String RecentScreenshot = null;
	public static WebDriver driver_w = null;
	public static AndroidDriver<AndroidElement> driver;
	public static WebElement webelement;
	public static boolean DefaultoptionalFlag = true;

	public static int flag_init = 0;
	public static String lastSMSTime = "";
	public static long youtubeElapsedTime = 0;
	public static long updatedStartTime = 0;
	public static boolean timerRunning = false;

	// this is only for critical func, like checking balance, turning on/off
	// internet, making voice call
	public static int retryOnFailureCount = 3;

	public static int numberOfFreeMessages = 0;

	public static WebElement youtubeScreen = null;
	public static int youtubeX = -1;
	public static int youtubeY = -1;
	public static String lastReadSMSFileName = "";

	public static int comparisonType = 2;// ignore tagged texts
	public static String dynamicLine = "";
	public static float numberOfFreetexts = 0;

	public static double lastSmsOrUssdTime = 0;
	public static boolean flagMultipleMessages = false;

	public static float lastSmsPercentMatch = 0.0f;
	public static boolean flagOnlySpecificSenders = true;

	public static String textViewerPackageName = "com.example.hp_pc.simpletextviewer";
	public static String textViewerActivityName = "com.example.hp_pc.simpletextviewer.MainActivity";
	public static String[] specificSenderList = senderList.split(",");
	public static int numberOfExpectedSms = 1;
	public static int numberOfExpectedReply = 1;
	public static int maxNumberOfColumns = 50;
	public static int globalRowNumber = 0;
	public static int lastRepliedRowNumber = 0;
	public static String brandType = "Regular";
	public static boolean alreadyWaited = false;
	public static String commandPullSS = "adb shell input keyevent 4";
	public static String commandPullSSS = "adb shell input touchscreen swipe 830 1120 530 1120";

	public static boolean flag = true;

	public static boolean Broadband = false;

	public static boolean SGTier1 = false;

	public static int scrolLimit = 0;

	public static String midX;

	public static String Failures;

	public static boolean paperlessBillinhDisabled = false;

	public static boolean GoGreen = false;

	public static int defaultBrowserTimeOut = 30;

	public static int defaultBrowserTimeOut1 = 5;

	public static int NumberOfTriesToDownloadApp = 3;

	public static boolean BillGenerated = true;

	public static int MinDriverTimeOut = 2;

	public static boolean AppLaunched = false;

	public static String FirstName;
	public static String LastName;
	public static String NickName;
	public static String UnitNo ;
	public static String StreetName;
	public static String Province;
	public static String City;
	public static String Barangay;
	public static String ZipCode;

	public static String[] emailBody = {
			"Order Tracking Number Hi " + Constant.FirstName + ", Yay! Your SIM is on the way! Tracking "
					+ "your package Your Tracking number: GOMO200001968 Go to XDE and enter the tracking "
					+ "number. Please note also that due to the surge in orders, deliveries will take longer"
					+ " than usual. Note also that you will only be able to track your package once it’s "
					+ "shipped out to the courier. Go to XDE Transaction Number: DNS1623825434823485 Your "
					+ "transaction was successfully processed. For more information on shipping and official "
					+ "reciepts, please visit our FAQs."

			,

			"Cross Tracking Device Email Template Hi " + Constant.FirstName + ", "
					+ "Yay! Thank you for ordering a GOMO SIM! Tracking your package "
					+ "Please wait for our email with your assigned courier and tracking "
					+ "number, which will be sent to you shortly. To track your order, "
					+ "simply enter the tracking number in the courier website provided. "
					+ "Note also that you will only be able to track your package once it’s "
					+ "shipped out to the courier. Total P299 Date Time: 02:37 PM Jun 16, 2021 " + "Delivery Location: "
					+ Constant.UnitNo + ", " + Constant.StreetName + ", " + Constant.Barangay + ", " + Constant.City
					+ ", " + Constant.Province + " "
					+ "Transaction Number: DNS1623825434823485 Receipt Summary Payment Method "
					+ "Credit/Debit Card Item Price GOMO SIM FREE 30 GB P299 Shipping/Delivery "
					+ "FREE Discount - P0 TOTAL P299 Your transaction was successfully processed. "
					+ "For more information on shipping and official reciepts, please visit our FAQs." };

//	public static String[] emailBody = { "Order Tracking Number Hi Noel, Yay! Your SIM is on "
//			+ "the way! Tracking your package Your Tracking " + "number: GOMO200001968 Go to XDE and enter the "
//			+ "tracking number. Please note also that due to " + "the surge in orders, deliveries will take longer "
//			+ "than usual. Note also that you will only be able "
//			+ "to track your package once it’s shipped out to the "
//			+ "courier. Go to XDE Transaction Number: DNS1623825434823485 "
//			+ "Your transaction was successfully processed. For more"
//			+ " information on shipping and official reciepts, please visit our FAQs."
//
//			,
//
//			"Cross Tracking Device Email Template Hi Noel, Yay! Thank you for "
//			+ "ordering a GOMO SIM! Tracking your package Please wait for our "
//			+ "email with your assigned courier and tracking number, which will "
//			+ "be sent to you shortly. To track your order, simply enter the tracking "
//			+ "number in the courier website provided. Note also that you will only be "
//			+ "able to track your package once it’s shipped out to the courier. Total "
//			+ "P299 Date Time: 02:37 PM Jun 16, 2021 Delivery Location: 15, St. Andrew St, "
//			+ "BAESA, QUEZON CITY, METRO MANILA Transaction Number: DNS1623825434823485 Receipt "
//			+ "Summary Payment Method Credit/Debit Card Item Price GOMO SIM FREE 30 GB P299 "
//			+ "Shipping/Delivery FREE Discount - P0 TOTAL P299 Your transaction was successfully "
//			+ "processed. For more information on shipping and official reciepts, please visit our FAQs." };

	public static int startingTextBalance;
	public static int endingTextBalance;

	public static int startingDataBalance;
	public static int endingDataBalance;

	public static int startingCallBalance;
	public static int endingCallBalance;

}
