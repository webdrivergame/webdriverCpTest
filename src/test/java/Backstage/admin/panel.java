package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class panel {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.121:8703/?#/login?redirect=%2F";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
        public void loginBefore() throws InterruptedException {
            driverUtil.loginBefore(URL);
            driverUtil.adminLogin("achao", "123123");
            driverUtil.xpathClick(login);
            Thread.sleep(2000);

    }

    String panel = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[1]/a/li/span";
    String playerNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div/div/div[1]/div/div/div[2]/div[2]/span[2]";
    String userManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String playerNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("仪表盘")
    @Stories("会员数量")
    @Title("验证平台总会员数是否有误")
    @Test(priority = 1)
        public void playerNumber() throws InterruptedException {
            driverUtil.xpathClick(panel);
            String getPlayerNumber = driverUtil.getTextByXpath(playerNumber);
            driverUtil.xpathClick(userManagement);
            driverUtil.xpathClick(vip);
            Thread.sleep(2000);
            String getPlayerNumberPage = driverUtil.getTextByXpath(playerNumberPage);
            String a1 = getPlayerNumberPage.substring(1,getPlayerNumberPage.indexOf("条"));
            System.out.println("仪表盘会员数："+getPlayerNumber);
            System.out.println("会员列表会员数："+getPlayerNumberPage);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getPlayerNumber,a1);
            Assert.assertTrue(Assertion.currentFlag());

        }

    String clickNotesNumber = "//*[@id=\"tab-2\"]";
    String totalNotes = "//*[@id=\"app\"]/div/div[2]/section/div/div/div/div[1]/div/div/div[2]/div[2]/span[2]";
    String betRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/div/span";
    String historyBet = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/ul/div[2]/a/li/span";
    String clickTime = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/div[2]/i[2]";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[7]/div/button[1]/span";
    String notesPage = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div[1]";


    @Features("仪表盘")
    @Stories("平台总注单量")
    @Title("验证平台总注单量是否有误")
    @Test(priority = 2)
        public void notesNumber() throws InterruptedException {
            driverUtil.xpathClick(panel);
            driverUtil.xpathClick(clickNotesNumber);
            String getTotalNotes = driverUtil.getTextByXpath(totalNotes);
            driverUtil.xpathClick(betRecord);
            driverUtil.xpathClick(historyBet);
            Thread.sleep(1000);
            driverUtil.xpathClick(clickTime);
            driverUtil.xpathClick(inquire);
            Thread.sleep(2000);
            String getNotesPage = driverUtil.getTextByXpath(notesPage);
            String getNotesPage1 = getNotesPage.substring(1,getNotesPage.indexOf("条"));
            Assertion.setFlag(true);
            Assertion.verifyEquals(getTotalNotes,getNotesPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }

}
