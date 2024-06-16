package testcases;

import general.BaseTest;
import org.testng.annotations.Test;
import pageobject.Scn1;

public class Scn1Test extends BaseTest {
    @Test
    public void Test_1() throws InterruptedException {
        Scn1.scenario1Test();
    }

}
