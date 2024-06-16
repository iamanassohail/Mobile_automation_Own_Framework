package pageobject;

import general.BaseTest;
import general.CommonFunctions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;;
import general.CommonFunctions.*;

import java.time.Duration;
import java.util.List;

public class Scn1 extends BaseTest {

    public static void scenario1Test() throws InterruptedException {
        // Navigate to the required section (assuming it's a button click)
        WebElement wrapOption = (WebElement) driver.findElement(By.id("65e5cdd0-2c27-43fc-93b7-7034fd37ba52")); // Replace with actual ID
        wrapOption.click();

        // Select Nigeria by scrolling
        CommonFunctions.scrollToElement("Nigeria");

        // Drag Nigeria to the top
        WebElement nigeriaElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Nigeria\")"
        ));
        CommonFunctions.dragAndDrop(nigeriaElement, 0);

        // Remove Afghanistan by swiping left
        WebElement afghanistanElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Afghanistan\")"
        ));
        CommonFunctions.swipeLeft(afghanistanElement);

        // Assertions
        List<WebElement> items = driver.findElements(By.id("b7fc9ba7-6ff6-4168-8ba9-01b40f818de4")); // Replace with actual item ID
        Assert.assertEquals(items.get(0).getText(), "Nigeria");
        boolean isAfghanistanPresent = items.stream().anyMatch(item -> item.getText().equals("Afghanistan"));
        Assert.assertFalse(isAfghanistanPresent);
    }

}
