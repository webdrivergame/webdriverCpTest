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
     * -------------------------------------------报表管理-代理报表-笔数-----------------------------------------
     *
     * */

    String countAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[5]/div";
    String countVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[6]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表充值笔数")
    @Test(priority = 13)
        public void countAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getCountAgent = driverUtil.getTextByXpath(countAgent);
            System.out.println("代理报表充值笔数："+getCountAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getCountVip = driverUtil.getTextByXpath(countVip);
            System.out.println("会员报表充值笔数总计："+getCountVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getCountAgent,getCountVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-投注金额-----------------------------------------
     *
     * */

    String betMoneyAgentReport = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[6]/div";
    String betMoneyVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[7]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表投注金额")
    @Test(priority = 13)
        public void betMoneyAgentReport() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getBetMoneyAgentReport = driverUtil.getTextByXpath(betMoneyAgentReport);
            System.out.println("代理报表充值笔数："+getBetMoneyAgentReport);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getBetMoneyVip = driverUtil.getTextByXpath(betMoneyVip);
            System.out.println("会员报表充值笔数总计："+getBetMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBetMoneyAgentReport,getBetMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-赢利投注金额-----------------------------------------
     *
     * */

    String winBetMoneyAgentReport = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[7]/div/span";
    String winBetMoneyVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[8]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表赢利投注金额")
    @Test(priority = 13)
        public void winBetMoneyAgentReport() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinBetMoneyAgentReport = driverUtil.getTextByXpath(winBetMoneyAgentReport);
            System.out.println("代理报表赢利投注金额："+getWinBetMoneyAgentReport);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWinBetMoneyVip = driverUtil.getTextByXpath(winBetMoneyVip);
            System.out.println("会员报表赢利投注金额总计："+getWinBetMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinBetMoneyAgentReport,getWinBetMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-代理报表-充值优惠/手续费金额-----------------------------------------
     *
     * */

    String serviceMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[9]/div";
    String serviceMoneyVipTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[10]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表充值优惠/手续费")
    @Test(priority = 16)
        public void serviceMoneyAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getServiceMoneyAgent = driverUtil.getTextByXpath(serviceMoneyAgent);
            System.out.println("代理报表充值优惠/手续费："+getServiceMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getServiceMoneyVipTotal = driverUtil.getTextByXpath(serviceMoneyVipTotal);
            System.out.println("会员报表充值优惠手续费："+getServiceMoneyVipTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getServiceMoneyAgent,getServiceMoneyVipTotal);
            Assert.assertTrue(Assertion.currentFlag());
    }




    /**
     * -------------------------------------------报表管理-代理报表-代理赔率金额-----------------------------------------
     *
     * */

    String oddsAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[10]/div";
    String oddsVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[11]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表代理赔率金额")
    @Test(priority = 17)
        public void oddsAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getOddsAgent = driverUtil.getTextByXpath(oddsAgent);
            System.out.println("代理报表代理赔率金额："+getOddsAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getOddsVip = driverUtil.getTextByXpath(oddsVip);
            System.out.println("会员报表代理赔率金额："+getOddsVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getOddsAgent,getOddsVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-代理退水金额-----------------------------------------
     *
     * */

    String waterBreakMoneyAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[11]/div";
    String waterBreakMoneyVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[12]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表代理退水金额")
    @Test(priority = 18)
        public void waterBreakMoneyAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWaterBreakMoneyAgent = driverUtil.getTextByXpath(waterBreakMoneyAgent);
            System.out.println("代理报表代理退水金额："+getWaterBreakMoneyAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWaterBreakMoneyVip = driverUtil.getTextByXpath(waterBreakMoneyVip);
            System.out.println("会员报表代理退水金额："+getWaterBreakMoneyVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakMoneyAgent,getWaterBreakMoneyVip);
            Assert.assertTrue(Assertion.currentFlag());
    }


    /**
     * -------------------------------------------报表管理-代理报表-会员输赢（不包括退水）-----------------------------------------
     *
     * */

    String winLoseNotWaterAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[12]/div";
    String winLoseNotWaterVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[13]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表实际输赢（不包括退水）")
    @Test(priority = 19)
        public void winLoseNotWaterAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinLoseNotWaterAgent = driverUtil.getTextByXpath(winLoseNotWaterAgent);
            System.out.println("代理报表实际输赢（不包括退水）："+getWinLoseNotWaterAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWinLoseNotWaterVip = driverUtil.getTextByXpath(winLoseNotWaterVip);
            System.out.println("会员报表实际输赢（不包括退水）："+getWinLoseNotWaterVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinLoseNotWaterAgent,getWinLoseNotWaterVip);
            Assert.assertTrue(Assertion.currentFlag());
    }



    /**
     * -------------------------------------------报表管理-代理报表-会员输赢（包括退水）-----------------------------------------
     *
     * */

    String winLoseWaterAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[14]/div/span";
    String winLoseWaterVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";

    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表实际输赢（包括退水）")
    @Test(priority = 20)
        public void winLoseWaterAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWinLoseWaterAgent = driverUtil.getTextByXpath(winLoseWaterAgent);
            System.out.println("代理报表实际输赢（包括退水）："+getWinLoseWaterAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWinLoseWaterVip = driverUtil.getTextByXpath(winLoseWaterVip);
            System.out.println("会员报表实际输赢（包括退水）："+getWinLoseWaterVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWinLoseWaterAgent,getWinLoseWaterVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------------报表管理-代理报表-实际退水-------------------------------
     *
     * */

    String waterBreakMoneyActivityAgent = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr/td[13]/div";
    String waterBreakMoneyActivityVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[14]/div";
    @Features("报表管理")
    @Stories("代理报表")
    @Title("验证代理报表代理退水金额")
    @Test(priority = 21)
        public void waterBreakMoneyActivityAgent() throws InterruptedException {
            driverUtil.xpathClick(reportAgent);
            driverUtil.xpathClearSendKeys(accountAgent,"dl");
            driverUtil.xpathClick(yesterdayAgent);
            driverUtil.xpathClick(inquireAgent);
            Thread.sleep(2000);
            String getWaterBreakMoneyActivityAgent = driverUtil.getTextByXpath(waterBreakMoneyActivityAgent);
            System.out.println("代理报表实际退水金额："+getWaterBreakMoneyActivityAgent);
            driverUtil.xpathClick(clickAgent);
            Thread.sleep(1000);
            String getWaterBreakMoneyActivityVip = driverUtil.getTextByXpath(waterBreakMoneyActivityVip);
            System.out.println("会员报表实际退水金额："+getWaterBreakMoneyActivityVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWaterBreakMoneyActivityAgent,getWaterBreakMoneyActivityVip);
            Assert.assertTrue(Assertion.currentFlag());
    }

    /**
     * -------------------------------------报表管理-会员报表-充值金额-------------------------------------------
     *
     * */

    String reportVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String inputVipAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/input";
    String reportVipYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/div/label[2]/span";
    String reportVipInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[7]/div/button[1]/span";
    String rechargeVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div";
    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String rechargeRecordInput = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div/input";
    String rechargeRecordYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";
    String rechargeRecordInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeRecordTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]";

    @Features("报表管理")
    @Stories("会员报表")
    @Title("验证会员报表充值金额")
    @Test(priority = 22)
        public void rechargeMoneyVip() throws InterruptedException {
        driverUtil.xpathClick(reportAgent);
        driverUtil.xpathClick(reportVip);
        Thread.sleep(2000);
        driverUtil.xpathClearSendKeys(inputVipAccount, "achaodl1hy1");
        driverUtil.xpathClick(reportVipYesterday);
        driverUtil.xpathClick(reportVipInquire);
        Thread.sleep(2000);
        String getRechargeVip = driverUtil.getTextByXpath(rechargeVip);
        System.out.println("会员报表会员充值金额：" + getRechargeVip);
        driverUtil.xpathClick(financeManagement);
        driverUtil.xpathClick(rechargeRecord);
        Thread.sleep(2000);
        driverUtil.xpathClearSendKeys(rechargeRecordInput,"achaodl1hy1");
        driverUtil.xpathClick(rechargeRecordYesterday);
        driverUtil.xpathClick(rechargeRecordInquire);
        Thread.sleep(2000);
        String getRechargeRecordTotal = driverUtil.getTextByXpath(rechargeRecordTotal);
        String getRechargeRecordTotalValue = getRechargeRecordTotal.substring(5);
        System.out.println("充值记录昨日充值总计："+getRechargeRecordTotalValue);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeVip,getRechargeRecordTotalValue);
        Assert.assertTrue(Assertion.currentFlag());

    }





}
