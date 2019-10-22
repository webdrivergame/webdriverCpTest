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
     * ------------------------------------------------财务管理>充值记录>今日充值人数----------------------------------------
     *-------------------------------------------------财务管理>充值记录>今日充值人数Page------------------------------------
     * */

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
        public void   rechargeNumber() throws InterruptedException {
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
            String getRechargeNumberToday1 = getRechargeNumberToday.substring(7);//截取数据：今日充值人数：X
            String getRechargeNumberTodayPage1 = getRechargeNumberTodayPage.substring(1,getRechargeNumberTodayPage.indexOf("条"));//共8条记录 第1 / 1页
            System.out.println("今日充值人数总计："+getRechargeNumberToday1);
            System.out.println("今日充值人数页数量："+getRechargeNumberTodayPage1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeNumberToday1,getRechargeNumberTodayPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>充值记录>会员余额---------------------------------------
     *-------------------------------------------------用户管里>会员列表-会员余额---------------------------------------
     * */

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
            driverUtil.xpathClearSendKeys(inputAccount,getVipAccount);
            driverUtil.xpathClick(vipInquire);
            Thread.sleep(1000);
            BigDecimal getUnableUseMoney = new BigDecimal(driverUtil.getTextByXpath(unableUseMoney));
            BigDecimal result = getBalance.add(getRechargeMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnableUseMoney,result);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>提现记录>会员余额---------------------------------------
     *-------------------------------------------------用户管理>会员列表>会员余额---------------------------------------
     * */

    String withdrawRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[2]/a/li/span";
    String status = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[1]/div/div/div/input";
    String selectSuccess1 = "/html[1]/body[1]/div[4]/div[1]/div[1]/ul[1]/li[3]/span[1]";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String balanceWithdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String MoneyWithdraw = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[9]/div/span";
    String vipAccount1 = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String inputVipAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String inquireVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String unableMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/span";

    @Features("财务管理")
    @Stories("提款记录")
    @Title("验证会员充值余额字段")
    @Test(priority = 3)
        public void  balanceWithdraw() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            Thread.sleep(1000);
            driverUtil.xpathClick(withdrawRecord);
            Thread.sleep(2000);
            driverUtil.xpathClick(status);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectSuccess1);
            driverUtil.xpathClick(inquire);
            Thread.sleep(1000);
            String getVipAccount1 = driverUtil.getTextByXpath(vipAccount1);
            BigDecimal getBalanceWithdraw = new BigDecimal(driverUtil.getTextByXpath(balanceWithdraw));
            BigDecimal getMoneyWithdraw = new BigDecimal(driverUtil.getTextByXpath(MoneyWithdraw));
            BigDecimal result = getBalanceWithdraw.subtract(getMoneyWithdraw);
            System.out.println("提现记录会员余额："+getBalanceWithdraw);
            System.out.println("提现金额："+getMoneyWithdraw);
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(vipList);
            Thread.sleep(1000);
            driverUtil.xpathClearSendKeys(inputVipAccount,getVipAccount1);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(1000);
            BigDecimal getUnableMoney = new BigDecimal(driverUtil.getTextByXpath(unableMoney));
            System.out.println("会员列表会员余额："+getUnableMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result,getUnableMoney);
            Assert.assertTrue(Assertion.currentFlag());


        }

    /**
     * ------------------------------------------------财务管理>资金明细>会员余额---------------------------------------
     *-------------------------------------------------用户管理>会员列表>会员余额---------------------------------------
     * */

    String moneyDate = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[3]/a/li/span";
    String userAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[1]/div/span";
    String transactionBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div";

    @Features("财务管理")
    @Stories("资金明细")
    @Title("验证余额数据")
    @Test(priority = 4)
        public void balanceVip() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(moneyDate);
            Thread.sleep(2000);
            String getUserAccount = driverUtil.getTextByXpath(userAccount);
            String getTTransactionBalance = driverUtil.getTextByXpath(transactionBalance);
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(vipList);
            driverUtil.xpathClearSendKeys(inputVipAccount,getUserAccount);
            driverUtil.xpathClick(inquireVip);
            Thread.sleep(1000);
            String getUnableMoney = driverUtil.getTextByXpath(unableMoney);
            System.out.println("会员账号："+getUserAccount);
            System.out.println("资金明细会员余额："+getTTransactionBalance);
            System.out.println("会员列表会员余额："+getUnableMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnableMoney,getTTransactionBalance);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>会员对账>差别金额---------------------------------------
     *
     * */

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
    @Test(priority = 5)
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
            String getRedPacketMoney= driverUtil.getTextByXpath(redPacketMoney);
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
            System.out.println("计算金额："+result);
            System.out.println("页面对账差值金额："+getReconciliationMoney1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(result,getReconciliationMoney1);
            Assert.assertTrue(Assertion.currentFlag());

        }





    /**
     * ------------------------------------------------财务管理>会员对帐>今日会员余额---------------------------------------
     *
     * */

    String balanceVipToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[10]/div";
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String VipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String UserMoneyTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[17]/div/div/span[1]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证今日会员余额数据")
    @Test(priority = 7)
        public void BalanceVipToday() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getBalanceVipToday = driverUtil.getTextByXpath(balanceVipToday);
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(VipList);
            Thread.sleep(2000);
            String getUserMoneyTotal = driverUtil.getTextByXpath(UserMoneyTotal);
            System.out.println("会员对账的今日会员余额："+getBalanceVipToday);
            System.out.println("会员列表用户总金额："+getUserMoneyTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBalanceVipToday,getUserMoneyTotal);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>会员对帐>线上充值金额---------------------------------------
     *
     * */

    String rechargeTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]";
    String selectRechargeWay = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/div/input";
    String selectOnline = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/span[1]";
    String inquireRechargeWay = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String yesterdayRecharge = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";
    String rechargeStatus = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/div/input";
    String selectRechargeSuccess = "//body/div[3]/div[1]/div[1]/ul[1]/li[3]/span[1]";


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证线上充值金额数据是否有误")
    @Test(priority = 8)
        public void rechargeOnline() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(2000);
            String getRechargeOnline = driverUtil.getTextByXpath(rechargeOnline);
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(1000);
            driverUtil.xpathClick(selectRechargeWay);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectOnline);//收款方式-在线入款
            driverUtil.xpathClick(rechargeStatus);
            Thread.sleep(1000);
            driverUtil.xpathClick(selectRechargeSuccess);//选择状态-充值成功
            driverUtil.xpathClick(yesterdayRecharge);
            driverUtil.xpathClick(inquireRechargeWay);
            Thread.sleep(1000);
            String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
            String getRechargeTotal1 = getRechargeTotal.substring(6);
            System.out.println("会员对账的线上充值金额："+getRechargeOnline);
            System.out.println("充值记录的在线充值总计："+getRechargeTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getRechargeOnline,getRechargeTotal1);
            Assert.assertTrue(Assertion.currentFlag());


        }

    /**
     * ------------------------------------------------财务管理>会员对帐>线下充值金额---------------------------------------
     *
     * */


    String underLine = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div";
    String hand = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/span[1]";
    String handTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]";
    String clickStatusUnder = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/div/input";
    String selectSuccessUnder = "//body/div[3]/div[1]/div[1]/ul[1]/li[3]/span[1]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证线下充值金额")
    @Test(priority = 9)
        public void underLine() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(1000);
            String getUnderLine = driverUtil.getTextByXpath(underLine);//会员对账的线下充值金额
            driverUtil.xpathClick(rechargeRecord);
            Thread.sleep(1000);
            driverUtil.xpathClick(selectRechargeWay);
            Thread.sleep(2000);
            driverUtil.xpathClick(hand);//选择手动入款
            driverUtil.xpathClick(clickStatusUnder);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectSuccessUnder);
            driverUtil.xpathClick(yesterdayRecharge);//选择昨天数据
            driverUtil.xpathClick(inquireRechargeWay);//查询
            Thread.sleep(1000);
            String getHandTotal = driverUtil.getTextByXpath(handTotal);
            String getHandTotal1 = getHandTotal.substring(6);
            Thread.sleep(1000);
            System.out.println("会员对账的线下充值金额:"+getUnderLine);
            System.out.println("充值记录手动入款金额:"+getHandTotal1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnderLine,getHandTotal1);
            Assert.assertTrue(Assertion.currentFlag());
        }

    /**
     * ------------------------------------------------财务管理>会员对帐>提款金额---------------------------------------
     *
     * */

    String withdrawRecord1 = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[2]/a/li/span";
    String selectWithdrawStatus = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[1]/div/div/div/input";
    String selectPass = "/html[1]/body[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/span[1]";
    String clickYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";
    String withdrawInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String withdrawTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[15]/div/span";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证提款金额")
    @Test(priority =10)
        public void rechargeMoney() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(1000);
            String getWithdraw = driverUtil.getTextByXpath(withdraw);
            driverUtil.xpathClick(withdrawRecord1);
            Thread.sleep(1000);
            driverUtil.xpathClick(selectWithdrawStatus);
            Thread.sleep(2000);
            driverUtil.xpathClick(selectPass);//提现记录选择提现成功状态
            driverUtil.xpathClick(clickYesterday);//选择昨日数据
            driverUtil.xpathClick(withdrawInquire);//查询
            Thread.sleep(1000);
            String getWithdrawTotal = driverUtil.getTextByXpath(withdrawTotal);
            System.out.println("会员对账提现金额："+getWithdraw);
            System.out.println("提现记录昨日提现总计金额："+getWithdrawTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getWithdraw,getWithdrawTotal);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>会员对帐>实际输赢金额---------------------------------------
     *
     * */

    String practiceMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String vipReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String vipReportMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[4]/table/tbody/tr/td[15]/div";


    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证实际输赢金额")
    @Test(priority = 11)
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
            System.out.println("会员对账实际输赢金额："+getPracticeMoney);
            System.out.println("会员报表今日实际输赢金额："+getVipReportMoney);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipReportMoney,getVipReportMoney);
            Assert.assertTrue(Assertion.currentFlag());

        }

    /**
     * ------------------------------------------------财务管理>会员对帐>未结算金额---------------------------------------
     *
     * */

    String unLiquidatedMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[6]/div";
    String betRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/div/span";
    String noteListToday = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[5]/li/ul/div[1]/a/li/span";
    String clickDate = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[8]/div/div[1]/div[1]/input";
    String selectAddDate = "/html/body/div[6]/div[1]/div[1]/ul/li[2]/span";
    String inquireNoteList = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[9]/div/button[1]/span";
    String unLiquidatedMoneyTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/span/span[2]";

    @Features("财务管理")
    @Stories("会员对账")
    @Title("验证未结算金额")
    @Test(priority = 12)
        public void unLiquidatedMoney() throws InterruptedException {
            driverUtil.xpathClick(financeManagement);
            driverUtil.xpathClick(reconciliationVip);
            Thread.sleep(1000);
            String getUnLiquidatedMoney = driverUtil.getTextByXpath(unLiquidatedMoney);
            driverUtil.xpathClick(betRecord);
            driverUtil.xpathClick(noteListToday);
            Thread.sleep(1000);
            driverUtil.xpathClick(clickDate);//今日注单列表选择添加日期
            driverUtil.xpathClick(selectAddDate);
            driverUtil.xpathClick(inquireNoteList);
            Thread.sleep(2000);
            String getUnLiquidatedMoneyTotal = driverUtil.getTextByXpath(unLiquidatedMoneyTotal);
            System.out.println("会员对账未结算金额："+getUnLiquidatedMoney);
            System.out.println("今日注单未结算金额："+getUnLiquidatedMoneyTotal);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUnLiquidatedMoney,getUnLiquidatedMoneyTotal);
            Assert.assertTrue(Assertion.currentFlag());
        }




























}
