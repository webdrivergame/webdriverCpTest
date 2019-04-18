package CreditBusiness;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;

public class MyServiceAccountChangeTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://binli.oneonewan.com/#/login";
        String username = "wxjb66";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";



        /***
         *
         * 获取变动类型
         * 获取变动金额
         * 获取变动前金额
         * @获取变动后金额
         *
         * ***/
        String myServiceAccountChangeMoney = "//*[@id=\"rest_system_agent_recharge_record\"]/li/span";
        String changeWhy = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[2]/div";
        String changeMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/div/span";
        String changeMoneyBefore = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        String changeMoneyAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";

        //-----------------------------------------------验证变动后金额计算------------------------------------------------

        @Features("信用代理")
        @Stories("首页")
        @Title("验证变动金额是否等于变动前与变动后金额计算值")
        @Test(priority = 6)
        public void myServiceAccountChangeMoney() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"我的服务费账户变动");
                driverUtil.findElementByXpathAndClick(myServiceAccountChangeMoney);
                Thread.sleep(2000);
                String getChangeWhy = driverUtil.getTextByXpath(changeWhy);
                String getChangeMoney = driverUtil.getTextByXpath(changeMoney);
                String getChangeMoneyBefore = driverUtil.getTextByXpath(changeMoneyBefore);
                String getChangeMoneyAfter = driverUtil.getTextByXpath(changeMoneyAfter);
                BigDecimal a1 = StringToNumber.toBigDecimal(getChangeMoney);
                BigDecimal b1 = StringToNumber.toBigDecimal(getChangeMoneyBefore);
                BigDecimal c1 = StringToNumber.toBigDecimal(getChangeMoneyAfter);
                if (getChangeWhy.equals("赠送服务费")){
                        BigDecimal result = b1.add(a1);
                        System.out.println("去重3");
                        System.out.println("赠送服务费");
                        System.out.println("变动前金额加变动金额："+b1+"+"+a1+"="+result);
                        System.out.println("变动后金额："+c1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result,c1);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (getChangeWhy.equals("缴款")){
                        BigDecimal result2 = b1.add(a1);
                        System.out.println("去重1");
                        System.out.println("缴款");
                        System.out.println("变动前金额加变动金额："+b1+"+"+a1+"="+result2);
                        System.out.println("变动后金额："+c1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result2,c1);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (getChangeWhy.equals("服务费")){
                        String d1 = getChangeMoney.substring(1);
                        BigDecimal d2 = StringToNumber.toBigDecimal(d1);//d2=变动金额
                        BigDecimal result3 = b1.subtract(d2);
                        System.out.println("去重2");
                        System.out.println("服务费");
                        System.out.println("变动前金额减变动金额："+b1+"-"+d2+"="+result3);
                        System.out.println("变动后金额："+c1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result3,c1);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }

        /***
         *
         * @获取昨日变动后金额
         * @获取今日变动前金额
         * ***/

        String changeMoneyAfterYesterday = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[2]/td[5]/div";
        String changeMoneyBeforeToday = "//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";

        //-------------------------------------------验证昨日变动后金额=今日变动前金额-----------------------------------------

        @Features("信用代理")
        @Stories("我的服务费账户变动")
        @Title("验证昨日变动后金额是否等于今日变动前金额")
        @Test(priority = 7)
        public void changeMoney(){
                String getChangeMoneyAfterYesterday = driverUtil.getTextByXpath(changeMoneyAfterYesterday);
                String getChangeMoneyBeforeToday = driverUtil.getTextByXpath(changeMoneyBeforeToday);
                System.out.println("昨日变动后金额："+getChangeMoneyAfterYesterday);
                System.out.println("今日变动前金额："+getChangeMoneyBeforeToday);
                System.out.println("去重");
                Assertion.setFlag(true);
                Assertion.verifyEquals(getChangeMoneyAfterYesterday,getChangeMoneyBeforeToday);
                Assert.assertTrue(Assertion.currentFlag());
        }

        @AfterTest
        public void close(){
                driverUtil.loginAfter();
        }
}
