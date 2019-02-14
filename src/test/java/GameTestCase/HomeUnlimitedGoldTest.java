package GameTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.yandex.qatools.allure.annotations.Title;


public class HomeUnlimitedGoldTest {

    private WebDriver driver;
    private SoftAssert softAssert = new SoftAssert();
    @Feature("平台首页")
    @Story("无限金币")
    @Title("今日服务费收入")
    @Test(priority = 1)
    private void ServiceFeeIncome() throws InterruptedException {
        WebDriverUtil driverUtil2 = new WebDriverUtil(driver);
        driverUtil2.LoginBefore();
        driverUtil2.adminlogin("xiaochaoadmin", "123123");
        driverUtil2.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);



        //判断首页无限金币今日服务费收入和跳转金额是否一致
        String ServiceFeeIncomeToday = driverUtil2.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil2.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String ServiceFeeIncomeTodayJump = driverUtil2.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[3]/span[2]");
            Assertion.setFlag(true);
            Assertion.verifyEquals(ServiceFeeIncomeToday,ServiceFeeIncomeTodayJump);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil2.LoginAfter();
    }

    @Title("自运营商户欠款总计")
    @Test(priority = 2)
    public void SinceBusinessOperationsTotalArrears() throws InterruptedException {
        WebDriverUtil driverUtil4 = new WebDriverUtil(driver);
        driverUtil4.LoginBefore();
        driverUtil4.adminlogin("xiaochaoadmin","123123");
        driverUtil4.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);


        //判断无限金币自运营商户欠款总计与跳转金额是否一致
        String SinceBusinessOperationsTotalArrears = driverUtil4.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil4.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        Thread.sleep(3000);
        driverUtil4.refreshpage();
        String SinceBusinessOperationsTotalArrearsJump = driverUtil4.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/li/span[2]");
            Assertion.setFlag(true);
            Assertion.verifyEquals(SinceBusinessOperationsTotalArrears,SinceBusinessOperationsTotalArrearsJump);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil4.LoginAfter();
    }
}