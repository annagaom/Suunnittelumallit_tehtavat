package Bridge.Remote;
import Bridge.Remote.BasicRemote    ;
import Bridge.device.Device;
public class SmartRemote extends BasicRemote {
    public SmartRemote(Device device) {
        super(device);
    }

    // New functionality for SmartRemote
    public void voiceControl(String command) {
        if (device.isEnabled()) {
            System.out.println("Executing voice command: " + command);
        } else {
            System.out.println("Cannot execute command. The device is off.");
        }
    }
}
