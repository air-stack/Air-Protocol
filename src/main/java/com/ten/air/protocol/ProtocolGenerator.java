package com.ten.air.protocol;

/**
 * Protocol 生成器
 */
public class ProtocolGenerator {

    /**
     * 生成模拟数据
     */
    public static String genMockProtocol(String imei) {
        return ProtocolEncode.genHexProtocol(imei, AirIndex.getNewAir());
    }

    /* --------------------------------------------------------------------- */

    /**
     * 大气质量指标
     */
    static class AirIndex {

        private String temperature;
        private String pm25;
        private String co2;
        private String so2;

        /**
         * 基础数据 :随机数据在BASE上下波动
         */
        private static final Integer BASE_TEMPERATURE = 25;
        private static final Integer BASE_PM25 = 75;
        private static final Integer BASE_CO2 = 350;
        private static final Integer BASE_SO2 = 350;

        /**
         * 获取一个新的空气指标记录，将随机生成相关参数
         */
        static AirIndex getNewAir() {
            AirIndex airIndex = new AirIndex();

            String temperature = String.valueOf(Math.random() > 0.5f ? BASE_TEMPERATURE + Math.random() * 10 : BASE_TEMPERATURE - Math.random() * 10) + "℃";
            String pm25 = String.valueOf(Math.random() > 0.5f ? BASE_PM25 + Math.random() * 50 : BASE_PM25 - Math.random() * 50);
            String co2 = String.valueOf(Math.random() > 0.5f ? BASE_CO2 + Math.random() * 100 : BASE_CO2 - Math.random() * 100) + "ppm";
            String so2 = String.valueOf(Math.random() > 0.5f ? BASE_SO2 + Math.random() * 100 : BASE_SO2 - Math.random() * 100) + "ppm";

            airIndex.setTemperature(temperature);
            airIndex.setPm25(pm25);
            airIndex.setCo2(co2);
            airIndex.setSo2(so2);

            return airIndex;
        }

        private AirIndex() {
        }

        @Override
        public String toString() {
            return "AirIndex{" +
                    "temperature='" + temperature + '\'' +
                    ", pm25='" + pm25 + '\'' +
                    ", co2='" + co2 + '\'' +
                    ", so2='" + so2 + '\'' +
                    '}';
        }

        String getPm25() {
            return pm25;
        }

        void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        String getSo2() {
            return so2;
        }

        void setSo2(String so2) {
            this.so2 = so2;
        }

        String getTemperature() {
            return temperature;
        }

        void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        String getCo2() {
            return co2;
        }

        void setCo2(String co2) {
            this.co2 = co2;
        }
    }

}
