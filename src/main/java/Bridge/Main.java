package Bridge;


import Bridge.device.*;
import Bridge.Remote.*;

public class Main {
    public static void main(String[] args) {
        Device smartTV = new SmartTV();
        SmartRemote smartRemote = new SmartRemote(smartTV);

        System.out.println("Testing SmartRemote with SmartTV:");
        smartRemote.power(); // Turn on SmartTV
        smartRemote.voiceControl("Open YouTube");
        ((SmartTV) smartTV).browseInternet();
        smartRemote.power(); // Turn off SmartTV

    }
}