
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
       
      // System.out.print(paragraphText);
       
       iPhone ip = new iPhone("6");
       System.out.println(ip.deviceName);
       
    }
  
}




