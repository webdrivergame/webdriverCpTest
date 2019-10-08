package Backstage.admin;

import SeleniumMethod.WebDriverUtil;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

public class RegisterManagement {

    WebDriverUtil driverUtil = new WebDriverUtil(null);

    String ReportManagement = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/div/span";
    String registerReport = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/div/ul/div[4]/li/ul/div[5]/a/li/span";
    String registerNumber = "//*[@id=\"app\"]/div/div[2]/section/div/div[2]/div[1]/div[3]/table/tbody/tr[1]/td[2]/div";


    @Features("后台管理")
    @Stories("报表管理")
    @Title("验证注册报表-昨日注册数量是否有误")
    @Test(priority = 1)
    public void registerYesterday(){
        driverUtil.findElementByXpathAndClick(ReportManagement);
        driverUtil.findElementByXpathAndClick(registerReport);
        String getRegisterNumber = driverUtil.getTextByXpath(registerNumber);
        System.out.println("注册数量："+getRegisterNumber);


    }

}
