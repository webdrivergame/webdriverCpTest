package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class ReportManagement {

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

    /**
     * -------------------------------------------报表管理-总代理报表-会员数-----------------------------------------
     *
     * */
    String yesterdayAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div[1]/div/div/label[2]/span";
    String inquireAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div[2]/div/button[1]/span";

    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportAgentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[1]/a/li/span";
    String vipNumberToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div";
    String accountAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[1]/div/span";
    String totalVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[2]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理今日会员数")
    @Test(priority = 1)
         public void vipNumberToday() throws InterruptedException {
            driverUtil.xpathClick(reportManagement);
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getVipNumberToday = driverUtil.getTextByXpath(vipNumberToday);
            System.out.println("总代理报表今日会员数："+getVipNumberToday);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getTotalVip = driverUtil.getTextByXpath(totalVip);
            System.out.println("代理报表总会员数："+getTotalVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumberToday,getTotalVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-笔数-----------------------------------------
     *
     * */

    String countTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div";
    String countAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[5]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理今日充值金额")
    @Test(priority = 2)
        public void countTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getCountTotal = driverUtil.getTextByXpath(countTotal);
            System.out.println("总代理下注笔数："+getCountTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getCountAgentTotal = driverUtil.getTextByXpath(countAgentTotal);
            System.out.println("代理报表投注笔数总计："+getCountAgentTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getCountTotal,getCountAgentTotal);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-投注金额-----------------------------------------
     *
     * */

    String betMoneyAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div";
    String betMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[6]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理今日投注金额")
    @Test(priority = 3)
        public void betMoneyAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getBetMoneyAgentTotal = driverUtil.getTextByXpath(betMoneyAgentTotal);
            System.out.println("总代理列表今日投注金额："+getBetMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getBetMoneyAgent = driverUtil.getTextByXpath(betMoneyAgent);
            System.out.println("代理列表今日投注金额："+getBetMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetMoneyAgentTotal,getBetMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
        }



    /**
     * -------------------------------------------报表管理-总代理报表-赢利投注金额-----------------------------------------
     *
     * */

    String winBetMoneyAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[5]/div/span";
    String winBetMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[7]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理今日赢利投注金额")
    @Test(priority = 4)
        public void winBetMoneyAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWinBetMoneyAgentTotal = driverUtil.getTextByXpath(winBetMoneyAgentTotal);
            System.out.println("总代理列表今日赢利投注金额："+getWinBetMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getWinBetMoneyAgent = driverUtil.getTextByXpath(winBetMoneyAgent);
            System.out.println("代理列表今日赢利投注金额："+getWinBetMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinBetMoneyAgentTotal,getWinBetMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-总代理报表-充值优惠/手续费金额-----------------------------------------
     *
     * */

    String serviceChargeAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[7]/div";
    String serviceChargeAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[9]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理充值优惠/服务费金额")
    @Test(priority = 5)
        public void serviceChargeAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getServiceChargeAgentTotal = driverUtil.getTextByXpath(serviceChargeAgentTotal);
            System.out.println("总代理列表今日充值优惠/服务费金额："+getServiceChargeAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getServiceChargeAgent = driverUtil.getTextByXpath(serviceChargeAgent);
            System.out.println("代理列表今日充值优惠/服务费金额："+getServiceChargeAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getServiceChargeAgentTotal,getServiceChargeAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-总代理报表-代理退水金额-----------------------------------------
     *
     * */

    String waterBreakAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div";
    String waterBreakAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[11]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理报表代理退水金额")
    @Test(priority = 6)
        public void waterBreakAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWaterBreakAgentTotal = driverUtil.getTextByXpath(waterBreakAgentTotal);
            System.out.println("总代理列表代理退水金额："+getWaterBreakAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getWaterBreakAgent = driverUtil.getTextByXpath(waterBreakAgent);
            System.out.println("代理列表代理退水金额："+getWaterBreakAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakAgentTotal,getWaterBreakAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-总代理报表-代理赔率金额-----------------------------------------
     *
     * */

    String oddsMoneyAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[8]/div";
    String oddsMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[10]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理报表代理赔率金额")
    @Test(priority = 7)
        public void oddsMoneyAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getOddsMoneyAgentTotal = driverUtil.getTextByXpath(oddsMoneyAgentTotal);
            System.out.println("总代理列表今日代理赔率金额："+getOddsMoneyAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getOddsMoneyAgent = driverUtil.getTextByXpath(oddsMoneyAgent);
            System.out.println("代理列表今日代理赔率金额："+getOddsMoneyAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getOddsMoneyAgentTotal,getOddsMoneyAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-会员输赢（不包括退水）金额-----------------------------------------
     *
     * */

    String loseWinAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[10]/div";
    String loseWinAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[12]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理报表会员输赢(不包括退水)金额")
    @Test(priority = 8)
        public void loseWinAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getLoseWinAgentTotal = driverUtil.getTextByXpath(loseWinAgentTotal);
            System.out.println("总代理列表会员输赢(不包括退水)金额："+getLoseWinAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getLoseWinAgent = driverUtil.getTextByXpath(loseWinAgent);
            System.out.println("代理列表今日会员输赢(不包括退水)金额："+getLoseWinAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getLoseWinAgentTotal,getLoseWinAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-实际退水金额-----------------------------------------
     *
     * */

    String waterBreakPracticeAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[11]/div";
    String waterBreakPracticeAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[13]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理报表实际退水金额")
    @Test(priority = 9)
        public void waterBreakPracticeAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getWaterBreakPracticeAgentTotal = driverUtil.getTextByXpath(waterBreakPracticeAgentTotal);
            System.out.println("总代理列表实际退水金额："+getWaterBreakPracticeAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getWaterBreakPracticeAgent = driverUtil.getTextByXpath(waterBreakPracticeAgent);
            System.out.println("代理列表今日实际退水金额："+getWaterBreakPracticeAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakPracticeAgentTotal,getWaterBreakPracticeAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-总代理报表-实际输赢(包括退水)金额-----------------------------------------
     *
     * */

    String loseWinAndWaterAgentTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[12]/div";
    String loseWinAndWaterAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[4]/table/tbody/tr/td[14]/div";

    @Features("报表管理")
    @Stories("总代理报表")
    @Title("验证总代理报表实际退水金额")
    @Test(priority = 10)
        public void loseWinAndWaterAgentTotal() throws InterruptedException {
            driverUtil.xpathClick(reportAgentTotal);
            Thread.sleep(1000);
            driverUtil.xpathClick(yesterdayAgentTotal);
            driverUtil.xpathClick(inquireAgentTotal);
            Thread.sleep(2000);
            String getLoseWinAndWaterAgentTotal = driverUtil.getTextByXpath(loseWinAndWaterAgentTotal);
            System.out.println("总代理列表实际输赢(包括退水)金额："+getLoseWinAndWaterAgentTotal);
            driverUtil.xpathClick(accountAgentTotal);
            Thread.sleep(1000);
            String getLoseWinAndWaterAgent = driverUtil.getTextByXpath(loseWinAndWaterAgent);
            System.out.println("代理列表今日实际输赢(包括退水)金额："+getLoseWinAndWaterAgent);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getLoseWinAndWaterAgentTotal,getLoseWinAndWaterAgent);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-今日会员数-----------------------------------------
     *
     * */

    String reportAgent = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[2]/a/li/span";
    String accountAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/input";
    String yesterdayAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div/label[2]/span";
    String inquireAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/button[1]/span";
    String clickAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[1]/div/span[1]";
    String vipNumberAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[2]/div";
    String vipNumberVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[3]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表会员数量")
    @Test(priority = 11)
        public void vipNumberAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getVipNumberAgent = driverUtil.getTextByXpath(vipNumberAgent);
            System.out.println("代理报表昨日会员数："+getVipNumberAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getVipNumberVip = driverUtil.getTextByXpath(vipNumberVip);
            System.out.println("代理列表昨日会员数："+getVipNumberVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumberAgent,getVipNumberVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-代理报表-充值金额-----------------------------------------
     *
     * */

    String rechargeMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[3]";
    String rechargeMoneyVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[4]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表充值金额")
    @Test(priority = 12)
        public void rechargeMoneyAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getRechargeMoneyAgent = driverUtil.getTextByXpath(rechargeMoneyAgent);
            System.out.println("代理报表充值金额："+getRechargeMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getRechargeMoneyVip = driverUtil.getTextByXpath(rechargeMoneyVip);
            System.out.println("会员报表充值金额："+getRechargeMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeMoneyAgent,getRechargeMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-代理报表-取款金额-----------------------------------------
     *
     * */

    String withdrawMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div";
    String withdrawMoneyVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[5]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表取款金额")
    @Test(priority = 13)
        public void withdrawMoneyAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWithdrawMoneyAgent = driverUtil.getTextByXpath(withdrawMoneyAgent);
            System.out.println("代理报表充值金额："+getWithdrawMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWithdrawMoneyVip = driverUtil.getTextByXpath(withdrawMoneyVip);
            System.out.println("会员报表充值金额："+getWithdrawMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWithdrawMoneyAgent,getWithdrawMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

}
