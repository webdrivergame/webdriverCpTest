package adminTestCase;

import listenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class CashAgentDetailTestCase {

    private WebDriver driver;

    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-直属下级代理人数是否一致")

    @Test(priority = 1)
    public void immediateLowerAgentNumber() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(3000);

        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String immediateLowerAgentNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div/span");
        System.out.println("下级人数："+immediateLowerAgentNumber);
             Thread.sleep(2000);

        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            Thread.sleep(3000);
        //获取直属下级代理人数
        String immediateLowerAgentNumber1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[1]/div/span");
        System.out.println("代理运营详情-直属下级代理人数："+immediateLowerAgentNumber1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(immediateLowerAgentNumber,immediateLowerAgentNumber1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-直推玩家人数是否一致")

    @Test(priority = 2)
    public void DirectPushPlayerNumber() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);

        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String DirectPushPlayerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div/a");
        System.out.println("玩家数："+DirectPushPlayerNumber);


        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            Thread.sleep(3000);
        //获取直推玩家人数
        String DirectPushPlayerNumber1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[2]/div/span");
        System.out.println("直推玩家数："+DirectPushPlayerNumber1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(DirectPushPlayerNumber,DirectPushPlayerNumber1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-税收总计与下级佣金统计税收金额是否一致")

    @Test(priority = 3)
    public void taxTotal() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);

        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        //获取运营数据-税收总计
        String taxTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[6]/div/span");
        System.out.println("现金推广代理税收总计："+taxTotal);
            Thread.sleep(2000);


        //进入下级佣金统计-现金代理税收金额
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);


        //获取税收金额
        String taxTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div");
        System.out.println("下级佣金统计-推广代理税收总计："+taxTotal1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(taxTotal,taxTotal1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-推广佣金总计与下级佣金统计生成佣金总额是否一致")

    @Test(priority = 4)
    public void promotionCommissionTotal() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);

        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);

        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

        //获取运营数据-推广佣金累计
        String promotionCommissionTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[7]/div/span");
        System.out.println("现金推广佣金总计：" + promotionCommissionTotal);
            Thread.sleep(2000);


        //进入下级佣金统计-现金代理生成佣金金额
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //获取生成佣金金额
        String promotionCommissionTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[9]/div");
        System.out.println("下级佣金统计-推广代理生成佣金总计：" + promotionCommissionTotal1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(promotionCommissionTotal, promotionCommissionTotal1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();

    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-领取红包总计与下级佣金统计领取红包总额是否一致")

    @Test(priority = 5)
    public void acceptRedEnvelopeTotal() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(5000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);
        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        //获取运营数据-领取红包总计
        String acceptRedEnvelopeTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/span");
        System.out.println("现金推广领取红包总计：" + acceptRedEnvelopeTotal);
             Thread.sleep(2000);


        //进入下级佣金统计-已领取红包金额
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //获取已领取红包
        String acceptRedEnvelopeTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[10]/div");
        System.out.println("下级佣金统计-已领取红包：" + acceptRedEnvelopeTotal1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(acceptRedEnvelopeTotal, acceptRedEnvelopeTotal1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-累计提款金额与下级佣金统计已领取金额是否一致")

    @Test(priority = 6)
    public void addWithdrawalMoney() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);
        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        //获取运营数据-累计提款金额
        String addWithdrawalMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[9]/div/span");
        System.out.println("累计提款金额：" + addWithdrawalMoney);
            Thread.sleep(2000);
        //进入下级佣金统计-已提现佣金
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //获取已提现佣金
        String addWithdrawalMoney1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[11]/div");
        System.out.println("下级佣金统计-推广代理已提现佣金：" + addWithdrawalMoney1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(addWithdrawalMoney, addWithdrawalMoney1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-佣金账户余额与下级佣金统计待提现佣金是否一致")

    @Test(priority = 7)
    public void commissionAccountBalance() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);
        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        //获取运营数据-佣金账户余额
        String commissionAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[10]/div/span");
        System.out.println("佣金账户余额：" + commissionAccountBalance);
             Thread.sleep(2000);
        //进入下级佣金统计-待提现佣金
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "下级佣金统计");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //获取待提现佣金
        String commissionAccountBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[12]/div/div");
        System.out.println("下级佣金统计-待提现佣金：" + commissionAccountBalance1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(commissionAccountBalance, commissionAccountBalance1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }



    @Feature("代理管理-现金推广代理")
    @Story("现金推广代理详情")
    @Title("现金推广代理详情-验证运营数据-充值余额与代理充值提现额度管理代理额度是否一致")

    @Test(priority = 8)
    public void rechargeBalance() throws InterruptedException {

        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
        driverUtil.adminLogin("xiaochaoadmin", "123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(5000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "现金推广代理");
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_cash_list\"]/li/span");
            Thread.sleep(4000);
        //搜索推广代理
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
        //获取运营数据-充值余额
        String rechargeBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[11]/div/span");
        System.out.println("现金代理详情-充值余额：" + rechargeBalance);
            Thread.sleep(2000);


        //进入代理充值提现额度管理-代理充值余额
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input", "代理充值提现额度管理");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_amount_list\"]/li/span");
            Thread.sleep(3000);
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/ul/div[2]/li/span");
            Thread.sleep(2000);
        driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input", "44444");
        driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //获取充值余额
        String rechargeBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[3]/table/tbody/tr/td[4]/div");
        System.out.println("额度管理-充值余额：" + rechargeBalance1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(rechargeBalance, rechargeBalance1);
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil.LoginAfter();
    }


}
