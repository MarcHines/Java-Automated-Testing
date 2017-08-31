
package automatedtests;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Website {
    public final String url;
    public String sourcecode;
    public String text;
    private final WebDriver wd;
    
        public Website(String arg_url){
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
        
        public String getWebsiteName(){
          return this.url;
        }
        
        //Remove all of the html tags and return only the text on webpage
        public String getText(){
          return null;
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


}
