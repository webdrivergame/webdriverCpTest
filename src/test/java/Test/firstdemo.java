package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class firstdemo {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void test(){
        WebElement login = driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[2]/div/div[1]/input"));
        login.clear();
        login.sendKeys("xiaochaoadmin");
        WebElement password=driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[3]/div/div/input"));
        password.clear();
        password.sendKeys("123123");
        driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[5]/div/div[1]")).click();

    }
    @BeforeClass
    public void before(){
        String Url = "http://192.168.1.8:9091/#/login";
        driver.get(Url);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void after(){
        driver.quit();
    }
}
