package Task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Click Here")).click();
		
		// switch to new window converting set to list
		Set<String> window = driver.getWindowHandles();
		List<String> list= new ArrayList<>(window);
		driver.switchTo().window(list.get(1));
		
		// validation
		String text=  driver.findElement(By.xpath("// h3[text()='New Window']")).getText();
		if ( text.equals("new window"))
		{
			System.out.println("the text present inthe new window match:"+ text);
		}
		else
		{
			System.out.println("the text present inthe new window faild with match:"+ text);
		}
		
		//close the child window
		driver.close();
		
		// verify the parent window active
		String parent =  driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText();
	 if ( parent.equals("open a new window"))
	 {
		 System.out.println("the present window is active  :"+ parent);
	 }
	 else
	 {
		 System.out.println("parent window not active");
	 }
	 
	// close the browser
		driver.close();
		
		
	}

}
