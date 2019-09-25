package CPBet;

import SeleniumMethod.WebDriverUtil;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RechargeWithdrawal {
    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String Url = "http://10.1.101.102:8704/alogin";
    String login = "//*[@id=\"app\"]/div/div/div[2]/div[3]/div";
    String clickAgree = "//*[@id=\"app\"]/div/div/div/div[3]/div/p[1]";
    String clickCloseAnnouncement = "//*[@id=\"app\"]/div/div[2]/div[1]/div[3]/div/span";


    @BeforeTest
    public void login() throws InterruptedException {
        driverUtil.loginBefore(Url);
        driverUtil.adminLogin("achaohy","achaohy");
        driverUtil.findElementByXpathAndClick(login);
        Thread.sleep(2000);
        driverUtil.findElementByXpath(clickAgree);
        Thread.sleep(2000);
        driverUtil.findElementByXpath(clickCloseAnnouncement);
    }

    String Recharge = "//*[@id=\"app\"]/div/div[1]/div/div[2]/div/ul/li[2]/div[1]/span";

    @Test
    public void Recharge(){
        driverUtil.findElementByXpath(Recharge);
        driverUtil.scrollToBottom();


    }

    @AfterTest
    public void close(){
        driverUtil.closeCurrentBrowser();


    }

}
