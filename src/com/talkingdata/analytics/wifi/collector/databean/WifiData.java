package com.talkingdata.analytics.wifi.collector.databean;

import java.io.Serializable;
import java.util.List;


/**
 * Created by loong on 4/22/16.
 */
public class WifiData implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String apmac;				//设备的mac
    private int num;					//包含的条数
    private long tssend; 				//设备发送数据的时间
    private List<WifiTa> wifitalist;
    
    //-----------新版本添加
    private String typeid; //这个字段可以知道  是哪个硬件厂商发送过来的数据 
    private int count;  //和 num 是一样的。
    private Location location;
    //------------------

    public String getApmac() {
        return apmac;
    }

    public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public int getCount() {
		return num;
	}

	public void setCount(int count) {
		this.num = count;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setApmac(String apmac) {
        this.apmac = apmac;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public long getTssend() {
        return tssend;
    }

    public void setTssend(long tssend) {
        this.tssend = tssend;
    }

    public List<WifiTa> getWifitalist() {
        return wifitalist;
    }

    public void setWifitalist(List<WifiTa> wifitalist) {
        this.wifitalist = wifitalist;
    }

    @Override
    public String toString() {
        return "WifiData{" +
        		"apmac='" + apmac + '\'' +
                ", num=" + num +
                ", typeid="+ typeid+
                ", count="+ count +
                ", tssend=" + tssend +
                ", wifitalist=" + wifitalist +
                ", location=" + location +
                '}';
    }
}
