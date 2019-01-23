package PageMelement;


import ProFileUtil.ProFileUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 登陆页类。返回登陆页面元素对象
 *
 * @author alzhang
 *
 */
public class LoginPage {
    private WebElement element = null;

    // 指定页面元素定位表达式配置文件的绝对文件路径
    private ProFileUtil pfu = new ProFileUtil(
            "src/main/resources/LoginPage.properties");

    private WebDriver driver;

    public LoginPage() {

    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 获取页面源代码的封装方法
    public String getPageSource() {
        return driver.getPageSource();
    }

    // 返回登陆页面的用户名输入框元素对象
    public WebElement userName() throws Exception {
        element = driver.findElement(pfu.parseProFile("loginPage.userName"));
        return element;
    }

    // 返回登陆页面的用户密码输入框元素对象
    public WebElement userPassword() throws Exception {
        element = driver
                .findElement(pfu.parseProFile("loginPage.userPassword"));
        return element;
    }

    // 返回登陆页面的登陆按钮元素对象
    public WebElement submit() throws Exception {
        element = driver.findElement(pfu.parseProFile("loginPage.submit"));
        return element;
    }



}
