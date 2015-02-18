package com.wangjiankang.weather.model;

/**
 * Created by wang on 2015/2/4.
 */
public class Province {
    private int id;
    private String provinceName;
    private String provinceCode;

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
    get and set for provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /*
   get and set for provinceCode
    */
    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
