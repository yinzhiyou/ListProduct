package com.example.yinzhiyou20181204.denglu.model;

import com.example.yinzhiyou20181204.denglu.callcack.MyCallBaCk;

public interface IModel {
void requestData(String url, String params, MyCallBaCk CallBaCk);
}
