package adminTestCase;

import listenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class cashBusinessDetailTestCase {

    public WebDriver driver;

    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-直属下级代理人数是否一致")

    @Test(priority = 1)
        public void immediateLowerAgentNumber() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金推广代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","qaxjtg01");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            //获取直属下级代理人数
            String immediateLowerAgentNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div/span");
            System.out.println("直属下级代理人数："+immediateLowerAgentNumber);
            //进入商户详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[4]/div[2]/table/tbody/tr/td[1]/div/a/div/span");
                Thread.sleep(3000);
            String immediateLowerAgentNumber1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[1]/div/span");
            System.out.println("商户详情直属下级代理人数："+immediateLowerAgentNumber1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(immediateLowerAgentNumber,immediateLowerAgentNumber1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();

        }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-税收总计是否与下级佣金统计税收一致")

    @Test(priority = 2)
        public void taxTotal() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
                Thread.sleep(5000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            //进入商户详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            driverUtil.scrollToBottom();
            //获取商户详情税收总计
            String waitWithdrawMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[6]/div/span");
            System.out.println("商户详情税收"+waitWithdrawMoney);
                Thread.sleep(2000);
                //下级佣金统计
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String waitWithdrawMoney2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div");
            System.out.println("下级佣金统计税收"+waitWithdrawMoney2);
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(waitWithdrawMoney, waitWithdrawMoney2);
                    Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
}


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-推广佣金总计是否与下级佣金统计该商户所占佣金是否一致")

    @Test(priority = 3)
    public void alreadySettlementMoney() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
                driverUtil.WebElementWaitClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input");
                //搜索商户
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                    Thread.sleep(3000);
                //进入商户详情
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
                String alreadySettlementMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[7]/div/span");
                System.out.println("商户详情推广佣金总计："+alreadySettlementMoney);
                //进入下级佣金统计
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                    Thread.sleep(3000);
                //按照商户搜索
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                    Thread.sleep(3000);
                //获取商户所占佣金
                String alreadySettlementMoney2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/span[2]");
                System.out.println("商户所占佣金："+alreadySettlementMoney2);
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(alreadySettlementMoney,alreadySettlementMoney2);
                    Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
            }

    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-待领取佣金是否与下级佣金统计待提现佣金一致")

    @Test(priority = 4)
    public void waitWithdrawMoney() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(3000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        //获取待领取佣金
        String waitWithdrawMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/span");
        System.out.println("商户详情待提现佣金："+waitWithdrawMoney);
        //下级佣金统计
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        //待提现佣金
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String waitWithdrawMoney2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[10]/div/div/span");
        System.out.println("下级佣金统计待提现佣金:"+waitWithdrawMoney2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(waitWithdrawMoney, waitWithdrawMoney2);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现今商户详情-验证运营数据-充值余额是否与代理充值提现额度管理该商户金额一致")

    @Test(priority = 5)
    public void rechargeBalance() throws InterruptedException {
        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(3000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //进入商户详情
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String rechargeBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[9]/div/span");
        System.out.println("商户充值余额："+rechargeBalance);
       //进入代理充值提现额度管理
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "代理充值提现额度管理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_amount_list\"]/li/span");
            Thread.sleep(3000);
        //搜索商户
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/div[1]/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String rechargeBalance2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div");
        System.out.println("商户充值提现额度"+rechargeBalance2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(rechargeBalance, rechargeBalance2);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-在线充值可用额度金额是否与在线充值提现额度列表该商户金额一致")

    @Test( priority = 6)
    public void onlineRechargeCredit() throws InterruptedException {
        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String onlineRechargeCredit = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[12]/div/span");
        System.out.println("商户在线充值可用额度："+onlineRechargeCredit);
                Thread.sleep(2000);
        //在线充值提现额度列表
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "支付入口配置");
        driverUtil.findElementByXpathAndClick("//*[@id=\"opt_pay_config_parent_list\"]/li/span");
                Thread.sleep(2000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
        String onlineRechargeCredit2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div");
        System.out.println("商户在线充值额度："+onlineRechargeCredit2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(onlineRechargeCredit, onlineRechargeCredit2);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广商户详情")
    @Title("现金商户详情-验证运营数据-在线提现可用额度金额是否与在线充值提现额度列表该商户金额一致")

    @Test(priority = 7)
    public void onlineWithdrawCredit() throws InterruptedException {
        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
                Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "qaxjtg01");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(2000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        driverUtil.scrollToBottom();
        String onlineWithdrawCredit = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[13]/div/span");
        System.out.println("商户详情在线提现可用额度："+onlineWithdrawCredit);
                Thread.sleep(2000);
        //在线充值提现额度列表
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "支付入口配置");
        driverUtil.findElementByXpathAndClick("//*[@id=\"opt_pay_config_parent_list\"]/li/span");
        driverUtil.WebElementWaitLocated("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
        String onlineWithdrawCredit2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");
        System.out.println("商户在线提现额度："+onlineWithdrawCredit2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(onlineWithdrawCredit, onlineWithdrawCredit2);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }

}
