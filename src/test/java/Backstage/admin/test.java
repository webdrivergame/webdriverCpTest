package Backstage.admin;

import SeleniumMethod.WebDriverUtil;
import com.gargoylesoftware.htmlunit.activex.javascript.msxml.XMLHTTPRequest;
import javafx.stage.Screen;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class test {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.119:8703/?#/login?redirect=%2F";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.findElementByXpathAndClick(login);
        Thread.sleep(2000);

    }

    String userAccount = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/div/span";
    String user = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[11]/li/ul/div[3]/a/li/span";
    String click = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/button/span";
    String sure = "//*[@id=\"app\"]/div/div[2]/section/div/div[3]/div/div[3]/div/button[2]/span";


    @Test
    public void getTest() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(userAccount);
        driverUtil.findElementByXpathAndClick(user);
        Thread.sleep(2000);
        driverUtil.findElementByXpathAndClick(click);
        driverUtil.findElementByXpathAndClick(sure);


    }

}
