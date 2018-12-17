package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;

/**
 * Protocol 编码工具 String->Hex
 */
public class ProtocolEncode {

    // 数据协议长度 72字节
    private static final int LENGTH = 72;

    // 数据帧头码 2字节
    private static final String HEAD = "A00F";
    // 数据帧字节数 1字节
    private static final String SIZE = "24";
    // 功能码 1字节
    private static final String FUNC = "01";
    // 和校验 2字节
    private static final String CHECK = "0000";

    /**
     * 将十进制指标转为十六进制协议字符串
     *
     * @param airRecord 应传入[imei, source, temperature, pm25, co2, so2]
     */
    public static String toHexProtocol(AirRecord airRecord) {
        StringBuilder protocol = new StringBuilder();

        protocol.append(HEAD);
        protocol.append(SIZE);
        protocol.append(genHexTime());
        protocol.append(FUNC);
        protocol.append(toHexImei(airRecord.getImei()));
        protocol.append(toHexSource(airRecord.getSource()));
        protocol.append(toHexDecimalData(airRecord.getTemperature()));
        protocol.append(toHexIntegerData(airRecord.getPm25()));
        protocol.append(toHexIntegerData(airRecord.getCo2()));
        protocol.append(toHexIntegerData(airRecord.getSo2()));
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("协议转换出错！");
        }

        return protocol.toString();
    }

    /* --------------------------------------------------------------------- */

    // 模拟数据来源标记
    private static final String SOURCE = "01";

    /**
     * 根据模拟指标生成十六进制协议字符串
     *
     * @param airIndex 应传入[temperature, pm25, co2, so2]
     */
    static String genHexProtocol(String imei, ProtocolGenerator.AirIndex airIndex) {
        StringBuilder protocol = new StringBuilder();

        protocol.append(HEAD);
        protocol.append(SIZE);
        protocol.append(genHexTime());
        protocol.append(FUNC);
        protocol.append(toHexImei(imei));
        protocol.append(toHexSource(SOURCE));
        protocol.append(toHexDecimalData(airIndex.getTemperature()));
        protocol.append(toHexIntegerData(airIndex.getPm25()));
        protocol.append(toHexIntegerData(airIndex.getCo2()));
        protocol.append(toHexIntegerData(airIndex.getSo2()));
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("协议转换出错！");
        }

        return protocol.toString();
    }

    /* --------------------------------------------------------------------- */

    /**
     * 生成时间戳 6Byte
     */
    private static String genHexTime() {
        return String.valueOf(System.currentTimeMillis()).substring(0, 12);
    }

    /**
     * 地址码 15Byte
     */
    private static String toHexImei(String imei) {
        if (imei.length() != 30) {
            imei = fillData(imei, 30);
        }
        return imei;
    }

    /**
     * 数据来源 1Byte
     */
    private static String toHexSource(String source) {
        if (source.length() == 2) {
            return source;
        }
        return "00";
    }

    /**
     * 仅有整数部分的数据 整数2Byte
     */
    private static String toHexIntegerData(String data) {
        String[] number = data.split("\\.");

        // 判断数据为空
        if (number.length < 1 || "".equals(number[0])) {
            return "0000";
        }

        // 进行进制转换
        try {
            Integer integer = Integer.parseInt(number[0]);
            String hexInteger = Integer.toHexString(integer);
            return fillData(hexInteger, 4);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("单精度十六进制数据转换失败");
            return "XXXX";
        }
    }

    /**
     * 带小数部分的数据 整数1Byte + 小数1Byte
     */
    private static String toHexDecimalData(String data) {
        String[] number = data.split("\\.");

        // 判断数据为空
        if (number.length < 2 || "".equals(number[0]) || "".equals(number[1])) {
            return "0000";
        }

        // 进行数制转换
        try {
            Integer integer = Integer.parseInt(number[0]);

            // 小数部分精确到2位
            if (number[1].length() > 2) {
                number[1] = number[1].substring(0, 2);
            }
            Integer decimal = Integer.parseInt(number[1]);

            String hexInteger = Integer.toHexString(integer);
            String hexDecimal = Integer.toHexString(decimal);

            // 字节填充
            hexInteger = fillData(hexInteger, 2);
            hexDecimal = fillData(hexDecimal, 2);

            return hexInteger + hexDecimal;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("双精度十六进制数据转换失败");
            return "XXXX";
        }
    }

    /**
     * 字节填充 补零
     */
    private static String fillData(String data, int expect) {
        int lack = expect - data.length();
        String result = "";
        // 超出范围
        if (lack < 0) {
            while (expect-- > 0) {
                result += "F";
            }
            return String.valueOf(result);
        }
        // 前缀补零
        else {
            result = data;
            while (lack-- > 0) {
                result = "0" + result;
            }
            return String.valueOf(result);
        }
    }
}
