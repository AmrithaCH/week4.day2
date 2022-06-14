package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DraggableAssn1 {

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
		driver.get("http://www.leafground.com/pages/drag.html");
		
		
		WebElement drag = driver.findElement(By.id("draggable"));
		
		Actions builder = new Actions(driver);
		builder
		.moveToElement(drag)
		.clickAndHold()
		.dragAndDropBy(drag, 150, 200)
		.perform();
		
	}

}
