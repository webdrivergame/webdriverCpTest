package InbetCashAgentTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class AgentHomeTestCase {

    private WebDriver driver;

    @Feature("代理首页")
    @Title("验证今日收入与跳转金额是否一致")

    @Test(enabled = false)
    public void homeIncomeToday() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("https://koudai.oneonewan.com/#/login");
        driverUtil.adminlogin("44444","123456");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

            //判断今日收入金额与跳转金额是否一致
        String incomeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String incomeTodayJump = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/ul/li[9]");
            Thread.sleep(2000);

            Assertion.setFlag(true);
            Assertion.verifyEquals(incomeToday,incomeTodayJump);
            Assert.assertTrue(Assertion.currentFlag());


        driverUtil.LoginAfter();
    }

    @Feature("代理首页")
    @Story("待结算佣金与跳转金额是否一致")

    @Test(enabled = false)
    public void homeWaitSettlementMoney() throws InterruptedException {

        WebDriverUtil driverUtil1 = new WebDriverUtil(driver);
        driverUtil1.LoginBefore("https://koudai.oneonewan.com/#/login");
        driverUtil1.adminlogin("44444","123456");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

            //判断待结算佣金与跳转金额是否一致
        String WaitSettlementMoney = driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String WaitSettlementMoneyJump =driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div[1]/li/span[2]");
            Thread.sleep(2000);

        Assertion.setFlag(true);
        Assertion.verifyEquals(WaitSettlementMoney,WaitSettlementMoneyJump);
        Assert.assertTrue(Assertion.currentFlag());


        driverUtil1.LoginAfter();

    }

}
