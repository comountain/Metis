package com.example.activity.activity;


import com.example.activity.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.HashMap;

import butterknife.OnClick;

public class MarketActivity extends BaseActivity {
    HashMap<String, Boolean> buyhelper = new HashMap<>();


    @Override
    int getLayoutId(){return R.layout.activity_market;}

    @OnClick({R.id.market_ret, R.id.market_brave, R.id.market_weak, R.id.market_brave_buy, R.id.market_weak_buy})
    public void onViewClicked(View v)
    {
        TextView show = (TextView)findViewById(R.id.market_show);
        switch (v.getId())
        {
            case R.id.market_ret:
                Intent intent1 = new Intent(MarketActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.market_brave:
                show.setText("骑士之心，能让你赢得比赛后获取更多积分,失败后减少更多积分。谨慎使用。");
                break;
            case R.id.market_weak:
                show.setText("懦夫药水，使用后比赛胜负不再影响积分，专为菜鸟和蠢货设计。也许适合你？");
                break;
            case R.id.market_brave_buy:
                AlertDialog textTips = new AlertDialog.Builder(MarketActivity.this)
                        .setTitle("Tips:")
                        .setMessage("购买后立即生效，持续一小时\n" +
                                "可以在集市取消效果\n" +
                                "切换账号失效")
                        .setPositiveButton("购买", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("我再想想", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.market_weak_buy:
                break;
        }
    }

}