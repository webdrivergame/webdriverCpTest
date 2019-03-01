package InbetCashAgentTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CashAgentreChangeRecord {

        private WebDriver driver;


        @Feature("现金代理充值记录")
        @Story("验证现金代理是否给玩家充值成功")

        @Test(enabled = false)
        public void CashAgentreChange() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://xjtg66.com:9091/#/login");
            driverUtil.adminlogin("ddddd","123456");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw_cash\"]/li/span");
                Thread.sleep(2000);

            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div/form/div[2]/div/div/div/input","b37229");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div/form/div[4]/div/div/div/div/input","100");
            driverUtil.findElementByTextAndClick("充值");
            //driverUtil.findElementByXpathAndClick("//*[@id=\"button5629035464\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"button1551142019\"]/span");//充值
                Thread.sleep(4000);


            //跳转充值记录页面断言是否产生记录
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"el-collapse-content-4535\"]/div/form/div/div[1]/div/div[1]/div[1]/div/div/input","b37229");
            driverUtil.findElementByXpathAndClick("//*[@id=\"button6859061196\"]/span");

            String rechangeMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div");

                Assertion.setFlag(true);
                Assertion.verifyEquals(rechangeMoney,"100.00");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();


        }



}
