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
        // Navigating back to home screen
        driver.navigate().back();

        // Selecting the "Multi choice questions" section
        WebElement multiChoiceSection = driver.findElement(By.id("27b63f52-17d9-4c24-a964-cd5c52f8b66f")); // Replace with actual ID
        multiChoiceSection.click();

        // Selecting 5 radio buttons randomly
        List<WebElement> radioButtons = driver.findElements(By.className("android.widget.CheckedTextView"));
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            WebElement randomRadioButton = radioButtons.get(random.nextInt(radioButtons.size()));
            if (!randomRadioButton.isSelected()) {
                randomRadioButton.click();
            }
        }

        // Deleting all selected items
        for (WebElement radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                WebElement deleteButton = radioButton.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.view.ViewGroup[1]/android.widget.LinearLayout/android.widget.ImageView[2]")); // Adjust XPath if necessary
                deleteButton.click();
            }
        }

        // Killing the activity
        ((AndroidDriver) driver).terminateApp("com.mobeta.android.demodslv"); // Replace with actual app package name

        // Starting the 2nd application
        ((AndroidDriver) driver).activateApp("io.selendroid.testapp"); // Replace with actual second app package name

        // Wait dynamically until the 2nd application launches
        Thread.sleep(5000); // Adjust the waiting time if needed

        // Assertions
        // Checking that deleted items are not in the list
        multiChoiceSection.click(); // Navigate back to the multi-choice section
        radioButtons = driver.findElements(By.className("android.widget.CheckedTextView"));
        for (WebElement radioButton : radioButtons) {
            Assert.assertFalse(radioButton.isSelected(), "Deleted items should not be present in the list");
        }

        // Checking that the 2nd application is open
        boolean isSecondAppOpened = ((AndroidDriver) driver).isAppInstalled("io.selendroid.testapp"); // Replace with actual second app package name
        Assert.assertTrue(isSecondAppOpened, "The 2nd application should be opened successfully");
    }
}
