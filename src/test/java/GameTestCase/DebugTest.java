package GameTestCase;

import PublicMethod.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DebugTest {

    public WebDriver driver;

    @Test
    public void testLogin() throws InterruptedException {

        // 登录
        // 方法类名实例化一个对象，本类中调用
        WebDriverUtil webDriverUtil = new WebDriverUtil(driver);
        webDriverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"login_username\"]","xiaochaoadmin");
        webDriverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"login_password\"]",123123);
        webDriverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        // 通过查找元素判断是否登录成功
        String PageSource = driver.findElement(By.xpath("//*[@id=\"root\"]/section/header/div/div[2]/div/div[1]/div[2]/div/p")).getText();
        Assert.assertEquals(PageSource,"管理员小超");
        Thread.sleep(3000);
        driver.close();
    }


}
