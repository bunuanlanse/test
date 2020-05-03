package com.example.demo.entity;
/**
 * [ip实体类]
 *
 * @author :  ws
 * Create at:  2020/4/20 16:32
 * Copyright: 沈阳峰行科技版权所有
 * @version : 1.0
 */

public class IPinfo {
    private long startip;
    private long endip;
    private String province;
    private String city;
    private String lat;
    private String along;
    private int province_code;
    private int city_code;

    public long getStartip() {
        return startip;
    }

    public void setStartip(final long startip) {
        this.startip = startip;
    }

    public long getEndip() {
        return endip;
    }

    public void setEndip(final long endip) {
        this.endip = endip;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(final String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(final String lat) {
        this.lat = lat;
    }

    public String getAlong() {
        return along;
    }

    public void setAlong(final String along) {
        this.along = along;
    }

    public int getProvince_code() {
        return province_code;
    }

    public void setProvince_code(final int province_code) {
        this.province_code = province_code;
    }

    public int getCity_code() {
        return city_code;
    }

    public void setCity_code(final int city_code) {
        this.city_code = city_code;
    }
}


