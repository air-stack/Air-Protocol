package com.ten.air.protocol;

import com.ten.air.protocol.bean.AirRecord;
import com.ten.air.protocol.dht11.DHT11DataType;
import com.ten.air.protocol.gp2y.GP2YDataType;
import com.ten.air.protocol.gp2y.GP2YDataUtil;

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

    // 真实数据来源
    private static final String REAL_SOURCE = "00";
    // 虚拟数据来源
    private static final String VIRTUAL_SOURCE = "01";

    // 填补空数据
    private static final String NOTHING_DATA = "0000";


    /**
     * 将DHT11模块发送的十进制指标转为十六进制协议字符串
     *
     * @param dataType 应传入[imei, tempInt, tempDeci, humiInt, humiDeci]
     */
    public static String toHexProtocol(DHT11DataType dataType) {
        StringBuilder protocol = new StringBuilder();

        protocol.append(HEAD);
        protocol.append(SIZE);
        protocol.append(genHexTime());
        protocol.append(FUNC);
        protocol.append(toHexImei(dataType.getImei()));
        protocol.append(REAL_SOURCE);
        // 温度 2字节 双精度
        protocol.append(toHexDecimalData(dataType.getTempInt(), dataType.getTempDeci()));
        // 湿度 2字节 双精度
        protocol.append(toHexDecimalData(dataType.getHumiInt(), dataType.getHumiDeci()));
        protocol.append(NOTHING_DATA);
        protocol.append(NOTHING_DATA);
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("Protocol conversion error!");
        }
        return protocol.toString();
    }


    /**
     * 将GP2Y模块发送的十进制指标转为十六进制协议字符串
     *
     * @param dataType 应传入[imei, voutH, voutL]
     */
    public static String toHexProtocol(GP2YDataType dataType) {
        StringBuilder protocol = new StringBuilder();

        protocol.append(HEAD);
        protocol.append(SIZE);
        protocol.append(genHexTime());
        protocol.append(FUNC);
        protocol.append(toHexImei(dataType.getImei()));
        protocol.append(REAL_SOURCE);
        protocol.append(NOTHING_DATA);
        protocol.append(NOTHING_DATA);
        // PM25浓度 2字节 单精度
        protocol.append(toHexIntegerData(
                GP2YDataUtil.calculateDensity(
                        dataType.getVoutH(),
                        dataType.getVoutL())));
        protocol.append(NOTHING_DATA);
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("Protocol conversion error!");
        }
        return protocol.toString();
    }

    /**
     * 将AirRecord的十进制指标转为十六进制协议字符串
     *
     * @param airRecord 应传入[imei, source, temperature, humidity, pm25, undefined]
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
        protocol.append(toHexDecimalData(airRecord.getHumidity()));
        protocol.append(toHexIntegerData(airRecord.getPm25()));
        protocol.append(toHexIntegerData(airRecord.getUndefinedData()));
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("Protocol conversion error!");
        }
        return protocol.toString();
    }

    /* --------------------------------------------------------------------- */

    /**
     * FIXME 根据模拟指标生成十六进制协议字符串
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
        protocol.append(toHexSource(VIRTUAL_SOURCE));
        protocol.append(toHexDecimalData(airIndex.getTemperature()));
        protocol.append(toHexDecimalData(airIndex.getHumi()));
        protocol.append(toHexIntegerData(airIndex.getPm25()));
        protocol.append(toHexIntegerData(airIndex.getUndef()));
        protocol.append(CHECK);

        if (protocol.toString().length() != LENGTH) {
            System.out.println("Protocol conversion error!");
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
            System.out.println("Single precision hexadecimal data conversion failed");
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

        return getDoubleHexData(number[0], number[1]);
    }

    /**
     * 带小数部分的数据 整数1Byte + 小数1Byte
     */
    private static String toHexDecimalData(String dataInt, String dataDeci) {
        // 判断数据为空
        if ("".equals(dataInt) || "".equals(dataDeci)) {
            return "0000";
        }

        return getDoubleHexData(dataInt, dataDeci);
    }

    /**
     * 转换为双精度2字节十六进制字符串 整数1Byte + 小数1Byte
     */
    private static String getDoubleHexData(String dataInt, String dataDeci) {
        // 进行数制转换
        try {
            Integer integer = Integer.parseInt(dataInt);

            // 小数部分精确到2位
            if (dataDeci.length() > 2) {
                dataDeci = dataDeci.substring(0, 2);
            }
            Integer decimal = Integer.parseInt(dataDeci);

            String hexInteger = Integer.toHexString(integer);
            String hexDecimal = Integer.toHexString(decimal);

            // 字节填充
            hexInteger = fillData(hexInteger, 2);
            hexDecimal = fillData(hexDecimal, 2);

            return hexInteger + hexDecimal;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Double precision hexadecimal data conversion failed");
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
