package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableAssn1 {

	public static void main(String[] args) {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//Open browser
		ChromeDriver driver = new ChromeDriver();
		//maximise window
		driver.manage().window().maximize();
		//implicit wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open the exact webpage by providing url
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));

		Actions builder = new Actions(driver);
//		builder.moveToElement(item1)
//		.clickAndHold()
//		.dragAndDrop(item1, item7)
//		.perform();
		
		builder.moveToElement(item1)
		.click()
		.keyDown(Keys.CONTROL)
		.moveToElement(item7)
		.click().perform();
	}

}
