package MySeleniumSessionClasses_GI.MySeleniumSessionClasses_AI;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.nio.file.Files;
import java.nio.file.Path;


public class Sai_code {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sai Kankipati\\Downloads\\chromedriver-win32 (4)\\chromedriver-win32\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      
	      
	      //handle pop-up
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			driver.navigate().refresh();
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title=\"notification-frame-b8a69227\"]")));
			driver.findElement(By.xpath("//i[@class=\"wewidgeticon we_close\"]")).click();
			
			
			//verify the page title
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			String expectedtitle = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
			Assert.assertEquals(actualTitle, expectedtitle);
			
			
			
		      //verify the url
				String actualurl=driver.getCurrentUrl();
				System.out.println(actualurl);
				String expectedurl="https://www.makemytrip.com/";
				Assert.assertEquals(actualurl,expectedurl);
				Thread.sleep(3000);
				
				
		      //verify the country name 
				driver.findElement(By.xpath("//span[@class='latoBold capText font11']")).click();
				WebElement  name=driver.findElement(By.xpath("//div[@class=\"selectConWrap\"]//span[2]"));
				Thread.sleep(2000);
				
				
				Assert.assertEquals("India",name.getText());
			    driver.findElement(By.id("fromCity")).click();
		        driver.findElement(By.xpath("//*[@placeholder='From']")).sendKeys("delhi");
		        Thread.sleep(2000);
		        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		        driver.findElement(By.id("toCity")).click();
		        driver.findElement(By.xpath("//*[@placeholder='To']")).sendKeys("mumbai");
		        Thread.sleep(2000);
		        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		        Thread.sleep(2000);
		        driver.findElement(By.xpath("//*[@aria-label='Wed Sep 20 2023']")).click();
		        driver.findElement(By.xpath("//*[@data-cy='returnArea']")).click();
		        driver.findElement(By.xpath("//*[@aria-label='Fri Oct 06 2023']")).click();
		        driver.findElement(By.xpath("//*[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();
		        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")).click();

		        // Verify the FROM
		        String From = driver.findElement(By.xpath("//*[@value='New Delhi, India']")).getAttribute("value");
		        Assert.assertEquals(From,"New Delhi, India");

		        // Verify the TO
		        String TO = driver.findElement(By.xpath("//*[@value='Mumbai, India']")).getAttribute("value");
		        Assert.assertEquals(TO,"Mumbai, India");

		        // Verify the Depart
		        String Depart = driver.findElement(By.xpath("//*[@value='Wed, Sep 20, 2023']")).getAttribute("value");
		        Assert.assertEquals(Depart,"Wed, Sep 20, 2023");

		        // Verify the Return
		        String Return = driver.findElement(By.xpath("//*[@value='Fri, Oct 6, 2023']")).getAttribute("value");
		        Assert.assertEquals(Return,"Fri, Oct 6, 2023");

		        // Verify the visible text 'Flights from New Delhi to Mumbai, and back'
		        String visible = driver.findElement(By.xpath("//*[starts-with(@class,'font24')]")).getText();
		        Assert.assertEquals(visible,"Flights from New Delhi to Mumbai, and back");
		        driver.navigate().back();
		        Thread.sleep(4000);

		        // Printing all the present links
		        List <WebElement> linklist = driver.findElements(By.tagName("a"));
		        for (int i=0; i < linklist.size(); i++)
		        {
		            System.out.println(linklist.get(i).getText());
		        }

		     // Capturing the screenshot
		        TakesScreenshot scrShot = ((TakesScreenshot) driver);
		        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		        File DestFile = new File("C:\\Users\\Sai Kankipati\\eclipse-workspace\\PraticeProject\\src\\pratice\\SeleniumWeekTest\\ScreenShot\\test.png");
		        Files.copy(SrcFile.toPath(), DestFile.toPath());
		        driver.close();
		        
		        
	}

}