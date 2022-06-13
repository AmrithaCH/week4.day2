package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NykaaAssn2 {

	public static void main(String[] args) throws InterruptedException {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//Open browser
		ChromeDriver driver = new ChromeDriver();
		//maximise window
		driver.manage().window().maximize();
		//implicit wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open the exact webpage by providing url
		driver.get("https://www.nykaa.com/");

		//Actions object to move to  brand L'Oreal Paris		
		Actions builder = new Actions(driver);

		WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
		builder.moveToElement(brand).perform();
		builder.moveToElement(driver.findElement(By.id("brandSearchBox"))).perform();
		builder.sendKeys("L'Oreal Paris").perform();
		builder.moveToElement(driver.findElement(By.linkText("L'Oreal Paris"))).click().perform();

		//check title
		if((driver.getTitle()).contains("L'Oreal Paris"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}

		//click on the Sort by		
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='Sort By : popularity']"))).click().perform();

		//Click on Customer top rated
		builder.moveToElement(driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div"))).click().perform();

		//click on category
		driver.findElement(By.xpath("//div[@id='first-filter']//span[text()='Category']")).click();
		//Click on Hair>Hair care>Shampoo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div/following-sibling::div")).click();
		//Click on concern>Color protection
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']/parent::div/following-sibling::div")).click();


		//Check filter contains shampoo
		List<WebElement> filter = driver.findElements(By.xpath("//span[@class='filter-value']"));
		for(int i=0; i<filter.size(); i++)
		{
			if(filter.get(i).getText().contains("Shampoo"))
			{
				break;
			}
		}
		System.out.println("filter contains shampoo");

		//click on color protect shampoo
		WebElement image = driver.findElement(By.xpath("//a[contains(@href,'color-protect')]//img"));
		builder.moveToElement(image).click().perform();

		//get window handles and move to the shampoo window and select 175ml

		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1));

		WebElement dropdown = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select dd= new Select(dropdown);
		dd.selectByVisibleText("175ml");
		//get price and add to cart
		String price = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
		System.out.println("Price: "+price);
		Thread.sleep(2000);
		WebElement addToBag = driver.findElement(By.xpath("//span[text()='Add to Bag']"));
		builder.moveToElement(addToBag).click().perform();
		driver.findElement(By.xpath("//span[@class='cart-count']/parent::button")).click();

		//check the price in shopping cart
		Thread.sleep(2000);
		WebElement framecart = driver.findElement(By.xpath("//iframe[contains(@src,'mobileCartIframe?ptype')]"));
		driver.switchTo().frame(framecart);
		String cartPrice = driver.findElement(By.xpath("//div[contains(@class,'medium-strong') and contains(@class,'value')]")).getText();
		System.out.println("Cart price: "+cartPrice);
		
		//Click on Proceed to add to cart
		driver.findElement(By.xpath("//span[@class='vernacular-string' and text()='Proceed']")).click();
		Set<String> windows1 = driver.getWindowHandles();
		List<String> windowsList1 = new ArrayList<String>(windows1);
		driver.switchTo().window(windowsList1.get(1));
		
		//Continue as guest for payment
		driver.findElement(By.xpath("//button[@type='button' and text()='CONTINUE AS GUEST']")).click();

		//get price in final 
		String finalPrice =  driver.findElement(By.xpath("//div[contains(text(),'Grand Total')]/following-sibling::div/span")).getText();
		System.out.println(finalPrice);

		if(cartPrice.contains(finalPrice))
		{
			System.out.println("price is same");
		}
		else
		{
			System.out.println("not same");
		}


		//quit browser
		driver.quit();


	}

}
