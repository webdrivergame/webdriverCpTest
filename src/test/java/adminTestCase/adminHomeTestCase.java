package adminTestCase;

import listenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import util.StringToNumber;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class adminHomeTestCase {

        public WebDriver driver;

        @Feature("平台")
        @Story("首页")
        @Title("平台首页-验证今日服务费收入与下级服务费金额是否一致")
        @Test(priority = 1)
        public void serviceIncomeToday() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);

                String serviceIncomeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[2]/div/div");
                System.out.println("首页-今日服务费收入："+serviceIncomeToday);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                        Thread.sleep(3000);
                String ServiceFeeIncomeToday2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[3]/span[2]");
                System.out.println("1.下级服务费-我的服务费总计："+ServiceFeeIncomeToday2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(serviceIncomeToday,ServiceFeeIncomeToday2);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台")
        @Story("首页")
        @Title("平台首页-验证服务费收入总计与下级服务费统计的生成服务费总计金额是否一致")
        @Test(priority = 2)
        public void sinceBusinessOperationsTotalArrears() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String SinceBusinessOperationsTotalArrears = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[2]/div/div");
                System.out.println("首页-服务费收入总计："+SinceBusinessOperationsTotalArrears);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                        Thread.sleep(3000);
                String SinceBusinessOperationsTotalArrears2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/span[2]");
                System.out.println("2.下级服务费统计："+SinceBusinessOperationsTotalArrears2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(SinceBusinessOperationsTotalArrears,SinceBusinessOperationsTotalArrears2);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("信用模式")
        @Title("平台首页-验证商户欠款总计与下级服务费结算记录总欠款是否一致")

        @Test(priority = 3)
        public void businessMoneyTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //判断首页商户欠款总计与下级服务费结算记录总欠款是否一致
                String businessMoneyTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[3]/div/div");
                System.out.println("首页-商户欠款总计："+businessMoneyTotal);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费结算记录");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record\"]/li/span");
                        Thread.sleep(3000);
                String businessMoneyTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/li/span[2]");
                System.out.println("3.下级服务费结算记录-总欠款："+businessMoneyTotal1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(businessMoneyTotal1,businessMoneyTotal);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("信用模式")
        @Title("平台首页-验证今日新增玩家与留存统计今日注册玩家数量是否一致")

        @Test(priority = 4)
        public void playerNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String playerNumberToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[5]/div/div");
                System.out.println("首页-今日新增玩家："+playerNumberToday);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_login_statistic\"]/li/span");
                        Thread.sleep(3000);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                Date date = new Date();//Date转换String
                String c1 = df.format(date);
                System.out.println("系统时间："+c1);// new Date()为获取当前系统时间
                String dateToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                System.out.println("获取时间："+dateToday);
                if (dateToday.equals(c1)){
                        String numberToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(playerNumberToday,numberToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! dateToday.equals(c1)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",playerNumberToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }
                driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("平台首页-验证今日系统盈亏与玩家输赢金额是否一致")

        @Test(priority = 5)
        public void systemWinOrLose() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //验证今日系统盈亏与玩家输赢统计金额是否一致
                String systemWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[7]/div/div");
                BigDecimal a1 = StringToNumber.toBigDecimal(systemWinOrLose).abs();
                System.out.println("首页-今日系统盈亏:"+a1);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_game_win_lose_list\"]/li/span");
                        Thread.sleep(3000);
                String playerWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[4]/span[2]");
                BigDecimal b1 = StringToNumber.toBigDecimal(playerWinOrLose).abs();
                System.out.println("现金玩家输赢统计:"+b1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,b1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();

        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("平台首页-验证今日佣金与下级佣金统计-商户今日佣金金额是否一致")

        @Test(priority = 6)
        public void todayCommission() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //验证今日佣金与下级佣金统计-商户今日佣金金额是否一致
                String commissionToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[8]/div/div");
                System.out.println("首页-今日佣金总计"+commissionToday);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                        Thread.sleep(3000);
                String businessCommissionToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[4]/span[2]");
                System.out.println("下级佣金统计："+businessCommissionToday);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(commissionToday,businessCommissionToday);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("平台首页-验证佣金总计与下级佣金统计-商户所占佣金金额是否一致")

        @Test(priority = 7)
        public void totalCommission() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //验证佣金总计与下级佣金统计-商户所占佣金金额是否一致
                String totalCommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[8]/div/div");
                System.out.println("首页-佣金总计："+totalCommission);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                        Thread.sleep(3000);
                String businessCommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[2]/span[2]");
                System.out.println("下级佣金统计："+businessCommission);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(totalCommission,businessCommission);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

        @Feature("平台首页")
        @Story("现金模式")
        @Title("平台首页-验证现今模式今日充值金额是否相等")

        @Test(priority = 8)
        public void rechargeMoneyToday() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //获取现今模式今日充值金额
                String rechargeMoneyToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[9]/div/div");
                BigDecimal a1 = StringToNumber.toBigDecimal(rechargeMoneyToday);
                System.out.println("首页-今日充值金额："+a1);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金-充值提现记录");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
                        Thread.sleep(3000);
                String rechargeTotalArtificial = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/span[2]");
                System.out.println("人工充值金额："+rechargeTotalArtificial);
                String rechargeTotalOnline = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[1]/span[2]");
                System.out.println("在线充值金额："+rechargeTotalOnline);
                //判断在线充值+人工充值是否等于首页今日总充值金额
                //BigDecimal a2 = new BigDecimal(rechargeTotalOnline);
                BigDecimal b1 = StringToNumber.toBigDecimal(rechargeTotalArtificial);
                BigDecimal total = b1.add(StringToNumber.toBigDecimal(rechargeTotalOnline));
                System.out.println("在线充值+人工充值总计金额："+total);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,total);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("平台首页-验证现金模式-今日提现金额是否相等")

        @Test(priority = 9)
        public void withdrawMoneyToday() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                //获取现今模式今日提现金额
                String withdrawMoneyToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[10]/div/div");
                BigDecimal a2 = StringToNumber.toBigDecimal(withdrawMoneyToday);
                System.out.println("首页-今日提现金额："+a2);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金-充值提现记录");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
                        Thread.sleep(3000);
                String withdrawTotalOnline = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[2]/span[2]");
                System.out.println("在线提现金额："+withdrawTotalOnline);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(withdrawMoneyToday,withdrawTotalOnline);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }



}