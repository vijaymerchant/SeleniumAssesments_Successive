package MySeleniumSessionClasses_GI.MySeleniumSessionClasses_AI;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

public class Omkar_code {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {
//	System.setProperty("webdriver.chrome.driver",
//		"C:/Users/OmkarPabale/A1_Drivers/chromedriver-win64/chromedriver.exe");
//	ChromeOptions co = new ChromeOptions();
//	co.setBinary("C:/Users/Omkar Pabal/A1_Drivers/chrome-win32/chrome.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//User Navigate to page and handles the popUp
	driver.get("https://www.makemytrip.com/");
	driver.navigate().refresh();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with(@title, 'notification-frame')]")));
	driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
//User verifies Page Title
	String actualTitle = driver.getTitle();
	String expectedTitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
//	Assert.assertEquals(actualTitle, expectedTitle);
//User verifies Page URL
	String URL = driver.getCurrentUrl();
//	Assert.assertEquals(URL, "https://www.makemytrip.com/");
//User verify Country location
	driver.findElement(By.xpath("//span[@class=\"latoBold capText font11\"]")).click();
	WebElement country = driver.findElement(By.xpath("(//div[@class=\"selectConWrap\"]//span)[2]"));
//	Assert.assertEquals("India", country.getText());
//User verifies Booking head Labels
	WebElement FROM = driver.findElement(By.xpath("(//label[@for=\"fromCity\"]//span)[1]"));
//	Assert.assertEquals("From", FROM.getText());
	WebElement TO = driver.findElement(By.xpath("(//label[@for=\"toCity\"]//span)[1]"));
//	Assert.assertEquals("To", TO.getText());
	WebElement DEPART = driver.findElement(By.xpath("(//label[@for=\"departure\"]//span)[1]"));
//	Assert.assertEquals("Departure", DEPART.getText());
	WebElement RETURN = driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[4]"));
//	Assert.assertEquals("Return", RETURN.getText());
//User select Round trip option
	driver.findElement(By.xpath("//li[text()='Round Trip']//span")).click();
//User Enter from City
	driver.findElement(By.xpath("//input[@id='fromCity']")).click();
	driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("New Delhi");
	List<WebElement> cities1 = driver.findElements(By.className("calc60"));
	for (WebElement city1 : cities1) {
	    if (city1.getText().equalsIgnoreCase("New Delhi, India")) {
		city1.click();
		break;
	    }
	}
//User Enter City To
	driver.findElement(By.xpath("//input[@id='toCity']")).click();
	driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Mumbai");
	List<WebElement> cities2 = driver.findElements(By.className("calc60"));
	for (WebElement city2 : cities2) {
	    if (city2.getText().equalsIgnoreCase("Mumbai, India")) {
		city2.click();
		break;
	    }
	}
//User enter dates and Search flight
	String date1 = "8";
	String date2 = "9";
	driver.findElement(By
		.xpath("(//div[@class='DayPicker-Month'])[1]//div[@class='dateInnerCell']//p[text()='" + date1 + "']"))
		.click();
	driver.findElement(By
		.xpath("(//div[@class='DayPicker-Month'])[1]//div[@class='dateInnerCell']//p[text()='" + date2 + "']"))
		.click();
	driver.findElement(By.xpath("//a[text()='Search']")).click();
//User verifies Journey Title
	String fl = driver.findElement(By.xpath("//div[@class='listingRhs']//span[text()='Flights from ']")).getText();
	String flight = fl.replace("\n", " ");
//	Assert.assertEquals(flight, "Flights from New Delhi to Mumbai, and back");
//User Take Screenshot of Displayed Search Page
	TakesScreenshot screenshot = (TakesScreenshot) driver;
	File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
	String destinationPath = "C:/Users/OmkarPabale/eclipse-workspace/SeleniumUpskill/src/main/resources/Screenshots/flight.png";
	FileHandler.copy(srcFile, new File(destinationPath));
//User Navigate Back
	driver.navigate().back();
//User get all links from Home Web Page
	List<WebElement> links = driver.findElements(By.tagName("a"));
	for (WebElement link : links) {
	    System.out.println("Text: " + link.getText());
	    System.out.println("URL: " + link.getAttribute("href"));
	}
//User closes the browser
	driver.close();
    }
}