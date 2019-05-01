package Admin;

import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import SeleniumMethod.WebDriverUtil;

public class BusinessDetailCreditTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);
        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";



          /*** *

         *  点击信用模式代理
         *  输入商户zongguan001
         *  查询
         *  点击商户跳转详情
         * @获取商户历史服务费总计
         *  进入下级服务费统计
         *  输入商户zongguan001
         *  查询
         * @获取商户生成服务费金额
         *
                 * ***/

        String clickCreditModelAgent = "//*[@id=\"rest_system_agent_list\"]/li/span";
        String inputBusinessInquire = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String Inquire = "//*[@id=\"submit\"]/span";
        String clickCreditBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a";
        String creditExplorerServiceHistoryTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span";
        String lowerServiceStatistics = "//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span";
        String inputBusiness2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String creditExplorerServiceHistoryTotal1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div";

        //------------------------------------------验证信用商户历史服务费总计-------------------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用商户运营数据-历史服务费总计与下级服务费统计该商户的生成服务费总计金额一致")
        @Test(priority = 14)
        public void creditExplorerServiceHistoryTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusinessInquire, "zongguan001");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditBusiness);
                Thread.sleep(2000);
                String getCreditExplorerServiceHistoryTotal = driverUtil.getTextByXpath(creditExplorerServiceHistoryTotal);
                System.out.println("商户历史服务费总计：" + getCreditExplorerServiceHistoryTotal);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness2, "zongguan001");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                String getCreditExplorerServiceHistoryTotal1 = driverUtil.getTextByXpath(creditExplorerServiceHistoryTotal1);
                System.out.println("下级服务费统计-生成服务费总计：" + getCreditExplorerServiceHistoryTotal1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getCreditExplorerServiceHistoryTotal, getCreditExplorerServiceHistoryTotal1);
                Assert.assertTrue(Assertion.currentFlag());
        }

          /***

         *  点击信用模式代理
         *  输入商户zongguan001
         *  查询
         *  点击商户跳转详情
         * @获取商户服务费账户余额
         *  进入下级服务费统计
         *  输入商户zongguan001
         *  查询
         * @获取商户今日结算后余额

                 ****/

        String serviceAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span";
        String settlementBalanceAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[7]/div/div/span";

        //------------------------------------------------验证信用商户服务费账户余额--------------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用商户运营数据-服务费账户余额与下级服务费统计-当前账户余额是否一致")
        @Test(priority = 15)
        public void creditExplorerAccountBalance() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusinessInquire, "zongguan001");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditBusiness);
                Thread.sleep(2000);
                String getServiceAccountBalance = driverUtil.getTextByXpath(serviceAccountBalance);
                System.out.println("商户服务费账户余额：" + getServiceAccountBalance);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness2, "zongguan001");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                String getSettlementBalanceAfterToady = driverUtil.getTextByXpath(settlementBalanceAfter);
                System.out.println("下级服务费统计-当前账户余额：" + getSettlementBalanceAfterToady);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getSettlementBalanceAfterToady, getServiceAccountBalance);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /**
         *  点击信用模式代理
         *  输入商务wxjb66
         *  查询
         *  点击商务跳转详情
         * @获取商务历史服务费总计
         *  进入下级服务费统计
         *  点击商务
         *  输入商务wxjb66
         *  查询
         * @获取商务生成服务费金额
         * ***/

        String inputLowerBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String lowerServiceHistory = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span/span";
        String clickLowerBusiness2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span";
        String serviceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div";
        String clickLowerCreditBusiness2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a";

        //----------------------------------------------验证信用商务历史服务费总计-------------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用商务运营数据-历史服务费总计与下级服务费统计该商务的生成服务费总计金额一致")
        @Test(priority = 16)
        public void creditBusinessServiceHistoryTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickLowerBusiness2);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputLowerBusiness, "wxjb66");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickLowerCreditBusiness2);
                Thread.sleep(2000);
                String getLowerServiceHistory = driverUtil.getTextByXpath(lowerServiceHistory);
                System.out.println("商务历史服务费总计："+getLowerServiceHistory);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickLowerBusiness2);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(sendKeysLowerBusiness,"wxjb66");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getServiceTotal = driverUtil.getTextByXpath(serviceTotal);
                System.out.println("商务生成服务费总计金额："+getServiceTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getLowerServiceHistory, getServiceTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /*****
         *  点击信用模式代理
         *  输入商务wxjb66
         *  查询
         *  点击商务跳转详情
         * @获取商务服务费账户余额
         *  进入下级服务费统计
         *  点击商务
         *  输入商务wxjb66
         *  查询
         * @获取商务今日结算后余额
         *
         *****/

        String lowerBusinessServiceAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span/span";
        String settlementBalanceToday = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[7]/div/div/span";
        String sendKeysLowerBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";

        //--------------------------------------------------验证信用商务服务费账户余额-----------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用商务运营数据-服务费账户余额与下级服务费统计-当前账户余额是否一致")
        @Test(priority = 17)
        public void creditBusinessServiceAccountBalance() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickLowerBusiness2);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputLowerBusiness, "wxjb66");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickLowerCreditBusiness2);
                Thread.sleep(2000);
                String getLowerBusinessServiceAccountBalance = driverUtil.getTextByXpath(lowerBusinessServiceAccountBalance);
                System.out.println("商务服务费账户余额："+getLowerBusinessServiceAccountBalance);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickLowerBusiness2);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(sendKeysLowerBusiness,"wxjb66");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getSettlementBalanceToday = driverUtil.getTextByXpath(settlementBalanceToday);
                System.out.println("商务当前账户余额："+getSettlementBalanceToday);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getLowerBusinessServiceAccountBalance, getSettlementBalanceToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /****
         *  点击信用模式代理
         *  输入信用代理wxjbdl1
         *  查询
         *  点击信用代理跳转详情
         * @获取信用代理历史服务费总计
         *  进入下级服务费统计
         *  点击信用代理
         *  输入信用代理wxjbdl1
         *  查询
         * @获取信用代理生成服务费总计
         * ***/

        String clickCreditAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span";
        String inputCreditAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String clickCreditAgent2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a";
        String creditAgentServiceHistoryTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span/span";
        String clickCreditAgent3 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span";
        String sendKeysCreditAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String creditAgentServiceTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[3]/div";

        //--------------------------------------------------验证信用代理历史服务费总计-----------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用代理运营数据-历史服务费总计与下级服务费的生成服务费总计是否一致")
        @Test(priority = 18)
        public void creditAgentServiceHistoryTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputCreditAgent, "wxjbdl1");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent2);
                Thread.sleep(2000);
                String getCreditAgentServiceHistoryTotal = driverUtil.getTextByXpath(creditAgentServiceHistoryTotal);
                System.out.println("信用代理历史服务费总计：" + getCreditAgentServiceHistoryTotal);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent3);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(sendKeysCreditAgent,"wxjbdl1");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getCreditAgentServiceTotal = driverUtil.getTextByXpath(creditAgentServiceTotal);
                System.out.println("信用代理生成服务费总计："+getCreditAgentServiceTotal);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getCreditAgentServiceHistoryTotal, getCreditAgentServiceTotal);
                Assert.assertTrue(Assertion.currentFlag());
        }

        /****
         *  点击信用模式代理
         *  输入信用代理wxjbdl1
         *  查询
         *  点击信用代理跳转详情
         * @获取信用代理服务费账户余额
         *  进入下级服务费统计
         *  点击信用代理
         *  输入信用代理wxjbdl1
         *  查询
         * @获取信用代理今日结算后余额
         * ***/

        String creditAgentAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span";
        String creditAgentServiceBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[7]/div/div/span";

        //--------------------------------------------------验证信用代理服务费账户余额-----------------------------------------------

        @Features("平台管理员")
        @Stories("信用代理详情")
        @Title("验证信用代理运营数据-信用代理服务费账户余额与下级服务费的当前账户余额是否一致")
        @Test(priority = 19)
        public void creditAgentServiceAccountBalance() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "信用模式代理");
                driverUtil.findElementByXpathAndClick(clickCreditModelAgent);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputCreditAgent, "wxjbdl1");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent2);
                Thread.sleep(2000);
                String getCreditAgentAccountBalance = driverUtil.getTextByXpath(creditAgentAccountBalance);
                System.out.println("信用代理服务费账户余额：" + getCreditAgentAccountBalance);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputText, "下级服务费统计");
                driverUtil.findElementByXpathAndClick(lowerServiceStatistics);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickCreditAgent3);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(sendKeysCreditAgent,"wxjbdl1");
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(2000);
                String getCreditAgentServiceBalance = driverUtil.getTextByXpath(creditAgentServiceBalance);
                System.out.println("信用代理当前账户余额："+getCreditAgentServiceBalance);
                Assertion.setFlag(true);
                Assertion.verifyEquals(getCreditAgentAccountBalance, getCreditAgentServiceBalance);
                Assert.assertTrue(Assertion.currentFlag());
        }




}