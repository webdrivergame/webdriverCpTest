package InbetGoldAgentTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class GoldAgentHomeTestCase {

    private WebDriver driver;

    @Feature("无限金币代理首页")
    @Title("验证无限金币代理首页账户余额与跳转金额是否一致")

    @Test(enabled = false)
    public void GoldAgentHome() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://wxjb66.com:9091/#/login");
        driverUtil.adminlogin("wxjbdl","123456");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        String AccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String AccountBalanceJump =driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div[1]/li/span[2]");
            Thread.sleep(2000);

            Assertion.setFlag(true);
            Assertion.verifyEquals(AccountBalance,AccountBalanceJump);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }


    @Feature("无限金币代理首页")
    @Title("验证无限金币代理首页玩家总欠款与跳转金额是否一致")

    @Test(enabled = false)
    public void PlayerArrearsTotal() throws InterruptedException {

        WebDriverUtil driverUtil1 = new WebDriverUtil(driver);
        driverUtil1.LoginBefore("http://wxjb66.com:9091/#/login");
        driverUtil1.adminlogin("wxjbdl","123456");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(2000);

        String PlayerArrearsTotal = driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
            Thread.sleep(2000);
        String PlayerArrearsJump = driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[1]/h4/span/i");

            Assertion.setFlag(true);
            Assertion.verifyEquals(PlayerArrearsTotal,PlayerArrearsJump);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil1.LoginAfter();
    }

}
