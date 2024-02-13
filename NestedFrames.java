
package Task21;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrames {

	public static void main(String[] args) throws InterruptedException {
		// load the url
		WebDriver driver = new ChromeDriver();
		
		// launcher the browser
		driver.navigate().to("http://the-internet.herokuapp.com/nested_frames");
		
		// add implisittime  wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       
        // window maximize
        driver.manage().window().maximize();
     
        //switch to the top frame
        WebElement top =  driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(top);
       
        //very there are 3 frames on the page
        List<WebElement> ele = driver.findElements(By.tagName("frame"));
        ele.size();
        System.out.println(ele.size());
   
        // switch to the left frame
        WebElement left = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(left);
       
      //verify the left frame text
          driver.findElement(By.tagName("body")).getText();
        System.out.println(driver.findElement(By.tagName("body")).getText());
       
        //switch back to the top frame
        driver.switchTo().parentFrame();
       
        //switch to the middle frame 
        WebElement mid = driver.findElement(By.xpath("//frame[@name=\"frame-middle\"]"));
        driver.switchTo().frame(mid);
        
        // verify the middle frame text
         driver.findElement(By.tagName("div"));
        System.out.println(driver.findElement(By.tagName("div")).getText());
       
        // switch back to the top frame
        driver.switchTo().parentFrame();
        
        // switch to the right frame
        WebElement rig = driver.findElement(By.xpath("//frame[@name=\"frame-right\"]"));
        driver.switchTo().frame(rig);
        
        // verify the right  frame text
           driver.findElement(By.tagName("body"));
        System.out.println(driver.findElement(By.tagName("body")).getText());
        
        //switch back  to the top frame
        driver.switchTo().parentFrame();
      
        //  adding thread or sleep
        Thread.sleep(300);
        
        // switch to the bottom frame
        WebElement bottom = driver.findElement(By.xpath("// frame[@ src='/frame_bottom']"));
             driver.switchTo().frame(bottom);
             
        // verify the bottom frame has a  text
          driver.findElement(By.tagName("body")).getText();
       System.out. println(driver.findElement(By.tagName("body")).getText());
      
       // switch back to the to frame 
        driver.switchTo().parentFrame();
        
      //verify the page title is frames
      System.out.println(driver.getTitle());
        driver.close();
	}

}
