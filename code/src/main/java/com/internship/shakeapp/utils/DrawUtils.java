package com.internship.shakeapp.utils;

import java.util.Random;

public class DrawUtils {

    private static final int multiple = 1000000;

    public static int calDrawResult() {
        return new Random().nextInt(multiple);
    }

    /**
     * 模拟风控检测
     * 10%的机率不通过风控检测
     * @return true通过风控哦检测, false未通过风控检测
     */
    public static boolean checkRisk() {
        int randomNum = new Random().nextInt(100);
        return randomNum > 9;
    }

}
