package com.ten.air.protocol.gp2y;

/**
 * Calculation Util
 */
public class GP2YDataUtil {
    /**
     * 比例系数
     */
    private static final double A = 0.35;

    /**
     * 浓度 = A * Vout (mg/m3)
     * A : (mg/m3) / v
     * Vout = ( Vout(H) * 256 + Vout(L) ) / 1024 * 5
     *
     * @param voutH 传感器数据
     * @param voutL 传感器数据
     * @return 单精度整数
     */
    public static String calculateDensity(String voutH, String voutL) {
        int h = Integer.parseInt(voutH);
        int l = Integer.parseInt(voutL);
        double result = A * ((h * 256 + l) / 1024 * 5);
        int resultNum = (int) result;
        return String.valueOf(resultNum);
    }

    /**
     * 检查校验和
     */
    public static boolean checkSum(GP2YDataType gp2YDataType) {
        // TODO
        return true;
    }

}
