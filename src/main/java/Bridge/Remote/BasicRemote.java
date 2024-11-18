package Bridge.Remote;
import Bridge.device.Device;

public class BasicRemote implements Remote {
    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: power toggle");
        if (device.isEnabled()) {
            device.disable();
            System.out.println("Device is off");
        } else {
            device.enable();
            System.out.println("Device is on");
        }
    }


}