package util;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


public class StringToNumber {

        /***
         * 带逗号的数字替换为空，保留数字
         */

        public static BigDecimal toBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll(",", "");
                        return new BigDecimal(total);
                }
                return null;
        }


        /**
         * 带”-“的数字替换为空，保留数字
         */


        public static BigDecimal DateBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll("-", "");
                        return new BigDecimal(total);
                }
                return null;
        }


        // public static void main(String[] ars){
        //BigDecimal b = moneyBigDecimal("¥150");
        // Integer rowCount = 1;
        //String stringValue = "1";

//      Assert.assertEquals(rowCount,stringValue); //this fails

        // Assert.assertEquals(rowCount,Integer.valueOf(stringValue)); //this passes
        // System.out.println(stringValue);
        // }


        public static void main(String[] ars) {

        }
        @Test
        public void number(){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date date = new Date();
                String b = dateFormat.format(date);
                int b1 = Integer.valueOf(b).intValue();
                String c = "20190330";
                int c1 = Integer.valueOf(c).intValue();

                if (b1 ==c1) {
                        System.out.println("ok");
                } else if (b1!=c1) {
                        System.out.println("NO");
                }

        }

        @Test
        public void subString(){
                String a1 = "-";
                String a2 = a1.substring(0,1);
                System.out.println(a2);
        }
        @Test
        public void  StringInt(){
                String a1 = "9999.000";
                Number number = Float.parseFloat(a1)*1000;
                int a2 = number.intValue();
                System.out.println(a2);

        }
        //BigDecimal类型断言，都要转换为BigDecimal类型，而不是int或String
}