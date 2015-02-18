package com.wangjiankang.weather.model;

/**
 * Created by wang on 2015/2/4.
 */
public class County {
    private int id;
    private String countyName;
    private String countyCode;
    private int cityId;

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
    get and set for countyName
     */
    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /*
    get and set for countyCode
     */
    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    /*
    get and set for cityId
     */
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

}
