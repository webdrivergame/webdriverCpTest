package AgentManagement;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class CashBusinessDetail {

    private WebDriver driver;

        @Feature("代理管理-现金推广代理")
        @Story("现金推广商户详情")
        @Title("验证运营数据-税收总计是否与下级佣金统计该商户税收总计金额一致")

        @Test(enabled = false)
        public void taxTotal() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金推广代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
                Thread.sleep(5000);
            //搜索商户
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","xjtg66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            //进入商户详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

                Thread.sleep(2000);

            driverUtil.scrollToBottom();
        /***
         * 问题区------------------------------------------------------------
         */

            Thread.sleep(2000);
            String taxTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[6]/div/span");

            //下级佣金统计
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                Thread.sleep(3000);
            //搜索商户
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","xjtg66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(300);

            String tax = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div");

                Assertion.setFlag(true);
                Assertion.verifyEquals(taxTotal,tax);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
    }
    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("验证运营数据-累计提款金额是否与下级佣金统计该商户已结算金额一致")

    @Test(enabled = false)
    public void alreadySettlementMoney() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
        driverUtil.adminlogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(5000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String alreadySettlementMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[7]/div/span");

        //下级佣金统计
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(300);

        String alreadySettlementMoney2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[9]/div");

            Assertion.setFlag(true);
            Assertion.verifyEquals(alreadySettlementMoney, alreadySettlementMoney2);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }

    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("验证运营数据-待领取佣金是否与下级佣金统计待提现佣金一致")

    @Test(enabled = false)
    public void waitWithdrawMoney() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
        driverUtil.adminlogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(5000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String waitWithdrawMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[8]/label");

        //下级佣金统计
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(300);

        String waitWithdrawMoney2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[10]/div/div/span");

            Assertion.setFlag(true);
            Assertion.verifyEquals(waitWithdrawMoney, waitWithdrawMoney2);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("验证运营数据-充值余额是否与代理充值提现额度管理该商户金额一致")

    @Test(enabled = false)
    public void rechangeBalance() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
        driverUtil.adminlogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(5000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String rechargeBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[9]/div/span");

       //进入代理充值提现额度管理
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "代理充值提现额度管理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_amount_list\"]/li/span");
            Thread.sleep(3000);

        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/div[1]/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(300);
        String rechargeBalance2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div");

            Assertion.setFlag(true);
            Assertion.verifyEquals(rechargeBalance, rechargeBalance2);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("验证运营数据-在线充值可用额度金额是否与在线充值提现额度列表该商户金额一致")

    @Test(enabled = false)
    public void onlineRechargeCredit() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
        driverUtil.adminlogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(5000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String onlineRechargeCredit = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[12]/div/span");

        //在线充值提现额度列表
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "在线充值提现额度列表");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_pay_balance_list\"]/li/span");
            Thread.sleep(3000);

        String onlineRechargeCredit2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div");

            Assertion.setFlag(true);
            Assertion.verifyEquals(onlineRechargeCredit, onlineRechargeCredit2);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("验证运营数据-在线提现可用额度金额是否与在线充值提现额度列表该商户金额一致")

    @Test(enabled = false)
    public void onlineWithdrawCredit() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.LoginBefore("http://192.168.1.9:9091/#/login");
        driverUtil.adminlogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(5000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "xjtg66");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String onlineWithdrawCredit = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[1]/div[2]/div[2]/div/form/div[13]/div/span");

        //在线充值提现额度列表
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "在线充值提现额度列表");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_pay_balance_list\"]/li/span");
            Thread.sleep(3000);

        String onlineWithdrawCredit2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");

            Assertion.setFlag(true);
            Assertion.verifyEquals(onlineWithdrawCredit, onlineWithdrawCredit2);
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil.LoginAfter();
    }

}
