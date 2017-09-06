
package automatedtests;
import java.util.*;

public class Device {
    int width;
    int height;
    String deviceName;
    
    
    
    public String getDeviceName(){
      return this.deviceName != null ? this.deviceName : "undefined";
    }

}

