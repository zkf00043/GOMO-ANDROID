package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Testing {

	public static void main(String[] args) throws Exception {
		try {
			GomoxFunction.LaunchAppInPerfecto("staging.ph.com.globe.dawn");
			Thread.sleep(6000);
			WebElement element = Constant.driver.findElement(By.xpath("//*[@content-desc=\"No GOMO number yet? Join the GOMO fam now!\"]"));
			//element.sendKeys("9271817262");
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
