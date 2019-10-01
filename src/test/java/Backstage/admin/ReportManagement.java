package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class ReportManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);


    String reportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String reportVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[3]/a/li/span";
    String clickMoths = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[6]/div/div/label[4]/span";
    String clickReportInput = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[7]/div/button[1]/span";
    String inputAccount = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[2]/div/div/input";
    String rechargeMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div";

    //
    String financeManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/div/span";
    String recordRecharge = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[3]/li/ul/div[1]/a/li/span";
    String inputUser = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[5]/div/div/input";
    String clickMothsRecharge = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[11]/div/div/label[3]/span";
    String clickInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[12]/div/button[1]/span";
    String rechargeTotal = "//*[@id=\"app\"]/div/div[2]/section/div/div[1]/form/div[14]/div/span[2]/span[3]/text()";

    @Features("后台管理")
    @Stories("报表管理")
    @Title("验证会员报表-充值总金额数据是否有误")
    @Test(priority = 1)
    public void rechargeMoneyTotal() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(reportManagement);
        driverUtil.findElementByXpathAndClick(reportVip);
        driverUtil.findElementByXpathAndClearSendkeys(inputAccount,"achaohy2");
        driverUtil.findElementByXpathAndClick(clickMoths);
        driverUtil.findElementByXpathAndClick(clickReportInput);
        Thread.sleep(2000);
        String getRechargeMoney = driverUtil.getTextByXpath(rechargeMoney);
        driverUtil.findElementByXpathAndClick(financeManagement);
        driverUtil.findElementByXpathAndClick(recordRecharge);
        driverUtil.findElementByXpathAndClearSendkeys(inputUser,"achaohy2");
        driverUtil.findElementByXpathAndClick(clickMothsRecharge);
        driverUtil.findElementByXpathAndClick(clickInquire);
        Thread.sleep(2000);
        String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
        System.out.println("会员报表的总充值金额："+getRechargeMoney);
        System.out.println("充值记录的该会员总充值金额"+getRechargeTotal);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getRechargeMoney,getRechargeTotal);
        Assert.assertTrue(Assertion.currentFlag());

    }


}
