package adminTestCase;

import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import java.text.SimpleDateFormat;
import java.util.Date;


public class creditModeComplexStatisticsTestCase {

        public WebDriver driver;

        @Feature("平台")
        @Story("信用模式综合统计")
        @Title("平台-信用模式综合统计-验证当日注册人数数量")
        @Test(priority = 1)
        public void registeredNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_unlimited_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String registeredNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[2]/div");
                System.out.println("信用模式综合统计今日注册人数："+registeredNumber);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_login_statistic\"]/li/span");
                        Thread.sleep(2000);
                String date = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                String date1 = date.replaceAll("-","");
                int b1 = Integer.valueOf(date1).intValue();
                System.out.println("获取日期："+b1);//获取信用留存日期去掉-并转换int类型
                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
                Date da = new Date();
                String date2 = df.format(da);
                int b2 = Integer.valueOf(date2).intValue();
                System.out.println("系统日期："+b2);//获取系统日期转换int类型
                if (b1==b2){
                        String dateToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(registeredNumber,dateToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (b1 !=b2){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",registeredNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }
                driverUtil.LoginAfter();
        }



        @Feature("平台")
        @Story("信用模式综合统计")
        @Title("平台-信用模式综合统计-验证登录人数数据")
        @Test(priority = 2)
        public void loginNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_unlimited_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String loginNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[4]/div");
                System.out.println("信用综合统计登录人数："+loginNumber);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用留存统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_login_statistic\"]/li/span");
                        Thread.sleep(2000);
                String dateToday1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[1]/div");
                String dateToday = dateToday1.replaceAll("-","");
                System.out.println("获取日期："+dateToday);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String systemDate = dateFormat.format(date);
                System.out.println("系统日期："+systemDate);
                if (dateToday.equals(systemDate)){
                        String loginNumber2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(loginNumber,loginNumber2);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (!dateToday.equals(systemDate)){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals("0",loginNumber);
                        Assert.assertTrue(Assertion.currentFlag());
                }
                driverUtil.LoginAfter();

        }


        @Feature("平台")
        @Story("信用模式综合统计")
        @Title("平台-信用模式综合统计-验证投注额数据是否一致")
        @Test(priority = 3)
        public void Bet() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_unlimited_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String Bet = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[5]/div");
                System.out.println("信用模式综合统计投注额："+Bet);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_game_win_lose_list\"]/li/span");
                        Thread.sleep(2000);
                String Bet2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[5]/span[2]");
                System.out.println("信用模式游戏输赢投注额："+Bet2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(Bet,Bet2);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("平台")
        @Story("信用模式综合统计")
        @Title("平台-信用模式综合统计-验证服务费金额数据一致")
        @Test(priority = 4)
        public void serviceMoney() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
                driverUtil.adminLogin("xiaochaoadmin", "123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式综合统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_unlimited_statistics_list\"]/li/span");
                        Thread.sleep(3000);
                String serviceMoney = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/div");
                System.out.println("信用模式综合统计今日服务费："+serviceMoney);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                        Thread.sleep(2000);
                String serviceToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[1]/div/div[1]/div[3]/span[2]");
                System.out.println("下级服务费统计今日服务费："+serviceToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(serviceMoney,serviceToday);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

}
