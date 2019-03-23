package util;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;

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
         * 带”人“的数字替换为空，保留数字
         */

        public static BigDecimal peopleBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll("人", "");
                        return new BigDecimal(total);
                }
                return null;
        }

        /**
         * 带”人“的数字替换为空，保留数字
         */


        public static BigDecimal DateBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll("-", "");
                        return new BigDecimal(total);
                }
                return null;
        }


        /***
         *
          * @param text
         * @return 带”¥“的替换为空，保留数字
         */

        public static BigDecimal moneyBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll("¥","");
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


        public static void main(String[] ars){

                SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd ");//设置日期格式
                System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        }



}