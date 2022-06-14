package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DroppableAssn1 {

	public static void main(String[] args) {
		//http://www.leafground.com/pages/drop.html

		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//Open browser
		ChromeDriver driver = new ChromeDriver();
		//maximise window
		driver.manage().window().maximize();
		//implicit wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open the exact webpage by providing url
		driver.get("http://www.leafground.com/pages/drop.html");

		//drag and drop webelements
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		//Actions class to perform drag and drop
		Actions builder = new Actions(driver);
		builder
		.moveToElement(drag)
		.clickAndHold()
		.dragAndDrop(drag, drop)
		.perform();
		
		//verify Dropped
		String text = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
		System.out.println(text);
		
		driver.quit();

	}

}
