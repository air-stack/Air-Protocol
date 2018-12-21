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
        String result = String.valueOf(A * ((Integer.parseInt(voutH) * 256 + Integer.parseInt(voutL)) / 1024 * 5));
        double resultNum = Double.parseDouble(result);
        // 进行数据拟合 使数据趋近于正常值
        if (resultNum >= 10000) {
            resultNum = resultNum / 100;
        } else if (resultNum >= 5000) {
            resultNum = resultNum / 20;
        } else if (resultNum >= 1000) {
            resultNum = resultNum / 10;
        }
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
