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



        /**
         *    ----------------------------------------用户管理>总代理>代理数-----------------------------------------------------
         *
         * */

    String UserManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/div/span";
    String agentTotal = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[1]/a/li/span";
    String agentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String clickAgentNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[3]/div/span";
    String agentNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";



    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证代理数数量")
    @Test(priority = 1)
        public void agentNumber() throws InterruptedException {
            driverUtil.xpathClick(UserManagement);
            driverUtil.xpathClick(agentTotal);
            Thread.sleep(1000);
            String getAgentNumber = driverUtil.getTextByXpath(agentNumber);
            System.out.println("总代理列表代理数："+getAgentNumber);
            driverUtil.xpathClick(clickAgentNumber);
            Thread.sleep(2000);
            String getAgentNumberPage = driverUtil.getTextByXpath(agentNumberPage);
            String getAgentNumberPage1 = getAgentNumberPage.substring(1,getAgentNumberPage.indexOf("条"));
            System.out.println("跳转页面代理数："+getAgentNumberPage1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentNumber, getAgentNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /**
         * --------------------------------------------用户管理>总代理>会员数---------------------------------------------------
         *
         **/

    String vipNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span";
    String vipNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("总代理列表")
    @Title("验证会员数数量")
    @Test(priority = 2)
        public void vipNumber() throws InterruptedException {
            driverUtil.xpathClick(agentTotal);
            Thread.sleep(1000);
            String getVipNumber = driverUtil.getTextByXpath(vipNumber);
            System.out.println("总代理列表会员数："+getVipNumber);
            driverUtil.xpathClick(vipNumber);
            Thread.sleep(2000);
            String getVipNumberPage = driverUtil.getTextByXpath(vipNumberPage);
            String getVipNumberPage1 = getVipNumberPage.substring(1,getVipNumberPage.indexOf("条"));
            System.out.println("跳转页面会员数量："+getVipNumberPage1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipNumber, getVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /**
         * ---------------------------------------------------用户管理>代理>会员数---------------------------------------------
         *
         * */

    String agentList = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[2]/a/li/span";
    String agentListVipNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[4]/div/span";
    String agentListVipNumberPage = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[2]/div[1]";

    @Features("用户管理")
    @Stories("代理列表")
    @Title("验证会员数数量")
    @Test(priority = 3)
        public void agentVipNumber() throws InterruptedException {
            driverUtil.xpathClick(agentList);
            Thread.sleep(1000);
            String getAgentListVipNumber = driverUtil.getTextByXpath(agentListVipNumber);
            System.out.println("代理列表会员数："+getAgentListVipNumber);
            driverUtil.xpathClick(agentListVipNumber);
            Thread.sleep(2000);
            String getAgentListVipNumberPage = driverUtil.getTextByXpath(agentListVipNumberPage);
            String agentListVipNumberPage1 = getAgentListVipNumberPage.substring(1,getAgentListVipNumberPage.indexOf("条"));
            System.out.println("点击跳转代理列表会员数："+agentListVipNumberPage1);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentListVipNumber, agentListVipNumberPage1);
            Assert.assertTrue(Assertion.currentFlag());

        }



        /**
         * -------------------------------------------用户管理>代理>可用额度--------------------------------------------------
         *
         * */


    String usableMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String minuteMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[12]/div/button/span";
    String balance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[7]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String close = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[7]/div/div[1]/button";

    @Features("用户管理")
    @Stories("代理列表")
    @Title("验证代理可用额度数据")
    @Test(enabled = false)
        public void usableMoney() throws InterruptedException {
            driverUtil.xpathClick(agentList);
            Thread.sleep(1000);
            String getUsableMoney = driverUtil.getTextByXpath(usableMoney);
            System.out.println("代理列表代理可用额度："+getUsableMoney);
            driverUtil.xpathClick(minuteMoney);
            Thread.sleep(2000);
            String getBalance = driverUtil.getTextByXpath(balance);
            System.out.println("资金明细最后余额："+getBalance);
            driverUtil.xpathClick(close);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getUsableMoney, getBalance);
            Assert.assertTrue(Assertion.currentFlag());
            driverUtil.switchToCurrentPage();
    }

        /**
         * ------------------------------------------------用户管理>会员>未登录时间-----------------------------------------------
         *
         **/


    String clickVip = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[3]/a/li/span";
    String timeText = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div";
    String loginTime = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[15]/div";

    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证会员未登录时间")
    @Test(priority = 5)
        public void loginTime() throws InterruptedException {
            driverUtil.xpathClick(clickVip);
            Thread.sleep(2000);
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



        /**
         *
         * --------------------------------------------------用户管理>会员>可用额度降序----------------------------------------------
         *
         * */

    String BalanceDesc = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[2]/table/thead/tr/th[7]/div/span/i[2]";
    String first = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[7]/div/span";
    String second = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[2]/td[7]/div/span";
    String third = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr[3]/td[7]/div/span";

    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证会员可用额度降序排列")
    @Test(priority = 6)
        public void desc() throws InterruptedException {
            driverUtil.xpathClick(BalanceDesc);
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






        /**
         *
         * --------------------------------------------------用户管理>会员>批量添加会员余额----------------------------------------------
         *
         * */


    String inputUser = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String inquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String balanceUse = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[7]/div/span";
    String addBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[16]/div/button[2]/span";
    String inputUserAddBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[10]/div/div[2]/form/div[1]/div/div/textarea";
    String clickSure = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[10]/div/div[3]/div/button[2]/span";

    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证批量添加会员余额，增加数据是否正常")
    @Test(priority = 7)
    public void addBalance() throws InterruptedException {
        driverUtil.xpathClearSendKeys(inputUser,"achaohy22222");
        driverUtil.xpathClick(inquire);
        Thread.sleep(2000);
        String getBalanceUse = driverUtil.getTextByXpath(balanceUse);
        driverUtil.xpathClick(addBalance);
        driverUtil.xpathClearSendKeys(inputUserAddBalance,"achaohy22222=100");
        driverUtil.xpathClick(clickSure);
        Thread.sleep(1000);
        String getBalanceUse2 = driverUtil.getTextByXpath(balanceUse);
        System.out.println("可用余额："+getBalanceUse);
        System.out.println("增加100后余额："+getBalanceUse2);
        Assertion.setFlag(true);
        Assertion.verifyEquals(getBalanceUse,getBalanceUse2);
        Assert.assertTrue(Assertion.currentFlag());

    }

        /**
         *
         * --------------------------------------------------用户管理>会员>批量添加会员余额----------------------------------------------
         **/

    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证批量扣减会员余额，扣减数据是否正常")
    @Test(priority = 8)
        public void subtractBalance() throws InterruptedException {
            driverUtil.xpathClearSendKeys(inputUser,"achaohy22222");
            driverUtil.xpathClick(inquire);
            Thread.sleep(2000);
            String getBalanceUse = driverUtil.getTextByXpath(balanceUse);
            driverUtil.xpathClick(addBalance);
            driverUtil.xpathClearSendKeys(inputUserAddBalance,"achaohy22222=-100");
            driverUtil.xpathClick(clickSure);
            Thread.sleep(2000);
            String getBalanceUse2 = driverUtil.getTextByXpath(balanceUse);
            System.out.println("可用余额："+getBalanceUse);
            System.out.println("减少100后余额："+getBalanceUse2);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getBalanceUse,getBalanceUse2);
            Assert.assertTrue(Assertion.currentFlag());

        }


        /**
         *
         * --------------------------------------------------用户管理>会员>可用额度----------------------------------------------
         **/

    //String inputVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[10]/div/div/input";
    String vipInquire = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[1]/form/div[15]/div/button[1]/span";
    String vipUsableMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[7]/div/span";
    String vipMinuteMoney = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[2]/div[1]/div[3]/table/tbody/tr/td[17]/div/button[3]/span";
    String vipBalance = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[2]/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[5]/div";
    String closeVip = "//*[@id=\"app\"]/div/div[2]/section/div/div/div[6]/div/div[1]/button";

    @Features("用户管理")
    @Stories("会员列表")
    @Title("验证会员可用额度数据是否有误")
    @Test(priority = 9)
        public void vipUsableMoney() throws InterruptedException {
            driverUtil.xpathClearSendKeys(inputUser,"achaodl1hy1");
            driverUtil.xpathClick(vipInquire);
            Thread.sleep(2000);
            String getVipUsableMoney = driverUtil.getTextByXpath(vipUsableMoney);
            System.out.println("会员列表某会员可用额度："+getVipUsableMoney);
            driverUtil.xpathClick(vipMinuteMoney);
            String getVipBalance = driverUtil.getTextByXpath(vipBalance);
            System.out.println("会员资金明细余额："+getVipBalance);
            driverUtil.xpathClick(closeVip);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getVipUsableMoney,getVipBalance);
            Assert.assertTrue(Assertion.currentFlag());
        }


        /**
         *
         * --------------------------------------------------用户管理>在线玩家>踢出----------------------------------------------
         **/

    String clickOnlinePlayer = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[4]/a/li/span";
    String shot = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[11]/div/button/span";
    String sure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String success = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线玩家")
    @Title("验证踢出功能")
    @Test(priority = 10)
        public void onlinePlayer() throws InterruptedException {
            driverUtil.switchToParentFrame();
            driverUtil.xpathClick(clickOnlinePlayer);
            Thread.sleep(2000);
            driverUtil.xpathClick(shot);
            driverUtil.xpathClick(sure);
            String getSuccess = driverUtil.getTextByXpath(success);
            System.out.println(getSuccess);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());
        }


    /**
     * ----------------------------------------------用户管理>在线后台用户>踢出-------------------------------------------
     *
     * */

    String clickOnlineBackstage = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[2]/li/ul/div[5]/a/li/span";
    String agentShot = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[8]/div/button/span";
    String agentSure = "/html/body/div[2]/div/div[3]/button[2]/span";
    String agentSuccess = "/html/body/div[3]/p";

    @Features("用户管理")
    @Stories("在线后台用户")
    @Title("验证踢出功能")
    @Test(priority = 11)
        public void onlineBackstage() throws InterruptedException {
            driverUtil.xpathClick(clickOnlineBackstage);
            Thread.sleep(1000);
            driverUtil.xpathClick(agentShot);
            driverUtil.xpathClick(agentSure);
            String getAgentSuccess = driverUtil.getTextByXpath(agentSuccess);
            Assertion.setFlag(true);
            Assertion.verifyEquals(getAgentSuccess,"踢出成功!");
            Assert.assertTrue(Assertion.currentFlag());

        }




}