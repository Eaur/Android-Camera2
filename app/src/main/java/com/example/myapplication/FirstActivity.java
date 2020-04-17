package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {
    public static final int PERMISSION_REQ_ID = 21;
    //请求权限的集合
    public static final String[] REQUEST_PERMISSION = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};
    @BindView(R.id.takePicture)
    Button takePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);
        //申请动态权限
        if (checkSelfPermission(REQUEST_PERMISSION[0], PERMISSION_REQ_ID) &&
                checkSelfPermission(REQUEST_PERMISSION[1], PERMISSION_REQ_ID) &&
                checkSelfPermission(REQUEST_PERMISSION[2], PERMISSION_REQ_ID)) {
        }

        takePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this,MainActivity.class));
            }
        });
    }



    private boolean checkSelfPermission(String permission, int request_code) {
        //判断是否有权限
        if (ContextCompat.checkSelfPermission(FirstActivity.this, permission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(FirstActivity.this, REQUEST_PERMISSION, request_code);
        }
        return true;
    }
}
