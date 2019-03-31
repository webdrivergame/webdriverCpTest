package adminTestCase;

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
import java.text.SimpleDateFormat;
import java.util.Date;

public class cashModeComplexStatisticsTestCase {

        public WebDriver driver;

        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现金模式综合统计-验证登录人数数据")
        @Test(priority = 1)
        public void loginNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String loginNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[2]/div/span");
                System.out.println("现金综合统计登录人数："+loginNumber);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"opt_rest_login_statistic_cash\"]/li/span");
                        Thread.sleep(2000);
                String getDate = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                String getDate1 = getDate.replaceAll("-","");
                System.out.println("现金留存获取页面时间："+getDate1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("现金留存获取系统时间："+systemDate);
                if (getDate1.equals(systemDate)){
                        String loginNumber2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(loginNumber,loginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDate1.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",loginNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("去重");
                }
        }


        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现今模式综合统计-验证注册人数数据")
        @Test(priority = 2)
        public void registeredNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String registeredNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[3]/div/span");
                System.out.println("现金综合统计注册人数："+registeredNumber);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"opt_rest_login_statistic_cash\"]/li/span");
                        Thread.sleep(2000);
                String getDate = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                String getDate1 = getDate.replaceAll("-","");
                System.out.println("现金留存获取页面时间："+getDate1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("现金留存获取系统时间："+systemDate);
                if (getDate1.equals(systemDate)){
                        String loginNumber2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(registeredNumber,loginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDate1.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",registeredNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("去重2");
                }
        }


        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现金模式综合统计-验证活跃玩家和现金新增留存统计数据")
        @Test(priority = 3)
        public void activePlayers() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                Thread.sleep(3000);
                String activePlayers = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[4]/div/span");
                System.out.println("现金综合统计活跃玩家："+activePlayers);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"opt_rest_login_statistic_cash\"]/li/span");
                Thread.sleep(2000);
                String getDate = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                String getDate1 = getDate.replaceAll("-","");
                System.out.println("现金留存获取页面时间："+getDate1);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("现金留存获取系统时间："+systemDate);
                if (getDate1.equals(systemDate)){
                        String loginNumber2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(activePlayers,loginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDate1.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",activePlayers);
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("去重3");
                }

        }


        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现金模式综合统计-验证今日总充值金额数据")
        @Test(priority = 4)
        public void rechargeTotalToday() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String rechargeTotalToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[1]");
                BigDecimal a1 = StringToNumber.toBigDecimal(rechargeTotalToday);
                System.out.println("现金综合统计今日总充值金额："+a1);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金-充值提现记录");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
                        Thread.sleep(3000);
                String ArtificialRecharge = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/span[2]");
                BigDecimal b1 = StringToNumber.toBigDecimal(ArtificialRecharge);
                System.out.println("现金充值提现记录人工充值金额："+b1);
                String onlineRecharge = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[1]/span[2]");
                BigDecimal c1 = StringToNumber.toBigDecimal(onlineRecharge);
                System.out.println("现金充值提现记录在线充值金额："+c1);
                BigDecimal d1 = b1.add(c1);//总充值金额等于在线充值加人工充值
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,d1);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现金模式综合统计-验证今日充值人数")
        @Test(priority = 5)
        public void rechargeNumberTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String rechargeNumberTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[2]");
                System.out.println("现金综合统计今日总充值人数："+rechargeNumberTotal);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金-充值提现记录");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
                        Thread.sleep(3000);
                String rechargeNumberTotal2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[8]/span[2]");
                System.out.println("现金充值提现记录总充人数："+rechargeNumberTotal2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(rechargeNumberTotal,rechargeNumberTotal2);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台")
        @Story("现金模式综合统计")
        @Title("平台-现金模式综合统计-验证人均充值人数")
        @Test(priority = 6)
        public void rechargeNumberAverage() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_statistics_list\"]/li/span");
                Thread.sleep(3000);
                String rechargeTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[1]");
                String numberTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[2]");
                String rechargeNumberAverage = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[7]/div/span");
                BigDecimal a1 = StringToNumber.toBigDecimal(rechargeTotal);
                BigDecimal a2 = StringToNumber.toBigDecimal(numberTotal);
                BigDecimal a3 = StringToNumber.toBigDecimal(rechargeNumberAverage);
                System.out.println("总充值金额："+a1);
                System.out.println("总充值人数："+a2);
                System.out.println("人均充值金额："+a3);
                if (a1.equals("0.000")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,a3);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! a1.equals("0.000")){
                        BigDecimal a4 = a1.divide(a2);
                        System.out.println("总充值除以人数值："+a4);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a4,a3);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


}
