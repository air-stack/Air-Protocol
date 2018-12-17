package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;

/**
 * Protocol 解码工具 Hex->String
 */
public class ProtocolDecode {

    /**
     * 将十六进制的数据属性转换为十进制的数据属性
     *
     * @param airRecord 应传入[temperature, pm25, co2, so2]
     */
    public static AirRecord parseProtocol(AirRecord airRecord) {
        airRecord.setTemperature(parseTemp(airRecord.getTemperature()));
        airRecord.setPm25(parsePm25(airRecord.getPm25()));
        airRecord.setCo2(parseCo2(airRecord.getCo2()));
        airRecord.setSo2(parseSo2(airRecord.getSo2()));
        return airRecord;
    }

    /* --------------------------------------------------------------------- */

    /**
     * 解析温度
     * 双精度 :0x19 0x02 -> 25.2℃
     */
    private static String parseTemp(String temp) {
        if (temp.length() == 4) {
            String integerHex = temp.substring(0, 2);
            String decimalHex = temp.substring(2, 4);
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

    /**
     * 解析PM25
     * 单精度 :0x00 0xfa -> 250
     */
    private static String parsePm25(String pm25) {
        return parseInteger(pm25);
    }

    /**
     * 解析CO2
     * 单精度 :0x00 0xfa -> 250
     */
    private static String parseCo2(String co2) {
        return parseInteger(co2);
    }

    /**
     * 解析SO2
     * 单精度 :0x00 0xfa -> 250
     */
    private static String parseSo2(String so2) {
        return parseInteger(so2);
    }

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
