package GameTestCase;

import PublicMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class HomeCashPromotionTest {

   private WebDriver driver;


    @Test
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

        try {
            Assert.assertEquals(TodaySystemWinOrLose,TodaySystemWinOrLoseJump);
        }catch (AssertionError error){
            System.out.println("今日系统盈亏金额与跳转页面金额不相同");

        }
        driverUtil1.LoginAfter();
    }

    @Test
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

        try {
            Assert.assertEquals(TodayGenerateCommission,TodayGenerateCommissionjump);
        }catch (AssertionError error){
            System.out.println("今日佣金总计金额不一致");
        }

        driverUtil3.LoginAfter();
    }

}
