package ProFileUtil;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * 加載和解析配置文件
 *
 * @author alzhang
 */
public class ProFileUtil {

    Properties proerties;

    public ProFileUtil(){

    }
    // 加載配置文件方法
    public  ProFileUtil(String propFile) {
        proerties = new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream(propFile);
            proerties.load(in);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    // 解析配置文件
    public By parseProFile(String elementName) {
        // 根据变量elementName，从配置文件中读取对应的配置对象。
        String by = proerties.getProperty(elementName);
        // 将配置文件中的定位类型存到byType变量中。将定位表达式的值存到byValue变量中。
        String byType = by.split(",")[0];
        String byValue = by.split(",")[1];

        if ("id".equals(byType)) {
            return By.id(byValue);
        } else if ("name".equals(byType)) {
            return By.name(byValue);
        } else if ("class".equals(byType)) {
            return By.className(byValue);
        } else if ("tag".equals(byType)) {
            return By.className(byValue);
        } else if ("link".equals(byType)) {
            return By.linkText(byValue);
        } else if ("partiallinktext".equals(byType)) {
            return By.partialLinkText(byValue);
        } else if ("css".equals(byType)) {
            return By.cssSelector(byValue);
        } else if ("xpath".equals(byType)) {
            return By.xpath(byValue);
        } else {
            throw new RuntimeException("输入的定位类型未在程序中定义，类型为：" + byValue);
        }

    }



}
