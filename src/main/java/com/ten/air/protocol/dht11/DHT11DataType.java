package com.ten.air.protocol.dht11;

/**
 * DHT11 :Temperature and Humidity
 */
public class DHT11DataType {
    /**
     * 发送设备号IMEI
     */
    private String imei;

    /**
     * 温度整数
     */
    private String tempInt;
    /**
     * 温度小数
     */
    private String tempDeci;

    /**
     * 湿度整数
     */
    private String humiInt;
    /**
     * 湿度小数
     */
    private String humiDeci;

    @Override
    public String toString() {
        return "DHT11DataType{" +
                "imei='" + imei + '\'' +
                ", tempInt='" + tempInt + '\'' +
                ", tempDeci='" + tempDeci + '\'' +
                ", humiInt='" + humiInt + '\'' +
                ", humiDeci='" + humiDeci + '\'' +
                '}';
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTempInt() {
        return tempInt;
    }

    public void setTempInt(String tempInt) {
        this.tempInt = tempInt;
    }

    public String getTempDeci() {
        return tempDeci;
    }

    public void setTempDeci(String tempDeci) {
        this.tempDeci = tempDeci;
    }

    public String getHumiInt() {
        return humiInt;
    }

    public void setHumiInt(String humiInt) {
        this.humiInt = humiInt;
    }

    public String getHumiDeci() {
        return humiDeci;
    }

    public void setHumiDeci(String humiDeci) {
        this.humiDeci = humiDeci;
    }
}
