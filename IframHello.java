package Task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframHello {

	public static void main(String[] args) {
		
		// load the browser
		WebDriver driver = new ChromeDriver();
		
		// load the url
		driver.navigate().to("https://the-internet.herokuapp.com/iframe");
		
		// Implicit wait is used
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// maximize the window
		driver.manage().window().maximize();
		
		//switch to the frame
	    WebElement frame = driver.findElement(By.xpath("//iframe[@title=\"Rich Text Area\"]"));
		driver.switchTo().frame(frame);
		
		//using p tag clear the text and write the text hello people 
        WebElement ele = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));				       
        ele.clear();
        ele.sendKeys("Hello People");   
        
        // close the driver
        driver.close();
	}
	}		

