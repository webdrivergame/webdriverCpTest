package serverErrorTestCase;

import PublicMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static ListenerPackage.Assertion.setFlag;

public class adminHomeCase {

        private WebDriver driver;

        @Test
        public void adminHomeCase(){

            WebDriverUtil driverUtil = new WebDriverUtil(driver);
            driverUtil.LoginBefore("http://xjtg66.com:9091/#/login");
            driverUtil.adminlogin("ddddd","123456");
            driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
            try {
                driverUtil.findElementByXpathAndClick("/html/body/div[13]/p\n");
            }catch (Exception e){
                e.printStackTrace(); //仅仅代表异常消息的输出
                setFlag(false); //抛出异常时记录flag=false
            }finally {
                System.out.println("服务器异常");
            }


        }
}
