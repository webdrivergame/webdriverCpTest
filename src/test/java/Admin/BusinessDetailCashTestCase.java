package Admin;

import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;

import java.math.BigDecimal;

public class BusinessDetailCashTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";



        /***
         *
         * 点击现金推广代理
         * 输入商户qaxjtg01
         * 查询
         * @获取商户推广玩家总数
         * 点击玩家总数跳转
         * @获取玩家管理商户总人数
         *
         * ***/

        String clickCashAgent = "//*[@id=\"rest_system_agent_cash_list\"]/li/span";
        String businessPlayerTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[6]/div/a";
        String PlayerAdminNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        //---------------------------------------------验证商户详情推广玩家总数----------------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证推广玩家总数")
        @Test(priority = 1)
        public void BusinessPlayerTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                String getBusinessPlayerTotal = driverUtil.getTextByXpath(businessPlayerTotal);
                BigDecimal a1 = StringToNumber.toBigDecimal(getBusinessPlayerTotal);
                BigDecimal a2 = a1.add(new BigDecimal(5));
                System.out.println("商户推广玩家总数(加上测试玩家)："+a2);
                driverUtil.findElementByXpathAndClick(businessPlayerTotal);
                Thread.sleep(4000);
                String getPlayerAdminNumber = driverUtil.getTextByXpath(PlayerAdminNumber);
                String b1 = getPlayerAdminNumber.substring(2,getPlayerAdminNumber.indexOf(" 条"));
                BigDecimal b2 = StringToNumber.toBigDecimal(b1);
                System.out.println("玩家管理商户人数："+b2);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a2,b2);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取直属下级人数
         * 点击下级详情
         * @获取页面代理条数
         *
         * ***/

        String ImmediateLowerNumber = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[4]/div/span";
        String clickLower = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[13]/div/div/div/div/a[1]";
        String agentNumberTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]";

        //----------------------------------------------验证直属下级人数-------------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证直属下级人数")
        @Test(priority = 2)
        public void ImmediateLowerNumber() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                String getImmediateLowerNumber = driverUtil.getTextByXpath(ImmediateLowerNumber);
                System.out.println("直属下级人数："+getImmediateLowerNumber);
                driverUtil.findElementByXpathAndClick(clickLower);
                Thread.sleep(3000);
                String getAgentNumberTotal = driverUtil.getTextByXpath(agentNumberTotal);
                String a1 = getAgentNumberTotal.substring(2,getAgentNumberTotal.indexOf(" 条"));
                System.out.println("下级跳转后人数："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getImmediateLowerNumber,a1);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取现金代理商户税收总计
         * 下级经营明细
         * @获取税收总计
         * 现金模式游戏输赢统计
         * @获取今日税收
         * 判断现金代理商户税收总计+今日税收=下级经营明细税收总计
         *
         * ***/

        String clickAdmin = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[2]/div/span[1]/span[1]/a";
        String taxTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[7]/div";
        String lowerRunDetails = "//*[@id=\"rest_cash_engage_detail_list\"]/li/span";
        String taxTotal2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[6]/div";
        String cashModelGameLoseOrWin = "//*[@id=\"rest_cash_game_win_lose_list\"]/li/span";
        String taxToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[8]/div";

        //----------------------------------------------验证现金代理商户税收总计--------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证现金代理商户税收总计金额等于下级经营明细税收减去今日税收")
        @Test(priority = 3)
        public void taxTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(clickAdmin);
                Thread.sleep(2000);
                String getTaxTotal = driverUtil.getTextByXpath(taxTotal);
                System.out.println("现金商户税收总计:"+getTaxTotal);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(lowerRunDetails);
                Thread.sleep(2000);
                String getTaxTotal2 = driverUtil.getTextByXpath(taxTotal2);
                BigDecimal taxTotal2Result = StringToNumber.toBigDecimal(getTaxTotal2);
                System.out.println("下级经营明细税收总计："+getTaxTotal2);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金模式游戏输赢统计");
                driverUtil.findElementByXpathAndClick(cashModelGameLoseOrWin);
                Thread.sleep(200);
                String getTaxToday = driverUtil.getTextByXpath(taxToday);
                System.out.println("现金游戏输赢今日税收："+getTaxToday);
                BigDecimal a1 = StringToNumber.toBigDecimal(getTaxTotal);
                BigDecimal b1 = StringToNumber.toBigDecimal(getTaxToday);
                BigDecimal result = a1.add(b1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(taxTotal2Result,result);
                Assert.assertTrue(Assertion.currentFlag());
        }

         /***
         *
         * @获取首页今日佣金
         * @获取下级经营明细所有商户佣金总计
         * @获取现金代理所有商户佣金总计
         * 判断今日佣金+现金代理所有商户佣金=下级经营明细所有商户佣金总计
         *
         * **/

        String homeCommissionToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[1]/div/div/div[3]/table/tbody/tr[1]/td[8]/div/div";
        String lowerCommissionBusiness2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[7]/div";
        String lowerCommissionBusiness3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[7]/div";
        String lowerCommissionBusiness4 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/div";
        String agentCommissionBusiness2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[9]/div/div/span";
        String agentCommissionBusiness3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[9]/div/div/span";
        String agentCommissionBusiness4 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[9]/div/div/span";

        //-------------------------------------------验证现金代理所有商户佣金---------------------------------------------

        @Features("平台管理员")
        @Stories("现金商户详情")
        @Title("验证现金代理商户佣金总计金额等于下级经营明细佣金减去今日佣金")
        @Test(priority = 4)
        public void BusinessCommissionTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"首页");
                driverUtil.findElementByXpathAndClick(adminHome);
                Thread.sleep(2000);
                String getHomeCommissionToday = driverUtil.getTextByXpath(homeCommissionToday);
                BigDecimal homeCommissionTodayResult = StringToNumber.toBigDecimal(getHomeCommissionToday);
                System.out.println("首页今日佣金："+getHomeCommissionToday);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级经营明细");
                driverUtil.findElementByXpathAndClick(lowerRunDetails);
                Thread.sleep(4000);
                String getLowerCommissionBusiness2 = driverUtil.getTextByXpath(lowerCommissionBusiness2);
                String getLowerCommissionBusiness3 = driverUtil.getTextByXpath(lowerCommissionBusiness3);
                String getLowerCommissionBusiness4 = driverUtil.getTextByXpath(lowerCommissionBusiness4);
                BigDecimal a2 = StringToNumber.toBigDecimal(getLowerCommissionBusiness2);
                BigDecimal a3 = StringToNumber.toBigDecimal(getLowerCommissionBusiness3);
                BigDecimal a4 = StringToNumber.toBigDecimal(getLowerCommissionBusiness4);
                BigDecimal lowerCommissionResult = a2.add(a3).add(a4);
                System.out.println("下级经营明细所有商户佣金总计："+lowerCommissionResult);
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"现金推广代理");
                driverUtil.findElementByXpathAndClick(clickCashAgent);
                Thread.sleep(2000);
                String getAgentCommissionBusiness2 = driverUtil.getTextByXpath(agentCommissionBusiness2);
                String getAgentCommissionBusiness3 = driverUtil.getTextByXpath(agentCommissionBusiness3);
                String getAgentCommissionBusiness4 = driverUtil.getTextByXpath(agentCommissionBusiness4);
                BigDecimal b2 = StringToNumber.toBigDecimal(getAgentCommissionBusiness2);
                BigDecimal b3 = StringToNumber.toBigDecimal(getAgentCommissionBusiness3);
                BigDecimal b4 = StringToNumber.toBigDecimal(getAgentCommissionBusiness4);
                BigDecimal AgentCommissionResult = b2.add(b3).add(b4);
                System.out.println("代理商户佣金总计："+AgentCommissionResult);
                BigDecimal overResult = AgentCommissionResult.add(homeCommissionTodayResult);
                Assertion.setFlag(true);
                Assertion.verifyEquals(overResult,lowerCommissionResult);
                Assert.assertTrue(Assertion.currentFlag());

        }



}
