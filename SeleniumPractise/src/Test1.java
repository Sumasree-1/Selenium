import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) {
		// Invoke the chrome browser

		System.setProperty("webdriver.chrome.driver", "C:\\Java sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		
		Actions a =new Actions(driver);
		WebElement veggies = driver.findElement(By.xpath("//body/div/div/div/div/ul/li[2]/a"));
		
		a.moveToElement(veggies).build().perform();
		
		driver.findElement(By.xpath("//body/div/div/div/div/ul/li[2]/ul/li[2]/a")).click();
		
		
	}

}
