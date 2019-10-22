package CPBet;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;

public class cycleRacingCar {
    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String Url = "https://zs05.com/";
    String code = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/span";
    String inputCode = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/p/input";
    String login = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/span[1]";
    String sure = "//*[@id=\"app\"]/div/div[1]/div[2]/div[2]/div[2]/span";
    String goGame = "//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[4]/span[2]";
    String clickAgree = "//*[@id=\"app\"]/div/div/div/div[3]/div/p[1]";
    String clickCloseAnnouncement = "//*[@id=\"app\"]/div/div[2]/div[1]/div[3]/div/span";


    @BeforeTest
    public void login() throws InterruptedException {
        driverUtil.loginBefore(Url);
        driverUtil.playerLogin("achaohy1","achaohy1");
        String getCode = driverUtil.getTextByXpath(code);
        System.out.println(getCode);
        driverUtil.xpathClearSendKeys(inputCode,getCode);
        driverUtil.xpathClick(login);
        driverUtil.xpathClick(sure);
        Thread.sleep(1000);
        driverUtil.xpathClick(goGame);
        driverUtil.xpathClick(clickAgree);
        Thread.sleep(3000);
        driverUtil.xpathClick(clickCloseAnnouncement);
        Thread.sleep(2000);
    }

    String car = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[1]/span[2]";
    String beijingCar = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[3]/span[1]";
    String beijingCarIssue1 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[2]/p/span/i";
    String beijingCarIssue2 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[3]/p/span/i";

    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖期数是否跳期")
    @Test(priority = 1)
    public void issue(){
        driverUtil.xpathClick(car);
        driverUtil.xpathClick(beijingCar);
        String getBeijingCarIssue1 = driverUtil.getTextByXpath(beijingCarIssue1);
        String getBeijingCarIssue2 = driverUtil.getTextByXpath(beijingCarIssue2);
        if (getBeijingCarIssue2.equals("已封盘")){
            System.out.println("已封盘");

        }else {
            BigDecimal a1 = new BigDecimal(getBeijingCarIssue1);
            BigDecimal a2 = new BigDecimal(getBeijingCarIssue2);
            System.out.println("当期已开奖期数："+getBeijingCarIssue1);
            System.out.println("下期待开奖期数："+getBeijingCarIssue2);
            BigDecimal result = a2.subtract(a1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result.intValue(),"1");
            Assert.assertTrue(Assertion.currentFlag());

        }


    }

    String lotteryTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[3]/span";
    String nextIssueTime = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div[4]/div/div[1]/div[4]/span";


    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖封盘时间是否低于下期开奖时间")
    @Test(priority = 2)
    public void openLotteryTime() {
        String getLotteryTime = driverUtil.getTextByXpath(lotteryTime).substring(0, 5);//截取时间前五位
        String getNextIssueTime = driverUtil.getTextByXpath(nextIssueTime).substring(0, 5);
        BigDecimal getLotteryTime1 = StringToNumber.colonBigDecimal(getLotteryTime);
        BigDecimal getNextIssueTime1 = StringToNumber.colonBigDecimal(getNextIssueTime);
        System.out.println("封盘截取时间："+getLotteryTime1);
        System.out.println("开奖截取时间："+getNextIssueTime1);
        if (getLotteryTime.equals("已封盘")) {
          System.out.println("已封盘");

        } else {
            int resultIssueTimeCompare2 = getLotteryTime1.compareTo(getNextIssueTime1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(resultIssueTimeCompare2, -1);
            Assert.assertTrue(Assertion.currentFlag());
        }


    }


    String lotteryResult = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/div[1]/span[3]";

    String lottery1 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[1]/td[1]";
    String lottery2 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[2]/td[1]";
    String lottery3 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[3]/td[1]";
    String lottery4 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[4]/td[1]";
    String lottery5 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[5]/td[1]";
    String lottery6 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[6]/td[1]";
    String lottery7 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[7]/td[1]";
    String lottery8 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[8]/td[1]";
    String lottery9 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[9]/td[1]";
    String lottery10 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[10]/td[1]";
    String lottery11 = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div/div[3]/div[1]/div/table/tbody/tr[11]/td[1]";


    @Features("赛车")
    @Stories("北京赛车")
    @Title("验证开奖结果期数是否少数据")
    @Test(priority = 3)
    public void lotteryResult() throws InterruptedException {
        driverUtil.xpathClick(lotteryResult);
        Thread.sleep(2000);


        BigDecimal b1 = new BigDecimal(driverUtil.getTextByXpath(lottery1));
        BigDecimal b2 = new BigDecimal(driverUtil.getTextByXpath(lottery2));
        BigDecimal b3 = new BigDecimal(driverUtil.getTextByXpath(lottery3));
        BigDecimal b4 = new BigDecimal(driverUtil.getTextByXpath(lottery4));
        BigDecimal b5 = new BigDecimal(driverUtil.getTextByXpath(lottery5));
        BigDecimal b6 = new BigDecimal(driverUtil.getTextByXpath(lottery6));
        BigDecimal b7 = new BigDecimal(driverUtil.getTextByXpath(lottery7));
        BigDecimal b8 = new BigDecimal(driverUtil.getTextByXpath(lottery8));
        BigDecimal b9 = new BigDecimal(driverUtil.getTextByXpath(lottery9));
        BigDecimal b10 = new BigDecimal(driverUtil.getTextByXpath(lottery10));
        BigDecimal b11 = new BigDecimal(driverUtil.getTextByXpath(lottery11));


        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(b7);
        System.out.println(b8);
        System.out.println(b9);
        System.out.println(b10);
        System.out.println(b11);


        Assertion.setFlag(true);
        Assertion.verifyEquals(b1.subtract(b2).intValue(),1);
        Assertion.verifyEquals(b2.subtract(b3).intValue(),1);
        Assertion.verifyEquals(b3.subtract(b4).intValue(),1);
        Assertion.verifyEquals(b4.subtract(b5).intValue(),1);
        Assertion.verifyEquals(b5.subtract(b6).intValue(),1);
        Assertion.verifyEquals(b6.subtract(b7).intValue(),1);
        Assertion.verifyEquals(b7.subtract(b8).intValue(),1);
        Assertion.verifyEquals(b8.subtract(b9).intValue(),1);
        Assertion.verifyEquals(b9.subtract(b10).intValue(),1);
        Assertion.verifyEquals(b10.subtract(b11).intValue(),1);
        Assert.assertTrue(Assertion.currentFlag());






    }


    @AfterTest
    public void close(){
        driverUtil.closeCurrentBrowser();


    }

}
