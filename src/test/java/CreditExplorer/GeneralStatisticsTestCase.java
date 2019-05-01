package CreditExplorer;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralStatisticsTestCase {
        WebDriverUtil driverUtil = new WebDriverUtil(null);
        String Url = "https://binli.oneonewan.com/#/login";
        String username = "zongguan001";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";


         /***
         *
         * 信用模式综合统计
         * @获取注册人数
         * 信用留存统计
         * 获取当前时间
         * @获取新增玩家
         *  ***/

        String generalStatistics = "//*[@id=\"rest_unlimited_statistics_list\"]/li/span";
        String registeredNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[2]/div";
        String creditRetainedStatistics = "//*[@id=\"rest_login_statistic\"]/li/span";
        String testDate = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div";
        String addNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";

        //-----------------------------------------------验证注册人数--------------------------------------------------

        @Features("信用总管")
        @Stories("信用模式综合统计")
        @Title("验证当日注册人数")
        @Test(priority = 1)
        public void registeredNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(generalStatistics);
                Thread.sleep(2000);
                String getRegisteredNumber = driverUtil.getTextByXpath(registeredNumber);
                System.out.println("信用综合统计注册人数："+getRegisteredNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date =new Date();
                String systemDate = dateFormat.format(date);
                String getTextDate = driverUtil.getTextByXpath(testDate);
                if (systemDate.equals(getTextDate)){
                        String getAddNumber = driverUtil.getTextByXpath(addNumber);
                        System.out.println("信用留存新增人数："+getAddNumber);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getRegisteredNumber,getAddNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! systemDate.equals(getTextDate)){
                        System.out.println("今日新增玩家为0");
                }
        }

         /***
         *
         * @获取信用综合统计登录人数
         * @获取信用留存登录人数
         *
         * ***/

        String loginNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[4]/div";
        String loginNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";

        //------------------------------------------------验证登录人数--------------------------------------------------------

        @Features("信用总管")
        @Stories("信用模式综合统计")
        @Title("验证当日登录人数")
        @Test(priority = 2)
        public void loginNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(generalStatistics);
                Thread.sleep(2000);
                String getLoginNumber = driverUtil.getTextByXpath(loginNumber);
                System.out.println("信用综合统计今日登录人数："+getLoginNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date =new Date();
                String systemDate = dateFormat.format(date);
                String getTextDate = driverUtil.getTextByXpath(testDate);
                if (systemDate.equals(getTextDate)){
                        String gerLoginNumber2 = driverUtil.getTextByXpath(loginNumber2);
                        System.out.println("信用留存登录人数："+gerLoginNumber2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getLoginNumber,gerLoginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! systemDate.equals(getTextDate)){
                        System.out.println("今日登录玩家为0");
                }
        }

         /***
         *
         * @获取信用模式综合统计投注额
         * 信用模式游戏输赢统计
         * @获取信用模式游戏输赢统计投注额
         *
         * ***/

        String Bet = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[5]/div";
        String creditModelGameLoseOrWin = "//*[@id=\"rest_game_win_lose_list\"]/li/span";
        String Bet2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[5]/span[2]";

        //-------------------------------------------------验证投注额----------------------------------------------------

        @Features("信用总管")
        @Stories("信用模式综合统计")
        @Title("验证投注额")
        @Test(priority = 3)
        public void Bet() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(generalStatistics);
                Thread.sleep(2000);
                String getBet = driverUtil.getTextByXpath(Bet);
                System.out.println("信用综合统计投注额："+getBet);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(creditModelGameLoseOrWin);
                Thread.sleep(2000);
                String getBet2 = driverUtil.getTextByXpath(Bet2);
                System.out.println("信用模式游戏输赢统计投注额："+getBet2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBet,getBet2);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         * @获取信用模式综合统计今日服务费
         * 下级服务费统计
         * @获取下级服务费统计今日服务费
         *
         * ***/

        String serviceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div";
        String home = "//*[@id=\"rest_agent_tenant_home\"]/li/span";
        String homeServiceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";

        //-----------------------------------------------------验证今日服务费------------------------------------------------

        @Features("信用总管")
        @Stories("信用模式综合统计")
        @Title("验证服务费金额")
        @Test(priority = 4)
        public void serviceToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(generalStatistics);
                Thread.sleep(2000);
                String getServiceToday = driverUtil.getTextByXpath(serviceToday);
                System.out.println("信用模式综合统计服务费金额："+getServiceToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getHomeServiceToday = driverUtil.getTextByXpath(homeServiceToday);
                System.out.println("下级服务费统计今日服务费："+getHomeServiceToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getServiceToday,getHomeServiceToday);
                Assert.assertTrue(Assertion.currentFlag());
        }


}
