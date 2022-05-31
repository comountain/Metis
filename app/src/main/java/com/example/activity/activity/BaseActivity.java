package com.example.activity.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.example.activity.MyApplication;
import com.example.activity.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity{
    int id;

    @Override
    protected final void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(getLayoutId());
        id = getLayoutId();
        ButterKnife.bind(this);
        getPreIntent();
        initView();
        initData();
        initListener();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if(id != R.layout.activity_wait && id != R.layout.activity_answer)
            {
                android.app.AlertDialog textTips = new AlertDialog.Builder(BaseActivity.this)
                        .setTitle("您要退出游戏吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ((MyApplication) getApplication()).removeUser();
                                ((MyApplication) getApplication()).finish();
                            }
                        })
                        .setNegativeButton("我手滑了", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
            else if(id == R.layout.activity_answer)
            {
                android.app.AlertDialog textTips = new AlertDialog.Builder(BaseActivity.this)
                        .setMessage("游戏过程请勿退出")
                        .show();
            }
            else if(id == R.layout.activity_wait)
            {
                android.app.AlertDialog textTips = new AlertDialog.Builder(BaseActivity.this)
                        .setMessage("请先取消匹配")
                        .show();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }



    abstract int getLayoutId();

    void getPreIntent(){}

    void initView(){}

    void initData(){}

    void initListener(){}
}

