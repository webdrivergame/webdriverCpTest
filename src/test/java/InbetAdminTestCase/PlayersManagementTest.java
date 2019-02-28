package InbetAdminTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

public class PlayersManagementTest {
        private WebDriver driver;

        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证玩家账号搜索玩家")
        @Test(priority = 2)//测试玩家账号搜索玩家和重置功能

        public void playersAccountManagement() throws InterruptedException {

            //调用登录
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin", "123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);


            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //判断玩家账号是否能搜索该玩家
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/input", "b57609");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(3000);
            String playerNumberList = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(playerNumberList,"b57609");
                Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }

        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证玩家昵称搜索玩家")
        @Test(priority = 3)//测试玩家昵称搜索玩家和重置

        public void playerName() throws InterruptedException {
            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);

            //判断玩家昵称是否能搜索到玩家
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[3]/div/div/input", "b57609");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
            driverUtil.isElementExist(By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a"));
            String playerNumberList = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

            Assertion.setFlag(true);
            Assertion.verifyEquals(playerNumberList,"b57609");
            Assert.assertTrue(Assertion.currentFlag());
            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证所属商务搜索")
        @Test(priority = 3)

        public void belongBusiness() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);
            //所属商务搜索
            driverUtil.findElementByXpathAndClick("(.//*[normalize-space(text()) and normalize-space(.)='返回'])[1]/following::div[1]");
            driverUtil.findElementByXpathAndClick("(.//*[normalize-space(text()) and normalize-space(.)='重置'])[1]/following::span[1]");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[1]/div/div/input","qaxjtg01");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String belongBusiness = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(belongBusiness,"qaxjtg01");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }

        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证所属代理搜索")
        @Test
        public void belongAgent() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);
            //所属代理搜索
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[2]/div/div/input","wxjbdl");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String belongAgent = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(belongAgent,"wxjbdl");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();

        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证所属推广代理搜索")
        @Test
        public void belongSpreadAgent() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);
            //所属代理搜索
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[3]/div/div/input","ddddd");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String belongSpreadAgent = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[2]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(belongSpreadAgent,"ddddd");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();

        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证手机号码搜索")

        @Test(enabled = false)//测试手机号搜索玩家和重置

            public void phoneNumber() throws InterruptedException {

                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.LoginBefore("http://192.168.1.9:9091");
                driverUtil.adminlogin("xiaochaoadmin","123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                    Thread.sleep(4000);

                //进入玩家管理
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                    Thread.sleep(4000);
                driverUtil.findElementByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");
                driverUtil.scrollToRight();
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();","<span>展开更多筛选</span>");//滚动到该元素
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");


                //判断手机号是否能搜索玩家
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div/input", "15545645622");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                    Thread.sleep(3000);
                String PhoneNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(PhoneNumber,"b57609");
                    Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
                }

        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证支付宝账号搜索")

        @Test(enabled = false)//测试支付宝搜索玩家和重置

            public void alipayNumber() throws InterruptedException {

                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.LoginBefore("http://192.168.1.9:9091");
                driverUtil.adminlogin("xiaochaoadmin","123123");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                    Thread.sleep(4000);

                //进入玩家管理
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                    Thread.sleep(4000);

                //driverUtil8.scrollToElement("<span>展开更多筛选</span>");//滚动到该元素
                driverUtil.scrollToRight();
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");

                //支付宝账号是否能搜索玩家
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[5]/div/div/input","13432344366");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                    Thread.sleep(3000);
                String alipyNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
                    Assertion.setFlag(true);
                    Assertion.verifyEquals(alipyNumber,"b57609");
                    Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
                }

        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证支付宝名字搜索")
        @Test
        public void alipayName() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //支付宝名字搜索
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[6]/div/div/input","纷纷");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String alipayName = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(alipayName,"b57609");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证银行卡搜索")
        @Test
        public void banNumber() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //银行卡搜索
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[8]/div/div/input","6217004223345675447");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String banNumber = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(banNumber,"b57609");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证银行卡姓名搜索")
        @Test
        public void banName() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理搜索玩家
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //银行卡姓名搜索
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[8]/div/div/input","刀丰");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String banName = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

                Assertion.setFlag(true);
                Assertion.verifyEquals(banName,"b57609");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证注册IP搜索")
        @Test
        public void registeredIp() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //注册IP搜索玩家
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[9]/div/div/input","192.168.1.8");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr[1]/td[1]/div/a");
            String registeredIp = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div[1]/div/div[2]/div/form/div[6]/div/span");

                Assertion.setFlag(true);
                Assertion.verifyEquals(registeredIp,"192.168.1.8");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证最后登录IP搜索")
        @Test
        public void loginIp() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //注册IP搜索玩家
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[10]/div/div/input","192.168.1.252");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr[1]/td[1]/div/a");
            String loginIp = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[1]/div[2]/div/div[2]/div/form/div[14]/div/span");

                Assertion.setFlag(true);
                Assertion.verifyEquals(loginIp,"192.168.1.252");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }


        @Feature("玩家管理")
        @Story("玩家账号管理")
        @Title("验证是否是机器人搜索")
        @Test
        public void rebot() throws InterruptedException {

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://192.168.1.9:9091");
            driverUtil.adminlogin("xiaochaoadmin","123123");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);

            //进入玩家管理
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
            driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(4000);

            //机器人选择否搜索，显示启用
            driverUtil.findElementByXpathAndClick("");
            driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[11]/div/div/div/input");
            driverUtil.findElementByXpathAndClick("/html/body/div[11]/div[1]/div[1]/ul/li[2]");
            driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                Thread.sleep(5000);
            String rebotNo = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[14]/div/span");

                Assertion.setFlag(true);
                Assertion.verifyEquals(rebotNo,"启用");
                Assert.assertTrue(Assertion.currentFlag());

            driverUtil.LoginAfter();
        }





}