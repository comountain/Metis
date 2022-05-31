package com.example.activity.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activity.MyApplication;
import com.example.activity.R;
import com.example.activity.constants.config;
import com.example.activity.utils.LogUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class InfoActivity extends BaseActivity {
    String Infouser;
    String Infonick;
    String Infoscore;
    String username;
    @Override
    int getLayoutId() {
        return R.layout.activity_info;
    }

    @Override
    void getPreIntent() {
        username=((MyApplication)getApplication()).getNickname();
        Infouser="账号: "+((MyApplication)getApplication()).getAccount();
        Infonick=((MyApplication)getApplication()).getNickname();
        Infoscore="积分: "+((MyApplication)getApplication()).getGame_score();
    }

    @Override
    void initView() {
        TextView usertv=(TextView)findViewById(R.id.info_username);
        EditText nicktv=(EditText) findViewById(R.id.info_nick);
        TextView scoretv=(TextView)findViewById(R.id.info_gamescore);
        usertv.setText(Infouser);
        nicktv.setText(Infonick);
        scoretv.setText(Infoscore);
    }

    public void back(View view){
        Intent intent = new Intent(InfoActivity.this, MyActivity.class);
        startActivity(intent);
    }
    public void modify(View view){
        EditText newnick=(EditText) findViewById(R.id.info_nick);
        String newnickname=newnick.getText().toString();
        LogUtils.e("initNet: 开始联网…………");
        final ProgressDialog progressDialog = new ProgressDialog(InfoActivity.this, R.style.btnStyle);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("验证中...");
        progressDialog.show();
        Button btn = (Button) findViewById(R.id._btn_message);
        String url = config.HOST;
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("nickname", newnickname);
        client.get(config.URL_UPDATE_INFO, params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        super.onSuccess(statusCode, headers, responseString);
                        if(responseString.equals("succeed")) {
                            LogUtils.e("initNet: 联网结束…………");
                            Intent intent = new Intent(InfoActivity.this, MyActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                        if(responseString.equals("Succeed")) {
                            LogUtils.e("initNet: 联网结束…………");
                            showDialog("成功！");
                            //登录成功后跳转到首页
                            // Intent intent = new Intent(InfoActivity.this, InfoActivity.class);
                            ((MyApplication)getApplication()).setNickname(newnickname);
                            //传递登录成功的用户名
                            //startActivity(intent);
                        }
                        Toast.makeText(InfoActivity.this, responseString, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        progressDialog.dismiss();
    }
    public void showDialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(InfoActivity.this);
        builder.setTitle("提示");
        builder.setMessage(msg);//提示信息
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setCancelable(false);
        builder.show();
    }
}
