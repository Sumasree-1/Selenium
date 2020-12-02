import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators{

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Java sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("//div[@class='logobar']/div/div[3]/p/a")).click();
		driver.findElement(By.id("login1")).sendKeys("hello");
		driver.findElement(By.name("passwd")).sendKeys("helponit");
		driver.findElement(By.cssSelector("input.signinbtn")).click();
		

	}

}
