package cashAgentTestCase;

import PublicMethod.WebDriverUtil;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listenerPackage.Assertion;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import util.StringToNumber;

import java.math.BigDecimal;

public class playerAccountAdminTestCase {

        public WebDriver driver;

        @Feature("现金代理")
        @Story("玩家账号管理")
        @Title("现金代理-玩家账号管理-验证玩家总充值排序功能")
        @Test(priority = 1)
        public  void rechargeTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[4]/div/div/input[1]");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[3]/div/span/i[2]");//总充值降序
                        Thread.sleep(2000);//总充值降序排列
                String rechargeTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/a");
                BigDecimal RemoveComma = StringToNumber.toBigDecimal(rechargeTotal);
                System.out.println("总充值最大金额："+RemoveComma);
                String rechargeTotal2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[3]/div/a");
                BigDecimal RemoveComma2 = StringToNumber.toBigDecimal(rechargeTotal2);
                System.out.println("总充值次大金额："+RemoveComma2);
                int a1 = RemoveComma.compareTo(RemoveComma2);//0是等于，-1是小于，1是大于
                System.out.println("比较结果应为1："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,a1);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("现金代理")
        @Story("玩家账号管理")
        @Title("现今代理-玩家账号管理-验证玩家总提现排序功能")
        @Test(priority = 2)
        public void withdrawTotal() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[4]/div/div/input[1]");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[4]/div/span/i[2]");
                        Thread.sleep(2000);//总提现降序排列
                String withdrawTotal = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/a");
                BigDecimal a1 = StringToNumber.toBigDecimal(withdrawTotal);
                System.out.println("总提现最大值："+a1);
                String withdrawTotal2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[4]/div/a");
                BigDecimal a2 = StringToNumber.toBigDecimal(withdrawTotal2);
                System.out.println("总提现次大值："+a2);
                int compare = a1.compareTo(a2);
                System.out.println("1为大于，-1为小于，0为等于："+compare);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,compare);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("现金代理")
        @Story("玩家账号管理")
        @Title("现今代理-玩家账号管理-验证额外补分排序功能")
        @Test(priority = 3)
        public void additionalUpPoints() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[4]/div/div/input[1]");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");
                        Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[9]/div/span/i[2]");
                        Thread.sleep(2000);//额外补分降序排列
                String additionalUpPoints = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div");
                BigDecimal a1 = StringToNumber.toBigDecimal(additionalUpPoints);
                System.out.println("额外补分最大金额："+a1);
                String additionalUpPoints2 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[9]/div");
                BigDecimal a2 = StringToNumber.toBigDecimal(additionalUpPoints2);
                System.out.println("额外补分次大金额："+a2);
                int compare = a1.compareTo(a2);
                System.out.println("1为大于，-1为小于，0为等于："+compare);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,compare);
                Assert.assertTrue(Assertion.currentFlag());
                driverUtil.LoginAfter();
        }


        @Feature("现金代理")
        @Story("玩家游戏记录")
        @Title("现金代理-玩家游戏记录-验证玩家游戏记录数据计算")
        @Test(priority = 4)
        public void playerGameRecord() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://koudai.oneonewan.com/?#/login");
                driverUtil.adminLogin("44444", "123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                Thread.sleep(4000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_online_player\"]/span");
                driverUtil.findElementByXpathAndClick("//*[@id=\"rest_system_operation_list\"]/li/span");
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");//重置时间
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClearSendkeys("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input","b10869");
                driverUtil.findElementByXpathAndClick("//*[@id=\"submit\"]/span");//查询玩家
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick("//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr/td[14]/div/div/div/div/a[1]");
                Thread.sleep(2000);
                //获取变动金额
                String a1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/ul/li[6]/div/span");
                String a2 = a1.substring(0,1);
                System.out.println("变动金额："+a1);
                System.out.println("截取第一个字符："+a2);
                //获取变动前金额转换
                String b1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/ul/li[7]");
                String b2 = b1.replaceAll(",","");
                BigDecimal changeMoneyBefore = new BigDecimal(b2);
                System.out.println("变动前金额："+changeMoneyBefore);
                //获取变动后金额转换
                String c1 = driverUtil.getTextByXpath("//*[@id=\"root\"]/section/section/main/div[2]/div/div[3]/div[1]/div/div[1]/ul/li[8]");
                String changeMoneyAfter = c1.replaceAll(",","");
                BigDecimal c2 = new BigDecimal(changeMoneyAfter);
                System.out.println("变动后金额："+changeMoneyAfter);
                if (a2.equals("-")) {
                        BigDecimal chargeMoney = StringToNumber.toBigDecimal(a1).abs();
                        BigDecimal result = changeMoneyBefore.subtract(chargeMoney);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result,c2);
                        Assert.assertTrue(Assertion.currentFlag());
                } else if (! a2.equals("-")) {
                        BigDecimal chargeMoney2 = StringToNumber.toBigDecimal(a1);
                        BigDecimal result2 =changeMoneyBefore.add(chargeMoney2);
                        Assertion.setFlag(true);
                        Assertion.verifyEquals(result2,c2);
                        Assert.assertTrue(Assertion.currentFlag());
                }
                driverUtil.LoginAfter();



        }

}
