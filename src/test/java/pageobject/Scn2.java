package pageobject;

import general.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

public class Scn2 extends BaseTest {

    public static void scenario2Test() throws InterruptedException {
        driver.navigate().back();

        WebElement multiChoiceSection = driver.findElement(By.id("27b63f52-17d9-4c24-a964-cd5c52f8b66f")); // Replace with actual ID
        multiChoiceSection.click();

        List<WebElement> radioButtons = driver.findElements(By.className("android.widget.CheckedTextView"));
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            WebElement randomRadioButton = radioButtons.get(random.nextInt(radioButtons.size()));
            if (!randomRadioButton.isSelected()) {
                randomRadioButton.click();
            }
        }

        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                WebElement deleteButton = radioButton.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.ImageView[2]")); // Adjust XPath if necessary
                deleteButton.click();
            }
        }

        ((AndroidDriver) driver).terminateApp("com.mobeta.android.demodslv");

        ((AndroidDriver) driver).activateApp("io.selendroid.testapp");

        Thread.sleep(5000);

        multiChoiceSection.click();
        radioButtons = driver.findElements(By.className("android.widget.CheckedTextView"));
        for (WebElement radioButton : radioButtons) {
            Assert.assertFalse(radioButton.isSelected(), "Deleted items should not be present in the list");
        }

        boolean isSecondAppOpened = ((AndroidDriver) driver).isAppInstalled("io.selendroid.testapp");
        Assert.assertTrue(isSecondAppOpened, "The 2nd application should be opened successfully");
    }
}
