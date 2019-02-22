package InbetCashBusinessTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class BusinessHomeTestCase {

    private WebDriver driver;

    @Feature("现金商户首页")
    @Title("今日收入")
    @Test(priority = 1)
    public void businessHome() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://xjtg66.com:9091/#/login");
        driverUtil.adminlogin("xjtg66","123456");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        String IncomeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String IncomeTodayJump = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[1]/div/div/div/div[1]/ul/li[9]");
            Thread.sleep(2000);

        Assertion.setFlag(true);
        Assertion.verifyEquals(IncomeToday,IncomeTodayJump);
        Assert.assertTrue(Assertion.currentFlag());


        driverUtil.LoginAfter();
    }

    @Feature("现金商户首页")
    @Story("待结算佣金")
    @Test(priority = 2)
    public void waitSettlementMoney() throws InterruptedException {

        WebDriverUtil driverUtil2 = new WebDriverUtil(driver);
        driverUtil2.LoginBefore("http://xjtg66.com:9091/#/login");
        driverUtil2.adminlogin("xjtg66","123456");
        driverUtil2.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        String WaitSettlementMoney = driverUtil2.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil2.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String WaitSettlementMoneyjump = driverUtil2.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div");
            Thread.sleep(2000);

        Assertion.setFlag(true);
        Assert.assertTrue(Assertion.currentFlag());
        Assertion.verifyEquals(WaitSettlementMoney,WaitSettlementMoneyjump);

        driverUtil2.LoginAfter();
    }


}
