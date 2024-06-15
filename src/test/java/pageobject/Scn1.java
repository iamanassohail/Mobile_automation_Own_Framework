package pageobject;

import general.BaseTest;
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

import java.time.Duration;
import java.util.List;

public class Scn1 extends BaseTest {

    @Test
    public void scenario1Test() throws InterruptedException {
        // Navigate to the required section (assuming it's a button click)
        WebElement wrapOption = (WebElement) driver.findElement(By.id("65e5cdd0-2c27-43fc-93b7-7034fd37ba52")); // Replace with actual ID
        wrapOption.click();

        // Select Nigeria by scrolling
        scrollToElement("Nigeria");

        // Drag Nigeria to the top
        WebElement nigeriaElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Nigeria\")"
        ));
        dragAndDrop(nigeriaElement, 0);

        // Remove Afghanistan by swiping left
        WebElement afghanistanElement = (WebElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiSelector().text(\"Afghanistan\")"
        ));
        swipeLeft(afghanistanElement);

        // Assertions
        List<WebElement> items = driver.findElements(By.id("b7fc9ba7-6ff6-4168-8ba9-01b40f818de4")); // Replace with actual item ID
        Assert.assertEquals(items.get(0).getText(), "Nigeria");
        boolean isAfghanistanPresent = items.stream().anyMatch(item -> item.getText().equals("Afghanistan"));
        Assert.assertFalse(isAfghanistanPresent);
    }

    private void scrollToElement(String elementText) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"
        ));
    }

    private void dragAndDrop(WebElement source, int targetIndex) {
        Dimension dimension = driver.manage().window().getSize();
        int x = (int) (dimension.width * 0.5);
        int startY = source.getLocation().getY();
        int endY = targetIndex * source.getSize().getHeight();

        Actions actions = new Actions(driver);
        actions.clickAndHold(source)
                .moveByOffset(0, endY - startY)
                .release()
                .perform();
    }

    private void swipeLeft(WebElement element) {
        int startX = element.getLocation().getX() + element.getSize().getWidth() - 10;
        int endX = element.getLocation().getX() + 10;
        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;

        Actions actions = new Actions(driver);
        actions.moveToElement(element)
                .clickAndHold()
                .moveByOffset(endX - startX, 0)
                .release()
                .perform();
    }

//    private void dragAndDrop(WebElement source, int targetIndex) {
//        Dimension dimension = driver.manage().window().getSize();
//        int x = (int) (dimension.width * 0.5);
//        int startY = source.getLocation().getY();
//        int endY = targetIndex * source.getSize().getHeight();
//
//        TouchAction action = new TouchAction(driver);
//        action.longPress(ElementOption.element(source))
//                .moveTo(ElementOption.point(x, endY))
//                .release()
//                .perform();
//    }
//
//    private void swipeLeft(WebElement element) {
//        int startX = element.getLocation().getX() + element.getSize().getWidth() - 10;
//        int endX = element.getLocation().getX() + 10;
//        int y = element.getLocation().getY() + element.getSize().getHeight() / 2;
//
//        TouchAction action = new TouchAction(driver);
//        action.press(ElementOption.point(startX, y))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
//                .moveTo(ElementOption.point(endX, y))
//                .release()
//                .perform();
//    }
}
