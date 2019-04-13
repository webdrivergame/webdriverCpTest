package CashAgent;

import org.testng.annotations.BeforeTest;
import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import UtilTest.StringToNumber;

import java.math.BigDecimal;

public class ChangeRecordCreditTestCase {
        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://koudai.oneonewan.com/?#/login";
        String username = "44444";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";


         /***
         *
         * 点击额度变动记录
         * 获取操作类型
         * 获取操作金额
         * 获取操作前金额
         * @获取操作后金额
         *
         * ***/
        String CreditChangeRecord= "//*[@id=\"rest_businessman_change_list\"]/li/span";
        String operatingType = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/span";
        String operatingMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        String operatingMoneyBefore = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";
        String operatingMoneyAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div";

        //-----------------------------------------------------验证现金推广代理额度变动---------------------------------------------

        @Features("现金代理")
        @Stories("额度变动记录")
        @Title("验证现金代理额度变动数据增减金额是否有误")
        @Test(priority = 1)
        public void cashAgentCredit() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"额度变动记录");
                driverUtil.findElementByXpathAndClick(CreditChangeRecord);
                Thread.sleep(2000);
                String getOperatingType = driverUtil.getTextByXpath(operatingType);
                String a1 = driverUtil.getTextByXpath(operatingMoney);
                String b1 = driverUtil.getTextByXpath(operatingMoneyBefore);
                String c1 = driverUtil.getTextByXpath(operatingMoneyAfter);
                BigDecimal getOperatingMoney = StringToNumber.toBigDecimal(a1);
                BigDecimal getOperatingMoneyBefore = StringToNumber.toBigDecimal(b1);
                BigDecimal getOperatingMoneyAfter = StringToNumber.toBigDecimal(c1);
                System.out.println("操作金额："+getOperatingMoney);
                System.out.println("操作前充值金额："+getOperatingMoneyBefore);
                System.out.println("操作后充值金额："+ getOperatingMoneyAfter);
                if(getOperatingType.equals("玩家充值")){
                        BigDecimal playerRechargeMoney = getOperatingMoneyBefore.subtract(getOperatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerRechargeMoney,getOperatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-玩家充值");
                }else if (getOperatingType.equals("转出")){
                        BigDecimal turnOut  = getOperatingMoneyBefore.subtract(getOperatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(turnOut,getOperatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-转出");
                }else if (getOperatingType.equals("转入")){
                        BigDecimal Into = getOperatingMoneyBefore.add(getOperatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(Into,getOperatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-转入");
                }

        }

         /***
         *
         * 点击充值代理总管
         * 获取操作类型
         * 获取操作金额
         * 获取操作前金额
         * @获取操作后金额
         * ***/
        String clickRechargeAgentBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span";
        String OperatingType2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/div/span";
        String OperatingMoney2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div";
        String operatingMoneyBefore2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div";
        String operatingMoneyAfter2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[6]/div";

        //----------------------------------------------------验证充值代理总管额度记录---------------------------------------------

        @Features("现金代理")
        @Stories("额度变动记录")
        @Title("验证充值代理总管额度变动数据")
        @Test(priority = 2)
        public void rechargeAgentAdminCredit() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(clickRechargeAgentBusiness);
                Thread.sleep(2000);
                String a2 = driverUtil.getTextByXpath(OperatingMoney2);
                String b2 = driverUtil.getTextByXpath(operatingMoneyBefore2);
                String c2 = driverUtil.getTextByXpath(operatingMoneyAfter2);
                BigDecimal getOperatingMoney2 = StringToNumber.toBigDecimal(a2);
                BigDecimal getOperatingMoneyBefore2 = StringToNumber.toBigDecimal(b2);
                BigDecimal getOperatingMoneyAfter2 = StringToNumber.toBigDecimal(c2);
                BigDecimal Into = getOperatingMoneyBefore2.add(getOperatingMoney2);
                System.out.println("操作金额："+getOperatingMoney2);
                System.out.println("操作前充值金额："+getOperatingMoneyBefore2);
                System.out.println("操作后充值金额："+ getOperatingMoneyAfter2);
                System.out.println("结果等于操作后金额："+Into);
                Assertion.setFlag(true);
                Assertion.verifyEquals(Into,getOperatingMoneyAfter2);
                Assert.assertTrue(Assertion.currentFlag());
                System.out.println("操作类型：代理总管-转入");

        }


        String clickRechargeAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span";
        String OperatingType3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/span";
        String OperatingMoney3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        String OperatingMoneyBefore3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";
        String OperatingMoneyAfter3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div";


        @Features("现金代理")
        @Stories("额度变动记录")
        @Title("验证充值代理额度变动数据")
        @Test(priority = 3)
        public void rechargeAgentCredit() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(clickRechargeAgent);
                Thread.sleep(2000);
                String getOperatingType3 = driverUtil.getTextByXpath(OperatingType3);
                String a3 = driverUtil.getTextByXpath(OperatingMoney3);
                String b3 = driverUtil.getTextByXpath(OperatingMoneyBefore3);
                String c3 = driverUtil.getTextByXpath(OperatingMoneyAfter3);
                BigDecimal getOperatingMoney3 = StringToNumber.toBigDecimal(a3);
                BigDecimal getOperatingMoneyBefore3 = StringToNumber.toBigDecimal(b3);
                BigDecimal getOperatingMoneyAfter3 = StringToNumber.toBigDecimal(c3);
                System.out.println("操作金额："+getOperatingMoney3);
                System.out.println("操作前充值金额："+getOperatingMoneyBefore3);
                System.out.println("操作后充值金额："+ getOperatingMoneyAfter3);
                if (getOperatingType3.equals("玩家充值")){
                        BigDecimal playerRecharge2 = getOperatingMoneyBefore3.subtract(getOperatingMoney3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerRecharge2,getOperatingMoneyAfter3);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：充值代理-玩家充值");
                }else if (getOperatingType3.equals("转入")){
                        BigDecimal Into2 = getOperatingMoneyBefore3.add(getOperatingMoney3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(Into2,getOperatingMoneyAfter3);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：充值代理-转入");
                }


        }


}
