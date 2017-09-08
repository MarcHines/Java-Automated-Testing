
package automatedtests;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutomatedTests {

    private static WebDriver chrome;
    
    
    public static void main(String[] args) {
       Website website = new Website("https://dev-marketingexperiments.meclabs.net/participate-research-project-drive-conversion-increases");
       ArrayList<String> paragraphText = website.getTextOf("p");
       
       
       website.addDevice(new iPhone("6"));
       website.addDevice(new iPhone("6Plus"));
       website.addDevice(new iPhone("5"));
       website.maximizeScreen();
       
       website.scrollDown(0, 250);
       try{
       Thread.sleep(4000);
       }catch(Exception e){}
       website.scrollDown(250, 2500);
       
       
      
    }
  
}




