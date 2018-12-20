package com.ten.air.protocol.gp2y;

/**
 * GP2Y :Pm25
 */
public class GP2YDataType {
    /**
     * 发送设备号IMEI
     */
    private String imei;

    private String start;

    private String voutH;
    private String voutL;
    private String vrefH;
    private String vrefL;

    private String check;
    private String finish;

    @Override
    public String toString() {
        return "GP2YDataType{" +
                "imei='" + imei + '\'' +
                ", start='" + start + '\'' +
                ", voutH='" + voutH + '\'' +
                ", voutL='" + voutL + '\'' +
                ", vrefH='" + vrefH + '\'' +
                ", vrefL='" + vrefL + '\'' +
                ", check='" + check + '\'' +
                ", finish='" + finish + '\'' +
                '}';
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getVoutH() {
        return voutH;
    }

    public void setVoutH(String voutH) {
        this.voutH = voutH;
    }

    public String getVoutL() {
        return voutL;
    }

    public void setVoutL(String voutL) {
        this.voutL = voutL;
    }

    public String getVrefH() {
        return vrefH;
    }

    public void setVrefH(String vrefH) {
        this.vrefH = vrefH;
    }

    public String getVrefL() {
        return vrefL;
    }

    public void setVrefL(String vrefL) {
        this.vrefL = vrefL;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
}
