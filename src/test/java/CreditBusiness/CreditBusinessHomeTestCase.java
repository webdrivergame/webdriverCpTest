package CreditBusiness;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class CreditBusinessHomeTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://binli.oneonewan.com/#/login";
        String username = "wxjb66";
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
         *
         * @获取首页账户余额
         * 点击跳转
         * @获取服务费账户余额总计
         * @获取变动后余额
         * ***/

        String accountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String accountBalanceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[1]/div[1]/li/span[2]";
        String changeAfterAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";

        //------------------------------------------------验证首页账户余额------------------------------------------------

        @Features("信用商务")
        @Stories("首页")
        @Title("验证账户余额")
        @Test(priority = 1)
        public void accountBalance() throws InterruptedException {
                String getAccountBalance = driverUtil.getTextByXpath(accountBalance);
                System.out.println("首页账户余额："+getAccountBalance);
                driverUtil.findElementByXpathAndClick(clickAccountBalance);
                Thread.sleep(2000);
                String getAccountBalanceTotal = driverUtil.getTextByXpath(accountBalanceTotal);
                String getChangeAfterAccountBalance = driverUtil.getTextByXpath(changeAfterAccountBalance);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getAccountBalance,getAccountBalanceTotal,getChangeAfterAccountBalance);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页今日服务费收入
         * 下级服务费统计
         * @获取我的服务费收入
         *
         * ***/

        String home = "//*[@id=\"rest_agent_zongdai_home\"]/li/span";
        String serviceIncomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String myServiceAccount = "//*[@id=\"rest_system_agent_recharge_record\"]/li/span";
        String serviceDetail = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[6]/div/div/div/div/a";
        String clickDate = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/input[1]";
        String selectToday = "/html/body/div[4]/div[1]/div[1]/button[1]";
        String serviceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[2]/div/div[1]/ul/li[6]/span";

        //---------------------------------------------验证首页今日服务费收入-----------------------------------------------

        @Features("信用商务")
        @Stories("首页")
        @Title("验证今日服务费收入")
        @Test(priority = 2)
        public void serviceIncomeToday() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getServiceIncomeToday = driverUtil.getTextByXpath(serviceIncomeToday);
                System.out.println("首页今日服务费收入："+getServiceIncomeToday);
                if (! getServiceIncomeToday.equals("0.000")) {
                        driverUtil.findElementByXpathAndClearSendkeys(inputText, "我的服务费账户变动");
                        driverUtil.findElementByXpathAndClick(myServiceAccount);
                        Thread.sleep(2000);
                        driverUtil.findElementByXpathAndClick(serviceDetail);
                        Thread.sleep(2000);
                        driverUtil.findElementByXpathAndClick(clickDate);
                        driverUtil.findElementByXpathAndClick(selectToday);
                        String getServiceToday = driverUtil.getTextByXpath(serviceToday);
                        System.out.println("今日服务费：" + getServiceToday);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getServiceIncomeToday, getServiceToday);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if(getServiceIncomeToday.equals("0.000")){
                        System.out.println("今日服务费为0");
                }

        }


         /***
         *
         * @获取首页代理人数
         * 信用模式代理
         * @获取共多少条
         * ***/

        String agentNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[1]";
        String clickAgentNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String agentNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[3]/span[1]";

        //------------------------------------------验证首页代理人数----------------------------------------------------

        @Features("信用商务")
        @Stories("首页")
        @Title("验证代理人数")
        @Test(priority = 4)
        public void agentNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getAgentNumber = driverUtil.getTextByXpath(agentNumber);
                System.out.println("首页代理人数："+getAgentNumber);
                driverUtil.findElementByXpathAndClick(clickAgentNumber);
                Thread.sleep(2000);
                String getAgentNumber2 = driverUtil.getTextByXpath(agentNumber2);
                String a1 = getAgentNumber2.substring(2,getAgentNumber2.indexOf(" 条"));
                Assertion.setFlag(true);
                Assertion.verifyEquals(getAgentNumber,a1);
                Assert.assertTrue(Assertion.currentFlag());
        }



}
