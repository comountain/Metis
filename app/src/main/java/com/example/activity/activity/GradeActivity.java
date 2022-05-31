package com.example.activity.activity;

import com.example.activity.MyApplication;
import com.example.activity.R;
import com.example.activity.constants.config;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class GradeActivity extends BaseActivity {
    int change = 0;
    String grade;
    String playertype;
    boolean ret = false;

    @Override
    int getLayoutId()
    {
        return R.layout.activity_grade;
    }

    @Override
    void getPreIntent()
    {
        playertype = ((MyApplication)getApplication()).getPlaytype();
        grade = getIntent().getExtras().get("grade").toString().trim();
    }

    @Override
    void initView()
    {
        if(playertype.equals("match"))
        {
            HashMap<String, String> result = ((MyApplication) getApplication()).getGameresult();
            int num = result.size();
            int[] score_order = new int[num];
            String show = "";
            int i = 0;
            for (Map.Entry<String, String> entry : result.entrySet())
            {
                score_order[i++] = Integer.parseInt(entry.getValue());
            }
            Arrays.sort(score_order);
            int order_now = 1;
            String champion="";
            List<String> if_add = new ArrayList<>();
            for(i = num - 1; i >= 0; i--)
            {
                for (Map.Entry<String, String> entry : result.entrySet())
                {
                    if(entry.getValue().equals(score_order[i]+"") && !if_add.contains(entry.getKey()))
                    {
                        if(order_now == 1)
                            champion = entry.getKey();
                        show += "第" + order_now +"名： " + entry.getKey() + " "+ entry.getValue() +"分\n";
                        order_now ++;
                        if_add.add(entry.getKey());
                        break;
                    }
                }
            }
            TextView championToShow = (TextView) findViewById(R.id.grade_title);
            if(!((MyApplication)getApplication()).getNickname().equals(champion))
            {
                change = -5;
                championToShow.setText("可惜，再加油吧.. 积分"+change);
            }
            else {
                change = 10;
                championToShow.setText("恭喜！你击败了所有人！积分 +"+change);
            }
            TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
            gradeToShow.setText(show);
        }
        else
        {
            if(Integer.parseInt(grade) > 130)
                change = 5;
            TextView titleToShow = (TextView) findViewById(R.id.grade_title);
            String title = "本次练习得分： " + grade;
            if(change == 5)
                title = title + "积分 +5";
            titleToShow.setText(title);
            TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
            gradeToShow.setTextSize(12);
            String wrong_all = "";
                for(int i = 0; i < ((MyApplication)getApplication()).getWrong().size(); i++)
                {
                    String q = ((MyApplication)getApplication()).getWrong().get(i);
                    wrong_all = wrong_all + q + "\n";

                }
            ((MyApplication)getApplication()).resetWrong();
                gradeToShow.setText(wrong_all);
        }
        if(Integer.parseInt(((MyApplication)getApplication()).getGame_score()) + change < 0)
            ((MyApplication)getApplication()).setGame_score("0");
        else
            ((MyApplication)getApplication()).setGame_score(Integer.parseInt(((MyApplication)getApplication()).getGame_score()) + change+"");
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("username",((MyApplication)getApplication()).getAccount());
        params.put("change",change);
        client.get(config.URL_UPDATE_SCORE,params, new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        super.onFailure(statusCode, headers, responseString, throwable);
                    }
                }
        );
    }

    @OnClick({R.id.grade_return})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.grade_return:
                ret = true;
                ((MyApplication)getApplication()).resetClient();
                Intent intent1 = new Intent(GradeActivity.this,MainActivity.class);
                startActivity(intent1);
                break;
        }
    }
}