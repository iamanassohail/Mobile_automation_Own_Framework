package general;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonFunctions extends BaseTest{

    public static void scrollToElement(String elementText) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementText + "\"));"
        ));
    }

    public static void dragAndDrop(WebElement source, int targetIndex) {
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

    public static void swipeLeft(WebElement element) {
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
}
