package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;




public class test {

    WebDriverUtil driverUtil = new WebDriverUtil(null);
    WebDriverUtil driverUtil2 = new WebDriverUtil(null);

    String Url2 = "http://10.1.101.121:8703/?#/login?redirect=%2F";
    String login1 = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";


    String Url1 = "https://zs05.com/";
    String code = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/span";
    String inputCode = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/input";
    String login2 = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/span[1]";
    String sure = "//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[2]/span";
    String goGame = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[4]/span[2]";
    String clickAgree = "//*[@id=\"app\"]/div/div/div/div[3]/div/p[1]";
    String clickCloseAnnouncement = "//*[@id=\"app\"]/div/div[2]/div[1]/div[3]/div/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(Url2);
        driverUtil.adminLogin("achao","123123");
        driverUtil.xpathClick(login1);
        Thread.sleep(2000);

        driverUtil.openUrl(Url1);
        //driverUtil.switchToWindow("钻石彩票");
        driverUtil.playerLogin("achaohy1","achaohy1");
        String getCode = driverUtil.getTextByXpath(code);
        System.out.println(getCode);
        driverUtil.xpathClearSendKeys(inputCode,getCode);
        driverUtil.xpathClick(login2);
        driverUtil.xpathClick(sure);
        Thread.sleep(1000);
        driverUtil.xpathClick(goGame);
        driverUtil.xpathClick(clickAgree);
        Thread.sleep(3000);
        driverUtil.xpathClick(clickCloseAnnouncement);
        Thread.sleep(2000);

    }

    String userAccount = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/div/span";
    String user = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/ul/div[3]/a/li/span";
    String click = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/button/span";
    String sure2 = "//*[@id=\"app\"]/div/div[2]/section/div/div[3]/div/div[3]/div/button[2]/span";
    String alert = "/html/body/div[2]/p";

    @Test
    public void getTest() throws InterruptedException {
        driverUtil.switchToWindow("后台管理系统");
        driverUtil.xpathClick(userAccount);
        driverUtil.xpathClick(user);
        Thread.sleep(2000);
        driverUtil.xpathClick(click);
        driverUtil.xpathClick(sure2);
        driverUtil.waitForElement(alert,3);
        String getAlert = driverUtil.getTextByXpath(alert);
        System.out.println("弹出信息："+getAlert);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getAlert,"修改成功！");
        Assert.assertTrue(Assertion.currentFlag());


    }

}
