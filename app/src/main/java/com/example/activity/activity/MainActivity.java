package com.example.activity.activity;

import android.view.View;

import android.content.Intent;

import com.example.activity.R;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Override
    int getLayoutId()
    {
        return R.layout.activity_main;
    }

    @OnClick({R.id.btn_start_answer, R.id.main_to_main, R.id.main_to_home, R.id.main_to_mine, R.id.main_to_mess})
    public void onViewClicked(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_start_answer:
                Intent intent1 = new Intent(MainActivity.this, NumActivity.class);
                startActivity(intent1);
                break;
            case R.id.main_to_main:
                break;
            case R.id.main_to_home:
                break;
            case R.id.main_to_mine:
                break;
            case R.id.main_to_mess:
                break;
        }
    }
}