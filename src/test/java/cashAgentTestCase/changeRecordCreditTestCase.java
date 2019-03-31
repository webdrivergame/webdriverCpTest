package cashAgentTestCase;

import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import util.StringToNumber;

import java.math.BigDecimal;

public class changeRecordCreditTestCase {
        public WebDriver driver;
        @Feature("现金代理")
        @Story("额度变动记录")
        @Title("现金代理-额度变动记录-验证现金代理额度变动数据")
        @Test(priority = 1)
        public void cashAgentCredit() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_businessman_change_list\"]/li/span");
                Thread.sleep(2000);

                String a1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/span");
                String b1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div");
                String c1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div");
                String d1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div");
                BigDecimal operatingMoney = StringToNumber.toBigDecimal(b1);
                BigDecimal operatingMoneyBefore = StringToNumber.toBigDecimal(c1);
                BigDecimal operatingMoneyAfter = StringToNumber.toBigDecimal(d1);
                System.out.println("操作金额："+operatingMoney);
                System.out.println("操作前充值金额："+operatingMoneyBefore);
                System.out.println("操作后充值金额："+ operatingMoneyAfter);
                if(a1.equals("玩家充值")){
                        BigDecimal playerRechargeMoney = operatingMoneyBefore.subtract(operatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerRechargeMoney,operatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-玩家充值");
                }else if (a1.equals("转出")){
                        BigDecimal turnOut  = operatingMoneyBefore.subtract(operatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(turnOut,operatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-转出");
                }else if (a1.equals("转入")){
                        BigDecimal Into = operatingMoneyAfter.add(operatingMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(Into,operatingMoneyAfter);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：现金代理-转入");
                }
                driverUtil.LoginAfter();
        }


        @Feature("现金代理")
        @Story("额度变动记录")
        @Title("现金代理-额度变动记录-验证充值代理总管额度变动数据")
        @Test(priority = 2)
        public void rechargeAgentAdminCredit() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_businessman_change_list\"]/li/span");
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
                String a1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div");
                String b1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div");
                String c1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[6]/div");
                BigDecimal operatingMoney1 = StringToNumber.toBigDecimal(a1);
                BigDecimal operatingMoneyBefore1 = StringToNumber.toBigDecimal(b1);
                BigDecimal operatingMoneyAfter1 = StringToNumber.toBigDecimal(c1);
                BigDecimal Into = operatingMoneyBefore1.add(operatingMoney1);
                System.out.println("操作金额："+operatingMoney1);
                System.out.println("操作前充值金额："+operatingMoneyBefore1);
                System.out.println("操作后充值金额："+ operatingMoneyAfter1);
                System.out.println("结果等于操作后金额："+Into);
                Assertion.setFlag(true);
                Assertion.verifyEquals(Into,operatingMoneyAfter1);
                Assert.assertTrue(Assertion.currentFlag());
                System.out.println("操作类型：代理总管-转入");
                driverUtil.LoginAfter();
        }


        @Feature("现金代理")
        @Story("额度变动记录")
        @Title("现金代理-额度变动记录-验证充值代理额度变动数据")
        @Test(priority = 3)
        public void rechargeAgentCredit() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_recharge_withdraw\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_businessman_change_list\"]/li/span");
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
                String a1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div/span");
                String b1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div");
                String c1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div");
                String d1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div");
                BigDecimal operatingMoney2 = StringToNumber.toBigDecimal(b1);
                BigDecimal operatingMoneyBefore2 = StringToNumber.toBigDecimal(c1);
                BigDecimal operatingMoneyAfter2 = StringToNumber.toBigDecimal(d1);
                System.out.println("操作金额："+operatingMoney2);
                System.out.println("操作前充值金额："+operatingMoneyBefore2);
                System.out.println("操作后充值金额："+ operatingMoneyAfter2);
                if (a1.equals("玩家充值")){
                        BigDecimal playerRecharge2 = operatingMoneyBefore2.subtract(operatingMoney2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerRecharge2,operatingMoneyAfter2);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：充值代理-玩家充值");
                }else if (a1.equals("转入")){
                        BigDecimal Into2 = operatingMoneyBefore2.add(operatingMoney2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(Into2,operatingMoneyAfter2);
                        Assert.assertTrue(Assertion.currentFlag());
                        System.out.println("操作类型：充值代理-转入");
                }
                driverUtil.LoginAfter();



        }


}
