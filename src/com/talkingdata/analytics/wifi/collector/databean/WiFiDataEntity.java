package com.talkingdata.analytics.wifi.collector.databean;

import java.io.Serializable;

/**
 * wifi数据格式实体类,字段含义详见文档说明
 * Created by loong on 4/15/16.
 * 我加了注释。by enan
 */
public class WiFiDataEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String version; //版本号
    private String devtype;	//探针或者路由器
    private String keytype; //加密类型
    private long tsreceive;  //  我们Collector接收到数据的时间戳，数据收到之后添加的
    private WifiData wifidata;


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDevtype() {
        return devtype;
    }

    public void setDevtype(String devtype) {
        this.devtype = devtype;
    }

    public String getKeytype() {
        return keytype;
    }

    public void setKeytype(String keytype) {
        this.keytype = keytype;
    }

    public WifiData getWifidata() {
        return wifidata;
    }

    public void setWifidata(WifiData wifidata) {
        this.wifidata = wifidata;
    }

    public long getTsreceive() {
        return tsreceive;
    }

    public void setTsreceive(long tsreceive) {
        this.tsreceive = tsreceive;
    }

    @Override
    public String toString() {
        return "WiFiDataEntity{" +
                "version='" + version + '\'' +
                ", devtype='" + devtype + '\'' +
                ", keytype='" + keytype + '\'' +
                ", tsreceive=" + tsreceive +
                ", wifidata=" + wifidata +
                '}';
    }
}

