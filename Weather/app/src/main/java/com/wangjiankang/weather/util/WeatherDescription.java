package com.wangjiankang.weather.util;

/**
 * Created by wang on 2015/2/18.
 */
public class WeatherDescription {

    private static String[] description = { "晴", "多云", "阴", "阵雨", "雷阵雨",
            "雷阵雨伴有冰雹", "雨夹雪", "小雨", "中雨", "大雨", "暴雨",
            "大暴雨", "特大暴雨", "阵雪", "小雪", "中雪", "大雪", "暴雪",
            "雾", "冻雨", "沙尘暴", "小到中雨", "大到中雨", "暴雨到大暴雨",
            "大暴雨到特大暴雨", "小到中雪", "中到中雪", "大到暴雪", "沙尘",
            "扬尘", "强沙尘暴",
    };
    public static String getDescription(int id) {
        if(id==53) return "霾";
        if(id==99) return "无";
        return description[id];


    }
}
