package GameTestCase;

import PublicMethod.WebDriverUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoldModeRechangeRecord {

    private WebDriver driver;

    @Test(enabled = false)
    public void GoldAgentrechangeRecord() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore();
        driverUtil.adminlogin("xiaochaoadmin","123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_subdivision\"]/span");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_bind_name_list\"]/li/span");
            Thread.sleep(3000);


        driverUtil.findElementByXpathAndClick("//*[@id=\"button6794698337\"]/span");
        //driverUtil.findElementByLinktestAndClick("重置");



    }
}
