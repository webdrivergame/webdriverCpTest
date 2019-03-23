package creditAgentTestCase;

import PublicMethod.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class creditAgentHomeTestCase {

        private WebDriver driver;
        @Test
        public void accountBalance() throws InterruptedException {
                WebDriverUtil driverUtil = new WebDriverUtil(driver);
                driverUtil.loginBefore("https://binli.oneonewan.com/#/login");
                driverUtil.adminLogin("wxjbdl1","123456");
                driverUtil.findElementByXpathAndClick("//*[@id=\"login_submit\"]");
                        Thread.sleep(3000);



        }
}
