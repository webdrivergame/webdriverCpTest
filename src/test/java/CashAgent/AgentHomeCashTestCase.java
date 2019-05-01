package CashAgent;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AgentHomeCashTestCase {


        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://koudai.oneonewan.com/?#/login";
        String username = "44444";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";

        @BeforeTest
        public void loginAdmin() throws InterruptedException {
                driverUtil.loginBefore(Url);
                driverUtil.adminLogin(username,password);
                driverUtil.findElementByXpathAndClick(login);
                Thread.sleep(4000);
        }


         /***
         * step ！！！
         *
         * @获取首页今日收入
         * 点金今日收入跳转
         * 点击选择今日时间
         * @获取我的佣金收入
         * **/

        String incomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickIncomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String currentDate = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[1]/ul/li[2]";
        String myCommissionIncome = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[1]/ul/li[9]";

        //--------------------------------------------------验证首页今日收入金额----------------------------------------------------

        @Features("现金代理")
        @Stories("首页")
        @Title("验证今日收入金额与今日产生佣金账单金额一致")
        @Test(priority = 1)
        public  void incomeToday() throws InterruptedException {
                String getIncomeToday=driverUtil.getTextByXpath(incomeToday);
                System.out.println("首页今日收入：" + getIncomeToday);
                driverUtil.findElementByXpathAndClick(clickIncomeToday);
                Thread.sleep(2000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("系统时间："+systemDate);
                if(systemDate.equals(currentDate)){
                        String getMyCommissionIncome = driverUtil.getTextByXpath(myCommissionIncome);
                        System.out.println("我的佣金收入："+getMyCommissionIncome);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getIncomeToday, getMyCommissionIncome);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! systemDate.equals(currentDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getIncomeToday, "0.000");
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

         /***
         *
         * @获取30日总收入
         * 点金今日收入
         * 点击时间选择30日
         * @获取30日收入
         *
         * **/

        String clickHome = "//*[@id=\"rest_case_promotion_agent_home\"]/li/span";
        String incomeTotalMonth = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[3]/div/span[2]";
        String clickStartDate = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/form/div[1]/div/div[1]/div[2]/div/div/input[1]";
        String clickMonth = "/html/body/div[3]/div[1]/div[1]/button[5]";
        String myCommissionIncomeMoths = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/span[2]";

        //--------------------------------------------------验证首页30日总金额----------------------------------------------------

        @Features("现金代理")
        @Stories("首页")
        @Title("验证30日总收入金额是否等于我的推广佣金账单30天金额")
        @Test(priority = 2)
        public void incomeTotalMonth() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(clickHome);
                Thread.sleep(3000);
                String getIncomeTotalMonth = driverUtil.getTextByXpath(incomeTotalMonth);
                String a1 = getIncomeTotalMonth.substring(2);
                System.out.println("30日总收入："+a1);
                driverUtil.findElementByXpathAndClick(clickIncomeToday);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickStartDate);
                Thread.sleep(1000);
                driverUtil.findElementByXpathAndClick(clickMonth);
                Thread.sleep(2000);
                String getMyCommissionIncomeMoths = driverUtil.getTextByXpath(myCommissionIncomeMoths);
                System.out.println("现金代理首页30日我的佣金总账单："+getMyCommissionIncomeMoths);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getMyCommissionIncomeMoths);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取待结算佣金
         * 点击待结算佣金
         * @获取变动后余额
         *
         *  ***/

        String waitSettlementCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickWaitSettlementCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span";
        String afterChangeBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";

        //-----------------------------------------------------验证首页待结算佣金--------------------------------------------------

        @Features("现金代理")
        @Stories("首页")
        @Title("验证首页待结算佣金金额是否等于我的佣金账户变动余额")
        @Test(priority = 3)
        public void waitSettlementCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(clickHome);
                Thread.sleep(3000);
                String getWaitSettlementCommission = driverUtil.getTextByXpath(waitSettlementCommission);
                System.out.println("现金代理首页待结算佣金："+getWaitSettlementCommission);
                driverUtil.findElementByXpathAndClick(clickWaitSettlementCommission);
                Thread.sleep(2000);
                String getAfterChangeBalance = driverUtil.getTextByXpath(afterChangeBalance);
                System.out.println("变动后余额："+getAfterChangeBalance);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getWaitSettlementCommission,getAfterChangeBalance);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页玩家总数
         * 点击跳转玩家管理
         * 查询
         * @获取玩家管理该代理玩家总数
         * ***/

        String playerNumberTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[1]";
        String clickPlayerNumberTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span";
        String inquire = "//*[@id=\"reset\"]/span";
        String playerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        //----------------------------------------------验证首页玩家数量-----------------------------------------------------------

        @Features("现金代理")
        @Stories("首页")
        @Title("验证首页玩家总数是否与玩家管理数量一致")
        @Test(priority = 4)
        public void playerNumberTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(clickHome);
                Thread.sleep(2000);
                String getPlayerNumberTotal = driverUtil.getTextByXpath(playerNumberTotal);
                System.out.println("首页玩家数量总计："+getPlayerNumberTotal);
                driverUtil.findElementByXpathAndClick(clickPlayerNumberTotal);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(inquire);
                Thread.sleep(3000);
                String getPlayerNumber = driverUtil.getTextByXpath(playerNumber);
                String a1 = getPlayerNumber.substring(2,getPlayerNumber.indexOf(" 条"));//截取数值xx（共 xx 条）
                System.out.println("玩家管理玩家人数："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getPlayerNumberTotal,a1);
                Assert.assertTrue(Assertion.currentFlag());
        }

}
