package Admin;

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

public class LowerCommissionSettlementRecord {
        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";



        /***
         *
         * 点击现金商户跳转详情
         * 结算待结算佣金
         * 输入100确认
         * @获取现金商户详情待结算佣金
         * 点击下级佣金结算记录
         * 查询商户qaxjtg01
         * 获取结算前金额1
         * 获取结算前金额2
         * 获取结算金额
         * 获取累计提款金额1
         * 获取累计提款金额2
         * 登录商户qaxjtg01账号
         * 点金我的佣金账户变动
         * @获取变动后金额
         *
         * ***/

        String clickCashAgent = "//*[@id=\"rest_system_agent_cash_list\"]/li/span";
        String inputBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String Inquire = "//*[@id=\"submit\"]/span";
        String clickCashBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[4]/div[2]/table/tbody/tr/td[1]/div/a/div/span";
        String settlement = "//*[@id=\"root\"]/section/section/main/div[2]/div[4]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/button/span";
        String settlementInput = "/html/body/div[4]/div/div[2]/div[1]/div/form/div[3]/div/div/input";
        String settlementSure = "/html/body/div[4]/div/div[3]/button[2]/span";
        String waitWithdrawCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[4]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/span";
        String lowerCommissionSettlementRecord = "//*[@id=\"rest_agent_withdraw_list\"]/li/span";
        String withdrawBeforeMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";
        String WithdrawalMoney1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div";
        String WithdrawalMoney2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[8]/div";
        String withdrawMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        String orderStatus = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[9]/div/div/span";

        //-------------------------------------------验证商户详情待结算佣金--下级佣金结算记录--------------------------------------------------

        @Features("平台管理员")
        @Stories("下级佣金结算记录")
        @Title("验证下级佣金结算记录变动前后金额计算和累计提款金额计算无误")
        @Test(priority = 1)
        public void waitWithdrawCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCashBusiness);
                Thread.sleep(2000);
                String getWaitWithdrawCommission = driverUtil.getTextByXpath(waitWithdrawCommission);
                System.out.println("现金商户待提现佣金："+getWaitWithdrawCommission);
                driverUtil.findElementByXpathAndClick(settlement);
                Thread.sleep(1000);
                driverUtil.findElementByXpathAndClearSendkeys(settlementInput,"100");
                driverUtil.findElementByXpathAndClick(settlementSure);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级佣金结算记录");
                driverUtil.findElementByXpathAndClick(lowerCommissionSettlementRecord);
                Thread.sleep(2000);
                String getWithdrawBeforeMoney = driverUtil.getTextByXpath(withdrawBeforeMoney);
                String getWithdrawMoney = driverUtil.getTextByXpath(withdrawMoney);
                System.out.println("下级佣金结算记录结算前余额："+getWithdrawBeforeMoney);
                System.out.println("结算金额："+getWithdrawMoney);
                //累计提款金额2减去结算金额等于累计提款金额1
                String getWithdrawalMoney1 = driverUtil.getTextByXpath(WithdrawalMoney1);
                String getWithdrawalMoney2 = driverUtil.getTextByXpath(WithdrawalMoney2);
                System.out.println("下级佣金结算记录累计提款金额1："+getWithdrawalMoney1);
                System.out.println("下级佣金结算记录累计提款金额2："+getWithdrawalMoney2);
                BigDecimal b1 = StringToNumber.toBigDecimal(getWithdrawalMoney1);
                BigDecimal b2 = StringToNumber.toBigDecimal(getWithdrawalMoney2);
                BigDecimal b3 = StringToNumber.toBigDecimal(getWithdrawMoney);
                String getOrderStatus = driverUtil.getTextByXpath(orderStatus);
                if (getOrderStatus.equals("上级结算")) {
                        BigDecimal result2 = b2.add(b3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getWaitWithdrawCommission, getWithdrawBeforeMoney);
                        Assertion.verifyEquals(result2, b1);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getOrderStatus.equals("上级结算")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getWaitWithdrawCommission, getWithdrawBeforeMoney);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


}
