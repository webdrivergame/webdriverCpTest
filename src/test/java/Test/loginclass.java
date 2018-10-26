package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginclass {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void start(){
        String username;
        String password;

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

