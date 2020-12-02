import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementsPractise {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Java sessions\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver,5);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //Implicit wait
		
		String[] requiredVeggies = {"Carrot", "Tomato", "Potato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");    //website name
		//Thread.sleep(3000);	
		addItemsToCart(driver, requiredVeggies);
		
		// 1. Read all the product names into list
		//2. capture only vegetable name
		//3. Store input vegetables list in an array
		//4. compare the the input vegetables to the ones extracted from the read and add to cart accordingly
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));  //Explicit wait
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='promoInfo']")));  //Explicit wait
		System.out.println(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText());
		
					
	}
	
	public static void addItemsToCart(WebDriver driver, String[] requiredVeggies) {
		
		int j=0;
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		for (int i=0; i<products.size();i++) {
			String[] name = products.get(i).getText().split("-");
			String nameFormatted = name[0].trim();
			
			List itemsToCart = Arrays.asList(requiredVeggies);
			
			if(itemsToCart.contains(nameFormatted)) {
				
				j++;
				
				driver.findElements(By.xpath("//div[@class='product-action']/button[@type='button']")).get(i).click();
				
				if (j==requiredVeggies.length) {
					break;
				}
				
			}
			
	
		}
		
	}

}
