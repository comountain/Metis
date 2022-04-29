package com.example.activity.fragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.example.activity.R;

import com.example.activity.bean.QuestBean;
import com.example.activity.utils.LogUtils;

import butterknife.OnClick;

public class AnswerFragment extends BaseFragment {
    private Button chooseA;
    private Button chooseB;
    private Button chooseC;
    private Button chooseD;
    private TextView tv_title;
    private String myanswer = "";
    QuestBean questBean = null;

    public AnswerFragment(QuestBean questBean)
    {
        this.questBean = questBean;
    }

    @Override
    protected View initView()
    {
        View view = View.inflate(mActivity, R.layout.fragment_answer, null);
        tv_title = (TextView) view.findViewById(R.id.quest);
        chooseA = (Button) view.findViewById(R.id.chooseA);
        chooseB = (Button) view.findViewById(R.id.chooseB);
        chooseC = (Button) view.findViewById(R.id.chooseC);
        chooseD = (Button) view.findViewById(R.id.chooseD);
        chooseA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!"multi".equals(questBean.getQ_type()))
                    check(view);
                else
                    checkmore(view);
            }
        });
        chooseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(view);
            }
        });
        chooseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(view);
            }
        });
        chooseD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(view);
            }
        });
        return view;
    }


    public void check(View v)
    {
        switch (v.getId())
        {
            case R.id.chooseA:
                questBean.setMyanswer("A");
                break;
            case R.id.chooseB:
                questBean.setMyanswer("B");
                break;
            case R.id.chooseC:
                questBean.setMyanswer("C");
                break;
            case R.id.chooseD:
                questBean.setMyanswer("D");
                break;
        }
    }

    public void checkmore(View v)
    {
        switch (v.getId())
        {
            case R.id.chooseA:
                if(!myanswer.contains("A"))
                    myanswer = myanswer + "A";
                questBean.setMyanswer(myanswer);
                break;
            case R.id.chooseB:
                if(!myanswer.contains("B"))
                    myanswer = myanswer + "B";
                questBean.setMyanswer(myanswer);
                break;
            case R.id.chooseC:
                if(!myanswer.contains("C"))
                    myanswer = myanswer + "C";
                questBean.setMyanswer(myanswer);
                break;
            case R.id.chooseD:
                if(!myanswer.contains("D"))
                    myanswer = myanswer + "D";
                questBean.setMyanswer(myanswer);
                break;
        }
    }

    @Override
    public void initData()
    {
        tv_title.setText("" + questBean.getTitle());
        if (questBean == null) {
            LogUtils.e( "initData: questBean==null");
            return;
        }

        if ("single".equals(questBean.getQ_type()) || "multi".equals(questBean.getQ_type())) {
            chooseA.setText("" + questBean.getOptionA());
            chooseB.setText("" + questBean.getOptionB());
            chooseC.setText("" + questBean.getOptionC());
            chooseD.setText("" + questBean.getOptionD());
        }

        else if ("judge".equals(questBean.getQ_type())) {
            chooseA.setText("对");
            chooseC.setText("错");
            chooseB.setVisibility(View.GONE);
            chooseD.setVisibility(View.GONE);
        }

    }

}
