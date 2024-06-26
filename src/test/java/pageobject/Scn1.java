package pageobject;

import general.BaseTest;
import general.CommonFunctions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class Scn1 extends BaseTest {

    public static void scenario1Test() throws InterruptedException {
        WebElement wrapOption = (WebElement) driver.findElement(By.id("65e5cdd0-2c27-43fc-93b7-7034fd37ba52"));
        wrapOption.click();

        CommonFunctions.scrollToElement("Nigeria");

        WebElement nigeriaElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Nigeria\")"
        ));
        CommonFunctions.dragAndDrop(nigeriaElement, 0);

        WebElement afghanistanElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Afghanistan\")"
        ));
        CommonFunctions.swipeLeft(afghanistanElement);

        List<WebElement> items = driver.findElements(By.id("b7fc9ba7-6ff6-4168-8ba9-01b40f818de4"));
        Assert.assertEquals(items.get(0).getText(), "Nigeria");
        boolean isAfghanistanPresent = items.stream().anyMatch(item -> item.getText().equals("Afghanistan"));
        Assert.assertFalse(isAfghanistanPresent);
    }

}
