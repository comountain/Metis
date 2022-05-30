package com.example.activity.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.activity.MyApplication;
import com.example.activity.R;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import butterknife.OnClick;

public class GradeActivity extends BaseActivity {
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
            if(!((MyApplication)getApplication()).getUsername().equals(champion))
            {
                championToShow.setText("可惜，再加油吧..");
            }
            else
                championToShow.setText("恭喜！你击败了所有人！");
            TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
            gradeToShow.setText(show);
        }
        else
        {
            TextView gradeToShow = (TextView) findViewById(R.id.grade_grade);
            gradeToShow.setText(grade + "分\n");
        }
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