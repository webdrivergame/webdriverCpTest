package Admin;

import ListenerPackage.Assertion;
import SeleniumMethod.WebDriverUtil;
import UtilTest.StringToNumber;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.math.BigDecimal;

public class LowerServiceSettlementRecord {

        String Url = "https://Admin.oneonewan.com/#/login";
        String username = "xiaochaoadmin";
        String password = "123123";
        String login = "//*[@id=\"login_submit\"]";
        String inputText = "//*[@id=\"root\"]/section/div[1]/div[1]/div/input";
        String adminHome = "//*[@id=\"rest_admin_home\"]/li/span";

        WebDriverUtil driverUtil = new WebDriverUtil(null);


        /***
         *
         * 下级服务费结算记录
         * 结算
         * 输入金额100
         * 确定
         * 点击详情
         * @获取操作金额
         * @获取操作前金额
         * @获取操作后金额
         *
         * ***/

        String lowerServiceSettlementRecord = "//*[@id=\"rest_system_sub_agent_recharge_record\"]/li/span";
        String settlement = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/div/div/div/a[1]";
        String inputSettlementMoney = "/html/body/div[3]/div/div[2]/div[2]/div[1]/input";
        String sure = "/html/body/div[3]/div/div[3]/button[2]/span";
        String detail = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[1]/div/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/div/div/div/a[2]";
        String operatingMoney  = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div";
        String operatingMoneyBefore = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div";
        String operatingMoneyAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div";

        //----------------------------------------------验证商户结算服务费后详情金额变化无误------------------------------------------------

        @Features("平台管理员")
        @Stories("下级服务费结算记录")
        @Title("验证下级服务费结算记录商户结算金额和金额详情变动无误")
        @Test(priority = 1)
        public void explorerSettlement() throws InterruptedException {
                driverUtil.findElementByXpathAndClearSendkeys(inputText,"下级服务费结算记录");
                driverUtil.findElementByXpathAndClick(lowerServiceSettlementRecord);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(settlement);
                driverUtil.findElementByXpathAndClearSendkeys(inputSettlementMoney,"100");
                driverUtil.findElementByXpathAndClick(sure);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(detail);
                Thread.sleep(2000);
                String getOperatingMoney = driverUtil.getTextByXpath(operatingMoney);
                String getOperatingMoneyBefore = driverUtil.getTextByXpath(operatingMoneyBefore);
                String getOperatingMoneyAfter = driverUtil.getTextByXpath(operatingMoneyAfter);
                BigDecimal resultMoney = StringToNumber.toBigDecimal(getOperatingMoney);
                BigDecimal resultMoneyBefore = StringToNumber.toBigDecimal(getOperatingMoneyBefore);
                BigDecimal resultMoneyAfter = StringToNumber.toBigDecimal(getOperatingMoneyAfter);
                BigDecimal result = resultMoney.add(resultMoneyBefore);
                System.out.println("操作金额："+resultMoney);
                System.out.println("操作前金额："+resultMoneyBefore);
                System.out.println("操作后金额："+resultMoneyAfter);
                System.out.println("相加后金额："+result);
                Assertion.setFlag(true);
                Assertion.verifyEquals(result,resultMoneyAfter);
                Assert.assertTrue(Assertion.currentFlag());

        }

         /***
         *
         * 返回
         * 点击商务
         * 输入账号查询
         * 点击详情
         * @获取操作金额
         * @获取操作前金额
         * @获取操作后金额
         *
         * ***/


        String comeback = "//*[@id=\"root\"]/section/section/main/div[2]/div[1]/div/div/button[4]/span";
        String clickBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[1]/div/ul/div[2]/li/span";
        String inputBusiness = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/form/div[1]/div/div[1]/div[1]/div/div/input";
        String input = "//*[@id=\"submit\"]/span";
        String businessDetail = "//*[@id=\"root\"]/section/section/main/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[2]/div[3]/table/tbody/tr/td[8]/div/div/div/div/a";
        String businessOperatingMoney = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[3]/div";
        String businessOperatingMoneyBefore = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[4]/div";
        String businessOperatingMoneyAfter = "//*[@id=\"root\"]/section/section/main/div[2]/div[3]/div[2]/div/div[3]/table/tbody/tr[1]/td[5]/div";

        //----------------------------------------------验证商务详情服务费和缴款金额变动无误-----------------------------------------

        @Features("平台管理员")
        @Stories("下级服务费结算记录")
        @Title("验证下级服务费商务结算金额变动无误")
        @Test(priority = 2)
        public void businessSettlement() throws InterruptedException {
                driverUtil.findElementByXpathAndClick(comeback);
                driverUtil.findElementByXpathAndClick(clickBusiness);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClearSendkeys(inputBusiness,"wxjb66");
                driverUtil.findElementByXpathAndClick(input);
                Thread.sleep(2000);
                driverUtil.findElementByXpathAndClick(businessDetail);
                Thread.sleep(2000);
                String getBusinessOperatingMoney = driverUtil.getTextByXpath(businessOperatingMoney);
                String getBusinessOperatingMoneyBefore = driverUtil.getTextByXpath(businessOperatingMoneyBefore);
                String getBusinessOperatingMoneyAfter = driverUtil.getTextByXpath(businessOperatingMoneyAfter);
                BigDecimal businessResultMoney = StringToNumber.toBigDecimal(getBusinessOperatingMoney);
                BigDecimal businessResultMoneyBefore = StringToNumber.toBigDecimal(getBusinessOperatingMoneyBefore);
                BigDecimal businessResultMoneyAfter = StringToNumber.toBigDecimal(getBusinessOperatingMoneyAfter);
                BigDecimal result2 = businessResultMoney.add(businessResultMoneyBefore);
                Assertion.setFlag(true);
                Assertion.verifyEquals(result2,businessResultMoneyAfter);
                Assert.assertTrue(Assertion.currentFlag());
        }





}
