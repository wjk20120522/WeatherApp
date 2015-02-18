package com.wangjiankang.weather.model;

/**
 * Created by wang on 2015/2/4.
 */
public class City {
    private int id;
    private String cityName;
    private String cityCode;
    private int provinceId;

    /*
    get and set for id
     */
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /*
    get and set for cityName
     */
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /*
    get and set for cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /*
    get and set for provinceId
     */
    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
