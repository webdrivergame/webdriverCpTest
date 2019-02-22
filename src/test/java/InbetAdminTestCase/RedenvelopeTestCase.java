package InbetAdminTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RedenvelopeTestCase {

    private WebDriver driver;

    @Feature("平台首页")
    @Story("红包管理")
    @Title("验证发红包功能")
    @Test
    public void Redenvelope() throws InterruptedException, AWTException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091");
        driverUtil.adminlogin("xiaochaoadmin","123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入红包
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","红包管理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_red_envelope_history_list\"]/li/span");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/button/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[3]/div/div/input","ddddd");
        driverUtil.waitForEnabledByXpathAndClick("//*[@id=\"submit\"]/span");//查询
        //driverUtil.findElementByXpath("//*[@id=\"submit\"]/span").sendKeys(Keys.ENTER);
            Thread.sleep(2000);

        //搜索输入参数验证发送总人数与发送总金额是否一致
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[1]/label[1]/span[1]/span");
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[2]/div[3]/div/div/div/input","1");

        String totalPeople = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[2]/div[1]/i");
        String totalMoney  = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[2]/div[2]/i[2]");

            Assertion.setFlag(true);
            Assertion.verifyEquals(totalPeople,totalMoney);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[2]/div[4]/div/div/div/textarea","selenium自动测试");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[4]/div[2]/div[5]/button/span");
        driverUtil.findElementByXpathAndClick("/html/body/div[5]/div/div[3]/button[2]/span");

        driverUtil.LoginAfter();
    }

}
