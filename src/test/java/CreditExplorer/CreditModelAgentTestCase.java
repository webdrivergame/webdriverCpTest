package CreditExplorer;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;

public class CreditModelAgentTestCase {
        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://binli.oneonewan.com/#/login";
        String username = "zongguan001";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";



         /***
         *
         * 信用代理
         * 点击自运营代理页面
         * @获取账户余额
         * @获取状态
         *
         * ***/

        String creditModelAgent = "//*[@id=\"rest_system_agent_list\"]/li/span";
        String clickAgent = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span";
        String accountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/div/div/span";
        String status = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div/div/span";


        @Features("信用总管")
        @Stories("信用模式代理")
        @Title("验证自运营代理当前账户余额为正,状态为启用;余额为负，状态为禁用")
        @Test(priority = 1)
        public void EnableOrDisable() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式代理");
                driverUtil.findElementByXpathAndClick(creditModelAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickAgent);
                Thread.sleep(2000);
                String getStatus = driverUtil.getTextByXpath(status);
                String getAccountBalance = driverUtil.getTextByXpath(accountBalance);
                String a1 = getAccountBalance.substring(0,1);
                System.out.println("截断："+a1);
                if (a1.equals("-")){
                        System.out.println("账户余额："+getAccountBalance+",禁用");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getStatus,"禁用");
                        Assert.assertTrue(Assertion.currentFlag());
                }else {
                        System.out.println("账户余额："+getAccountBalance+",启用");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getStatus,"启用");
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


         /***
         *
         * 点击服务费总计降序
         * @获取第一金额
         * @获取第二金额
         * @获取第三金额
         * @获取第四金额
         *
         * ***/

        String serviceTotalDesc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/table/thead/tr/th[6]/div/span/i[2]";
        String numberOneMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[6]/div/div/span";
        String numberTwoMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[6]/div/div/span";
        String numberThreeMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[6]/div/div/span";
        String numberFourMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[4]/td[6]/div/div/span";


        @Features("信用总管")
        @Stories("信用模式代理")
        @Title("验证代理服务费总计降序排列")
        @Test(priority = 3)
        public void serviceTotalDesc() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"信用模式代理");
                driverUtil.findElementByXpathAndClick(creditModelAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(clickAgent);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(serviceTotalDesc);
                Thread.sleep(2000);
                String getNumberOneMoney = driverUtil.getTextByXpath(numberOneMoney);
                String getNumberTwoMoney = driverUtil.getTextByXpath(numberTwoMoney);
                String getNumberThreeMoney = driverUtil.getTextByXpath(numberThreeMoney);
                String getNumberFourMoney = driverUtil.getTextByXpath(numberFourMoney);
                System.out.println("降序排列金额1："+getNumberOneMoney);
                System.out.println("降序排列金额2："+getNumberTwoMoney);
                System.out.println("降序排列金额3："+getNumberThreeMoney);
                System.out.println("降序排列金额4："+getNumberFourMoney);
                if (getNumberOneMoney.equals("0.000") & getNumberTwoMoney.equals("0.000")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getNumberOneMoney,getNumberTwoMoney);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getNumberOneMoney.equals("0.000")){
                        BigDecimal a1 = StringToNumber.toBigDecimal(getNumberOneMoney);
                        BigDecimal a2 = StringToNumber.toBigDecimal(getNumberTwoMoney);
                        BigDecimal a3 = StringToNumber.toBigDecimal(getNumberThreeMoney);
                        BigDecimal a4 = StringToNumber.toBigDecimal(getNumberFourMoney);
                        int result = a1.compareTo(a2);
                        int result2 = a2.compareTo(a3);
                        int result3 = a3.compareTo(a4);
                        System.out.println("1为大于，-1为小于，0为等于："+result);
                        System.out.println("1为大于，-1为小于，0为等于："+result2);
                        System.out.println("1为大于，-1为小于，0为等于："+result3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result,1);
                        Assertion.verifyEquals(result2,1);
                        Assertion.verifyEquals(result3,1);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

        //服务费总计升序排列

        String serviceTotalAsc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/table/thead/tr/th[6]/div/span/i[1]";

        @Features("信用总管")
        @Stories("信用模式代理")
        @Title("验证代理服务费总计升序排列")
        @Test(priority = 4)
        public void serviceTotalAsc() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(serviceTotalAsc);
                Thread.sleep(2000);
                String getNumberOneMoney = driverUtil.getTextByXpath(numberOneMoney);
                String getNumberTwoMoney = driverUtil.getTextByXpath(numberTwoMoney);
                String getNumberThreeMoney = driverUtil.getTextByXpath(numberThreeMoney);
                String getNumberFourMoney = driverUtil.getTextByXpath(numberFourMoney);
                System.out.println("升序排列金额1："+getNumberOneMoney);
                System.out.println("升序排列金额2："+getNumberTwoMoney);
                System.out.println("升序排列金额3："+getNumberThreeMoney);
                System.out.println("升序排列金额4："+getNumberFourMoney);
                if (getNumberOneMoney.equals("0.000") & getNumberTwoMoney.equals("0.000")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getNumberOneMoney,getNumberTwoMoney);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getNumberOneMoney.equals("0.000")) {
                        BigDecimal a1 = StringToNumber.toBigDecimal(getNumberOneMoney);
                        BigDecimal a2 = StringToNumber.toBigDecimal(getNumberTwoMoney);
                        BigDecimal a3 = StringToNumber.toBigDecimal(getNumberThreeMoney);
                        BigDecimal a4 = StringToNumber.toBigDecimal(getNumberFourMoney);
                        int result = a1.compareTo(a2);
                        int result2 = a2.compareTo(a3);
                        int result3 = a3.compareTo(a4);
                        System.out.println("1为大于，-1为小于，0为等于：" + result);
                        System.out.println("1为大于，-1为小于，0为等于：" + result2);
                        System.out.println("1为大于，-1为小于，0为等于：" + result3);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result, -1);
                        Assertion.verifyEquals(result2, -1);
                        Assertion.verifyEquals(result3, -1);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

        //账户余额降序排列

        String accountBalanceDesc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/table/thead/tr/th[7]/div/span/i[2]";
        String NumberOneAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[1]/td[7]/div/div/span";
        String NumberTwoAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[2]/td[7]/div/div/span";
        String NumberThreeAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[3]/td[7]/div/div/span";
        String NumberFourAccountBalance = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[3]/table/tbody/tr[4]/td[7]/div/div/span";

        @Features("信用总管")
        @Stories("信用模式代理")
        @Title("验证代理当前账户余额降序排列")
        @Test(priority = 5)
        public void accountBalanceDesc() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(accountBalanceDesc);
                Thread.sleep(2000);
                String getNumberOneAccountBalance = driverUtil.getTextByXpath(NumberOneAccountBalance);
                String getNumberTwoAccountBalance = driverUtil.getTextByXpath(NumberTwoAccountBalance);
                String getNumberThreeAccountBalance = driverUtil.getTextByXpath(NumberThreeAccountBalance);
                String getNumberFourAccountBalance = driverUtil.getTextByXpath(NumberFourAccountBalance);
                System.out.println("账户余额降序排列1："+getNumberOneAccountBalance);
                System.out.println("账户余额降序排列2："+getNumberTwoAccountBalance);
                System.out.println("账户余额降序排列3："+getNumberThreeAccountBalance);
                System.out.println("账户余额降序排列4："+getNumberFourAccountBalance);
                if (getNumberOneAccountBalance.equals("0.000") & getNumberTwoAccountBalance.equals("0.000")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getNumberOneAccountBalance,getNumberTwoAccountBalance);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getNumberOneAccountBalance.equals("0.000")){
                        BigDecimal a1 = StringToNumber.toBigDecimal(getNumberOneAccountBalance);
                        BigDecimal a2 = StringToNumber.toBigDecimal(getNumberTwoAccountBalance);
                        BigDecimal a3 = StringToNumber.toBigDecimal(getNumberThreeAccountBalance);
                        BigDecimal a4 = StringToNumber.toBigDecimal(getNumberFourAccountBalance);
                        int result = a1.compareTo(a2);
                        int result2 = a2.compareTo(a3);
                        int result3 = a3.compareTo(a4);
                        System.out.println("1为大于，-1为小于，0为等于：" + result);
                        System.out.println("1为大于，-1为小于，0为等于：" + result2);
                        System.out.println("1为大于，-1为小于，0为等于：" + result3);
                        System.out.println("去重");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result, 1);
                        Assertion.verifyEquals(result2, 1);
                        Assertion.verifyEquals(result3, 1);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

        String setAccountBalanceAsc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/table/thead/tr/th[7]/div/span/i[1]";


        @Features("信用总管")
        @Stories("信用模式代理")
        @Title("验证账户余额升序排列")
        @Test(priority = 6)
        public void setAccountBalanceAsc() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(setAccountBalanceAsc);
                Thread.sleep(2000);
                String getNumberOneAccountBalance = driverUtil.getTextByXpath(NumberOneAccountBalance);
                String getNumberTwoAccountBalance = driverUtil.getTextByXpath(NumberTwoAccountBalance);
                String getNumberThreeAccountBalance = driverUtil.getTextByXpath(NumberThreeAccountBalance);
                String getNumberFourAccountBalance = driverUtil.getTextByXpath(NumberFourAccountBalance);
                System.out.println("账户余额升序排列1："+getNumberOneAccountBalance);
                System.out.println("账户余额升序排列2："+getNumberTwoAccountBalance);
                System.out.println("账户余额升序排列3："+getNumberThreeAccountBalance);
                System.out.println("账户余额升序排列4："+getNumberFourAccountBalance);
                if (getNumberOneAccountBalance.equals("0.000") & getNumberTwoAccountBalance.equals("0.000")){
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getNumberOneAccountBalance,getNumberTwoAccountBalance);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! getNumberOneAccountBalance.equals("0.000")) {
                        BigDecimal a1 = StringToNumber.toBigDecimal(getNumberOneAccountBalance);
                        BigDecimal a2 = StringToNumber.toBigDecimal(getNumberTwoAccountBalance);
                        BigDecimal a3 = StringToNumber.toBigDecimal(getNumberThreeAccountBalance);
                        BigDecimal a4 = StringToNumber.toBigDecimal(getNumberFourAccountBalance);
                        int result = a1.compareTo(a2);
                        int result2 = a2.compareTo(a3);
                        int result3 = a3.compareTo(a4);
                        System.out.println("1为大于，-1为小于，0为等于：" + result);
                        System.out.println("1为大于，-1为小于，0为等于：" + result2);
                        System.out.println("1为大于，-1为小于，0为等于：" + result3);
                        System.out.println("去重");
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result, -1);
                        Assertion.verifyEquals(result2, -1);
                        Assertion.verifyEquals(result3, -1);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


}
