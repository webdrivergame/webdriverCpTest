package Backstage.admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.102:8703/?#/login?redirect=%2F";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao","123123");
        driverUtil.findElementByXpathAndClick(login);
        Thread.sleep(3000);

    }



    String clickUserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String clickVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String timeText = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div";
    String loginTime = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[15]/div";

    @Features("管理员")
    @Stories("用户管理")
    @Title("验证会员未登录时间是否无误")
    @Test(priority = 1)
    public void loginTime() {
        driverUtil.findElementByXpathAndClick(clickUserManagement);
        driverUtil.findElementByXpathAndClick(clickVip);
        String getTimeText = driverUtil.getTextByXpath(timeText);
        String getLoginTime = driverUtil.getTextByXpath(loginTime);//获取未登录时间文本
        String timeTruncated = getTimeText.substring(0, 10);
        BigDecimal timeNull = StringToNumber.DateBigDecimal(timeTruncated);//去掉日期格式的-符号
        System.out.println("获取页面时间：" + timeNull);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
        Date date = new Date();//Date转换String
        String systemDate = df.format(date);// 获取当前系统时间
        BigDecimal systemDate2 = new BigDecimal(systemDate);
        System.out.println("系统时间：" + systemDate2);
        BigDecimal result = systemDate2.subtract(timeNull);//系统时间减去文本时间
        BigDecimal loginTime2 = new BigDecimal(getLoginTime);//未登录时间文本转换格式
        System.out.println("未登录时间："+loginTime2);
        System.out.println("未登录时间与最后登录时间差数："+result);
        if (result.equals(0) || result.equals(1)) {
            Assertion.setFlag(true);
            Assertion.verifyEquals(loginTime2, 0);
            Assert.assertTrue(Assertion.currentFlag());
        } else {
            Assertion.setFlag(true);
            Assertion.verifyEquals(result, loginTime2);
            Assert.assertTrue(Assertion.currentFlag());
        }
    }

    @AfterTest
    public void loginAfter(){
        driverUtil.loginAfter();

    }



}
