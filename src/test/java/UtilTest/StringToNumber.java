package UtilTest;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class StringToNumber {

        /***
         * 带逗号的数字替换为空，保留数字
         */

        public static BigDecimal toBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total = text.replaceAll(",", "");
                        String total2 = text.replaceAll(".", "");
                        String total3 = text.replaceAll(":","");
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


        public static BigDecimal pointBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total2 = text.replaceAll(".", "");
                        return new BigDecimal(total2);
                }
                return null;
        }



        public static BigDecimal colonBigDecimal(String text) {
                if (StringUtils.isNotEmpty(text)) {
                        String total3 = text.replaceAll(":", "");
                        return new BigDecimal(total3);
                }
                return null;
        }


        //String转换int
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

        //截取
        @Test
        public void subString(){
                String a1 = "0.000/0";
                String a2 = a1.substring(a1.indexOf("/")+1);
                String a3 = a1.substring(0,3);
                System.out.println(a2);
                System.out.println(a3);

        }
        @Test
        public void  StringInt(){
                String a1 = "9999.000";
                Number number = Float.parseFloat(a1)*1000;
                int a2 = number.intValue();
                System.out.println(a2);

        }
        //BigDecimal类型断言，都要转换为BigDecimal类型，而不是int或String

        //随机数
        @Test
        public void test(){
                int max=100;
                int min=1;
                Random random = new Random();

                int s = random.nextInt(max)%(max-min+1) + min;
                System.out.println(s);
        }

        //从0开始随机数，0-50
        @Test
        public void test2(){
                Random random = new Random();
                int s = random.nextInt(50) ;
                System.out.println(s);
        }

         //尝试写会员管理的资金明细，判断暂无数据和有数据的的判断不同筛选类型

        @Test
        public void contains(){
                String aa = "1234";
                System.out.println(aa.contains("4"));//如果存在返回true，不存在返回false
        }


}