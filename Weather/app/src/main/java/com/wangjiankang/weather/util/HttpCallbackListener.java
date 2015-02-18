package com.wangjiankang.weather.util;

/**
 * Created by wang on 2015/2/4.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
