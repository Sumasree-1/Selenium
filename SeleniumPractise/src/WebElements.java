import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Java sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.spicejet.com/");    //website name
		
		Thread.sleep(3000);
	//  handling dynamic drop downs to select start and destination cities	
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	//	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	//	driver.findElement(By.xpath("//div[@class='left1'] //input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		Thread.sleep(3000);
		
	//	Date	
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
	//	Static dropdowns passengers
		driver.findElement(By.id("divpaxinfo")).click();
		Select a  = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		a.selectByValue("2");
		Select c  = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Child")));
		c.selectByIndex(1);
		Select i  = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Infant")));
		i.selectByVisibleText("1");
		
	// checkbox selection
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id *= 'friendsandfamily']")).click();
		
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'friendsandfamily']")).isSelected());
		
	//print number of checkboxes in the page
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
	
	//hit search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		driver.switchTo().alert().accept();
	}

}
