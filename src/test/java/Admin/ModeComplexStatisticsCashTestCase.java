package Admin;

import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import UtilTest.StringToNumber;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeComplexStatisticsCashTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";


        /***
         *
         * 点击现金综合统计报表
         * @获取现金综合统计今日登录人数
         * 点金现金留存统计
         * 获取今日时间
         * @获取现金留存统计今日登录人数
         *
         *  ***/

        String clickCashModelComplexStatistics = "//*[@id=\"rest_system_statistics_list\"]/li/span";
        String loginNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[2]/div/span";
        String cashRetainedStatistics = "//*[@id=\"opt_rest_login_statistic_cash\"]/li/span";
        String dateToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div";
        String loginNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";

        //------------------------------------------------验证现金综合统计今日登录人数------------------------------------------------

        @Features("平台管理员")
        @Stories("现金模式综合统计")
        @Title("验证登录人数是否等于留存登录人数数据")
        @Test(priority = 1)
        public void loginNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCashModelComplexStatistics);
                Thread.sleep(3000);
                String getLoginNumber = driverUtil.getTextByXpath(loginNumber);
                System.out.println("现金综合统计登录人数："+getLoginNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金留存统计");
                driverUtil.findElementByXpathAndClick(cashRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("现金留存获取页面时间："+getDateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("现金留存获取系统时间："+systemDate);
                if (getDateToday.equals(systemDate)){
                        String getLoginNumber2 = driverUtil.getTextByXpath(loginNumber2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getLoginNumber,getLoginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",getLoginNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("去重");
                }
        }

        /***
         *
         * 点击现金综合统计报表
         * @获取现金综合统计今日注册人数
         * 点金现金留存统计
         * 获取今日时间
         * @获取现金留存统计今日新增人数
         *
         *  ***/

        String registeredNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[3]/div/span";
        String loginNumber3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";

        //------------------------------------------------验证现金综合统计今日注册人数------------------------------------------------

        @Features("平台管理员")
        @Stories("现金模式综合统计")
        @Title("验证注册人数是否等于现金留存数据")
        @Test(priority = 2)
        public void registeredNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCashModelComplexStatistics);
                Thread.sleep(3000);
                String getRegisteredNumber = driverUtil.getTextByXpath(registeredNumber);
                System.out.println("现金综合统计注册人数："+getRegisteredNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金留存统计");
                driverUtil.findElementByXpathAndClick(cashRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("现金留存获取页面时间："+getDateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("现金留存获取系统时间："+systemDate);
                if (getDateToday.equals(systemDate)){
                        String getLoginNumber3 = driverUtil.getTextByXpath(loginNumber3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getRegisteredNumber,getLoginNumber3);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",getRegisteredNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("去重2");
                }
        }

         /***
         *
         * @获取现金综合统计今日充值
         * 点击现金充值提现记录
         * 获取人工充值金额
         * 获取在线充值金额
         * @人工充值+在线充值
         *
         *  ***/

        String rechargeTotalToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[1]";
        String clickCashRechargeWithdrawRecord = "//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span";
        String ArtificialRecharge = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/span[2]";
        String onlineRecharge = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[1]/span[2]";

        //----------------------------------------------------验证现金综合统计总充值------------------------------------------------

        @Features("平台管理员")
        @Stories("现金模式综合统计")
        @Title("验证今日总充值金额数据是否等于现金充值记录今日充值金额")
        @Test(priority = 4)
        public void rechargeTotalToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCashModelComplexStatistics);
                Thread.sleep(3000);
                String getRechargeTotalToday = driverUtil.getTextByXpath(rechargeTotalToday);
                BigDecimal a1 = StringToNumber.toBigDecimal(getRechargeTotalToday);
                System.out.println("现金综合统计今日总充值金额："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金-充值提现记录");
                driverUtil.findElementByXpathAndClick(clickCashRechargeWithdrawRecord);
                Thread.sleep(3000);
                String getArtificialRecharge = driverUtil.getTextByXpath(ArtificialRecharge);
                BigDecimal b1 = StringToNumber.toBigDecimal(getArtificialRecharge);
                System.out.println("现金充值提现记录人工充值金额："+b1);
                String getOnlineRecharge = driverUtil.getTextByXpath(onlineRecharge);
                BigDecimal c1 = StringToNumber.toBigDecimal(getOnlineRecharge);
                System.out.println("现金充值提现记录在线充值金额："+c1);
                BigDecimal d1 = b1.add(c1);//总充值金额等于在线充值加人工充值
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,d1);
                Assert.assertTrue(Assertion.currentFlag());
        }


         /***
         *
         * @获取现金综合统计今日充值人数
         * @获取现金充值提现记录今日充值人数
         *
         * ***/

        String rechargeNumberTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[2]";
        String rechargeNumberTotal2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[8]/span[2]";

        //----------------------------------------------------验证现金综合统计今日充值人数-----------------------------------------------

        @Features("平台管理员")
        @Stories("现金模式综合统计")
        @Title("验证今日充值人数是否等于总充人数")
        @Test(priority = 5)
        public void rechargeNumberTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCashModelComplexStatistics);
                Thread.sleep(3000);
                String getRechargeNumberTotal = driverUtil.getTextByXpath(rechargeNumberTotal);
                System.out.println("现金综合统计今日总充值人数："+getRechargeNumberTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金-充值提现记录");
                driverUtil.findElementByXpathAndClick(clickCashRechargeWithdrawRecord);
                Thread.sleep(3000);
                String getRechargeNumberTotal2 = driverUtil.getTextByXpath(rechargeNumberTotal2);
                System.out.println("现金充值提现记录总充人数："+getRechargeNumberTotal2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getRechargeNumberTotal,getRechargeNumberTotal2);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取总充值金额
         * @获取充值人数
         * @获取人均充值金额
         *
         * ***/

        String rechargeTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[1]";
        String numberTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span[2]";
        String rechargeNumberAverage = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[7]/div/span";

        //----------------------------------------------------验证现金综合统计人均充值------------------------------------------------

        @Features("平台管理员")
        @Stories("现金模式综合统计")
        @Title("验证人均充值金额是否等于总充金额/人数")
        @Test(priority = 6)
        public void rechargeNumberAverage() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCashModelComplexStatistics);
                Thread.sleep(3000);
                String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
                String getNumberTotal = driverUtil.getTextByXpath(numberTotal);
                String getRechargeNumberAverage = driverUtil.getTextByXpath(rechargeNumberAverage);
                BigDecimal a1 = StringToNumber.toBigDecimal(getRechargeTotal);
                BigDecimal a2 = StringToNumber.toBigDecimal(getNumberTotal);
                BigDecimal a3 = StringToNumber.toBigDecimal(getRechargeNumberAverage);
                System.out.println("总充值金额："+a1);
                System.out.println("总充值人数："+a2);
                System.out.println("人均充值金额："+a3);
                if (a1.equals("0.000")){
                       System.out.println("总充值金额为：0.000");
                }else if (! a1.equals("0.000")){
                        BigDecimal a4 = a1.divide(a2);
                        System.out.println("总充值除以人数值："+a4);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a4,a3);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


}
