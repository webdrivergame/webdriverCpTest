package CreditAgent;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgentHomeCreditTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://binli.oneonewan.com/#/login";
        String username = "wxjbdl1";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";

        @BeforeTest
        public void login() throws InterruptedException {
                driverUtil.loginBefore(Url);
                driverUtil.adminLogin(username,password);
                driverUtil.findElementByXpathAndClick(login);
                Thread.sleep(4000);
        }

         /***
         *
         * @获取首页今日新增玩家
         * @获取首页昨日新增玩家
         * 进入信用留存统计
         * 获取今日日期（是否等于系统日期）
         * @获取留存今日新增玩家
         * @获取留存昨日新增玩家
         *
         * ***/

        String addPlayerTodayHome = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div/div/div[1]";
        String addPlayerYesterdayHome = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/span";
        String creditRetainedStatistics = "//*[@id=\"rest_login_statistic\"]/li/span";
        String dateToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div";
        String addPlayerTodayRetained = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";
        String addPlayerYesterdayRetained = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[3]/div";

        //--------------------------------------------验证首页今日新增玩家和昨日新增------------------------------------------------

        @Features("信用代理")
        @Stories("首页")
        @Title("验证今日新增玩家")
        @Test(priority = 1)
        public void addPlayerToday() throws InterruptedException {
                String getAddPlayerTodayHome = driverUtil.getTextByXpath(addPlayerTodayHome);
                String getAddPlayerYesterdayHome = driverUtil.getTextByXpath(addPlayerYesterdayHome);
                System.out.println("信用代理首页今日新增玩家："+getAddPlayerTodayHome);
                System.out.println("信用代理首页昨日新增玩家："+getAddPlayerYesterdayHome);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("获取今日日期："+getDateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String dateSystem = dateFormat.format(date);
                System.out.println("获取系统日期："+dateSystem);
                if (getDateToday.equals(dateSystem)){
                        String getAddPlayerTodayRetained = driverUtil.getTextByXpath(addPlayerTodayRetained);
                        String getAddPlayerYesterdayRetained = driverUtil.getTextByXpath(addPlayerYesterdayRetained);
                        System.out.println("信用留存统计昨日新增玩家："+getAddPlayerTodayRetained);
                        System.out.println("信用留存统计今日新增玩家："+getAddPlayerYesterdayRetained);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getAddPlayerTodayHome,getAddPlayerTodayRetained);
                        Assertion.verifyEquals(getAddPlayerYesterdayHome,getAddPlayerYesterdayRetained);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(dateSystem)){
                        System.out.println("今日新增玩家为0");
                }
        }

         /***
         *
         * 点金首页
         * @获取首页今日活跃玩家和昨日活跃玩家
         * 点击留存
         * 获取当前时间是否等于系统时间
         * @获取留存今日活跃玩家和昨日活跃玩家
         * ***/

        String home = "//*[@id=\"rest_agent_daili_home\"]/li/span";
        String activePlayerTodayHome = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]";
        String activePlayerYesterdayHome = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[2]/span";
        String activePlayerTodayStatistics = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";
        String activePlayerYesterdayStatistics = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[2]/div";

        //---------------------------------------------验证首页活跃玩家和昨日活跃玩家---------------------------------------------

        @Features("信用代理")
        @Stories("首页")
        @Title("验证今日活跃和昨日活跃玩家")
        @Test(priority = 2)
        public void activePlayerTodayHome() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(2000);
                String getActivePlayerTodayHome = driverUtil.getTextByXpath(activePlayerTodayHome);
                String getActivePlayerYesterdayHome = driverUtil.getTextByXpath(activePlayerYesterdayHome);
                System.out.println("首页今日活跃玩家："+getActivePlayerTodayHome);
                System.out.println("首页昨日活跃玩家："+getActivePlayerYesterdayHome);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("获取今日日期："+getDateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String dateSystem = dateFormat.format(date);
                System.out.println("获取系统日期："+dateSystem);
                if (getDateToday.equals(dateSystem)){
                       String getActivePlayerTodayStatistics = driverUtil.getTextByXpath(activePlayerTodayStatistics);
                       String getActivePlayerYesterdayStatistics = driverUtil.getTextByXpath(activePlayerYesterdayStatistics);
                       System.out.println("信用代理留存今日登录人数："+getActivePlayerTodayStatistics);
                       System.out.println("信用代理留存昨日登录人数："+getActivePlayerYesterdayStatistics);
                        Assertion.setFlag(true);
                       Assertion.verifyEquals(getActivePlayerTodayHome,getActivePlayerTodayStatistics);
                       Assertion.verifyEquals(getActivePlayerYesterdayHome,getActivePlayerYesterdayStatistics);
                       Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(dateSystem)){
                        System.out.println("今日活跃玩家为0");
                }
        }

         /***
         *
         * @获取首页今日系统输赢
         * 进入信用模式游戏输赢统计
         * @获取今日系统输赢
         *
         * ***/

        String systemLoseOrWinToday = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[3]/div/div/div[1]";
        String creditModelGameLoseOrWin = "//*[@id=\"rest_game_win_lose_list\"]/li/span";
        String loseOrWinTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[4]/span[2]";

        //----------------------------------------------验证首页今日系统输赢--------------------------------------------------

        @Features("信用代理")
        @Stories("首页")
        @Title("验证今日系统输赢")
        @Test(priority = 3)
        public void systemLoseOrWinToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(2000);
                String getSystemLoseOrWinToday = driverUtil.getTextByXpath(systemLoseOrWinToday);
                String a1 = getSystemLoseOrWinToday.substring(2);
                System.out.println("首页今日系统输赢："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(creditModelGameLoseOrWin);
                Thread.sleep(2000);
                String getLoseOrWinTotal = driverUtil.getTextByXpath(loseOrWinTotal);
                System.out.println("信用模式游戏输赢统计："+getLoseOrWinTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,getLoseOrWinTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页今日服务费
         * 我的服务费账单
         * 获取日期对比系统日期
         * @获取我的服务费
         *
         * ***/

        String serviceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[4]/div/div/div[1]";
        String myServiceBill = "//*[@id=\"rest_system_agent_clearing_record\"]/li/span";
        String dateText = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[1]/ul/li[2]";
        String service = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[1]/ul/li[6]/span";

        //-------------------------------------------验证首页我的服务费账单------------------------------------------

        @Features("信用代理")
        @Stories("首页")
        @Title("验证我的服务费账单")
        @Test(priority = 4)
        public void serviceToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(2000);
                String getServiceToday = driverUtil.getTextByXpath(serviceToday);
                String a1 = getServiceToday.substring(2);
                System.out.println("首页今日服务费："+a1);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"我的服务费账单");
                driverUtil.findElementByXpathAndClick(myServiceBill);
                Thread.sleep(2000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("系统日期："+systemDate);
                String getDate = driverUtil.getTextByXpath(dateText);
                System.out.println("当前日期："+getDate);
                if (systemDate.equals(getDate)){
                        String getService = driverUtil.getTextByXpath(service);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getServiceToday,getService);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! systemDate.equals(getDate)){
                        System.out.println("今日服务费为0");
                }
        }


}
