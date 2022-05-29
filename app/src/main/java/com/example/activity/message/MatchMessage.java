package com.example.activity.message;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class MatchMessage {
    private String type = "2";
    private String name;
    private String num;
    private String field;
    private int remove;

    public MatchMessage(String username, String num, String filed, int re)
    {
        this.name = username;
        this.num = num;
        this.field = filed;
        this.remove = re;
    }

    public String MessageString()
    {
        return type+"_"+name+"_"+num+"_"+field+"_"+remove+"";
    }
}
