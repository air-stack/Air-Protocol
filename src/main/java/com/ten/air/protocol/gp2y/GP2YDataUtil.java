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
     * 浓度 = A * Vout (ug/m3)
     * <p>
     * Vout = ( Vout(H) * 256 + Vout(L) ) / 1024 * 5
     *
     * @param voutH
     * @param voutL
     */
    public static String calculateDensity(String voutH, String voutL) {
        return String.valueOf(A * ((Integer.parseInt(voutH) * 256 + Integer.parseInt(voutL)) / 1024 * 5));
    }

    /**
     * 检查校验和
     */
    public static boolean checkSum(GP2YDataType gp2YDataType) {
        // TODO
        return true;
    }

}
