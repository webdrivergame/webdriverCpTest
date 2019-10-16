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
     *
     * */

    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String clickStatus = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[3]/div/div/div/input";
    String selectSuccess = "/html/body/div[8]/div[1]/div[1]/ul/li[3]/span";
    String rechargeInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeNumberToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[1]/text()";
    String rechargeNumberTodayPage = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div";


    @Features("财务管理")
    @Stories("充值记录")
    @Title("验证今日充值人数")
    @Test(priority = 1)
    public void   rechargeNumber() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(financeManagement);
        driverUtil.findElementByXpathAndClick(rechargeRecord);
        Thread.sleep(1000);
        driverUtil.findElementByXpathAndClick(clickStatus);
        Thread.sleep(1000);
        driverUtil.findElementByXpathAndClick(selectSuccess);
        driverUtil.findElementByXpathAndClick(rechargeInquire);
        Thread.sleep(1000);
        String getRechargeNumberToday = driverUtil.getTextByXpath(rechargeNumberToday);
        String getRechargeNumberTodayPage = driverUtil.getTextByXpath(rechargeNumberTodayPage);
        String getRechargeNumberTodayPage1 = getRechargeNumberTodayPage.substring(1,getRechargeNumberTodayPage.indexOf("条"));
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeNumberToday,getRechargeNumberTodayPage1);
        Assert.assertTrue(Assertion.currentFlag());

    }

    /**
     * ------------------------------------------------财务管理>充值记录>会员余额---------------------------------------
     *
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
        String getVipAccount = driverUtil.getTextByXpath(vipAccount);
        BigDecimal getBalance = new BigDecimal(driverUtil.getTextByXpath(balance));
        BigDecimal getRechargeMoney = new BigDecimal(driverUtil.getTextByXpath(rechargeMoney));
        driverUtil.findElementByXpathAndClick(UserManagement1);
        driverUtil.findElementByXpathAndClick(vipList);
        Thread.sleep(1000);
        driverUtil.findElementByXpathAndClearSendkeys(inputAccount,getVipAccount);
        driverUtil.findElementByXpathAndClick(vipInquire);
        Thread.sleep(1000);
        BigDecimal getUnableUseMoney = new BigDecimal(driverUtil.getTextByXpath(unableUseMoney));
        BigDecimal result = getBalance.add(getRechargeMoney);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getUnableUseMoney,result);
        Assert.assertTrue(Assertion.currentFlag());

    }













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

    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-差别金额数据是否正常")
    @Test(priority = 1)
    public void ReconciliationVip() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(financeManagement);
        driverUtil.findElementByXpathAndClick(reconciliationVip);
        Thread.sleep(1000);
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


    String dateStart = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[1]/div/div/input[1]";
    String dateEnd = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[1]/div/div/input[2]";
    String pageTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[2]/div";


    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-时间筛选对应数据是否正确")
    @Test(priority = 2)
    public void date(){
        String getDateStart = driverUtil.getTextByXpath(dateStart);
        String getDateEnd = driverUtil.getTextByXpath(dateEnd);
        String getPageTotal = driverUtil.getTextByXpath(pageTotal);
        BigDecimal getDateStart1 = StringToNumber.DateBigDecimal(getDateStart);
        BigDecimal getDateEnd1 = StringToNumber.DateBigDecimal(getDateEnd);
        BigDecimal getPageTotal1 = new BigDecimal(getPageTotal.substring(2,2));
        System.out.println("开始日期："+getDateStart1);
        System.out.println("结束日期："+getDateEnd1);
        System.out.println("页面条数："+getPageTotal1);
        BigDecimal resultDate = getDateEnd1.subtract(getDateStart1);
        Assertion.setFlag(true);
        Assertion.verifyEquals(resultDate,getPageTotal1);
        Assert.assertTrue(Assertion.currentFlag());

    }


    String balanceVipToday = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[10]/div";
    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String VipList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String UserMoneyTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[17]/div/div/span[1]/text()";

    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-今日会员余额数据是否有误")
    @Test(priority = 3)
    public void BalanceVipToday() throws InterruptedException {
        String getBalanceVipToday = driverUtil.getTextByXpath(balanceVipToday);
        driverUtil.findElementByXpathAndClick(UserManagement);
        driverUtil.findElementByXpathAndClick(VipList);
        Thread.sleep(2000);
        String getUserMoneyTotal = driverUtil.getTextByXpath(UserMoneyTotal);
        System.out.println("会员对账的今日会员余额："+getBalanceVipToday);
        System.out.println("会员列表用户总金额："+getUserMoneyTotal);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalanceVipToday,getUserMoneyTotal);
        Assert.assertTrue(Assertion.currentFlag());

    }


    String rechargeTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]/text()";
    String selectRechargeWay = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/div/input";
    String selectOnline = "/html/body/div[5]/div[1]/div[1]/ul/li[3]/span";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";


    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-线上充值金额数据是否有误")
    @Test(priority = 4)
    public void rechargeOnline(){
        driverUtil.findElementByXpathAndClick(financeManagement);
        driverUtil.findElementByXpathAndClick(reconciliationVip);
        String getRechargeOnline = driverUtil.getTextByXpath(rechargeOnline);
        driverUtil.findElementByXpathAndClick(rechargeRecord);
        driverUtil.findElementByXpathAndClick(selectRechargeWay);
        driverUtil.findElementByXpathAndClick(selectOnline);
        driverUtil.findElementByXpathAndClick(inquire);
        String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
        System.out.println("会员对账的线上充值金额："+getRechargeOnline);
        System.out.println("充值记录的在线充值总计："+getRechargeTotal);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeOnline,getRechargeTotal);
        Assert.assertTrue(Assertion.currentFlag());


    }



    String withdrawRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[2]/a/li/span";
    String clickYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";
    String withdrawInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String withdrawTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[15]/div/span/text()";

    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-提款金额是否有误")
    @Test(priority = 5)
    public void rechargeMoney(){
        driverUtil.findElementByXpathAndClick(reconciliationVip);
        String getWithdraw = driverUtil.getTextByXpath(withdraw);
        driverUtil.findElementByXpathAndClick(withdrawRecord);
        driverUtil.findElementByXpathAndClick(clickYesterday);
        driverUtil.findElementByXpathAndClick(withdrawInquire);
        String getWithdrawTotal = driverUtil.getTextByXpath(withdrawTotal);
        System.out.println("会员对账提现金额："+getWithdraw);
        System.out.println("提现记录昨日提现总计金额："+getWithdrawTotal);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getWithdraw,getWithdrawTotal);
        Assert.assertTrue(Assertion.currentFlag());

    }






}
