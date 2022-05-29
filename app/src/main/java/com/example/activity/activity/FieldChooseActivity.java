package com.example.activity.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.activity.MyApplication;
import com.example.activity.R;
import com.example.activity.activity.BaseActivity;
import com.example.activity.message.GamerMessage;
import com.example.activity.message.MatchMessage;
import com.example.activity.service.CientService;

import butterknife.OnClick;

public class FieldChooseActivity extends BaseActivity {
    private String matchNum;
    private String num;

    @Override
    int getLayoutId()
    {
        return R.layout.activity_field_choose;
    }

    @Override
    void getPreIntent()
    {
        matchNum = ((MyApplication)getApplication()).getPlaytype();
        num = getIntent().getExtras().get("num").toString().trim();
    }


    @OnClick({R.id.field_1,R.id.field_2,R.id.field_3,R.id.field_4,R.id.field_5,R.id.field_6,R.id.field_7,R.id.ret})
    public void onViewClicked(View view)
    {
        switch(view.getId())
        {
            case R.id.field_1:
                Intent intent1 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent12 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent1.putExtra("field","Literature");
                intent1.putExtra("num", num);
                intent12.putExtra("field","Literature");
                if(matchNum.equals("match"))
                    startActivity(intent1);
                else
                    startActivity(intent12);
                break;
            case R.id.field_2:
                Intent intent2 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent22 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent2.putExtra("field","History");
                intent2.putExtra("num", num);
                intent22.putExtra("field","History");
                if(matchNum.equals("match"))
                    startActivity(intent2);
                else
                    startActivity(intent22);
                break;
            case R.id.field_3:
                Intent intent3 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent32 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent3.putExtra("field","Films");
                intent3.putExtra("num", num);
                intent32.putExtra("field","Films");
                if(matchNum.equals("match"))
                    startActivity(intent3);
                else
                    startActivity(intent32);
                break;
            case R.id.field_4:
                Intent intent4 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent42 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent4.putExtra("field","Art");
                intent4.putExtra("num", num);
                intent42.putExtra("field","Art");
                if(matchNum.equals("match"))
                    startActivity(intent4);
                else
                    startActivity(intent42);
                break;
            case R.id.field_5:
                Intent intent5 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent52 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent5.putExtra("field","Geography");
                intent5.putExtra("num", num);
                intent52.putExtra("field","Geography");
                if(matchNum.equals("match"))
                    startActivity(intent5);
                else
                    startActivity(intent52);
                break;
            case R.id.field_6:
                Intent intent6 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent62 = new Intent(FieldChooseActivity.this,AnswerActivity.class);
                intent6.putExtra("field","Science");
                intent6.putExtra("num", num);
                intent62.putExtra("field","Science");
                if(matchNum.equals("match"))
                    startActivity(intent6);
                else
                    startActivity(intent62);
                break;
            case R.id.field_7:
                Intent intent7 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                Intent intent72 = new Intent(FieldChooseActivity.this,WaitActivity.class);
                intent7.putExtra("field","All");
                intent7.putExtra("num", num);
                intent72.putExtra("field","All");
                if(matchNum.equals("match"))
                    startActivity(intent7);
                else
                    startActivity(intent72);
                break;
            case R.id.ret:
                this.finish();
                break;
        }
    }
}