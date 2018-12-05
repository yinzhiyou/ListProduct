package com.example.yinzhiyou20181204.denglu;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yinzhiyou20181204.denglu.activity.ShowActivity;
import com.example.yinzhiyou20181204.denglu.bean.LoginBean;
import com.example.yinzhiyou20181204.denglu.presenter.IPresenterImpl;
import com.example.yinzhiyou20181204.denglu.utils.HttpUtils;
import com.example.yinzhiyou20181204.denglu.view.IView;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {

    private IPresenterImpl iPresenter;
    private EditText phone;
    private EditText pwd;
    private String phone1;
    private String pwd1;
    private String urll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iPresenter = new IPresenterImpl(this);
        initView();
    }


    private void initView() {
        phone = findViewById(R.id.phone);
        pwd = findViewById(R.id.pwd);
        Button send_Btn=findViewById(R.id.commit);


        send_Btn.setOnClickListener(this);
    }

    @Override
    public void showResponseData(Object data) {
        LoginBean bean= (LoginBean) data;
        if (bean.getCode() == 100) {
            Log.i("TAG",bean.getMsg()+"yyyyyyyyyyyyyyyy");
            Toast.makeText(MainActivity.this, "请求成功", Toast.LENGTH_SHORT).show();
             startActivity(new Intent(MainActivity.this,ShowActivity.class));
        } else if (bean.getCode() == 101) {
            Toast.makeText(MainActivity.this, "用户名为空", Toast.LENGTH_SHORT).show();
        } else if (bean.getCode() == 102) {
            Toast.makeText(MainActivity.this, "密码为空", Toast.LENGTH_SHORT).show();
        } else if (bean.getCode() == 103) {
            Toast.makeText(MainActivity.this, "用户名/密码错误", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (iPresenter!=null){
            iPresenter.onDetach();
        }
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.commit:
         //  checkPermission();
            phone1 = phone.getText().toString();
            pwd1 = pwd.getText().toString();
            if (phone1.isEmpty()|| pwd1.isEmpty()){
                Toast.makeText(MainActivity.this,"不能为空",Toast.LENGTH_LONG).show();
            }else{
                startRequest();
            }

    }
    }

    /*private void checkPermission() {
        if (Build.VERSION.PREVIEW_SDK_INT>=Build.VERSION_CODES.M){
            if (ContextCompat.checkSelfPermission(this,Manifest.permission.INTERNET)!=PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},100);
            }else {
            startRequest();
            }
        }else {
            startRequest();
        }
    }*/

  /*  @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
            startRequest();
        }
    }*/

    public void startRequest(){
        urll="http://www.xieast.com/api/user/login.php?username="+phone1+"&password="+pwd1;
        Log.i("TAG","yyyyyyyy3456yyyyyyyy");
        iPresenter.startRequest(urll,null);
    }


}
