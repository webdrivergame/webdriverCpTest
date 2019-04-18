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
        String accountBalanceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/div[1]/li/span[2]";
        String changeAfterAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";

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
        String clickServiceIncomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String serviceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div[3]/span[2]";

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
                driverUtil.findElementByXpathAndClick(clickServiceIncomeToday);
                Thread.sleep(2000);
                String getServiceToday = driverUtil.getTextByXpath(serviceToday);
                System.out.println("今日服务费："+getServiceToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getServiceIncomeToday,getServiceToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页代理欠款总计
         * 下级服务费结算记录
         * @获取总欠款
         *
         * ***/

        String agentArrearsTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickAgentArrearsTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String arrearsTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/li/span[2]";

        //-----------------------------------------------验证首页带路欠款总计---------------------------------------------

        @Features("信用商务")
        @Stories("首页")
        @Title("验证代理欠款总计")
        @Test(priority = 3)
        public void agentArrearsTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getAgentArrearsTotal = driverUtil.getTextByXpath(agentArrearsTotal);
                System.out.println("首页代理欠款总计："+getAgentArrearsTotal);
                driverUtil.findElementByXpathAndClick(clickAgentArrearsTotal);
                Thread.sleep(2000);
                String getArrearsTotal = driverUtil.getTextByXpath(arrearsTotal);
                System.out.println("总欠款："+getArrearsTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getAgentArrearsTotal,getArrearsTotal);
                Assert.assertTrue(Assertion.currentFlag());
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

         /***
         *
         * @获取首页玩家数量
         * 点击跳转玩家账号管理
         * @获取玩家人数
         * ***/

        String playerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[5]/div/div/div/div[1]/div[2]/div[2]/span/span[1]";
        String clickPlayerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[5]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String inquire = "//*[@id=\"submit\"]/span";
        String playerNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        //------------------------------------------------验证首页玩家人数----------------------------------------------

        @Features("信用商务")
        @Stories("首页")
        @Title("验证玩家人数")
        @Test(priority = 5)
        public void playerNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getPlayerNumber = driverUtil.getTextByXpath(playerNumber);
                System.out.println("首页玩家人数："+getPlayerNumber);
                driverUtil.findElementByXpathAndClick(clickPlayerNumber);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(inquire);
                Thread.sleep(3000);
                String getPlayerNumber2 = driverUtil.getTextByXpath(playerNumber2);
                String getPlayerNumber3 = getPlayerNumber2.substring(2,getPlayerNumber2.indexOf(" 条"));
                System.out.println("玩家账号管理："+getPlayerNumber3);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getPlayerNumber,getPlayerNumber3);
                Assert.assertTrue(Assertion.currentFlag());

        }


}
