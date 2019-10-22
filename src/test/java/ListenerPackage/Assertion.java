package ListenerPackage;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

public class Assertion {

    public static boolean flag = true;
    public static boolean currentFlag() {
        return flag;
    }
    public static void setFlag(boolean flag) {
        Assertion.flag = flag;
    }
    public static List<Error> errors = new ArrayList<Error>();

    public static void verifyEquals(Object actual, Object expected){
        try{
            Assert.assertEquals(actual, expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }



    public static void verifyNotEquals(Object actual, Object expected){
        try{
            Assert.assertNotEquals(actual, expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifyNotNull(Object actual, Object expected){
        try{
            Assert.assertNotNull(actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }



    public static void verifyFalse(Object actual, Object expected){
        try{
            Assert.assertFalse((Boolean) actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifySame(Object actual, Object expected){
        try{
            Assert.assertSame(actual, (String) expected);
        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }


    public static void verifyNotSame(Object actual, Object expected){
        try{
            Assert.assertNotSame(actual, (String) expected);

        }catch(Error e){

            e.printStackTrace(); //仅仅代表异常消息的输出
            setFlag(false); //抛出异常时记录flag=false

        }
    }





}