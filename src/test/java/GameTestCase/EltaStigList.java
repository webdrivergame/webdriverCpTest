package GameTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EltaStigList {

    private WebDriver driver;

    @Test(enabled = false)
    public void EltaStigList() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore();
        driverUtil.adminlogin("xiaochaoadmin","123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw\"]/span");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_feeze_recharge_list\"]/li/span");
        //进入追分列表
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"el-collapse-content-5585\"]/div/form/div[1]/div/div/div/div/input");
        driverUtil.findElementByXpathAndClick("/html/body/div[3]/div[1]/div[1]/ul/li[1]/span");
        driverUtil.findElementByXpathAndClick("//*[@id=\"button9727434129\"]/span");//已同意

        String AgreeList = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[8]/div/span");
        String AgreeList2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[8]/div/span");

            Assertion.setFlag(true);
            Assertion.verifyEquals(AgreeList,"已同意");
            Assert.assertTrue(Assertion.currentFlag());
            Assertion.setFlag(true);
            Assertion.verifyEquals(AgreeList2,"已同意");
            Assert.assertTrue(Assertion.currentFlag());
            Thread.sleep(3000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"el-collapse-content-5585\"]/div/form/div[2]/div/div/input","ddddd");
        driverUtil.findElementByXpathAndClick("//*[@id=\"button9494498321\"]/span[1]");

        String PlayercountNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[1]/div");
        String PlayercountNumber2= driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[1]/div");

            Assertion.setFlag(true);
            Assertion.verifyEquals(PlayercountNumber,"ddddd");
            Assert.assertTrue(Assertion.currentFlag());
            Assertion.setFlag(true);
            Assertion.verifyEquals(PlayercountNumber2,"ddddd");
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }
}
