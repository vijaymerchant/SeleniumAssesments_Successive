package MySeleniumSessionClasses_GI.MySeleniumSessionClasses_AI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//System.setProperty("ChromeDriver", "/home/vijaymishra/Downloads/Old Laptop/Downloads/Selenium Learning/Dependencies/chromedriver_v114");
		WebDriver driver = new ChromeDriver();
		try {
		
		driver.manage().window().maximize();
		
		
		SoftAssert softAssert = new SoftAssert();
		String PageTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		String ActualURL = "https://www.makemytrip.com/";
 		
		driver.get("https://www.makemytrip.com/");
		//After landing on the given url ,fetch and verify the page title , 
		String GetTitle = driver.getTitle();
		System.out.println("GetTitle = "+GetTitle);
		Assert.assertEquals(GetTitle, PageTitle);
		
		// Fetch and verify the url
		String GetURL = driver.getCurrentUrl();
		System.out.println("Get URL = "+GetURL);
		Assert.assertEquals(GetURL, ActualURL);
		
		//driver.wait(3000);
//		try {
//            driver.wait(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
		Thread.sleep(3000);
		System.out.println("before swithch");
		driver.switchTo().frame(driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")));
		//driver.wait(3000);
		System.out.println("After swithch");
//		WebDriverWait wait1 = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("webklipper-publisher-widget-container-notification-close-div")));
		driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
		
		driver.switchTo().defaultContent();
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		//Verify the INDIA country is visible after clicking on country dropdown
		driver.findElement(By.xpath("//span[@class='switcherDownArrow appendLeft10']")).click();
		Thread.sleep(2000);
		WebElement countryName = driver.findElement(By.name("INDIA"));
		driver.wait(5000);
		softAssert.assertEquals(true, false);
		}
		finally {
				driver.quit();
				}
		
	}

}
