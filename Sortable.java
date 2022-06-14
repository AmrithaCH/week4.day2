package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

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
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//ul[@id='sortable']/li[1]")))
		.clickAndHold()
		.dragAndDrop(driver.findElement(By.xpath("//ul[@id='sortable']/li[3]")), 
				driver.findElement(By.xpath("//ul[@id='sortable']/li[1]")))
		.perform();		
		
		}

}
