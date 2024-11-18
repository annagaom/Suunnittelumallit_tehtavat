package Bridge.device;

public class SmartTV implements Device {
    private boolean on = false;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    // New functionality for SmartTV
    public void browseInternet() {
        if (on) {
            System.out.println("Browsing the internet on SmartTV...");
        } else {
            System.out.println("Cannot browse. The SmartTV is off.");
        }
    }

}
