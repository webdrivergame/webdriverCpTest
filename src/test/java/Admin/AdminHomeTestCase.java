package Admin;

import ListenerPackage.Assertion;
import org.testng.annotations.AfterTest;
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
                System.out.println("下级服务费统计-今日服务费："+getMyServiceTotal);
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
        String ServiceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[3]/span[2]";

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
                BigDecimal a1 = StringToNumber.toBigDecimal(getServiceIncomeTotal).abs();
                System.out.println("首页-服务费收入总计："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费统计");
                driverUtil.findElementByXpathAndClick(clickLowerServiceStatistics);
                Thread.sleep(3000);
                String getGenerateServiceTotal = driverUtil.getTextByXpath(generateServiceTotal);
                String getServiceToday = driverUtil.getTextByXpath(ServiceToday);
                BigDecimal a2 = StringToNumber.toBigDecimal(getGenerateServiceTotal).abs();
                BigDecimal b1 = StringToNumber.toBigDecimal(getServiceToday).abs();
                BigDecimal result = a1.add(b1);
                System.out.println("下级服务费统计我的服务费总计+今日服务费："+result);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,result);
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
                BigDecimal a1 = new BigDecimal(getCommissionToday);
                System.out.println("首页-今日佣金总计"+a1);
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
                        Assertion.verifyEquals(a1,total);
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
        @Test(enabled = false)
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


         /***
         *
         * 点击详情
         * @获取商户待结算佣金
         * 现金代理
         * @获取商户待结算佣金
         *
         * ***/

        String detail = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div/button/span";
        String waitRechargeCommissionHome = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[3]/table/tbody/tr[3]/td[8]/div";
        String cashAgent = "//*[@id=\"rest_system_agent_cash_list\"]/li/span";
        String waitRechargeCommissionAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[10]/div/div/span";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证商户详情待提现佣金金额")
        @Test(priority = 10)
        public void waitRechargeCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(detail);
                Thread.sleep(2000);
                String getWaitRechargeCommissionHome = driverUtil.getTextByXpath(waitRechargeCommissionHome);
                System.out.println("首页商户详情待结算佣金："+getWaitRechargeCommissionHome);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(cashAgent);
                Thread.sleep(2000);
                String getWaitRechargeCommissionAgent = driverUtil.getTextByXpath(waitRechargeCommissionAgent);
                System.out.println("现金代理商户待结算佣金："+getWaitRechargeCommissionAgent);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getWaitRechargeCommissionHome,getWaitRechargeCommissionAgent);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * 点击首页详情
         * @获取现金商户玩家数量
         * @获取现金代理玩家数量
         * @获取下级经营明细玩家数量
         *
         * ***/

        String playerNumberDetail = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[3]/table/tbody/tr[3]/td[3]/div";
        String playerNumberCashAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[6]/div/a";
        String lowerRunDetail = "//*[@id=\"rest_cash_engage_detail_list\"]/li/span";
        String playerNumberLowerRunDetail = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[4]/div/span";


        @Features("平台管理员")
        @Stories("首页")
        @Title("验证详情现金商户玩家人数与代理管理，下级经营明细玩家数量")
        @Test(priority = 11)
        public void playerNumberDetail() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(detail);
                Thread.sleep(2000);
                String getPlayerNumberDetail = driverUtil.getTextByXpath(playerNumberDetail);
                System.out.println("首页详情玩家人数："+getPlayerNumberDetail);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(cashAgent);
                Thread.sleep(2000);
                String getPlayerNumberCashAgent = driverUtil.getTextByXpath(playerNumberCashAgent);
                System.out.println("现金推广代理玩家人数："+getPlayerNumberCashAgent);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(lowerRunDetail);
                Thread.sleep(2000);
                String getPlayerNumberLowerRunDetail = driverUtil.getTextByXpath(playerNumberLowerRunDetail);
                System.out.println("下级经营明细玩家人数："+getPlayerNumberLowerRunDetail);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getPlayerNumberDetail,getPlayerNumberCashAgent,getPlayerNumberLowerRunDetail);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /***
         *
         * @获取首页今日信用模式税收
         * 信用模式输赢统计
         * @获取信用模式输赢统计今日税收
         *
         * ***/

        String creditModelTaxMoneyTodayHome = "//*[@id=\"pane-1\"]/div/div[2]/div/div/div[1]/span[2]";
        String clickCreditModelLoseOrWin = "//*[@id=\"rest_game_win_lose_list\"]/li/span";
        String taxWinOrLose = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[6]/span[2]";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证税收趋势图-今日信用模式税收金额")
        @Test(priority = 12)
        public void creditModelTaxMoneyToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                String getCreditModelTaxMoneyTodayHome = driverUtil.getTextByXpath(creditModelTaxMoneyTodayHome);
                String a1 = getCreditModelTaxMoneyTodayHome.substring(2);
                System.out.println("首页今日信用模式税收："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelLoseOrWin);
                Thread.sleep(2000);
                String getTaxWinOrLose = driverUtil.getTextByXpath(taxWinOrLose);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getTaxWinOrLose);
                Assert.assertTrue(Assertion.currentFlag());
        }


        /***
         *
         * @获取首页今日现金模式税收
         * 信用模式输赢统计
         * @获取现金模式输赢统计今日税收
         *
         * ***/

        String cashModelTaxMoneyTodayHome = "//*[@id=\"pane-1\"]/div/div[2]/div/div/div[2]/span[2]";
        String clickCashModelLoseOrWin = "//*[@id=\"rest_cash_game_win_lose_list\"]/li/span";
        String taxWinOrLoseCash = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[6]/span[2]";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证税收趋势图-今日现金模式税收金额")
        @Test(priority = 12)
        public void cashModelTaxMoneyToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                String getCashModelTaxMoneyTodayHome = driverUtil.getTextByXpath(cashModelTaxMoneyTodayHome);
                String a1 = getCashModelTaxMoneyTodayHome.substring(2);
                System.out.println("首页今日现金模式税收："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCashModelLoseOrWin);
                Thread.sleep(2000);
                String getTaxWinOrLoseCash = driverUtil.getTextByXpath(taxWinOrLoseCash);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getTaxWinOrLoseCash);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /***
         *
         * 系统输赢趋势
         * @获取今日信用模式系统输赢
         * 信用模式输赢统计
         * @获取信用模式输赢统计今日输赢
         *
         * ***/

        String creditModelSystemLoseOrWinTodayHome = "//*[@id=\"pane-2\"]/div/div[2]/div/div/div[1]/span[2]";
        String clickCreditModelSystemLoseOrWinTodayHome = "//*[@id=\"tab-2\"]";
        String creditModelSystemLoseOrWinToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[4]/span[2]";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证系统输赢趋势图-信用模式今日系统输赢")
        @Test(priority = 13)
        public void creditModelSystemLoseOrWinToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCreditModelSystemLoseOrWinTodayHome);
                String getCreditModelSystemLoseOrWinTodayHome = driverUtil.getTextByXpath(creditModelSystemLoseOrWinTodayHome);
                String a1 = getCreditModelSystemLoseOrWinTodayHome.substring(2);
                System.out.println("首页今日信用模式系统输赢："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelLoseOrWin);
                Thread.sleep(2000);
                String getCreditModelSystemLoseOrWinToday = driverUtil.getTextByXpath(creditModelSystemLoseOrWinToday);
                BigDecimal b1 = new BigDecimal(getCreditModelSystemLoseOrWinToday).abs();
                System.out.println("信用模式游戏输赢统计："+b1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,b1);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /***
         *
         * 系统输赢趋势
         * @获取今日信用模式系统输赢
         * 信用模式输赢统计
         * @获取信用模式输赢统计今日输赢
         *
         * ***/

        String cashModelSystemLoseOrWinTodayHome = "//*[@id=\"pane-2\"]/div/div[2]/div/div/div[2]/span[2]";
        String clickCashModelSystemLoseOrWinTodayHome = "//*[@id=\"tab-2\"]";
        String cashModelSystemLoseOrWinToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[4]/span[2]";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证系统输赢趋势图-现金模式今日系统输赢")
        @Test(priority = 14)
        public void cashModelSystemLoseOrWinToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCashModelSystemLoseOrWinTodayHome);
                String getCashModelSystemLoseOrWinTodayHome = driverUtil.getTextByXpath(cashModelSystemLoseOrWinTodayHome);
                String a1 = getCashModelSystemLoseOrWinTodayHome.substring(2);
                System.out.println("首页今日现金模式系统输赢："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCashModelLoseOrWin);
                Thread.sleep(2000);
                String getCashModelSystemLoseOrWinToday = driverUtil.getTextByXpath(cashModelSystemLoseOrWinToday);
                BigDecimal b1 = new BigDecimal(getCashModelSystemLoseOrWinToday).abs();
                System.out.println("信用模式游戏输赢统计："+b1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,b1);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * 玩家登录趋势
         * @获取信用玩家今日登录人数
         * 信用留存统计
         * @获取信用留存统计今日登录人数
         *
         * ***/

        String clickCreditPlayerLoginNumberToday = "//*[@id=\"tab-3\"]";
        String creditPlayerLoginNumberToday = "//*[@id=\"pane-3\"]/div/div[2]/div/div/div[1]/span[2]";
        String creditRetainStatistics = "//*[@id=\"rest_login_statistic\"]/li/span";
        String creditRetainStatisticsAddToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证玩家登录趋势-信用玩家今日登录人数")
        @Test(priority = 15)
        public void creditPlayerLoginNumberToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCreditPlayerLoginNumberToday);
                String getCreditPlayerLoginNumberToday = driverUtil.getTextByXpath(creditPlayerLoginNumberToday);
                String a1 = getCreditPlayerLoginNumberToday.substring(0,getCreditPlayerLoginNumberToday.indexOf("人"));
                System.out.println("信用玩家今日登录人数："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainStatistics);
                Thread.sleep(2000);
                String getCreditRetainStatisticsAddToday = driverUtil.getTextByXpath(creditRetainStatisticsAddToday);
                System.out.println("信用留存今日新增玩家："+getCreditRetainStatisticsAddToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getCreditRetainStatisticsAddToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /***
         *
         * 玩家登录趋势
         * @获取现金玩家今日登录人数
         * 信用留存统计
         * @获取现金留存统计今日登录人数
         *
         * ***/

        String clickCashPlayerLoginNumberToday = "//*[@id=\"tab-3\"]";
        String cashPlayerLoginNumberToday = "//*[@id=\"pane-3\"]/div/div[2]/div/div/div[2]/span[2]";
        String cashRetainStatistics = "//*[@id=\"opt_rest_login_statistic_cash\"]/li/span";
        String cashRetainStatisticsLoginToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证玩家登录趋势-现金玩家今日登录人数")
        @Test(priority = 15)
        public void cashPlayerLoginNumberToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCashPlayerLoginNumberToday);
                String getCashPlayerLoginNumberToday = driverUtil.getTextByXpath(cashPlayerLoginNumberToday);
                String a1 = getCashPlayerLoginNumberToday.substring(0,getCashPlayerLoginNumberToday.indexOf("人"));
                System.out.println("现金玩家今日登录人数："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金留存统计");
                driverUtil.findElementByXpathAndClick(cashRetainStatistics);
                Thread.sleep(2000);
                String getCashRetainStatisticsAddToday = driverUtil.getTextByXpath(cashRetainStatisticsLoginToday);
                System.out.println("信用留存今日新增玩家："+getCashRetainStatisticsAddToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getCashRetainStatisticsAddToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

        String clickAddPlayer = "//*[@id=\"tab-4\"]";
        String creditAddPlayerHome = "//*[@id=\"pane-4\"]/div/div[2]/div/div/div[1]/span[2]";
        String cashAddPlayerHome = "//*[@id=\"pane-4\"]/div/div[2]/div/div/div[2]/span[2]";
        String creditAddPlayerRetain = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";
        String cashAddPlayerRetain = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证玩家新增趋势-信用和现金今日注册玩家")
        @Test(priority = 16)
        public void addPlayerToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickAddPlayer);
                Thread.sleep(2000);
                String getCreditAddPlayerHome = driverUtil.getTextByXpath(creditAddPlayerHome);
                String getCashAddPlayerHome = driverUtil.getTextByXpath(cashAddPlayerHome);
                String a1 = getCreditAddPlayerHome.substring(0,getCreditAddPlayerHome.indexOf("人"));
                String a2 = getCashAddPlayerHome.substring(0,getCashAddPlayerHome.indexOf("人"));
                System.out.println("信用首页今日注册玩家："+a1);
                System.out.println("现金首页今日注册玩家："+a2);
                driverUtil.findElementByXpathAndClick(creditRetainStatistics);
                Thread.sleep(2000);
                String getCreditAddPlayerRetain = driverUtil.getTextByXpath(creditAddPlayerRetain);
                driverUtil.findElementByXpathAndClick(cashRetainStatistics);
                Thread.sleep(2000);
                String getCashAddPlayerRetain = driverUtil.getTextByXpath(cashAddPlayerRetain);
                System.out.println("信用留存今日新增："+getCreditAddPlayerRetain);
                System.out.println("现金留存今日新增："+getCashAddPlayerRetain);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getCreditAddPlayerRetain);
                Assertion.verifyEquals(a2,getCashAddPlayerRetain);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * 点击首页信用充值提现趋势
         * @获取信用今日充值提现金额
         * 额度刷新列表
         * @获取加分总计和减分总计
         *
         * ***/

        String clickCreditRechargeWithdraw = "//*[@id=\"tab-5\"]";
        String creditRecharge = "//*[@id=\"pane-5\"]/div/div[2]/div/div/div[1]/span[2]";
        String creditWithdraw = "//*[@id=\"pane-5\"]/div/div[2]/div/div/div[2]/span[2]";
        String creditRefreshRecord = "//*[@id=\"rest_bind_name_list\"]/li/span";
        String addPoint = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/span[2]";
        String minusPoint = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[1]/div/div[1]/div[2]/span[2]";

        @Features("平台管理员")
        @Stories("首页")
        @Title("验证信用模式充值提现趋势-今日充值提现")
        @Test(priority = 17)
        public void creditRechargeWithdraw() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCreditRechargeWithdraw);
                Thread.sleep(2000);
                String getCreditRecharge = driverUtil.getTextByXpath(creditRecharge);
                String getCreditWithdraw = driverUtil.getTextByXpath(creditWithdraw);
                String a1 = getCreditRecharge.substring(2);
                String a2 = getCreditWithdraw.substring(2);
                System.out.println("首页信用今日充值："+a1);
                System.out.println("首页信用今日提现："+a2);
                driverUtil.findElementByXpathAndClick(creditRefreshRecord);
                Thread.sleep(2000);
                String getAddPoint = driverUtil.getTextByXpath(addPoint);
                String getMinusPoint = driverUtil.getTextByXpath(minusPoint);
                System.out.println("信用今日加分总计："+getAddPoint);
                System.out.println("信用今日加分总计："+getMinusPoint);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getAddPoint);
                Assertion.verifyEquals(a2,getMinusPoint);
                Assert.assertTrue(Assertion.currentFlag());
        }




}