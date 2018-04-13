package com.talkingdata.analytics.wifi.collector.databean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by loong on 4/22/16.
 */
public class WifiTa implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String rssi;
    private String mac;
    private String mactype;
    private List<TaEvent> taevent;
    private String dist;
    private String duringstart;
    private String duringend;
    private String packetnumup;
    private String packetnumdown;
    private String volumeup;
    private String volumedown;
    private String authidtype;
    private String authid;
    private String tatype;
    private String tabrand;
    private String tasystem;
    private String applicationlist;
    private String urllist;
    private String dns;

    public WifiTa() {
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public List<TaEvent> getTaevent() {
        return taevent;
    }

    public void setTaevent(List<TaEvent> taevent) {
        this.taevent = taevent;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getDuringstart() {
        return duringstart;
    }

    public void setDuringstart(String duringstart) {
        this.duringstart = duringstart;
    }

    public String getDuringend() {
        return duringend;
    }

    public void setDuringend(String duringend) {
        this.duringend = duringend;
    }

    public String getPacketnumup() {
        return packetnumup;
    }

    public void setPacketnumup(String packetnumup) {
        this.packetnumup = packetnumup;
    }

    public String getPacketnumdown() {
        return packetnumdown;
    }

    public void setPacketnumdown(String packetnumdown) {
        this.packetnumdown = packetnumdown;
    }

    public String getVolumeup() {
        return volumeup;
    }

    public void setVolumeup(String volumeup) {
        this.volumeup = volumeup;
    }

    public String getVolumedown() {
        return volumedown;
    }

    public void setVolumedown(String volumedown) {
        this.volumedown = volumedown;
    }

    public String getAuthidtype() {
        return authidtype;
    }

    public void setAuthidtype(String authidtype) {
        this.authidtype = authidtype;
    }

    public String getAuthid() {
        return authid;
    }

    public void setAuthid(String authid) {
        this.authid = authid;
    }

    public String getTatype() {
        return tatype;
    }

    public void setTatype(String tatype) {
        this.tatype = tatype;
    }

    public String getTabrand() {
        return tabrand;
    }

    public void setTabrand(String tabrand) {
        this.tabrand = tabrand;
    }

    public String getTasystem() {
        return tasystem;
    }

    public void setTasystem(String tasystem) {
        this.tasystem = tasystem;
    }

    public String getApplicationlist() {
        return applicationlist;
    }

    public void setApplicationlist(String applicationlist) {
        this.applicationlist = applicationlist;
    }

    public String getUrllist() {
        return urllist;
    }

    public void setUrllist(String urllist) {
        this.urllist = urllist;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getMactype() {
        return mactype;
    }

    public void setMactype(String mactype) {
        this.mactype = mactype;
    }

    @Override
    public String toString() {
        return "WifiTa{" +
                "rssi='" + rssi + '\'' +
                ", mac='" + mac + '\'' +
                ", mactype='" + mactype + '\'' +
                ", taevent=" + taevent +
                ", dist=" + dist +
                ", duringstart=" + duringstart +
                ", duringend=" + duringend +
                ", packetnumup=" + packetnumup +
                ", packetnumdown=" + packetnumdown +
                ", volumeup=" + volumeup +
                ", volumedown=" + volumedown +
                ", authidtype=" + authidtype +
                ", authid='" + authid + '\'' +
                ", tatype='" + tatype + '\'' +
                ", tabrand='" + tabrand + '\'' +
                ", tasystem='" + tasystem + '\'' +
                ", applicationlist='" + applicationlist + '\'' +
                ", urllist='" + urllist + '\'' +
                ", dns='" + dns + '\'' +
                '}';
    }
}
