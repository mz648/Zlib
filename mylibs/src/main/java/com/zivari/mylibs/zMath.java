package com.zivari.mylibs;

public class zMath {

    public  static String  digit_seprator(String num){
        String price_str;
        long price=long_tryparse(num);
        price_str=String.format("%,d",price);
        return price_str;
    }

    public static int integer_tryparse(String str) {

        int num;
        if(str.equals("") || str.toLowerCase().equals("null"))
            num=0;
        else{
            str=str.replace(",","").replace("٬","");
            num=Integer.parseInt(str);
        }

        return num;
    }
    public static long long_tryparse(String str) {

        long num;
        if(str.equals("") || str.toLowerCase().equals("null"))
            num=0;
        else{
            str=str.replace(",","").replace("٬","");
            num=Long.parseLong(str);

        }
        return num;
    }
}
