package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Stopserve {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void testclose() throws InterruptedException {
        WebElement login = driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[2]/div/div[1]/input"));
        login.clear();
        login.sendKeys("xiaochaoadmin");
        WebElement password=driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[3]/div/div/input"));
        password.clear();
        password.sendKeys("123123");
        driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[5]/div/div[1]")).click();
        driver.findElement(By.xpath(".//*[@id='root']/section/div[1]/div[1]/div/ul/div/a[8]/li")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[10]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//斗地主确认开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[9]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//骰宝开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[8]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//对战牛牛开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[7]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//百家乐VIP开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[6]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//龙虎斗开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[5]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//百家乐开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[4]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//抢庄牛牛开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[3]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//桃园结义开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[2]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//捕鱼开服
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='root']/section/section/main/div[2]/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr[1]/td[3]/div/div/button[1]")).click();
        driver.findElement(By.xpath(".//*[@id='playerModifPassword']/div[1]/div/div/input")).sendKeys("123123");
        driver.findElement(By.xpath("html/body/div[5]/div/div[3]/span/button[1]")).click();//大厅开服

    }
    @BeforeClass
    public void beforeclose(){
        String Url = "http://192.168.1.8:9091/#/login";
        driver.get(Url);
        driver.manage().window().maximize();
    }
    @AfterClass
    public void afterclose(){
        driver.quit();
    }
}
