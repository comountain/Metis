package com.example.activity.bean;

import java.util.Date;
import java.util.HashMap;


public class User {
    private int userid ;
    private String username;
    private int image_id ;
    private int game_score;
    private String nickname;
    private HashMap<String, Date> tools;

    public User(int id, int game_score,int image_id, String username, String nickname)
    {
        this.userid = id;
        this.image_id = image_id;
        this.game_score = game_score;
        this.username = username;
        this.nickname = nickname;
    }

    public int getId()
    {
        return userid;
    }

    public Boolean if_have_tool(String s){return tools.containsKey(s);}

    public void remove_tool(String s){tools.remove(s);}

    public void add_tool(String s){tools.put(s,new Date());}

    public int getGame_score() {
        return game_score;
    }

    public int getImage_id() {
        return image_id;
    }

    public int getUserid() {
        return userid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setGame_score(int game_score) {
        this.game_score = game_score;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
