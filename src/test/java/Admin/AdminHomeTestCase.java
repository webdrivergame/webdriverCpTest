package Admin;

import ListenerPackage.Assertion;
import org.testng.annotations.BeforeTest;
import SeleniumMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import UtilTest.StringToNumber;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AdminHomeTestCase {

        public WebDriver driver;

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        @BeforeTest
            public void loginAdmin() throws InterruptedException {
                driverUtil.loginBefore(Url);
                driverUtil.adminLogin(username,password);
                driverUtil.findElementByXpathAndClick(login);
                Thread.sleep(4000);
        }


        /****
         *
         * @获取首页今日服务费收入
         * 点击下级服务费统计
         * @获取我的服务费总计
         *
         ****/

        String ServiceIncomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[2]/div/div";
        String clickLowerServiceStatistics = "//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span";
        String MyServiceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[3]/span[2]";

        //------------------------------------------------验证首页今日服务费收入--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日服务费收入与下级服务费统计-我的服务费总计金额数据")
        @Test(priority = 1)
            public void serviceIncomeToday() throws InterruptedException {
                String getServiceIncomeToday = driverUtil.getTextByXpath(ServiceIncomeToday);
                System.out.println("首页-今日服务费收入："+getServiceIncomeToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费统计");
                driverUtil.findElementByXpathAndClick(clickLowerServiceStatistics);
                Thread.sleep(3000);
                String getMyServiceTotal = driverUtil.getTextByXpath(MyServiceTotal);
                System.out.println("下级服务费统计-我的服务费总计："+getMyServiceTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getServiceIncomeToday,getMyServiceTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

          /***
           *
         * @获取首页服务费收入总计
         * 下级服务费统计
         * @获取生成服务费总计
           *
         ***/
        String ServiceIncomeTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[2]/div/div";
        String generateServiceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[1]/span[2]";

        //------------------------------------------------验证首页服务费收入总计--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证服务费收入总计与下级服务费统计的生成服务费总计金额数据")
        @Test(priority = 2)
            public void sinceBusinessOperationsTotalArrears() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getServiceIncomeTotal = driverUtil.getTextByXpath(ServiceIncomeTotal);
                System.out.println("首页-服务费收入总计："+getServiceIncomeTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费统计");
                driverUtil.findElementByXpathAndClick(clickLowerServiceStatistics);
                Thread.sleep(3000);
                String getGenerateServiceTotal = driverUtil.getTextByXpath(generateServiceTotal);
                System.out.println("下级服务费统计-生成服务费总计："+getGenerateServiceTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getServiceIncomeTotal,getGenerateServiceTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }


        /***
         *
         * @获取首页商务欠款总计
         * 下级服务费结算记录
         * @获取总欠款数据
         *
         * **/
        String businessMoneyTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[3]/div/div";
        String clickLowerServiceRecord = "//*[@id=\"rest_system_sub_agent_recharge_record\"]/li/span";
        String businessMoneyTotal1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div/li/span[2]";

        //------------------------------------------------验证首页商户欠款--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证商户欠款总计与下级服务费结算记录总欠款数据")
        @Test(priority = 3)
            public void businessMoneyTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getBusinessMoneyTotal = driverUtil.getTextByXpath(businessMoneyTotal);
                System.out.println("首页-商户欠款总计："+getBusinessMoneyTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费结算记录");
                driverUtil.findElementByXpathAndClick(clickLowerServiceRecord);
                Thread.sleep(3000);
                String getBusinessMoneyTotal1 = driverUtil.getTextByXpath(businessMoneyTotal1);
                System.out.println("下级服务费结算记录-总欠款："+getBusinessMoneyTotal1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBusinessMoneyTotal,getBusinessMoneyTotal1);
                Assert.assertTrue(Assertion.currentFlag());

        }

        /**
         * @获取首页今日新增玩家
         * 点击信用留存统计
         * 获取今日时间
         * @获取信用留存今日新增玩家
         *
         * **/
        String playerNumberToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[5]/div/div";
        String clickCreditRetainedStatistics = "//*[@id=\"rest_login_statistic\"]/li/span";
        String dateToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div";
        String registeredPlayerToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";

        //------------------------------------------------验证首页今日新增玩家--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日新增玩家与留存统计今日注册玩家数量是否一致")
        @Test(priority = 4)
            public void playerNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getPlayerNumberToday = driverUtil.getTextByXpath(playerNumberToday);
                System.out.println("首页-今日新增玩家："+getPlayerNumberToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(clickCreditRetainedStatistics);
                Thread.sleep(3000);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                Date date = new Date();//Date转换String
                String systemDate = df.format(date);// 获取当前系统时间
                System.out.println("系统时间："+systemDate);
                String getDateToday = driverUtil.getTextByXpath(dateToday);//获取页面时间
                System.out.println("获取时间："+getDateToday);
                if (getDateToday.equals(systemDate)){
                        String getNumberToday = driverUtil.getTextByXpath(registeredPlayerToday);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getPlayerNumberToday,getNumberToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",getPlayerNumberToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

         /***
         *
         * @获取首页系统输赢
         * 点击现金模式游戏输赢统计
         * @获取现金游戏玩家输赢金额
         *
         * **/

        String systemWinOrLose = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[7]/div/div";
        String clickCashModelGameLoseOrWin = "//*[@id=\"rest_cash_game_win_lose_list\"]/li/span";
        String cashModelGameLoseOrWin = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[4]/span[2]";

        //------------------------------------------------验证首页今日系统输赢--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日系统输赢与玩家输赢金额是否一致")
        @Test(priority = 5)
            public void systemWinOrLose() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getSystemWinOrLose = driverUtil.getTextByXpath(systemWinOrLose);
                BigDecimal a1 = StringToNumber.toBigDecimal(getSystemWinOrLose).abs();
                System.out.println("首页-今日系统盈亏:"+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCashModelGameLoseOrWin);
                Thread.sleep(3000);
                String getCashGameWinOrLose = driverUtil.getTextByXpath(cashModelGameLoseOrWin);
                BigDecimal b1 = StringToNumber.toBigDecimal(getCashGameWinOrLose).abs();
                System.out.println("现金玩家输赢统计:"+b1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,b1);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页今日佣金
         * 点击下级经营明细
         * @获取下级经营明细今日所有商户佣金
          *
         * **/

        String commissionToday ="//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[8]/div/div";
        String clickLowerRunDetails = "//*[@id=\"rest_cash_engage_detail_list\"]/li/span";
        String businessCommissionToday2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[13]/div";
        String businessCommissionToday3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[13]/div";
        String businessCommissionToday4 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[13]/div";

        //------------------------------------------------验证首页今日佣金--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日佣金与下级经营明细-商户今日佣金金额数据")
        @Test(priority = 6)
            public void todayCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getCommissionToday = driverUtil.getTextByXpath(commissionToday);
                System.out.println("首页-今日佣金总计"+getCommissionToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(clickLowerRunDetails);
                Thread.sleep(3000);
                String getBusinessCommissionToday2 = driverUtil.getTextByXpath(businessCommissionToday2);
                String getBusinessCommissionToday3 = driverUtil.getTextByXpath(businessCommissionToday3);
                String getBusinessCommissionToday4 = driverUtil.getTextByXpath(businessCommissionToday4);
                BigDecimal a2 = StringToNumber.toBigDecimal(getBusinessCommissionToday2);
                BigDecimal a3 = StringToNumber.toBigDecimal(getBusinessCommissionToday3);
                BigDecimal a4 = StringToNumber.toBigDecimal(getBusinessCommissionToday4);
                BigDecimal total= a2.add(a3).add(a4);
                System.out.println("下级佣金明细-今日所有商户佣金："+total);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getCommissionToday,total);
                        Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页佣金总计
         * 点金现金推广代理
         * @获取现金推广代理所有商户总佣金
         *
         * **/

        String totalCommission ="//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[2]/td[8]/div/div";
        String clickCashAgent ="//*[@id=\"rest_system_agent_cash_list\"]/li/span";
        String commissionTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[1]/div[3]/span[2]";

        //------------------------------------------------验证首页佣金总计--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证佣金总计与现金推广代理-所有商户总佣金")
        @Test(priority = 7)
            public void totalCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getTotalCommission = driverUtil.getTextByXpath(totalCommission);
                System.out.println("首页-佣金总计："+getTotalCommission);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(3000);
                String getBusinessCommission = driverUtil.getTextByXpath(commissionTotal);
                System.out.println("下级佣金统计："+getBusinessCommission);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getTotalCommission,getBusinessCommission);
                Assert.assertTrue(Assertion.currentFlag());

        }

         /***
         * @获取今日充值金额
         * 现金充值提现记录
         * @获取人工充值金额
         * @获取在线充值金额
         *
         * **/

        String rechargeMoneyToday ="//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[9]/div/div";
        String clickCashRechargeWithdrawRecord = "//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span";
        String rechargeTotalArtificial = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[3]/span[2]";
        String rechargeTotalOnline = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[1]/span[2]";

        //------------------------------------------------验证首页今日充值金额--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日充值金额是否等于现金充值记录的在线充值金额+人工充值金额")
        @Test(priority = 8)
            public void rechargeMoneyToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getRechargeMoneyToday = driverUtil.getTextByXpath(rechargeMoneyToday);
                BigDecimal a1 = StringToNumber.toBigDecimal(getRechargeMoneyToday);
                System.out.println("首页-今日充值金额："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金-充值提现记录");
                driverUtil.findElementByXpathAndClick(clickCashRechargeWithdrawRecord);
                Thread.sleep(3000);
                String getRechargeTotalArtificial = driverUtil.getTextByXpath(rechargeTotalArtificial);
                System.out.println("人工充值金额："+getRechargeTotalArtificial);
                String getRechargeTotalOnline = driverUtil.getTextByXpath(rechargeTotalOnline);
                System.out.println("在线充值金额："+getRechargeTotalOnline);
                BigDecimal b1 = StringToNumber.toBigDecimal(getRechargeTotalArtificial);
                BigDecimal total = b1.add(StringToNumber.toBigDecimal(getRechargeTotalOnline));
                System.out.println("在线充值+人工充值总计金额："+total);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,total);
                Assert.assertTrue(Assertion.currentFlag());

        }

         /***
         *
         * @获取首页提现金额
         *
         * @获取在线提现金额
         *
         * **/

        String withdrawMoneyToday ="//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[10]/div/div";
        String withdrawTotalOnline ="//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/div[1]/div[2]/span[2]";

        //------------------------------------------------验证首页今日提现金额--------------------------------------------------------

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证今日提现金额是否等于现金充值记录的在线提现金额")
        @Test(priority = 9)
            public void withdrawMoneyToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(3000);
                String getWithdrawMoneyToday = driverUtil.getTextByXpath(withdrawMoneyToday);
                System.out.println("首页-今日提现金额："+getWithdrawMoneyToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金-充值提现记录");
                driverUtil.findElementByXpathAndClick(clickCashRechargeWithdrawRecord);
                Thread.sleep(3000);
                String getWithdrawTotalOnline = driverUtil.getTextByXpath(withdrawTotalOnline);
                System.out.println("在线提现金额："+getWithdrawTotalOnline);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getWithdrawMoneyToday,getWithdrawTotalOnline);
                Assert.assertTrue(Assertion.currentFlag());
        }

}