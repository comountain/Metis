package com.example.activity.bean;

public class User {
    private int userid = 1;
    private String username;
    private int image_id = 1;
    private int game_score;
    private String nickname;

    public User(int id, int game_score, String username, String nickname)
    {
        this.userid = id;
        this.game_score = game_score;
        this.username = username;
        this.nickname = nickname;
    }

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
