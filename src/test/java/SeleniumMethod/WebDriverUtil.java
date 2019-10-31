package SeleniumMethod;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.soap.Text;

/**
     *    基于selenium的二次封装
     */
           public class WebDriverUtil {

              //私有化成员变量private

               private static final Object BigDecimal = null;
               public static List<Error> errors = new ArrayList<Error>();
               public static WebDriver driver = null;
               private static Select select = null;
               private static Alert alert = null;
               private static WebElement element = null;
               private static List<WebElement> elementList = null;
               private static long timeOutInSeconds = 10;
               private Object senior;
               private boolean acceptNextAlert = true;


            public WebDriverUtil(WebDriver driver) {
                    WebDriverUtil.driver = driver;
                    WebDriverUtil.timeOutInSeconds = timeOutInSeconds;
                    //PageFactory.initElements(driver,this);
            }



               /**
                *    后台登录方法
                *    *        adminlogin
                */

               public void adminLogin(String username,String password){
                   WebElement user = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div[2]/div/div/input"));
                   user.clear();
                   user.click();
                   user.sendKeys(username);
                   WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/form/div[3]/div/div/input"));
                   pass.clear();
                   pass.click();
                   pass.sendKeys(password);
               }


                /**
                 *    玩家登录方法
                 *    *        playerLogin
                 */

                public void playerLogin(String username,String password){
                    WebElement user = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/input[1]"));
                    user.clear();
                    user.click();
                    user.sendKeys(username);
                    WebElement pass = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div/div[1]/div[2]/div[2]/div[1]/input[2]"));
                    pass.clear();
                    pass.click();
                    pass.sendKeys(password);
                }


               //浏览器打开Url

               public void loginBefore(String Url){
                   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
                   // 去掉浏览器中的“--ignore-certificate-errors”
                   DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                   capabilities.setCapability("chrome.switches",
                           Arrays.asList("--incognito"));
                   ChromeOptions options = new ChromeOptions();
                   options.addArguments("--test-type");
                   capabilities.setCapability("chrom.binary",
                           "src/ucBrowserDrivers/chromedriver.exe");
                   capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                   DesiredCapabilities sCaps = new DesiredCapabilities();
                   sCaps.setJavascriptEnabled(true);//允许执行js代码
                   driver = new ChromeDriver(capabilities);
                   driver.get(Url);
                   driver.manage().window().maximize();
                   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
               }





               //结束测试

               public void loginAfter(){
                   driver.close();
               }


               /**
       *    初始化浏览器
         *        Firefox
        */
             public static WebDriver initBrowser() {
                /*
           * 谷歌浏览器 System.setProperty("webdriver.chrome.driver",
          * "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
          * WebDriver driver = new ChromeDriver(); driver.get("http://www.baidu.com/");
         */
                 FirefoxProfile profile = new FirefoxProfile();
                 profile.setPreference("browser.download.manager.showWhenStarting", false);// 是否显示下载进度框////
                 profile.setPreference("browser.offline-apps.notify", false);// 网站保存离线数据时不通知我
                 profile.setPreference("browser.helperApps.alwaysAsk.force", false);// 应用程序设置不询问
                 profile.setPreference("browser.download.folderList", 0);// 设置下载地址0是桌面；1是“我的下载”；2是自定义
                 profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                                 "application/octet-stream, application/vnd.ms-excel, text/csv, application/zip, application/msword");
                 profile.setPreference("dom.webnotifications.enabled", false);// 允许通知
                 WebDriver driver = new FirefoxDriver(profile);// 启动火狐浏览器
                 driver.manage().window().maximize();// 设置窗口大小
                 driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);// 设置页面加载超时
                 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 设置查询组件等待时间
                return driver;
             }



              //----------------------------------------------------元素相关-----------------------------------------------------------------------------



              /**
        *     获取单个元素
        */
              public WebElement findElementByXpath(String xpath) {
                 return driver.findElement(By.xpath(xpath));
             }
              public WebElement findElementByTag(String tag) {
                 return driver.findElement(By.tagName(tag));
             }
              public WebElement findElementById(String id) {
                 return driver.findElement(By.id(id));
             }
              public WebElement findElementByClassName(String name) {
                 return driver.findElement(By.className(name));
             }
              public WebElement findElementByText(String text) {
                 return driver.findElement(By.linkText(text));
             }
              public WebElement findElementByPartialText(String text) {
                 return driver.findElement(By.partialLinkText(text));
             }
              public WebElement findElementByName(String name) {
                 return driver.findElement(By.name(name));
             }

             /**
        *    获取多个元素
        */
              public List<WebElement> findElementsByXpath(String xpath) {
                 return driver.findElements(By.xpath(xpath));
             }
              public List<WebElement> findElementsByText(String text) {
                 return driver.findElements(By.linkText(text));
             }
              public List<WebElement> findElementsByPartialText(String text) {
                 return driver.findElements(By.partialLinkText(text));
             }
              public List<WebElement> findElementsById(String id) {
                 return driver.findElements(By.id(id));
             }
              public List<WebElement> findElementsByTag(String tag) {
                 return driver.findElements(By.tagName(tag));
             }

              /**
        *    获取一组元素中的指定元素
        */
              public WebElement FindByElements(By by, int index) {
                 WebElement element = null;
                 if (this.elementsExists(by)) {
                         element = driver.findElements(by).get(index);
                     }
                 return element;
             }

              /**
        *     查找元素并点击
        * @param by      传入一个类型        例如：name
        * @param byValue 传入一个类型值       例如：username
        */
              public boolean findElementClick(String by, String byValue) {
                 try {
                     if ("id".equals(by)) {
                         driver.findElement(By.id(byValue)).click();
                         return true;
                     } else if ("name".equals(by)) {
                         driver.findElement(By.name(byValue)).click();
                         return true;
                     } else if ("class".equals(by)) {
                         driver.findElement(By.className(byValue)).click();
                         return true;
                     } else if ("tag".equals(by)) {
                         driver.findElement(By.tagName(byValue)).click();

                         driver.findElement(By.linkText(byValue)).click();
                         return true;
                     } else if ("link".equals(by)) {
                         driver.findElement(By.linkText(byValue)).click();
                         return true;
                     } else if ("partiallinktext".equals(by)) {
                         driver.findElement(By.partialLinkText(byValue)).click();

                         driver.findElement(By.cssSelector(byValue)).click();
                         return true;
                     } else if ("css".equals(by)) {
                         driver.findElement(By.cssSelector(byValue)).click();
                         return true;
                     } else if ("xpath".equals(by)) {
                         driver.findElement(By.xpath(byValue)).click();
                         return true;
                     } else {
                         throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
                     }
                     } catch (Exception e) {
                         System.out.println("*****没有找到元素,类型为：:" + by + "属性值为：" + byValue + "  的元素或者该元素无法点击****");
                         return false;
                     }
            }

             /**
        *    定位元素并点击
       */
              public void findElementByIdAndClick(String id) {

                  driver.findElement(By.id(id)).click();
             }
              public void findElementByNameAndClick(String name) {

                  driver.findElement(By.name(name)).click();
             }
              public void findElementByTextAndClick(String text) {
                 driver.findElement(By.linkText(text)).click();
             }
              public void findElementByPartiaTextAndClick(String text) {
                 driver.findElement(By.partialLinkText(text)).click();
             }

            public void xpathClick(String xpath) {

                driver.findElement(By.xpath(xpath)).click();
            }


    public void findElementByClassNameAndClick(String name) {
                 driver.findElement(By.className(name)).click();
             }

              public void findElementByLinkTextAndClick(String text){
                  driver.findElement(By.linkText(text)).click();
              }
             /**
        *     查找元素并清除文本内容
        * @param by      传入一个类型        例如：name
        * @param byValue 传入一个类型值       例如：username
        */
              public boolean findElementClear(String by, String byValue) {
                 try {
                     if ("id".equals(by)) {
                         driver.findElement(By.id(byValue)).clear();
                         return true;
                     } else if ("name".equals(by)) {
                         driver.findElement(By.name(byValue)).clear();
                         return true;
                     } else if ("class".equals(by)) {
                         driver.findElement(By.className(byValue)).clear();
                         return true;
                     } else if ("tag".equals(by)) {
                         driver.findElement(By.tagName(byValue)).clear();
                         return true;
                     } else if ("link".equals(by)) {
                         driver.findElement(By.linkText(byValue)).clear();
                         return true;
                     } else if ("partialLinkText".equals(by)) {
                         driver.findElement(By.partialLinkText(byValue)).clear();
                         return true;
                     } else if ("css".equals(by)) {
                         driver.findElement(By.cssSelector(byValue)).clear();
                         return true;
                     } else if ("xpath".equals(by)) {
                         driver.findElement(By.xpath(byValue)).clear();
                         return true;
                     } else {
                         throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
                     }
                     } catch (Exception e) {
                         System.out.println("*****没有找到元素,类型为：:" + by + "属性值为：" + byValue + "  的元素或者该元素没有输入值****");
                         return false;
                     }
             }

              /**
        *     查找元素并输入值
        * @param by      传入一个类型        例如：name
        * @param byValue 传入一个类型值       例如：username
        * @param key     填写要输入的值        例如：kitty
        */
              public boolean findElementSendKeys(String by, String byValue, String key) {
                 try {
                     if ("id".equals(by)) {
                         driver.findElement(By.id(byValue)).sendKeys(key);
                         return true;
                     } else if ("name".equals(by)) {
                         driver.findElement(By.name(byValue)).sendKeys(key);
                         return true;
                     } else if ("class".equals(by)) {
                         driver.findElement(By.className(byValue)).sendKeys(key);
                         return true;
                     } else if ("tag".equals(by)) {
                         driver.findElement(By.tagName(byValue)).sendKeys(key);
                         return true;
                     } else if ("link".equals(by)) {
                         driver.findElement(By.linkText(byValue)).sendKeys(key);
                         return true;
                     } else if ("partialLinkText".equals(by)) {
                         driver.findElement(By.partialLinkText(byValue)).sendKeys(key);

                         driver.findElement(By.cssSelector(byValue)).sendKeys(key);
                         return true;
                     } else if ("css".equals(by)) {
                         driver.findElement(By.cssSelector(byValue)).sendKeys(key);
                         return true;
                     } else if ("xpath".equals(by)) {
                         driver.findElement(By.xpath(byValue)).sendKeys(key);
                         return true;
                     } else {
                         throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
                     }
                     } catch (Exception e) {
                         System.out.println("*****没有找到元素,类型为：:" + by + "属性值为：" + byValue + "    的元素或者该元素无法输入****");
                         return false;
                     }
             }

              /**
        *    定位元素并清空文本内容，输入相应的值
        */

              public void findElementByXpathAndClearSendKeys(String xpath, BigDecimal text) {
                 findElementByXpath(xpath).clear();
                 findElementByXpath(xpath).sendKeys((CharSequence) BigDecimal);
             }
              public void xpathClearSendKeys(String xpath, String text) {
                 driver.findElement(By.xpath(xpath)).clear();
                 driver.findElement(By.xpath(xpath)).sendKeys(text);
             }
              public void findElementByClassnameAndClearSendKeys(String classname, int num) {
                 driver.findElement(By.className(classname)).clear();
                 driver.findElement(By.className(classname)).sendKeys(num + "");
             }

             //定位元素并清空

               public void findElementByXpathAndClear(String xpath){
                  driver.findElement(By.xpath(xpath)).click();
                  driver.findElement(By.xpath(xpath)).clear();
               }
              //定位元素点击并输入

              public void findElementByXpathAndClickSendKeys(String xpath,String text){
                  driver.findElement(By.xpath(xpath)).click();
                  driver.findElement(By.xpath(xpath)).sendKeys(text);
              }



              /**
        *    定位元素，并获取其文本内容
        */
              public String getTextByXpath(String xpath) {
                 return findElementByXpath(xpath).getText();
             }
              public String getTextByClassName(String name) {
                 return findElementByClassName(name).getText();
             }
              public String getTextById(String id) {
                 return findElementById(id).getText();
             }
              public String getTextByName(String name) {
                 return findElementByName(name).getText();
             }
              public String getAttribute(String xpath ){
                  return findElementByXpath(xpath).getAttribute("class");
              }

              /**
        *     定位元素，并指定点击次数(连续点击) 0s
        */
              public boolean clickById(String id, int clickCount) {
                 try {
                         for (int i = 0; i < clickCount; i++) {
                                 driver.findElement(By.id(id)).click();
                             }
                         return true;
                     } catch (Exception e) {
                         System.out.println(e.getMessage());
                         return false;
                     }
             }
              public boolean clickByXpath(String xpath, int clickCount) {
                 try {
                         for (int i = 0; i < clickCount; i++) {
                                 driver.findElement(By.xpath(xpath)).click();
                             }
                         return true;
                     } catch (Exception e) {
                         System.out.println(e.getMessage());
                         return false;
                     }
             }
              public boolean clickByCss(String css, int clickCount) {
                 try {
                         for (int i = 0; i < clickCount; i++) {
                                 driver.findElement(By.cssSelector(css)).click();
                             }
                         return true;
                     } catch (Exception e) {
                         System.out.println(e.getMessage());
                         return false;
                     }
             }

              // 判断元素是否存在
              public boolean exists(By selector) {
                 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);// 设置查询组件等待时间
                 try {
                         driver.findElement(selector);
                         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 设置查询组件等待时间
                         return true;
                     } catch (Exception e) {
                         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// 设置查询组件等待时间
                         return false;
                     }
             }
      /**
        *     判断一个元素是否存在
        */
              public boolean isElementExist(By by) {
                 try {
                         driver.findElement(by);
                         return true;
                     } catch (NoSuchElementException e) {
                         return false;
                     }
             }

              /**
        *    判断一组元素是否存在
        */
              public boolean elementsExists(By by) {
                 return driver.findElements(by).size() > 0;
             }

          //---------------------------------------判断页面是否包含指定文本---------------------------------------------------------
              /**
        *     1、指定时间内等待直到页面包含文本字符串
        * @param text        期望出现的文本
        * @param seconds     超时时间
        * @return Boolean    检查给定文本是否存在于指定元素中, 超时则捕获抛出异常TimeoutException并返回false
        *
        */
              public static Boolean waitUntilPageContain(String text,String xpath, long seconds) {
                 try {
                         return new WebDriverWait(driver, seconds)
                                 .until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("xpath")), text));
                     } catch (Exception e) {
                         e.printStackTrace();
                         return false;
                     }
             }

               //---------------------------------------元素判断---------------------------------------------------------
              /**
        *     1、指定时间内等待直到元素存在于页面的DOM上并可见, 可见性意味着该元素不仅被显示, 而且具有大于0的高度和宽度
        * @param locator 元素定位器
        * @param seconds 超时时间
        * @return Boolean 检查给定元素的定位器是否出现, 超时则捕获抛出异常TimeoutException并返回false
        * @see
        */
              public static Boolean waitUntilElementVisible(By locator, int seconds) {
                 try {
                         new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
                         return true;
                     } catch (Exception e) {
                         e.printStackTrace();
                         return false;
                     }
             }

            //driverUtil.waitElementLocated(alert,"修改成功！");
            public void waitElementLocated(String xpath,String text){

                  WebDriverWait wait = new WebDriverWait(driver,10);

                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath),text));

            }


    //封装显示等待方法

    public WebElement waitForElement(String xpath, int timeout ) {
        WebElement element =null;
        try {
            //设置显示等待
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            WebElement emailField=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(xpath))));

        } catch (Exception e) {
            System.out.println("元素没有在页面出现");
        }

        return element;

    }


            public void waitElementValue(String xpath,String text){

                  WebDriverWait wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.textToBePresentInElementValue(By.xpath(xpath),text));
            }





        /***
         *  只有满足显式等待的条件满足，测试代码才会继续向后执行后续的测试逻辑
         *
         * 如果超过设定的最大显式等待时间阈值， 这测试程序会抛出异常。
         *
         */


            public void WebElementWaitLocated(String xpath){

                WebDriverWait wait=new WebDriverWait(driver,10);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

                }

        /***
         * 页面元素是否在页面上可用和可被单击 elementToBeClickable(By locator)
         */


            public void WebElementWaitClick(String xpath){

                WebDriverWait wait = new WebDriverWait(driver,10);

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            }


            //页面元素处于被选中状态  elementToBeSelected(WebElement element)

            //页面元素在页面中存在  presenceOfElementLocated(By locator)

            //在页面元素中是否包含特定的文本  textToBePresentInElement(By locator)


              /**
        *    判断元素是否显示
        */
              public boolean getDisplayStatById(String id) {
                     return driver.findElement(By.id(id)).isDisplayed();
             }
              public boolean getDisplayStatByXpath(String xpath) {
                     return driver.findElement(By.xpath(xpath)).isDisplayed();
             }
              public boolean getDisplayStatByCss(String css) {
                 return driver.findElement(By.cssSelector(css)).isDisplayed();
             }
      /**
        *    判断元素是否可写
        */
              public boolean getEnableStatById(String id) {
                 return driver.findElement(By.id(id)).isEnabled();
             }
              public boolean getEnableStatByXpath(String xpath) {
                 return driver.findElement(By.xpath(xpath)).isEnabled();
             }
              public boolean getEnableStatByCss(String css) {
                 return driver.findElement(By.cssSelector(css)).isEnabled();
             }
      /**
        *    判断元素是否选中
        */
              public boolean getSelectStatById(String id) {
                 return driver.findElement(By.id(id)).isSelected();
             }
              public boolean getSelectStatByXpath(String xpath) {
                 return driver.findElement(By.xpath(xpath)).isSelected();
             }
              public boolean getSelectStatByCss(String css) {
                 return driver.findElement(By.cssSelector(css)).isSelected();
             }

              /**
        *     获取当前焦点所在页面元素的属性值(name,value,id,src等等)
        */
              public String getFocusAttributeValue(String attribute) {
                 String value = "";
                 try {
                         Thread.sleep(333);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                 value = driver.switchTo().activeElement().getAttribute(attribute);
                 System.out.println("The focus Element's " + attribute + "attribute value is>>" + value);
                 return value;
             }

              // 等待元素可用再点击
              public void waitForEnabledByXpathAndClick(String xpath) throws InterruptedException {
                 boolean key = true;
                 while (key) {
                         if (findElementByXpath(xpath).isEnabled() && findElementByXpath(xpath).isDisplayed()) {
                                 clickByJsByXpath(xpath);
                                 key = false;
                             } else {
                                 sleep(0);
                             }
                     }
             }
      // 自定义等待时间
              public static void sleep(int key) throws InterruptedException {
                  if (key == 0) {
                      Thread.sleep(500);

                  } else if (key == 1) {
                      Thread.sleep(2000);

                  } else if (key == 2) {
                      Thread.sleep(5000);

                  } else {
                      System.out.println("错误");

                  }
             }

          //---------------------------------------下拉列表操作---------------------------------------------------------

               // 根据id获取下拉框，根据index选择选项
              public void findSelectByIdAndSelectByIndex(String id, int index) {
                 Select select = new Select(findElementById(id));
                 select.selectByIndex(index);
             }
              // 根据id获取下拉框，根据value选择选项
              public void findSelectByIdAndSelectByValue(String id, String value) {
                 Select select = new Select(findElementById(id));
                 select.selectByValue(value);
             }
              // 根据id获取下拉框，根据text选择选项
              public void findSelectByIdAndSelectByText(String id, String text) {
                 Select select = new Select(findElementById(id));
                 select.selectByVisibleText(text);
             }

              // 根据classname获取下拉框，根据text选择选项
              public void findSelectByClassNameAndSelectByText(String name, String text) {
                 Select select = new Select(findElementByClassName(name));
                 select.selectByVisibleText(text);
             }
              // 根据classname获取下拉框，根据Value选择选项
              public void findSelectByClassNameAndSelectByValue(String name, String value) {
                 Select select = new Select(findElementByClassName(name));
                 select.selectByValue(value);
             }
              // 根据classname获取下拉框，根据index选择选项
              public void findSelectByClassNameAndSelectByIndex(String name, int index) {
                 Select select = new Select(findElementByClassName(name));
                 select.selectByIndex(index);
             }


             // 根据name获取下拉框，根据index选择选项
              public void findSelectByNameAndSelectByIndex(String name, int index) {
                 Select select = new Select(findElementByName(name));
                 select.selectByIndex(index);
             }
              //根据xpath获取下拉框，根据name选择选项
               public void findSelectByXpathAndSelectByValue(String xpath,String text){
                  Select select = new Select(findElementByXpath(xpath));
                  //select.selectByValue(value);
                  select.selectByVisibleText(text);
               }
            //通过linkText查找元素
                public void findElementByLinkText(String linkText){
                  driver.findElement(By.linkText(linkText));
                }



        /**
        *     定位select并选中对应text的option
        * @param locator
        * @param text
        * @see
        */
              public static void selectByText(By locator, String text) {
                 select = new Select(driver.findElement(locator));
                 select.selectByVisibleText(text);
             }

              /**
        *     定位select并选中对应index的option
        * @param locator
        * @param index
        * @see
        */
              public static void selectByIndex(By locator, int index) {
                 select = new Select(driver.findElement(locator));
                 select.selectByIndex(index);
             }

              /**
        *    定位select并选中对应value值的option
        * @param locator  定位select的选择器
        * @param value       option 中的value值
        * @see
       */
            public static void selectByValue(By locator, String value) {
                select = new Select(driver.findElement(locator));
                select.selectByValue(value);
           }

          //---------------------------------------弹框操作---------------------------------------------------------
             // 判断是否有弹框
          public boolean isAlertPresent() {
            try {
                alert = driver.switchTo().alert();
                      return true;
                 } catch (NoAlertPresentException Ex) {
                      return false;
                }
             }
      // 接受弹出框
             public void acceptAlert() {
                if (this.isAlertPresent()) {
                        alert.accept();
                  }
             }
      // 取消弹出框
              public void dismissAlert() {
                if (this.isAlertPresent()) {
                         alert.dismiss();
                    }
            }
     // 获取弹出内容
            public String getAlertText() {
                 String text = null;
                 if (this.isAlertPresent()) {
                       text = alert.getText();
                    } else {
                         // todo:log;
                     }
               return text;
            }
     // 弹出对话框输入文本字符串
             public void inputTextToAlert(String text) {
                 if (this.isAlertPresent()) {
                         alert.sendKeys(text);
                     } else {
                         // todo:log;
                     }
             }

          //---------------------------------------窗口和iframe---------------------------------------------------------
              /**
        *     切换到当前页面
        */
              public static void switchToCurrentPage() {
                 String handle = driver.getWindowHandle();
                 for (String tempHandle : driver.getWindowHandles()) {
                         if (tempHandle.equals(handle)) {
                                driver.close();
                             } else {
                                driver.switchTo().window(tempHandle);
                            }
                     }
            }
      /**
       *     切换到指定title的窗口
      */
              public void switchToWindow(String windowTitle) {
                 Set<String> windowHandles = driver.getWindowHandles();
                 for (String handler : windowHandles) {
                         driver.switchTo().window(handler);
                         String title = driver.getTitle();
                         if (windowTitle.equals(title)) {
                                 break;
                             }
                     }
             }

              /**
        *     切换至父级frame
        * @see
        */
              public static void switchToParentFrame() {
                 driver.switchTo().parentFrame();
             }

              /**
        *     切换默认最外层frame或者窗口
        * @return 这个驱动程序聚焦在顶部窗口/第一个frame上
        * @see
        */
              public static void switchToDefault() {
                 driver.switchTo().defaultContent();
             }

              /**
        *    切换到指定iframe
        */
              public void switchToFrameByXpath(String frameXpath) {
                 driver.switchTo().frame(frameXpath);
             }
              public void switchToFrameByIndex(int index) {
                 driver.switchTo().frame(index);
             }
              public void switchToFrameByElement(By locator) {
                 driver.switchTo().frame(driver.findElement(locator));
             }

              /**
               *
               *
               */
              public static void submitForm(By locator) {
                 driver.findElement(locator).submit();
             }

              /**
        *     上传文件
        */
              public static void uploadFile(By locator, String filePath) {
                 driver.findElement(locator).sendKeys(filePath);
             }

          //---------------------------------------JS操作---------------------------------------------------------
              // JS点击指定元素
              public void clickByJs(WebElement element) {
                  ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
             }

              // 定位元素触发JS点击事件
              public void clickByJsByXpath(String xpath) {
                 clickByJs(driver.findElement(By.xpath(xpath)));
             }
              public void clickByJsByText(String text) {
                 clickByJs(findElementByText(text));
             }
              public void clickByJsById(String id) {
                 clickByJs(findElementById(id));
             }
              public void clickByJsByClassName(String name) {
                 clickByJs(findElementByClassName(name));
             }
              public void clickByJsByName(String name) {
                 clickByJs(findElementByName(name));
             }

             //打开切换新的窗口
              public void openUrl(String openUrl){((JavascriptExecutor)driver).executeScript(openUrl);}
              // 滚动到窗口最上方
              public void scrollToTop() {
                 ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0);");
             }

             // 滚动到页面底部
              //public void scrollToBottom() {
                 //((JavascriptExecutor) driver).executeScript("window.scrollTo(0,10000);");
             //}
                public void scrollToBottom(){
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
                }
              //设置窗口比例
               public void scrollToWindow(){
                   ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%';");
               }
              //滚动到最右边
               public void scrollToRight(){
                   ((JavascriptExecutor) driver).executeScript("window.scrollTo(10000,1024);");
               }


              // 滚动到某个元素
              public void scrollToElement(String element) {
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].scrollIntoView(true);", element);
             }
              // js给指定元素value赋值
              public void inputTextByJs(String text, WebElement element) {
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].value=" + text + "\"", element);
             }
              // js使元素隐藏元素显示
              public void makeElementDisplay(WebElement element) {
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].style=arguments[1]", element, "display: block;");
             }




          //---------------------------------------浏览器操作---------------------------------------------------------
              /**
        *     关闭当前浏览器
        */
              public static void closeCurrentBrowser() {
                 driver.close();
             }
      /**
        *     关闭所有selenium驱动打开的浏览器
        */
              public static void closeAllBrowser() {
                 driver.quit();
             }
     /**
       *     最大化浏览器
       */
             public static void maxBrowser() {
                 driver.manage().window().maximize();
             }

             /**
       *     自定义设置浏览器尺寸
       */
             public static void setBrowserSize(int width, int heigth) {
                 driver.manage().window().setSize(new Dimension(width, heigth));
             }

             /**
       *     获取网页的title值
       */
             public String getTitle() {
                 return driver.getTitle();
             }

             /**
       *     获取当前url字符串
       */
             public static String getURL() {
                 return driver.getCurrentUrl();
             }

             /**
       *    上一个页面(点击浏览器返回)
       */
             public  void returnToPreviousPage() {

                 driver.navigate().back();
             }

             /**
       *     下一个页面(如果没有下一个页面则什么都不做)
       *     浏览器上的前进
       */
             public static void forwardToNextPage() {
                 driver.navigate().forward();
             }

             /**
       *     刷新页面
       */
             public static void refreshPage() {
                 driver.navigate().refresh();
             }

             // 强制刷新页面
             public void refresh() {
                 Actions ctrl = new Actions(driver);
                 ctrl.keyDown(Keys.CONTROL).perform();
                 try {
                         pressKeyEvent(KeyEvent.VK_F5);
                     } catch (AWTException e) {
                         e.printStackTrace();
                     }
                 ctrl.keyUp(Keys.CONTROL).perform();
             }

             /**
       *     判断是否加载有JQuery
       */
             public Boolean JQueryLoaded() {
                 Boolean loaded;
                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 try {
                         loaded = (Boolean) js.executeScript("return" + "JQuery()!=null");
                     } catch (WebDriverException e) {
                         loaded = false;
                     }
                 return loaded;
             }
 //---------------------------------------屏幕截图---------------------------------------------------------
             public void screenShot(WebDriver driver) {
                 String dir_name = "screenshot";
                 if (!(new File(dir_name).isDirectory())) {
                         new File(dir_name).mkdir();
                     }
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHMMss");
                 String time = sdf.format(new Date());
                 try {
                         File source_file = (((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE));// 执行截屏
                         FileUtils.copyFile(source_file, new File(dir_name + File.separator + time + ".png"));
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
             }
     // 截图命名为当前时间保存桌面
             public void takeScreenshotByNow() throws IOException {
                 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHMMss");
                 String time = sdf.format(new Date());
                 String file = "C:\\Users\\jtc\\Desktop\\picture\\" + time + ".png";
                 FileUtils.copyFile(srcFile, new File(file));
             }
     // 截图重命名保存至桌面
             public void takeScreenshotByName(String name) throws IOException {
                 File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                 String file = "C:\\Users\\zhangsan\\Desktop\\picture\\" + name + ".png";
                 FileUtils.copyFile(srcFile, new File(file));
             }

         //---------------------------------------键盘操作---------------------------------------------------------
             // 获取键盘
             public Keyboard getKeyboard() {
                 return ((HasInputDevices) driver).getKeyboard();
             }
     // 模拟ctrl+F5
             public void refreshWithCtrlF5() {
                 getKeyboard().sendKeys(Keys.CONTROL, Keys.F5);
             }
     /**
       *     按物理按键(KeyEvent类中查找相关的常量)
       *     例子：
       *        Robot robot = new Robot();
       *         robot.keyPress(KeyEvent.VK_ENTER);//按下enter键
       */
             public void pressKeyEvent(int keycode) throws AWTException {
                 Robot robot = new Robot();
                 robot.keyPress(keycode);
             }

         //---------------------------------------鼠标操作---------------------------------------------------------
             // 鼠标悬浮指定元素并点击
             public void moveToElementById(String id) {
                 Actions actions = new Actions(driver);
                 actions.moveToElement(findElementById(id)).perform();
             }
             public void moveToElementByClassName(String name) {
                 Actions actions = new Actions(driver);
                 actions.moveToElement(findElementByClassName(name)).perform();
             }

             // 鼠标右键点击
             public void RightClickWebElement(String id) {
                 Actions actions = new Actions(driver);
                 actions.contextClick(findElementById(id)).perform();
             }
     // 鼠标双击
             public void DoubleClickWebElement(String id) {
                 Actions actions = new Actions(driver);
                 actions.doubleClick(findElementById(id)).perform();
             }

             /**
       *    模拟点击键盘上的键：
       *        keyDown()按下
       *        keyUp()抬起,松开
       *
       *    常见的键：
       *        Keys.SHIFT    Keys.ALT   Keys.Tab
       */
             public void ClickCtrl(String id) {
                 Actions actions = new Actions(driver);
                 actions.keyDown(Keys.CONTROL);//按下control键
                 actions.keyUp(Keys.CONTROL);//松开control键
             }

             /**
       *    模拟键盘输入关键字到输入框
       */
             public void sendText(By by,String text) {
                 Actions actions = new Actions(driver);
                 actions.sendKeys(driver.findElement(by),text).perform();
             }

             /**
       *    模拟鼠标移动到指定元素,并点击
       */
             public void moveToElementAndClick(By by,String text) {
                 Actions actions = new Actions(driver);
                 actions.moveToElement(driver.findElement(by)).click().perform();
             }

             /**
       *    模拟鼠标点击和释放
       */
             public void clickHoldAndRelease(By by) {
                 Actions actions = new Actions(driver);
                 actions.clickAndHold(driver.findElement(by)).perform();
                 try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 actions.release(driver.findElement(by)).perform();
             }

             /**
              * 浏览器返回
              * */
             public void back(){

                 driver.navigate().back();
             }

             /**
              * 浏览器刷新
              * */
             public void refreshpage(){

                 driver.navigate().refresh();
             }

             /**
              *  浏览器前进
              * */
             public void forward(){

                 driver.navigate().forward();
             }




             //获取动态id值
           //String s1=driver.findElement(By.xpath("//input[9]")).getAttribute("id");



        //---------------------------------------Cookie操作---------------------------------------------------------
             /**
       *     获取当前域所有的cookies
       * @return Set&lt;Cookie> 当前的cookies集合
       *
       */
             public static Set<Cookie> getAllCookies() {
                 return driver.manage().getCookies();
             }
     // 输出cookies信息
             public void outputCookie() {
                 Set<Cookie> cookie = driver.manage().getCookies();
                 System.out.println(cookie);
             }
     //添加cookie信息
             public void addCookie(Map<String, String> args) {
                 Set<String> keys = args.keySet();
                 for (String key : keys) {
                         driver.manage().addCookie(new Cookie(key, args.get(key)));
                     }
             }
     /**
       *     用给定的name和value创建默认路径的Cookie并添加, 永久有效
       * @param name
       * @param value
       *
       */
             public static void addCookie(String name, String value) {
                 driver.manage().addCookie(new Cookie(name, value));
             }

             /**
       *     用给定的name和value创建指定路径的Cookie并添加, 永久有效
       * @param name  cookie名称
       * @param value cookie值
       * @param path  cookie路径
       */
             public static void addCookie(String name, String value, String path) {
                 driver.manage().addCookie(new Cookie(name, value, path));
             }
     /**
       *     根据cookie名称删除cookie
       * @param name cookie的name值
       *
       */
             public static void deleteCookie(String name) {
                 driver.manage().deleteCookieNamed(name);
             }
     /**
       *     删除当前域的所有Cookie
       *
       */
             public static void deleteAllCookies() {
                 driver.manage().deleteAllCookies();
             }

             /**
       *     根据名称获取指定cookie
       * @param name cookie名称
       * @return Map&lt;String, String>, 如果没有cookie则返回空, 返回的Map的key值如下:
       *         <ul>
       *         <li><tt>name</tt> <tt>cookie名称</tt>
       *         <li><tt>value</tt> <tt>cookie值</tt>
       *         <li><tt>path</tt> <tt>cookie路径</tt>
       *         <li><tt>domain</tt> <tt>cookie域</tt>
       *         <li><tt>expiry</tt> <tt>cookie有效期</tt>
       *         </ul>
       *
       */
             public static Map<String, String> getCookieByName(String name) {
                 Cookie cookie = driver.manage().getCookieNamed(name);
                 if (cookie != null) {
                         Map<String, String> map = new HashMap<String, String>();
                         map.put("name", cookie.getName());
                         map.put("value", cookie.getValue());
                         map.put("path", cookie.getPath());
                         map.put("domain", cookie.getDomain());
                         map.put("expiry", cookie.getExpiry().toString());
                         return map;
                     }
                 return null;
             }

         //---------------------------------------远程---------------------------------------------------------
             /**
       *     进入测试，打开浏览器，输入网址，打开网页
       *
       * @param remoteUrl 远程服务器地址
       * @param pageUrl   测试页面地址
       */
             public boolean startTest(String remoteUrl, String pageUrl) {
                 try {
                         try {
                                 driver = new RemoteWebDriver(new URL(remoteUrl), DesiredCapabilities.firefox());
                             } catch (MalformedURLException e) {
                                 e.printStackTrace();
                             }
                         driver.get(pageUrl);
                         return true;
                     } catch (Exception e) {
                         e.printStackTrace();
                         System.out.println(e.getMessage());
                         return false;
                     }
             }

        public Object toString(String s) {return s;
        }

            //获取警告弹窗文本信息

        public String closeAlertAndGetItsText() {

            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                if (acceptNextAlert) {
                    alert.accept();
                } else {
                    alert.dismiss();
                }
                return alertText;
            } finally {
                acceptNextAlert = true;
            }
        }

            public String getProperty(String datePlayerAccount) {

                    return datePlayerAccount;
            }


            /*
             *获取系统日期
             * String
             */

            public  void date() {
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd ");//设置日期格式
                    System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
            }




    /**   setScale(1,BigDecimal.ROUND_DOWN)直接删除多余的小数位，如2.35会变成2.3
             *   setScale(1,BigDecimal.ROUND_HALF_UP)四舍五入，2.35变成2.4
             *   BigDecimal b = new BigDecimal("123.456");
             *   b.scale(),返回的就是3.
             *
             *   Substring  (0,3) 保留0-3：Sub
         *
         *
             *  加法add
             *  减法subtract
             *  乘法multiply
             *  除法divide
             *
             * */
    }
