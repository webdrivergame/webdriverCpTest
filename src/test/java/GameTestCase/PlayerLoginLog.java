package GameTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerLoginLog {

    private WebDriver driver;

    @Test(enabled = false)
    public void PlayerLoginLog() throws InterruptedException {

        WebDriverUtil driverUtil11 = new WebDriverUtil(driver);
        driverUtil11.LoginBefore();
        driverUtil11.adminlogin("xiaochaoadmin","123123");
        driverUtil11.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        driverUtil11.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil11.findElementByXpathAndClick("//*[@id=\"rest_system_safety_front_login_log\"]/li/span");
            Thread.sleep(3000);//进入玩家登录日志
        driverUtil11.findElementByXpathAndClearSendkeys("//*[@id=\"el-collapse-content-3570\"]/div/form/div[2]/div/div/input","b455576");
        driverUtil11.findElementByXpathAndClick("//*[@id=\"el-collapse-content-3510\"]/div/form/div[3]/div/div/div/input");
        driverUtil11.findElementByXpathAndClick("/html/body/div[5]/div[1]/div[1]/ul/li[1]/span");
        driverUtil11.findElementByXpathAndClick("//*[@id=\"button1656237323\"]/span[1]");
            Thread.sleep(2000);

        String UserName = driverUtil11.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr/td[2]/div");
        String Login = driverUtil11.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr/td[4]/div");
        String LoginIp = driverUtil11.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/table/tbody/tr/td[5]/div");

            Assertion.verifyEquals(UserName,"b455576");
            Assertion.verifyEquals(Login,"登录");
            Assertion.verifyEquals(LoginIp,"192.168.1.225");

        driverUtil11.LoginAfter();
    }

    /***
     * 问题：找不到元素
     *
     */



}
