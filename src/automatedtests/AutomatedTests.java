
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
       
       ArrayList<String> allLinkText = new ArrayList<String>();
       
       for(WebElement webelement : website.getAllElements("a")){
           if(!webelement.getText().equals("")){
              allLinkText.add(webelement.getText().trim());
           }
       }
       
       System.out.println(allLinkText);
       System.out.println(website.getURL());
       website.clickLink(allLinkText.get(0));
       System.out.println(website.getURL());
    }
  
}




