package cashAgentTestCase;


import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class cashAgentHomeTestCase {

        private WebDriver driver;

        @Feature("现金代理首页")
        @Story("今日收入")
        @Title("现金代理首页-验证今日收入金额与今日产生佣金账单金额一致")
        @Test(priority = 1)
        public  void incomeToday() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String incomeToday = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[2]");
                System.out.println("首页今日收入：" + incomeToday);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/form/div[1]/div/div[1]/div[2]/div/div/input[1]");
                driverUtil.findElementByXpathAndClick("/html/body/div[3]/div[1]/div[1]/button[1]");
                        Thread.sleep(2000);
                String myCommissionIncome = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/span[2]");
                System.out.println("今日我的佣金收入：" + myCommissionIncome);
                if (String.valueOf(myCommissionIncome) == "0.000") {
                        System.out.println("今日我的推广佣金账单未产生");
                }
                Assertion.setFlag(true);
                Assertion.verifyEquals(incomeToday, myCommissionIncome);
                Assert.assertTrue(Assertion.currentFlag());

                driverUtil.LoginAfter();
        }


        @Feature("现金代理首页")
        @Story("30日总收入")
        @Title("现今代理首页-验证30日总收入金额是否等于我的推广佣金账单30天金额")
        @Test(priority = 2)
        public void incomeTotalMonth() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String incomeTotalMonth = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[3]/div/span[2]");
                String a1 = incomeTotalMonth.substring(2);
                System.out.println("30日总收入："+a1);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/form/div[1]/div/div[1]/div[2]/div/div/input[1]");
                driverUtil.findElementByXpathAndClick("/html/body/div[3]/div[1]/div[1]/button[5]");
                        Thread.sleep(2000);
                String myCommissionIncomeMoths = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div/div[1]/div[2]/span[2]");
                System.out.println("现金代理首页30日我的佣金总账单："+myCommissionIncomeMoths);
                Assertion.setFlag(true);
                Assertion.verifyEquals(a1,myCommissionIncomeMoths);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("现金代理首页")
        @Story("待结算佣金")
        @Title("现金代理首页-验证首页待结算佣金金额是否等于我的佣金账户变动余额")
        @Test(priority = 3)
        public void waitSettlementCommission() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String waitSettlementCommission = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[2]");
                System.out.println("现今代理首页待结算佣金："+waitSettlementCommission);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/span");
                        Thread.sleep(2000);
                String afterChangeBalance = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div[3]/table/tbody/tr[1]/td[5]/div");
                System.out.println("变动后余额："+afterChangeBalance);
                Assertion.setFlag(true);
                Assertion.verifyEquals(waitSettlementCommission,afterChangeBalance);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("现今代理首页")
        @Story("玩家总数量")
        @Title("现金代理首页-验证首页玩家总数是否与玩家管理数量一致")
        @Test(priority = 4)
        public void playerNumberTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                String playerNumberTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[1]");
                System.out.println("首页玩家数量总计："+playerNumberTotal);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/div[3]/div/div/div/div[1]/div[2]/div[2]/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"reset\"]/span");
                        Thread.sleep(3000);
                String playerNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[3]/span[1]");
                String a1 = playerNumber.substring(2,playerNumber.indexOf(" 条"));//截取数值xx（共 xx 条）
                System.out.println("玩家管理玩家人数："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(playerNumberTotal,a1);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }

}
