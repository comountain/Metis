package com.example.activity;

import android.app.Application;

import com.example.activity.message.AnswerMessage;
import com.example.activity.message.CompeteMessage;
import com.example.activity.message.MatchMessage;
import com.example.activity.service.CientService;
import com.example.activity.message.GamerMessage;
import com.example.activity.bean.User;
import java.util.HashMap;

public class MyApplication extends Application {
    public User user = new User(5,2,"0001","Co");
    public String playtype;
    CientService cientService = new CientService();
    @Override
    public void onCreate()
    {
        super.onCreate();
        cientService.setUser(user.getNickname());
        cientService.start();
        sendMessage(new GamerMessage(user.getNickname()));
    }

    public void setPlaytype(String ty)
    {
        playtype = ty;
    }

    public String getPlaytype()
    {
        return playtype;
    }

    public String getUsername()
    {
        return user.getNickname();
    }

    public String[] getPlayername(){return cientService.getPlayername();}

    public int getSubNow(){return cientService.getSubnow();}

    public void restSubNow(){cientService.resetSubnow();}

    public void resetClient()
    {
        cientService.resetGameresult();
        cientService.resetPlayername();
        cientService.resetIfMatched();
    }

    public void setScore(String score)
    {
        cientService.setScore(score);
    }

    public void sendMessage(GamerMessage msg)
    {
        cientService.sendMessage(msg);
    }

    public void sendMessage(MatchMessage msg)
    {
        cientService.sendMessage(msg);
    }

    public void sendMessage(CompeteMessage msg)
    {
        cientService.sendMessage(msg);
    }

    public void sendMessage(AnswerMessage msg){cientService.sendMessage(msg);}

    public boolean ifMatched()
    {
        return cientService.isIfMatched();
    }

    public HashMap<String, String> getGameresult()
    {
        return cientService.getGameresult();
    }

}
