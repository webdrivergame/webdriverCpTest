package InbetCashAgentTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import static ListenerPackage.Assertion.setFlag;

public class AgentPlayerAccountNumberTestCase {

        private WebDriver driver;

        @Feature("代理玩家账号管理")
        @Title("验证玩家账号搜索")

        @Test
        public void playerAccountNumber() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://xjtg66.com:9091/?#/login");
            driverUtil.adminlogin("ddddd","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");

            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","b57609");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
                try {
                        String playerAccountNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerAccountNumber,"b57609");
                        Assert.assertTrue(Assertion.currentFlag());

                }catch (Exception e){
                        System.out.println("未找到该玩家账号");
                }finally {
                        driverUtil.LoginAfter();
                }


        }

        @Feature("代理玩家账号管理")
        @Title("验证玩家昵称搜索")

        @Test
        public void playerNickname() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://xjtg66.com:9091/?#/login");
            driverUtil.adminlogin("ddddd","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");

            driverUtil.findElementByXpathAndClearSendkeys("","");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");


        }



}
