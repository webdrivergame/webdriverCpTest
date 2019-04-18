package Admin;

import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ModeComplexStatisticsCreditTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";


         /***
         *
         * 点击信用模式综合统计
         * @获取注册人数
         * 点击信用留存
         * 获取当前日期
         * @获取留存新增玩家
         *
         *  **/

        String clickCreditModelComplexStatistics = "//*[@id=\"rest_unlimited_statistics_list\"]/li/span";
        String registeredNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[2]/div";
        String creditRetainedStatistics = "//*[@id=\"rest_login_statistic\"]/li/span";
        String dateToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div";
        String addPlayer = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div";

        //--------------------------------------------------验证信用模式综合统计注册玩家---------------------------------------------
        @Features("平台管理员")
        @Stories("信用模式综合统计")
        @Title("验证当日注册人数数量")
        @Test(priority = 25)
            public void registeredNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelComplexStatistics);
                Thread.sleep(3000);
                String getRegisteredNumber = driverUtil.getTextByXpath(registeredNumber);
                System.out.println("信用模式综合统计今日注册人数："+getRegisteredNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("获取日期："+getDateToday);//获取信用留存日期去掉-并转换int类型
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
                Date da = new Date();
                String systemDate = df.format(da);
                System.out.println("系统日期："+systemDate);//获取系统日期转换int类型
                if (getDateToday.equals(systemDate)){
                        String getAddPlayer = driverUtil.getTextByXpath(addPlayer);
                        System.out.println("信用留存新增玩家："+getAddPlayer);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getAddPlayer,getRegisteredNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",getRegisteredNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

         /***
         * @获取信用综合统计登录人数
         *
         * @获取信用留存统计登录人数
         *
         * ***/

        String loginNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[4]/div";
        String loginNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";

        //--------------------------------------------------验证信用模式综合统计登录玩家---------------------------------------------

        @Features("平台管理员")
        @Stories("信用模式综合统计")
        @Title("验证登录人数数据")
        @Test(priority = 26)
            public void loginNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelComplexStatistics);
                Thread.sleep(3000);
                String getLoginNumber = driverUtil.getTextByXpath(loginNumber);
                System.out.println("信用综合统计登录人数："+getLoginNumber);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用留存统计");
                driverUtil.findElementByXpathAndClick(creditRetainedStatistics);
                Thread.sleep(2000);
                String getDateToday = driverUtil.getTextByXpath(dateToday);
                System.out.println("获取日期："+getDateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("系统日期："+systemDate);
                if (getDateToday.equals(systemDate)){
                        String getLoginNumber2 = driverUtil.getTextByXpath(loginNumber2);
                        System.out.println("信用留存登陆人数："+getLoginNumber2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getLoginNumber,getLoginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getDateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",getLoginNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

         /***
          *
         * @获取信用模式综合统计投注额
         * 点击信用模式游戏输赢统计
         * @获取投注额
         *
         * **/

        String Bet = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[5]/div";
        String creditModelComplexStatisticsBex = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[5]/span[2]";
        String clickCreditGameWinOrLoseStatistics = "//*[@id=\"rest_game_win_lose_list\"]/li/span";

        //--------------------------------------------------验证信用模式综合统计投注额--------------------------------------------

        @Features("平台管理员")
        @Stories("信用模式综合统计")
        @Title("验证投注额是否等于信用模式游戏输赢统计投注额")
        @Test(priority = 27)
            public void Bet() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelComplexStatistics);
                Thread.sleep(3000);
                String getBet = driverUtil.getTextByXpath(Bet);
                System.out.println("信用模式综合统计投注额："+getBet);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(clickCreditGameWinOrLoseStatistics);
                        Thread.sleep(2000);
                String getCreditModelComplexStatisticsBex = driverUtil.getTextByXpath(creditModelComplexStatisticsBex);
                System.out.println("信用模式游戏输赢投注额："+getCreditModelComplexStatisticsBex);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getBet,getCreditModelComplexStatisticsBex);
                Assert.assertTrue(Assertion.currentFlag());
        }


          /***
          *
         * @获取信用综合统计服务费
         * 点击下级服务费统计
         * @获取今日服务费金额
         *
         * ***/
        String serviceMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div";
        String clickLowerServiceStatistics = "//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span";
        String serviceToday2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[3]/span[2]";

        //--------------------------------------------------验证信用模式综合统计服务费--------------------------------------------

        @Features("平台管理员")
        @Stories("信用模式综合统计")
        @Title("验证服务费金额数据是否与下级服务费统计今日服务费金额一致")
        @Test(priority = 28)
            public void serviceMoney() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式综合统计");
                driverUtil.findElementByXpathAndClick(clickCreditModelComplexStatistics);
                Thread.sleep(3000);
                String getServiceMoney = driverUtil.getTextByXpath(serviceMoney);
                System.out.println("信用模式综合统计今日服务费："+getServiceMoney);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费统计");
                driverUtil.findElementByXpathAndClick(clickLowerServiceStatistics);
                Thread.sleep(2000);
                String getServiceToday = driverUtil.getTextByXpath(serviceToday2);
                System.out.println("下级服务费统计今日服务费："+getServiceToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getServiceMoney,getServiceToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

        @AfterTest
        public void close(){
                driverUtil.loginAfter();
        }
}
