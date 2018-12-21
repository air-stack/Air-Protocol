package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;

/**
 * Protocol 解码工具 Hex->String
 */
public class ProtocolDecode {
    /**
     * 协议字符串长度
     */
    private static final int DATA_LENGTH = 72;

    /**
     * 解析协议字符串，返回记录数据对象
     */
    public static AirRecord parseProtocol(String protocol) {
        AirRecord airRecord = new AirRecord();

        // 长度校验
        if (protocol.length() < DATA_LENGTH) {
            System.out.println("长度校验失败 :" + protocol.length());
            return null;
        }

        // 地址码 (11-25)字节
        String imei = protocol.substring(20, 50);
        // 数据来源 (26)字节
        String source = protocol.substring(50, 52);
        // 数据1 温度 (27-28)字节
        String temperature = protocol.substring(52, 56);
        // 数据2 湿度 (29-30)字节
        String humi = protocol.substring(56, 60);
        // 数据3 PM25 (31-32)字节
        String pm25 = protocol.substring(60, 64);
        // 数据4 未定义 (33-34)字节
        String undef = protocol.substring(64, 68);

        airRecord.setImei(imei);
        airRecord.setSource(source);
        airRecord.setTemperature(temperature);
        airRecord.setHumidity(humi);
        airRecord.setPm25(pm25);
        airRecord.setUndefinedData(undef);

        // 转换十六进制为十进制数据
        return toDecimalProtocol(airRecord);
    }

    /**
     * 将十六进制的数据属性转换为十进制的数据属性 Decimal
     *
     * @param airRecord 应传入[temperature, pm25, co2, so2]
     */
    static AirRecord toDecimalProtocol(AirRecord airRecord) {
        airRecord.setTemperature(parseTemp(airRecord.getTemperature()));
        airRecord.setHumidity(parseHumi(airRecord.getHumidity()));
        airRecord.setPm25(parsePm25(airRecord.getPm25()));
        airRecord.setUndefinedData(parseUndef(airRecord.getUndefinedData()));
        return airRecord;
    }

    /* --------------------------------------------------------------------- */

    /**
     * 解析温度
     * 双精度 :0x19 0x02 -> 25.2℃
     */
    private static String parseTemp(String temp) {
        return parseDoubleByteData(temp);
    }

    /**
     * 解析湿度
     * 双精度 :0x19 0x02 -> 25.2 %
     */
    private static String parseHumi(String humi) {
        return parseDoubleByteData(humi);
    }

    /**
     * 解析双精度数据
     */
    private static String parseDoubleByteData(String data) {
        if (data.length() == 4) {
            String integerHex = data.substring(0, 2);
            String decimalHex = data.substring(2, 4);
            try {
                String integer = String.valueOf(Integer.parseInt(integerHex, 16));
                String decimal = String.valueOf(Integer.parseInt(decimalHex, 16));
                return integer + "." + decimal;
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("十六进制双精度数据解析出错！");
                return "xx.xx";
            }
        }
        return "xx.xx";
    }

    /* --------------------------------------------------------------------- */

    /**
     * 解析PM25
     * 单精度 :0x00 0xfa -> 250
     */
    private static String parsePm25(String pm25) {
        return parseInteger(pm25);
    }


    /**
     * 解析SO2
     * 单精度 :0x00 0xfa -> 250
     */
    private static String parseUndef(String undef) {
        return parseInteger(undef);
    }

    /**
     * 解析单精度数据
     */
    private static String parseInteger(String data) {
        if (data.length() < 1) {
            return "x";
        }
        try {
            return String.valueOf(Integer.parseInt(data, 16));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("十六进制单精度数据解析出错！");
            return "x";
        }
    }
}
