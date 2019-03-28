package creditAgentTestCase;

import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import java.text.SimpleDateFormat;
import java.util.Date;

public class creditAgentPlayerTestCase {

        private WebDriver driver;

        @Feature("玩家账号管理")
        @Title("验证信用代理新增玩家功能")
        @Test(priority = 1)
        public void newPlayer() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                        Thread.sleep(2000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd ");//设置日期格式
                Date now = new Date();
                String playerDate = dateFormat.format(now).substring(0,8);//去掉时间后的空格
                System.out.println("获取时间的玩家："+playerDate);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/button[1]/span");
                driverUtil.findElementByXpathAndClearSendkeys("/html/body/div[4]/div/div[2]/div/div[1]/form/div[1]/div/div/div/div/input",playerDate);
                driverUtil.findElementByXpathAndClearSendkeys("/html/body/div[4]/div/div[2]/div/div[1]/form/div[2]/div/div/div/div[1]/input",playerDate);
                driverUtil.findElementByXpathAndClearSendkeys("/html/body/div[4]/div/div[2]/div/div[1]/form/div[3]/div/div/div/div/input","123123");
                driverUtil.findElementByXpathAndClearSendkeys("/html/body/div[4]/div/div[2]/div/div[1]/form/div[4]/div/div/div/div/input","123123");
                driverUtil.findElementByXpathAndClick("/html/body/div[4]/div/div[3]/div/button[2]/span");
                        Thread.sleep(2000);
                String player = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr[1]/td[1]/div/a");
                System.out.println("玩家账号："+player);
                Assertion.setFlag(true);
                Assertion.verifyEquals(player,playerDate);//第二个是期望值
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
                }

}
