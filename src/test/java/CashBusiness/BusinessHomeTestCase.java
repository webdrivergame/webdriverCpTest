package CashBusiness;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class BusinessHomeTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://koudai.oneonewan.com/?#/login";
        String username = "qaxjtg01";
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
         * @获取首页今日收入
         * 点金今日收入跳转
         * 点击开始时间
         * 选择今日
         * @获取今日我的佣金收入
         *
         * ***/
        String incomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickIncomeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String clickStartDate = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/form/div[1]/div/div[1]/div[2]/div/div/input[1]";
        String clickToday = "/html/body/div[3]/div[1]/div[1]/button[1]";
        String incomeMyCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/span[2]";


        @Features("现金商户")
        @Stories("首页")
        @Title("验证今日收入金额是否等于今日我的推广佣金账单+下级抽成金额")
        @Test(priority = 1)
        public void incomeToday() throws InterruptedException {
                String getIncomeToday = driverUtil.getTextByXpath(incomeToday);
                System.out.println("今日收入总计："+getIncomeToday);
                driverUtil.findElementByXpathAndClick(clickIncomeToday);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickStartDate);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickToday);
                Thread.sleep(2000);
                String getIncomeMyCommission = driverUtil.getTextByXpath(incomeMyCommission);
                System.out.println("今日我的佣金收入："+getIncomeMyCommission);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getIncomeToday,getIncomeMyCommission);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页30日佣金收入
         * 点击跳转
         * 选择30日
         * @获取30日佣金余额
         *
         *  ***/

        String home = "//*[@id=\"rest_case_agent_tenant_home\"]/li/span";
        String incomeMonth = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[1]/div/div/div/div[3]/div/span[2]";
        String clickMoths = "/html/body/div[4]/div[1]/div[1]/button[5]";
        String getIncomeMyCommissionMoths = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/span[2]";

        @Features("现金商户")
        @Stories("首页")
        @Title("验证30日总收入金额与我的推广佣金30天金额是否一致")
        @Test(priority = 2)
        public void incomeTotalThirty() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getIncomeMonth = driverUtil.getTextByXpath(incomeMonth);
                String incomeTotalThirty = getIncomeMonth.substring(2);
                System.out.println("30日收入总计："+incomeTotalThirty);
                driverUtil.findElementByXpathAndClick(clickIncomeToday);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickStartDate);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickMoths);
                Thread.sleep(2000);
                String b1 = driverUtil.getTextByXpath(getIncomeMyCommissionMoths);
                System.out.println("30日我的佣金收入："+b1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(b1,incomeTotalThirty);
                Assert.assertTrue(Assertion.currentFlag());

        }


         /***
         *
         * @获取首页待结算佣金
         * 点击跳转
         * @获取变动后金额
         * @获取我的待结算佣金
         * ***/

        String waitSettlementCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]";
        String clickWaitSettlementCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String changeAfterMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";
        String myWaitSettlementCommission = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[1]/li/span[2]";

        @Features("现金商户")
        @Stories("首页")
        @Title("验证待结算佣金与我的佣金账户变动金额是否一致")
        @Test(priority = 3)
        public void waitSettlementCommission() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getWaitSettlementCommission = driverUtil.getTextByXpath(waitSettlementCommission);
                System.out.println("待结算佣金："+getWaitSettlementCommission);
                driverUtil.findElementByXpathAndClick(clickWaitSettlementCommission);
                Thread.sleep(2000);
                String getChangeAfterMoney = driverUtil.getTextByXpath(changeAfterMoney);
                String getMyWaitSettlementCommission = driverUtil.getTextByXpath(myWaitSettlementCommission);
                System.out.println("变动后金额："+getChangeAfterMoney);
                System.out.println("我的待结算佣金："+getMyWaitSettlementCommission);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getWaitSettlementCommission,getChangeAfterMoney,getMyWaitSettlementCommission);
                Assert.assertTrue(Assertion.currentFlag());

        }

         /***
         *
         * @获取首页玩家数量
         * 点击跳转玩家管理
         * 查询
         * @获取玩家页数
         * ***/

        String playerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[1]";
        String clickPlayerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String Inquire = "//*[@id=\"submit\"]/span";
        String playerNumber2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        @Features("现金商户")
        @Stories("首页")
        @Title("验证玩家数量总数是否一致")
        @Test(priority = 4)
        public void playerNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getPlayerNumber = driverUtil.getTextByXpath(playerNumber);
                System.out.println("首页玩家数量："+getPlayerNumber);
                driverUtil.findElementByXpathAndClick(clickPlayerNumber);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                String getPlayerNumber2 = driverUtil.getTextByXpath(playerNumber2);
                String b1 = getPlayerNumber2.substring(2,getPlayerNumber2.indexOf(" 条"));
                Assertion.setFlag(true);
                Assertion.verifyEquals(b1,getPlayerNumber);
                Assert.assertTrue(Assertion.currentFlag());

        }

         /***
         *
         * @获取首页下级代理人数
         * @获取直推代理人数
         * 点击跳转代理
         * @获取现金推广代理直推代理人数
         * 重置
         * @获取现金推广代理下级代理人数
         * ***/

        String lowerSpreadAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[1]";
        String ImmediateAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div/div[3]/div/span[2]";
        String clickLowerSpreadAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[3]";
        String ImmediateAgent2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";
        String reset = "//*[@id=\"reset\"]/span";
        String lowerSpreadAgent2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        @Features("现金商户")
        @Stories("首页")
        @Title("验证下级推广代理人数是否一致")
        @Test(priority = 5)
        public void lowerSpreadAgent() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(home);
                Thread.sleep(3000);
                String getLowerSpreadAgent = driverUtil.getTextByXpath(lowerSpreadAgent);
                String a1 = driverUtil.getTextByXpath(ImmediateAgent);
                String getImmediateAgent = a1.substring(0,a1.indexOf("人"));
                System.out.println("下级代理人数："+getLowerSpreadAgent);
                System.out.println("直属推广代理人数："+getImmediateAgent);
                driverUtil.findElementByXpathAndClick(clickLowerSpreadAgent);
                Thread.sleep(2000);
                String getImmediateAgent2 = driverUtil.getTextByXpath(ImmediateAgent2);
                String b1 = getImmediateAgent2.substring(2,getImmediateAgent2.indexOf(" 条"));
                driverUtil.findElementByXpathAndClick(reset);
                Thread.sleep(2000);
                String b2 = driverUtil.getTextByXpath(lowerSpreadAgent2);
                String getLowerSpreadAgent2 = b2.substring(2,b2.indexOf(" 条"));
                System.out.println("现金推广直推代理："+b1);
                System.out.println("现金推广代理下级代理："+getLowerSpreadAgent2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(b1,getImmediateAgent);
                Assertion.verifyEquals(getLowerSpreadAgent,getLowerSpreadAgent2);
                Assert.assertTrue(Assertion.currentFlag());
        }


        @AfterTest
        public void close(){
                driverUtil.loginAfter();
        }

}
