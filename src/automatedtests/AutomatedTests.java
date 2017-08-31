
package automatedtests;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class AutomatedTests {

    private static WebDriver chrome;
    
    
    public static void main(String[] args) {
       Website website = new Website("   ");
       website.maximizeScreen();
    
    }
  
}




