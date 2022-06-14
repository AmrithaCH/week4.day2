package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResizableAssn1 {

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
		driver.get("https://jqueryui.com/resizable/");
		
		//Javasript executor to scroll down the window 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		//switch into frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		//driver.switchTo().frame(0);
		
		WebElement resizeright = driver.findElement(By.xpath("//h3[text()='Resizable']/following-sibling::div"));
		WebElement resizedown = driver.findElement(By.xpath("//h3[text()='Resizable']/following-sibling::div[2]"));
		WebElement resizeDiag = driver.findElement(By.xpath("//h3[text()='Resizable']/following-sibling::div[3]"));
		
		
		System.out.println(resizeright.getLocation());
		System.out.println(resizedown.getLocation());
		System.out.println(resizeDiag.getLocation());
		
		
		Actions builder = new Actions(driver);
		builder
		//.moveToElement(resizeright)
		.clickAndHold(resizeright)
		.dragAndDropBy(resizeright, 40, 0)
		//.moveByOffset(40, 30)
		.release()
		.perform();
		
		builder
		.clickAndHold(resizedown)
		.dragAndDropBy(resizedown, 0, 30)
		.release()
		.perform();
		
		builder
		.clickAndHold(resizeDiag)
		//.moveByOffset(200, 170)
		.dragAndDropBy(resizeDiag, 40, 40)
		.perform();
		
		System.out.println(resizeDiag.getLocation());


	}

}
