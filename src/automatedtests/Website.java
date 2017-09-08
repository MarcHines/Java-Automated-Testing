
package automatedtests;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Website {
    public final String url;
    public String sourcecode;
    public String text;
    private final WebDriver wd;
    public ArrayList<Device> devices = new ArrayList<>();
    
        //Website Contructor: Takes as an argument the url of website
        public Website(String arg_url){
          //If user gives empty string or null, we'll just use example.com
          if(arg_url == null || arg_url.trim().isEmpty()){
            arg_url = "http://example.com/";
          }
          
          System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
          WebDriver chrome = new ChromeDriver();
          chrome.get(arg_url);
          
          //Initialize our Class Attributes
          this.url = chrome.getCurrentUrl();
          this.sourcecode = chrome.getPageSource();
          this.wd = chrome;
        }
        
        public String getSourceCode(){
          return this.sourcecode;
        }
        
        public String getURL(){
          return this.wd.getCurrentUrl();
        }
        
        //Remove all of the html tags and return all the text of given html tag
        public ArrayList<String> getTextOf(String tag){
          if(tag == null || tag.isEmpty()){
            return null;
          }
  
          ArrayList<String> result = new ArrayList<>();
          for(WebElement we : this.wd.findElements(By.cssSelector(tag))){
            result.add(we.getText());
          }
          return result;
        }
        
        //Returns the driver used to instanciate this Object
        private WebDriver getDriver(){
          return this.wd;
        }
        
        //Resize the screen of the Web Browser
        public void resizeScreen(int width, int height){
          Dimension dimension = new Dimension(width, height);
          this.getDriver().manage().window().setSize(dimension);
        }
        
        //Maximizes the screen of the Web Browser
        public void maximizeScreen(){
          this.getDriver().manage().window().maximize();
        }
        
        //Captures Screenshot 
        public  String captureScreenshot (String screenshotName){
            WebDriver driver = this.getDriver();
            
        try {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String dest = "/Users/marcus.hines/Desktop/Screenshots/" + screenshotName + ".png";
            File destination = new File(dest);
            FileUtils.copyFile(source, destination);
            return dest;
            } 

        catch (IOException e) {return e.getMessage();}
        }
        
        //Returns all elements of class name X
        public ArrayList<WebElement> getAllElements(String cssClass){
          WebDriver driver = this.getDriver();
          return (ArrayList)driver.findElements(By.cssSelector(cssClass));
        }
        
        //Add another Device to the list of devices we want to test website on
        public void addDevice(Device device){
          this.devices.add(device);
        }
  
        //Returns list of devices that we can use to test
        public ArrayList<Device> getDevices(){
          return this.devices;
        }
        
        //Scrolls down the page to specified range. Use 0 - 2500 for bottom of page
        public void scrollDown(int start, int end){
          JavascriptExecutor js = (JavascriptExecutor)this.wd;
          String arg = "scrollBy(" + Integer.toString(start) + "," + Integer.toString(end) + ")";
          js.executeScript(arg);
        }
        
        //Clicks link that has given name
        public void clickLink(String text){
          if(text != null && !text.isEmpty()){
              this.wd.findElement(By.linkText(text)).click();
          }
        }
}
