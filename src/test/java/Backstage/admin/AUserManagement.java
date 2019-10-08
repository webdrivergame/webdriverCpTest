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

public class AUserManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String URL = "http://10.1.101.102:8703/?#/login?redirect=%2F";
    String login = "//*[@id=\"app\"]/div/div/form/div[4]/div/div/button/span";

    @BeforeTest
    public void loginBefore() throws InterruptedException {
        driverUtil.loginBefore(URL);
        driverUtil.adminLogin("achao", "123123");
        driverUtil.findElementByXpathAndClick(login);
        Thread.sleep(2000);

    }


    String clickUserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String clickVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String timeText = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div";
    String loginTime = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[15]/div";

    @Features("后台管理")
    @Stories("用户管理")
    @Title("验证会员未登录时间是否无误")
    @Test(priority = 1)
    public void loginTime() throws InterruptedException {
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
        BigDecimal loginDay = new BigDecimal(getLoginTime);//未登录时间文本转换格式
        int result2 = result.intValue();
        int loginDay2 = loginDay.intValue();
        System.out.println("未登录天数：" + loginDay);
        System.out.println("未登录时间与最后登录时间差数：" + result);
        if (result2==0) {
            System.out.println("执行1");
            Assertion.setFlag(true);
            Assertion.verifyEquals(loginDay2, 0);
            Assert.assertTrue(Assertion.currentFlag());
        } else if (result2==1){
            System.out.println("执行2");
            Assertion.setFlag(true);
            Assertion.verifyEquals(loginDay2, 0);
            Assert.assertTrue(Assertion.currentFlag());
        }else {
            System.out.println("执行3");
            Assertion.setFlag(true);
            Assertion.verifyEquals(result, loginDay);
            Assert.assertTrue(Assertion.currentFlag());
        }
        Thread.sleep(2000);
    }



    String BalanceDesc = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[2]/table/thead/tr/th[7]/div/span/i[2]";
    String first = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/span";
    String second = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div/span";
    String third = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[7]/div/span";

    @Features("后台管理")
    @Stories("用户管理")
    @Title("验证会员可用额度降序排列")
    @Test(priority = 2)
    public void desc() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(BalanceDesc);
        Thread.sleep(2000);
        String getFirst = driverUtil.getTextByXpath(first);
        String getSecond = driverUtil.getTextByXpath(second);
        String getThird = driverUtil.getTextByXpath(third);
        BigDecimal toFirst = new BigDecimal(getFirst);
        BigDecimal toSecond = new BigDecimal(getSecond);
        BigDecimal toThird = new BigDecimal(getThird);
        System.out.println("第一个值："+getFirst);
        System.out.println("第二个值："+getSecond);
        System.out.println("第三个值："+getThird);
        if (getFirst.equals(getSecond)) {
            System.out.println("执行1");
            int compareResult2 = toSecond.compareTo(toThird);
            Assertion.setFlag(true);
            Assertion.verifyEquals(compareResult2, 1);
            Assert.assertTrue(Assertion.currentFlag());
        } else {
            int a1 = toFirst.compareTo(toSecond);
            System.out.println("执行2");
            Assertion.setFlag(true);
            Assertion.verifyEquals(a1, 1);
            Assert.assertTrue(Assertion.currentFlag());
        }
    }

    String BalanceAsc = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[2]/table/thead/tr/th[7]/div/span/i[1]";

    @Features("后台管理")
    @Stories("用户管理")
    @Title("验证会员可用额度升序排列")
    @Test(priority = 3)
    public void Asc() throws InterruptedException {
        driverUtil.findElementByXpathAndClick(BalanceAsc);
        String getFirst2 = driverUtil.getTextByXpath(first);
        String getSecond2 = driverUtil.getTextByXpath(second);
        BigDecimal toFirst2 = new BigDecimal(getFirst2);
        BigDecimal toSecond = new BigDecimal(getSecond2);
        System.out.println("第一个值：" + toFirst2);
        System.out.println("第二个值：" + toSecond);
        int compareResult2 = toFirst2.compareTo(toSecond);
        if (!getFirst2.equals(getSecond2)) {
            Assertion.setFlag(true);
            Assertion.verifyEquals(compareResult2, -1);
            Assert.assertTrue(Assertion.currentFlag());
        } else {
            System.out.println("两值相等");
        }


}



    String inputUser = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String balanceUse = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[7]/div/span";
    String addBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[16]/div/button[2]/span";
    String inputUserAddBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[10]/div/div[2]/form/div[1]/div/div/textarea";
    String clickSure = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[10]/div/div[3]/div/button[2]/span";

    @Features("后台管理")
    @Stories("用户管理")
    @Title("验证会员余额增加数据是否正常")
    @Test(priority = 4)
    public void addBalance() throws InterruptedException {
        driverUtil.findElementByXpathAndClearSendkeys(inputUser,"achaohy2");
        driverUtil.findElementByXpathAndClick(inquire);
        Thread.sleep(2000);
        String getBalanceUse = driverUtil.getTextByXpath(balanceUse);
        driverUtil.findElementByXpathAndClick(addBalance);
        driverUtil.findElementByXpathAndClearSendkeys(inputUserAddBalance,"achaohy2=100");
        driverUtil.findElementByXpathAndClick(clickSure);
        String getBalanceUse2 = driverUtil.getTextByXpath(balanceUse);
        System.out.println("可用余额："+getBalanceUse);
        System.out.println("增加100后余额："+getBalanceUse2);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalanceUse,getBalanceUse2);
        Assert.assertTrue(Assertion.currentFlag());

    }



    @Features("后台管理")
    @Stories("用户管理")
    @Title("验证会员余额减少数据是否正常")
    @Test(priority = 4)
    public void subtractBalance() throws InterruptedException {

        String getBalanceUse = driverUtil.getTextByXpath(balanceUse);
        driverUtil.findElementByXpathAndClick(addBalance);
        driverUtil.findElementByXpathAndClearSendkeys(inputUserAddBalance,"achaohy2=-100");
        driverUtil.findElementByXpathAndClick(clickSure);
        String getBalanceUse2 = driverUtil.getTextByXpath(balanceUse);
        System.out.println("可用余额："+getBalanceUse);
        System.out.println("减少100后余额："+getBalanceUse2);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalanceUse,getBalanceUse2);
        Assert.assertTrue(Assertion.currentFlag());

    }




}