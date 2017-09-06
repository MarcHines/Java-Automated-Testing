package automatedtests;
import java.util.*;

public class iPhone extends Device {
    public final int width;
    public final int height;
    public final String deviceName;
    public final String version;
   
    public iPhone(String version){
         this.version = version;
         
         switch(version){
             case "6Plus":
               this.width = 414;
               this.height = 736;
               break;
                 
             case "6":
               this.width = 375;
               this.height = 667;
               break;
                 
             case "5":
               this.width = 320;
               this.height = 568;
               break;
                 
             default:
               this.width = 0;
               this.height = 0;
               break;
         }
         
         this.deviceName = "iPhone " + version;
    }
    
    public void landscape(){
      
    }
}
