package creditAgentTestCase;

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

public class creditAgentHomeTestCase {

        private WebDriver driver;
        @Feature("信用代理首页")
        @Story("账户余额")
        @Title("信用代理首页-验证首页账户余额与跳转页面服务费金额减去已缴款金额是否一致")
        @Test(priority = 1)
        public void accountBalance() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String accountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[2]");
                System.out.println("首页账户余额："+accountBalance);
                BigDecimal a1 = StringToNumber.toBigDecimal(accountBalance).abs();
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                        Thread.sleep(2000);
                String serviceAccountBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/div[1]/li/span[2]");
                System.out.println("服务费金额总计："+serviceAccountBalance);
                String balanceTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/div[2]/li/span[2]");
                System.out.println("缴款金额总计："+balanceTotal);
                BigDecimal b1 = StringToNumber.toBigDecimal(serviceAccountBalance).abs();
                BigDecimal d1 = b1.subtract(StringToNumber.toBigDecimal(balanceTotal)).abs();
                System.out.println("结果对比首页金额："+d1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,d1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("信用代理首页")
        @Story("玩家欠款")
        @Title("信用代理首页-验证玩家欠款总计金额是否正确")
        @Test(priority = 2)
        public void playerArrearsTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String playerArrearsTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]");
                System.out.println("玩家欠款总计："+playerArrearsTotal);
                BigDecimal a1 = StringToNumber.toBigDecimal(playerArrearsTotal).abs();
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                        Thread.sleep(2000);
                String playerArrearsTotal1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[1]/div/h4/span/i");
                BigDecimal b1 = StringToNumber.toBigDecimal(playerArrearsTotal1).abs();
                System.out.println("玩家欠款总计:"+playerArrearsTotal1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,b1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

        @Feature("信用代理首页")
        @Story("下级服务费欠款总计")
        @Title("信用代理首页-验证下级服务费欠款总计是否正确")
        @Test(priority = 3)
        public void lowerServiceArrearsTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String lowerServiceArrearsTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[2]");
                BigDecimal a1 = StringToNumber.toBigDecimal(lowerServiceArrearsTotal).abs();
                System.out.println("下级服务费欠款总计："+a1);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                        Thread.sleep(2000);
                String arrearsTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/div/div[1]/div/li/span[2]");
                BigDecimal b1 = StringToNumber.toBigDecimal(arrearsTotal).abs();
                System.out.println("总欠款："+arrearsTotal);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(a1,b1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

        @Feature("信用代理首页")
        @Story("自运营玩家数")
        @Title("信用代理首页-验证自运营玩家数是否正确")
        @Test(priority = 4)
        public void SinceOperationsPlayerNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String SinceOperationsPlayerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[1]");
                System.out.println("首页自运营玩家："+SinceOperationsPlayerNumber);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                driverUtil.WebElementWaitLocated("//*[@id=\"reset\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"reset\"]/span");
                        Thread.sleep(3000);
                String playerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]");
                String b1 = playerNumber.substring(2,playerNumber.indexOf("条"));
                System.out.println("玩家账号管理玩家："+b1);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(SinceOperationsPlayerNumber,b1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

        @Feature("信用代理首页")
        @Story("下级自运营代理人数")
        @Title("信用代理-验证下级自运营代理人数是否正确")
        @Test(priority = 5)
        public void lowerSinceOperationsAgentNumber() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String lowerSinceOperationsAgentNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[5]/div/div/div/div[1]/div[2]/div[2]/span/span[1]");
                System.out.println("首页下级自运营代理人数："+lowerSinceOperationsAgentNumber);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div[5]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                driverUtil.WebElementWaitLocated("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div/div[1]/div[3]/div/div/div/input");
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[1]/div/form/div[1]/div/div[1]/div[3]/div/div/div/input");
                driverUtil.findElementByXpathAndClick("/html/body/div[6]/div[1]/div[1]/ul/li[2]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                driverUtil.WebElementWaitLocated("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[3]/span[1]");
                String agentNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div/div[3]/span[1]");
                String a1 = agentNumber.substring(2,4);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(lowerSinceOperationsAgentNumber,a1);
                        Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }
}
