package com.example.yinzhiyou20181204.denglu.presenter;

import android.util.Log;

import com.example.yinzhiyou20181204.denglu.callcack.MyCallBaCk;
import com.example.yinzhiyou20181204.denglu.model.IModel;
import com.example.yinzhiyou20181204.denglu.model.IModelImpl;
import com.example.yinzhiyou20181204.denglu.view.IView;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private IModelImpl model;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        model=new IModelImpl();
    }

    @Override
    public void startRequest(String url, String params) {
    model.requestData(url, params, new MyCallBaCk() {
        @Override
        public void setData(Object data) {
            Log.i("TAG","yyyyyyyyyyyyyyyy");
            iView.showResponseData(data);
        }
    });
    }
    public void onDetach(){
        if (model!=null){
            model=null;
        }
        if (iView!=null){
            iView=null;
        }
    }
}
