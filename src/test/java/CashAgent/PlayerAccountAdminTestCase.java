package CashAgent;

import SeleniumMethod.WebDriverUtil;
import ListenerPackage.Assertion;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import UtilTest.StringToNumber;

import java.math.BigDecimal;

public class PlayerAccountAdminTestCase {

        WebDriverUtil driverUtil = new WebDriverUtil(null);

        String Url = "https://koudai.oneonewan.com/?#/login";
        String username = "44444";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";


        /***
         *
         * 点击总充值倒序排列
         * @获取第一个值
         * @获取第二个值
         *
         * ***/

        String clickPlayerAccountAdmin = "//*[@id=\"rest_system_operation_list\"]/li/span";
        String Inquire = "//*[@id=\"submit\"]/span";
        String clickRechargeTotalDesc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[3]/div/span/i[2]";
        String rechargeTotal = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div/a";
        String rechargeTotal2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[3]/div/a";

        @Features("现金代理")
        @Stories("玩家账号管理")
        @Title("验证玩家总充值排序功能")
        @Test(priority = 1)
        public  void rechargeTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"玩家账号管理");
                driverUtil.findElementByXpathAndClick(clickPlayerAccountAdmin);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(Inquire);
                Thread.sleep(3000);
                driverUtil.findElementByXpathAndClick(clickRechargeTotalDesc);//总充值降序
                Thread.sleep(2000);
                String getRechargeTotal = driverUtil.getTextByXpath(rechargeTotal);
                BigDecimal RemoveComma = StringToNumber.toBigDecimal(getRechargeTotal);
                System.out.println("总充值最大金额："+RemoveComma);
                String getRechargeTotal2 = driverUtil.getTextByXpath(rechargeTotal2);
                BigDecimal RemoveComma2 = StringToNumber.toBigDecimal(getRechargeTotal2);
                System.out.println("总充值次大金额："+RemoveComma2);
                int a1 = RemoveComma.compareTo(RemoveComma2);//0是等于，-1是小于，1是大于
                System.out.println("比较结果应为1："+a1);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,a1);
                Assert.assertTrue(Assertion.currentFlag());

        }

        /***
         *
         * 点击总提现倒序排列
         * @获取第一个值
         * @获取第二个值
         *
         * ***/
        String withdrawTotalDesc = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[4]/div/span/i[2]";
        String withdrawTotal1 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div/a";
        String withdrawTotal2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[4]/div/a";

        @Features("现金代理")
        @Stories("玩家账号管理")
        @Title("验证玩家总提现排序功能")
        @Test(priority = 2)
        public void withdrawTotal() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(withdrawTotalDesc);
                Thread.sleep(2000);//总提现降序排列
                String getWithdrawTotal1 = driverUtil.getTextByXpath(withdrawTotal1);
                BigDecimal a1 = StringToNumber.toBigDecimal(getWithdrawTotal1);
                System.out.println("总提现最大值："+a1);
                String getWithdrawTotal2 = driverUtil.getTextByXpath(withdrawTotal2);
                BigDecimal a2 = StringToNumber.toBigDecimal(getWithdrawTotal2);
                System.out.println("总提现次大值："+a2);
                int compare = a1.compareTo(a2);
                System.out.println("1为大于，-1为小于，0为等于："+compare);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,compare);
                Assert.assertTrue(Assertion.currentFlag());

        }

        /***
         *
         * 点击额外补分倒序排列
         * @获取第一个值
         * @获取第二个值
         *
         * ***/

        String clickAdditionalPoint = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[2]/table/thead/tr/th[9]/div/span/i[2]";
        String additionalUpPoints = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[1]/td[9]/div";
        String additionalUpPoints2 = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div/div[3]/table/tbody/tr[2]/td[9]/div";

        @Features("现金代理")
        @Stories("玩家账号管理")
        @Title("验证额外补分排序功能")
        @Test(priority = 3)
        public void additionalUpPoints() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(clickAdditionalPoint);
                Thread.sleep(2000);//额外补分降序排列
                String getAdditionalUpPoints = driverUtil.getTextByXpath(additionalUpPoints);
                BigDecimal a1 = StringToNumber.toBigDecimal(getAdditionalUpPoints);
                System.out.println("额外补分最大金额："+a1);
                String getAdditionalUpPoints2 = driverUtil.getTextByXpath(additionalUpPoints2);
                BigDecimal a2 = StringToNumber.toBigDecimal(getAdditionalUpPoints2);
                System.out.println("额外补分次大金额："+a2);
                int compare = a1.compareTo(a2);
                System.out.println("1为大于，-1为小于，0为等于："+compare);
                Assertion.setFlag(true);
                Assertion.verifyEquals(1,compare);
                Assert.assertTrue(Assertion.currentFlag());
        }

        @AfterTest
        public void close(){
                driverUtil.loginAfter();
        }

}
