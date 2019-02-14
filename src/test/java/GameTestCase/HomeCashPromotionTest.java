package GameTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Title;


public class HomeCashPromotionTest {

    private WebDriver driver;




    @Feature("平台首页")
    @Story("现金推广")
    @Title("今日系统盈亏")
    @Test(priority = 1)
    public void TodaySystemWinOrLose() throws InterruptedException {
        WebDriverUtil driverUtil1 = new WebDriverUtil(driver);
        driverUtil1.LoginBefore();
        driverUtil1.adminlogin("xiaochaoadmin", "123123");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);

        //判断首页现金今日系统盈亏金额与跳转玩家输赢总计金额是否一致
        String TodaySystemWinOrLose = driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil1.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String TodaySystemWinOrLoseJump = driverUtil1.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div/div/div[2]/div[1]/div[4]/li/span[2]");
            Assertion.setFlag(true);
            Assertion.verifyEquals(TodaySystemWinOrLose,TodaySystemWinOrLoseJump);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil1.LoginAfter();
    }


    @Title("今日产生佣金")
    @Test(priority = 2)
    public void TodayGenerateCommission() throws InterruptedException {
        WebDriverUtil driverUtil3 = new WebDriverUtil(driver);
        driverUtil3.LoginBefore();
        driverUtil3.adminlogin("xiaochaoadmin","123123");
        driverUtil3.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);

        //判断首页今日产生佣金金额与跳转下级佣金统计页面今日佣金统计字段金额是否一致
        String TodayGenerateCommission = driverUtil3.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil3.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[2]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        String TodayGenerateCommissionjump = driverUtil3.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[3]/span[2]");
            Assertion.setFlag(true);
            Assertion.verifyEquals(TodayGenerateCommission,TodayGenerateCommissionjump);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil3.LoginAfter();
    }

}
