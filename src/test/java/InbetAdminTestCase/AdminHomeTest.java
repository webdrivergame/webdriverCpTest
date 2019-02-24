package InbetAdminTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;


public class AdminHomeTest {

    private WebDriver driver;


        @Feature("平台首页")
        @Story("信用模式")
        @Title("验证今日服务费收入与下级服务费金额是否一致")

        @Test(priority = 1)
        private void serviceFeeIncome() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(8000);


            //判断首页无限金币今日服务费收入与下级服务费我的服务费总计金额是否一致
            String ServiceFeeIncomeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[1]/td[2]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            String ServiceFeeIncomeToday2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[3]/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(ServiceFeeIncomeToday,ServiceFeeIncomeToday2);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("信用模式")
        @Title("验证服务费收入总计与下级服务费统计的生成服务费总计金额是否一致")

        @Test(priority = 2)
        public void sinceBusinessOperationsTotalArrears() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);


            //判断服务费收入总计与下级服务费统计的生成服务费总计金额是否一致
            String SinceBusinessOperationsTotalArrears = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[2]/td[2]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            String SinceBusinessOperationsTotalArrears2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[1]/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(SinceBusinessOperationsTotalArrears,SinceBusinessOperationsTotalArrears2);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("信用模式")
        @Title("验证商户欠款总计与下级服务费结算记录总欠款是否一致")

        @Test(priority = 3)
        public void busniessMoneyTotal() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //判断首页商户欠款总计与下级服务费结算记录总欠款是否一致
            String busniessMoneyTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[2]/td[3]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费结算记录");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record\"]/li/span");

                Thread.sleep(3000);
            String busniessMoneyTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/li/span[2]");


                Assertion.setFlag(true);
                Assertion.verifyEquals(busniessMoneyTotal,busniessMoneyTotal1);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("信用模式")
        @Title("验证今日新增玩家与留存统计今日注册玩家数量是否一致")

        @Test(priority = 4)
        public void playerNumber() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //验证今日新增玩家与留存统计今日注册玩家数量是否一致

            String playerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[1]/td[5]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","留存统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_login_statistic\"]/li/span");
                Thread.sleep(4000);
            String registerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");

                Assertion.setFlag(true);
                Assertion.verifyEquals(playerNumber,registerNumber);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("验证今日系统盈亏与玩家输赢金额是否一致")

        @Test(priority = 5)
        public void systermWinOrLose() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //验证今日系统盈亏与玩家输赢同进金额是否一致
            String systermWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[1]/td[7]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式游戏输赢统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_game_win_lose_list\"]/li/span");
                Thread.sleep(3000);
            String playerWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div/div/div[2]/div[1]/div[4]/li/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(systermWinOrLose,playerWinOrLose);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();

        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("验证系统盈亏总计与玩家输赢总计金额是否一致")

        @Test(priority = 6)
        public void totalsystermWinOrLose() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //验证系统盈亏总计与玩家输赢总计金额是否一致

            String totalsystermWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[2]/td[7]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金模式游戏输赢统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_game_win_lose_list\"]/li/span");
                Thread.sleep(3000);
            String totalPlayerWinOrLose = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div/div/div[2]/div[1]/div[4]/li/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(totalPlayerWinOrLose,totalsystermWinOrLose);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("验证今日佣金与下级佣金统计-商户今日佣金金额是否一致")

        @Test(priority = 7)
        public void todayCommission() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //验证今日佣金与下级佣金统计-商户今日佣金金额是否一致
            String todaycommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[1]/td[8]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                Thread.sleep(3000);
            String bussniessTodaycommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[4]/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(todaycommission,bussniessTodaycommission);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("验证佣金总计与下级佣金统计-商户所占佣金金额是否一致")

        @Test(priority = 8)
        public void totalCommission() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(6000);

            //验证佣金总计与下级佣金统计-商户所占佣金金额是否一致
            String totalCommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[2]/td[8]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级佣金统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_sub_promotion_agent_statistics\"]/li/span");
                Thread.sleep(3000);
            String bussinessCommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div[2]/span[2]");

                Assertion.setFlag(true);
                Assertion.verifyEquals(totalCommission,bussinessCommission);
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("平台首页")
        @Story("现金模式")
        @Title("验证今日充值金额与现金充值提现记录-人工充值+在线充值是否一致")

        @Test(enabled = false)
        public void rechangeToday() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(6000);

            //验证今日充值金额与现金充值提现记录-人工充值+在线充值是否一致
            String rechangeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div/div[3]/table/tbody/tr[1]/td[9]/div/div");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","现金-充值提现记录");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_cash_recharge_withdraw_list\"]/li/span");
                Thread.sleep(2000);
            String s1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div[1]/span[2]");
            String s2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div[3]/span[2]");


            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            //int total = a+b;
            String total = Integer.toString(b+a);
            //String total = Integer.toString(Integer.parseInt(s1+s2));

            //String total = (String) driverUtil.toString(s1+s2);

              Assertion.setFlag(true);
              Assertion.verifyEquals(total,rechangeToday);
              Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }



}