package publicModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pobliclogin {
    public static void username(WebDriver driver){
        WebElement login = driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[2]/div/div[1]/input"));
        login.clear();
        login.sendKeys();
    }
    public static void password(WebDriver driver){
        WebElement password=driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[3]/div/div/input"));
        password.clear();
        password.sendKeys();
    }
    public static void login(WebDriver driver){
        driver.findElement(By.xpath(".//*[@id='root']/div/div/div/form/div[5]/div/div[1]")).click();
    }
}
