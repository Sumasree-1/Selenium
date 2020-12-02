import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Java sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div[contains(@class,'IiD88i')]/input[@type='text']")).sendKeys("testaccount");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("hi there");
		driver.findElement(By.xpath("//div[contains(@class,'_1D1L_j')]/button")).click();
	}

}
