package CashAgent;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import UtilTest.StringToNumber;

import java.math.BigDecimal;

public class MyCommissionAccountChangeTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://koudai.oneonewan.com/?#/login";
        String username = "44444";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";



         /***
         *
         * 点击我的佣金账户变动
         * @获取变动金额
         * 获取变动前金额
         * @获取变动后金额
         * ***/

        String myCommissionAccount = "//*[@id=\"rest_promotion_agent_recharge_record\"]/li/span";
        String changeMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/div/span";
        String changeMoneyBefore = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div";
        String changeMoneyAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div";

        @Features("现金代理")
        @Stories("我的佣金账户变动")
        @Title("验证我的佣金账户变动数据")
        @Test(priority = 8)
        public void myCommissionAccountChange() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"我的佣金账户变动");
                driverUtil.findElementByXpathAndClick(myCommissionAccount);
                Thread.sleep(2000);
                String a1 = driverUtil.getTextByXpath(changeMoney);
                String b1 = driverUtil.getTextByXpath(changeMoneyBefore);
                String c1 = driverUtil.getTextByXpath(changeMoneyAfter);
                BigDecimal getChangeMoney = StringToNumber.toBigDecimal(a1);
                BigDecimal getChangeMoneyBefore = StringToNumber.toBigDecimal(b1);
                BigDecimal getChangeMoneyAfter = StringToNumber.toBigDecimal(c1);
                System.out.println("变动金额："+getChangeMoney);
                System.out.println("变动前金额："+getChangeMoneyBefore);
                System.out.println("变动后金额："+getChangeMoneyAfter);
                String a2 = a1.substring(0,1);
                if (a2.equals("-")){
                        BigDecimal result = getChangeMoneyBefore.subtract(getChangeMoney);
                        System.out.println("结果金额等于变动后金额："+result);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getChangeMoneyAfter,result);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! a2.equals("-")){
                        BigDecimal commissionProduce = getChangeMoneyBefore.add(getChangeMoney);
                        System.out.println("结果金额等于变动后金额："+commissionProduce);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(getChangeMoneyAfter,commissionProduce);
                        Assert.assertTrue(Assertion.currentFlag());
                }
        }


}
