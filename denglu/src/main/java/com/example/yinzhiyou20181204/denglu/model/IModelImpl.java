package com.example.yinzhiyou20181204.denglu.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.yinzhiyou20181204.denglu.bean.LoginBean;
import com.example.yinzhiyou20181204.denglu.callcack.MyCallBaCk;
import com.example.yinzhiyou20181204.denglu.utils.HttpUtils;
import com.google.gson.Gson;

public class IModelImpl implements IModel {
    private MyCallBaCk callBaCk;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:

                    LoginBean loginBean= (LoginBean) msg.obj;

                    if (callBaCk!=null){

                        callBaCk.setData(loginBean);
                    }
                    break;
                case 1:
                    break;
                    default:
                        break;
            }
        }
    };

    @Override
    public void requestData(final String url, String params, MyCallBaCk CallBaCk) {
        this.callBaCk=CallBaCk;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String jsonStr = HttpUtils.get(url);

                    Gson gson=new Gson();
                    LoginBean loginBean = gson.fromJson(jsonStr, LoginBean.class);
                    handler.sendMessage(handler.obtainMessage(0,loginBean));
                } catch (Exception e) {

                    e.printStackTrace();
                    handler.sendMessage(handler.obtainMessage(0,"错误"));
                }
            }
        }).start();
    }
}
