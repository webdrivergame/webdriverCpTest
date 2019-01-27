package logintest.base;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import PageMelement.LoginPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginCase {
    public WebDriver driver;
    private static Logger logger = Logger.getLogger(LoginCase.class);

    @Test
    public void testLogin() throws Exception {

        driver.get("此处填写登陆页面的URL：http://XXXXXX");
        LoginPage loginPage = new LoginPage(driver);
        logger.info("登陆用例开始");
        logger.info("不输入用户名和密码，点击登陆");
        loginPage.submit().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("请输入账户名"));
        logger.info("输入用户名，不输入密码，点击登陆");
        loginPage.userName().sendKeys("18678945247");
        loginPage.submit().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("请输入密码"));
        logger.info("输入错误的密码，点击登陆");
        loginPage.userPassword().sendKeys("1234567");
        loginPage.submit().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("用户名或密码错误"));
        logger.info("输入正确的密码，点击登陆");
        loginPage.userPassword().clear();
        loginPage.userPassword().sendKeys("12345678");
        loginPage.submit().click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getPageSource().contains("查看所有创业公司"));
        logger.info("登陆用例结束");
    }

    @BeforeTest
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files (x86)\\\\Google\\\\Chrome\\\\Application\\\\chromedriver.exe");
        // 去掉浏览器中的“--ignore-certificate-errors”
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("chrome.switches",
                Arrays.asList("--incognito"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        capabilities.setCapability("chrom.binary",
                "src/ucBrowserDrivers/chromedriver.exe");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();

    }

    @AfterTest
    public void afterMethod() {
        driver.quit();
    }

}
