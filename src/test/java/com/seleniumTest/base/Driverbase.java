package com.seleniumTest.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

//浏览器的基类
public class Driverbase {
    public WebDriver driver;

    //构造方法
    public Driverbase(String browser) {
        //初始化浏览器选择类
        SelectDriver selectDriver = new SelectDriver();
        //把确定之后的浏览器实例赋值给当前的Webdriver
        this.driver = selectDriver.driverName(browser);
    }

    /*
     * 获取driver
     * */
    public WebDriver getDriver() {
        return driver;
    }

    //关闭浏览器驱动方法
    public void stopDriver() {
        System.out.println("Stop Driver!");
        driver.close();
    }


    /*
     * 封装Element方法
     *
     * */
    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    /*
     * get封装
     * */
    public void get(String url) {
        driver.get(url);
    }

    /*
     * 封装click（点击）方法
     * 需要传入一个WebElement类型的元素
     *
     * */
    public void click(WebElement element) {
        if (element != null) {
            element.click();
        } else {
            System.out.println("元素未定位到,定位失败");
        }
    }

    /*
     * 返回
     *
     * */
    public void back() {
        driver.navigate().back();
    }

    /*
     * 刷新
     *
     * */
    public void refresh() {
        driver.navigate().refresh();
        ;
    }

    /**
     * 屏幕最大化
     */
    public void getWindowMax() {
        driver.manage().window().maximize();
    }

    /*
     * 休眠
     * */
    public void sleep(int num) {
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 切换alert窗口
     */
    public void switchAlert() {
        driver.switchTo().alert();
    }

    /**
     * 模态框切换
     */
    public void switchToMode() {
        driver.switchTo().activeElement();
    }

    /**
     * actionMoveElement
     */
    public void action(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * 获取cookcie
     *
     * @return
     */
    public Set<Cookie> getCookie() {
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

    /**
     * 删除cookie
     */
    public void deleteCookie() {
        driver.manage().deleteAllCookies();
    }

    /**
     * 设置cookie
     */
    public void setCookie(Cookie cookie) {
        driver.manage().addCookie(cookie);
    }

    /**
     * 获取当前系统窗口list
     */
    public List<String> getWindowsHandles() {
        Set<String> winHandels = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }

    /*
     * 获取当前窗口
     * **/
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    /**
     * 切换windows窗口
     */
    public void switchWindows(String name) {
        driver.switchTo().window(name);
    }

    /**
     * 获取当前url
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * 获取title
     */
    public String getTitle() {
        return driver.getTitle();
    }

    /**
     * 传入参数截图
     */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }

    /**
     * 封装定位一组elements的方法
     */
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    /**
     * 自动截图
     */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
        //takeScreenShot((TakesScreenshot) driver, path);
    }
}
