package com.wangjiankang.weather.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.wangjiankang.weather.model.City;
import com.wangjiankang.weather.model.County;
import com.wangjiankang.weather.model.Province;
import com.wangjiankang.weather.model.WeatherDB;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wang on 2015/2/4.
 */
public class Utility {
    /*
    handle the information from provinces
     */
    public synchronized static boolean handleProvinceResponse(WeatherDB weatherDB, String response) {
        if(!TextUtils.isEmpty(response)) {

            String[] allProvinces = response.split(",");
            if(allProvinces.length >0) {
                for(String p : allProvinces) {
                    String[] arr = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(arr[0]);
                    province.setProvinceName(arr[1]);
                    weatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /*
    handle the information from cities
     */
    public static boolean handleCitiesResponse(WeatherDB weatherDB, String response, int provinceId) {
        if(!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if(allCities.length >0) {
                for(String c : allCities) {
                    String[] arr = c.split("\\|");
                    City city = new City();
                    city.setCityCode(arr[0]);
                    city.setCityName(arr[1]);
                    city.setProvinceId(provinceId);
                    weatherDB.saveCity(city);
                }
                return true;
            }

        }
        return false;
    }

    /*
    handle the information from counties
     */
    public static boolean handleContiesResponse(WeatherDB weatherDB, String response, int cityId) {
        if(!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if(allCounties.length >0) {
                for(String c : allCounties) {
                    String[] arr = c.split("\\|");
                    County county = new County();
                    county.setCityId(cityId);
                    county.setCountyCode(arr[0]);
                    county.setCountyName(arr[1]);
                    weatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析服务器返回的JSON数据，并将解析出的数据存储到本地。
     */
    public static void handleWeatherResponse(Context context, String response) {
        try {

            JSONObject jsonObject = new JSONObject(response);

			JSONObject c = jsonObject.getJSONObject("c");
			String cityName = c.getString("c3");
			String weatherCode = c.getString("c1");
			JSONObject f = jsonObject.getJSONObject("f");
			String publishTime = f.getString("f0");
            publishTime = publishTime.substring(8,10)+":"+publishTime.substring(10,12);

            JSONArray array = f.getJSONArray("f1");
            JSONObject firstDay = array.getJSONObject(0);

            String temp1 = firstDay.getString("fc");
            String temp2 = firstDay.getString("fd");

            String dayDesp = WeatherDescription.getDescription(firstDay.getInt("fa"));
            String nightDesp = WeatherDescription.getDescription(firstDay.getInt("fb"));
            String weatherDesp;
            if(dayDesp.equals(nightDesp)) {
                weatherDesp = dayDesp;
            } else {
                weatherDesp = dayDesp + "转" + nightDesp;
            }

            saveWeatherInfo(context, cityName, weatherCode, temp1, temp2,
                    weatherDesp, publishTime);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将服务器返回的所有天气信息存储到SharedPreferences文件中。
     */
    public static void saveWeatherInfo(Context context, String cityName,
                                       String weatherCode, String temp1, String temp2, String weatherDesp,
                                       String publishTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日", Locale.CHINA);
        SharedPreferences.Editor editor = PreferenceManager
                .getDefaultSharedPreferences(context).edit();
        editor.putBoolean("city_selected", true);
        editor.putString("city_name", cityName);
        editor.putString("weather_code", weatherCode);
        editor.putString("temp1", temp1);
        editor.putString("temp2", temp2);
        editor.putString("weather_desp", weatherDesp);
        editor.putString("publish_time", publishTime);
        editor.putString("current_date", sdf.format(new Date()));
        editor.commit();
    }
}
