
package automatedtests;
import java.util.*;

public class Device {
    int width;
    int height;
    public boolean isPhone;
    String deviceName;
    
    
    public String getDeviceName(){
      return this.deviceName != null ? this.deviceName : "undefined";
    }

    public int getWidth(){
      return this.width;
    }
    
    public int getHeight(){
      return this.height;
    }
    
    public boolean isPhone(){
      return this.isPhone;
    }
}

