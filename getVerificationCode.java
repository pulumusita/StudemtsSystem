package Students;

/*
生成验证码程序
 */

import java.util.Random;

public class getVerificationCode {

    //创建验证码
    public static String getIdentifying() {
        char[] arr = new char[52];

        String result = "";


        Random rd = new Random();
        //数组中随机抽取4个字母
        for (int i = 0; i < 5; i++) {
            int index = rd.nextInt(52);
            result = result + getArr(arr)[index];
        }
        int number = rd.nextInt(10);

        result = result + number;

        return result;

    }

    //大写字母和小写字母都保存到数组当中
    public static char[] getArr(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i <= 25) {
                arr[i] = (char) (97 + i);
            } else {
                arr[i] = (char) (65 + i - 26);
            }
        }
        return arr;
    }

    public static String disturbanceStr(String str) {
        char[] arr = str.toCharArray();
        Random ra = new Random();

        for (int i = 0; i < arr.length; i++) {
            int number = ra.nextInt(arr.length);
            char tmp = arr[i];//定义记录初始a
            arr[i] = arr[number];//arr[number]赋给arr[i]
            arr[number] = tmp;//tmp赋给arr[number]
        }
        String result = new String(arr);
        return result;
    }
}
