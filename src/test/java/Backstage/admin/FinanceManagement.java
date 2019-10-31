package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;

public class FinanceManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);



    /**
     * ------------------------------------------------财务管理>充值记录>今日充值人数----------------------------------------
     */

    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String clickStatus = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/div/input";
    String selectSuccess = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/span[1]";
    String rechargeInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeNumberToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[1]";
    String rechargeNumberTodayPage = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div";


    @Features("财务管理")
    @Stories("充值记录")
    @Title("验证今日充值人数")
    @Test(priority = 1)
        public void rechargeNumber() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(1000);
            driverUtil.xpathClick(clickStatus);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectSuccess);//选择状态-充值成功
            driverUtil.xpathClick(rechargeInquire);
            Thread.sleep(1000);
            String getRechargeNumberToday = driverUtil.getTextByXpath(rechargeNumberToday);
            String getRechargeNumberTodayPage = driverUtil.getTextByXpath(rechargeNumberTodayPage);
            String getRechargeNumberToday1 = getRechargeNumberToday.substring(6);//截取数据：今日充值人数：X
            String getRechargeNumberTodayPage1 = getRechargeNumberTodayPage.substring(1, getRechargeNumberTodayPage.indexOf("条"));//共8条记录 第1 / 1页
            System.out.println("今日充值人数总计：" + getRechargeNumberToday1);
            System.out.println("今日充值人数页数量：" + getRechargeNumberTodayPage1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeNumberToday1, getRechargeNumberTodayPage1);
            Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * ------------------------------------------------财务管理>充值记录>会员余额---------------------------------------
     */

    String vipAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/div[1]";
    String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String rechargeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div/span";
    String UserManagement1 = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String vipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String inputAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String vipInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String unableUseMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/span";

    @Features("财务管理")
    @Stories("充值记录")
    @Title("验证会员充值余额字段")
    @Test(priority = 2)
        public void rechargeBalance() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(rechargeRecord);
            String getVipAccount = driverUtil.getTextByXpath(vipAccount);
            BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
            BigDecimal getRechargeMoney = new BigDecimal(driverUtil.getTextByXpath(rechargeMoney));
            driverUtil.xpathClick(UserManagement1);
            driverUtil.xpathClick(vipList);
            Thread.sleep(1000);
            driverUtil.xpathClearSendKeys(inputAccount, getVipAccount);
            driverUtil.xpathClick(vipInquire);
            Thread.sleep(1000);
            BigDecimal getUnableUseMoney = new BigDecimal(driverUtil.getTextByXpath(unableUseMoney));
            BigDecimal result = getBalance.add(getRechargeMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnableUseMoney, result);
            Assert.assertTrue(Assertion.currentFlag());

    }




    /**
     * ------------------------------------------------财务管理>会员对账>差别金额---------------------------------------
     */

    String reconciliationVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[4]/a/li/span";

    String yesterdayBalanceVip = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div";
    String rechargeOnline = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div";
    String rechargeInline = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";
    String loseOrWinActual = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String notAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div";
    String withdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div";
    String exerciseMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div";
    String redPacketMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[9]/div";
    String BalanceVipToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[10]/div";
    String ReconciliationMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[14]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证差别金额数据是否正常")
    @Test(priority = 3)
        public void ReconciliationVip() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getYesterdayBalanceVip = driverUtil.getTextByXpath(yesterdayBalanceVip);
            String getRechargeOnline = driverUtil.getTextByXpath(rechargeOnline);
            String getRechargeInline = driverUtil.getTextByXpath(rechargeInline);
            String getLoseOrWinActual = driverUtil.getTextByXpath(loseOrWinActual);
            String getNotAccount = driverUtil.getTextByXpath(notAccount);
            String getWithdraw = driverUtil.getTextByXpath(withdraw);
            String getExerciseMoney = driverUtil.getTextByXpath(exerciseMoney);
            String getRedPacketMoney = driverUtil.getTextByXpath(redPacketMoney);
            String getBalanceVipToday = driverUtil.getTextByXpath(BalanceVipToday);
            String getReconciliationMoney = driverUtil.getTextByXpath(ReconciliationMoney);


            BigDecimal getYesterdayBalanceVip1 = new BigDecimal(getYesterdayBalanceVip);//昨日会员余额
            BigDecimal getRechargeOnline1 = new BigDecimal(getRechargeOnline);//线上充值
            BigDecimal getRechargeInline1 = new BigDecimal(getRechargeInline);//线下充值
            BigDecimal getLoseOrWinActual1 = new BigDecimal(getLoseOrWinActual);//实际输赢
            BigDecimal getNotAccount1 = new BigDecimal(getNotAccount);//未结算
            BigDecimal getWithdraw1 = new BigDecimal(getWithdraw);//提款
            BigDecimal getExerciseMoney1 = new BigDecimal(getExerciseMoney);//活动奖金
            BigDecimal getRedPacketMoney1 = new BigDecimal(getRedPacketMoney);//红包金额
            BigDecimal getBalanceVipToday1 = new BigDecimal(getBalanceVipToday);//今日会员余额
            BigDecimal getReconciliationMoney1 = new BigDecimal(getReconciliationMoney);//对账差别金额
            BigDecimal result = getBalanceVipToday1.subtract(getYesterdayBalanceVip1).subtract(getRechargeInline1).subtract(getRechargeOnline1).subtract(getLoseOrWinActual1).add(getNotAccount1).add(getWithdraw1).subtract(getExerciseMoney1).subtract(getRedPacketMoney1);
            System.out.println("计算金额：" + result);
            System.out.println("页面对账差值金额：" + getReconciliationMoney1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result, getReconciliationMoney1);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * ------------------------------------------------财务管理>会员对帐>今日会员余额---------------------------------------
     */

    String balanceVipToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[10]/div";
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String VipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String UserMoneyTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[17]/div/div/span[1]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证今日会员余额数据")
    @Test(priority = 4)
        public void BalanceVipToday() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getBalanceVipToday = driverUtil.getTextByXpath(balanceVipToday);
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(VipList);
            Thread.sleep(2000);
            String getUserMoneyTotal = driverUtil.getTextByXpath(UserMoneyTotal);
            System.out.println("会员对账的今日会员余额：" + getBalanceVipToday);
            System.out.println("会员列表用户总金额：" + getUserMoneyTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBalanceVipToday, getUserMoneyTotal);
            Assert.assertTrue(Assertion.currentFlag());

    }


    /**
     * ------------------------------------------------财务管理>会员对帐>实际输赢金额---------------------------------------
     */

    String practiceMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String vipReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String vipReportMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证实际输赢金额")
    @Test(priority = 5)
        public void practiceLoseOrWin() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getPracticeMoney = driverUtil.getTextByXpath(practiceMoney);
            driverUtil.xpathClick(reportManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(vipReport);
            Thread.sleep(1000);
            String getVipReportMoney = driverUtil.getTextByXpath(vipReportMoney);
            System.out.println("会员对账实际输赢金额：" + getPracticeMoney);
            System.out.println("会员报表今日实际输赢金额：" + getVipReportMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getPracticeMoney, getVipReportMoney);
            Assert.assertTrue(Assertion.currentFlag());

    }

}




























