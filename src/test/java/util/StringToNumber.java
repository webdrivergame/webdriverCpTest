package util;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

public class StringToNumber {

        public static BigDecimal toBigDecimal(String text){
                if(StringUtils.isNotEmpty(text)){
                        String total = text.replaceAll(",", "");
                        return new BigDecimal(total);
                }
                return null;
        }

        public static void main(String[] ars){
                BigDecimal a = toBigDecimal("123,1231.000");
                System.out.println(a);
        }


}
