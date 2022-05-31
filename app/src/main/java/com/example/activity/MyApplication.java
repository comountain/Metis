package com.example.activity;

import android.app.Application;

import com.example.activity.bean.QuestBean;
import com.example.activity.message.AnswerMessage;
import com.example.activity.message.CompeteMessage;
import com.example.activity.message.LeaveMessage;
import com.example.activity.message.LogMessage;
import com.example.activity.message.MatchMessage;
import com.example.activity.service.CientService;
import com.example.activity.message.GamerMessage;
import com.example.activity.bean.User;
import java.util.HashMap;
import java.util.List;

public class MyApplication extends Application {
    public User user = null;
    public String username;
    public String nickname;
    public String game_score;
    public String playtype;
    CientService cientService = new CientService();
    @Override
    public void onCreate()
    {
        super.onCreate();
    }

    public void createUser(int id, int image_id, int gamescore, String username, String nickname)
    {
        boolean havein = false;
        if(user != null)
            havein = true;
        user = new User(id,image_id, gamescore,username,nickname);
        cientService.setUser(user.getNickname());
        if(!havein)
            cientService.start();
        cientService.sendMessage(new LogMessage(id,nickname));
    }

    public void finish(){this.finish();}

    public void removeUser()
    {
        cientService.senMessage(new LeaveMessage(user.getId()));
    }

    public void setNickname(String nick) {
        nickname = nick;
    }


    public void setUsername(String us) {
        username = us;
    }

    public String getAccount()
    {
        return username;
    }

    public void setGame_score(String score) {
        game_score = score;
    }

    public String getGame_score() {
        return game_score;
    }

    public void removeTool(String s){user.remove_tool(s);}

    public void addTool(String s){user.add_tool(s);}

    public void setPlaytype(String ty)
    {
        playtype = ty;
    }

    public boolean ifTool(String s){return user.if_have_tool(s);}

    public int getWrapperOrder(){return cientService.wrapper_order;}

    public String getPlaytype()
    {
        return playtype;
    }

    public String getNickname()
    {
        return user.getNickname();
    }

    public String[] getPlayername(){return cientService.getPlayername();}

    public List<String> getWrong(){return cientService.getWrong_quest();}

    public int getSubNow(){return cientService.getSubnow();}

    public void addWrong(String q){cientService.addWrong(q);}

    public void resetWrong(){cientService.resetWrong();}

    public void restSubNow(){cientService.resetSubnow();}

    public void resetClient()
    {
        cientService.resetGameresult();
        cientService.resetPlayername();
        cientService.resetIfMatched();
    }

    public void resetWrapperOrder()
    {
        cientService.wrapper_order = -1;
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
