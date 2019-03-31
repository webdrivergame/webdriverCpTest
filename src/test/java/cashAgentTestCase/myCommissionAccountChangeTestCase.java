package cashAgentTestCase;

import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import util.StringToNumber;

import java.math.BigDecimal;

public class myCommissionAccountChangeTestCase {
        public WebDriver driver;
        @Feature("现金代理")
        @Story("我的佣金账户变动")
        @Title("现金代理-我的佣金账户变动-验证我的佣金账户变动数据")
        @Test(priority = 1)
        public void myCommissionAccountChange() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_activity_manager\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_promotion_agent_recharge_record\"]/li/span");
                Thread.sleep(2000);
                String a1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[3]/div/div/span");
                String b1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[4]/div");
                String c1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div");
                BigDecimal changeMoney3 = StringToNumber.toBigDecimal(a1);
                BigDecimal changeMoneyBefore3 = StringToNumber.toBigDecimal(b1);
                BigDecimal changeMoneyAfter3 = StringToNumber.toBigDecimal(c1);
                System.out.println("变动金额："+changeMoney3);
                System.out.println("变动前金额："+changeMoneyBefore3);
                System.out.println("变动后金额："+changeMoneyAfter3);
                String a2 = a1.substring(0,1);
                if (a2.equals("-")){
                        BigDecimal result = changeMoneyBefore3.subtract(changeMoney3);
                        System.out.println("结果金额等于变动后金额："+result);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(changeMoneyAfter3,result);
                        Assert.assertTrue(Assertion.currentFlag());
                }else if (! a2.equals("-")){
                        BigDecimal commissionProduce = changeMoneyBefore3.add(changeMoney3);
                        System.out.println("结果金额等于变动后金额："+commissionProduce);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(changeMoneyAfter3,commissionProduce);
                        Assert.assertTrue(Assertion.currentFlag());
                }
                driverUtil.LoginAfter();

        }
}
