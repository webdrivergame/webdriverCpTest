package adminTestCase;

import listenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class creditDetailTestCase {

        private WebDriver driver;


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商户运营数据-直属下级商务人数是否一致")
        @Test(priority = 1)
        public void creditExplorerNumber() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式商户详情
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","zongguan001");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditExplorerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div/span");
            System.out.println("下级商务人数："+creditExplorerNumber);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");




            //获取直属下级代理人数
            String creditExplorerNumber1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[1]/div/span");
            System.out.println("信用商户运营详情-直属下级商务人数："+creditExplorerNumber1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditExplorerNumber,creditExplorerNumber1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商户运营数据-历史服务费总计与下级服务费统计该商户的生成服务费总计金额一致")

        @Test(priority = 2)
        public void creditExplorerServiceHistoryTotal() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式商户详情
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","zongguan001");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditExplorerServiceHistoryTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span");
            //String player =   driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[3]/div/span");

                //System.out.println(sum+"----------------: "+val.toString());
                //new对象传参
                //BigDecimal val = new BigDecimal(creditExplorerServiceHistoryTotal);
                //BigDecimal sum = val.add(new BigDecimal(player));

            //System.out.println("总计："+sum);
            System.out.println("历史服务费总计："+creditExplorerServiceHistoryTotal);




            //获取商户生成服务费总计金额
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","zongguan001");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditExplorerServiceHistoryTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div");
            System.out.println("下级服务费统计-生成服务费总计："+creditExplorerServiceHistoryTotal1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditExplorerServiceHistoryTotal,creditExplorerServiceHistoryTotal1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商户运营数据-服务费账户余额与下级服务费统计-今日结算后余额是否一致")

        @Test(priority = 3)
        public void creditExplorerAccountBalance() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(4000);
            //信用模式商户详情
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","zongguan001");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditExplorerAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span");
            System.out.println("服务费账户余额："+creditExplorerAccountBalance);




            //获取下级服务费统计-今日结算后余额
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","zongguan001");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditExplorerAccountBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[8]/div/div/span");
            System.out.println("下级服务费统计-生成服务费总计："+creditExplorerAccountBalance1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditExplorerAccountBalance,creditExplorerAccountBalance1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商务运营数据-直属下级代理人数是否一致")

        @Test(priority = 4)
        public void creditBusinessNumber() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
            Thread.sleep(3000);
            //信用模式商务详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjb66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditBusinessNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[3]/table/tbody/tr/td[3]/div/span");
            System.out.println("商务下级人数"+creditBusinessNumber);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
                Thread.sleep(2000);
            //获取直属下级代理人数
            String creditBusinessNumber1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[1]/div/span");
            System.out.println("商务直属下级人数："+creditBusinessNumber1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditBusinessNumber,creditBusinessNumber1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商务运营数据-历史服务费总计与下级服务费统计该商务的生成服务费总计金额一致")

        @Test(priority = 5)
        public void creditBusinessServiceHistoryTotal() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式商务详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjb66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditBusinessServiceHistoryTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span");
            System.out.println("商务历史服务费总计："+creditBusinessServiceHistoryTotal);




            //获取商务生成服务费总计金额
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjb66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditBusinessServiceHistoryTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[4]/div");
            System.out.println("商务下级服务费统计-生成服务费总计："+creditBusinessServiceHistoryTotal1);
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(creditBusinessServiceHistoryTotal,creditBusinessServiceHistoryTotal1);
                    Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用商务运营数据-服务费账户余额与下级服务费统计-今日结算后余额是否一致")

        @Test(priority = 6)
        public void creditBusinessServiceAccountBalance() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式商务详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjb66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditBusinessServiceAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span");
            System.out.println("商务服务费账户余额："+creditBusinessServiceAccountBalance);





            //获取商务今日结算后余额
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span");
                Thread.sleep(2000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjb66");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditBusinessServiceAccountBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[8]/div/div/span");
            System.out.println("商务下级服务费统计-今日结算后余额："+creditBusinessServiceAccountBalance1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditBusinessServiceAccountBalance,creditBusinessServiceAccountBalance1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用代理运营数据-历史服务费总计与下级服务费的生成服务费总计是否一致")

        @Test(priority = 7)
        public void creditAgentServiceHistoryTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式代理详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjbdl1");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditBusinessServiceAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[4]/div/span");
            System.out.println("历史服务费总计："+creditBusinessServiceAccountBalance);




            //获取信用代理历史服务费总计
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjbdl1");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditBusinessServiceAccountBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[5]/div");
            System.out.println("信用代理下级服务费统计-生成服务费总计："+creditBusinessServiceAccountBalance1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditBusinessServiceAccountBalance,creditBusinessServiceAccountBalance1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("代理管理-信用模式代理")
        @Story("信用模式代理详情")
        @Title("信用模式代理详情-验证信用代理运营数据-信用代理服务费账户余额与下级服务费的今日结算后余额是否一致")

        @Test(priority = 8)
        public void creditAgentServiceAccountBalance() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.loginBefore("https://admin.oneonewan.com/#/login");
            driverUtil.adminLogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","信用模式代理");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_agent_list\"]/li/span");
                Thread.sleep(3000);
            //信用模式代理详情
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjbdl1");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            String creditAgentServiceAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div/div/div[2]/div/div[2]/div/div/form/div[5]/div/span");
            System.out.println("服务费账户余额："+creditAgentServiceAccountBalance);




            //获取服务费账户余额
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/div[1]/div[1]/div/input","下级服务费统计");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_sub_agent_recharge_record_statistics\"]/li/span");
                Thread.sleep(3000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[3]/li/span");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","wxjbdl1");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String creditAgentServiceAccountBalance1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[9]/div/div/span");
            System.out.println("信用代理下级服务费统计-今日结算后余额："+creditAgentServiceAccountBalance1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(creditAgentServiceAccountBalance,creditAgentServiceAccountBalance1);
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }





    }
