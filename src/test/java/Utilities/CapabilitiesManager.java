package Utilities;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CapabilitiesManager {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", Platform.ANDROID.name());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel Pro API 30");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/anas.sohail_ventured/Downloads/draganddrop.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("autoGrantPermissions", true);
        return capabilities;
    }

}
