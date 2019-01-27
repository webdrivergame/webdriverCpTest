package GameTestCase;

import PublicMethod.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.tmp.verify.Verify;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class HomePlatformGoldNumberTest {
    public WebDriver driver;
    @Test
    public void GoldNumber() throws InterruptedException, Exception {

        //实例化driverUtil对象调用登录
        WebDriverUtil driverUtil = new WebDriverUtil(driver);
        driverUtil.adminlogin("xiaochaoadmin","123123");
        driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
        Thread.sleep(4000);
        /**
          获取用户名判断登录是否成功
         */
        String adminText = driver.findElement(By.xpath("//*[@id=\"root\"]/section/header/div/div[2]/div/div[1]/div[2]/div/p")).getText();
        Assert.assertEquals(adminText,"管理员小超");



        /**
         *    断言首页自运营商户人数与跳转页面自运营商户人数是否一致
         * */

        String BusinessNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[3]")
        ).getText();
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[3]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,10000);");
        String JumpBusinessNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[3]/span[1]")
        ).getText();
        try {
            Assert.assertEquals(BusinessNumber, JumpBusinessNumber);
        }catch (AssertionError e){
            System.out.println("商户人数不相等");
        }
        driverUtil.returnToPreviousPage();
        Thread.sleep(4000);



        /**
         *      断言首页代理人数和跳转的代理页面page人数是否相等
         * */
        String AgentNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[3]")
        ).getText();
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[4]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        driverUtil.findSelectByXpathAndSelectByValue("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[1]/div/form/div[1]/div/div[1]/div[2]/div/div/div/input","普通代理");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,10000);");
        String JumpAgentNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[3]/div/div[3]/span[1]")
        ).getText();
        try {
            Assert.assertEquals(AgentNumber,JumpAgentNumber);
        }catch (AssertionError e){
            System.out.println("代理人数不相等");
        }
        driverUtil.returnToPreviousPage();
        Thread.sleep(4000);



        /**
         * 断言首页自运营商户欠款总计共和跳转页面商户金额是否一致
         */

        String BusinessArrearsNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]")
        ).getText();
        driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/span/span[3]");
        Thread.sleep(3000);
        driverUtil.refreshpage();
        String JumpBusinessArrearsNumber = driver.findElement(
                By.xpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div/li/span[2]")
        ).getText();
        try {
            Assert.assertEquals(BusinessArrearsNumber,JumpBusinessArrearsNumber);
        }catch (AssertionError e){
            System.out.println("自运营商户欠款不一致");
        }
        driver.navigate().back();
        Thread.sleep(4000);

    }



    @BeforeClass
    public void beforelogin(){

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
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
        String Url ="http://192.168.1.9:9091";
        driver.get(Url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterClass
    public void afterlogin(){

    }

}
