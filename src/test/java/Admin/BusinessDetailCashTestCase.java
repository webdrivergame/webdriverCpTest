package Admin;

import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;

import java.math.BigDecimal;

public class BusinessDetailCashTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";


         /***
         *
         * 点击现金推广代理
         * 输入商户qaxjtg01
         * 查询
         * @获取商户推广玩家总数
         * 点击玩家总数跳转
         * @获取玩家管理商户总人数
         *
         * ***/

        String clickCashAgent = "//*[@id=\"rest_system_agent_cash_list\"]/li/span";
        String inputBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String Inquire = "//*[@id=\"submit\"]/span";
        String businessPlayerTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[6]/div/a";
        String PlayerAdminNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        //---------------------------------------------验证商户详情推广玩家总数----------------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证推广玩家总数")
        @Test(priority = 10)
        public void BusinessPlayerTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getBusinessPlayerTotal = driverUtil.getTextByXpath(businessPlayerTotal);
                System.out.println("商户推广玩家总数："+getBusinessPlayerTotal);
                driverUtil.findElementByXpathAndClick(businessPlayerTotal);
                Thread.sleep(4000);
                String getPlayerAdminNumber = driverUtil.getTextByXpath(PlayerAdminNumber);
                String a1 = getPlayerAdminNumber.substring(2,getPlayerAdminNumber.indexOf(" 条"));
                System.out.println("玩家管理商户人数："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getBusinessPlayerTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取现金商户详情税收总计
         * 点击下级经营明细
         * 查询商户
         * @获取下级经营明细现今商户税收总计
         *
         * ***/

        String businessTaxTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[7]/div";
        String lowerRunDetails = "//*[@id=\"rest_cash_engage_detail_list\"]/li/span";
        String inputLowerRunDetails = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String inquire = "//*[@id=\"submit\"]/span";
        String lowerRunDetailsTax= "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr/td[6]/div";

        //----------------------------------------------验证现金商户详情税收总计-----------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证商户税收总计金额是否与下级经营明细该商户税收总计一致")
        @Test(priority = 11)
        public void businessTaxTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getBusinessTaxTotal = driverUtil.getTextByXpath(businessTaxTotal);
                System.out.println("现今商户税收总计："+getBusinessTaxTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(lowerRunDetails);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputLowerRunDetails,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(inquire);
                Thread.sleep(2000);
                String getLowerRunDetailsTax = driverUtil.getTextByXpath(lowerRunDetailsTax);
                System.out.println("下级经营明细商户税收总计："+getLowerRunDetailsTax);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBusinessTaxTotal,getLowerRunDetailsTax);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取现今商户佣金总计
         *
         * @获取下级经营明细商户佣金总计
         *
         * ***/

         String businessCommissionTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[9]/div/div/span";
         String lowerCommissionTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr/td[7]/div";

        //--------------------------------------------验证现金商户详情佣金总计-----------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证现今商户佣金总计与下级经营明细佣金是否一致")
        @Test(priority = 12)
        public void businessCommissionTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getBusinessCommissionTotal = driverUtil.getTextByXpath(businessCommissionTotal);
                System.out.println("现金商户佣金总计："+getBusinessCommissionTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(lowerRunDetails);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputLowerRunDetails,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(inquire);
                Thread.sleep(2000);
                String getLowerCommissionTotal = driverUtil.getTextByXpath(lowerCommissionTotal);
                System.out.println("现金商户下级经营明细佣金总计:"+getLowerCommissionTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBusinessCommissionTotal,getLowerCommissionTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

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

        String clickCashBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[4]/div[2]/table/tbody/tr/td[1]/div/a/div/span";
        String settlement = "//*[@id=\"root\"]/section/section/main/div[2]/div[4]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/button/span";
        String settlementInput = "/html/body/div[4]/div/div[2]/div[1]/div/form/div[3]/div/div/input";
        String settlementSure = "/html/body/div[4]/div/div[3]/button[2]/span";
        String waitWithdrawCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[4]/div/div/div[2]/div/div[2]/div/div/form/div[8]/div/span";
        //下级佣金结算记录-结算前金额
        String lowerCommissionSettlementRecord = "//*[@id=\"rest_agent_withdraw_list\"]/li/span";
        //String inputLowerCommissionSettlementRecord = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String settlementBeforeBalance1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";
        String SettlementMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        //下级佣金结算记录-累计提款金额
        String WithdrawalMoney1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div";
        String WithdrawalMoney2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[8]/div";

        //-------------------------------------------验证商户详情待结算佣金--下级佣金结算记录--------------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证1下级佣金结算记录变动前后金额计算无误,2累计提款金额计算无误")
        @Test(priority = 13)
        public void waitWithdrawCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"qaxjtg01");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCashBusiness);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(settlement);
                driverUtil.findElementByXpathAndClearSendkeys(settlementInput,"100");
                driverUtil.findElementByXpathAndClick(settlementSure);
                Thread.sleep(2000);
                String getWaitWithdrawCommission = driverUtil.getTextByXpath(waitWithdrawCommission);
                System.out.println("现金商户待提现佣金："+getWaitWithdrawCommission);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级佣金结算记录");
                driverUtil.findElementByXpathAndClick(lowerCommissionSettlementRecord);
                Thread.sleep(2000);
                //driverUtil.findElementByXpathAndClearSendkeys(inputLowerCommissionSettlementRecord,"qaxjtg01");
                //driverUtil.findElementByXpathAndClick(inquire);
                //Thread.sleep(2000);

                //结算前金额2减去结算金额等于结算金额1
                String getSettlementBeforeBalance1 = driverUtil.getTextByXpath(settlementBeforeBalance1);
                String getSettlementMoney = driverUtil.getTextByXpath(SettlementMoney);
                System.out.println("下级佣金结算记录变动前余额1："+getSettlementBeforeBalance1);
                System.out.println("下级佣金结算记录结算金额："+getSettlementMoney);
                BigDecimal a1 = StringToNumber.toBigDecimal(getSettlementBeforeBalance1);
                BigDecimal a2 = StringToNumber.toBigDecimal(getWaitWithdrawCommission);
                BigDecimal a3 = new BigDecimal(getSettlementMoney).abs();
                BigDecimal result = a2.subtract(a3);

                //累计提款金额2减去结算金额等于累计提款金额1
                String getWithdrawalMoney1 = driverUtil.getTextByXpath(WithdrawalMoney1);
                String getWithdrawalMoney2 = driverUtil.getTextByXpath(WithdrawalMoney2);
                System.out.println("下级佣金结算记录累计提款金额1："+getWithdrawalMoney1);
                System.out.println("下级佣金结算记录累计提款金额2："+getWithdrawalMoney2);
                BigDecimal b1 = StringToNumber.toBigDecimal(getWithdrawalMoney1);
                BigDecimal b2 = StringToNumber.toBigDecimal(getWithdrawalMoney2);
                BigDecimal result2 = b2.add(a3);
                Assertion.setFlag(true);
                Assertion.verifyEquals(result,a1);
                Assertion.verifyEquals(result2,b1);
                Assert.assertTrue(Assertion.currentFlag());
        }

}
