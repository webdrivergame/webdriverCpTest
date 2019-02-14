package GameTestCase;

import ListenerPackage.Assertion;
import PublicMethod.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PlayersManagementTest {
        private WebDriver driver;
        private SoftAssert softAssert = new SoftAssert();

    @Test(priority = 2)//测试玩家账号搜索玩家和重置功能
    public void PlayersAccountManagement() throws InterruptedException {

        //实例对象调用登录
        WebDriverUtil driverUtil5 = new WebDriverUtil(driver);
        driverUtil5.LoginBefore();
        driverUtil5.adminlogin("xiaochaoadmin", "123123");
        driverUtil5.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入玩家管理
        driverUtil5.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil5.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);

        //判断玩家账号是否能搜索该玩家
        driverUtil5.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/input", "b57609");
        driverUtil5.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String PlayerNumberList = driverUtil5.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

            Assertion.setFlag(true);
            Assertion.verifyEquals(PlayerNumberList,"b57609");
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil5.LoginAfter();
    }


    @Test(priority = 3)//测试玩家昵称搜索玩家和重置
    public void PlayerName() throws InterruptedException {

        WebDriverUtil driverUtil6 = new WebDriverUtil(driver);
        driverUtil6.LoginBefore();
        driverUtil6.adminlogin("xiaochaoadmin","123123");
        driverUtil6.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入玩家管理
        driverUtil6.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil6.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);

        //判断玩家昵称是否能搜索到玩家
        driverUtil6.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[3]/div/div/input", "b57609");
        driverUtil6.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        driverUtil6.isElementExist(By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a"));
        String PlayerNumberList = driverUtil6.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");

            Assertion.setFlag(true);
            Assertion.verifyEquals(PlayerNumberList,"b57609");
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil6.LoginAfter();
        }


    @Test(enabled = false)//测试手机号搜索玩家和重置
    public void PhoneNumber() throws InterruptedException {

        WebDriverUtil driverUtil7 = new WebDriverUtil(driver);
        driverUtil7.LoginBefore();
        driverUtil7.adminlogin("xiaochaoadmin","123123");
        driverUtil7.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入玩家管理
        driverUtil7.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil7.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);
        driverUtil7.findElementByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");
        driverUtil7.scrollToRight();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();","<span>展开更多筛选</span>");//滚动到该元素
        driverUtil7.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");


        //判断手机号是否能搜索玩家
        driverUtil7.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[4]/div/div/input", "15545645622");
        driverUtil7.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String PhoneNumber = driverUtil7.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            Assertion.setFlag(true);
            Assertion.verifyEquals(PhoneNumber,"b57609");
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil7.LoginAfter();
        }


    @Test(enabled = false)//测试支付宝搜索玩家和重置
    public void AlipayNumber() throws InterruptedException {

        WebDriverUtil driverUtil8 = new WebDriverUtil(driver);
        driverUtil8.LoginBefore();
        driverUtil8.adminlogin("xiaochaoadmin","123123");
        driverUtil8.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入玩家管理
        driverUtil8.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil8.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);

        //driverUtil8.scrollToElement("<span>展开更多筛选</span>");//滚动到该元素
        driverUtil8.scrollToRight();
        driverUtil8.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[8]/span");

        //判断支付宝账号是否能搜索玩家
        driverUtil8.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[2]/div/div[5]/div/div/input","13432344366");
        driverUtil8.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        String AlipyNumber = driverUtil8.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[4]/div[2]/table/tbody/tr/td[1]/div/a");
            Assertion.setFlag(true);
            Assertion.verifyEquals(AlipyNumber,"b57609");
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil8.LoginAfter();
        }



    @Test(priority = 1)//测试编辑禁用玩家
    public void CompiledPlayer() throws InterruptedException {

        WebDriverUtil driverUtil9 = new WebDriverUtil(driver);
        driverUtil9.LoginBefore();
        driverUtil9.adminlogin("xiaochaoadmin","123123");
        driverUtil9.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);

        //进入玩家管理搜索玩家
        driverUtil9.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil9.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
        Thread.sleep(4000);
        driverUtil9.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/input", "b57609");
        driverUtil9.findElementByXpathAndClick("//*[@id=\"submit\"]/span");

        driverUtil9.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[5]/div[2]/table/tbody/tr/td[25]/div/div/a");
        driverUtil9.findElementByXpathAndClick("/html/body/div[4]/div/div[2]/div/div[1]/form/div[3]/div[1]/div/div/div/div/input");
        Thread.sleep(2000);
        driverUtil9.findElementByXpathAndClick("/html/body/div[5]/div[1]/div[1]/ul/li[2]/span");//禁用b57609玩家
        driverUtil9.findElementByXpathAndClick("/html/body/div[4]/div/div[3]/div/button[2]/span");
        Thread.sleep(3000);

        driverUtil9.scrollToRight();
        String Disable = driverUtil9.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[23]/div/span");

            Assertion.setFlag(true);
            Assertion.verifyEquals(Disable,"禁用");
            Assert.assertTrue(Assertion.currentFlag());

        driverUtil9.LoginAfter();

    }


    @Test(enabled = false)
    public void MoreGoldMovement() throws InterruptedException {

        WebDriverUtil driverUtil10 = new WebDriverUtil(driver);
        driverUtil10.LoginBefore();
        driverUtil10.adminlogin("xiaochaoadmin","123123");
        driverUtil10.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            Thread.sleep(4000);

        //进入玩家管理搜索玩家
        driverUtil10.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
        driverUtil10.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
            Thread.sleep(4000);
        driverUtil10.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/input", "b57609");
        driverUtil10.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
            Thread.sleep(3000);
        //更多-金币变动详情
        driverUtil10.findSelectByXpathAndSelectByValue("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[5]/div[2]/table/tbody/tr/td[25]/div/div/div[2]/a","金币变动详情");
            Thread.sleep(3000);
        String GoldMovement = driverUtil10.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[1]/h4");
            Assertion.setFlag(true);
            Assertion.verifyEquals(GoldMovement,"玩家游戏记录");
            Assert.assertTrue(Assertion.currentFlag());
        driverUtil10.LoginAfter();
    }

        /**
         *  遗留问题：1.玩家管理-更多-下拉框定位；2.滚动条拖动右边；3.编辑玩家确认按钮无法操作或无法禁用
         * */
}