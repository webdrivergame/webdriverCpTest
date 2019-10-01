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

    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
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

    String rechargeRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
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

    /***
     *
     * 忽略--------------------------------------------------------------------
     */


    String selectInlineWay = "/html/body/div[5]/div[1]/div[1]/ul/li[4]/span";


    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-线下充值金额数据是否有误")
    @Test(priority = 5)
    public void rechargeInline(){
        driverUtil.findElementByXpathAndClick(reconciliationVip);
        String getRechargeInline = driverUtil.getTextByXpath(rechargeInline);
        driverUtil.findElementByXpathAndClick(rechargeRecord);
        driverUtil.findElementByXpathAndClick(selectRechargeWay);
        driverUtil.findElementByXpathAndClick(selectInlineWay);
        driverUtil.findElementByXpathAndClick(inquire);
        String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
        System.out.println("会员对账的线上充值金额："+getRechargeInline);
        System.out.println("充值记录的在线充值总计："+getRechargeTotal);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeInline,getRechargeTotal);
        Assert.assertTrue(Assertion.currentFlag());

    }



    /***
     *
     * 忽略--------------------------------------------------------------------
     */


    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String selectYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/div/label[2]/span";
    String inquireVipRecord = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[7]/div/button[1]/span";

    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-实际输赢金额是否有误")
    @Test(priority = 6)
    public void loseOrWinActual() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(reconciliationVip);
        String getLoseOrWinActual = driverUtil.getTextByXpath(loseOrWinActual);
        driverUtil.findElementByXpathAndClick(reportManagement);
        driverUtil.findElementByXpathAndClick(reportVip);
        Thread.sleep(2000);
        driverUtil.findElementByXpathAndClick(selectYesterday);
        driverUtil.findElementByXpathAndClick(inquireVipRecord);


    }


    String withdrawRecord = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[2]/a/li/span";
    String clickYesterday = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[2]/span";
    String withdrawInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String withdrawTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[15]/div/span/text()";

    @Features("后台管理")
    @Stories("财务管理")
    @Title("验证会员对账-提款金额是否有误")
    @Test(priority = 7)
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
